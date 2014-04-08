package com.sound.healing.screens;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class ScreenSpec {
	
	private Stage stage;
	HashMap<Integer, Actor> actors;
	
	public ScreenSpec(HashMap<Integer, Actor> actors) {
		this.actors = actors;
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}
	
	public Actor getActor(Integer actorName){
		return actors.get(actorName);
	}
	
	public HashMap<Integer, Actor> getActors(){
		return actors;
	}
	
	public Stage createStage(){
		if(stage.getActors().size == 0){
		stage  = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			for(int i = 0; i < actors.size(); i++){
				stage.addActor(actors.get(i));
			}
		}
		return stage;
	}
	
	
}
