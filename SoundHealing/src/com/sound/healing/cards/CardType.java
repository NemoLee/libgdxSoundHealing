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
			return "Instruct/instruct_ah.png";
		case SACRAL:
			return "Instruct/instruct_ay.png";
		case SOLARPLEXUS:
			return "Instruct/instruct_or.png";
		case HEART:
			return "Instruct/instruct_oh.png";
		case THROAT:
			return "Instruct/instruct_ee.png";
		case THIRDEYE:
			return "Instruct/instruct_ohm.png";
		case CROWN:
			return "Instruct/instruct_ooh.png";
		case WHOLEBODY:
			return "Instruct/instruct_iam.png";
		case ANGEL:
			return "Instruct/instruct_ah.png";
		case ALL:
			return "All";
		default: return "No SUIT";
		
		}
	
	}

}
