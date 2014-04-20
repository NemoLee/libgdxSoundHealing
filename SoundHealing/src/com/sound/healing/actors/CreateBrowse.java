package com.sound.healing.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.sound.healing.AssetLoader;
import com.sound.healing.cards.AllCards;
import com.sound.healing.cards.Card;
import com.sound.healing.cards.CardEnum;
import com.sound.healing.custom.MenuButton;
import com.sound.healing.screens.ScreenSpec;

public class CreateBrowse extends CreateScene{
	
	private TextButtonStyle style_menu_startbutton;
	private MenuButton backButton;
	private Image selectType, root, sacral, throat, heart, thirdEye, crown, solar, whole, angel;
	private TextureRegion textureRegion;
	private TextureRegionDrawable textureRegionDrawable;
	private Table table, container;
	private ScrollPane scroll;
	private Card[] scrollCards;
	
	public CreateBrowse() {
		
		setupTop("BROWSE");
		setupBottom();
		setupCardScroll();
		setupOverlay();
		spec = new ScreenSpec(scene);
		
	}

	private void setupOverlay() {
		textureRegion = new TextureRegion(allAtlas.findRegion("select_type_down"));
		textureRegionDrawable = new TextureRegionDrawable(textureRegion);
		selectType = new Image(textureRegionDrawable);
		selectType.setUserObject(2);
		selectType.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/8);
		selectType.setPosition(0, Gdx.graphics.getHeight()-(topImage.getHeight()+selectType.getHeight()));
		scene.put((Integer) selectType.getUserObject(), selectType);
		float offset = (Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/8+topImage.getHeight()+backButton.getHeight()));
		
		
		root = new Image(allAtlas.findRegion("rootbtn"));
		root.setUserObject(4);
		root.setSize(Gdx.graphics.getWidth()/2, offset/6);
		root.setPosition(0, offset+backButton.getHeight()-offset/6);
		root.setVisible(false);
		scene.put((Integer) root.getUserObject(), root);
		
		sacral = new Image(allAtlas.findRegion("sacralbtn"));
		sacral.setUserObject(5);
		sacral.setSize(Gdx.graphics.getWidth()/2, offset/6);
		sacral.setPosition(Gdx.graphics.getWidth()/2, offset+backButton.getHeight()-offset/6);
		sacral.setVisible(false);
		scene.put((Integer) sacral.getUserObject(), sacral);
		
		throat = new Image(allAtlas.findRegion("throatbtn"));
		throat.setUserObject(6);
		throat.setSize(Gdx.graphics.getWidth()/2, offset/6);
		throat.setPosition(0, offset+backButton.getHeight()-(offset/6)*2);
		throat.setVisible(false);
		scene.put((Integer) throat.getUserObject(), throat);
		
		heart = new Image(allAtlas.findRegion("heartbtn"));
		heart.setUserObject(7);
		heart.setSize(Gdx.graphics.getWidth()/2, offset/6);
		heart.setPosition(Gdx.graphics.getWidth()/2, offset+backButton.getHeight()-(offset/6)*2);
		heart.setVisible(false);
		scene.put((Integer) heart.getUserObject(), heart);
		
		thirdEye = new Image(allAtlas.findRegion("thirdeyebtn"));
		thirdEye.setUserObject(8);
		thirdEye.setSize(Gdx.graphics.getWidth()/2, offset/6);
		thirdEye.setPosition(0, offset+backButton.getHeight()-(offset/6)*3);
		thirdEye.setVisible(false);
		scene.put((Integer) thirdEye.getUserObject(), thirdEye);
		
		
		crown = new Image(allAtlas.findRegion("crownbtn"));
		crown.setUserObject(9);
		crown.setSize(Gdx.graphics.getWidth()/2, offset/6);
		crown.setPosition(Gdx.graphics.getWidth()/2, offset+backButton.getHeight()-(offset/6)*3);
		crown.setVisible(false);
		scene.put((Integer) crown.getUserObject(), crown);
		
		
		solar = new Image(allAtlas.findRegion("solarplexusbtn"));
		solar.setUserObject(10);
		solar.setSize(Gdx.graphics.getWidth(), offset/6);
		solar.setPosition(0, offset+backButton.getHeight()-(offset/6)*4);
		solar.setVisible(false);
		scene.put((Integer) solar.getUserObject(), solar);
		
		whole = new Image(allAtlas.findRegion("wholebodybtn"));
		whole.setUserObject(11);
		whole.setSize(Gdx.graphics.getWidth(), offset/6);
		whole.setPosition(0, offset+backButton.getHeight()-(offset/6)*5);
		whole.setVisible(false);
		scene.put((Integer) whole.getUserObject(), whole);
		
		angel = new Image(allAtlas.findRegion("angelcardsbtn"));
		angel.setUserObject(12);
		angel.setSize(Gdx.graphics.getWidth(), offset/6);
		angel.setPosition(0, offset+backButton.getHeight()-(offset));
		angel.setVisible(false);
		scene.put((Integer) angel.getUserObject(), angel);
		
		
	}

	private void setupCardScroll() {
		table = new Table();
		container = new Table();
		table.setBounds(0, 0, Gdx.graphics.getWidth(), (Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/8+topImage.getHeight()+backButton.getHeight())));
		scroll = new ScrollPane(table);
		scroll.setFlingTime(1.4f);
		container.add(scroll).width(Gdx.graphics.getWidth()).height((Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/8+topImage.getHeight()+backButton.getHeight())));
		container.row();
		container.setUserObject(3);
		container.setBounds(0, Gdx.graphics.getHeight()/7, Gdx.graphics.getWidth(), (Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/8+topImage.getHeight()+backButton.getHeight())));
		container.setBackground(new TextureRegionDrawable(new TextureRegion(allAtlas.findRegion("darkpurp"))));
		scrollCards = AllCards.getInstance().getCards();
		for(int i = 0; i < scrollCards.length; i++){
			Image image = new Image(AssetLoader.manager.get("Card/"+(String) scrollCards[i].getCardSpec().getCardProperty(CardEnum.IMAGE.getEnumID()), Texture.class));
			image.setUserObject(i+1);
			table.add(image).size(Gdx.graphics.getWidth()/3, (float) (Gdx.graphics.getWidth()/3*1.4533)).padLeft(Gdx.graphics.getWidth()/15);
			
		}
		
		scene.put((Integer) container.getUserObject(), container);
	}
	
	private void setupBottom() {
		style_menu_startbutton = createTextButtonStyle("Back/backbutton.atlas","backbutton","backbutton_dark", Gdx.graphics.getWidth()/14);
		
	    //Start button
		backButton = new MenuButton("",style_menu_startbutton,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/7);
		backButton.setUserObject(1);
	    scene.put((Integer) backButton.getUserObject(), backButton);
		
	}

}