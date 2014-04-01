package com.sound.healing.actors;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.utils.Array;
import com.sound.healing.AssetLoader;
import com.sound.healing.cards.AllCards;
import com.sound.healing.cards.Card;
import com.sound.healing.cards.CardEnum;
import com.sound.healing.custom.MenuButton;
import com.sound.healing.screens.ScreenSpec;

public class CreateReveal extends CreateScene{
	
	private MenuButton backButton, saveButton;
	private TextButtonStyle style_info_backbutton, style_info_startButton;
	private Image darkPurple;
	private Image[] backCards, frontCards;
	private Array<Card> cards;
	private int cardWidth, cardHeight;
	private Array<Integer> locations;
	
	public CreateReveal() {
		setupCards();
		setupTop(SceneHandler.getInstance().getSpread().toString());
		cardWidth = (Gdx.graphics.getWidth()-(SceneHandler.getInstance().getSpread().getNumberOfCards()*10))/SceneHandler.getInstance().getSpread().getNumberOfCards();
		cardHeight = (int)(cardWidth*1.4533);
		locations = SceneHandler.getInstance().getSpread().getSpreadLayout();
		//locations = SceneHandler.getInstance().getSpread().getSpreadLayout();
		setupBottom();
		setupReveal();
		spec = new ScreenSpec(scene);
	}

	private void setupCards() {
		cards = null;
		cards = new Array<Card>();
		int x = 0;
		for(int i = 0; i < SceneHandler.getInstance().getSpread().getNumberOfCards(); i++){
			x = MathUtils.random(51);
			if(!cards.contains(AllCards.getInstance().getCard(x), false)){
				cards.add(AllCards.getInstance().getCard(x));
			}
			else{
				i--;
			}
		}
	}

	private void setupReveal() {
		darkPurple = new Image(AssetLoader.manager.get("Style/darkpurp.png", Texture.class));
		darkPurple.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/2+Gdx.graphics.getHeight()/5-Gdx.graphics.getHeight()/120);
		darkPurple.setPosition(0, Gdx.graphics.getHeight()/7);
		darkPurple.setUserObject(3);
		scene.put((Integer) darkPurple.getUserObject(), darkPurple);
		int locationCounter = 0;
		int x = 4;
		backCards = new Image[(locations.size/2)];
		frontCards = new Image[(locations.size/2)];
		for(int i = 0; i < backCards.length; i++){
			backCards[i] = new Image(AssetLoader.manager.get("Choose/bigcard.png", Texture.class));
			frontCards[i] = new Image(AssetLoader.manager.get("Card/"+cards.get(i).getCardSpec().getCardProperty(CardEnum.ID.getEnumID())+".png", Texture.class));
			backCards[i].setSize(cardWidth, cardHeight);
			frontCards[i].setSize(cardWidth, cardHeight);
			backCards[i].setPosition(locations.get(locationCounter), locations.get(locationCounter+1));
			frontCards[i].setPosition(locations.get(locationCounter), locations.get(locationCounter+1));
			frontCards[i].setName(cards.get(i).getCardSpec().getCardProperty(CardEnum.ID.getEnumID())+"");
			backCards[i].setName(cards.get(i).getCardSpec().getCardProperty(CardEnum.ID.getEnumID())+"");
			backCards[i].setUserObject(x+1);
			frontCards[i].setUserObject(x);
			frontCards[i].setVisible(false);
			scene.put(x, frontCards[i]);
			scene.put(x+1, backCards[i]);
			x+=2;
			locationCounter+=2;
		}
		
		
	}
	

	private void setupBottom() {
		
		style_info_backbutton = createTextButtonStyle("Back/backbuttonsmall.atlas","backbuttonsmall","backbuttonsmall_dark", Gdx.graphics.getWidth()/14);
		
		backButton = new MenuButton("",style_info_backbutton,0,0,Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/7);
		backButton.setUserObject(1);
	    scene.put((Integer) backButton.getUserObject(), backButton);
	    
	    style_info_startButton = createTextButtonStyle("Reveal/savebutton.atlas","savebutton","savebutton_dark", Gdx.graphics.getWidth()/14);
		
	    saveButton = new MenuButton("",style_info_startButton,Gdx.graphics.getWidth()/2,0,Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/7);
	    saveButton.setUserObject(2);
	    scene.put((Integer) saveButton.getUserObject(), saveButton);
		
	}

	public void reset() {
		
		backCards = null;
		frontCards = null;
		setupCards();
		cardWidth = (Gdx.graphics.getWidth()-(SceneHandler.getInstance().getSpread().getNumberOfCards()*10))/SceneHandler.getInstance().getSpread().getNumberOfCards();
		cardHeight = (int)(cardWidth*1.4533);
		locations = SceneHandler.getInstance().getSpread().getSpreadLayout();
		int locationCounter = 0;
		int x = 4;
		backCards = new Image[(locations.size/2)];
		frontCards = new Image[(locations.size/2)];
		for(int i = 0; i < backCards.length; i++){
			backCards[i] = new Image(AssetLoader.manager.get("Choose/bigcard.png", Texture.class));
			frontCards[i] = new Image(AssetLoader.manager.get("Card/"+cards.get(i).getCardSpec().getCardProperty(CardEnum.ID.getEnumID())+".png", Texture.class));
			backCards[i].setSize(cardWidth, cardHeight);
			frontCards[i].setSize(cardWidth, cardHeight);
			backCards[i].setPosition(locations.get(locationCounter), locations.get(locationCounter+1));
			frontCards[i].setPosition(locations.get(locationCounter), locations.get(locationCounter+1));
			frontCards[i].setName(cards.get(i).getCardSpec().getCardProperty(CardEnum.ID.getEnumID())+"");
			backCards[i].setName(cards.get(i).getCardSpec().getCardProperty(CardEnum.ID.getEnumID())+"");
			backCards[i].setUserObject(x+1);
			frontCards[i].setUserObject(x);
			frontCards[i].setVisible(false);
			scene.put(x, frontCards[i]);
			scene.put(x+1, backCards[i]);
			x+=2;
			locationCounter+=2;
			
		}
	}
}
