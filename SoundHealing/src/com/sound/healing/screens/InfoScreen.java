package com.sound.healing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.sound.healing.AssetLoader;
import com.sound.healing.Scene;
import com.sound.healing.SceneManager;
import com.sound.healing.ScreenManager;
import com.sound.healing.actors.SceneHandler;

public class InfoScreen extends BaseScreen implements com.badlogic.gdx.Screen {

	public InfoScreen(ScreenSpec screenSpec) {
		super(screenSpec);

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
	
		stage.clear();
		transitionStage.clear();
		stage = screenSpec.createStage();
		Gdx.input.setInputProcessor(stage);
		ClickListener back = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 
				 			transitionStage = SceneHandler.getInstance().getCreateSpreadSelect().getSpec().createStage();
				 			transitionStage.addAction(Actions.sequence(Actions.moveTo(-transitionStage.getWidth(), 0), Actions.moveTo(0, 0, 0.4f)));
					 		stage.addAction(Actions.sequence(Actions.delay(0.0f),Actions.moveTo(stage.getWidth(), 0, 0.4f),Actions.delay(0.4f),Actions.run(new Runnable(){

								@Override
								public void run() {
									SceneManager.getInstance().getGame().setScreen(SceneManager.getInstance().createSpreadSelect());	
									
								}
					 			
					 		})));
					 		
	         }
		};
		
		ClickListener click = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 
				 			transitionStage = SceneHandler.getInstance().getCreateChoose().getSpec().createStage();
				 			transitionStage.getActors().get(3).setVisible(true);
				 			transitionStage.getActors().get(4).setVisible(true);
				 			transitionStage.getActors().get(5).setVisible(true);
				 			transitionStage.addAction(Actions.sequence(Actions.moveTo(transitionStage.getWidth(), 0), Actions.moveTo(0, 0, 0.4f)));
					 		stage.addAction(Actions.sequence(Actions.delay(0.0f),Actions.moveTo(-stage.getWidth(), 0, 0.4f),Actions.delay(0.4f),Actions.run(new Runnable(){

								@Override
								public void run() {
									SceneManager.getInstance().getGame().setScreen(SceneManager.getInstance().createChoose());	
								}
					 			
					 		})));
					 		
											 	
				
	         }
		};
		
		stage.getActors().get(4).addListener(back);
		stage.getActors().get(5).addListener(click);

	}


	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Scene getSceneType() {
	
		return Scene.INFO;
	}

}
