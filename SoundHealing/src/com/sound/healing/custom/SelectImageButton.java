package com.sound.healing.custom;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;

public class SelectImageButton extends Button{

	float width, height;
	public SelectImageButton(ButtonStyle style, int x, int y, int width, int height) {
		super(style);
		this.width = width;
		this.height = height;
		setPosition(x, y);
		setSize(width, height);
		
		
	}

}
