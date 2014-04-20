package com.sound.healing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.sound.healing.AssetLoader;
import com.sound.healing.ScreenManager;
import com.sound.healing.actors.CreateScene;
import com.sound.healing.actors.SceneHandler;
import com.sound.healing.cards.AllCards;
import com.sound.healing.cards.CardEnum;

public class BrowseScreen extends BaseScreen implements com.badlogic.gdx.Screen {
	
	private ClickListener back, select, change, cards;
	private boolean isDown = false;
	private TextureRegion textureRegionUp, textureRegionDown;
	private TextureRegionDrawable textureRegionDrawableUp, textureRegionDrawableDown;
	private Table temp;
	private Image[] images;

	public BrowseScreen(CreateScene scene) {
		super(scene);
		textureRegionUp = new TextureRegion(AssetLoader.manager.get("All/all.atlas", TextureAtlas.class).findRegion("select_type_up"));
		textureRegionDrawableUp = new TextureRegionDrawable(textureRegionUp);
		textureRegionDown = new TextureRegion(AssetLoader.manager.get("All/all.atlas", TextureAtlas.class).findRegion("select_type_down"));
		textureRegionDrawableDown = new TextureRegionDrawable(textureRegionDown);
		back = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
		 			SceneHandler.getInstance().setBack(true);
		 			SceneHandler.getInstance().setPreviousStage(stage);
		 			ScreenManager.getInstance().show(com.sound.healing.Screen.MAIN_MENU);
	         }
		};
		cards = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
					AllCards.getInstance().setCurrentCard((Integer) event.getListenerActor().getUserObject()); 
					SceneHandler.getInstance().setCurrentSpreadStage(stage);
					SceneHandler.getInstance().setLoad(2);
					SceneHandler.getInstance().setBack(false);
					SceneHandler.getInstance().setPreviousStage(stage);
					ScreenManager.getInstance().show(com.sound.healing.Screen.Card);
	         }
		};
		select = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
		 			//make selection visible
				 if(isDown){
					 ((Image) stage.getActors().get(2)).setDrawable(textureRegionDrawableDown);
					 isDown = !isDown;
					 for(int i = 4; i < 13; i++){
						 stage.getActors().get(i).setVisible(false);
					 }
				 }
				 else{
					 ((Image) stage.getActors().get(2)).setDrawable(textureRegionDrawableUp);
					 isDown = !isDown;
					 for(int i = 4; i < 13; i++){
						 stage.getActors().get(i).setVisible(true);
					 }
				 }
	         }
		};
		change = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 	temp.reset();
				 	images = null;
				 	images = new Image[6];
					 ((Image) stage.getActors().get(2)).setDrawable(textureRegionDrawableDown);
					 isDown = !isDown;
					 for(int i = 4; i < 13; i++){
						 stage.getActors().get(i).setVisible(false);
					 }
				 	switch((Integer)(((Actor) event.getTarget()).getUserObject())){
				 	case 4:		 		
				 		for(int i = 0; i < 6; i++){
				 			images[i] = new Image(AssetLoader.manager.get("Card/"+(i+1)+".png", Texture.class));
				 			images[i].setUserObject(i+1);
				 			images[i].addListener(cards);
				 			temp.add(images[i]).size(Gdx.graphics.getWidth()/3, (float) (Gdx.graphics.getWidth()/3*1.4533)).padLeft(Gdx.graphics.getWidth()/15);
				 		}
				 	break;
				 	case 5:
				 		for(int i = 0; i < 6; i++){
				 			images[i] = new Image(AssetLoader.manager.get("Card/"+(i+7)+".png", Texture.class));
				 			images[i].setUserObject(i+7);
				 			images[i].addListener(cards);
				 			temp.add(images[i]).size(Gdx.graphics.getWidth()/3, (float) (Gdx.graphics.getWidth()/3*1.4533)).padLeft(Gdx.graphics.getWidth()/15);
				 		}
				 	break;
				 	case 6:
				 		for(int i = 0; i < 6; i++){
				 			images[i] = new Image(AssetLoader.manager.get("Card/"+(i+25)+".png", Texture.class));
				 			images[i].setUserObject(i+25);
				 			images[i].addListener(cards);
				 			temp.add(images[i]).size(Gdx.graphics.getWidth()/3, (float) (Gdx.graphics.getWidth()/3*1.4533)).padLeft(Gdx.graphics.getWidth()/15);
				 		}
				 	break;
				 	case 7:
				 		for(int i = 0; i < 6; i++){
				 			images[i] = new Image(AssetLoader.manager.get("Card/"+(i+19)+".png", Texture.class));
				 			images[i].setUserObject(i+19);
				 			images[i].addListener(cards);
				 			temp.add(images[i]).size(Gdx.graphics.getWidth()/3, (float) (Gdx.graphics.getWidth()/3*1.4533)).padLeft(Gdx.graphics.getWidth()/15);
				 		}
				 	break;
				 	case 8:
				 		for(int i = 0; i < 6; i++){
				 			images[i] = new Image(AssetLoader.manager.get("Card/"+(i+31)+".png", Texture.class));
				 			images[i].setUserObject(i+31);
				 			images[i].addListener(cards);
				 			temp.add(images[i]).size(Gdx.graphics.getWidth()/3, (float) (Gdx.graphics.getWidth()/3*1.4533)).padLeft(Gdx.graphics.getWidth()/15);
				 		}
				 	break;
				 	case 9:
				 		for(int i = 0; i < 6; i++){
				 			images[i] = new Image(AssetLoader.manager.get("Card/"+(i+37)+".png", Texture.class));
				 			images[i].setUserObject(i+37);
				 			images[i].addListener(cards);
				 			temp.add(images[i]).size(Gdx.graphics.getWidth()/3, (float) (Gdx.graphics.getWidth()/3*1.4533)).padLeft(Gdx.graphics.getWidth()/15);
				 		}
				 	break;
				 	case 10:
				 		for(int i = 0; i < 6; i++){
				 			images[i] = new Image(AssetLoader.manager.get("Card/"+(i+13)+".png", Texture.class));
				 			images[i].setUserObject(i+13);
				 			images[i].addListener(cards);
				 			temp.add(images[i]).size(Gdx.graphics.getWidth()/3, (float) (Gdx.graphics.getWidth()/3*1.4533)).padLeft(Gdx.graphics.getWidth()/15);
				 		}
				 	break;
				 	case 11:
				 		for(int i = 0; i < 6; i++){
				 			images[i] = new Image(AssetLoader.manager.get("Card/"+(i+43)+".png", Texture.class));
				 			images[i].setUserObject(i+43);
				 			images[i].addListener(cards);
				 			temp.add(images[i]).size(Gdx.graphics.getWidth()/3, (float) (Gdx.graphics.getWidth()/3*1.4533)).padLeft(Gdx.graphics.getWidth()/15);
				 		}
				 	break;
				 	case 12:
				 		for(int i = 0; i < 4; i++){
				 			images[i] = new Image(AssetLoader.manager.get("Card/"+(i+49)+".png", Texture.class));
				 			images[i].setUserObject(i+49);
				 			images[i].addListener(cards);
				 			temp.add(images[i]).size(Gdx.graphics.getWidth()/3, (float) (Gdx.graphics.getWidth()/3*1.4533)).padLeft(Gdx.graphics.getWidth()/15);
				 		}
				 	break;
		 			
		 			}
				 
	         }
		};
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.35f, 0, 0.7f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		transitionStage.act();
		stage.act();
		batch.setProjectionMatrix(camera.combined);
		
	    batch.begin();
			stage.draw();
			transitionStage.draw();
    	batch.end();
	}

	@Override
	public void show() {
		super.show();
		stage.getActors().get(1).addListener(back);
		stage.getActors().get(2).addListener(select);
		 for(int i = 4; i < 13; i++){
			 stage.getActors().get(i).addListener(change);
		 }
		 temp = (Table) ((ScrollPane) ((Table) stage.getActors().get(3)).getChildren().get(0)).getWidget();
		 if(temp.getChildren().size > 6){
			 for(int i = 0; i < 52; i++){
				 temp.getChildren().get(i).addListener(cards);
			 }
		 }
	}
	
}
