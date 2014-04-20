package com.sound.healing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.TimeUtils;
import com.sound.healing.AssetLoader;
import com.sound.healing.Screen;
import com.sound.healing.ScreenManager;
import com.sound.healing.actors.CreateScene;
import com.sound.healing.actors.CreateSplash;
import com.sound.healing.actors.SceneHandler;
import com.sound.healing.custom.Spread;

public class SplashScreen extends BaseScreen{

	private boolean isSelect = false;
	private boolean isInfo = false;
	private boolean isChoose = false;
	private boolean isReveal = false;
	private boolean isCard = false;
	private boolean isLoad = false;
	
	public SplashScreen(CreateSplash createSplash) {
		super(createSplash);

	}
	
	
	 
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.35f, 0, 0.7f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		transitionStage.act();
		stage.act();
		batch.setProjectionMatrix(camera.combined);
		if(AssetLoader.manager.update(50)){
			load();
		}
		if(!isSelect && AssetLoader.manager.isLoaded("Card/10.png",Texture.class)){
			isSelect = true;
			Screen.SPREAD_SELECT.getScreenInstance();
		}
		if(!isInfo && AssetLoader.manager.isLoaded("Card/20.png",Texture.class)){
			isInfo = true;
			Screen.INFO.getScreenInstance();
		}
		if(!isChoose && AssetLoader.manager.isLoaded("Card/30.png",Texture.class)){
			isChoose = true;
			Screen.CHOOSE.getScreenInstance();
		}
		if(!isLoad && AssetLoader.manager.isLoaded("Card/40.png",Texture.class)){
			isLoad = true;
			Screen.LOAD.getScreenInstance();
		}
		if(!isCard && AssetLoader.manager.isLoaded("Card/50.png",Texture.class)){
			isCard = true;
			Screen.Card.getScreenInstance();
		}
		if(!isReveal && AssetLoader.manager.isLoaded("UI/wait.png",Texture.class)){
			isReveal = true;
			Screen.REVEAL.getScreenInstance();
		}
	    batch.begin();
			stage.draw();
			transitionStage.draw();
    	batch.end();
	}
	
	
	@Override
	public void show() {
		stage.clear();
		transitionStage.clear();
		stage = scene2.getSpec().createStage();
		Gdx.input.setInputProcessor(stage);
		stage.getActors().get(1).addAction(Actions.forever(Actions.rotateBy(10)));
        
        SceneHandler.getInstance().setSpread(Spread.SOUND_ADVICE);
        AssetLoader.getInstance().loadAll();
			}
	
	private void load(){
		
		//Screen.SPREAD_SELECT.getScreenInstance();
		//Screen.INFO.getScreenInstance();
		//Screen.CHOOSE.getScreenInstance();
		//Screen.REVEAL.getScreenInstance();
		//Screen.Card.getScreenInstance();
		//Screen.LOAD.getScreenInstance();
 		SceneHandler.getInstance().setBack(false);
 		stage.getActors().get(1).clearActions();
 		SceneHandler.getInstance().setPreviousStage(stage);
        ScreenManager.getInstance().show(Screen.MAIN_MENU);

	}
	
}
