package com.sound.healing.custom;

import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;

public class SelectImageButton extends ImageButton{

	float width, height;
	public SelectImageButton(ImageButtonStyle style, int x, int y, int width, int height) {
		super(style);
		this.width = width;
		this.height = height;
		setPosition(x, y);
		setSize(width, height);
	}

}
