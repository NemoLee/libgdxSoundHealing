package com.sound.healing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.sound.healing.ScreenManager;
import com.sound.healing.actors.CreateScene;
import com.sound.healing.actors.SceneHandler;
import com.sound.healing.cards.AllCards;

public class loadRevealScreen extends BaseScreen implements Screen {

	private ClickListener back, flip;
	private boolean isCardFlip = false;
	int flasher = 5;
	private boolean isFlash = true;
	
	public loadRevealScreen(CreateScene sccene) {
		super(sccene);
		back = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 
				 	SceneHandler.getInstance().setBack(true);
					SceneHandler.getInstance().setPreviousStage(stage);
					ScreenManager.getInstance().show(com.sound.healing.Screen.LOAD);
					 		
	         }
		};
		flip = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 if(isFlash){
					 if(event.getListenerActor().equals(stage.getActors().get(flasher))){
							stage.getActors().get(flasher).clearActions();
							flasher+=2;
							if(flasher < 4+(SceneHandler.getInstance().getSpread().getNumberOfCards()*2)){
								stage.getActors().get(flasher).addAction(Actions.forever(Actions.sequence(Actions.fadeOut(0.8f),Actions.fadeIn(0.8f))));
							}
							else{
								isFlash = false;
							}
						AllCards.getInstance().setCurrentCard(Integer.parseInt(event.getListenerActor().getName())); 
						SceneHandler.getInstance().setCurrentSpreadStage(stage);
						isCardFlip = true;
						event.getListenerActor().addAction(Actions.parallel(Actions.fadeOut(0.3f)));
						stage.getActors().get((Integer) event.getListenerActor().getUserObject()-1).addAction(Actions.parallel(Actions.fadeIn(0.3f),Actions.visible(true)));
						SceneHandler.getInstance().setLoad(true);
						SceneHandler.getInstance().setBack(false);
						SceneHandler.getInstance().setPreviousStage(stage);
						ScreenManager.getInstance().show(com.sound.healing.Screen.Card);
											
			         	}
					 }
				 else{
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
		camera.update();
		transitionStage.act();
		stage.act();
		batch.setProjectionMatrix(camera.combined);
		
	    batch.begin();
			stage.draw();
			transitionStage.draw();
    	batch.end();

	}

	@Override
	public void show() {
		if(isCardFlip){
			stage.clear();
			transitionStage.clear();
			transitionStage = SceneHandler.getInstance().getPreviousStage();
			stage = scene.getSpec().createStage();
			transitionStage.addAction(Actions.sequence(Actions.moveTo(0, 0), Actions.moveTo(transitionStage.getWidth(), 0, 0.4f)));
	 		stage.addAction(Actions.sequence(Actions.moveTo(-stage.getWidth(),0),Actions.moveTo(0, 0, 0.4f)));
			Gdx.input.setInputProcessor(stage);
			isCardFlip = false;
		}
		else{
			isFlash = true;
			flasher = 5;
			stage.clear();
			transitionStage.clear();
			transitionStage = SceneHandler.getInstance().getPreviousStage();
			scene.reset();
			stage = scene.getSpec().createStage();
			transitionStage.addAction(Actions.sequence(Actions.moveTo(0, 0), Actions.moveTo(-transitionStage.getWidth(), 0, 0.4f)));
	 		stage.addAction(Actions.sequence(Actions.moveTo(stage.getWidth(),0),Actions.moveTo(0, 0, 0.4f)));
	 		Gdx.input.setInputProcessor(stage);
			stage.getActors().get(1).addListener(back);
			for(int i = 5; i < 4+(SceneHandler.getInstance().getSpread().getNumberOfCards()*2); i++){
				stage.getActors().get(i).addListener(flip);
			}
			stage.getActors().get(flasher).addAction(Actions.forever(Actions.sequence(Actions.fadeOut(0.8f),Actions.fadeIn(0.8f))));
		}

	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
