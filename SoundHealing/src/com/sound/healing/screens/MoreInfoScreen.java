package com.sound.healing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.sound.healing.ScreenManager;
import com.sound.healing.actors.CreateScene;
import com.sound.healing.actors.SceneHandler;
import com.sound.healing.custom.MoreInfo;
import com.sound.healing.custom.Spread;

public class MoreInfoScreen extends BaseScreen {

	private ClickListener back, info;
	
	public MoreInfoScreen(CreateScene scene) {
		super(scene);
		back = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 
				 	SceneHandler.getInstance().setBack(true);
					SceneHandler.getInstance().setPreviousStage(stage);
					ScreenManager.getInstance().show(com.sound.healing.Screen.MAIN_MENU);
					 		
	         }	
		};
		info = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 		//check to see if switch if null to handle android vs desktop and make sure to check ios
							switch((Integer)(((Actor) event.getTarget()).getUserObject())){
							case 3:
								SceneHandler.getInstance().setMoreInfo(MoreInfo.INTRO);
								break;
							case 4:
								SceneHandler.getInstance().setMoreInfo(MoreInfo.SOUNDS);						
								break;
							case 5:
								SceneHandler.getInstance().setMoreInfo(MoreInfo.MEANINGS);
								break;
							case 6:
								SceneHandler.getInstance().setMoreInfo(MoreInfo.SUITS);
								break;
							case 7:
								SceneHandler.getInstance().setMoreInfo(MoreInfo.USING);
								break;
							}
							SceneHandler.getInstance().setBack(false);
							SceneHandler.getInstance().setPreviousStage(stage);
							ScreenManager.getInstance().show(com.sound.healing.Screen.MORE_INFO_SUB);		
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
		Table t = (Table) stage.getActors().get(1);
		for(int i = 0; i<t.getChildren().size; i++){
			t.getChildren().get(i).addListener(info);
		}

	}


}
