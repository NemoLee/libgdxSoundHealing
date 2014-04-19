package com.sound.healing.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.sound.healing.AssetLoader;
import com.sound.healing.screens.ScreenSpec;

public class CreateSplash extends CreateScene{
	
	private Image background, rotate;
	
	public CreateSplash() {
		setupBackground();
		setupForground();
		spec = new ScreenSpec(scene);
	}

	private void setupBackground() {
		background = new Image(AssetLoader.manager.get("Splash/splash.png", Texture.class));
		background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		background.setPosition(0, 0);
		background.setUserObject(0);
		scene.put((Integer) background.getUserObject(), background);
	}
	
	private void setupForground() {
		rotate = new Image(AssetLoader.manager.get("Splash/loading.png", Texture.class));
		rotate.setSize(Gdx.graphics.getWidth()/10, Gdx.graphics.getWidth()/10);
		rotate.setPosition(Gdx.graphics.getWidth()/2-rotate.getWidth()/2, Gdx.graphics.getHeight()/5);
		rotate.setUserObject(1);
		rotate.setOrigin(rotate.getWidth()/2, rotate.getHeight()/2);
		scene.put((Integer) rotate.getUserObject(), rotate);
		
	}
	

}
