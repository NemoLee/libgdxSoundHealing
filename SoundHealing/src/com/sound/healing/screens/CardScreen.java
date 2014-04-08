package com.sound.healing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.sound.healing.Scene;
import com.sound.healing.SceneManager;
import com.sound.healing.ScreenManager;
import com.sound.healing.actors.SceneHandler;

public class CardScreen extends BaseScreen implements Screen {

	private ClickListener back, bigFlip;
	private boolean isFlipped = false;
	
	public CardScreen(ScreenSpec screenSpec) {
		super(screenSpec);
		back = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 			
				 			transitionStage = SceneHandler.getInstance().getCurrentSpreadStage();
				 			transitionStage.addAction(Actions.sequence(Actions.moveTo(-transitionStage.getWidth(), 0), Actions.moveTo(0, 0, 0.4f)));
					 		stage.addAction(Actions.sequence(Actions.delay(0.0f),Actions.moveTo(stage.getWidth(), 0, 0.4f),Actions.delay(0.4f),Actions.run(new Runnable(){

								@Override
								public void run() {
									stage.getActors().get(3).addAction(Actions.sequence(Actions.fadeOut(0.3f), Actions.visible(false)));
									stage.getActors().get(0).addAction(Actions.parallel(Actions.visible(true),Actions.fadeIn(0.3f)));
									isFlipped = false;
									if(SceneHandler.getInstance().isLoad()){
										SceneManager.getInstance().getGame().setScreen(SceneManager.getInstance().createLoadReveal());
									}
									else{
										SceneManager.getInstance().getGame().setScreen(SceneManager.getInstance().createReveal()); 
									}
								}
					 			
					 		})));
					 		
	         }
		};
		bigFlip = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 
				 if(!isFlipped){
					 stage.getActors().get(0).addAction(Actions.sequence(Actions.fadeOut(0.3f), Actions.visible(false)));
					 stage.getActors().get(3).addAction(Actions.parallel(Actions.visible(true),Actions.fadeIn(0.3f)));
					 isFlipped = true;
				 }
				 else{
					 stage.getActors().get(3).addAction(Actions.sequence(Actions.fadeOut(0.3f), Actions.visible(false)));
					 stage.getActors().get(0).addAction(Actions.parallel(Actions.visible(true),Actions.fadeIn(0.3f)));
					 isFlipped = false;
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
		stage.clear();
		//transitionStage.clear();
		stage = screenSpec.createStage();
		Gdx.input.setInputProcessor(stage);
		stage.getActors().get(3).addAction(Actions.sequence(Actions.fadeOut(0.3f), Actions.visible(false)));
		stage.getActors().get(0).addAction(Actions.parallel(Actions.visible(true),Actions.fadeIn(0.3f)));
		isFlipped = false;
		stage.getActors().get(1).addListener(back);
		stage.getActors().get(2).addListener(bigFlip);

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Scene getSceneType() {
		return Scene.CARD;
	}

}
