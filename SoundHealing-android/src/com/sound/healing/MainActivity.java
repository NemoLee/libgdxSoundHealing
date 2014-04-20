package com.sound.healing;

import android.os.Bundle;

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
} 