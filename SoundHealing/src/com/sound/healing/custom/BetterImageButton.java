package com.sound.healing.custom;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Scaling;
import com.esotericsoftware.tablelayout.Cell;

public class BetterImageButton extends Button{
	
	private Image image;
	private ImageButtonStyle style;


	public BetterImageButton (ImageButtonStyle style, Image image) {
		super(style);
		this.image = new Image();
		this.image.setScaling(Scaling.fit);
		add(this.image);
		setStyle(style);
		setSize(getPrefWidth(), getPrefHeight());
	}

	public void setStyle (ButtonStyle style) {
		if (!(style instanceof ImageButtonStyle)) throw new IllegalArgumentException("style must be an ImageButtonStyle.");
		super.setStyle(style);
		this.style = (ImageButtonStyle)style;
		if (image != null) updateImage();
	}

	public ImageButtonStyle getStyle () {
		return style;
	}

	private void updateImage () {
		/*
		boolean isPressed = isPressed();
		if (isDisabled() && style.imageDisabled != null)
			image.setDrawable(style.imageDisabled);
		else if (isPressed && style.imageDown != null)
			image.setDrawable(style.imageDown);
		else if (isChecked() && style.imageChecked != null)
			image.setDrawable((style.imageCheckedOver != null && isOver()) ? style.imageCheckedOver : style.imageChecked);
		else if (isOver() && style.imageOver != null)
			image.setDrawable(style.imageOver);
		else if (style.imageUp != null) //
			image.setDrawable(style.imageUp);
			*/
	}

	public void draw (Batch batch, float parentAlpha) {
		//updateImage();
		super.draw(batch, parentAlpha);
	}

	public Image getImage () {
		return image;
	}

	public Cell getImageCell () {
		return getCell(image);
	}
/*

	static public class ImageButtonStyle extends ButtonStyle {
	
		public Drawable imageUp, imageDown, imageOver, imageChecked, imageCheckedOver, imageDisabled;

		public ImageButtonStyle () {
		}

		public ImageButtonStyle (Drawable up, Drawable down, Drawable checked, Drawable imageUp, Drawable imageDown,
			Drawable imageChecked) {
			super(up, down, checked);
			this.imageUp = imageUp;
			this.imageDown = imageDown;
			this.imageChecked = imageChecked;
		}

		public ImageButtonStyle (ImageButtonStyle style) {
			super(style);
			this.imageUp = style.imageUp;
			this.imageDown = style.imageDown;
			this.imageOver = style.imageOver;
			this.imageChecked = style.imageChecked;
			this.imageCheckedOver = style.imageCheckedOver;
			this.imageDisabled = style.imageDisabled;
		}

		public ImageButtonStyle (ButtonStyle style) {
			super(style);
		}
	}
	*/
}