package com.sound.healing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.sound.healing.AssetLoader;
import com.sound.healing.Screen;
import com.sound.healing.ScreenManager;
import com.sound.healing.actors.CreateSpreadSelect;
import com.sound.healing.actors.SceneHandler;

public class MainMenuScreen extends BaseScreen implements com.badlogic.gdx.Screen {


	public MainMenuScreen(ScreenSpec screenSpec) {
		super(screenSpec);

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
	public void resize(int width, int height) {
		batch.getProjectionMatrix().setToOrtho2D(0, 0, width, height);

	}

	@Override
	public void show() {
	AssetLoader.getInstance().loadSpreadSelect();
	stage.clear();
	transitionStage.clear();
	stage = screenSpec.createStage();
	Gdx.input.setInputProcessor(stage);
	
	ClickListener click = new ClickListener(){
		 @Override
         public void clicked(InputEvent event, float x, float y) {
			 
			 			transitionStage = SceneHandler.getInstance().getCreateSpreadSelect().getSpec().createStage();
			 			transitionStage.addAction(Actions.sequence(Actions.moveTo(transitionStage.getWidth(), 0), Actions.moveTo(0, 0, 0.4f)));
				 		stage.addAction(Actions.sequence(Actions.delay(0.0f),Actions.moveTo(-stage.getWidth(), 0, 0.4f),Actions.delay(0.4f),Actions.run(new Runnable(){

							@Override
							public void run() {
								ScreenManager.getInstance().show(Screen.SPREAD_SELECT); 
							}
				 			
				 		})));
				 		
										 	
			
         }
	};
	
	stage.getActors().get(3).addListener(click);
	stage.getActors().get(4).addListener(click);
	stage.getActors().get(5).addListener(click);
	stage.getActors().get(6).addListener(click);
    
   
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
		
		batch.dispose();
		stage.dispose();
		//AssetLoader.getInstance().unloadMainMenu();
		

	}

}
