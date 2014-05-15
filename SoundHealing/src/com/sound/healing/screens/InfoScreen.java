package com.sound.healing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.sound.healing.AssetLoader;
import com.sound.healing.ScreenManager;
import com.sound.healing.actors.CreateScene;
import com.sound.healing.actors.SceneHandler;
import com.sound.healing.custom.Spread;

public class InfoScreen extends BaseScreen implements com.badlogic.gdx.Screen {

	private ClickListener back, click, back2;
	private Music infoSound;
	
	public InfoScreen(CreateScene scene) {
		super(scene);
		back2 = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 	infoSound.stop();
				 	infoSound.dispose();
				 	infoSound = null;
				 	
		 			if(SceneHandler.getInstance().getSpread().equals(Spread.INDIVIDUAL)){
			 			SceneHandler.getInstance().setBack(true);
			 			SceneHandler.getInstance().setPreviousStage(stage);
		 				ScreenManager.getInstance().show(com.sound.healing.Screen.REVEALINDI);
		 			}
		 			else if(SceneHandler.getInstance().getLoad() == 0){
						SceneHandler.getInstance().setBack(true);
						SceneHandler.getInstance().setPreviousStage(stage);
						ScreenManager.getInstance().show(com.sound.healing.Screen.LOAD_REVEAL);
					}
					else if(SceneHandler.getInstance().getLoad() == 1){
						SceneHandler.getInstance().setBack(true);
						SceneHandler.getInstance().setPreviousStage(stage);
						ScreenManager.getInstance().show(com.sound.healing.Screen.REVEAL);
					}
					 		
	         }
		};
		
		back = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 	infoSound.stop();
				 	infoSound.dispose();
				 	infoSound = null;
		 			SceneHandler.getInstance().setBack(true);
		 			SceneHandler.getInstance().setPreviousStage(stage);
		 			ScreenManager.getInstance().show(com.sound.healing.Screen.SPREAD_SELECT);
					 		
	         }
		};
		click = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 			infoSound.stop();
				 			infoSound.dispose();
				 			infoSound = null;
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
		transitionStage.act();
		stage.act();
		update();
		stage.draw();
		transitionStage.draw();

	}

	private void update() {
		
		
		stage.getActors().get(5).setPosition(stage.getActors().get(5).getX(), ((1-((ScrollPane) ((Table) stage.getActors().get(6)).getChildren().get(0)).getScrollPercentY())*(Gdx.graphics.getHeight()/2-Gdx.graphics.getHeight()/16-Gdx.graphics.getHeight()/6))+Gdx.graphics.getHeight()/7+Gdx.graphics.getHeight()/45);
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		super.show();
		if(SceneHandler.getInstance().isHelp()){
			stage.getActors().get(9).setVisible(true);
			stage.getActors().get(9).addListener(back2);
		}
		else{
			stage.getActors().get(9).setVisible(false);
			stage.getActors().get(7).addListener(back);
			stage.getActors().get(8).addListener(click);
		}
		infoSound = Gdx.audio.newMusic(Gdx.files.internal("Sound/"+SceneHandler.getInstance().getSpread().getSound()));
		infoSound.play();
	}

}
