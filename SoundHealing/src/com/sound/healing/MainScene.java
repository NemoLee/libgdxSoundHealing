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
        AssetLoader.getInstance().loadAll();
        ScreenManager.getInstance().initialize(this);
        SceneHandler.getInstance().setSpread(Spread.SOUND_ADVICE);
        Screen.SPREAD_SELECT.getScreenInstance();
        Screen.INFO.getScreenInstance();
        Screen.CHOOSE.getScreenInstance();
        Screen.REVEAL.getScreenInstance();
        Screen.Card.getScreenInstance();
        Screen.LOAD.getScreenInstance();
        ScreenManager.getInstance().show(Screen.MAIN_MENU);
    }
 
    @Override
    public void dispose() {
        super.dispose();
        ScreenManager.getInstance().dispose();
    }
}
