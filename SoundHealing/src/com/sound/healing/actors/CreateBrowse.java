package com.sound.healing.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.TimeUtils;
import com.sound.healing.AssetLoader;
import com.sound.healing.cards.AllCards;
import com.sound.healing.cards.Card;
import com.sound.healing.cards.CardEnum;
import com.sound.healing.custom.BackButton;
import com.sound.healing.custom.MenuButton;
import com.sound.healing.screens.ScreenSpec;

public class CreateBrowse extends CreateScene{
	
	private ButtonStyle style_menu_startbutton;
	private BackButton backButton;
	private Image selectType, root, sacral, throat, heart, thirdEye, crown, solar, whole, angel;
	private TextureRegion textureRegion;
	private TextureRegionDrawable textureRegionDrawable;
	private Table table, container;
	private ScrollPane scroll;
	
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
		selectType.setUserObject(3);
		selectType.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/8);
		selectType.setPosition(0, Gdx.graphics.getHeight()-(topImage.getHeight()+selectType.getHeight()));
		scene.add(selectType);
		float offset = (Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/8+topImage.getHeight()+backButton.getHeight()));
		
		
		root = new Image(allAtlas.findRegion("rootbtn"));
		root.setUserObject(4);
		root.setSize(Gdx.graphics.getWidth()/2, offset/6);
		root.setPosition(0, offset+backButton.getHeight()-offset/6);
		root.setVisible(false);
		scene.add(root);
		
		sacral = new Image(allAtlas.findRegion("sacralbtn"));
		sacral.setUserObject(5);
		sacral.setSize(Gdx.graphics.getWidth()/2, offset/6);
		sacral.setPosition(Gdx.graphics.getWidth()/2, offset+backButton.getHeight()-offset/6);
		sacral.setVisible(false);
		scene.add(sacral);
		
		throat = new Image(allAtlas.findRegion("throatbtn"));
		throat.setUserObject(6);
		throat.setSize(Gdx.graphics.getWidth()/2, offset/6);
		throat.setPosition(0, offset+backButton.getHeight()-(offset/6)*2);
		throat.setVisible(false);
		scene.add(throat);
		
		heart = new Image(allAtlas.findRegion("heartbtn"));
		heart.setUserObject(7);
		heart.setSize(Gdx.graphics.getWidth()/2, offset/6);
		heart.setPosition(Gdx.graphics.getWidth()/2, offset+backButton.getHeight()-(offset/6)*2);
		heart.setVisible(false);
		scene.add(heart);
		
		thirdEye = new Image(allAtlas.findRegion("thirdeyebtn"));
		thirdEye.setUserObject(8);
		thirdEye.setSize(Gdx.graphics.getWidth()/2, offset/6);
		thirdEye.setPosition(0, offset+backButton.getHeight()-(offset/6)*3);
		thirdEye.setVisible(false);
		scene.add(thirdEye);
		
		
		crown = new Image(allAtlas.findRegion("crownbtn"));
		crown.setUserObject(9);
		crown.setSize(Gdx.graphics.getWidth()/2, offset/6);
		crown.setPosition(Gdx.graphics.getWidth()/2, offset+backButton.getHeight()-(offset/6)*3);
		crown.setVisible(false);
		scene.add(crown);
		
		
		solar = new Image(allAtlas.findRegion("solarplexusbtn"));
		solar.setUserObject(10);
		solar.setSize(Gdx.graphics.getWidth(), offset/6);
		solar.setPosition(0, offset+backButton.getHeight()-(offset/6)*4);
		solar.setVisible(false);
		scene.add(solar);
		
		whole = new Image(allAtlas.findRegion("wholebodybtn"));
		whole.setUserObject(11);
		whole.setSize(Gdx.graphics.getWidth(), offset/6);
		whole.setPosition(0, offset+backButton.getHeight()-(offset/6)*5);
		whole.setVisible(false);
		scene.add(whole);
		
		angel = new Image(allAtlas.findRegion("angelcardsbtn"));
		angel.setUserObject(12);
		angel.setSize(Gdx.graphics.getWidth(), offset/6);
		angel.setPosition(0, offset+backButton.getHeight()-(offset));
		angel.setVisible(false);
		scene.add(angel);
		
		
	}

	private void setupCardScroll() {
		table = new Table();
		container = new Table();
		table.setBounds(0, 0, Gdx.graphics.getWidth(), (Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/8+topImage.getHeight()+backButton.getHeight())));
		scroll = new ScrollPane(table);
		scroll.setFlingTime(1.4f);
		container.add(scroll).width(Gdx.graphics.getWidth()).height((Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/8+topImage.getHeight()+backButton.getHeight())));
		container.row();
		container.setUserObject(2);
		container.setBounds(0, Gdx.graphics.getHeight()/7, Gdx.graphics.getWidth(), (Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/8+topImage.getHeight()+backButton.getHeight())));
		container.setBackground(new TextureRegionDrawable(new TextureRegion(allAtlas.findRegion("darkpurp"))));
		for(int i = 1; i < 53; i++){
			Image image = new Image(AssetLoader.manager.get("Card/cardsheet.atlas", TextureAtlas.class).findRegion((String) ""+i));
			
			image.setUserObject(i);
		        
			table.add();
		}
		scene.add(container);
	}
	
	private void setupBottom() {
		
		style_menu_startbutton = createImageButtonStyle("Back/backbutton.atlas","backbutton","backbutton_dark");
	    //Start button
		backButton = new BackButton(style_menu_startbutton,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/7);
		backButton.setUserObject(1);
	    scene.add(backButton);
		
	}

	public void dispose() {
		style_menu_startbutton = null;
		backButton.reset();
		backButton.remove();
		backButton = null;
		selectType.remove();
		selectType = null;
		root.remove();
		root = null;
		sacral.remove();
		sacral = null;
		throat.remove();
		throat = null;
		heart.remove();
		heart = null;
		thirdEye.remove();
		thirdEye = null;
		crown.remove();
		crown = null;
		solar.remove();
		solar = null;
		whole.remove();
		whole = null;
		angel.remove();
		angel = null;
		textureRegion = null;
		textureRegionDrawable = null;
		table.reset();
		table.remove();
		table = null;
		container.reset();
		container.remove();
		container = null;
		scroll.remove();
		scroll = null;
		scene.clear();
		//scene = null;
		//spec = null;
		topImage.reset();
		topImage.remove();
		topImage = null;
	}

}