package com.sound.healing;

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

public enum Screen {
	 

 
    MAIN_MENU {
        @Override
        protected com.badlogic.gdx.Screen getScreenInstance() {
             return new MainMenuScreen();
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
             return new LoadScreen();
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
             return new SpreadSelectScreen();
        }
    },
    
    INFO {
        @Override
        protected com.badlogic.gdx.Screen getScreenInstance() {
             return new InfoScreen();
        }
    },
    
    CHOOSE {
        @Override
        protected com.badlogic.gdx.Screen getScreenInstance() {
             return new ChooseScreen();
        }
    },
 
    REVEAL {
        @Override
        protected com.badlogic.gdx.Screen getScreenInstance() {
             return new RevealScreen();
        }
    },
    
    Card {
        @Override
        protected com.badlogic.gdx.Screen getScreenInstance() {
             return new CardScreen();
        }
    },
    
    Card_Back {
        @Override
        protected com.badlogic.gdx.Screen getScreenInstance() {
             return new CardBackScreen();
        }
    };
    
    protected abstract com.badlogic.gdx.Screen getScreenInstance();
 
}