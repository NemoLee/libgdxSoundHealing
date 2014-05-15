package com.sound.healing.screens;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.sound.healing.MainScene;
import com.sound.healing.actors.SceneHandler;

public class ScreenSpec {
	
	private Stage stage;
	LinkedList<Actor> actors;
	
	public ScreenSpec(LinkedList<Actor> scene) {
		this.actors = scene;
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}
	
	public Actor getActor(Integer actorName){
		return actors.get(actorName);
	}
	
	public LinkedList<Actor> getActors(){
		return actors;
	}
	
	public Stage createStage(){
		if(stage.getActors().size == 0){
		stage  = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), false , SceneHandler.getInstance().getBatch());
			for(int i = 0; i < actors.size(); i++){
				
			
					stage.addActor(actors.get(i));
				
			}
		}
		return stage;
	}
	
	
}
