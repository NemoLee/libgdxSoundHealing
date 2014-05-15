package com.sound.healing.custom;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.sound.healing.AssetLoader;
import com.sound.healing.Screen;
import com.sound.healing.ScreenManager;
import com.sound.healing.cards.CardEnum;
import com.sound.healing.cards.CardType;
import com.sound.healing.screens.BaseScreen;

public class MenuButton extends TextButton{

	float width, height;
	private Spread spread;
	private int[] spreadIDS;
	
	public MenuButton(String text, TextButtonStyle style, final float x, final float y, final float width, final float height) {
		super(text, style);
		this.width = width;
		this.height = height;
		setPosition(x, y);
		setSize(width, height);
		
	}

	public void setSpreadType(String spreadName){
		if(Spread.SINGLE.toString().equals(spreadName)){
			spread = Spread.SINGLE;
		}
		if(Spread.SOUND_ADVICE.toString().equals(spreadName)){
			spread = Spread.SOUND_ADVICE;
		}
		if(Spread.SYMPHONY_OF_LIFE.toString().equals(spreadName)){
			spread = Spread.SYMPHONY_OF_LIFE;
		}
		if(Spread.DUET.toString().equals(spreadName)){
			spread = Spread.DUET;
		}
		if(Spread.HEARTSONG.toString().equals(spreadName)){
			spread = Spread.HEARTSONG;
		}
		if(Spread.RETUNING.toString().equals(spreadName)){
			spread = Spread.RETUNING;
		}
		if(Spread.SINGING_EARTH.toString().equals(spreadName)){
			spread = Spread.SINGING_EARTH;
		}
		if(Spread.ANGELS_OF_SOUND.toString().equals(spreadName)){
			spread = Spread.ANGELS_OF_SOUND;
		}
		if(Spread.INDIVIDUAL.toString().equals(spreadName)){
			spread = Spread.INDIVIDUAL;
		}
		if(Spread.MULTI.toString().equals(spreadName)){
			spread = Spread.MULTI;
		}
		
	}
	
	public Spread getSpread() {
		return spread;
	}

	public void setSpreadIDS(int[] spreadCards) {
		spreadIDS = spreadCards;
	}
	
	public int[] getSpreadIDS() {
		return spreadIDS;
	}
}
