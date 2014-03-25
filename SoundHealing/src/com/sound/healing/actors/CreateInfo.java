package com.sound.healing.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;
import com.sound.healing.AssetLoader;
import com.sound.healing.custom.MenuButton;
import com.sound.healing.custom.Spread;
import com.sound.healing.screens.ScreenSpec;

public class CreateInfo extends CreateScene{
	
	private MenuButton backButton, startButton;
	private TextButtonStyle style_info_backbutton, style_info_startButton;
	private Image darkPurple, lightPurple, infoCard;
	private BitmapFont titleFont, descriptionFont, descriptionFontAngel, descriptionFontIndividual, descriptionFontMulti;
	private Label labelTitle, labelDescription;
	private FreeTypeFontParameter font, font2, fontAngel, fontIndividual, fontMulti;
	private LabelStyle style, styleAngel, styleIndividual, styleMulti;
	private TextureRegion textureRegion;
	private TextureRegionDrawable textureRegionDrawable;
	
	
	public CreateInfo() {
		setupTop(SceneHandler.getInstance().getSpread().toString());
		setupInfoCards();
		setupDescription();
		setupBottom();
		spec = new ScreenSpec(scene);
	}

	private void setupInfoCards() {
		darkPurple = new Image(AssetLoader.manager.get("Style/darkpurp.png", Texture.class));
		darkPurple.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/3);
		darkPurple.setPosition(0, Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+darkPurple.getHeight()));
		darkPurple.setUserObject(1);
		scene.put((Integer) darkPurple.getUserObject(), darkPurple);
		
		textureRegion = new TextureRegion(AssetLoader.manager.get(SceneHandler.getInstance().getSpread().getInfocard(), Texture.class));
		textureRegionDrawable = new TextureRegionDrawable(textureRegion);
		infoCard = new Image(textureRegionDrawable);
		infoCard.setSize(Gdx.graphics.getWidth()-Gdx.graphics.getWidth()/3, Gdx.graphics.getHeight()/3);
		infoCard.setPosition(Gdx.graphics.getWidth()/6, (Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+infoCard.getHeight())));
		infoCard.setUserObject(3);
		scene.put((Integer) infoCard.getUserObject(), infoCard);
	}

	private void setupDescription() {
		lightPurple = new Image(AssetLoader.manager.get("Style/lightpurp.png", Texture.class));
		lightPurple.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/2);
		lightPurple.setPosition(0, Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+darkPurple.getHeight()+lightPurple.getHeight()));
		lightPurple.setUserObject(2);
		scene.put((Integer) lightPurple.getUserObject(), lightPurple);
		
		font = new FreeTypeFontParameter();
		font.size = Gdx.graphics.getWidth()/17;
		titleFont = AssetLoader.getInstance().generator.generateFont(font);
		labelTitle = new Label(SceneHandler.getInstance().getSpread().toString(), new LabelStyle(titleFont, Color.WHITE));
		labelTitle.setSize(Gdx.graphics.getWidth()/5, Gdx.graphics.getHeight()/20);
		labelTitle.setUserObject(6);
		labelTitle.setPosition(Gdx.graphics.getWidth()/100,  Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/5+darkPurple.getHeight()+Gdx.graphics.getHeight()/30));
		scene.put((Integer) labelTitle.getUserObject(), labelTitle);
	
		font2 = new FreeTypeFontParameter();
		fontAngel = new FreeTypeFontParameter();
		fontIndividual = new FreeTypeFontParameter();
		fontMulti = new FreeTypeFontParameter();
		font2.size = Gdx.graphics.getWidth()/25;
		fontAngel.size = Gdx.graphics.getWidth()/28;
		fontIndividual.size = Gdx.graphics.getWidth()/35;
		fontMulti.size = Gdx.graphics.getWidth()/28;
		descriptionFont = AssetLoader.getInstance().generator.generateFont(font2);
		descriptionFontAngel = AssetLoader.getInstance().generator.generateFont(fontAngel);
		descriptionFontIndividual = AssetLoader.getInstance().generator.generateFont(fontIndividual);
		descriptionFontMulti = AssetLoader.getInstance().generator.generateFont(fontMulti);
		style = new LabelStyle(descriptionFont, Color.WHITE);
		styleAngel = new LabelStyle(descriptionFontAngel, Color.WHITE);
		styleIndividual = new LabelStyle(descriptionFontIndividual, Color.WHITE);
		styleMulti = new LabelStyle(descriptionFontMulti, Color.WHITE);
		

		labelDescription = new Label(SceneHandler.getInstance().getSpread().getInfoDescription(), getStyle());
		labelDescription.setWrap(true);
		labelDescription.setAlignment(Align.top | Align.left, Align.left);
		labelDescription.setSize(Gdx.graphics.getWidth()-Gdx.graphics.getWidth()/200, Gdx.graphics.getHeight()/6);
		labelDescription.setUserObject(7);
		labelDescription.setPosition(Gdx.graphics.getWidth()/100,  Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/4+darkPurple.getHeight()+Gdx.graphics.getHeight()/7));
		scene.put((Integer) labelDescription.getUserObject(), labelDescription);
		
	}

	private void setupBottom() {
		
		style_info_backbutton = createTextButtonStyle("Back/backbuttonsmall.atlas","backbuttonsmall","backbuttonsmall_dark", Gdx.graphics.getWidth()/14);
		
		backButton = new MenuButton("",style_info_backbutton,0,0,Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/7);
		backButton.setUserObject(4);
	    scene.put((Integer) backButton.getUserObject(), backButton);
	    
	    style_info_startButton = createTextButtonStyle("Info/startbutton.atlas","startbutton","startbutton_dark", Gdx.graphics.getWidth()/14);
		
	    startButton = new MenuButton("",style_info_startButton,Gdx.graphics.getWidth()/2,0,Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/7);
	    startButton.setUserObject(5);
	    scene.put((Integer) startButton.getUserObject(), startButton);
		
	}

	public void reset() {
		topImage.setText(SceneHandler.getInstance().getSpread().toString());
		textureRegion.setTexture(AssetLoader.manager.get(SceneHandler.getInstance().getSpread().getInfocard(), Texture.class));
		
		textureRegionDrawable.setRegion(textureRegion);
		infoCard.setDrawable(textureRegionDrawable);
		labelTitle.setText(SceneHandler.getInstance().getSpread().toString());
		labelDescription.setText(SceneHandler.getInstance().getSpread().getInfoDescription());
		labelDescription.setStyle(getStyle());
	}

	private LabelStyle getStyle() {
		switch(SceneHandler.getInstance().getSpread()){
		case ANGELS_OF_SOUND:
			return styleAngel;
		case INDIVIDUAL:
			return styleIndividual;
		case MULTI:
			return styleMulti;
		default:
			
			return style;
		}
	}
	

}
