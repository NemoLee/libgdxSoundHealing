package com.sound.healing;

import com.sound.healing.actors.SceneHandler;
import com.sound.healing.screens.BrowseScreen;
import com.sound.healing.screens.CardScreen;
import com.sound.healing.screens.ChooseScreen;
import com.sound.healing.screens.InfoScreen;
import com.sound.healing.screens.LoadScreen;
import com.sound.healing.screens.MainMenuScreen;
import com.sound.healing.screens.MoreInfoScreen;
import com.sound.healing.screens.RevealScreen;
import com.sound.healing.screens.SpreadSelectScreen;
import com.sound.healing.screens.loadRevealScreen;

public enum Screen {
	 
	MAIN_MENU,BROWSE,LOAD,MORE_INFO,SPREAD_SELECT,INFO,CHOOSE,REVEAL,Card,LOAD_REVEAL;
 
	
	
	public com.badlogic.gdx.Screen getScreenInstance(){
		switch(this){
		case MAIN_MENU:
			return new MainMenuScreen(SceneHandler.getInstance().getCreateMainMenu());
		case BROWSE:
			return new BrowseScreen(SceneHandler.getInstance().getCreateBrowse());
		case LOAD:
			return new LoadScreen(SceneHandler.getInstance().getCreateLoad());
		case MORE_INFO:
			return new MoreInfoScreen();
		case SPREAD_SELECT:
			return new SpreadSelectScreen(SceneHandler.getInstance().getCreateSpreadSelect());
		case INFO:
			return new InfoScreen(SceneHandler.getInstance().getCreateInfo());
		case CHOOSE:
			return new ChooseScreen(SceneHandler.getInstance().getCreateChoose());
		case REVEAL:
			return new RevealScreen(SceneHandler.getInstance().getCreateReveal());
		case Card:
			return new CardScreen(SceneHandler.getInstance().getCreateCard());
		case LOAD_REVEAL:
			return new loadRevealScreen(SceneHandler.getInstance().getCreateLoadReveal());
		default:
			return null;
		}
	}
}
	
   