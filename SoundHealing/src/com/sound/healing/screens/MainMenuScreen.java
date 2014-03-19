package com.sound.healing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.sound.healing.AssetLoader;
import com.sound.healing.Screen;
import com.sound.healing.ScreenManager;

public class MainMenuScreen extends BaseScreen implements com.badlogic.gdx.Screen {

	private TextButton startButton, browseButton, loadButton, moreinfoButton;
	private Sprite sprite_Menu_Title, sprite_Menu_Author, sprite_Menu_Title_Background;
	private Stage stage;
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		stage.act();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(sprite_Menu_Title_Background, 0,0, WIDTH, HEIGHT/3+HEIGHT/10);
		batch.draw(sprite_Menu_Title,WIDTH/4,HEIGHT/16,WIDTH/2,HEIGHT/6);
		batch.draw(sprite_Menu_Author,WIDTH/3,HEIGHT/4+HEIGHT/24,WIDTH/3,HEIGHT/18);
		batch.end();
		batch.begin();
			stage.draw();
		batch.end();

	}

	@Override
	public void resize(int width, int height) {
		

	}

	@Override
	public void show() {
	AssetLoader.getInstance().loadMainMenu();
	stage = new Stage(WIDTH,HEIGHT);
	stage.clear();
    Gdx.input.setInputProcessor(stage);
    
    //background
    sprite_Menu_Title_Background = new Sprite(AssetLoader.getInstance().texture_Menu_Title_Background);
    sprite_Menu_Title_Background.flip(false, true);
    
    //title
    sprite_Menu_Title = new Sprite(AssetLoader.getInstance().texture_Menu_Title);
    sprite_Menu_Title.flip(false, true);
    
    //author
    sprite_Menu_Author = new Sprite(AssetLoader.getInstance().texture_Menu_Author);
    sprite_Menu_Author.flip(false, true);
    
    //Start button
    startButton = new TextButton("Start",AssetLoader.getInstance().style_menu_startbutton);
    startButton.setPosition(0, 3*(HEIGHT/7));
    startButton.setSize(WIDTH, HEIGHT/7);
    startButton.addListener(new InputListener(){
		public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
			
			return true;
	 	}

		public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
	        ScreenManager.getInstance().show(com.sound.healing.Screen.SPREAD_SELECT);
			dispose();
				
	 	}
    });
    stage.addActor(startButton);
    
    //Browse Button  
    browseButton = new TextButton("Browse",AssetLoader.getInstance().style_menu_startbutton);
    browseButton.setPosition(0, 2*(HEIGHT/7));
    browseButton.setSize(WIDTH, HEIGHT/7);
    browseButton.addListener(new InputListener(){
		public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
			
			return true;
	 	}

		public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
	        ScreenManager.getInstance().show(com.sound.healing.Screen.BROWSE);
			dispose();
				
	 	}
    });
    stage.addActor(browseButton);
    
    
    //Load Button
    loadButton = new TextButton("Load",AssetLoader.getInstance().style_menu_startbutton);
    loadButton.setPosition(0, 1*(HEIGHT/7));
    loadButton.setSize(WIDTH, HEIGHT/7);
    loadButton.addListener(new InputListener(){
		public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
			
			return true;
	 	}

		public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
	        ScreenManager.getInstance().show(com.sound.healing.Screen.LOAD);
			dispose();
				
	 	}
    });
    stage.addActor(loadButton);
    
    
    //MoreInfo Button
    moreinfoButton = new TextButton("More Info",AssetLoader.getInstance().style_menu_startbutton);
    moreinfoButton.setPosition(0, 0);
    moreinfoButton.setSize(WIDTH, HEIGHT/7);
    moreinfoButton.addListener(new InputListener(){
		public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
			
			return true;
	 	}

		public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
	        ScreenManager.getInstance().show(com.sound.healing.Screen.MORE_INFO);
			dispose();
				
	 	}
    });
    stage.addActor(moreinfoButton);
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
		ScreenManager.getInstance().dispose(Screen.MAIN_MENU);

	}

}
