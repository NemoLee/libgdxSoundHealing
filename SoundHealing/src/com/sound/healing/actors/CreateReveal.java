package com.sound.healing.actors;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.sound.healing.AssetLoader;
import com.sound.healing.cards.AllCards;
import com.sound.healing.cards.Card;
import com.sound.healing.cards.CardEnum;
import com.sound.healing.custom.MenuButton;
import com.sound.healing.custom.Spread;
import com.sound.healing.custom.TopImage;
import com.sound.healing.screens.ScreenSpec;

public class CreateReveal extends CreateScene{
	
	private MenuButton backButton, saveButton;
	private TextButton yes, no;
	private TextButtonStyle style_info_backbutton, style_info_startButton, style_yes,style_no;
	private Image darkPurple, black, popupBackground, help;
	private Image[] backCards, frontCards;
	private Array<Card> cards;
	private int cardWidth, cardHeight;
	private Array<Integer> locations;
	private int x = 5;
	private Group group;

	public CreateReveal() {
		cards = AllCards.getInstance().setupRevealCards();
		setupTop(SceneHandler.getInstance().getSpread().toString()+"          ");
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
		setupHelp();
		setupBottom();
		setupDialog();
		setupReveal();
		spec = new ScreenSpec(scene);
		
	}

	private void setupHelp() {
		help = new Image(AssetLoader.manager.get("Reveal/more_info_button.png", Texture.class));
		help.setSize(Gdx.graphics.getWidth()/10, Gdx.graphics.getWidth()/10);
		help.setPosition(Gdx.graphics.getWidth()-help.getWidth()-help.getWidth(), Gdx.graphics.getHeight()-topImage.getHeight()/2-help.getHeight()/2);
		help.setUserObject(1);
		scene.add(help);
		
	}

	private void setupDialog() {
		group = new Group();
		group.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		group.setPosition(0, 0);
		group.setUserObject(5);
		group.setVisible(false);
		black = new Image(allAtlas.findRegion("darkpurp"));
		black.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		black.setPosition(0, 0);
		black.addAction(Actions.alpha(0.8f));
		black.setUserObject(36);
		//black.setVisible(false);
		group.addActor(black);
	   // scene.put((Integer) black.getUserObject(), black);
	    popupBackground = new Image(AssetLoader.manager.get("UI/wait.png",Texture.class));
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

	private void setupReveal() {
		darkPurple = new Image(allAtlas.findRegion("darkpurp"));
		darkPurple.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/2+Gdx.graphics.getHeight()/5-Gdx.graphics.getHeight()/120);
		darkPurple.setPosition(0, Gdx.graphics.getHeight()/7);
		darkPurple.setUserObject(4);
		scene.add(darkPurple);
		int locationCounter = 0;
		x = 6;
		backCards = new Image[(cards.size)];
		frontCards = new Image[(cards.size)];
		for(int i = 0; i < backCards.length; i++){
			backCards[i] = new Image(allAtlas.findRegion("bigcard"));
			frontCards[i] = new Image(AssetLoader.manager.get("Card/cardsheet.atlas", TextureAtlas.class).findRegion((String)""+cards.get(i).getCardSpec().getCardProperty(CardEnum.ID.getEnumID())));
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
		System.out.print(x);
		
	}
	

	private void setupBottom() {
		
		style_info_backbutton = createTextButtonStyle("Back/backbuttonsmall.atlas","backbuttonsmall","backbuttonsmall_dark", Gdx.graphics.getWidth()/14);
		
		backButton = new MenuButton("",style_info_backbutton,0,0,Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/7);
		backButton.setUserObject(2);
	    scene.add(backButton);
	    
	    style_info_startButton = createTextButtonStyle("Reveal/savebutton.atlas","savebutton","savebutton_dark", Gdx.graphics.getWidth()/14);
		
	    saveButton = new MenuButton("",style_info_startButton,Gdx.graphics.getWidth()/2,0,Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/7);
	    saveButton.setUserObject(3);
	    scene.add(saveButton);
		
	}

	@Override
	public void reset() {
		
		backCards = null;
		frontCards = null;
		cards = null;
		cards = AllCards.getInstance().setupRevealCards();
		topImage.setText(SceneHandler.getInstance().getSpread().toString()+"          ");
		switch(SceneHandler.getInstance().getSpread()){
		case SOUND_ADVICE:
			help.setPosition(Gdx.graphics.getWidth()-help.getWidth()-2*help.getWidth(), Gdx.graphics.getHeight()-topImage.getHeight()/2-help.getHeight()/2);
			break;
		case SYMPHONY_OF_LIFE:
			help.setPosition(Gdx.graphics.getWidth()-2*help.getWidth()-help.getWidth()/8, Gdx.graphics.getHeight()-topImage.getHeight()/2-help.getHeight()/2);
			break;
		case DUET:
			help.setPosition(Gdx.graphics.getWidth()-help.getWidth()-3*help.getWidth(), Gdx.graphics.getHeight()-topImage.getHeight()/2-help.getHeight()/2);
			break;
		case HEARTSONG:
			help.setPosition(Gdx.graphics.getWidth()-help.getWidth()-2*help.getWidth(), Gdx.graphics.getHeight()-topImage.getHeight()/2-help.getHeight()/2);
			break;
		case RETUNING:
			help.setPosition(Gdx.graphics.getWidth()-help.getWidth()-2*help.getWidth(), Gdx.graphics.getHeight()-topImage.getHeight()/2-help.getHeight()/2);
			break;
		case SINGING_EARTH:
			help.setPosition(Gdx.graphics.getWidth()-help.getWidth()-2*help.getWidth(), Gdx.graphics.getHeight()-topImage.getHeight()/2-help.getHeight()/2);
			break;
		case ANGELS_OF_SOUND:
			help.setPosition(Gdx.graphics.getWidth()-help.getWidth()-help.getWidth(), Gdx.graphics.getHeight()-topImage.getHeight()/2-help.getHeight()/2);
			break;
		case INDIVIDUAL:
			help.setPosition(Gdx.graphics.getWidth()-help.getWidth()-help.getWidth(), Gdx.graphics.getHeight()-topImage.getHeight()/2-help.getHeight()/2);
			break;
		case MULTI:
			help.setPosition(Gdx.graphics.getWidth()-help.getWidth()-help.getWidth(), Gdx.graphics.getHeight()-topImage.getHeight()/2-help.getHeight()/2);
			break;
		default:
			break;
	}		
		
		if(SceneHandler.getInstance().getSpread().equals(Spread.MULTI)){
			cardWidth = (Gdx.graphics.getWidth()-(11*10))/11;
		}
		else if(SceneHandler.getInstance().getSpread().equals(Spread.SOUND_ADVICE)){
			cardWidth = (Gdx.graphics.getWidth()-(4*10))/4;
		}
		else if(SceneHandler.getInstance().getSpread().equals(Spread.SINGLE)){
			cardWidth = (Gdx.graphics.getWidth()-(3*10))/3;
		}
		else{
			cardWidth = (Gdx.graphics.getWidth()-(cards.size*10))/cards.size;
		}
		cardHeight = (int)(cardWidth*1.4533);
		locations = SceneHandler.getInstance().getSpread().getSpreadLayout();
		int locationCounter = 0;
		x = 6;
		int size = scene.size();
		for(int i = x; i < size; i++){
				scene.remove(x);
				//spec.getActors().remove(x);
		}
		backCards = new Image[(cards.size)];
		frontCards = new Image[(cards.size)];
		for(int i = 0; i < backCards.length; i++){
			backCards[i] = new Image(allAtlas.findRegion("bigcard"));
			frontCards[i] = new Image(AssetLoader.manager.get("Card/cardsheet.atlas", TextureAtlas.class).findRegion((String)""+cards.get(i).getCardSpec().getCardProperty(CardEnum.ID.getEnumID())));
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
}
