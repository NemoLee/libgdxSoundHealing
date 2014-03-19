package com.sound.healing;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class AssetLoader {
	
	
	public Texture texture_Menu_Button;
	private TextureAtlas atlas_Menu_Button;
	private Skin skin_Menu_Button;
	public TextButtonStyle style_menu_startbutton;
	public Texture texture_Menu_Title_Background;
	public Texture texture_Menu_Title;
	public Texture texture_Menu_Author;
	private BitmapFont appFont;
	private static final AssetLoader INSTANCE = new AssetLoader();


	public static AssetLoader getInstance() {
		
		return INSTANCE;
	}
	
	public void loadMainMenu() {
		texture_Menu_Title_Background = new Texture(Gdx.files.internal("Menu/menu_title_background.png"));
		texture_Menu_Title = new Texture(Gdx.files.internal("Menu/menu_title.png"));
		texture_Menu_Author = new Texture(Gdx.files.internal("Menu/menu_author.png"));
		texture_Menu_Title_Background.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		texture_Menu_Title.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		texture_Menu_Author.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		atlas_Menu_Button = new TextureAtlas(Gdx.files.internal("Menu/menubutton.atlas"));
		skin_Menu_Button = new Skin();
		skin_Menu_Button.addRegions(atlas_Menu_Button);
		style_menu_startbutton = new TextButtonStyle();
		style_menu_startbutton.up = skin_Menu_Button.getDrawable("menu_button");
		style_menu_startbutton.down = skin_Menu_Button.getDrawable("menu_button_dark");
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Font/slab.ttf"));
		FreeTypeFontParameter f = new FreeTypeFontParameter();
		f.size = 35;
		appFont = generator.generateFont(f);
		style_menu_startbutton.font = appFont;
	}
	
	
	public void unLoadMainMenu() {
		texture_Menu_Title_Background.dispose();
		texture_Menu_Title.dispose();
		texture_Menu_Author.dispose();
		texture_Menu_Title_Background = null;
		texture_Menu_Title = null;
		texture_Menu_Author = null;
	}
	

}
