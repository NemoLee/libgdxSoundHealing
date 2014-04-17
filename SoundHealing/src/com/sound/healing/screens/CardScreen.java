package com.sound.healing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.sound.healing.ScreenManager;
import com.sound.healing.actors.CreateScene;
import com.sound.healing.actors.SceneHandler;

public class CardScreen extends BaseScreen implements Screen {

	private ClickListener back, bigFlip;
	private boolean isFlipped = false;
	
	public CardScreen(CreateScene scene) {
		super(scene);
		back = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 			
				 	
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

	}

}
