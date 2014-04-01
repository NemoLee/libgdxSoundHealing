package com.sound.healing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.sound.healing.AssetLoader;
import com.sound.healing.ScreenManager;
import com.sound.healing.actors.SceneHandler;

public class ChooseScreen extends BaseScreen implements Screen {

	private ClickListener cardClick, back;
	private int currentCard = 1;
	private boolean isStopped = false;
	
	public ChooseScreen(ScreenSpec screenSpec) {
		super(screenSpec);
		cardClick = new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if(!isStopped){
					stage.getActors().get((Integer)(((Actor) event.getTarget()).getUserObject())).setVisible(false);
					miniCardShow();
				}
			}
		};
		 back = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 
				 	stage.getActors().get(3).setVisible(false);
					stage.getActors().get(4).setVisible(false);
					stage.getActors().get(5).setVisible(false);
					isStopped = true;
					int i = 1;
					while(i < SceneHandler.getInstance().getSpread().getNumberOfCards()*2){
						(((HorizontalGroup) stage.getActors().get(7)).getChildren()).get(i).setVisible(false);
						i+=2;
					}
					transitionStage = SceneHandler.getInstance().getCreateInfo().getSpec().createStage();
		 			transitionStage.addAction(Actions.sequence(Actions.moveTo(-transitionStage.getWidth(), 0), Actions.moveTo(0, 0, 0.4f)));
			 		stage.addAction(Actions.sequence(Actions.delay(0.0f),Actions.moveTo(stage.getWidth(), 0, 0.4f),Actions.delay(0.4f),Actions.run(new Runnable(){

						@Override
						public void run() {
							ScreenManager.getInstance().show(com.sound.healing.Screen.INFO); 
						}
			 			
			 		})));
	         }
		};
	}

	protected void miniCardShow() {
		(((HorizontalGroup) stage.getActors().get(7)).getChildren()).get(currentCard).setVisible(true);
		(((HorizontalGroup) stage.getActors().get(7)).getChildren()).get(currentCard).addAction(Actions.sequence(Actions.alpha(0f),Actions.alpha(1f, 0.4f),Actions.run(new Runnable(){

			@Override
			public void run() {
				if(currentCard > SceneHandler.getInstance().getSpread().getNumberOfCards()*2){
					stage.getActors().get(3).setVisible(false);
					stage.getActors().get(4).setVisible(false);
					stage.getActors().get(5).setVisible(false);
					isStopped = true;
		 			transitionStage = SceneHandler.getInstance().getCreateReveal().getSpec().createStage();
		 			transitionStage.addAction(Actions.sequence(Actions.moveTo(transitionStage.getWidth(), 0), Actions.moveTo(0, 0, 0.4f)));
			 		stage.addAction(Actions.sequence(Actions.delay(0.0f),Actions.moveTo(-stage.getWidth(), 0, 0.4f),Actions.delay(0.4f),Actions.run(new Runnable(){

						@Override
						public void run() {
							ScreenManager.getInstance().show(com.sound.healing.Screen.REVEAL); 
						}
			 			
			 		})));
				}
			}
			
		})));
		currentCard+=2;
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.35f, 0, 0.7f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		transitionStage.act();
		stage.act();
		if(!isStopped){
			update();
		}
		batch.setProjectionMatrix(camera.combined);
		
	    batch.begin();
			stage.draw();
			transitionStage.draw();
    	batch.end();
    	
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
		AssetLoader.getInstance().loadReveal();
		stage.clear();
		transitionStage.clear();
		stage = screenSpec.createStage();
		Gdx.input.setInputProcessor(stage);
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

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		
	}

}
