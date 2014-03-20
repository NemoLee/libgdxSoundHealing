package com.sound.healing.custom;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.sound.healing.AssetLoader;

public class TopImage extends Label{

	private Skin skin;
	private LabelStyle styles;
	private FreeTypeFontParameter font;
	private NinePatch temp;
	
	public TopImage(CharSequence text, LabelStyle style, Texture image, int size) {
		super(text, style);
		temp = new NinePatch(image, 0, 0, 0, 0);
		skin = new Skin();
		skin.add("top", temp);
		font = new FreeTypeFontParameter();
		font.size = size;
		styles = new LabelStyle();
		styles.background = skin.getDrawable("top");
		styles.font = AssetLoader.getInstance().generator.generateFont(font);
		this.setStyle(styles);
		
	}

}
