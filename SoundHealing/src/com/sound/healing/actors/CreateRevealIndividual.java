package com.sound.healing.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.sound.healing.AssetLoader;
import com.sound.healing.cards.AllCards;
import com.sound.healing.cards.Card;
import com.sound.healing.cards.CardEnum;
import com.sound.healing.custom.MenuButton;
import com.sound.healing.custom.Spread;
import com.sound.healing.screens.ScreenSpec;

public class CreateRevealIndividual extends CreateScene{
	
	private MenuButton backButton, saveButton;
	private TextButton yes, no;
	private TextButtonStyle style_info_backbutton, style_info_startButton, style_yes,style_no;
	private Image darkPurple, black, popupBackground;
	private Image[] backCards, frontCards;
	private Array<Card> cards;
	private int cardWidth, cardHeight;
	private Array<Integer> locations;
	private int x = 4;
	private FreeTypeFontParameter font;
	private BitmapFont descriptionFont;
	private LabelStyle style;
	private Label labelDescription;
	private Group group;

	public CreateRevealIndividual() {
		cards = AllCards.getInstance().getIndividual();
		setupTop(SceneHandler.getInstance().getSpread().toString());
		if(SceneHandler.getInstance().getSpread().equals(Spread.MULTI)){
			cardWidth = (Gdx.graphics.getWidth()-(11*10))/11;
		}
		else{
			cardWidth = (Gdx.graphics.getWidth()-(cards.size*10))/cards.size;
		}
		cardHeight = (int)(cardWidth*1.4533);
		locations = SceneHandler.getInstance().getSpread().getSpreadLayout();
		//locations = SceneHandler.getInstance().getSpread().getSpreadLayout();
		setupBottom();
		setupReveal();
		setupDialog();
		spec = new ScreenSpec(scene);
	}

	private void setupDialog() {
		group = new Group();
		group.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		group.setPosition(0, 0);
		group.setUserObject(x);
		group.setVisible(false);
		black = new Image(allAtlas.findRegion("darkpurp"));
		black.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		black.setPosition(0, 0);
		black.addAction(Actions.alpha(0.8f));
		black.setUserObject(x);
		//black.setVisible(false);
		group.addActor(black);
	   // scene.put((Integer) black.getUserObject(), black);
	    popupBackground = new Image(AssetLoader.manager.get("UI/wait.png", Texture.class));
	    popupBackground.setSize(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/3);
	    popupBackground.setPosition(Gdx.graphics.getWidth()/4, Gdx.graphics.getHeight()/3);
	    popupBackground.setUserObject(x+1);
	   // popupBackground.setVisible(false);
	    group.addActor(popupBackground);
	   // scene.put((Integer) popupBackground.getUserObject(), popupBackground);
	   
		//scene.put((Integer) labelDescription.getUserObject(), labelDescription);
		
		style_yes =  createTextButtonStyle("UI/yesbutton.atlas","yesbutton","yesbutton_dark", Gdx.graphics.getWidth()/18);
		style_no =  createTextButtonStyle("UI/nobutton.atlas","nobutton","nobutton_dark", Gdx.graphics.getWidth()/18);
		yes = new TextButton("", style_yes);
		no = new TextButton("", style_no);
		yes.setSize(Gdx.graphics.getWidth()/4-Gdx.graphics.getWidth()/400, Gdx.graphics.getWidth()/12);
		no.setSize(Gdx.graphics.getWidth()/4-Gdx.graphics.getWidth()/400, Gdx.graphics.getWidth()/12);
		yes.setPosition(Gdx.graphics.getWidth()/4, Gdx.graphics.getHeight()/3);
		no.setPosition(Gdx.graphics.getWidth()/4+(Gdx.graphics.getWidth()/4+Gdx.graphics.getWidth()/400), Gdx.graphics.getHeight()/3);
		yes.setUserObject(x+2);
		no.setUserObject(x+3);
		//yes.setVisible(false);
		//no.setVisible(false);
		group.addActor(yes);
		group.addActor(no);
		scene.put((Integer) group.getUserObject(), group);
		
		
	}

	private void setupReveal() {
		darkPurple = new Image(allAtlas.findRegion("darkpurp"));
		darkPurple.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/2+Gdx.graphics.getHeight()/5-Gdx.graphics.getHeight()/120);
		darkPurple.setPosition(0, Gdx.graphics.getHeight()/7);
		darkPurple.setUserObject(3);
		scene.put((Integer) darkPurple.getUserObject(), darkPurple);
		int locationCounter = 0;
		x = 4;
		backCards = new Image[(cards.size)];
		frontCards = new Image[(cards.size)];
		for(int i = 0; i < backCards.length; i++){
			backCards[i] = new Image(allAtlas.findRegion("bigcard"));
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
		System.out.print(x);
		
	}
	

	private void setupBottom() {
		
		style_info_backbutton = createTextButtonStyle("Back/backbuttonsmall.atlas","backbuttonsmall","backbuttonsmall_dark", Gdx.graphics.getWidth()/14);
		
		backButton = new MenuButton("",style_info_backbutton,0,0,Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/7);
		backButton.setUserObject(1);
	    scene.put((Integer) backButton.getUserObject(), backButton);
	    
	    style_info_startButton = createTextButtonStyle("Reveal/savebutton.atlas","savebutton_dark","savebutton_dark", Gdx.graphics.getWidth()/14);
		
	    saveButton = new MenuButton("",style_info_startButton,Gdx.graphics.getWidth()/2,0,Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/7);
	    saveButton.setUserObject(2);
	    scene.put((Integer) saveButton.getUserObject(), saveButton);
		
	}

	@Override
	public void reset() {
		
		backCards = null;
		frontCards = null;
		cards = null;
		cards = AllCards.getInstance().getIndividual();
		if(SceneHandler.getInstance().getSpread().equals(Spread.MULTI)){
			cardWidth = (Gdx.graphics.getWidth()-(11*10))/11;
		}
		else{
			cardWidth = (Gdx.graphics.getWidth()-(cards.size*10))/cards.size;
		}
		cardHeight = (int)(cardWidth*1.4533);
		locations = SceneHandler.getInstance().getSpread().getSpreadLayout();
		int locationCounter = 0;
		x = 4;
		backCards = new Image[(cards.size)];
		frontCards = new Image[(cards.size)];
		for(int i = 0; i < backCards.length; i++){
			backCards[i] = new Image(allAtlas.findRegion("bigcard"));
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
		for(int i = x; i < scene.size(); i++){
			if(scene.get(i)!= null){
				scene.get(i).setVisible(false);
			}
		}
		group.setVisible(false);
		group.setUserObject(x);
		scene.put((Integer) group.getUserObject(), group);
	    
		
	}
}
