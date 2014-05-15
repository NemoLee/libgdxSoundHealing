package com.sound.healing;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.TextureLoader.TextureParameter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.sound.healing.custom.MenuButton;
import com.sound.healing.custom.TopImage;

public class AssetLoader {
	
	public static AssetManager manager = new AssetManager();

	public FreeTypeFontGenerator generator,generator2;
	public FreeTypeFontParameter font;
	public BitmapFont slab,smallSlab, sans;
	public TextureParameter param;

	
	private static final AssetLoader INSTANCE = new AssetLoader();


	public static AssetLoader getInstance() {
		
		return INSTANCE;
	}
	
	public void loadSplash(){
		param = new TextureParameter();
		param.minFilter = TextureFilter.Linear;
		param.magFilter = TextureFilter.Linear;
		manager.load("Splash/splash.png", Texture.class, param);
		manager.load("Splash/loading.png", Texture.class, param);
		manager.finishLoading();
	}
	
	public void loadAll() {
		if(!manager.isLoaded("UI/wait.png")){
		Texture.setAssetManager(manager);
		generator = new FreeTypeFontGenerator(Gdx.files.internal("Font/slab.ttf"));
		generator2 = new FreeTypeFontGenerator(Gdx.files.internal("Font/sans.ttf"));
		font = new FreeTypeFontParameter();
		font.size = Gdx.graphics.getWidth()/12;
		slab = generator.generateFont(font);
		font.size = Gdx.graphics.getWidth()/17;
		smallSlab = generator.generateFont(font);
		font.size = Gdx.graphics.getWidth()/25;
		sans = generator2.generateFont(font);
		//loadMenu
	//	manager.load("Menu/menu.atlas", TextureAtlas.class);
		manager.load("Menu/menubutton.atlas", TextureAtlas.class);
		manager.load("Menu/menu_title.png", Texture.class, param);
		manager.load("All/all.atlas", TextureAtlas.class);
		manager.load("Reveal/more_info_button.png", Texture.class, param);
		manager.load("Back/backbutton.atlas", TextureAtlas.class);
		//manager.load("Top/top_header.png", Texture.class ,param);
		manager.load("Back/backbuttonsmall.atlas", TextureAtlas.class);
	
		manager.load("Info/startbutton.atlas", TextureAtlas.class);
		manager.load("Reveal/savebutton.atlas", TextureAtlas.class);
		manager.load("Card/flipbutton.atlas", TextureAtlas.class);
		manager.load("UI/yesbutton.atlas", TextureAtlas.class);
		manager.load("UI/nobutton.atlas", TextureAtlas.class);
		
		manager.load("Card/cardsheet.atlas", TextureAtlas.class);
		manager.load("UI/wait2.png", Texture.class, param);
		manager.load("UI/wait.png", Texture.class, param);
		}
	}
}
