package com.sound.healing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.utils.Array;
import com.sound.healing.AssetLoader;
import com.sound.healing.ScreenManager;
import com.sound.healing.actors.CreateScene;
import com.sound.healing.actors.SceneHandler;
import com.sound.healing.custom.Spread;

public class ChooseScreen extends BaseScreen implements Screen {

	private ClickListener cardClick, back;
	private int currentCard = 1;
	private boolean isStopped = false;
	private Array<String> sounds;
	private Music cardSound;
	private int play = 0;
	private boolean block = false;
	
	public ChooseScreen(CreateScene scene) {
		super(scene);
		cardClick = new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				play = 0;
				if(!isStopped){
					stage.getActors().get((Integer)(((Actor) event.getTarget()).getUserObject())).setVisible(false);
					if(currentCard <= SceneHandler.getInstance().getSpread().getNumberOfCards()*2){
						miniCardShow();
					}
				}
			}
		};
		 back = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
					cardSound.stop();
				 	cardSound.dispose();
				 	cardSound = null;
				 	stage.getActors().get(3).setVisible(false);
					stage.getActors().get(4).setVisible(false);
					stage.getActors().get(5).setVisible(false);
					isStopped = true;
					int i = 1;
					while(i < SceneHandler.getInstance().getSpread().getNumberOfCards()*2){
						(((HorizontalGroup) stage.getActors().get(7)).getChildren()).get(i).setVisible(false);
						i+=2;
					}
					SceneHandler.getInstance().setBack(true);
					SceneHandler.getInstance().setPreviousStage(stage);
					if(SceneHandler.getInstance().getSpread().equals(Spread.SINGLE)){
						ScreenManager.getInstance().show(com.sound.healing.Screen.SPREAD_SELECT);
					}
					else{
					ScreenManager.getInstance().show(com.sound.healing.Screen.INFO);
					}
			 }
		};
	}

	protected void miniCardShow() {

		(((HorizontalGroup) stage.getActors().get(7)).getChildren()).get(currentCard).setVisible(true);
		(((HorizontalGroup) stage.getActors().get(7)).getChildren()).get(currentCard).addAction(Actions.sequence(Actions.alpha(0f),Actions.alpha(1f, 0.4f),new Action(){

			@Override
			public boolean act(float delta) {
				if(currentCard > SceneHandler.getInstance().getSpread().getNumberOfCards()*2){
					stage.getActors().get(3).setVisible(false);
					stage.getActors().get(4).setVisible(false);
					stage.getActors().get(5).setVisible(false);
					isStopped = true;
					SceneHandler.getInstance().setBack(false);
					SceneHandler.getInstance().setPreviousStage(stage);
					if(!block){
						block = true;
						cardSound.stop();
					 	cardSound.dispose();
					 	cardSound = null;
					ScreenManager.getInstance().show(com.sound.healing.Screen.REVEAL);
					}
				}
				return true;
			}
			
		}));
		currentCard+=2;
		if(currentCard <= SceneHandler.getInstance().getSpread().getNumberOfCards()*2){
			cardSound.stop();
		 	cardSound.dispose();
		 	cardSound = null;
			cardSound = Gdx.audio.newMusic(Gdx.files.internal("Sound/"+sounds.get((currentCard+1)/2-1)));
			cardSound.play();
		}
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.35f, 0, 0.7f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		transitionStage.act();
		stage.act();
		if(!isStopped){
			update();
			if(!cardSound.isPlaying() && play == 1){
				cardSound.stop();
			 	cardSound.dispose();
			 	cardSound = null;
				cardSound = Gdx.audio.newMusic(Gdx.files.internal("Sound/"+sounds.get(currentCard-1)));
				cardSound.play();
				play = 0;
			}
		}
			stage.draw();
			transitionStage.draw();
    	
	}

	private void update() {
		stage.getActors().get(3).setX(stage.getActors().get(3).getX()-Gdx.graphics.getDeltaTime()*500);
		stage.getActors().get(4).setX(stage.getActors().get(4).getX()-Gdx.graphics.getDeltaTime()*500);
		stage.getActors().get(5).setX(stage.getActors().get(5).getX()-Gdx.graphics.getDeltaTime()*500);
		if(stage.getActors().get(3).getX() < -stage.getActors().get(3).getWidth()){
			stage.getActors().get(3).setX(Gdx.graphics.getWidth()+stage.getActors().get(3).getWidth()/2);
			stage.getActors().get(3).setVisible(true);
		}
		if(stage.getActors().get(4).getX() < -stage.getActors().get(4).getWidth()){
			stage.getActors().get(4).setX(Gdx.graphics.getWidth()+stage.getActors().get(4).getWidth()/2);
			stage.getActors().get(4).setVisible(true);
		}
		if(stage.getActors().get(5).getX() < -stage.getActors().get(5).getWidth()){
			stage.getActors().get(5).setX(Gdx.graphics.getWidth()+stage.getActors().get(5).getWidth()/2);
			stage.getActors().get(5).setVisible(true);
		}
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		super.show();
		block = false;
		isStopped = false;
		currentCard = 1;
		stage.getActors().get(3).setVisible(true);
		stage.getActors().get(4).setVisible(true);
		stage.getActors().get(5).setVisible(true);
		int i = 1;
		while(i < SceneHandler.getInstance().getSpread().getNumberOfCards()*2){
			(((HorizontalGroup) stage.getActors().get(7)).getChildren()).get(i).setVisible(false);
			i+=2;
		}
		
		stage.getActors().get(1).addListener(back);
		stage.getActors().get(3).addListener(cardClick);
		stage.getActors().get(4).addListener(cardClick);
		stage.getActors().get(5).addListener(cardClick);
		sounds = null;
		sounds = SceneHandler.getInstance().getSpread().getCardsSound();
		if(SceneHandler.getInstance().getSpread().equals(Spread.ANGELS_OF_SOUND)){
			cardSound = Gdx.audio.newMusic(Gdx.files.internal("Sound/042.mp3"));
			cardSound.play();
			play = 1;
		}
		else{
			cardSound = Gdx.audio.newMusic(Gdx.files.internal("Sound/"+sounds.get(currentCard-1)));
			cardSound.play();
		}
	}


}
