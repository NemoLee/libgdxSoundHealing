package com.sound.healing;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.sound.healing.actors.SceneHandler;
import com.sound.healing.custom.Spread;

public class MainScene extends Game {
	
	
    @Override
    public void create() {
    	AssetLoader.getInstance().loadSplash();
    	ScreenManager.getInstance().initialize(this);
    	ScreenManager.getInstance().show(Screen.SPLASH);
    	
    }
 
    @Override
    public void dispose() {
        super.dispose();
        ScreenManager.getInstance().dispose();
    }
}
