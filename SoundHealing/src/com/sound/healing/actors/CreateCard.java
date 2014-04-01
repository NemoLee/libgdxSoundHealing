package com.sound.healing.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.sound.healing.AssetLoader;
import com.sound.healing.cards.AllCards;
import com.sound.healing.cards.CardEnum;
import com.sound.healing.custom.MenuButton;
import com.sound.healing.screens.ScreenSpec;

public class CreateCard extends CreateScene{
	
	private Image largeCard;
	private TextButtonStyle style_info_backbutton,style_info_startButton;
	private MenuButton backButton, saveButton;
	
	public CreateCard() {
		setupCard();
		setupBottom();
		spec = new ScreenSpec(scene);
	}

	private void setupCard() {
		largeCard = new Image(AssetLoader.manager.get("Card/"+AllCards.getInstance().getCurrentCard().getCardSpec().getCardProperty(CardEnum.IMAGE.getEnumID()), Texture.class));
		largeCard.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/7);
		largeCard.setPosition(0, Gdx.graphics.getHeight()/7);
		largeCard.setUserObject(0);
		scene.put((Integer) largeCard.getUserObject(), largeCard);
		
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
	
	

}
