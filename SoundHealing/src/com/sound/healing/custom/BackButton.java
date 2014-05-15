package com.sound.healing.custom;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class BackButton extends Button{

	
	float width, height;
	
	public BackButton(ButtonStyle style, final float x, final float y, final float width, final float height) {
		super(style);
		this.width = width;
		this.height = height;
		setPosition(x, y);
		setSize(width, height);
		
	}
	
	
}
