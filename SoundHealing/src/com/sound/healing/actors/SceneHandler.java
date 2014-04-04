package com.sound.healing.actors;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.sound.healing.AssetLoader;
import com.sound.healing.custom.Spread;

public class SceneHandler {
	
	private CreateMainMenu createMainMenu;
	private CreateSpreadSelect createSpreadSelect;
	private CreateInfo createInfo;
	private CreateChoose createChoose;
	private CreateReveal createReveal;
	private CreateCard createCard;
	private Spread spread;
	private Stage currentSpreadStage;
	
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
		else{
			createInfo.reset();
		}
		return createInfo;
	}
	
	public CreateScene getCreateChoose() {
		if(createChoose == null){
			createChoose = new CreateChoose();
		}
		else{
			createChoose.reset();
		}
		return createChoose;
	}
	
	public CreateScene getCreateReveal() {
		if(createReveal == null){
			createReveal = new CreateReveal();
		}
		else{
			createReveal.reset();
		}
		return createReveal;
	}


	public CreateScene getCreateCard() {
		if(createCard == null){
			createCard = new CreateCard();
		}
		else{
			createCard.reset();
		}
		return createCard;
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




	
	

}
