package com.sound.healing.actors;

import com.sound.healing.custom.Spread;
import com.sound.healing.screens.ScreenSpec;

public class CreateInfo extends CreateScene{
	
	
	
	public CreateInfo() {
		setupTop(SceneHandler.getInstance().getSpread().toString());
		
		spec = new ScreenSpec(scene);
	}
	

}
