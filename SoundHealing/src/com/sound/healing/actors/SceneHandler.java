package com.sound.healing.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.sound.healing.AssetLoader;
import com.sound.healing.Screen;
import com.sound.healing.custom.MoreInfo;
import com.sound.healing.custom.Spread;

public class SceneHandler {
	
	private CreateMainMenu createMainMenu;
	private CreateSpreadSelect createSpreadSelect;
	private CreateInfo createInfo;
	private CreateChoose createChoose;
	private CreateReveal createReveal;
	private CreateCard createCard;
	private Spread spread;
	private MoreInfo moreInfo;
	private Stage currentSpreadStage;
	private CreateLoad createLoad;
	private CreateLoadReveal createLoadReveal;
	private CreateBrowse createBrowse;
	private CreateIndividual createIndividual;
	private CreateRevealIndividual createRevealIndividual;
	private CreateSplash createSplash;
	private CreateMoreInfo createMoreInfo;
	private CreateMoreInfoSub createMoreInfoSub;
	private int isLoad = 0;
	private boolean isBack = false;
	private Stage previousStage;
	private boolean isHelp = false;
	private SpriteBatch batch;
	
	public SceneHandler() {
		batch = new SpriteBatch();
	}
	
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
	
	public CreateScene getCreateBrowse() {
		if(createBrowse == null){
			createBrowse = new CreateBrowse();
		}
		return createBrowse;
	}
	
	public void unloadCreateBrowse() {
		if(createBrowse != null){
			createBrowse.dispose();
			createBrowse = null;
		}
	}
	
	public CreateScene getCreateIndividual() {
		if(createIndividual == null){
			createIndividual = new CreateIndividual();
		}
		return createIndividual;
	}
	
	public CreateScene getCreateRevealIndividual() {
		if(createRevealIndividual == null){
			createRevealIndividual = new CreateRevealIndividual();
		}
		return createRevealIndividual;
	}
	
	public CreateSplash getCreateSplash() {
		if(createSplash == null){
			createSplash = new CreateSplash();
		}
		return createSplash;
	}
	
	public CreateScene getCreateMoreInfo() {
		if(createMoreInfo == null){
			createMoreInfo = new CreateMoreInfo();
		}
		return createMoreInfo;
	}
	
	public CreateScene getCreateMoreInfoSub() {
		if(createMoreInfoSub == null){
			createMoreInfoSub = new CreateMoreInfoSub();
		}
		return createMoreInfoSub;
	}

	public void setSpread(Spread spread) {
		this.spread = spread;
	}
	
	public Spread getSpread() {
		return spread;
	}
	
	public MoreInfo getMoreInfo() {
		return moreInfo;
	}
	
	public void setMoreInfo(MoreInfo moreInfo) {
		this.moreInfo = moreInfo;
	}
	
	public Stage getCurrentSpreadStage() {
		return currentSpreadStage;
	}
	
	public void setCurrentSpreadStage(Stage currentSpreadStage) {
		this.currentSpreadStage = currentSpreadStage;
	}
	
	public int getLoad() {
		return isLoad;
	}
	
	public void setLoad(int isLoad) {
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
	public boolean isHelp() {
		return isHelp;
	}
	public void setHelp(boolean isHelp) {
		this.isHelp = isHelp;
	}

	public SpriteBatch getBatch() {
		return batch;
	}


}
