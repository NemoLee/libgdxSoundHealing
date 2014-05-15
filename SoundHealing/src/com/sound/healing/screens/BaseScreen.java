package com.sound.healing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.sound.healing.AssetLoader;
import com.sound.healing.MainScene;
import com.sound.healing.ScreenManager;
import com.sound.healing.actors.CreateScene;
import com.sound.healing.actors.CreateSplash;
import com.sound.healing.actors.SceneHandler;

public abstract class BaseScreen implements Screen{

	protected SpriteBatch batch = null;
	protected float WIDTH, HEIGHT;
	protected OrthographicCamera camera;
	protected Stage stage, transitionStage;
	protected CreateScene scene;
	protected CreateSplash scene2;
	public BaseScreen(CreateScene scene) {
		batch = SceneHandler.getInstance().getBatch();
		//WIDTH = Gdx.graphics.getWidth()/5;
		//HEIGHT = Gdx.graphics.getHeight()/5;
		camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		this.scene = scene;
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), false, batch);
		transitionStage = new Stage(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), false, batch);
	}
	
	public BaseScreen(CreateSplash scene){
		batch = new SpriteBatch();
		//WIDTH = Gdx.graphics.getWidth()/5;
		//HEIGHT = Gdx.graphics.getHeight()/5;
		camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		scene2 = scene;
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), false, batch);
		transitionStage = new Stage(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), false , batch);
	}
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
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
	 		stage.addAction(Actions.sequence(Actions.moveTo(stage.getWidth(),0),Actions.moveTo(0, 0, 0.4f)));
		}
 		Gdx.input.setInputProcessor(stage);
 		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		//Gdx.app.exit();
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	public Stage getStage() {
		return stage;
	}

}
