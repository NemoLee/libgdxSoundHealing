package com.sound.healing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.sound.healing.AssetLoader;
import com.sound.healing.Screen;
import com.sound.healing.ScreenManager;
import com.sound.healing.actors.CreateMainMenu;
import com.sound.healing.actors.CreateScene;
import com.sound.healing.actors.SceneHandler;
import com.sound.healing.custom.Spread;

public class SpreadSelectScreen extends BaseScreen implements com.badlogic.gdx.Screen {

	private ClickListener back;
	private ClickListener Info;
	
	public SpreadSelectScreen(CreateScene scene) {
		super(scene);
		back = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
		 			SceneHandler.getInstance().setBack(true);
		 			SceneHandler.getInstance().setPreviousStage(stage);
		 			ScreenManager.getInstance().show(Screen.MAIN_MENU);
					 		
	         }
		};
		Info = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 		//check to see if switch if null to handle android vs desktop and make sure to check ios
							switch((Integer)(((Actor) event.getTarget()).getUserObject())){
							case 3:
								SceneHandler.getInstance().setSpread(Spread.SOUND_ADVICE);
								break;
							case 4:
								SceneHandler.getInstance().setSpread(Spread.SYMPHONY_OF_LIFE);							
								break;
							case 5:
								SceneHandler.getInstance().setSpread(Spread.DUET);
								break;
							case 6:
								SceneHandler.getInstance().setSpread(Spread.HEARTSONG);
								break;
							case 7:
								SceneHandler.getInstance().setSpread(Spread.RETUNING);
								break;
							case 8:
								SceneHandler.getInstance().setSpread(Spread.SINGING_EARTH);
								break;
							case 9:
								SceneHandler.getInstance().setSpread(Spread.ANGELS_OF_SOUND);
								break;
							case 10:
								SceneHandler.getInstance().setSpread(Spread.INDIVIDUAL);
								break;
							case 11:
								SceneHandler.getInstance().setSpread(Spread.MULTI);
								break;
							}
							SceneHandler.getInstance().setBack(false);
							SceneHandler.getInstance().setPreviousStage(stage);
							ScreenManager.getInstance().show(Screen.INFO);		
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
		
		stage.getActors().get(2).addListener(back);
		Table t = (Table) stage.getActors().get(1);
		for(int i = 0; i<t.getChildren().size; i++){
			t.getChildren().get(i).addListener(Info);
		}
	}
}
