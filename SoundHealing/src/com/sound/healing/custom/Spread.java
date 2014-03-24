package com.sound.healing.custom;

public enum Spread {
	
	SOUND_ADVICE, SYMPHONY_OF_LIFE, DUET, HEARTSONG, RETUNING, SINGING_EARTH, ANGELS_OF_SOUND, INDIVIDUAL, MULTI;
	
	
	@Override
	public String toString() {
		switch(this){
		case SOUND_ADVICE:
			return "SOUND ADVICE";
		case SYMPHONY_OF_LIFE:
			return "SYMPHONY OF LIFE";
		case DUET:
			return "DUET";
		case HEARTSONG:
			return "HEARTSONG";
		case RETUNING:
			return "RETUNING";
		case SINGING_EARTH:
			return "SINGING EARTH";
		case ANGELS_OF_SOUND:
			return "ANGELS OF SOUND";
		case INDIVIDUAL:
			return "INDIVIDUAL CHAKRA READING";
		case MULTI:
			return "MULTI CHAKRA READING";
		default:
			return "";
		}
	}

}
