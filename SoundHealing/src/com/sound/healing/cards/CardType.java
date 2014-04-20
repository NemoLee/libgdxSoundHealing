package com.sound.healing.cards;

public enum CardType {
	
	ROOT, SACRAL, SOLARPLEXUS, HEART, THROAT, THIRDEYE, CROWN, WHOLEBODY, ANGEL, ALL;
	
	@Override
	public String toString() {
		switch(this){
		case ROOT:
			return "Root";
		case SACRAL:
			return "Sacral";
		case SOLARPLEXUS:
			return "SolarPlexus";
		case HEART:
			return "Heart";
		case THROAT:
			return "Throat";
		case THIRDEYE:
			return "ThirdEye";
		case CROWN:
			return "Crown";
		case WHOLEBODY:
			return "WholeBody";
		case ANGEL:
			return "Angel";
		case ALL:
			return "All";
		default: return "No SUIT";
		
		}
	}
		public String getSoundID(){
		switch(this){
		case ROOT:
			return "instruct_ah";
		case SACRAL:
			return "instruct_ay";
		case SOLARPLEXUS:
			return "instruct_or";
		case HEART:
			return "instruct_oh";
		case THROAT:
			return "instruct_ee";
		case THIRDEYE:
			return "instruct_ohm";
		case CROWN:
			return "instruct_ooh";
		case WHOLEBODY:
			return "instruct_iam";
		case ANGEL:
			return "instruct_angel";
		case ALL:
			return "All";
		default: return "No SUIT";
		
		}
	
	}

}
