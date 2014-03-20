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
import com.sound.healing.buttons.MenuButton;

public class MainMenuScreen extends BaseScreen implements com.badlogic.gdx.Screen {

	private MenuButton startButton, browseButton, loadButton, moreinfoButton;
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
    startButton = new MenuButton("Start",AssetLoader.getInstance().style_menu_startbutton,0,3*(HEIGHT/7),WIDTH, HEIGHT/7,this,com.sound.healing.Screen.SPREAD_SELECT);
    stage.addActor(startButton);
    
    //Browse Button  
    browseButton = new MenuButton("Browse",AssetLoader.getInstance().style_menu_startbutton,0,2*(HEIGHT/7), WIDTH, HEIGHT/7, this, com.sound.healing.Screen.BROWSE);
    stage.addActor(browseButton);
    
    
    //Load Button
    loadButton = new MenuButton("Load",AssetLoader.getInstance().style_menu_startbutton,0,(HEIGHT/7), WIDTH, HEIGHT/7, this, com.sound.healing.Screen.LOAD );
    stage.addActor(loadButton);
    
    
    //MoreInfo Button
    moreinfoButton = new MenuButton("More Info",AssetLoader.getInstance().style_menu_startbutton,0,0,WIDTH,HEIGHT/7,this,com.sound.healing.Screen.MORE_INFO);
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
		batch.dispose();
		stage.dispose();
		AssetLoader.getInstance().unloadMainMenu();
		startButton = null;
		browseButton = null;
		loadButton = null;
		moreinfoButton = null;	
		sprite_Menu_Title = null;
		sprite_Menu_Author = null;
		sprite_Menu_Title_Background = null;
		ScreenManager.getInstance().dispose(Screen.MAIN_MENU);

	}

}
