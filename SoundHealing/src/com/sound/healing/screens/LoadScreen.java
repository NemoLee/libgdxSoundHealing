package com.sound.healing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.sound.healing.Scene;
import com.sound.healing.SceneManager;
import com.sound.healing.ScreenManager;
import com.sound.healing.actors.SceneHandler;
import com.sound.healing.cards.AllCards;
import com.sound.healing.custom.MenuButton;

public class LoadScreen extends BaseScreen implements Screen {
	
	private ClickListener back, click;
	private Table t;
	
	
	public LoadScreen(ScreenSpec screenSpec) {
		super(screenSpec);
		back = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 
				 			transitionStage = SceneHandler.getInstance().getCreateMainMenu().getSpec().createStage();
				 			transitionStage.addAction(Actions.sequence(Actions.moveTo(-transitionStage.getWidth(), 0), Actions.moveTo(0, 0, 0.4f)));
					 		stage.addAction(Actions.sequence(Actions.delay(0.0f),Actions.moveTo(stage.getWidth(), 0, 0.4f),Actions.delay(0.4f),Actions.run(new Runnable(){

								@Override
								public void run() {
									//mainMenu
									SceneManager.getInstance().getGame().setScreen(SceneManager.getInstance().createSpreadSelect());	
									
								}
					 			
					 		})));
					 		
	         }
		};
		click = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 			
				 			AllCards.getInstance().setupLoadedCards(((MenuButton)event.getTarget().getParent()).getSpreadIDS());
				 			SceneHandler.getInstance().setSpread(((MenuButton) event.getTarget().getParent()).getSpread());
				 			transitionStage = SceneHandler.getInstance().getCreateLoadReveal().getSpec().createStage();
				 			transitionStage.addAction(Actions.sequence(Actions.moveTo(transitionStage.getWidth(), 0), Actions.moveTo(0, 0, 0.4f)));
					 		stage.addAction(Actions.sequence(Actions.delay(0.0f),Actions.moveTo(-stage.getWidth(), 0, 0.4f),Actions.delay(0.4f),Actions.run(new Runnable(){

								@Override
								public void run() {
									SceneManager.getInstance().getGame().setScreen(SceneManager.getInstance().createLoadReveal());	 
									
								}
					 			
					 		})));
					 		
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
		stage.clear();
		transitionStage.clear();
		stage = screenSpec.createStage();
		Gdx.input.setInputProcessor(stage);
		stage.getActors().get(1).addListener(back);
		t = (Table) stage.getActors().get(3);
		for(int i = 0; i<t.getChildren().size; i++){
			t.getChildren().get(i).addListener(click);
		}
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Scene getSceneType() {
		return Scene.LOAD;
	}

}
