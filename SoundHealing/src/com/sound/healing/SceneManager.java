package com.sound.healing;

import com.sound.healing.actors.SceneHandler;
import com.sound.healing.screens.BaseScreen;
import com.sound.healing.screens.CardScreen;
import com.sound.healing.screens.ChooseScreen;
import com.sound.healing.screens.InfoScreen;
import com.sound.healing.screens.LoadScreen;
import com.sound.healing.screens.MainMenuScreen;
import com.sound.healing.screens.RevealScreen;
import com.sound.healing.screens.SpreadSelectScreen;
import com.sound.healing.screens.loadRevealScreen;

public class SceneManager {
	
	private MainScene game;
	private BaseScreen menu;
	private BaseScreen select;
	private BaseScreen info;
	private BaseScreen choose;
	private BaseScreen reveal;
	private BaseScreen card;
	private BaseScreen load;
	private BaseScreen loadreveal;

	//Scene.MAIN_MENU
	
	private static final SceneManager INSTANCE = new SceneManager();
	
	private Scene currentSceneType = Scene.MAIN_MENU;
	 
	private BaseScreen currentScene;
	
	public void setScene(BaseScreen currentScene) {
		this.currentScene = currentScene;
		this.currentSceneType = currentScene.getSceneType();
	}
	
	public void setScene(Scene scene){
		switch(scene){
		case MAIN_MENU:
			setScene(menu);
			break;
		case SPREAD_SELECT:
			setScene(select);
		break;
		case INFO:
			setScene(info);
		break;
		case CHOOSE:
			setScene(choose);
			break;
		case REVEAL:
			setScene(reveal);
			break;
		case CARD:
			setScene(card);
			break;
		case LOAD:
			setScene(load);
			break;
		case LOAD_REVEAL:
			setScene(loadreveal);
			break;
		case BROWSE:
			//setScene(loading);
			break;
		case MORE_INFO:
			//setScene(loading);
			break;
		
		}
		
	}
	
	public static SceneManager getInstance() {
		return INSTANCE;
	}
	
	public MainMenuScreen createMainMenu(MainScene game){
		this.game = game;
		AssetLoader.getInstance().loadAll();
		menu = new MainMenuScreen(SceneHandler.getInstance().getCreateMainMenu().getSpec());	
		setScene(Scene.MAIN_MENU);
		return (MainMenuScreen) currentScene;
	}
	
	
	public SpreadSelectScreen createSpreadSelect(){
		select = new SpreadSelectScreen(SceneHandler.getInstance().getCreateSpreadSelect().getSpec());
		setScene(Scene.SPREAD_SELECT);
		return (SpreadSelectScreen) currentScene;
	}
	
	
	public InfoScreen createInfo(){
		info = new InfoScreen(SceneHandler.getInstance().getCreateInfo().getSpec());
		setScene(Scene.INFO);
		return (InfoScreen) currentScene;
	}
	
	public ChooseScreen createChoose(){
		choose = new ChooseScreen(SceneHandler.getInstance().getCreateChoose().getSpec());
		setScene(Scene.CHOOSE);
		return (ChooseScreen) currentScene;
	}
	
	public RevealScreen createReveal(){
		reveal = new RevealScreen(SceneHandler.getInstance().getCreateReveal().getSpec());
		setScene(Scene.REVEAL);	
		return (RevealScreen) currentScene;
	}
	
	public CardScreen createCard(){
		card = new CardScreen(SceneHandler.getInstance().getCreateCard().getSpec());
		setScene(Scene.CARD);	
		return (CardScreen) currentScene;
	}
	
	public LoadScreen createLoad(){
		load = new LoadScreen(SceneHandler.getInstance().getCreateLoad().getSpec());
		setScene(Scene.LOAD);	
		return (LoadScreen) currentScene;
	}
	
	public loadRevealScreen createLoadReveal(){
		loadreveal = new loadRevealScreen(SceneHandler.getInstance().getCreateLoadReveal().getSpec());
		setScene(Scene.LOAD_REVEAL);
		return (loadRevealScreen) currentScene;
	}

	
	
	
	
	public MainScene getGame() {
		return game;
	}

}
