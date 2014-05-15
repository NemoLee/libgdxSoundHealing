package com.sound.healing.screens;

import java.util.StringTokenizer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.sound.healing.ScreenManager;
import com.sound.healing.actors.CreateScene;
import com.sound.healing.actors.SceneHandler;
import com.sound.healing.cards.AllCards;
import com.sound.healing.custom.MenuButton;

public class LoadScreen extends BaseScreen implements Screen {
	
	private ClickListener back, click, delete,yes, no;
	private Table t;
	private Preferences prefs;
	private String loadData;
	private boolean isDeleting = false;
	private int deleter = 0;
	
	
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
		
		no = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				stage.getActors().get(4).setVisible(false);
				
	         }
		};
		yes = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {

		 			System.out.println(deleter);
		 			prefs = Gdx.app.getPreferences("spread");
		 			loadData = prefs.getString("spread", "");
		 			StringTokenizer loads = new StringTokenizer(loadData, "^");
		 			String redo = "";
		 			int max = loads.countTokens();
		 			for(int i = 0; i <max; i++ ){
		 				if(i == deleter){
		 					loads.nextToken();
		 				}
		 				else{
		 					redo += loads.nextToken()+"^";
		 				}
		 			}
		 			isDeleting = true;
		 			prefs.putString("spread",redo);
		 			prefs.flush();
		 			SceneHandler.getInstance().setPreviousStage(stage);
		 			ScreenManager.getInstance().show(com.sound.healing.Screen.LOAD);
					 		
	         }
		};
		
		delete = new ClickListener(){
			 @Override
	         public void clicked(InputEvent event, float x, float y) {
				 deleter = (Integer) event.getTarget().getUserObject()-5004;
				 stage.getActors().get(4).setVisible(true);
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
		if(isDeleting){
			isDeleting = false;
			stage.clear();
			transitionStage.clear();
			transitionStage = SceneHandler.getInstance().getPreviousStage();
			scene.reset();
			stage = scene.getSpec().createStage();
			Gdx.input.setInputProcessor(stage);
		}
		else{
		super.show();
		}
		stage.getActors().get(1).addListener(back);
		//t = (Table) stage.getActors().get(3);
		t = ((Table) ((ScrollPane) ((Table) stage.getActors().get(3)).getChildren().get(0)).getWidget());
		for(int i = 0; i<t.getChildren().size-1; i++){
			t.getChildren().get(i).addListener(click);
			t.getChildren().get(i+1).addListener(delete);
			i++;
		}
		stage.getActors().get(4).setVisible(false);
		((Group) stage.getActors().get(4)).getChildren().get(2).addListener(yes);
		((Group) stage.getActors().get(4)).getChildren().get(3).addListener(no);
		
	}

}
