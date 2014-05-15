package com.sound.healing.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.sound.healing.AssetLoader;
import com.sound.healing.custom.BackButton;
import com.sound.healing.custom.MenuButton;
import com.sound.healing.screens.ScreenSpec;

public class CreateIndividual extends CreateScene{
	
	
	private BackButton backButton;
	private ButtonStyle style_menu_startbutton;
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
		darkPurple = new Image(allAtlas.findRegion("darkpurp"));
		darkPurple.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/2);
		darkPurple.setPosition(0, (Gdx.graphics.getHeight()/7)*2);
		darkPurple.setUserObject(1);
		scene.add(darkPurple);
		
		
		bigCards = new Image[8];
		bigCards[0] = new Image(allAtlas.findRegion("spread81"));
		bigCards[1] = new Image(allAtlas.findRegion("spread82"));
		bigCards[2] = new Image(allAtlas.findRegion("spread83"));
		bigCards[3] = new Image(allAtlas.findRegion("spread84"));
		bigCards[4] = new Image(allAtlas.findRegion("spread85"));
		bigCards[5] = new Image(allAtlas.findRegion("spread86"));
		bigCards[6] = new Image(allAtlas.findRegion("spread87"));
		bigCards[7] = new Image(allAtlas.findRegion("spread88"));

		
		for(int i = 0; i < 8; i++){
			bigCards[i].setSize(Gdx.graphics.getWidth()/8, (float)(Gdx.graphics.getWidth()/8*1.4533));
			bigCards[i].setUserObject(i+2);
		}
		
		bigCards[0].setPosition(bigCards[0].getWidth(), (Gdx.graphics.getHeight()/4)*2+Gdx.graphics.getHeight()/16);
		bigCards[1].setPosition(bigCards[1].getWidth(), (Gdx.graphics.getHeight()/4)+Gdx.graphics.getHeight()/16);
		bigCards[2].setPosition(bigCards[2].getWidth()*2+bigCards[2].getWidth()/2, (Gdx.graphics.getHeight()/4)*2+Gdx.graphics.getHeight()/16);
		bigCards[3].setPosition(bigCards[3].getWidth()*2+bigCards[3].getWidth()/2, (Gdx.graphics.getHeight()/4)+Gdx.graphics.getHeight()/16);
		bigCards[4].setPosition((bigCards[4].getWidth()*3+bigCards[4].getWidth()), (Gdx.graphics.getHeight()/4)*2+Gdx.graphics.getHeight()/16);
		bigCards[5].setPosition((bigCards[5].getWidth()*3+bigCards[5].getWidth()), (Gdx.graphics.getHeight()/4)+Gdx.graphics.getHeight()/16);
		bigCards[6].setPosition((bigCards[6].getWidth()*4+bigCards[6].getWidth()+bigCards[6].getWidth()/2), (Gdx.graphics.getHeight()/4)*2+Gdx.graphics.getHeight()/16);
		bigCards[7].setPosition((bigCards[7].getWidth()*4+bigCards[7].getWidth()+bigCards[7].getWidth()/2), (Gdx.graphics.getHeight()/4)+Gdx.graphics.getHeight()/16);
		
		scene.add(bigCards[0]);
		scene.add(bigCards[1]);
		scene.add(bigCards[2]);
		scene.add(bigCards[3]);
		scene.add(bigCards[4]);
		scene.add(bigCards[5]);
		scene.add(bigCards[6]);
		scene.add(bigCards[7]);
		
	}
	
	private void setupMiniCards() {
		lightPurple = new Image(allAtlas.findRegion("lightpurp"));
		lightPurple.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/7);
		lightPurple.setPosition(0, Gdx.graphics.getHeight()/7);
		lightPurple.setUserObject(10);
		scene.add(lightPurple);
		
		miniCards = new Image[1];
		miniCardsBG = new Image[1];
		cardGroup = new HorizontalGroup();
		cardGroup.setSize((Gdx.graphics.getWidth()/10+Gdx.graphics.getWidth()/20)*miniCards.length, (Gdx.graphics.getWidth()/2)+Gdx.graphics.getWidth()/8);
		cardGroup.setPosition(Gdx.graphics.getWidth()/2-cardGroup.getWidth()/2+Gdx.graphics.getWidth()/40,Gdx.graphics.getHeight()/7+Gdx.graphics.getHeight()/42);
		cardGroup.setLayoutEnabled(false);
		cardGroup.setUserObject(11);
		for(int i = 0; i < miniCards.length; i++){
			miniCards[i] = new Image(allAtlas.findRegion("bigcard"));
			miniCardsBG[i] = new Image(allAtlas.findRegion("minicard_bg"));
			miniCards[i].setSize(Gdx.graphics.getWidth()/10, (float) ((Gdx.graphics.getWidth()/10)*1.4533));
			miniCards[i].setPosition((miniCards[i].getWidth()+Gdx.graphics.getWidth()/20)*i,0);
			miniCards[i].setUserObject(i);
			miniCards[i].setVisible(false);
			miniCardsBG[i].setSize(Gdx.graphics.getWidth()/10, (float) ((Gdx.graphics.getWidth()/10)*1.4533));
			miniCardsBG[i].setPosition((miniCardsBG[i].getWidth()+Gdx.graphics.getWidth()/20)*i,0);
			cardGroup.addActor(miniCardsBG[i]);
			cardGroup.addActor(miniCards[i]);
		}
		scene.add(cardGroup);
	}
	
	
	private void setupSmallPurple() {
		smallPurple = new Image(allAtlas.findRegion("lightpurp"));
		smallPurple.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/20);
		smallPurple.setPosition(0, (Gdx.graphics.getHeight()/7)*2+Gdx.graphics.getHeight()/2);
		smallPurple.setUserObject(12);
		scene.add(smallPurple);
		
	}

	private void setupBottom() {
		style_menu_startbutton = createImageButtonStyle("Back/backbutton.atlas","backbutton","backbutton_dark");
		
	    //Start button
		backButton = new BackButton(style_menu_startbutton,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/7);
		backButton.setUserObject(13);
	    scene.add(backButton);
		
	}
	
	
	
	

}
