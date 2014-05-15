package com.sound.healing.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.utils.Array;
import com.sound.healing.AssetLoader;
import com.sound.healing.cards.AllCards;
import com.sound.healing.cards.Card;
import com.sound.healing.cards.CardEnum;
import com.sound.healing.custom.MenuButton;
import com.sound.healing.custom.Spread;
import com.sound.healing.screens.ScreenSpec;

public class CreateLoadReveal extends CreateScene{
	
	private MenuButton backButton, saveButton;
	private TextButtonStyle style_info_backbutton, style_info_startButton;
	private Image darkPurple;
	private Image[] backCards, frontCards;
	private Array<Card> cards;
	private int cardWidth, cardHeight;
	private int x = 4;
	private Array<Integer> locations;
	
	public CreateLoadReveal() {
		cards = AllCards.getInstance().getLoadedCards();
		setupTop(SceneHandler.getInstance().getSpread().toString());
		if(SceneHandler.getInstance().getSpread().equals(Spread.MULTI)){
			cardWidth = (Gdx.graphics.getWidth()-(11*10))/11;
		}
		else if(SceneHandler.getInstance().getSpread().equals(Spread.SINGLE)){
			cardWidth = (Gdx.graphics.getWidth()-(3*10))/3;
		}
		else if(SceneHandler.getInstance().getSpread().equals(Spread.SOUND_ADVICE)){
			cardWidth = (Gdx.graphics.getWidth()-(4*10))/4;
		}
		else{
			cardWidth = (Gdx.graphics.getWidth()-(cards.size*10))/cards.size;
		}
		cardHeight = (int)(cardWidth*1.4533);
		locations = SceneHandler.getInstance().getSpread().getSpreadLayout();
		setupBottom();
		setupReveal();
		spec = new ScreenSpec(scene);
	}

	private void setupReveal() {
		darkPurple = new Image(allAtlas.findRegion("darkpurp"));
		darkPurple.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/2+Gdx.graphics.getHeight()/5-Gdx.graphics.getHeight()/120);
		darkPurple.setPosition(0, Gdx.graphics.getHeight()/7);
		darkPurple.setUserObject(3);
		scene.add(darkPurple);
		int locationCounter = 0;
		int x = 4;
		backCards = new Image[(cards.size)];
		frontCards = new Image[(cards.size)];
		for(int i = 0; i < backCards.length; i++){
			backCards[i] = new Image(allAtlas.findRegion("bigcard"));
			frontCards[i] = new Image(AssetLoader.manager.get("Card/cardsheet.atlas", TextureAtlas.class).findRegion((String) ""+cards.get(i).getCardSpec().getCardProperty(CardEnum.ID.getEnumID())));
			backCards[i].setSize(cardWidth, cardHeight);
			frontCards[i].setSize(cardWidth, cardHeight);
			backCards[i].setPosition(locations.get(locationCounter), locations.get(locationCounter+1));
			frontCards[i].setPosition(locations.get(locationCounter), locations.get(locationCounter+1));
			frontCards[i].setName(cards.get(i).getCardSpec().getCardProperty(CardEnum.ID.getEnumID())+"");
			backCards[i].setName(cards.get(i).getCardSpec().getCardProperty(CardEnum.ID.getEnumID())+"");
			backCards[i].setUserObject(x+1);
			frontCards[i].setUserObject(x);
			frontCards[i].setVisible(false);
			scene.add(frontCards[i]);
			scene.add(backCards[i]);
			x+=2;
			locationCounter+=2;
		}
		
		
	}
	

	private void setupBottom() {
		
		style_info_backbutton = createTextButtonStyle("Back/backbuttonsmall.atlas","backbuttonsmall","backbuttonsmall_dark", Gdx.graphics.getWidth()/14);
		
		backButton = new MenuButton("",style_info_backbutton,0,0,Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/7);
		backButton.setUserObject(1);
	    scene.add(backButton);
	    
	    style_info_startButton = createTextButtonStyle("Reveal/savebutton.atlas","savebutton_dark","savebutton_dark", Gdx.graphics.getWidth()/14);
		
	    saveButton = new MenuButton("",style_info_startButton,Gdx.graphics.getWidth()/2,0,Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/7);
	    saveButton.setUserObject(2);
	    scene.add(saveButton);
		
	}

	@Override
	public void reset() {
		
		backCards = null;
		frontCards = null;
		cards = null;
		cards = AllCards.getInstance().getLoadedCards();
		if(SceneHandler.getInstance().getSpread().equals(Spread.MULTI)){
			cardWidth = (Gdx.graphics.getWidth()-(11*10))/11;
		}
		else if(SceneHandler.getInstance().getSpread().equals(Spread.SINGLE)){
			cardWidth = (Gdx.graphics.getWidth()-(3*10))/3;
		}
		else if(SceneHandler.getInstance().getSpread().equals(Spread.SOUND_ADVICE)){
			cardWidth = (Gdx.graphics.getWidth()-(4*10))/4;
		}
		else{
			cardWidth = (Gdx.graphics.getWidth()-(cards.size*10))/cards.size;
		}
		cardHeight = (int)(cardWidth*1.4533);
		locations = SceneHandler.getInstance().getSpread().getSpreadLayout();
		int locationCounter = 0;
		x = 4;
		int size = scene.size();
		for(int i = x; i < size; i++){
				scene.remove(x);
				//spec.getActors().remove(x);
		}
		backCards = new Image[(cards.size)];
		frontCards = new Image[(cards.size)];
		for(int i = 0; i < backCards.length; i++){
			backCards[i] = new Image(allAtlas.findRegion("bigcard"));
			frontCards[i] = new Image(AssetLoader.manager.get("Card/cardsheet.atlas", TextureAtlas.class).findRegion((String) ""+cards.get(i).getCardSpec().getCardProperty(CardEnum.ID.getEnumID())));
			backCards[i].setSize(cardWidth, cardHeight);
			frontCards[i].setSize(cardWidth, cardHeight);
			backCards[i].setPosition(locations.get(locationCounter), locations.get(locationCounter+1));
			frontCards[i].setPosition(locations.get(locationCounter), locations.get(locationCounter+1));
			frontCards[i].setName(cards.get(i).getCardSpec().getCardProperty(CardEnum.ID.getEnumID())+"");
			backCards[i].setName(cards.get(i).getCardSpec().getCardProperty(CardEnum.ID.getEnumID())+"");
			backCards[i].setUserObject(x+1);
			frontCards[i].setUserObject(x);
			frontCards[i].setVisible(false);
			scene.add(frontCards[i]);
			scene.add(backCards[i]);
			x+=2;
			locationCounter+=2;
		}
		
		//group.setVisible(false);
		//group.setUserObject(x);
		//scene.put((Integer) group.getUserObject(), group);
	    
		
	}
}
