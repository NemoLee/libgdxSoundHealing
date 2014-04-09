package com.sound.healing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.sound.healing.ScreenManager;
import com.sound.healing.actors.CreateScene;
import com.sound.healing.actors.SceneHandler;
import com.sound.healing.cards.AllCards;
import com.sound.healing.custom.MenuButton;

public class LoadScreen extends BaseScreen implements Screen {
	
	private ClickListener back, click;
	private Table t;
	
	
	public LoadScreen(CreateScene scene) {
		super(scene);
		back = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 
				 SceneHandler.getInstance().setBack(true);
					SceneHandler.getInstance().setPreviousStage(stage);
					ScreenManager.getInstance().show(com.sound.healing.Screen.MAIN_MENU);
					 		
	         }	
		};
		click = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 			
				 			AllCards.getInstance().setupLoadedCards(((MenuButton)event.getTarget().getParent()).getSpreadIDS());
				 			SceneHandler.getInstance().setSpread(((MenuButton) event.getTarget().getParent()).getSpread());
				 			SceneHandler.getInstance().setBack(true);
							SceneHandler.getInstance().setPreviousStage(stage);
							ScreenManager.getInstance().show(com.sound.healing.Screen.LOAD_REVEAL);
					 		
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
		t = (Table) stage.getActors().get(3);
		for(int i = 0; i<t.getChildren().size; i++){
			t.getChildren().get(i).addListener(click);
		}
		
	}

}
