package com.sound.healing.cards;

public enum CardEnum {
	
	NAME, TYPE, IMAGE, DESCRIPTION, SOUND1, SOUND2, ID;
	
	public int getEnumID(){
		switch(this){
		case NAME:
			return 0;
		case TYPE:
			return 1;
		case IMAGE:
			return 2;
		case DESCRIPTION:
			return 3;
		case SOUND1:
			return 4;
		case SOUND2:
			return 5;
		case ID:
			return 6;
		default:
			return -1;
		}
		
	}
	
	

}
