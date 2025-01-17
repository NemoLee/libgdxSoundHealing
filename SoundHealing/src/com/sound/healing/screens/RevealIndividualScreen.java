package com.sound.healing.screens;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.sound.healing.ScreenManager;
import com.sound.healing.actors.CreateScene;
import com.sound.healing.actors.SceneHandler;
import com.sound.healing.cards.AllCards;
import com.sound.healing.cards.CardEnum;
import com.sound.healing.custom.BackButton;

public class RevealIndividualScreen extends BaseScreen {



	private ClickListener back, flip, save, yes, no;
	private boolean isCardFlip = false;
	int flasher = 5;
	int pick = 0;
	int[] selected = new int[]{0,0,0,0,0,0,0,0,0,0};
	private boolean isFlash = true;
	Preferences prefs = Gdx.app.getPreferences("spread");
	Dialog dialog;
	FreeTypeFontParameter font;
	BitmapFont titleFont;
	private Music cardSound;
	private String[] sounds = new String[]{"051.mp3","052.mp3","053.mp3","054.mp3","055.mp3","056.mp3","057.mp3","058.mp3","059.mp3",};

	
	public RevealIndividualScreen(final CreateScene scene) {
		super(scene);
		// TODO Auto-generated constructor stub
		no = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				stage.getActors().get(stage.getActors().size-1).setVisible(false);
	
					 		
	         }
		};
		yes = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 if(isFlash){
					 	cardSound.stop();
					 	cardSound.dispose();
					 	cardSound = null;
					 }
				  stage.getActors().get(stage.getActors().size-1).setVisible(false);
					SceneHandler.getInstance().setBack(true);
					SceneHandler.getInstance().setPreviousStage(stage);
					ScreenManager.getInstance().show(com.sound.healing.Screen.SPREAD_SELECT);
			 
					 		
	         }
		};
		
		back = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 if(SceneHandler.getInstance().getLoad() == 0){
					 System.out.println("LOAD = "+ SceneHandler.getInstance().getLoad());
				     stage.getActors().get(stage.getActors().size-1).setVisible(false);
					 SceneHandler.getInstance().setBack(true);
					 SceneHandler.getInstance().setPreviousStage(stage);
					 ScreenManager.getInstance().show(com.sound.healing.Screen.LOAD);
				 }
				 else{
					 stage.getActors().get(stage.getActors().size-1).setVisible(true);
				 }		
	         }
		};
		save = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
						 if(isFlash){
							 	//isDone = false;
							 	cardSound.stop();
							 	cardSound.dispose();
							 	cardSound = null;
							 }			
					 		String cardIDs = "";
					 		cardIDs+= (AllCards.getInstance().getIndividualCard()+1)+",";
					 		for(int i = 0; i < 9; i++){
					 			cardIDs += String.valueOf(AllCards.getInstance().getIndividual().get(i).getCardSpec().getCardProperty(CardEnum.ID.getEnumID()))+",";
							}
					 		
							SimpleDateFormat s = new SimpleDateFormat("hh:mm MM/dd/yyyy");
							String format = s.format(new Date());
					 		prefs.putString("spread", prefs.getString("spread", "")+SceneHandler.getInstance().getSpread().toString()+"|,"+cardIDs+"_"+format+"^");
					 		System.out.println(prefs.getString("spread"));
					 		prefs.flush();
					 		SceneHandler.getInstance().setBack(true);
							SceneHandler.getInstance().setPreviousStage(stage);
							ScreenManager.getInstance().show(com.sound.healing.Screen.MAIN_MENU);
							//for(int i = 6; i < scene.getSpec().actors.size(); i++)
							//	scene.getSpec().actors.remove(i);	
						
					 		
	         }
		};
		flip = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 if(isFlash){
					 if(pick <3){
						 if(event.getListenerActor().equals(stage.getActors().get(flasher)) || event.getListenerActor().equals(stage.getActors().get(flasher+2))){
							 	selected[((Integer) event.getListenerActor().getUserObject()-5)/2] = 1;
								stage.getActors().get(flasher).clearActions();
								stage.getActors().get(flasher+2).clearActions();
								flasher+=4;
								pick++;
							 	cardSound.stop();
							 	cardSound.dispose();
							 	cardSound = null;
								AllCards.getInstance().setCurrentCard(Integer.parseInt(event.getListenerActor().getName())); 
								SceneHandler.getInstance().setCurrentSpreadStage(stage);
								isCardFlip = true;
								event.getListenerActor().addAction(Actions.parallel(Actions.fadeOut(0.6f)));
								stage.getActors().get((Integer) event.getListenerActor().getUserObject()-2).addAction(Actions.sequence(Actions.parallel(Actions.fadeIn(0.6f),Actions.visible(true)), new Action(){

									@Override
									public boolean act(float delta) {
										SceneHandler.getInstance().setLoad(3);
										SceneHandler.getInstance().setBack(false);
										SceneHandler.getInstance().setPreviousStage(stage);
										if(pick < 3){
											stage.getActors().get(flasher).addAction(Actions.forever(Actions.sequence(Actions.fadeOut(0.8f),Actions.fadeIn(0.8f))));
											stage.getActors().get(flasher+2).addAction(Actions.forever(Actions.sequence(Actions.fadeOut(0.8f),Actions.fadeIn(0.8f))));
										}
										else{
											stage.getActors().get(flasher).addAction(Actions.forever(Actions.sequence(Actions.fadeOut(0.8f),Actions.fadeIn(0.8f))));
											stage.getActors().get(flasher+2).addAction(Actions.forever(Actions.sequence(Actions.fadeOut(0.8f),Actions.fadeIn(0.8f))));
											stage.getActors().get(flasher+4).addAction(Actions.forever(Actions.sequence(Actions.fadeOut(0.8f),Actions.fadeIn(0.8f))));
											stage.getActors().get(flasher+6).addAction(Actions.forever(Actions.sequence(Actions.fadeOut(0.8f),Actions.fadeIn(0.8f))));
										}
										ScreenManager.getInstance().show(com.sound.healing.Screen.Card);
										return true;
									}
									
								}));
						 }
					 }
					 if(pick == 3){
						 if(event.getListenerActor().equals(stage.getActors().get(flasher)) || event.getListenerActor().equals(stage.getActors().get(flasher+2))|| event.getListenerActor().equals(stage.getActors().get(flasher+4))|| event.getListenerActor().equals(stage.getActors().get(flasher+6))){
							 stage.getActors().get(flasher).clearActions();
							 stage.getActors().get(flasher+2).clearActions();
							 stage.getActors().get(flasher+4).clearActions();
							 stage.getActors().get(flasher+6).clearActions();
							 selected[((Integer) event.getListenerActor().getUserObject()-5)/2] = 1;
							 isFlash = false;
							 
								AllCards.getInstance().setCurrentCard(Integer.parseInt(event.getListenerActor().getName())); 
								SceneHandler.getInstance().setCurrentSpreadStage(stage);
								isCardFlip = true;
								event.getListenerActor().addAction(Actions.parallel(Actions.fadeOut(0.6f)));
								stage.getActors().get((Integer) event.getListenerActor().getUserObject()-2).addAction(Actions.sequence(Actions.parallel(Actions.fadeIn(0.6f),Actions.visible(true)), new Action(){

									@Override
									public boolean act(float delta) {
										SceneHandler.getInstance().setLoad(3);
										SceneHandler.getInstance().setBack(false);
										SceneHandler.getInstance().setPreviousStage(stage);
										ScreenManager.getInstance().show(com.sound.healing.Screen.Card);
										return true;
									}
									
								}));
						}
					 }
	
					 
				 }
				 else{
					 if(selected[((Integer) event.getListenerActor().getUserObject()-5)/2] == 1){
							AllCards.getInstance().setCurrentCard(Integer.parseInt(event.getListenerActor().getName())); 
							SceneHandler.getInstance().setCurrentSpreadStage(stage);
							isCardFlip = true;

							SceneHandler.getInstance().setBack(false);
							SceneHandler.getInstance().setPreviousStage(stage);
							ScreenManager.getInstance().show(com.sound.healing.Screen.Card);
					 } 
					 else{
						 
					 }
					 }
			 }
		};
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.35f, 0, 0.7f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		transitionStage.act();
		stage.act();
		stage.draw();
		transitionStage.draw();



	}


	@Override
	public void show() {

		if(isCardFlip){
			stage.clear();
			transitionStage.clear();
			transitionStage = SceneHandler.getInstance().getPreviousStage();
			stage = scene.getSpec().createStage();
			stage.getActors().get(3).setZIndex(stage.getActors().size-1);
			transitionStage.addAction(Actions.sequence(Actions.moveTo(0, 0), Actions.moveTo(transitionStage.getWidth(), 0, 0.4f)));
	 		stage.addAction(Actions.sequence(Actions.moveTo(-stage.getWidth(),0),Actions.moveTo(0, 0, 0.4f)));
			Gdx.input.setInputProcessor(stage);
			isCardFlip = false;
			if(isFlash){
				cardSound = Gdx.audio.newMusic(Gdx.files.internal("Sound/"+sounds[pick]));
				cardSound.play();
			}
		}
		else{
			isFlash = true;
			flasher = 5;
			pick = 0;
			selected = null;
			selected = new int[]{0,0,0,0,0,0,0,0,0,0};
			stage.clear();
			transitionStage.clear();
			transitionStage = SceneHandler.getInstance().getPreviousStage();
			scene.reset();
			stage = scene.getSpec().createStage();
			for (int i = 0; i < stage.getActors().size; i ++){
				Gdx.app.log(i+"",stage.getActors().get(i).toString());	
			}
			transitionStage.addAction(Actions.sequence(Actions.moveTo(0, 0), Actions.moveTo(-transitionStage.getWidth(), 0, 0.4f)));
	 		stage.addAction(Actions.sequence(Actions.moveTo(stage.getWidth(),0),Actions.moveTo(0, 0, 0.4f)));
	 		Gdx.input.setInputProcessor(stage);
			stage.getActors().get(1).addListener(back);
			if(SceneHandler.getInstance().getLoad() == 0){

			}
			else{
				stage.getActors().get(2).addListener(save);
			}
			stage.getActors().get(3).setZIndex(stage.getActors().size-1);
			for(int i = 5; i < 4+(AllCards.getInstance().getIndividual().size*2); i++){
				stage.getActors().get(i).addListener(flip);
			}
			
			for (int i = 0; i < stage.getActors().size; i ++){
				Gdx.app.log(i+"",stage.getActors().get(i).toString());	
			}
			((Group) stage.getActors().get(stage.getActors().size-1)).getChildren().get(2).addListener(yes);
			((Group) stage.getActors().get(stage.getActors().size-1)).getChildren().get(3).addListener(no);
			stage.getActors().get(flasher).addAction(Actions.forever(Actions.sequence(Actions.fadeOut(0.8f),Actions.fadeIn(0.8f))));
			stage.getActors().get(flasher+2).addAction(Actions.forever(Actions.sequence(Actions.fadeOut(0.8f),Actions.fadeIn(0.8f))));
			cardSound = Gdx.audio.newMusic(Gdx.files.internal("Sound/"+sounds[pick]));
			cardSound.play();
		}
		
	}


	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}
}
