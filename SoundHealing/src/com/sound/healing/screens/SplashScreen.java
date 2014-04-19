package com.sound.healing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.sound.healing.AssetLoader;
import com.sound.healing.Screen;
import com.sound.healing.ScreenManager;
import com.sound.healing.actors.CreateScene;
import com.sound.healing.actors.SceneHandler;
import com.sound.healing.custom.Spread;

public class SplashScreen extends BaseScreen{

	private Thread t;
	
	public SplashScreen(CreateScene scene) {
		super(scene);

	}
	
	
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.35f, 0, 0.7f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		transitionStage.act();
		stage.act();
		batch.setProjectionMatrix(camera.combined);
		/*if(AssetLoader.manager.update(50)){
			load();
		}
		if (AssetLoader.manager.isLoaded("Menu/menubutton.atlas")){
			Screen.MAIN_MENU.getScreenInstance();
		}
		if (AssetLoader.manager.isLoaded("Select/select_angel.png")){
			Screen.SPREAD_SELECT.getScreenInstance();
		}
		if (AssetLoader.manager.isLoaded("Info/infocard9.png")){
			Screen.INFO.getScreenInstance();
		}
		if (AssetLoader.manager.isLoaded("Choose/minicard_bg.png")){
	        Screen.CHOOSE.getScreenInstance();
		}
		if (AssetLoader.manager.isLoaded("Card/flipbutton.atlas")){
			Screen.REVEAL.getScreenInstance();
		}
		if (AssetLoader.manager.isLoaded("Card/spread8_8.png")){
			Screen.Card.getScreenInstance();
			Screen.LOAD.getScreenInstance();
		}
		*/
	    batch.begin();
			stage.draw();
			transitionStage.draw();
    	batch.end();
	}
	
	
	@Override
	public void show() {
		stage.clear();
		transitionStage.clear();
		stage = scene.getSpec().createStage();
		Gdx.input.setInputProcessor(stage);
		stage.getActors().get(1).addAction(Actions.forever(Actions.rotateBy(10)));
        
        SceneHandler.getInstance().setSpread(Spread.SOUND_ADVICE);
       
        load();
			}
	
	private void load(){
		new Thread(new Runnable(){
			@Override
			public void run() {
				Gdx.app.postRunnable(new Runnable(){
					@Override
					public void run() {
						AssetLoader.getInstance().loadAll();
						Screen.SPREAD_SELECT.getScreenInstance();
						Screen.INFO.getScreenInstance();
						Screen.CHOOSE.getScreenInstance();
						Screen.REVEAL.getScreenInstance();
						Screen.Card.getScreenInstance();
						Screen.LOAD.getScreenInstance();
				 		SceneHandler.getInstance().setBack(false);
				 		SceneHandler.getInstance().setPreviousStage(stage);
				        ScreenManager.getInstance().show(Screen.MAIN_MENU);
					}
				});
				
			}
		}).start();

	}
	
}
