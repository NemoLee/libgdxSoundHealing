package com.sound.healing;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
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
	public Texture texture_Menu_Button, texture_Back_Button;
	private TextureAtlas atlas_Menu_Button, atlas_Back_Button;
	private Skin skin_Menu_Button, skin_Back_Button;
	public TextButtonStyle style_menu_startbutton;
	public ButtonStyle style_Back_Button;
	public Texture texture_Menu_Title_Background;
	public Texture texture_Menu_Title;
	public Texture texture_Menu_Author;
	public Texture texture_SpreadSelect_Title;
	public FreeTypeFontGenerator generator;
	public FreeTypeFontParameter font;
	public BitmapFont appFont;
	public TopImage topImage;
	public float WIDTH, HEIGHT;
	public MenuButton startButton, browseButton, loadButton, moreinfoButton;
	public Image image_Menu_Title_Background, image_Menu_Author, image_Menu_Title;
	
	private static final AssetLoader INSTANCE = new AssetLoader();


	public static AssetLoader getInstance() {
		
		return INSTANCE;
	}
	
	public void loadFont(){
		generator = new FreeTypeFontGenerator(Gdx.files.internal("Font/slab.ttf"));
		font = new FreeTypeFontParameter();
	}
	
	public void loadMainMenu() {
		//menu textures
		if(!manager.isLoaded("Menu/menubutton.atlas")){
		manager.load("Menu/menu_title_background.png", Texture.class);
		manager.load("Menu/menu_title.png", Texture.class); 
		manager.load("Menu/menu_author.png", Texture.class);
		manager.load("Menu/menubutton.atlas", TextureAtlas.class);
		manager.finishLoading();
		}
	}
	

	
	public void unloadMainMenu() {
		texture_Menu_Title_Background.dispose();
		texture_Menu_Title.dispose();
		texture_Menu_Author.dispose();
		atlas_Menu_Button.dispose();
		skin_Menu_Button.dispose();
		texture_Menu_Title_Background = null;
		texture_Menu_Title = null;
		texture_Menu_Author = null;
		atlas_Menu_Button = null;
		skin_Menu_Button = null;
		style_menu_startbutton = null;
	}
	
	public void loadSpreadSelect(){
		if(!manager.isLoaded("Select/select_angel.png")){
		manager.load("Back/backbutton.atlas", TextureAtlas.class);
		manager.load("Top/top_header.png", Texture.class);
		manager.load("Select/select_soundadvice.png", Texture.class);
		manager.load("Select/select_symphony.png", Texture.class);
		manager.load("Select/select_duet.png", Texture.class);
		manager.load("Select/select_heartsong.png", Texture.class);
		manager.load("Select/select_individual.png", Texture.class);
		manager.load("Select/select_multi.png", Texture.class);
		manager.load("Select/select_retuning.png", Texture.class);
		manager.load("Select/select_singingearth.png", Texture.class);
		manager.load("Select/select_angel.png", Texture.class);
		manager.finishLoading();
		}
	}
	
	
	public void unloadSpreadSelect(){
		
	}
	

}
