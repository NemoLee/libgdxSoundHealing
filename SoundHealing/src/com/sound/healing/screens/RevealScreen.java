package com.sound.healing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.sound.healing.ScreenManager;
import com.sound.healing.actors.SceneHandler;
import com.sound.healing.cards.AllCards;
import com.sound.healing.cards.Card;

public class RevealScreen  extends BaseScreen implements com.badlogic.gdx.Screen {
	private ClickListener back, flip;
	private boolean isCardFlip = false;
	
	public RevealScreen(ScreenSpec screenSpec) {
		super(screenSpec);
		back = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 
				 			transitionStage = SceneHandler.getInstance().getCreateSpreadSelect().getSpec().createStage();
				 			transitionStage.addAction(Actions.sequence(Actions.moveTo(-transitionStage.getWidth(), 0), Actions.moveTo(0, 0, 0.4f)));
					 		stage.addAction(Actions.sequence(Actions.delay(0.0f),Actions.moveTo(stage.getWidth(), 0, 0.4f),Actions.delay(0.4f),Actions.run(new Runnable(){

								@Override
								public void run() {
									ScreenManager.getInstance().show(com.sound.healing.Screen.SPREAD_SELECT); 
									
								}
					 			
					 		})));
					 		
	         }
		};
		flip = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				AllCards.getInstance().setCurrentCard(Integer.parseInt(event.getListenerActor().getName())); 
				SceneHandler.getInstance().setCurrentSpreadStage(stage);
				isCardFlip = true;
				event.getListenerActor().addAction(Actions.parallel(Actions.fadeOut(0.3f)));
				stage.getActors().get((Integer) event.getListenerActor().getUserObject()-1).addAction(Actions.parallel(Actions.fadeIn(0.3f),Actions.visible(true)));
				transitionStage = SceneHandler.getInstance().getCreateCard().getSpec().createStage();
	 			transitionStage.addAction(Actions.sequence(Actions.moveTo(transitionStage.getWidth(), 0),Actions.delay(0.6f), Actions.moveTo(0, 0, 0.4f)));
		 		stage.addAction(Actions.sequence(Actions.delay(0.6f),Actions.moveTo(-stage.getWidth(), 0, 0.4f),Actions.delay(0.8f),Actions.run(new Runnable(){

					@Override
					public void run() {
						ScreenManager.getInstance().show(com.sound.healing.Screen.Card); 
						
					}
		 			
		 		})));
		
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
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		if(isCardFlip){
			Gdx.input.setInputProcessor(stage);
			isCardFlip = false;
		}
		else{
			//might need to fix memory leak in scenehandler
			stage.clear();
			transitionStage.clear();
			stage = screenSpec.createStage();
			Gdx.input.setInputProcessor(stage);
			stage.getActors().get(1).addListener(back);
			for(int i = 5; i < 4+(SceneHandler.getInstance().getSpread().getNumberOfCards()*2); i++){
				stage.getActors().get(i).addListener(flip);
			}
		}
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
