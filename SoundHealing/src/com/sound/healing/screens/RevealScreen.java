package com.sound.healing.screens;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Music.OnCompletionListener;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window.WindowStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.sound.healing.AssetLoader;
import com.sound.healing.ScreenManager;
import com.sound.healing.actors.CreateScene;
import com.sound.healing.actors.SceneHandler;
import com.sound.healing.cards.AllCards;
import com.sound.healing.cards.Card;
import com.sound.healing.cards.CardEnum;

public class RevealScreen extends BaseScreen implements com.badlogic.gdx.Screen {
	private ClickListener back, flip, save, yes, no, help;
	private boolean isCardFlip = false;
	int flasher = 6;
	private Music cardSound;
	private Array<String> sounds;
	private boolean isFlash = true;
	Preferences prefs = Gdx.app.getPreferences("spread");
	Dialog dialog;
	FreeTypeFontParameter font;
	BitmapFont titleFont;
	private int isDone = 0;

	
	public RevealScreen(final CreateScene scene) {
		super(scene);
		
		help = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 	cardSound.stop();
				 	cardSound.dispose();
				 	cardSound = null;
					SceneHandler.getInstance().setBack(false);
					SceneHandler.getInstance().setPreviousStage(stage);
					SceneHandler.getInstance().setHelp(true);
					ScreenManager.getInstance().show(com.sound.healing.Screen.INFO);		
	         }
		};
		no = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				stage.getActors().get(stage.getActors().size-1).setZIndex(5);
				stage.getActors().get(5).setVisible(false);
				
	         }
		};
		yes = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 if(isFlash||isDone ==1){
					 	//isDone = false;
					 	cardSound.stop();
					 	cardSound.dispose();
					 	cardSound = null;
					 }
					SceneHandler.getInstance().setBack(true);
					SceneHandler.getInstance().setPreviousStage(stage);
					ScreenManager.getInstance().show(com.sound.healing.Screen.SPREAD_SELECT);
					//for(int i = 6; i < scene.getSpec().actors.size(); i++)
					//	scene.getSpec().actors.remove(i);	
			 
					 		
	         }
		};
		
		back = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				// for(int i = 6; i < stage.getActors().size; i++){
				//	 stage.getActors().get(i).setVisible(false);
				// }
				stage.getActors().get(5).setVisible(true);
				stage.getActors().get(5).toFront();
				//System.out.println(((Group) stage.getActors().get(4)).getChildren().get(2).getUserObject());
					 		
	         }
		};
		save = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
						 if(isFlash||isDone == 1){
							 	//isDone = false;
							 	cardSound.stop();
							 	cardSound.dispose();
							 	cardSound = null;
							 }			
					 		String cardIDs = "";
					 		for(int i = 0; i < AllCards.getInstance().getRevealCards().size; i++){
					 			cardIDs += String.valueOf(AllCards.getInstance().getRevealCards().get(i).getCardSpec().getCardProperty(CardEnum.ID.getEnumID()))+",";
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
					 if(event.getListenerActor().equals(stage.getActors().get(flasher))){
							stage.getActors().get(flasher).clearActions();
							flasher+=2;
						 	cardSound.stop();
						 	cardSound.dispose();
						 	cardSound = null;
						AllCards.getInstance().setCurrentCard(Integer.parseInt(event.getListenerActor().getName())); 
						SceneHandler.getInstance().setCurrentSpreadStage(stage);
						isCardFlip = true;
						event.getListenerActor().addAction(Actions.parallel(Actions.fadeOut(0.6f)));
						stage.getActors().get((Integer) event.getListenerActor().getUserObject()-1).addAction(Actions.sequence(Actions.parallel(Actions.fadeIn(0.6f),Actions.visible(true)), new Action(){

							@Override
							public boolean act(float delta) {
								SceneHandler.getInstance().setBack(false);
								SceneHandler.getInstance().setPreviousStage(stage);
								if(flasher < 6+(AllCards.getInstance().getRevealCards().size*2)){
									stage.getActors().get(flasher).addAction(Actions.forever(Actions.sequence(Actions.fadeOut(1f),Actions.fadeIn(1f))));
								}
								else{
									isFlash = false;
								}
								ScreenManager.getInstance().show(com.sound.healing.Screen.Card);
								return true;
							}
							
						}));
											
			         	}
					 }
				 else{
					 if(isDone == 1){
						 isDone = 2;
						 	cardSound.stop();
						 	cardSound.dispose();
						 	cardSound = null;
						 	//isDone = false;
					 }
						AllCards.getInstance().setCurrentCard(Integer.parseInt(event.getListenerActor().getName())); 
						SceneHandler.getInstance().setCurrentSpreadStage(stage);
						isCardFlip = true;

						SceneHandler.getInstance().setBack(false);
						SceneHandler.getInstance().setPreviousStage(stage);
						ScreenManager.getInstance().show(com.sound.healing.Screen.Card);
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
		SceneHandler.getInstance().setLoad(1);
		
		if(isCardFlip||SceneHandler.getInstance().isHelp()){
			stage.clear();
			transitionStage.clear();
			transitionStage = SceneHandler.getInstance().getPreviousStage();
			stage = scene.getSpec().createStage();
			transitionStage.addAction(Actions.sequence(Actions.moveTo(0, 0), Actions.moveTo(transitionStage.getWidth(), 0, 0.4f)));
	 		stage.addAction(Actions.sequence(Actions.moveTo(-stage.getWidth(),0),Actions.moveTo(0, 0, 0.4f)));
			Gdx.input.setInputProcessor(stage);
			SceneHandler.getInstance().setHelp(false);
			isCardFlip = false;
			if(isFlash){
			cardSound = Gdx.audio.newMusic(Gdx.files.internal("Sound/"+sounds.get((flasher-7)/2)));
			cardSound.play();
			}
			else if(isDone == 0){
				stage.getActors().get(1).removeListener(help);
				isDone = 1;
				cardSound = Gdx.audio.newMusic(Gdx.files.internal("Sound/004.mp3"));
				cardSound.setOnCompletionListener(new OnCompletionListener(){

					@Override
					public void onCompletion(Music music) {	
							cardSound.stop();
						 	cardSound.dispose();
						 	cardSound = null;
							cardSound = Gdx.audio.newMusic(Gdx.files.internal("Sound/005.mp3"));
							cardSound.play();
					}
					
				});
				cardSound.play();
			}
		}
		else{
			SceneHandler.getInstance().setHelp(false);
			isFlash = true;
			flasher = 7;
			isDone = 0;
			stage.clear();
			transitionStage.clear();
			transitionStage = SceneHandler.getInstance().getPreviousStage();
			scene.reset();
			stage = scene.getSpec().createStage();
			transitionStage.addAction(Actions.sequence(Actions.moveTo(0, 0), Actions.moveTo(-transitionStage.getWidth(), 0, 0.4f)));
	 		stage.addAction(Actions.sequence(Actions.moveTo(stage.getWidth(),0),Actions.moveTo(0, 0, 0.4f)));
	 		Gdx.input.setInputProcessor(stage);
	 		stage.getActors().get(1).addListener(help);
			stage.getActors().get(2).addListener(back);
			stage.getActors().get(3).addListener(save);
			for(int i = 7; i < 6+(AllCards.getInstance().getRevealCards().size*2); i++){
				stage.getActors().get(i).addListener(flip);
				
			}
			stage.getActors().get(5).setZIndex(stage.getActors().get(5).getZIndex()-1);
			stage.getActors().get(5).setVisible(false);
			((Group) stage.getActors().get(5)).getChildren().get(2).addListener(yes);
			((Group) stage.getActors().get(5)).getChildren().get(3).addListener(no);
			stage.getActors().get(flasher).addAction(Actions.forever(Actions.sequence(Actions.fadeOut(1f),Actions.fadeIn(1f))));
			sounds = null;
			sounds = SceneHandler.getInstance().getSpread().getCardsSound();
			cardSound = Gdx.audio.newMusic(Gdx.files.internal("Sound/"+sounds.get(flasher-7)));
			cardSound.play();
		}
		
	}

/*			cardSound.stop();
		 	cardSound.dispose();
		 	cardSound = null;
			cardSound = Gdx.audio.newMusic(Gdx.files.internal("Sound/"+AllCards.getInstance().getCurrentCard().getCardSpec().getCardProperty(CardEnum.SOUND1.getEnumID())));
			cardSound.play();
			*/
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
