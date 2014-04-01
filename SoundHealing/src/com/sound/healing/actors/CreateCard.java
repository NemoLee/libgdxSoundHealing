package com.sound.healing.actors;

import com.sound.healing.screens.ScreenSpec;

public class CreateCard extends CreateScene{
	
	public CreateCard() {
		setupTop(SceneHandler.getInstance().getSpread().toString());
		spec = new ScreenSpec(scene);
	}
	
	

}
