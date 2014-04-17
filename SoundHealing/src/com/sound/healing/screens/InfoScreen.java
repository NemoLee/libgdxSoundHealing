package com.sound.healing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.sound.healing.AssetLoader;
import com.sound.healing.ScreenManager;
import com.sound.healing.actors.CreateScene;
import com.sound.healing.actors.SceneHandler;
import com.sound.healing.custom.Spread;

public class InfoScreen extends BaseScreen implements com.badlogic.gdx.Screen {

	private ClickListener back, click;
	
	public InfoScreen(CreateScene scene) {
		super(scene);
		back = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 
		 			SceneHandler.getInstance().setBack(true);
		 			SceneHandler.getInstance().setPreviousStage(stage);
		 			ScreenManager.getInstance().show(com.sound.healing.Screen.SPREAD_SELECT);
					 		
	         }
		};
		click = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 			
				 			SceneHandler.getInstance().setBack(false);
				 			SceneHandler.getInstance().setPreviousStage(stage);
				 			if(SceneHandler.getInstance().getSpread().equals(Spread.INDIVIDUAL)){
				 				ScreenManager.getInstance().show(com.sound.healing.Screen.INDIVIDUAL);
				 			}
				 			else{
				 				ScreenManager.getInstance().show(com.sound.healing.Screen.CHOOSE);
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
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		super.show();
		stage.getActors().get(4).addListener(back);
		stage.getActors().get(5).addListener(click);

	}

}
