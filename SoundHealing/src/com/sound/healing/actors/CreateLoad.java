package com.sound.healing.actors;

import java.util.StringTokenizer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.utils.Array;
import com.sound.healing.AssetLoader;
import com.sound.healing.custom.MenuButton;
import com.sound.healing.screens.ScreenSpec;

public class CreateLoad extends CreateScene{
	
	private MenuButton backButton;
	private MenuButton[] loadButtons;
	private TextButtonStyle style_menu_backbutton, style_menu_loadbutton;
	private Image darkPurple;
	private Preferences prefs = Gdx.app.getPreferences("spread");
	private String loadData;
	private Table table, container;
	private ScrollPane scroll;
	
	public CreateLoad() {
		setupTop("LOAD A PREVIOUS READING");
		setupBackButton();
		setupScroll();
		spec = new ScreenSpec(scene);
	}

	private void setupScroll() {
		darkPurple = new Image(AssetLoader.manager.get("Style/darkpurp.png", Texture.class));
		darkPurple.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/2+Gdx.graphics.getHeight()/5-Gdx.graphics.getHeight()/120);
		darkPurple.setPosition(0, Gdx.graphics.getHeight()/7);
		darkPurple.setUserObject(2);
		scene.put((Integer) darkPurple.getUserObject(), darkPurple);
		
		

		
		loadData = prefs.getString("spread", "");
		StringTokenizer loads = new StringTokenizer(loadData, "^");
		loadButtons = new MenuButton[loads.countTokens()];
		style_menu_loadbutton = createTextButtonStyle("Menu/menubutton.atlas","menu_button","menu_button_dark", Gdx.graphics.getWidth()/17);
		
		
		
		
		table = new Table();
		container = new Table();
		table.setBounds(0, 0, Gdx.graphics.getWidth(), loadButtons.length*(Gdx.graphics.getHeight()/7));
		scroll = new ScrollPane(table);
		container.add(scroll).width(Gdx.graphics.getWidth()).height(Gdx.graphics.getHeight()-(topImage.getHeight()+Gdx.graphics.getHeight()/7));
		container.row();
		container.setUserObject(3);
		container.setBounds(0, Gdx.graphics.getHeight()/7, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()-(topImage.getHeight()+Gdx.graphics.getHeight()/7));
		
		table.top();
		
		
		for(int i = 0; i < loadButtons.length; i++){
			String current = loads.nextToken();
			String name = getSpreadName(current);
			String time = getSpreadTime(current);
			loadButtons[i] = new MenuButton(name+"\n Time: "+ time,style_menu_loadbutton,0,(loadButtons.length-i)*(Gdx.graphics.getHeight()/7),Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/7);
			loadButtons[i].setUserObject(i+4);
			loadButtons[i].setSpreadType(name);
			loadButtons[i].setSpreadIDS(getSpreadCards(current));
			table.add(loadButtons[i]).size(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/7);
			table.row();
		}
		
		scene.put((Integer) container.getUserObject(), container);
		
	}

	private int[] getSpreadCards(String current) {
		StringTokenizer tokens = new StringTokenizer(current, ",");
		tokens.nextToken();
		int[] spreadCards = new int[tokens.countTokens()-1];
		for(int i = 0; i < spreadCards.length; i++){
			spreadCards[i] = Integer.parseInt(tokens.nextToken())-1;
		}
		return spreadCards;
	}
	
	private String getSpreadTime(String string) {
		StringTokenizer tokens = new StringTokenizer(string, "_");
		tokens.nextToken();
		return tokens.nextToken().substring(0, 16);
	}

	private String getSpreadName(String string) {
		StringTokenizer tokens = new StringTokenizer(string, "|");
		return tokens.nextToken();
	}

	private void setupBackButton() {
		style_menu_backbutton = createTextButtonStyle("Back/backbutton.atlas","backbutton","backbutton_dark", Gdx.graphics.getWidth()/14);
		
	    //Start button
		backButton = new MenuButton("",style_menu_backbutton,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/7);
		backButton.setUserObject(1);
	    scene.put((Integer) backButton.getUserObject(), backButton);
		
	}
	

}
