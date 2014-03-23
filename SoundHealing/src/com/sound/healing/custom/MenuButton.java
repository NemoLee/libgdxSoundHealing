package com.sound.healing.custom;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.sound.healing.AssetLoader;
import com.sound.healing.Screen;
import com.sound.healing.ScreenManager;
import com.sound.healing.screens.BaseScreen;

public class MenuButton extends TextButton{

	float width, height;
	public MenuButton(String text, TextButtonStyle style, final float x, final float y, final float width, final float height) {
		super(text, style);
		this.width = width;
		this.height = height;
		setPosition(x, y);
		setSize(width, height);
		
	}
}
