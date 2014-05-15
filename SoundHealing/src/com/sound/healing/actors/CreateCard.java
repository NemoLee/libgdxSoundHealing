package com.sound.healing.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane.SplitPaneStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.sound.healing.AssetLoader;
import com.sound.healing.cards.AllCards;
import com.sound.healing.cards.CardEnum;
import com.sound.healing.cards.CardType;
import com.sound.healing.custom.BackButton;
import com.sound.healing.custom.MenuButton;
import com.sound.healing.screens.ScreenSpec;

public class CreateCard extends CreateScene{
	
	private Image largeCard, sound1, sound2;
	private ButtonStyle style_info_flipButton, style_info_backbutton;
	private BackButton backButton;
	private BackButton flipButton;
	private TextureRegion textureRegion, textureRegion2;
	private TextureRegionDrawable textureRegionDrawable, textureRegionDrawable2;
	private Table table, container;
	private ScrollPane scroll;
	private Label labelDescription, labelInfo;
	private FreeTypeFontParameter font2, font3;
	private LabelStyle style, style2;
	private BitmapFont descriptionFont, descriptionInfo;
	private HorizontalGroup hg;
	
	public CreateCard() {
		setupCard();
		setupBottom();
		setupCardBack();
		spec = new ScreenSpec(scene);
	}


	private void setupCard() {
		
		textureRegion = new TextureRegion(AssetLoader.manager.get("Card/cardsheet.atlas", TextureAtlas.class).findRegion((String)""+AllCards.getInstance().getCurrentCard().getCardSpec().getCardProperty(CardEnum.ID.getEnumID())));
		textureRegionDrawable = new TextureRegionDrawable(textureRegion);
		largeCard = new Image(textureRegionDrawable);
		largeCard.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/7);
		largeCard.setPosition(0, Gdx.graphics.getHeight()/7);
		largeCard.setUserObject(0);
		scene.add(largeCard);
		
	}
	
	private void setupBottom() {
		
		
		style_info_backbutton = createImageButtonStyle("Back/backbuttonsmall.atlas","backbuttonsmall","backbuttonsmall_dark");
		
		backButton = new BackButton(style_info_backbutton,0,0,Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/7);
		backButton.setUserObject(1);
	    scene.add(backButton);
	    
	    style_info_flipButton = createImageButtonStyle("Card/flipbutton.atlas","flipbutton","flipbutton_dark");
		
	    flipButton = new BackButton(style_info_flipButton,Gdx.graphics.getWidth()/2,0,Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/7);
	    flipButton.setUserObject(2);
	    scene.add(flipButton);
	    
	}
	
	private void setupCardBack() {
		
		table = new Table();
		container = new Table();
		//table.setBounds(0, 0, Gdx.graphics.getWidth(), 9*(Gdx.graphics.getHeight()/6));
		scroll = new ScrollPane(table);
		container.add(scroll).width(Gdx.graphics.getWidth()).height(Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/7);
		container.row();
		container.setUserObject(3);
		container.setBounds(0, Gdx.graphics.getHeight()/7, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/7);
		container.setBackground(new TextureRegionDrawable(new TextureRegion(allAtlas.findRegion("lightpurp"))));
		
		descriptionFont = AssetLoader.getInstance().smallSlab;
		descriptionInfo = AssetLoader.getInstance().sans;
		style = new LabelStyle(descriptionFont, Color.WHITE);
		style2 = new LabelStyle(descriptionInfo, Color.WHITE);
		
		
		labelDescription = new Label("\nDESCRIPTION:\n",style);
		//labelDescription.setAlignment(Align.top | Align.left, Align.left);
		//labelDescription.setWrap(true);
		labelDescription.setPosition(0,  Gdx.graphics.getHeight());
		table.top();
	    table.add(labelDescription);
	    table.row();
		
	    labelInfo = new Label((String) AllCards.getInstance().getCurrentCard().getCardSpec().getCardProperty(CardEnum.DESCRIPTION.getEnumID()), style2);
	    labelInfo.setWrap(true);
	    labelInfo.setAlignment(Align.top | Align.left, Align.left);
	    labelInfo.setSize(Gdx.graphics.getWidth()-Gdx.graphics.getWidth()/50, Gdx.graphics.getHeight()/2+Gdx.graphics.getWidth()/16);
	    labelInfo.setUserObject(4);
	    labelInfo.setPosition(0,  Gdx.graphics.getHeight()/2);
		//scene.put((Integer) labelDescription.getUserObject(), labelDescription);
	    table.add(labelInfo).padLeft(Gdx.graphics.getWidth()/50).padRight(Gdx.graphics.getWidth()/50).size(Gdx.graphics.getWidth()-Gdx.graphics.getWidth()/25,labelInfo.getPrefHeight());
	    table.row();
	   
	    sound1 = new Image(allAtlas.findRegion("instruct_i"));
	    sound1.setSize(Gdx.graphics.getWidth()/4, Gdx.graphics.getWidth()/4);
	    sound1.setPosition(Gdx.graphics.getWidth()/8, 0);
	    sound1.setUserObject(5);
	    
	    textureRegion2 = new TextureRegion(allAtlas.findRegion(((CardType) AllCards.getInstance().getCurrentCard().getCardSpec().getCardProperty(CardEnum.TYPE.getEnumID())).getSoundID()));
	    textureRegionDrawable2 = new TextureRegionDrawable(textureRegion2);
	    textureRegionDrawable2.setMinWidth(Gdx.graphics.getHeight()/4);
	    textureRegionDrawable2.setMinHeight(Gdx.graphics.getWidth()/4);
	    sound2 = new Image(textureRegionDrawable2);
	    sound2.setSize(Gdx.graphics.getWidth()/4, Gdx.graphics.getWidth()/4);
	    sound2.setPosition((Gdx.graphics.getWidth()/8)*5, 0);
	    sound2.setUserObject(6);
	    
	    
	    hg = new HorizontalGroup();
	    hg.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/7);
	    hg.setLayoutEnabled(false);
	    hg.addActor(sound1);
	    hg.addActor(sound2);
	    table.add(hg).size(Gdx.graphics.getWidth(), hg.getPrefHeight()+Gdx.graphics.getWidth()/18);
	    table.row();
	    table.add().size(Gdx.graphics.getWidth(), Gdx.graphics.getWidth()/18);
	    container.setVisible(false);
	    scene.add(container);
	   
	    
	}
	
	@Override
	public void reset(){
		textureRegion = new TextureRegion(AssetLoader.manager.get("Card/cardsheet.atlas", TextureAtlas.class).findRegion((String)""+ AllCards.getInstance().getCurrentCard().getCardSpec().getCardProperty(CardEnum.ID.getEnumID())));
		textureRegionDrawable.setRegion(textureRegion);
		largeCard.setDrawable(textureRegionDrawable);
		labelInfo.setText((String) AllCards.getInstance().getCurrentCard().getCardSpec().getCardProperty(CardEnum.AFFIRMATION.getEnumID())+"\n\n"+AllCards.getInstance().getCurrentCard().getCardSpec().getCardProperty(CardEnum.DESCRIPTION.getEnumID()));
		table.getCell(labelInfo).size(Gdx.graphics.getWidth()-Gdx.graphics.getWidth()/25, labelInfo.getPrefHeight());
		scroll.setScrollY(0);
		textureRegion2.setRegion(allAtlas.findRegion(((CardType) AllCards.getInstance().getCurrentCard().getCardSpec().getCardProperty(CardEnum.TYPE.getEnumID())).getSoundID()));
		textureRegionDrawable2.setRegion(textureRegion2);
		sound2.setDrawable(textureRegionDrawable2);
		//System.out.println(labelDescription.getPrefHeight());
	}
	
	

}
