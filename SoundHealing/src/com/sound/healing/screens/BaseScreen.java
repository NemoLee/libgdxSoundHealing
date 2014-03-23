package com.sound.healing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.sound.healing.ScreenManager;

public class BaseScreen implements Screen{

	protected SpriteBatch batch = null;
	protected float WIDTH, HEIGHT;
	protected OrthographicCamera camera;
	protected Stage stage, transitionStage;
	protected ScreenSpec screenSpec;
	public BaseScreen(ScreenSpec screenSpec) {
		batch = new SpriteBatch();
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();
		camera = new OrthographicCamera(WIDTH,HEIGHT);
		camera.setToOrtho(false, WIDTH, HEIGHT);
		this.screenSpec = screenSpec;
		stage = new Stage(WIDTH, HEIGHT);
		transitionStage = new Stage(WIDTH,HEIGHT);
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
		// TODO Auto-generated method stub
		
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
	
	public Stage getStage() {
		return stage;
	}

}
