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
	
	private SelectImageButton soundAdvice, symphonyOfLife, duet, heartSong, retuning, singingEarth, angelsOfSound, individual, multi;
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
	
		table = new Table();
		container = new Table();
		table.setBounds(0, 0, Gdx.graphics.getWidth(), 9*(Gdx.graphics.getHeight()/6));
		scroll = new ScrollPane(table);
		container.add(scroll).width(Gdx.graphics.getWidth()).height(Gdx.graphics.getHeight()-(topImage.getHeight()+Gdx.graphics.getHeight()/7));
		container.row();
		container.setUserObject(1);
		container.setBounds(0, Gdx.graphics.getHeight()/7, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()-(topImage.getHeight()+Gdx.graphics.getHeight()/7));

	    soundAdvice = new SelectImageButton(style,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
	    soundAdvice.setUserObject(2);
	    soundAdvice.add(new Image(AssetLoader.manager.get("Select/select_soundadvice.png", Texture.class)));
	    table.add(soundAdvice).size(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
	    table.row();

	   // style[1].imageUp =  new TextureRegionDrawable(new TextureRegion(AssetLoader.manager.get("Select/select_symphony.png", Texture.class)));
		symphonyOfLife = new SelectImageButton(style,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
		symphonyOfLife.setUserObject(3);
		symphonyOfLife.add(new Image(AssetLoader.manager.get("Select/select_symphony.png", Texture.class)));
		table.add(symphonyOfLife).size(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
		table.row();
		
	  //  style[2].imageUp =  new TextureRegionDrawable(new TextureRegion(AssetLoader.manager.get("Select/select_duet.png", Texture.class)));
	    duet = new SelectImageButton(style,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
	    duet.setUserObject(4);
	    duet.add(new Image(AssetLoader.manager.get("Select/select_duet.png", Texture.class)));
		table.add(duet).size(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
		table.row();
		
	   // style[3].imageUp =  new TextureRegionDrawable(new TextureRegion(AssetLoader.manager.get("Select/select_heartsong.png", Texture.class)));
	    heartSong = new SelectImageButton(style,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
	    heartSong.setUserObject(5);
	    heartSong.add(new Image(AssetLoader.manager.get("Select/select_heartsong.png", Texture.class)));
		table.add(heartSong).size(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
		table.row();
		
	  //  style[4].imageUp =  new TextureRegionDrawable(new TextureRegion(AssetLoader.manager.get("Select/select_retuning.png", Texture.class)));
	    retuning = new SelectImageButton(style,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
	    retuning.setUserObject(6);
	    retuning.add(new Image(AssetLoader.manager.get("Select/select_retuning.png", Texture.class)));
		table.add(retuning).size(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
		table.row();
		
	  //  style[5].imageUp =  new TextureRegionDrawable(new TextureRegion(AssetLoader.manager.get("Select/select_singingearth.png", Texture.class)));
	    singingEarth = new SelectImageButton(style,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
	    singingEarth.setUserObject(7);
	    singingEarth.add(new Image(AssetLoader.manager.get("Select/select_singingearth.png", Texture.class)));
		table.add(singingEarth).size(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
		table.row();
		
	  //  style[6].imageUp =  new TextureRegionDrawable(new TextureRegion(AssetLoader.manager.get("Select/select_angel.png", Texture.class)));
	    angelsOfSound = new SelectImageButton(style,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
	    angelsOfSound.setUserObject(8);
	    angelsOfSound.add(new Image(AssetLoader.manager.get("Select/select_angel.png", Texture.class)));
		table.add(angelsOfSound).size(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
		table.row();
		
	 //   style[7].imageUp =  new TextureRegionDrawable(new TextureRegion(AssetLoader.manager.get("Select/select_individual.png", Texture.class)));
	    individual = new SelectImageButton(style,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
	    individual.setUserObject(9);
	    individual.add(new Image(AssetLoader.manager.get("Select/select_individual.png", Texture.class)));
		table.add(individual).size(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
		table.row();
		
	   // style[8].imageUp =  new TextureRegionDrawable(new TextureRegion(AssetLoader.manager.get("Select/select_multi.png", Texture.class)));
	    multi = new SelectImageButton(style,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
	    multi.setUserObject(10);
	    multi.add(new Image(AssetLoader.manager.get("Select/select_multi.png", Texture.class)));
	    table.add(multi).size(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
		table.row();
		
		scene.put((Integer) container.getUserObject(), container);
	    
	}

	private void setupBackButton() {
		style_menu_startbutton = createTextButtonStyle("Back/backbutton.atlas","backbutton","backbutton_dark", Gdx.graphics.getWidth()/14);
		
	    //Start button
		backButton = new MenuButton("",style_menu_startbutton,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/7);
		backButton.setUserObject(2);
	    scene.put((Integer) backButton.getUserObject(), backButton);
		
		
	}
}

