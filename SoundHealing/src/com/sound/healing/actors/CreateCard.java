package com.sound.healing.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane.SplitPaneStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.sound.healing.AssetLoader;
import com.sound.healing.cards.AllCards;
import com.sound.healing.cards.CardEnum;
import com.sound.healing.cards.CardType;
import com.sound.healing.custom.MenuButton;
import com.sound.healing.screens.ScreenSpec;

public class CreateCard extends CreateScene{
	
	private Image largeCard, sound1, sound2;
	private TextButtonStyle style_info_backbutton,style_info_flipButton;
	private MenuButton backButton, flipButton;
	private TextureRegion textureRegion;
	private TextureRegionDrawable textureRegionDrawable;
	private Table table, container;
	private ScrollPane scroll;
	private Label labelDescription;
	private FreeTypeFontParameter font2;
	private LabelStyle style;
	private BitmapFont descriptionFont;
	private HorizontalGroup hg;
	
	public CreateCard() {
		setupCard();
		setupBottom();
		setupCardBack();
		spec = new ScreenSpec(scene);
	}


	private void setupCard() {
		textureRegion = new TextureRegion(AssetLoader.manager.get("Card/"+AllCards.getInstance().getCurrentCard().getCardSpec().getCardProperty(CardEnum.IMAGE.getEnumID()), Texture.class));
		textureRegionDrawable = new TextureRegionDrawable(textureRegion);
		largeCard = new Image(textureRegionDrawable);
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
	    
	    style_info_flipButton = createTextButtonStyle("Card/flipbutton.atlas","flipbutton","flipbutton_dark", Gdx.graphics.getWidth()/14);
		
	    flipButton = new MenuButton("",style_info_flipButton,Gdx.graphics.getWidth()/2,0,Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/7);
	    flipButton.setUserObject(2);
	    scene.put((Integer) flipButton.getUserObject(), flipButton);
	    
	}
	
	private void setupCardBack() {
		
		table = new Table();
		container = new Table();
		table.setBounds(0, 0, Gdx.graphics.getWidth(), 9*(Gdx.graphics.getHeight()/6));
		scroll = new ScrollPane(table);
		container.add(scroll).width(Gdx.graphics.getWidth()).height(Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/7);
		container.row();
		container.setUserObject(3);
		container.setBounds(0, Gdx.graphics.getHeight()/7, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/7);
		container.setBackground(new TextureRegionDrawable(new TextureRegion(AssetLoader.manager.get("Style/lightpurp.png", Texture.class))));
		
		
		font2 = new FreeTypeFontParameter();
		font2.size = Gdx.graphics.getWidth()/25;
		descriptionFont = AssetLoader.getInstance().generator.generateFont(font2);
		style = new LabelStyle(descriptionFont, Color.WHITE);
		labelDescription = new Label("DESCRIPTION:\n\n"+(String) AllCards.getInstance().getCurrentCard().getCardSpec().getCardProperty(CardEnum.DESCRIPTION.getEnumID()), style);
		labelDescription.setWrap(true);
		labelDescription.setAlignment(Align.top | Align.left, Align.left);
		labelDescription.setSize(Gdx.graphics.getWidth()-Gdx.graphics.getWidth()/200, Gdx.graphics.getHeight()/2);
		labelDescription.setUserObject(4);
		labelDescription.setPosition(Gdx.graphics.getWidth()/100,  Gdx.graphics.getHeight()/2);
		//scene.put((Integer) labelDescription.getUserObject(), labelDescription);
		table.top();
	    table.add(labelDescription).size(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/2);
	    table.row();
	   
	    sound1 = new Image(AssetLoader.manager.get("Instruct/instruct_i.png", Texture.class));
	    sound1.setSize(Gdx.graphics.getWidth()/4, Gdx.graphics.getWidth()/4);
	    sound1.setPosition(Gdx.graphics.getWidth()/8, 0);
	    sound1.setUserObject(5);
	    
	    sound2 = new Image(AssetLoader.manager.get(((CardType) AllCards.getInstance().getCurrentCard().getCardSpec().getCardProperty(CardEnum.TYPE.getEnumID())).getSoundID(),Texture.class));
	    sound2.setSize(Gdx.graphics.getWidth()/4, Gdx.graphics.getWidth()/4);
	    sound2.setPosition((Gdx.graphics.getWidth()/8)*5, 0);
	    sound2.setUserObject(6);
	    
	    
	    hg = new HorizontalGroup();
	    hg.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/4);
	    hg.setLayoutEnabled(false);
	    hg.addActor(sound1);
	    hg.addActor(sound2);
	    table.add(hg).left();
	    
	    container.setVisible(false);
	    scene.put((Integer) container.getUserObject(), container);
	   
	    
	}
	
	@Override
	public void reset(){
		textureRegion.setTexture(AssetLoader.manager.get("Card/"+AllCards.getInstance().getCurrentCard().getCardSpec().getCardProperty(CardEnum.IMAGE.getEnumID()), Texture.class));
		textureRegionDrawable.setRegion(textureRegion);
		largeCard.setDrawable(textureRegionDrawable);
		labelDescription.setText("DESCRIPTION:\n\n"+(String) AllCards.getInstance().getCurrentCard().getCardSpec().getCardProperty(CardEnum.DESCRIPTION.getEnumID()));
		
	}
	
	

}
