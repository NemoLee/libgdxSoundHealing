package com.sound.healing.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.sound.healing.AssetLoader;
import com.sound.healing.custom.MenuButton;
import com.sound.healing.custom.SelectImageButton;
import com.sound.healing.custom.TopImage;
import com.sound.healing.screens.ScreenSpec;

public class CreateSpreadSelect extends CreateScene{
	
	private SelectImageButton single, soundAdvice, symphonyOfLife, duet, heartSong, retuning, singingEarth, angelsOfSound, individual, multi;
	private MenuButton backButton;
	private TextButtonStyle style_menu_startbutton;
	private ButtonStyle style;
	private Table table, container;
	private ScrollPane scroll;
	
	public CreateSpreadSelect() {
		setupTop("CHOOSE YOUR SPREAD");
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
		table.setBounds(0, 0, Gdx.graphics.getWidth(), 9*(Gdx.graphics.getHeight()/6));
		scroll = new ScrollPane(table);
		container.add(scroll).width(Gdx.graphics.getWidth()).height(Gdx.graphics.getHeight()-(topImage.getHeight()+Gdx.graphics.getHeight()/7));
		container.row();
		container.setUserObject(1);
		container.setBounds(0, Gdx.graphics.getHeight()/7, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()-(topImage.getHeight()+Gdx.graphics.getHeight()/7));
		container.setBackground(new TextureRegionDrawable(new TextureRegion(allAtlas.findRegion("darkpurp"))));
		
		
		single = new SelectImageButton(style,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
		single.setUserObject(3);
	    textureRegion = new TextureRegion(allAtlas.findRegion("select_single"));
	    textureRegionDrawable = new TextureRegionDrawable(textureRegion);
	    textureRegionDrawable.setMinWidth(Gdx.graphics.getWidth()/3+Gdx.graphics.getWidth()/4);
	    textureRegionDrawable.setMinHeight(Gdx.graphics.getHeight()/8);
	    image = new Image(textureRegionDrawable);
	    image.setUserObject(3);
	    single.add(image);
	    
	    table.add(single).size(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
	    table.row();
		
	    soundAdvice = new SelectImageButton(style,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
	    soundAdvice.setUserObject(4);
	    textureRegion = new TextureRegion(allAtlas.findRegion("select_soundadvice"));
	    textureRegionDrawable = new TextureRegionDrawable(textureRegion);
	    textureRegionDrawable.setMinWidth(Gdx.graphics.getWidth()/3+Gdx.graphics.getWidth()/4);
	    textureRegionDrawable.setMinHeight(Gdx.graphics.getHeight()/8);
	    image = new Image(textureRegionDrawable);
	    image.setUserObject(4);
	    soundAdvice.add(image);
	   
	    table.add(soundAdvice).size(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
	    table.row();

	   // style[1].imageUp =  new TextureRegionDrawable(new TextureRegion(allAtlas.findRegion("select_symphony")));
		symphonyOfLife = new SelectImageButton(style,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
		symphonyOfLife.setUserObject(5);
	    textureRegion = new TextureRegion(allAtlas.findRegion("select_symphony"));
	    textureRegionDrawable = new TextureRegionDrawable(textureRegion);
	    textureRegionDrawable.setMinWidth(Gdx.graphics.getWidth()/2);
	    textureRegionDrawable.setMinHeight(Gdx.graphics.getHeight()/8);
	    image = new Image(textureRegionDrawable);
	    image.setUserObject(5);
		symphonyOfLife.add(image);
		table.add(symphonyOfLife).size(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
		table.row();
		
	  //  style[2].imageUp =  new TextureRegionDrawable(new TextureRegion(allAtlas.findRegion("select_duet")));
	    duet = new SelectImageButton(style,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
	    duet.setUserObject(6);
	    textureRegion = new TextureRegion(allAtlas.findRegion("select_duet"));
	    textureRegionDrawable = new TextureRegionDrawable(textureRegion);
	    textureRegionDrawable.setMinWidth(Gdx.graphics.getWidth()/8);
	    textureRegionDrawable.setMinHeight(Gdx.graphics.getHeight()/8);
	    image = new Image(textureRegionDrawable);
	    image.setUserObject(6);
	    duet.add(image);
		table.add(duet).size(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
		table.row();
		
	   // style[3].imageUp =  new TextureRegionDrawable(new TextureRegion(allAtlas.findRegion("select_heartsong")));
	    heartSong = new SelectImageButton(style,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
	    heartSong.setUserObject(7);
	    textureRegion = new TextureRegion(allAtlas.findRegion("select_heartsong"));
	    textureRegionDrawable = new TextureRegionDrawable(textureRegion);
	    textureRegionDrawable.setMinWidth(Gdx.graphics.getWidth()/3);
	    textureRegionDrawable.setMinHeight(Gdx.graphics.getHeight()/8);
	    image = new Image(textureRegionDrawable);
	    image.setUserObject(7);
	    heartSong.add(image);
		table.add(heartSong).size(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
		table.row();
		
	  //  style[4].imageUp =  new TextureRegionDrawable(new TextureRegion(allAtlas.findRegion("select_retuning")));
	    retuning = new SelectImageButton(style,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
	    retuning.setUserObject(8);
	    textureRegion = new TextureRegion(allAtlas.findRegion("select_retuning"));
	    textureRegionDrawable = new TextureRegionDrawable(textureRegion);
	    textureRegionDrawable.setMinWidth(Gdx.graphics.getWidth()/3);
	    textureRegionDrawable.setMinHeight(Gdx.graphics.getHeight()/8);
	    image = new Image(textureRegionDrawable);
	    image.setUserObject(8);
	    retuning.add(image);
		table.add(retuning).size(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
		table.row();
		
	  //  style[5].imageUp =  new TextureRegionDrawable(new TextureRegion(allAtlas.findRegion("select_singingearth")));
	    singingEarth = new SelectImageButton(style,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
	    singingEarth.setUserObject(9);
	    textureRegion = new TextureRegion(allAtlas.findRegion("select_singingearth"));
	    textureRegionDrawable = new TextureRegionDrawable(textureRegion);
	    textureRegionDrawable.setMinWidth(Gdx.graphics.getWidth()/3+Gdx.graphics.getWidth()/25);
	    textureRegionDrawable.setMinHeight(Gdx.graphics.getHeight()/8);
	    image = new Image(textureRegionDrawable);
	    image.setUserObject(9);
	    singingEarth.add(image);
		table.add(singingEarth).size(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
		table.row();
		
	  //  style[6].imageUp =  new TextureRegionDrawable(new TextureRegion(allAtlas.findRegion("select_angel")));
	    angelsOfSound = new SelectImageButton(style,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
	    angelsOfSound.setUserObject(10);
	    textureRegion = new TextureRegion(allAtlas.findRegion("select_angel"));
	    textureRegionDrawable = new TextureRegionDrawable(textureRegion);
	    textureRegionDrawable.setMinWidth(Gdx.graphics.getWidth()/2-Gdx.graphics.getWidth()/12);
	    textureRegionDrawable.setMinHeight(Gdx.graphics.getHeight()/9);
	    image = new Image(textureRegionDrawable);
	    image.setUserObject(10);
	    angelsOfSound.add(image);
		table.add(angelsOfSound).size(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
		table.row();
		
	 //   style[7].imageUp =  new TextureRegionDrawable(new TextureRegion(allAtlas.findRegion("select_individual")));
	    individual = new SelectImageButton(style,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
	    individual.setUserObject(11);
	    textureRegion = new TextureRegion(allAtlas.findRegion("select_individual"));
	    textureRegionDrawable = new TextureRegionDrawable(textureRegion);
	    textureRegionDrawable.setMinWidth(Gdx.graphics.getWidth()-Gdx.graphics.getWidth()/3);
	    textureRegionDrawable.setMinHeight(Gdx.graphics.getHeight()/10);
	    image = new Image(textureRegionDrawable);
	    image.setUserObject(11);
	    individual.add(image);
		table.add(individual).size(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
		table.row();
		
	   // style[8].imageUp =  new TextureRegionDrawable(new TextureRegion(allAtlas.findRegion("select_multi")));
	    multi = new SelectImageButton(style,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
	    multi.setUserObject(12);
	    textureRegion = new TextureRegion(allAtlas.findRegion("select_multi"));
	    textureRegionDrawable = new TextureRegionDrawable(textureRegion);
	    textureRegionDrawable.setMinWidth(Gdx.graphics.getWidth()/2);
	    textureRegionDrawable.setMinHeight(Gdx.graphics.getHeight()/8);
	    image = new Image(textureRegionDrawable);
	    image.setUserObject(12);
	    multi.add(image);
	    table.add(multi).size(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
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

