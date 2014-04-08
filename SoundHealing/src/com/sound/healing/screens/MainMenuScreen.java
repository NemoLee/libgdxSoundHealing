package com.sound.healing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.sound.healing.AssetLoader;
import com.sound.healing.Scene;
import com.sound.healing.SceneManager;
import com.sound.healing.Screen;
import com.sound.healing.ScreenManager;
import com.sound.healing.actors.CreateSpreadSelect;
import com.sound.healing.actors.SceneHandler;

public class MainMenuScreen extends BaseScreen implements com.badlogic.gdx.Screen {

	private ClickListener click, click2;

	public MainMenuScreen(ScreenSpec screenSpec) {	
		super(screenSpec);
		click = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 
				 			transitionStage = SceneHandler.getInstance().getCreateSpreadSelect().getSpec().createStage();
				 			transitionStage.addAction(Actions.sequence(Actions.moveTo(transitionStage.getWidth(), 0), Actions.moveTo(0, 0, 0.4f)));
					 		stage.addAction(Actions.sequence(Actions.delay(0.0f),Actions.moveTo(-stage.getWidth(), 0, 0.4f),Actions.delay(0.4f),Actions.run(new Runnable(){

								@Override
								public void run() {
									SceneManager.getInstance().getGame().setScreen(SceneManager.getInstance().createSpreadSelect());	
								}
					 			
					 		})));
					 		
											 	
				
	         }
		};
		click2 = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 			
				 			transitionStage = SceneHandler.getInstance().getCreateLoad().getSpec().createStage();
				 			transitionStage.addAction(Actions.sequence(Actions.moveTo(transitionStage.getWidth(), 0), Actions.moveTo(0, 0, 0.4f)));
					 		stage.addAction(Actions.sequence(Actions.delay(0.0f),Actions.moveTo(-stage.getWidth(), 0, 0.4f),Actions.delay(0.4f),Actions.run(new Runnable(){

								@Override
								public void run() {
									SceneManager.getInstance().getGame().setScreen(SceneManager.getInstance().createLoad());
								}
					 			
					 		})));
					 		
											 	
				
	         }
		};
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		stage.act();
		transitionStage.act();
		batch.setProjectionMatrix(camera.combined);	
		batch.begin();
			transitionStage.draw();
			stage.draw();
		batch.end();
	}


	@Override
	public void show() {
	stage.clear();
	transitionStage.clear();
	stage = screenSpec.createStage();
	Gdx.input.setInputProcessor(stage);

	
	stage.getActors().get(3).addListener(click);
	stage.getActors().get(4).addListener(click);
	stage.getActors().get(5).addListener(click2);
	stage.getActors().get(6).addListener(click);
    
   
	}



	@Override
	public void dispose() {
	
		

	}

	@Override
	public Scene getSceneType() {
		return Scene.MAIN_MENU;
	}

}
