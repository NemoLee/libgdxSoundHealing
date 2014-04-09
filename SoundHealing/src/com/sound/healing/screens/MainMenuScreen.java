package com.sound.healing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.sound.healing.AssetLoader;
import com.sound.healing.Screen;
import com.sound.healing.ScreenManager;
import com.sound.healing.actors.CreateMainMenu;
import com.sound.healing.actors.CreateScene;
import com.sound.healing.actors.SceneHandler;

public class MainMenuScreen extends BaseScreen implements com.badlogic.gdx.Screen {

	private ClickListener click, click2;

	public MainMenuScreen(CreateScene scene) {	
		super(scene);
		

		click = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 			SceneHandler.getInstance().setBack(false);
				 			SceneHandler.getInstance().setPreviousStage(stage);
				 			ScreenManager.getInstance().show(Screen.SPREAD_SELECT);
			 }
		};
		click2 = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 		SceneHandler.getInstance().setBack(false);
				 		SceneHandler.getInstance().setPreviousStage(stage);
						ScreenManager.getInstance().show(Screen.LOAD);
		 	
				
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
	if(SceneHandler.getInstance().isBack()){
		super.show();
	}
	else{
		stage.clear();
		transitionStage.clear();
		stage = scene.getSpec().createStage();
		Gdx.input.setInputProcessor(stage);
	}
	
	stage.getActors().get(3).addListener(click);
	//stage.getActors().get(4).addListener(click);
	stage.getActors().get(5).addListener(click2);
	//stage.getActors().get(6).addListener(click);
    
   
	}



	@Override
	public void dispose() {

	}

}
