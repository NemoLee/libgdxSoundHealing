package com.sound.healing.actors;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.sound.healing.AssetLoader;
import com.sound.healing.ScreenManager;
import com.sound.healing.custom.MenuButton;
import com.sound.healing.custom.SelectImageButton;
import com.sound.healing.screens.ScreenSpec;

public class CreateMainMenu extends CreateScene{
	
	

	private SelectImageButton startButton, browseButton, loadButton, moreinfoButton;
	private Image image_Menu_Title_Background, image_Menu_Author, image_Menu_Title;
	private TextButtonStyle style_menu_startbutton;
	
	public CreateMainMenu() {
		setupTop();
		setupMenuButtons();
		spec = new ScreenSpec(scene);
	}

	private void setupTop() {
		//Image Menu Title Background
		image_Menu_Title_Background = new Image(allAtlas.findRegion("menu_title_background"));
		image_Menu_Title_Background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/7)*4);
		image_Menu_Title_Background.setPosition(0, Gdx.graphics.getHeight()-(image_Menu_Title_Background.getHeight()));
		image_Menu_Title_Background.setUserObject(0);
		scene.add(image_Menu_Title_Background);
		
		//Image Menu Title
		image_Menu_Title = new Image(AssetLoader.manager.get("Menu/menu_title.png", Texture.class));
	    image_Menu_Title.setSize(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/6);
	    image_Menu_Title.setPosition(Gdx.graphics.getWidth()/4, Gdx.graphics.getHeight()-(image_Menu_Title.getHeight()+Gdx.graphics.getHeight()/16));
	    image_Menu_Title.setUserObject(1);
	    scene.add(image_Menu_Title);
	    
	    //Image Menu Author
		image_Menu_Author =new Image( allAtlas.findRegion("menu_author"));
	    image_Menu_Author.setSize(Gdx.graphics.getWidth()/3, Gdx.graphics.getHeight()/18);
	    image_Menu_Author.setPosition(Gdx.graphics.getWidth()/3, Gdx.graphics.getHeight()-(image_Menu_Author.getHeight()+Gdx.graphics.getHeight()/4+Gdx.graphics.getHeight()/24));
	    image_Menu_Author.addListener(new ClickListener(){
			 @Override
	            public void clicked(InputEvent event, float x, float y) {
				 Gdx.net.openURI("http://shirlieroden.com");
	            }
	    });
	    
	    image_Menu_Author.setUserObject(2);
	    scene.add(image_Menu_Author);
	}
	
	
	private void setupMenuButtons() {
		style_menu_startbutton = createTextButtonStyle("Menu/menubutton.atlas","menu_button","menu_button_dark", Gdx.graphics.getWidth()/14);
		Image image;
		TextureRegion textureRegion;
		TextureRegionDrawable textureRegionDrawable;
		
	    //MoreInfo Button
	    moreinfoButton = new SelectImageButton(style_menu_startbutton,0,3*(Gdx.graphics.getHeight()/7),Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/7);
	    moreinfoButton.setUserObject(3);
	    textureRegion = new TextureRegion(allAtlas.findRegion("more_info"));
	    textureRegionDrawable = new TextureRegionDrawable(textureRegion);
	    textureRegionDrawable.setMinWidth(Gdx.graphics.getWidth()/3);
	    textureRegionDrawable.setMinHeight(Gdx.graphics.getWidth()/15);
	    image = new Image(textureRegionDrawable);
	    image.setUserObject(3);
	    moreinfoButton.add(image);
	    scene.add(moreinfoButton);
		
		
		
	    //Start button
	    startButton = new SelectImageButton(style_menu_startbutton,0,2*(Gdx.graphics.getHeight()/7),Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/7);
	    startButton.setUserObject(4);
	    textureRegion = new TextureRegion(allAtlas.findRegion("start"));
	    textureRegionDrawable = new TextureRegionDrawable(textureRegion);
	    textureRegionDrawable.setMinWidth(Gdx.graphics.getWidth()/7);
	    textureRegionDrawable.setMinHeight(Gdx.graphics.getWidth()/15);
	    image = new Image(textureRegionDrawable);
	    image.setUserObject(4);
	    startButton.add(image);
	    
	    scene.add(startButton);
	    
	    //Load Button
	    loadButton = new SelectImageButton(style_menu_startbutton,0,(Gdx.graphics.getHeight()/7), Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/7);
	    loadButton.setUserObject(5);
	    textureRegion = new TextureRegion(allAtlas.findRegion("load"));
	    textureRegionDrawable = new TextureRegionDrawable(textureRegion);
	    textureRegionDrawable.setMinWidth(Gdx.graphics.getWidth()/9);
	    textureRegionDrawable.setMinHeight(Gdx.graphics.getWidth()/15);
	    image = new Image(textureRegionDrawable);
	    image.setUserObject(5);
	    loadButton.add(image);
	    scene.add(loadButton);
	    
	    //Browse Button  
	    browseButton = new SelectImageButton(style_menu_startbutton,0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/7);
	    browseButton.setUserObject(6);
	    textureRegion = new TextureRegion(allAtlas.findRegion("browse"));
	    textureRegionDrawable = new TextureRegionDrawable(textureRegion);
	    textureRegionDrawable.setMinWidth(Gdx.graphics.getWidth()/5);
	    textureRegionDrawable.setMinHeight(Gdx.graphics.getWidth()/15);
	    image = new Image(textureRegionDrawable);
	    image.setUserObject(6);
	    browseButton.add(image);
	    scene.add(browseButton);
	    
		
		
	}

}