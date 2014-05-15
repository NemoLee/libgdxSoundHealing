package com.sound.healing.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.sound.healing.AssetLoader;
import com.sound.healing.cards.AllCards;
import com.sound.healing.cards.CardEnum;
import com.sound.healing.custom.MenuButton;
import com.sound.healing.screens.ScreenSpec;

public class CreateMoreInfoSub extends CreateScene{
	
	private MenuButton backButton;
	private TextButtonStyle style_menu_startbutton;
	private Table table, container;
	private ScrollPane scroll;
	private Label labelDescription, labelInfo;
	private FreeTypeFontParameter font2, font3;
	private LabelStyle style, style2;
	private BitmapFont descriptionFont, descriptionInfo;
	
	
	public CreateMoreInfoSub() {
		setupTop(SceneHandler.getInstance().getMoreInfo().toString());
		setupDescription();
		setupBackButton();
		spec = new ScreenSpec(scene);
	}
	
	
	private void setupDescription() {
		table = new Table();
		container = new Table();
	//	table.setBounds(0, 0, Gdx.graphics.getWidth(), 5*(Gdx.graphics.getHeight()/6));
		scroll = new ScrollPane(table);
		container.add(scroll).width(Gdx.graphics.getWidth()).height(Gdx.graphics.getHeight()-(topImage.getHeight()+Gdx.graphics.getHeight()/7));
		container.row();
		container.setUserObject(1);
		container.setBounds(0, Gdx.graphics.getHeight()/7, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()-(topImage.getHeight()+Gdx.graphics.getHeight()/7));
		container.setBackground(new TextureRegionDrawable(new TextureRegion(allAtlas.findRegion("lightpurp"))));
		
		font2 = new FreeTypeFontParameter();
		font2.size = Gdx.graphics.getWidth()/16;
		font3 = new FreeTypeFontParameter();
		font3.size = Gdx.graphics.getWidth()/24;
		
		descriptionFont = AssetLoader.getInstance().generator.generateFont(font2);
		descriptionInfo = AssetLoader.getInstance().generator2.generateFont(font3);
		style = new LabelStyle(descriptionFont, Color.WHITE);
		style2 = new LabelStyle(descriptionInfo, Color.WHITE);
		
		
		labelDescription = new Label("\nDESCRIPTION:\n",style);
		//labelDescription.setAlignment(Align.top | Align.left, Align.left);
		//labelDescription.setWrap(true);
		labelDescription.setPosition(0,  Gdx.graphics.getHeight());
		table.top();
	    table.add(labelDescription);
	    table.row();
		
	    labelInfo = new Label(SceneHandler.getInstance().getMoreInfo().getDescription(), style2);
	    labelInfo.setWrap(true);
	    labelInfo.setAlignment(Align.top | Align.left, Align.left);
	    labelInfo.setSize(Gdx.graphics.getWidth()-Gdx.graphics.getWidth()/50, Gdx.graphics.getHeight()/2+Gdx.graphics.getWidth()/16);
	    labelInfo.setUserObject(4);
	    labelInfo.setPosition(0,  Gdx.graphics.getHeight()/2);
		//scene.put((Integer) labelDescription.getUserObject(), labelDescription);
	    table.add(labelInfo).padLeft(Gdx.graphics.getWidth()/50).padRight(Gdx.graphics.getWidth()/50).size(Gdx.graphics.getWidth()-Gdx.graphics.getWidth()/25,labelInfo.getPrefHeight());
	    table.row();
		
		
		
		
		scene.add(container);
	}


	private void setupBackButton() {
		style_menu_startbutton = createTextButtonStyle("Back/backbutton.atlas","backbutton","backbutton_dark", Gdx.graphics.getWidth()/14);
		
	    //Start button
		backButton = new MenuButton("",style_menu_startbutton,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/7);
		backButton.setUserObject(2);
	    scene.add(backButton);
		
		
	}
	
	@Override
	public void reset() {
		topImage.setText(SceneHandler.getInstance().getMoreInfo().toString());
		labelInfo.setText(SceneHandler.getInstance().getMoreInfo().getDescription());
		//System.out.println(labelInfo.getPrefHeight());
		table.getCell(labelInfo).size(Gdx.graphics.getWidth()-Gdx.graphics.getWidth()/25, labelInfo.getPrefHeight());
		scroll.setScrollY(0);
	}
	
}
