package com.sound.healing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.sound.healing.ScreenManager;
import com.sound.healing.actors.CreateScene;
import com.sound.healing.actors.SceneHandler;
import com.sound.healing.cards.AllCards;
import com.sound.healing.cards.CardEnum;

public class IndividualScreen extends BaseScreen {

	private ClickListener cardClick, back;
	private Music cardSound;

	public IndividualScreen(CreateScene scene) {
		super(scene);
		cardClick = new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
					AllCards.getInstance().setIndividual((Integer) event.getTarget().getUserObject()-2);
					System.out.println("\n\n\n"+event.getTarget().getUserObject()+"\n\n");
					stage.getActors().get((Integer)(((Actor) event.getTarget()).getUserObject())).setVisible(false);
					((Image) (((HorizontalGroup) stage.getActors().get(11)).getChildren()).get(1)).setDrawable(((Image) event.getTarget()).getDrawable());
					(((HorizontalGroup) stage.getActors().get(11)).getChildren()).get(1).setVisible(true);
					(((HorizontalGroup) stage.getActors().get(11)).getChildren()).get(1).addAction(Actions.sequence(Actions.alpha(0f),Actions.alpha(1f, 0.4f),Actions.run(new Runnable(){

						@Override
						public void run() {

								//stage.getActors().get(3).setVisible(false);
								//stage.getActors().get(4).setVisible(false);
								//stage.getActors().get(5).setVisible(false);
						 		cardSound.stop();
						 		cardSound.dispose();
						 		cardSound = null;
								SceneHandler.getInstance().setBack(false);
								SceneHandler.getInstance().setPreviousStage(stage);
								ScreenManager.getInstance().show(com.sound.healing.Screen.REVEALINDI);
							}
						
						
					})));

			}
		};
		back = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 	cardSound.stop();
				 	cardSound.dispose();
				 	cardSound = null;
		 			SceneHandler.getInstance().setBack(true);
		 			SceneHandler.getInstance().setPreviousStage(stage);
		 			ScreenManager.getInstance().show(com.sound.healing.Screen.SPREAD_SELECT);
					 		
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
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		super.show();
		
		
		stage.getActors().get(2).setVisible(true);
		stage.getActors().get(3).setVisible(true);
		stage.getActors().get(4).setVisible(true);
		stage.getActors().get(5).setVisible(true);
		stage.getActors().get(6).setVisible(true);
		stage.getActors().get(7).setVisible(true);
		stage.getActors().get(8).setVisible(true);
		stage.getActors().get(9).setVisible(true);
		(((HorizontalGroup) stage.getActors().get(11)).getChildren()).get(1).setVisible(false);
		stage.getActors().get(2).addListener(cardClick);
		stage.getActors().get(3).addListener(cardClick);
		stage.getActors().get(4).addListener(cardClick);
		stage.getActors().get(5).addListener(cardClick);
		stage.getActors().get(6).addListener(cardClick);
		stage.getActors().get(7).addListener(cardClick);
		stage.getActors().get(8).addListener(cardClick);
		stage.getActors().get(9).addListener(cardClick);
		stage.getActors().get(13).addListener(back);
		cardSound = Gdx.audio.newMusic(Gdx.files.internal("Sound/049.mp3"));
		cardSound.play();

	}		



}
