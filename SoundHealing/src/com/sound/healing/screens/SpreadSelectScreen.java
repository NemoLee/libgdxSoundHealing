package com.sound.healing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.sound.healing.Screen;
import com.sound.healing.ScreenManager;
import com.sound.healing.actors.CreateMainMenu;
import com.sound.healing.actors.SceneHandler;
import com.sound.healing.custom.Spread;

public class SpreadSelectScreen extends BaseScreen implements com.badlogic.gdx.Screen {

	public SpreadSelectScreen(ScreenSpec screenSpec) {
		super(screenSpec);
		// TODO Auto-generated constructor stub
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
		stage.clear();
		transitionStage.clear();
		stage = screenSpec.createStage();
		Gdx.input.setInputProcessor(stage);

		ClickListener back = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 
				 			transitionStage = SceneHandler.getInstance().getCreateMainMenu().getSpec().createStage();
				 			transitionStage.addAction(Actions.sequence(Actions.moveTo(-transitionStage.getWidth(), 0), Actions.moveTo(0, 0, 0.4f)));
					 		stage.addAction(Actions.sequence(Actions.delay(0.0f),Actions.moveTo(stage.getWidth(), 0, 0.4f),Actions.delay(0.4f),Actions.run(new Runnable(){

								@Override
								public void run() {
									ScreenManager.getInstance().show(Screen.MAIN_MENU); 
									
								}
					 			
					 		})));
					 		
											 	
				
	         }
		};
		
		ClickListener Info = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 		//check to see if switch if null to handle android vs desktop and make sure to check ios
							switch((Integer)(event.getTarget().getParent().getUserObject())){
							case 2:
								SceneHandler.getInstance().setSpread(Spread.SOUND_ADVICE);
								break;
							case 3:
								SceneHandler.getInstance().setSpread(Spread.SYMPHONY_OF_LIFE);							
								break;
							case 4:
								SceneHandler.getInstance().setSpread(Spread.DUET);
								break;
							case 5:
								SceneHandler.getInstance().setSpread(Spread.HEARTSONG);
								break;
							case 6:
								SceneHandler.getInstance().setSpread(Spread.RETUNING);
								break;
							case 7:
								SceneHandler.getInstance().setSpread(Spread.SINGING_EARTH);
								break;
							case 8:
								SceneHandler.getInstance().setSpread(Spread.ANGELS_OF_SOUND);
								break;
							case 9:
								SceneHandler.getInstance().setSpread(Spread.INDIVIDUAL);
								break;
							case 10:
								SceneHandler.getInstance().setSpread(Spread.MULTI);
								break;
							}
				 			transitionStage = SceneHandler.getInstance().getCreateInfo().getSpec().createStage();
				 			transitionStage.addAction(Actions.sequence(Actions.moveTo(transitionStage.getWidth(), 0), Actions.moveTo(0, 0, 0.4f)));
					 		stage.addAction(Actions.sequence(Actions.delay(0.0f),Actions.moveTo(-stage.getWidth(), 0, 0.4f),Actions.delay(0.4f),Actions.run(new Runnable(){

								@Override
								public void run() {
						
									ScreenManager.getInstance().show(Screen.INFO); 
									
								}
					 			
					 		})));
					 		
											 	
				
	         }
		};
		
		stage.getActors().get(2).addListener(back);
		Table t = (Table) stage.getActors().get(1);
		for(int i = 0; i<t.getChildren().size; i++){
			t.getChildren().get(i).addListener(Info);
		}
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
		stage.dispose();
		transitionStage.dispose();
		

	}

}
