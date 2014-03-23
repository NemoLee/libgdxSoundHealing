package com.sound.healing.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.sound.healing.AssetLoader;
import com.sound.healing.custom.MenuButton;
import com.sound.healing.custom.SelectImageButton;
import com.sound.healing.custom.TopImage;
import com.sound.healing.screens.ScreenSpec;

public class CreateSpreadSelect extends CreateScene{
	
	private SelectImageButton soundAdvice, symphonyOfLife, duet, heartSong, retuning, singingEarth, angelsOfSound, individual, multi;
	private TopImage topImage;
	private ImageButtonStyle style_menu_startbutton;
	private ImageButtonStyle[] style;
	private Table table, container;
	private ScrollPane scroll;
	
	public CreateSpreadSelect() {
		setupTop();
		setupMenuButtons();
		spec = new ScreenSpec(scene);
	}

	private void setupTop() {
		/*
		atlas_Menu_Button = manager.get("Menu/menubutton.atlas", TextureAtlas.class);
		skin_Menu_Button = new Skin();
		skin_Menu_Button.addRegions(atlas_Menu_Button);
		style_menu_startbutton = new TextButtonStyle();
		style_menu_startbutton.up = skin_Menu_Button.getDrawable("menu_button");
		style_menu_startbutton.down = skin_Menu_Button.getDrawable("menu_button_dark");
		font.size = Gdx.graphics.getWidth()/20;
		appFont = generator.generateFont(font);
		style_menu_startbutton.font = appFont;
		
		
		
		atlas_Back_Button = manager.get("Back/backbutton.atlas", TextureAtlas.class);
		skin_Back_Button = new Skin();
		skin_Back_Button.addRegions(atlas_Back_Button);
		style_Back_Button = new ButtonStyle();
		style_Back_Button.up = skin_Back_Button.getDrawable("backbutton");
		style_Back_Button.down = skin_Back_Button.getDrawable("backbutton_dark");
	
		
		texture_SpreadSelect_Title = manager.get("Top/top_header.png", Texture.class);
		*/
		topImage = new TopImage("CHOOSE YOUR SPREAD", new TextButtonStyle(null, null, null, new BitmapFont()), AssetLoader.manager.get("Top/top_header.png", Texture.class), 60, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		topImage.setPosition(0, Gdx.graphics.getHeight()-topImage.getHeight());
		topImage.setUserObject(0);
		scene.put((Integer) topImage.getUserObject(), topImage);
		
	}

	private void setupMenuButtons() {
		
		style = new ImageButtonStyle[9];
		for(int i = 0; i < style.length; i++){
			style[i] = createImageButtonStyle("Menu/menubutton.atlas","menu_button","menu_button_dark");
		}
		
		table = new Table();
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		container = new Table();
		scroll = new ScrollPane(table);
		container.add(scroll).width(Gdx.graphics.getWidth()).height(Gdx.graphics.getHeight());
		container.row();
		container.setUserObject(1);
		container.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	
		style[0].imageUp =  new TextureRegionDrawable(new TextureRegion(AssetLoader.manager.get("Select/select_soundadvice.png", Texture.class)));
	    soundAdvice = new SelectImageButton(style[0],0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/7);
	    soundAdvice.setUserObject(2);
	    table.add(soundAdvice);
	    table.row();
	    //scene.put((Integer) soundAdvice.getUserObject(), soundAdvice);
	    
	    
	    style[1].imageUp =  new TextureRegionDrawable(new TextureRegion(AssetLoader.manager.get("Select/select_symphony.png", Texture.class)));
		symphonyOfLife = new SelectImageButton(style[1],0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/7);
		symphonyOfLife.setUserObject(3);
		table.add(symphonyOfLife);
		
		scene.put((Integer) container.getUserObject(), container);
	   // scene.put((Integer) symphonyOfLife.getUserObject(), symphonyOfLife);
		
	    //symphonyOfLife
	    
	}

}
