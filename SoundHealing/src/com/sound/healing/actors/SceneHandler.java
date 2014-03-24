package com.sound.healing.actors;

import com.sound.healing.AssetLoader;
import com.sound.healing.custom.Spread;

public class SceneHandler {
	
	private CreateMainMenu createMainMenu;
	private CreateSpreadSelect createSpreadSelect;
	private CreateInfo createInfo;
	private Spread spread;
	
	private static final SceneHandler INSTANCE = new SceneHandler();


	public static SceneHandler getInstance() {
		
		return INSTANCE;
	}


	public CreateScene getCreateMainMenu() {
		if(createMainMenu == null){
			createMainMenu = new CreateMainMenu();
		}
		return createMainMenu;
	}
	
	public CreateScene getCreateSpreadSelect() {
		if(createSpreadSelect == null){
			createSpreadSelect = new CreateSpreadSelect();
		}
		return createSpreadSelect;
	}
	
	public void setSpread(Spread spread) {
		this.spread = spread;
	}
	
	public Spread getSpread() {
		return spread;
	}


	public CreateScene getCreateInfo() {
		if(createInfo == null){
			createInfo = new CreateInfo();
		}
		return createInfo;
	}
	
	

}
