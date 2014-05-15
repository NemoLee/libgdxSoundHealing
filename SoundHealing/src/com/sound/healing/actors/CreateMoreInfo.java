package com.sound.healing.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.sound.healing.custom.MenuButton;
import com.sound.healing.custom.SelectImageButton;
import com.sound.healing.screens.ScreenSpec;

public class CreateMoreInfo extends CreateScene{
	
	private SelectImageButton intro, sounds, meanings, suits, using;
	private MenuButton backButton;
	private TextButtonStyle style_menu_startbutton;
	private ButtonStyle style;
	private Table table, container;
	private ScrollPane scroll;
	
	public CreateMoreInfo() {
		setupTop("MORE INFO");
		setupMenuButtons();
		setupBackButton();
		spec = new ScreenSpec(scene);
	}
	
	private void setupMenuButtons() {
		

		style = createImageButtonStyle("Menu/menubutton.atlas","menu_button","menu_button_dark");
		Image image;
		TextureRegion textureRegion;
		TextureRegionDrawable textureRegionDrawable;
		
		table = new Table();
		container = new Table();
		table.setBounds(0, 0, Gdx.graphics.getWidth(), 5*(Gdx.graphics.getHeight()/6));
		scroll = new ScrollPane(table);
		container.add(scroll).width(Gdx.graphics.getWidth()).height(Gdx.graphics.getHeight()-(topImage.getHeight()+Gdx.graphics.getHeight()/7));
		container.row();
		container.setUserObject(1);
		container.setBounds(0, Gdx.graphics.getHeight()/7, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()-(topImage.getHeight()+Gdx.graphics.getHeight()/7));
		container.setBackground(new TextureRegionDrawable(new TextureRegion(allAtlas.findRegion("darkpurp"))));
		
		
		
	    intro = new SelectImageButton(style,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
	    intro.setUserObject(3);
	    textureRegion = new TextureRegion(allAtlas.findRegion("intro"));
	    textureRegionDrawable = new TextureRegionDrawable(textureRegion);
	    textureRegionDrawable.setMinWidth(Gdx.graphics.getWidth()/4);
	    textureRegionDrawable.setMinHeight(Gdx.graphics.getHeight()/24);
	    image = new Image(textureRegionDrawable);
	    image.setUserObject(3);
	    intro.add(image);
	   
	    table.add(intro).size(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
	    table.row();

	   // style[1].imageUp =  new TextureRegionDrawable(new TextureRegion(allAtlas.findRegion("select_symphony")));
		sounds = new SelectImageButton(style,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
		sounds.setUserObject(4);
	    textureRegion = new TextureRegion(allAtlas.findRegion("making_sounds"));
	    textureRegionDrawable = new TextureRegionDrawable(textureRegion);
	    textureRegionDrawable.setMinWidth(Gdx.graphics.getWidth()/2-Gdx.graphics.getWidth()/12);
	    textureRegionDrawable.setMinHeight(Gdx.graphics.getHeight()/24);
	    image = new Image(textureRegionDrawable);
	    image.setUserObject(4);
		sounds.add(image);
		table.add(sounds).size(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
		table.row();
		
	  //  style[2].imageUp =  new TextureRegionDrawable(new TextureRegion(allAtlas.findRegion("select_meanings")));
	    meanings = new SelectImageButton(style,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
	    meanings.setUserObject(5);
	    textureRegion = new TextureRegion(allAtlas.findRegion("meanings"));
	    textureRegionDrawable = new TextureRegionDrawable(textureRegion);
	    textureRegionDrawable.setMinWidth(Gdx.graphics.getWidth()/3);
	    textureRegionDrawable.setMinHeight(Gdx.graphics.getHeight()/24);
	    image = new Image(textureRegionDrawable);
	    image.setUserObject(5);
	    meanings.add(image);
		table.add(meanings).size(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
		table.row();
		
	   // style[3].imageUp =  new TextureRegionDrawable(new TextureRegion(allAtlas.findRegion("select_suits")));
	    suits = new SelectImageButton(style,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
	    suits.setUserObject(6);
	    textureRegion = new TextureRegion(allAtlas.findRegion("suits_colours"));
	    textureRegionDrawable = new TextureRegionDrawable(textureRegion);
	    textureRegionDrawable.setMinWidth(Gdx.graphics.getWidth()/2);
	    textureRegionDrawable.setMinHeight(Gdx.graphics.getHeight()/24);
	    image = new Image(textureRegionDrawable);
	    image.setUserObject(6);
	    suits.add(image);
		table.add(suits).size(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
		table.row();
		
	  //  style[4].imageUp =  new TextureRegionDrawable(new TextureRegion(allAtlas.findRegion("select_using")));
	    using = new SelectImageButton(style,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
	    using.setUserObject(7);
	    textureRegion = new TextureRegion(allAtlas.findRegion("using_cards"));
	    textureRegionDrawable = new TextureRegionDrawable(textureRegion);
	    textureRegionDrawable.setMinWidth(Gdx.graphics.getWidth()/2-Gdx.graphics.getWidth()/8);
	    textureRegionDrawable.setMinHeight(Gdx.graphics.getHeight()/24);
	    image = new Image(textureRegionDrawable);
	    image.setUserObject(7);
	    using.add(image);
		table.add(using).size(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
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
}
