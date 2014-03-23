package com.sound.healing.actors;

import java.util.HashMap;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.sound.healing.AssetLoader;
import com.sound.healing.screens.ScreenSpec;

public class CreateScene {

	protected ScreenSpec spec;
	protected HashMap<Integer, Actor> scene;
	
	public CreateScene() {
		scene = new HashMap<Integer, Actor>();
	}
	
	public ScreenSpec getSpec() {
		return spec;
	}
	
	
	protected TextButtonStyle createTextButtonStyle(String Atlas, String up, String down, int fontSize) {
		TextureAtlas textAtlas = AssetLoader.manager.get(Atlas, TextureAtlas.class);	
		Skin skin = new Skin();
		skin.addRegions(textAtlas);
		TextButtonStyle style = new TextButtonStyle();
		style.up = skin.getDrawable(up);
		style.down = skin.getDrawable(down);
		AssetLoader.getInstance().font.size = fontSize;
		BitmapFont appFont = AssetLoader.getInstance().generator.generateFont(AssetLoader.getInstance().font);
		style.font = appFont;
		return style;
	}
	
	protected ImageButtonStyle createImageButtonStyle(String Atlas, String up, String down){
		TextureAtlas textAtlas = AssetLoader.manager.get(Atlas, TextureAtlas.class);	
		Skin skin = new Skin();
		skin.addRegions(textAtlas);
		ImageButtonStyle style = new ImageButtonStyle();
		style.up = skin.getDrawable(up);
		style.down = skin.getDrawable(down);
		return style;
	}
	
}