package com.sound.healing;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.TextureLoader.TextureParameter;
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
	
	/*
	public void loadFont(){
		generator = new FreeTypeFontGenerator(Gdx.files.internal("Font/slab.ttf"));
		font = new FreeTypeFontParameter();
	}
	
	public void loadMainMenu() {
		//menu textures
		if(!manager.isLoaded("Menu/menubutton.atlas")){
		manager.load("Menu/menu_title_background.png", Texture.class ,param);
		manager.load("Menu/menu_title.png", Texture.class ,param); 
		manager.load("Menu/menu_author.png", Texture.class ,param);
		manager.load("Menu/menubutton.atlas", TextureAtlas.class);
		manager.load("Style/darkpurp.png", Texture.class ,param);
		manager.load("Back/backbuttonsmall.atlas", TextureAtlas.class);
		manager.load("Reveal/savebutton.atlas", TextureAtlas.class);
		manager.load("Choose/bigcard.png", Texture.class ,param);
		manager.load("Style/lightpurp.png", Texture.class ,param);		
		loadCards();
		manager.finishLoading();
		}
	}
	

	
	public void unloadMainMenu() {

	}
	
	public void loadSpreadSelect(){
		if(!manager.isLoaded("Select/select_angel.png")){
		manager.load("Back/backbutton.atlas", TextureAtlas.class);
		manager.load("Top/top_header.png", Texture.class ,param);
		manager.load("Select/select_soundadvice.png", Texture.class ,param);
		manager.load("Select/select_symphony.png", Texture.class ,param);
		manager.load("Select/select_duet.png", Texture.class ,param);
		manager.load("Select/select_heartsong.png", Texture.class ,param);
		manager.load("Select/select_individual.png", Texture.class ,param);
		manager.load("Select/select_multi.png", Texture.class ,param);
		manager.load("Select/select_retuning.png", Texture.class ,param);
		manager.load("Select/select_singingearth.png", Texture.class ,param);
		manager.load("Select/select_angel.png", Texture.class ,param);
		manager.finishLoading();
		}
	}
	
	
	public void unloadSpreadSelect(){
		
	}
	
	
	public void loadInfo(){
		if(!manager.isLoaded("Info/infocard9.png")){
		manager.load("Info/startbutton.atlas", TextureAtlas.class);
		manager.load("Info/infocard1.png", Texture.class ,param);
		manager.load("Info/infocard2.png", Texture.class ,param);
		manager.load("Info/infocard3.png", Texture.class ,param);
		manager.load("Info/infocard4.png", Texture.class ,param);
		manager.load("Info/infocard5.png", Texture.class ,param);
		manager.load("Info/infocard6.png", Texture.class ,param);
		manager.load("Info/infocard7.png", Texture.class ,param);
		manager.load("Info/infocard8.png", Texture.class ,param);
		manager.load("Info/infocard9.png", Texture.class ,param);
		manager.finishLoading();
		}
		
	}
	
	public void loadChoose(){
		if(!manager.isLoaded("Choose/minicard.png")){
			manager.load("Choose/minicard_bg.png", Texture.class ,param);
			manager.finishLoading();
		}
	}

	public void loadReveal(){
		if(!manager.isLoaded("Reveal/savebutton.atlas")){
			manager.load("Reveal/savebutton.atlas", TextureAtlas.class);
			manager.finishLoading();
		}
	}

	public void loadCards(){
		if(!manager.isLoaded("Card/52.png")){
			manager.load("Card/1.png", Texture.class ,param);
			manager.load("Card/2.png", Texture.class ,param);
			manager.load("Card/3.png", Texture.class ,param);
			manager.load("Card/4.png", Texture.class ,param);
			manager.load("Card/5.png", Texture.class ,param);
			manager.load("Card/6.png", Texture.class ,param);
			manager.load("Card/7.png", Texture.class ,param);
			manager.load("Card/8.png", Texture.class ,param);
			manager.load("Card/9.png", Texture.class ,param);
			manager.load("Card/10.png", Texture.class ,param);
			manager.load("Card/11.png", Texture.class ,param);
			manager.load("Card/12.png", Texture.class ,param);
			manager.load("Card/13.png", Texture.class ,param);
			manager.load("Card/14.png", Texture.class ,param);
			manager.load("Card/15.png", Texture.class ,param);
			manager.load("Card/16.png", Texture.class ,param);
			manager.load("Card/17.png", Texture.class ,param);
			manager.load("Card/18.png", Texture.class ,param);
			manager.load("Card/19.png", Texture.class ,param);
			manager.load("Card/20.png", Texture.class ,param);
			manager.load("Card/21.png", Texture.class ,param);
			manager.load("Card/22.png", Texture.class ,param);
			manager.load("Card/23.png", Texture.class ,param);
			manager.load("Card/24.png", Texture.class ,param);
			manager.load("Card/25.png", Texture.class ,param);
			manager.load("Card/26.png", Texture.class ,param);
			manager.load("Card/27.png", Texture.class ,param);
			manager.load("Card/28.png", Texture.class ,param);
			manager.load("Card/29.png", Texture.class ,param);
			manager.load("Card/30.png", Texture.class ,param);
			manager.load("Card/31.png", Texture.class ,param);
			manager.load("Card/32.png", Texture.class ,param);
			manager.load("Card/33.png", Texture.class ,param);
			manager.load("Card/34.png", Texture.class ,param);
			manager.load("Card/35.png", Texture.class ,param);
			manager.load("Card/36.png", Texture.class ,param);
			manager.load("Card/37.png", Texture.class ,param);
			manager.load("Card/38.png", Texture.class ,param);
			manager.load("Card/39.png", Texture.class ,param);
			manager.load("Card/40.png", Texture.class ,param);
			manager.load("Card/41.png", Texture.class ,param);
			manager.load("Card/42.png", Texture.class ,param);
			manager.load("Card/43.png", Texture.class ,param);
			manager.load("Card/44.png", Texture.class ,param);
			manager.load("Card/45.png", Texture.class ,param);
			manager.load("Card/46.png", Texture.class ,param);
			manager.load("Card/47.png", Texture.class ,param);
			manager.load("Card/48.png", Texture.class ,param);
			manager.load("Card/49.png", Texture.class ,param);
			manager.load("Card/50.png", Texture.class ,param);
			manager.load("Card/51.png", Texture.class ,param);
			manager.load("Card/52.png", Texture.class ,param);
			manager.load("Card/flipbutton.atlas", TextureAtlas.class);
			manager.load("Instruct/instruct_ah.png", Texture.class ,param);
			manager.load("Instruct/instruct_ay.png", Texture.class ,param);
			manager.load("Instruct/instruct_ee.png", Texture.class ,param);
			manager.load("Instruct/instruct_i.png", Texture.class ,param);
			manager.load("Instruct/instruct_iam.png", Texture.class ,param);
			manager.load("Instruct/instruct_oh.png", Texture.class ,param);
			manager.load("Instruct/instruct_ooh.png", Texture.class ,param);
			manager.load("Instruct/instruct_or.png", Texture.class ,param);
		}
	}
*/
	public void loadAll() {
		generator = new FreeTypeFontGenerator(Gdx.files.internal("Font/slab.ttf"));
		generator2 = new FreeTypeFontGenerator(Gdx.files.internal("Font/sans.ttf"));
		font = new FreeTypeFontParameter();

		manager.load("Menu/start.png", Texture.class , param);
		manager.load("Menu/browse.png", Texture.class ,param);
		manager.load("Menu/load.png", Texture.class ,param);
		manager.load("Menu/more_info.png", Texture.class ,param);
		manager.load("Menu/menu_title_background.png", Texture.class ,param);
		manager.load("Menu/menu_title.png", Texture.class, param); 
		manager.load("Menu/menu_author.png", Texture.class, param);	
		manager.load("Menu/menubutton.atlas", TextureAtlas.class);
		
		manager.load("Back/backbutton.atlas", TextureAtlas.class);
		manager.load("Top/top_header.png", Texture.class ,param);
		manager.load("Back/backbuttonsmall.atlas", TextureAtlas.class);
		
		manager.load("Select/select_soundadvice.png", Texture.class ,param);
		manager.load("Select/select_symphony.png", Texture.class ,param);
		manager.load("Select/select_duet.png", Texture.class ,param);
		manager.load("Select/select_heartsong.png", Texture.class ,param);
		manager.load("Select/select_individual.png", Texture.class ,param);
		manager.load("Select/select_multi.png", Texture.class ,param);
		manager.load("Select/select_retuning.png", Texture.class ,param);
		manager.load("Select/select_singingearth.png", Texture.class ,param);
		manager.load("Select/select_angel.png", Texture.class ,param);
		
		manager.load("Style/darkpurp.png", Texture.class ,param);
		manager.load("Style/lightpurp.png", Texture.class ,param);		
		manager.load("Info/startbutton.atlas", TextureAtlas.class);
		manager.load("Info/infocard1.png", Texture.class, param);
		manager.load("Info/infocard2.png", Texture.class, param);
		manager.load("Info/infocard3.png", Texture.class, param);
		manager.load("Info/infocard4.png", Texture.class, param);
		manager.load("Info/infocard5.png", Texture.class,param);
		manager.load("Info/infocard6.png", Texture.class,param);
		manager.load("Info/infocard7.png", Texture.class, param);
		manager.load("Info/infocard8.png", Texture.class,param);
		manager.load("Info/infocard9.png", Texture.class,param);
		
		manager.load("Choose/bigcard.png", Texture.class ,param);
		manager.load("Choose/minicard_bg.png", Texture.class ,param);
		
		manager.load("Reveal/savebutton.atlas", TextureAtlas.class);
		manager.load("Card/1.png", Texture.class, param);
		manager.load("Card/2.png", Texture.class, param);
		manager.load("Card/3.png", Texture.class, param);
		manager.load("Card/4.png", Texture.class, param);
		manager.load("Card/5.png", Texture.class, param);
		manager.load("Card/6.png", Texture.class, param);
		manager.load("Card/7.png", Texture.class, param);
		manager.load("Card/8.png", Texture.class, param);
		manager.load("Card/9.png", Texture.class, param);
		manager.load("Card/10.png", Texture.class, param);
		manager.load("Card/11.png", Texture.class, param);
		manager.load("Card/12.png", Texture.class, param);
		manager.load("Card/13.png", Texture.class, param);
		manager.load("Card/14.png", Texture.class, param);
		manager.load("Card/15.png", Texture.class, param);
		manager.load("Card/16.png", Texture.class, param);
		manager.load("Card/17.png", Texture.class, param);
		manager.load("Card/18.png", Texture.class, param);
		manager.load("Card/19.png", Texture.class, param);
		manager.load("Card/20.png", Texture.class, param);
		manager.load("Card/21.png", Texture.class, param);
		manager.load("Card/22.png", Texture.class, param);
		manager.load("Card/23.png", Texture.class, param);
		manager.load("Card/24.png", Texture.class, param);
		manager.load("Card/25.png", Texture.class, param);
		manager.load("Card/26.png", Texture.class, param);
		manager.load("Card/27.png", Texture.class, param);
		manager.load("Card/28.png", Texture.class, param);
		manager.load("Card/29.png", Texture.class, param);
		manager.load("Card/30.png", Texture.class, param);
		manager.load("Card/31.png", Texture.class, param);
		manager.load("Card/32.png", Texture.class, param);
		manager.load("Card/33.png", Texture.class, param);
		manager.load("Card/34.png", Texture.class, param);
		manager.load("Card/35.png", Texture.class, param);
		manager.load("Card/36.png", Texture.class, param);
		manager.load("Card/37.png", Texture.class, param);
		manager.load("Card/38.png", Texture.class, param);
		manager.load("Card/39.png", Texture.class, param);
		manager.load("Card/40.png", Texture.class, param);
		manager.load("Card/41.png", Texture.class, param);
		manager.load("Card/42.png", Texture.class, param);
		manager.load("Card/43.png", Texture.class, param);
		manager.load("Card/44.png", Texture.class, param);
		manager.load("Card/45.png", Texture.class, param);
		manager.load("Card/46.png", Texture.class, param);
		manager.load("Card/47.png", Texture.class, param);
		manager.load("Card/48.png", Texture.class, param);
		manager.load("Card/49.png", Texture.class, param);
		manager.load("Card/50.png", Texture.class, param);
		manager.load("Card/51.png", Texture.class, param);
		manager.load("Card/52.png", Texture.class, param);
		manager.load("UI/yesbutton.atlas", TextureAtlas.class);
		manager.load("UI/nobutton.atlas", TextureAtlas.class);	
		manager.load("UI/wait.png", Texture.class, param);
		manager.load("Card/flipbutton.atlas", TextureAtlas.class);
		
		
		
		manager.load("Instruct/instruct_ah.png", Texture.class,param);
		manager.load("Instruct/instruct_ay.png", Texture.class,param);
		manager.load("Instruct/instruct_ee.png", Texture.class,param);
		manager.load("Instruct/instruct_i.png", Texture.class,param);
		manager.load("Instruct/instruct_iam.png", Texture.class,param);
		manager.load("Instruct/instruct_oh.png", Texture.class,param);
		manager.load("Instruct/instruct_ooh.png", Texture.class,param);
		manager.load("Instruct/instruct_or.png", Texture.class,param);
		manager.load("Instruct/instruct_ohm.png", Texture.class,param);
		manager.load("Instruct/instruct_angel.png", Texture.class,param);
		manager.load("Card/spread8_1.png", Texture.class ,param);
		manager.load("Card/spread8_2.png", Texture.class ,param);
		manager.load("Card/spread8_3.png", Texture.class ,param);
		manager.load("Card/spread8_4.png", Texture.class ,param);
		manager.load("Card/spread8_5.png", Texture.class ,param);
		manager.load("Card/spread8_6.png", Texture.class ,param);
		manager.load("Card/spread8_7.png", Texture.class ,param);
		manager.load("Card/spread8_8.png", Texture.class ,param);

		
		manager.load("Browse/select_type_down.png", Texture.class ,param);	
		manager.load("Browse/select_type_up.png", Texture.class ,param);
		manager.load("Browse/rootbtn.png", Texture.class ,param);
		manager.load("Browse/sacralbtn.png", Texture.class ,param);
		manager.load("Browse/throatbtn.png", Texture.class ,param);
		manager.load("Browse/heartbtn.png", Texture.class ,param);
		manager.load("Browse/thirdeyebtn.png", Texture.class ,param);
		manager.load("Browse/crownbtn.png", Texture.class ,param);
		manager.load("Browse/solarplexusbtn.png", Texture.class ,param);
		manager.load("Browse/wholebodybtn.png", Texture.class ,param);
		manager.load("Browse/angelcardsbtn.png", Texture.class ,param);

		manager.finishLoading();
	}
}
