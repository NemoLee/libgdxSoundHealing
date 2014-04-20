package com.sound.healing.custom;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.sound.healing.AssetLoader;

public class TopImage extends TextButton{

	private Skin skin;
	private TextButtonStyle styles;
	private FreeTypeFontParameter font;
	private NinePatch temp;
	
	public TopImage(String text, TextButtonStyle style, AtlasRegion atlasRegion, int size, float WIDTH, float HEIGHT) {
		//might change to text button
		super(text, style);
		temp = new NinePatch(atlasRegion, 0, 0, 0, 0);
		skin = new Skin();
		skin.add("top", temp);
		font = new FreeTypeFontParameter();
		font.size = size;
		styles = new TextButtonStyle();
		styles.up = skin.getDrawable("top");
		styles.font = AssetLoader.getInstance().generator.generateFont(font);
		this.setStyle(styles);
		this.setSize(WIDTH, HEIGHT/6);

	}

}
/*
   		atlas_Menu_Button = new TextureAtlas(Gdx.files.internal("Menu/menubutton.atlas"));
		skin_Menu_Button = new Skin();
		skin_Menu_Button.addRegions(atlas_Menu_Button);
		style_menu_startbutton = new TextButtonStyle();
		style_menu_startbutton.up = skin_Menu_Button.getDrawable("menu_button");
		style_menu_startbutton.down = skin_Menu_Button.getDrawable("menu_button_dark");
		font.size = Gdx.graphics.getWidth()/20;
		appFont = generator.generateFont(font);
		style_menu_startbutton.font = appFont;
*/