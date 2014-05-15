package com.sound.healing.actors;

import java.util.HashMap;
import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.TimeUtils;
import com.sound.healing.AssetLoader;
import com.sound.healing.custom.TopImage;
import com.sound.healing.screens.ScreenSpec;

public class CreateScene {

	protected ScreenSpec spec;
	protected LinkedList<Actor> scene;
	protected TopImage topImage;
	protected TextureAtlas allAtlas;
	private Skin skin;
	private TextButtonStyle styles;
	private FreeTypeFontParameter font;
	private TextureRegion textureRegion = null;
	
	
	public CreateScene() {
		allAtlas = AssetLoader.manager.get("All/all.atlas", TextureAtlas.class);
		scene = new LinkedList<Actor>();
	}
	
	public ScreenSpec getSpec() {
		return spec;
	}
	
	protected void setupTop(String title) {	
		skin = new Skin();
		textureRegion = new TextureRegion(allAtlas.findRegion("top_header"));
		skin.add("top", textureRegion);
		styles = new TextButtonStyle();
		styles.up = skin.getDrawable("top");
		styles.font = AssetLoader.getInstance().slab;
		topImage = new TopImage(title, styles);
		topImage.setPosition(0, Gdx.graphics.getHeight()-topImage.getHeight());
		topImage.setUserObject(0);
		scene.add(topImage);	
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
	
	protected ButtonStyle createImageButtonStyle(String Atlas, String up, String down){
		TextureAtlas textAtlas = AssetLoader.manager.get(Atlas, TextureAtlas.class);	
		Skin skin = new Skin();
		skin.addRegions(textAtlas);
		ButtonStyle style = new ButtonStyle();
		style.up = skin.getDrawable(up);
		style.down = skin.getDrawable(down);
		return style;
	}

	public void reset() {
		
		
	}
	
}
