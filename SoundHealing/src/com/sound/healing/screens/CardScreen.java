package com.sound.healing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.sound.healing.ScreenManager;
import com.sound.healing.actors.CreateScene;
import com.sound.healing.actors.SceneHandler;
import com.sound.healing.cards.AllCards;
import com.sound.healing.cards.CardEnum;
import com.sound.healing.cards.CardType;

public class CardScreen extends BaseScreen implements Screen {

	private ClickListener back, bigFlip, playAll, playLast;
	private boolean isFlipped = false;
	private Music cardSound;
	private int play = 1;
	
	public CardScreen(CreateScene scene) {
		super(scene);
		playAll = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 cardSound.stop();
				 	play = 3;
				 
			 }
		};
		playLast = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 cardSound.stop();
				 	play = 1;
				 
			 }
		};
		back = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 			
					cardSound.stop();
				 	cardSound.dispose();
				 	cardSound = null;
									stage.getActors().get(3).addAction(Actions.sequence(Actions.fadeOut(0.3f), Actions.visible(false)));
									stage.getActors().get(0).addAction(Actions.parallel(Actions.visible(true),Actions.fadeIn(0.3f)));
									isFlipped = false;
									if(SceneHandler.getInstance().getLoad() == 0){
										SceneHandler.getInstance().setBack(true);
										SceneHandler.getInstance().setPreviousStage(stage);
										ScreenManager.getInstance().show(com.sound.healing.Screen.LOAD_REVEAL);
									}
									else if(SceneHandler.getInstance().getLoad() == 1){
										SceneHandler.getInstance().setBack(true);
										SceneHandler.getInstance().setPreviousStage(stage);
										ScreenManager.getInstance().show(com.sound.healing.Screen.REVEAL);
									}
									else if(SceneHandler.getInstance().getLoad() == 2){
										SceneHandler.getInstance().setBack(true);
										SceneHandler.getInstance().setPreviousStage(stage);
										ScreenManager.getInstance().show(com.sound.healing.Screen.BROWSE);
									}
									else if(SceneHandler.getInstance().getLoad() == 3){
										SceneHandler.getInstance().setBack(true);
										SceneHandler.getInstance().setPreviousStage(stage);
										ScreenManager.getInstance().show(com.sound.healing.Screen.REVEALINDI);
									}
					 		
	         }
		};
		bigFlip = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 
				 if(!isFlipped){
					 stage.getActors().get(0).addAction(Actions.sequence(Actions.fadeOut(0.3f), Actions.visible(false)));
					 stage.getActors().get(3).addAction(Actions.parallel(Actions.visible(true),Actions.fadeIn(0.3f)));
					 isFlipped = true;
				 }
				 else{
					 stage.getActors().get(3).addAction(Actions.sequence(Actions.fadeOut(0.3f), Actions.visible(false)));
					 stage.getActors().get(0).addAction(Actions.parallel(Actions.visible(true),Actions.fadeIn(0.3f)));
					 isFlipped = false;
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
		if(!cardSound.isPlaying()&&play == 3){
			cardSound.stop();
		 	cardSound.dispose();
		 	cardSound = null;
			cardSound = Gdx.audio.newMusic(Gdx.files.internal("Sound/"+AllCards.getInstance().getCurrentCard().getCardSpec().getCardProperty(CardEnum.SOUND1.getEnumID())));
			cardSound.play();
			play = 2;
		}
		else if(!cardSound.isPlaying()&&play == 2){
			cardSound.stop();
		 	cardSound.dispose();
		 	cardSound = null;
			cardSound = Gdx.audio.newMusic(Gdx.files.internal("Sound/"+AllCards.getInstance().getCurrentCard().getCardSpec().getCardProperty(CardEnum.SOUND2.getEnumID())));
			cardSound.play();
			play = 1;
		}
		else if(!cardSound.isPlaying()&&play == 1){
			cardSound.stop();
		 	cardSound.dispose();
		 	cardSound = null;
		 	if(AllCards.getInstance().getCurrentCard().equals(AllCards.getInstance().getCard(48))){
		 		cardSound = Gdx.audio.newMusic(Gdx.files.internal("Sound/177.mp3"));
		 	}
		 	else if(AllCards.getInstance().getCurrentCard().equals(AllCards.getInstance().getCard(49))){
		 		cardSound = Gdx.audio.newMusic(Gdx.files.internal("Sound/180.mp3"));
		 	}
		 	else if(AllCards.getInstance().getCurrentCard().equals(AllCards.getInstance().getCard(50))){
		 		cardSound = Gdx.audio.newMusic(Gdx.files.internal("Sound/183.mp3"));
		 	}
		 	else if(AllCards.getInstance().getCurrentCard().equals(AllCards.getInstance().getCard(51))){
		 		cardSound = Gdx.audio.newMusic(Gdx.files.internal("Sound/186.mp3"));
		 	}
		 	else{
		 		cardSound = Gdx.audio.newMusic(Gdx.files.internal("Sound/"+(((CardType) AllCards.getInstance().getCurrentCard().getCardSpec().getCardProperty(CardEnum.TYPE.getEnumID())).getBreatheSound())));
		 	}
			cardSound.play();
			play = 0;
		}
	    batch.begin();
			stage.draw();
			transitionStage.draw();
    	batch.end();

	}

	@Override
	public void show() {
		super.show();
		stage.getActors().get(3).addAction(Actions.sequence(Actions.fadeOut(0.3f), Actions.visible(false)));
		stage.getActors().get(0).addAction(Actions.parallel(Actions.visible(true),Actions.fadeIn(0.3f)));
		isFlipped = false;
		stage.getActors().get(1).addListener(back);
		stage.getActors().get(2).addListener(bigFlip);
		((HorizontalGroup) ((Table) ((ScrollPane) ((Table) stage.getActors().get(3)).getChildren().get(0)).getWidget()).getChildren().get(1)).getChildren().get(0).addListener(playAll);
		((HorizontalGroup) ((Table) ((ScrollPane) ((Table) stage.getActors().get(3)).getChildren().get(0)).getWidget()).getChildren().get(1)).getChildren().get(1).addListener(playLast);
		//((HorizontalGroup) ((Table) stage.getActors().get(3)).getChildren().get(0)).getChildren().get(0).addListener(playAll);
		//((HorizontalGroup) ((Table) stage.getActors().get(3)).getChildren().get(0)).getChildren().get(1).addListener(playLast);
		cardSound = Gdx.audio.newMusic(Gdx.files.internal("Sound/"+AllCards.getInstance().getCurrentCard().getCardSpec().getCardProperty(CardEnum.SOUND1.getEnumID())));
		cardSound.play();
		play = 2;
	}

}
