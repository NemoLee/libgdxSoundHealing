package com.sound.healing.actors;

import java.util.StringTokenizer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.sound.healing.AssetLoader;
import com.sound.healing.custom.MenuButton;
import com.sound.healing.screens.ScreenSpec;

public class CreateLoad extends CreateScene{
	
	private MenuButton backButton;
	private MenuButton[] loadButtons;
	private Image[] deleteButtons;
	private TextButton yes, no;
	private TextButtonStyle style_menu_backbutton, style_menu_loadbutton, style_info_startButton, style_yes,style_no;
	private Image darkPurple, black, popupBackground;
	private Preferences prefs;
	private String loadData;
	private Table table, container;
	private ScrollPane scroll;
	private Group group;
	
	public CreateLoad() {
		setupTop("LOAD A PREVIOUS READING");
		setupBackButton();
		setupScroll();
		setupDialog();
		spec = new ScreenSpec(scene);
	}

	private void setupScroll() {
		darkPurple = new Image(allAtlas.findRegion("darkpurp"));
		darkPurple.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/2+Gdx.graphics.getHeight()/5-Gdx.graphics.getHeight()/120);
		darkPurple.setPosition(0, Gdx.graphics.getHeight()/7);
		darkPurple.setUserObject(2);
		scene.add(darkPurple);
		
		

		prefs = Gdx.app.getPreferences("spread");
		loadData = prefs.getString("spread", "");
	
		StringTokenizer loads = new StringTokenizer(loadData, "^");
		loadButtons = new MenuButton[loads.countTokens()];
		deleteButtons = new Image[loadButtons.length];
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
			deleteButtons[i] = new Image(allAtlas.findRegion("delete"));
			deleteButtons[i].setUserObject(i+4);
			deleteButtons[i].setSize(Gdx.graphics.getWidth()/6, Gdx.graphics.getWidth()/6);
			deleteButtons[i].setPosition(deleteButtons[i].getWidth(), (loadButtons.length-i)*(Gdx.graphics.getHeight()/7));
			loadButtons[i] = new MenuButton(name+"\n Time: "+ time,style_menu_loadbutton,0,(loadButtons.length-i)*(Gdx.graphics.getHeight()/7),Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/7);
			loadButtons[i].setUserObject(i+4);
			loadButtons[i].setSpreadType(name);
			loadButtons[i].setSpreadIDS(getSpreadCards(current));
			//loadButtons[i].add(deleteButtons[i]);
			table.add(loadButtons[i]).size(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/7);
			table.row();
		}
		
		scene.add(container);
		
		
		
		
	}
	private void setupDialog() {
		group = new Group();
		group.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		group.setPosition(0, 0);
		group.setUserObject(4);
		group.setVisible(false);
		black = new Image(allAtlas.findRegion("darkpurp"));
		black.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		black.setPosition(0, 0);
		black.addAction(Actions.alpha(0.8f));
		black.setUserObject(36);
		//black.setVisible(false);
		group.addActor(black);
	   // scene.put((Integer) black.getUserObject(), black);
	    popupBackground = new Image(AssetLoader.manager.get("UI/wait2.png",Texture.class));
	    popupBackground.setSize(Gdx.graphics.getWidth()-Gdx.graphics.getWidth()/3, Gdx.graphics.getHeight()/2);
	    popupBackground.setPosition(Gdx.graphics.getWidth()/6, Gdx.graphics.getHeight()/3);
	    popupBackground.setUserObject(37);
	   // popupBackground.setVisible(false);
	    group.addActor(popupBackground);
	   // scene.put((Integer) popupBackground.getUserObject(), popupBackground);
	   
		//scene.put((Integer) labelDescription.getUserObject(), labelDescription);
		
		style_yes =  createTextButtonStyle("UI/yesbutton.atlas","yesbutton","yesbutton_dark", Gdx.graphics.getWidth()/18);
		style_no =  createTextButtonStyle("UI/nobutton.atlas","nobutton","nobutton_dark", Gdx.graphics.getWidth()/18);
		yes = new TextButton("", style_yes);
		no = new TextButton("", style_no);
		yes.setSize((Gdx.graphics.getWidth()-Gdx.graphics.getWidth()/3)/2-Gdx.graphics.getWidth()/400, Gdx.graphics.getWidth()/8);
		no.setSize((Gdx.graphics.getWidth()-Gdx.graphics.getWidth()/3)/2-Gdx.graphics.getWidth()/400, Gdx.graphics.getWidth()/8);
		yes.setPosition(Gdx.graphics.getWidth()/6, Gdx.graphics.getHeight()/3);
		no.setPosition(Gdx.graphics.getWidth()/6+((Gdx.graphics.getWidth()-Gdx.graphics.getWidth()/3)/2+Gdx.graphics.getWidth()/400), Gdx.graphics.getHeight()/3);
		yes.setUserObject(38);
		no.setUserObject(39);
		//yes.setVisible(false);
		//no.setVisible(false);
		group.addActor(yes);
		group.addActor(no);
		scene.add(group); 
		
	
		
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
	    scene.add(backButton);
		
	}
	
	@Override
	public void reset() {	
		loadButtons = null;
		deleteButtons = null;
		
		table = null;
		container = null;
		scroll = null;
		prefs = Gdx.app.getPreferences("spread");
		loadData = prefs.getString("spread", "");
		StringTokenizer loads = new StringTokenizer(loadData, "^");
		loadButtons = new MenuButton[loads.countTokens()];
		deleteButtons = new Image[loadButtons.length];
		
		
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
			deleteButtons[i] = new Image(allAtlas.findRegion("delete"));
			deleteButtons[i].setUserObject(i+4+5000);
			deleteButtons[i].setSize(Gdx.graphics.getWidth()/6, Gdx.graphics.getWidth()/6);
			deleteButtons[i].setPosition(deleteButtons[i].getWidth(), (loadButtons.length-i)*(Gdx.graphics.getHeight()/7));

			loadButtons[i] = new MenuButton(name+"\n Time: "+ time,style_menu_loadbutton,0,(loadButtons.length-i)*(Gdx.graphics.getHeight()/7),Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/7);
			loadButtons[i].setUserObject(i+4);
			loadButtons[i].setSpreadType(name);
			loadButtons[i].setSpreadIDS(getSpreadCards(current));
			//loadButtons[i].add(hg);
			table.add(loadButtons[i]).size(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/7);
			table.add(deleteButtons[i]).padLeft(-Gdx.graphics.getWidth()*2+2*deleteButtons[i].getWidth());
			table.row();
		}
		scene.set(3,container);
	}
	

}
