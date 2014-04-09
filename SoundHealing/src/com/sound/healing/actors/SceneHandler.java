package com.sound.healing.actors;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.sound.healing.AssetLoader;
import com.sound.healing.Screen;
import com.sound.healing.custom.Spread;

public class SceneHandler {
	
	private CreateMainMenu createMainMenu;
	private CreateSpreadSelect createSpreadSelect;
	private CreateInfo createInfo;
	private CreateChoose createChoose;
	private CreateReveal createReveal;
	private CreateCard createCard;
	private CreateCardBack createCardBack;
	private Spread spread;
	private Stage currentSpreadStage;
	private CreateLoad createLoad;
	private CreateLoadReveal createLoadReveal;
	private boolean isLoad = false;
	private boolean isBack = false;
	private Stage previousStage;
	
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
	
	public CreateScene getCreateInfo() {
		if(createInfo == null){
			createInfo = new CreateInfo();
		}
		return createInfo;
	}
	
	public CreateScene getCreateChoose() {
		if(createChoose == null){
			createChoose = new CreateChoose();
		}
		return createChoose;
	}
	
	public CreateScene getCreateReveal() {
		if(createReveal == null){
			createReveal = new CreateReveal();
		}
		return createReveal;
	}


	public CreateScene getCreateCard() {
		if(createCard == null){
			createCard = new CreateCard();
		}
		return createCard;
	}
	
	public CreateScene getCreateCardBack() {
		if(createCardBack == null){
			createCardBack = new CreateCardBack();
		}
		return createCardBack;
	}
	
	public CreateScene getCreateLoad() {
		if(createLoad == null){
			createLoad = new CreateLoad();
		}
		return createLoad;
	}	
	
	public CreateScene getCreateLoadReveal() {
		if(createLoadReveal == null){
			createLoadReveal = new CreateLoadReveal();
		}
		return createLoadReveal;
	}
	
	public void setSpread(Spread spread) {
		this.spread = spread;
	}
	
	public Spread getSpread() {
		return spread;
	}
	
	public Stage getCurrentSpreadStage() {
		return currentSpreadStage;
	}
	
	public void setCurrentSpreadStage(Stage currentSpreadStage) {
		this.currentSpreadStage = currentSpreadStage;
	}
	
	public boolean isLoad() {
		return isLoad;
	}
	
	public void setLoad(boolean isLoad) {
		this.isLoad = isLoad;
	}

	public Stage getPreviousStage() {
		return previousStage;
	}
	
	public void setPreviousStage(Stage previousStage) {
		this.previousStage = previousStage;
	}

	public boolean isBack() {
		return isBack;
	}
	public void setBack(boolean isBack) {
		this.isBack = isBack;
	}

}
