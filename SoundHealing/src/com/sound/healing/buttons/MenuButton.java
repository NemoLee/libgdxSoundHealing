package com.sound.healing.buttons;



import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.sound.healing.Screen;
import com.sound.healing.ScreenManager;
import com.sound.healing.screens.BaseScreen;

public class MenuButton extends TextButton{


	public MenuButton(String text, TextButtonStyle style, float x, float y, float width, float height, final BaseScreen screen, final Screen showScreen) {
		super(text, style);
		setPosition(x, y);
		setSize(width, height);
		addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				
				return true;
		 	}

			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
		        ScreenManager.getInstance().show(showScreen);
		        screen.dispose();
					
		 	}
	    });
		
	}
	
	


	
	

}
