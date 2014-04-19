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

	private ClickListener click, click2, click3;

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
		click3 = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 		SceneHandler.getInstance().setBack(false);
				 		SceneHandler.getInstance().setPreviousStage(stage);
						ScreenManager.getInstance().show(Screen.BROWSE);
		 	
				
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
		transitionStage = SceneHandler.getInstance().getPreviousStage();
		scene.reset();
		stage = scene.getSpec().createStage();

		if(SceneHandler.getInstance().isBack()){
			transitionStage.addAction(Actions.sequence(Actions.moveTo(0, 0), Actions.moveTo(transitionStage.getWidth(), 0, 0.4f)));
	 		stage.addAction(Actions.sequence(Actions.moveTo(-stage.getWidth(),0),Actions.moveTo(0, 0, 0.4f)));
		}
		else{
		transitionStage.addAction(Actions.sequence(Actions.moveTo(0, 0), Actions.moveTo(-transitionStage.getWidth(), 0, 0.4f)));
	 	stage.addAction(Actions.sequence(Actions.moveTo(stage.getWidth(),0),Actions.moveTo(0, 0, 0.4f), Actions.run(new Runnable(){
	 		@Override
	 		public void run() {
	 			AssetLoader.manager.unload("Splash/splash.png");
	 			AssetLoader.manager.unload("Splash/loading.png");
	 			ScreenManager.getInstance().dispose(Screen.SPLASH);
	 		}
	 	})));
		}
 		Gdx.input.setInputProcessor(stage);
	//}
	/*else{
		stage.clear();
		transitionStage.clear();
		stage = scene.getSpec().createStage();
		Gdx.input.setInputProcessor(stage);
	}
	*/
	stage.getActors().get(3).addListener(click);
	stage.getActors().get(4).addListener(click3);
	stage.getActors().get(5).addListener(click2);
	//stage.getActors().get(6).addListener(click);
    
   
	}



	@Override
	public void dispose() {

	}

}
