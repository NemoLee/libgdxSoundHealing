package com.sound.healing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.sound.healing.ScreenManager;
import com.sound.healing.actors.CreateScene;
import com.sound.healing.actors.SceneHandler;

public class MoreInfoSubScreen extends BaseScreen {

	private ClickListener back;
	
	public MoreInfoSubScreen(CreateScene scene) {
		super(scene);
		back = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 
				 	SceneHandler.getInstance().setBack(true);
					SceneHandler.getInstance().setPreviousStage(stage);
					ScreenManager.getInstance().show(com.sound.healing.Screen.MORE_INFO);
					 		
	         }	
		};
		
		
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.35f, 0, 0.7f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		transitionStage.act();
		stage.act();
		stage.draw();
		transitionStage.draw();

	}

	@Override
	public void show() {
		super.show();
		stage.getActors().get(2).addListener(back);
	}

}
