package com.sound.healing;

import com.sound.healing.actors.CreateMainMenu;
import com.sound.healing.actors.CreateSpreadSelect;
import com.sound.healing.actors.SceneHandler;
import com.sound.healing.screens.BrowseScreen;
import com.sound.healing.screens.CardBackScreen;
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
	 

 
    MAIN_MENU {
        @Override
        protected com.badlogic.gdx.Screen getScreenInstance() {
             return new MainMenuScreen(SceneHandler.getInstance().getCreateMainMenu().getSpec());
        }
    },
 
    BROWSE {
        @Override
        protected com.badlogic.gdx.Screen getScreenInstance() {
             return new BrowseScreen();
        }
    },
 
    LOAD {
        @Override
        protected com.badlogic.gdx.Screen getScreenInstance() {
             return new LoadScreen(SceneHandler.getInstance().getCreateLoad().getSpec());
        }
    },
    
    MORE_INFO {
        @Override
        protected com.badlogic.gdx.Screen getScreenInstance() {
             return new MoreInfoScreen();
        }
    },
    
    SPREAD_SELECT {
        @Override
        protected com.badlogic.gdx.Screen getScreenInstance() {
             return new SpreadSelectScreen(SceneHandler.getInstance().getCreateSpreadSelect().getSpec());
        }
    },
    
    INFO {
        @Override
        protected com.badlogic.gdx.Screen getScreenInstance() {
             return new InfoScreen(SceneHandler.getInstance().getCreateInfo().getSpec());
        }
    },
    
    CHOOSE {
        @Override
        protected com.badlogic.gdx.Screen getScreenInstance() {
             return new ChooseScreen(SceneHandler.getInstance().getCreateChoose().getSpec());
        }
    },
 
    REVEAL {
        @Override
        protected com.badlogic.gdx.Screen getScreenInstance() {
             return new RevealScreen(SceneHandler.getInstance().getCreateReveal().getSpec());
        }
    },
    
    Card {
        @Override
        protected com.badlogic.gdx.Screen getScreenInstance() {
             return new CardScreen(SceneHandler.getInstance().getCreateCard().getSpec());
        }
    },
    
    LOAD_REVEAL {
        @Override
        protected com.badlogic.gdx.Screen getScreenInstance() {
             return new loadRevealScreen(SceneHandler.getInstance().getCreateLoadReveal().getSpec());
        }
    };
    
    protected abstract com.badlogic.gdx.Screen getScreenInstance();
 
}