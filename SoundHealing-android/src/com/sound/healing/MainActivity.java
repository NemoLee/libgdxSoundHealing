package com.sound.healing;

import android.os.Bundle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class MainActivity extends AndroidApplication {
    @Override  
    public void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState);
        
        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
        initialize(new MainScene(), cfg);
    }
    
    @Override
    public void onBackPressed() {
 
    }
    
    @Override
    protected void onPause() {
       	int pid = android.os.Process.myPid(); 
    	android.os.Process.killProcess(pid);
    	super.onPause();
    }
}   

/**
 * things to fix:
 * the rest of the back buttons
 * each individual screen test for bottleneck
 * angel and indi fixes
 * grammar fixes.
 * 
 * /
 */