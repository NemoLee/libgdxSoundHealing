package com.sound.healing.actors;

import java.util.StringTokenizer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;
import com.sound.healing.AssetLoader;
import com.sound.healing.custom.BackButton;
import com.sound.healing.custom.MenuButton;
import com.sound.healing.custom.Spread;
import com.sound.healing.screens.ScreenSpec;

public class CreateInfo extends CreateScene{
	
	BackButton backButton;
	private BackButton startButton;
	ButtonStyle style_info_backbutton;
	private ButtonStyle style_info_startButton;
	ButtonStyle style_menu_startbutton;
	private Image darkPurple, lightPurple, infoCard, cardPurpose, scrollbackground, scrollbar;
	private BitmapFont titleFont, descriptionFont;
	private Label labelTitle;
	private LabelStyle style;
	private TextureRegion textureRegion;
	private TextureRegionDrawable textureRegionDrawable;
	private Image[] cardImages;
	private Label[] descriptions;
	private Table table, container;
	private ScrollPane scroll;
	
	
	public CreateInfo() {
		setupTop(SceneHandler.getInstance().getSpread().toString());
		setupInfoCards();
		setupDescription();
		setupBottom();
		setupBackButton();
		spec = new ScreenSpec(scene);
	}

	private void setupInfoCards() {
		darkPurple = new Image(allAtlas.findRegion("darkpurp"));
		darkPurple.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/3);
		darkPurple.setPosition(0, Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+darkPurple.getHeight()));
		darkPurple.setUserObject(1);
		scene.add(darkPurple);
		
		textureRegion = new TextureRegion(allAtlas.findRegion(SceneHandler.getInstance().getSpread().getInfocard()));
		textureRegionDrawable = new TextureRegionDrawable(textureRegion);
		infoCard = new Image(textureRegionDrawable);
		infoCard.setSize((float) ((Gdx.graphics.getHeight()/4+Gdx.graphics.getHeight()/30)*1.635), Gdx.graphics.getHeight()/4+Gdx.graphics.getHeight()/30);
		infoCard.setPosition((Gdx.graphics.getWidth()-infoCard.getWidth())/2, (Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/4+infoCard.getHeight())+Gdx.graphics.getWidth()/12));
		infoCard.setUserObject(2);
		scene.add(infoCard);
	}

	private void setupDescription() {
		
		lightPurple = new Image(allAtlas.findRegion("lightpurp"));
		lightPurple.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/2);
		lightPurple.setPosition(0, Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+darkPurple.getHeight()+lightPurple.getHeight()));
		lightPurple.setUserObject(3);
		scene.add(lightPurple);
		scrollbackground = new Image(allAtlas.findRegion("scrollpanel"));
		scrollbackground.setSize(Gdx.graphics.getWidth()/60, Gdx.graphics.getHeight()-darkPurple.getHeight()-2*(Gdx.graphics.getHeight()/7)-Gdx.graphics.getHeight()/40);
		scrollbackground.setPosition(Gdx.graphics.getWidth()-scrollbackground.getWidth(), Gdx.graphics.getHeight()/7);
		scrollbackground.setUserObject(4);
		scene.add(scrollbackground);
		
		scrollbar = new Image(allAtlas.findRegion("scrollbar"));
		scrollbar.setSize(Gdx.graphics.getWidth()/70, Gdx.graphics.getHeight()/20);
		scrollbar.setPosition(Gdx.graphics.getWidth()-scrollbar.getWidth(), Gdx.graphics.getHeight()/7+scrollbackground.getHeight()-scrollbar.getHeight());
		scrollbar.setUserObject(5);
		scene.add(scrollbar);
		

		descriptionFont = AssetLoader.getInstance().sans;
		style = new LabelStyle(descriptionFont, Color.WHITE);

		table = new Table();
		container = new Table();
		//table.setBounds(0, 0, Gdx.graphics.getWidth(),(Gdx.graphics.getHeight()/7));
		scroll = new ScrollPane(table);
		container.add(scroll).width(Gdx.graphics.getWidth()).height(Gdx.graphics.getHeight()-(topImage.getHeight()+Gdx.graphics.getHeight()/7+darkPurple.getHeight()));
		container.row();
		container.setUserObject(6);
		container.setBounds(0, Gdx.graphics.getHeight()/7, Gdx.graphics.getWidth(),Gdx.graphics.getHeight()-(topImage.getHeight()+Gdx.graphics.getHeight()/7+darkPurple.getHeight()));
		
		table.top();
		
		//font = new FreeTypeFontParameter();
		//font.size = Gdx.graphics.getWidth()/17;
		titleFont = AssetLoader.getInstance().smallSlab;
		labelTitle = new Label("CARD PURPOSES", new LabelStyle(titleFont, Color.WHITE));
		labelTitle.setUserObject(7);
		labelTitle.setAlignment(Align.center);
		labelTitle.setPosition(Gdx.graphics.getWidth()/50,  Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/5+darkPurple.getHeight()+Gdx.graphics.getHeight()/30));
		cardPurpose = new Image(allAtlas.findRegion("medpurp"));
		cardPurpose.setAlign(Align.center);
		table.add(cardPurpose).size(Gdx.graphics.getWidth()/3+Gdx.graphics.getWidth()/15, labelTitle.getPrefHeight()+Gdx.graphics.getWidth()/15).align(Align.center).padTop(Gdx.graphics.getHeight()/25);
		table.add(labelTitle).align(Align.center).padLeft(-Gdx.graphics.getWidth()).padTop(Gdx.graphics.getHeight()/25);
		table.row();
		table.add().size(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/100);
		table.row();
		//hg = new HorizontalGroup[SceneHandler.getInstance().getSpread().getNumberOfCards()];
		cardImages = new Image[SceneHandler.getInstance().getSpread().getNumberOfCards()];
		descriptions = new Label[SceneHandler.getInstance().getSpread().getNumberOfCards()];
		StringTokenizer string = new StringTokenizer(SceneHandler.getInstance().getSpread().getInfoDescription(), "\n");
		for(int i = 0; i < SceneHandler.getInstance().getSpread().getNumberOfCards(); i++){
			cardImages[i] = new Image(allAtlas.findRegion("card"+(i+1)));
			cardImages[i].setAlign(Align.left);
			cardImages[i].setSize(Gdx.graphics.getWidth()/8, Gdx.graphics.getWidth()/6);
			descriptions[i] = new Label(string.nextToken(), new LabelStyle(getStyle()));
			descriptions[i].setSize(Gdx.graphics.getWidth(), descriptions[i].getPrefHeight());
			descriptions[i].setWrap(true);
			descriptions[i].setAlignment(Align.left);
			
			table.add(cardImages[i]).size(Gdx.graphics.getWidth()/8, Gdx.graphics.getWidth()/6).align(Align.left).padLeft(Gdx.graphics.getWidth()/20).padTop(Gdx.graphics.getHeight()/20);
			table.add(descriptions[i]).size(Gdx.graphics.getWidth()/2+Gdx.graphics.getWidth()/4, descriptions[i].getPrefHeight()).padLeft(-Gdx.graphics.getWidth()+Gdx.graphics.getWidth()/8).padTop(Gdx.graphics.getHeight()/20);
			table.row();
		}
		
		scene.add(container);
	}

	private void setupBottom() {
		
		style_info_backbutton = createImageButtonStyle("Back/backbuttonsmall.atlas","backbuttonsmall","backbuttonsmall_dark");
		
		backButton = new BackButton(style_info_backbutton,0,0,Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/7);
		backButton.setUserObject(7);
	    scene.add(backButton);
	    
	    style_info_startButton = createImageButtonStyle("Info/startbutton.atlas","startbutton","startbutton_dark");
		
	    startButton = new BackButton(style_info_startButton,Gdx.graphics.getWidth()/2,0,Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/7);
	    startButton.setUserObject(8);
	    scene.add(startButton);
		
	}
	
	private void setupBackButton() {
		style_menu_startbutton = createImageButtonStyle("Back/backbutton.atlas","backbutton","backbutton_dark");
		
	    //Start button
		backButton = new BackButton(style_menu_startbutton,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/7);
		backButton.setUserObject(9);
		backButton.setVisible(false);
	    scene.add(backButton);
		
		
	}

	@Override
	public void reset() {
		
		table = null;
		container = null;
		scroll = null;
		cardImages = null;
		descriptions = null;
		
		
		table = new Table();
		container = new Table();
		//table.setBounds(0, 0, Gdx.graphics.getWidth(),(Gdx.graphics.getHeight()/7));
		scroll = new ScrollPane(table);
		container.add(scroll).width(Gdx.graphics.getWidth()).height(Gdx.graphics.getHeight()-(topImage.getHeight()+Gdx.graphics.getHeight()/7+darkPurple.getHeight()));
		container.row();
		container.setUserObject(6);
		container.setBounds(0, Gdx.graphics.getHeight()/7, Gdx.graphics.getWidth(),Gdx.graphics.getHeight()-(topImage.getHeight()+Gdx.graphics.getHeight()/7+darkPurple.getHeight()));
		
		table.top();
		
		table.add(cardPurpose).size(Gdx.graphics.getWidth()/3+Gdx.graphics.getWidth()/15, labelTitle.getPrefHeight()+Gdx.graphics.getWidth()/15).align(Align.center).padTop(Gdx.graphics.getHeight()/25);
		table.add(labelTitle).align(Align.center).padLeft(-Gdx.graphics.getWidth()).padTop(Gdx.graphics.getHeight()/25);
		table.row();
		table.add().size(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/100);
		table.row();
		
		cardImages = new Image[SceneHandler.getInstance().getSpread().getNumberOfCards()];
		descriptions = new Label[SceneHandler.getInstance().getSpread().getNumberOfCards()];
		StringTokenizer string = new StringTokenizer(SceneHandler.getInstance().getSpread().getInfoDescription(), "\n");
		for(int i = 0; i < SceneHandler.getInstance().getSpread().getNumberOfCards(); i++){
			cardImages[i] = new Image(allAtlas.findRegion("card"+(i+1)));
			cardImages[i].setAlign(Align.left);
			cardImages[i].setSize(Gdx.graphics.getWidth()/8, Gdx.graphics.getWidth()/6);
			descriptions[i] = new Label(string.nextToken(), new LabelStyle(getStyle()));
			descriptions[i].setSize(Gdx.graphics.getWidth(), descriptions[i].getPrefHeight());
			descriptions[i].setWrap(true);
			descriptions[i].setAlignment(Align.left);
			
			table.add(cardImages[i]).size(Gdx.graphics.getWidth()/8, Gdx.graphics.getWidth()/6).align(Align.left).padLeft(Gdx.graphics.getWidth()/20).padTop(Gdx.graphics.getHeight()/20);
			table.add(descriptions[i]).size(Gdx.graphics.getWidth()/2+Gdx.graphics.getWidth()/4, descriptions[i].getPrefHeight()).padLeft(-Gdx.graphics.getWidth()+Gdx.graphics.getWidth()/8).padTop(Gdx.graphics.getHeight()/20);
			table.row();
		}
		
		scene.set(6,container);
		topImage.setText(SceneHandler.getInstance().getSpread().toString());
		textureRegion.setRegion(allAtlas.findRegion(SceneHandler.getInstance().getSpread().getInfocard()));
		textureRegionDrawable.setRegion(textureRegion);
		infoCard.setDrawable(textureRegionDrawable);
	}

	private LabelStyle getStyle() {
		return style;
	}
	

}
