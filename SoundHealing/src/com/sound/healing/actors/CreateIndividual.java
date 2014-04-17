package com.sound.healing.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.sound.healing.AssetLoader;
import com.sound.healing.custom.MenuButton;
import com.sound.healing.screens.ScreenSpec;

public class CreateIndividual extends CreateScene{
	
	
	private MenuButton backButton;
	private TextButtonStyle style_menu_startbutton;
	private Image darkPurple, lightPurple, smallPurple;
	private Image[] bigCards,miniCards, miniCardsBG;
	private HorizontalGroup cardGroup;
	
	public CreateIndividual() {

		setupTop("Choose Your Card");
		setupMiddle();
		setupMiniCards();
		setupSmallPurple();
		setupBottom();
		spec = new ScreenSpec(scene);
	}

	private void setupMiddle() {
		darkPurple = new Image(AssetLoader.manager.get("Style/darkpurp.png", Texture.class));
		darkPurple.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/2);
		darkPurple.setPosition(0, (Gdx.graphics.getHeight()/7)*2);
		darkPurple.setUserObject(1);
		scene.put((Integer) darkPurple.getUserObject(), darkPurple);
		
		
		bigCards = new Image[6];
		for(int i = 0; i < 6; i++){
			bigCards[i] = new Image(AssetLoader.manager.get("Choose/bigcard.png", Texture.class));
			bigCards[i].setSize(Gdx.graphics.getWidth()/6, (float)(Gdx.graphics.getWidth()/6*1.4533));
			bigCards[i].setUserObject(i+2);
		}
		
		bigCards[0].setPosition(bigCards[0].getWidth(), (Gdx.graphics.getHeight()/4)*2+Gdx.graphics.getHeight()/16);
		bigCards[1].setPosition(bigCards[1].getWidth(), (Gdx.graphics.getHeight()/4)+Gdx.graphics.getHeight()/16);
		bigCards[2].setPosition(bigCards[2].getWidth()*2+bigCards[2].getWidth()/2, (Gdx.graphics.getHeight()/4)*2+Gdx.graphics.getHeight()/16);
		bigCards[3].setPosition(bigCards[3].getWidth()*2+bigCards[3].getWidth()/2, (Gdx.graphics.getHeight()/4)+Gdx.graphics.getHeight()/16);
		bigCards[4].setPosition((bigCards[4].getWidth()*3+bigCards[4].getWidth()/2), (Gdx.graphics.getHeight()/4)*2+Gdx.graphics.getHeight()/16);
		bigCards[5].setPosition((bigCards[5].getWidth()*3+bigCards[5].getWidth()/2), (Gdx.graphics.getHeight()/4)+Gdx.graphics.getHeight()/16);
		scene.put((Integer) bigCards[0].getUserObject(), bigCards[0]);
		scene.put((Integer) bigCards[1].getUserObject(), bigCards[1]);
		scene.put((Integer) bigCards[2].getUserObject(), bigCards[2]);
		scene.put((Integer) bigCards[3].getUserObject(), bigCards[3]);
		scene.put((Integer) bigCards[4].getUserObject(), bigCards[4]);
		scene.put((Integer) bigCards[5].getUserObject(), bigCards[5]);
		
	}
	
	private void setupMiniCards() {
		lightPurple = new Image(AssetLoader.manager.get("Style/lightpurp.png", Texture.class));
		lightPurple.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/7);
		lightPurple.setPosition(0, Gdx.graphics.getHeight()/7);
		lightPurple.setUserObject(8);
		scene.put((Integer) lightPurple.getUserObject(), lightPurple);
		
		miniCards = new Image[1];
		miniCardsBG = new Image[1];
		cardGroup = new HorizontalGroup();
		cardGroup.setSize((Gdx.graphics.getWidth()/10+Gdx.graphics.getWidth()/20)*miniCards.length, (Gdx.graphics.getWidth()/2)+Gdx.graphics.getWidth()/8);
		cardGroup.setPosition(Gdx.graphics.getWidth()/2-cardGroup.getWidth()/2+Gdx.graphics.getWidth()/40,Gdx.graphics.getHeight()/7+Gdx.graphics.getHeight()/42);
		cardGroup.setLayoutEnabled(false);
		cardGroup.setUserObject(9);
		for(int i = 0; i < miniCards.length; i++){
			miniCards[i] = new Image(AssetLoader.manager.get("Choose/bigcard.png", Texture.class));
			miniCardsBG[i] = new Image(AssetLoader.manager.get("Choose/minicard_bg.png", Texture.class));
			miniCards[i].setSize(Gdx.graphics.getWidth()/10, (float) ((Gdx.graphics.getWidth()/10)*1.4533));
			miniCards[i].setPosition((miniCards[i].getWidth()+Gdx.graphics.getWidth()/20)*i,0);
			miniCards[i].setUserObject(i+9);
			miniCards[i].setVisible(false);
			miniCardsBG[i].setSize(Gdx.graphics.getWidth()/10, (float) ((Gdx.graphics.getWidth()/10)*1.4533));
			miniCardsBG[i].setPosition((miniCardsBG[i].getWidth()+Gdx.graphics.getWidth()/20)*i,0);
			cardGroup.addActor(miniCardsBG[i]);
			cardGroup.addActor(miniCards[i]);
		}
		scene.put((Integer) cardGroup.getUserObject(), cardGroup);
	}
	
	
	private void setupSmallPurple() {
		smallPurple = new Image(AssetLoader.manager.get("Style/lightpurp.png", Texture.class));
		smallPurple.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/20);
		smallPurple.setPosition(0, (Gdx.graphics.getHeight()/7)*2+Gdx.graphics.getHeight()/2);
		smallPurple.setUserObject(10);
		scene.put((Integer) smallPurple.getUserObject(), smallPurple);
		
	}

	private void setupBottom() {
		style_menu_startbutton = createTextButtonStyle("Back/backbutton.atlas","backbutton","backbutton_dark", Gdx.graphics.getWidth()/14);
		
	    //Start button
		backButton = new MenuButton("",style_menu_startbutton,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/7);
		backButton.setUserObject(11);
	    scene.put((Integer) backButton.getUserObject(), backButton);
		
	}
	
	
	
	

}
