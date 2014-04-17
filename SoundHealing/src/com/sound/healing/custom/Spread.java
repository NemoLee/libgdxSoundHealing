package com.sound.healing.custom;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;



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
	
	public String getInfocard(){
		switch(this){
			case SOUND_ADVICE:
				return "Info/infocard1.png";
			case SYMPHONY_OF_LIFE:
				return "Info/infocard2.png";
			case DUET:
				return "Info/infocard3.png";
			case HEARTSONG:
				return "Info/infocard4.png";
			case RETUNING:
				return "Info/infocard5.png";
			case SINGING_EARTH:
				return "Info/infocard6.png";
			case ANGELS_OF_SOUND:
				return "Info/infocard8.png";
			case INDIVIDUAL:
				return "Info/infocard9.png";
			case MULTI:
				return "Info/infocard7.png";
			default:
				return "";
		}
	}
	
	public String getInfoDescription(){
		switch(this){
		case SOUND_ADVICE:
			return "CARD 1 The life lesson/challenge you have just learned/moved through\nCARD 2 Where you currently are/what you need to address right now\nCARD 3 The outcome/what you will attract into your life/need to deal with in the future";
		case SYMPHONY_OF_LIFE:
			return "CARD 1 What you most need to know\nCARD 2 What you most need to work on\nCARD 3 Your biggest current block\nCARD 4 What your vibration is attracting to you\nCARD 5 What is helping you on your path\nCARD 6 Tap an Angel of Sound card to guide you";
		case DUET:
			return "CARD 1 Your energy in the current situation\nCARD 2 The other person’s energy in the current situation\nCARD 3 The energy you are creating together\nCARD 4 What you personally most need to address/work with/let go of\nCARD 5 Your highest potential together";
		case HEARTSONG:
			return "CARD 1 Your greatest gift you brought with you into this life\nCARD 2 Your greatest current challenge/block\nCARD 3 Why you are here this incarnation\nCARD 4 What you need to address to manifest your dreams\nCARD 5 What Life is trying to tell you right now";
		case RETUNING:
			return "CARD 1 Where is your energy blocked?\nCARD 2 What do you need to address to release blocks/increase your current vitality?\nCARD 3 What would really help you to be healthier and happier?\nCARD 4 How can you tune yourself up into being ‘sound’ in body and mind?\nCARD 5 A message from your body to you";
		case SINGING_EARTH:
			return  "CARD 1 What does the Earth really need?\nCARD 2 What can you personally do to help?\nCARD 3 What sound should you/we focus on the planet to heal it?\nCARD 4 How can you/we help mankind to resonate more in harmony with the Earth?\nCARD 5 What can you/we give back to the Earth to show gratitude?";
		case ANGELS_OF_SOUND:
			return "The four Angels cards are removed from the main pack to guide your reading. Now choose four cards to line up beneath the randomly-placed Angel cards:\n\nCARD 1 The main life lesson you chose in your Divine Plan before coming here.\n\tTap the Angel card to see which Angel is assisting you in this.\nCARD 2 The major current challenges you need to address.\n\tTap the Angel card to see which Angel is assisting you in this.\nCARD 3 A gift from the Angels of Sound to you.\n\tTap the Angel card to see which Angel is assisting you in this.\nCARD 4 How the Angels of Sound will work and sing with you.\n\tTap the Angel card to see which Angel is assisting you in this.";
		case INDIVIDUAL:
			return "Choose one of the eight chakra suits displayed. Then, asking what you most need to know in this moment, choose one closed chakra card, one open chakra card, a heaven or earth card and one angel card. \nChoose a chakra suit"
					+"Choose a closed chakra card, "
					+"Choose an open chakra card, "
					+"Choose a heaven or earth card, "
					+"Choose an Angel of Sound card, "
					+"\n1.	Closed chakra card: use the sound on the card to vibrate the chakra and release blocks."
					+"\n2.	Open chakra card: use the sound to fill the chakra with positive energy, place hands on chakra and send in healing sound to the place where the block has been released."
					+"\n3.	Heaven card: use high sound to connect to Source and visualise a sacred spiral of sound and colour pouring in through the crown to the chakra. Earth card: use low sound and visualise connecting the chakra down through the body deep into the earth."
					+"\n4.	Angel of Sound: find a sound to connect with this angel and as you tone, visualise pink gold light pouring in through the crown and filling the chakra.";
		case MULTI:
			return "Choose a Root Chakra card.\nNow choose a Sacral Chakra card.\nNow choose a Solar Plexus Chakra card.\nNow choose a Heart Chakra card.\nNow choose a Throat Chakra card.\nNow choose a Third Eye Chakra card.\nNow choose a Crown Chakra card.\nNow choose a Whole Body card.\nNow choose an Angel for guidance.\n\nBeginning with the Root chakra, work with the cards and sounds in sequence, right up to the Crown, the Whole Body and finishing with the Angel of Sound.";
		default:
			return "";
	}
	}
	
	public int getNumberOfCards(){
		switch(this){
		case SOUND_ADVICE:
			return 3;
		case SYMPHONY_OF_LIFE:
			return 6;
		case DUET:
			return 5;
		case HEARTSONG:
			return 5;
		case RETUNING:
			return 5;
		case SINGING_EARTH:
			return 5;
		case ANGELS_OF_SOUND:
			return 4;
		case INDIVIDUAL:
			return 10;
		case MULTI:
			return 9;
		default:
			return 0;
	}
	}
	
	Array<Integer> a = null;
	public Array<Integer> getSpreadLayout(){
		a = null;
		a = new Array<Integer>(); 
		int cardWidth;
		int cardHeight;
		int offset;
		switch(this){
		case SOUND_ADVICE:
			a.removeAll(a, true);
			cardWidth = (Gdx.graphics.getWidth()-(3*10))/3;
			cardHeight = (int)(cardWidth*1.4533);
			
			a.add(Gdx.graphics.getWidth()/60);
			a.add((Gdx.graphics.getHeight()/2)-(cardHeight/2));
			
			a.add((Gdx.graphics.getWidth()/2)-(cardWidth/2));
			a.add((Gdx.graphics.getHeight()/2)-(cardHeight/2));
			
			a.add(Gdx.graphics.getWidth()-(cardWidth)-Gdx.graphics.getWidth()/60);
			a.add((Gdx.graphics.getHeight()/2)-(cardHeight/2));
			return a;
		case SYMPHONY_OF_LIFE:
			a.removeAll(a, true);
			cardWidth = (Gdx.graphics.getWidth()-(6*10))/6;
			cardHeight = (int)(cardWidth*1.4533);
			offset = Gdx.graphics.getHeight()/50;
			
			a.add(Gdx.graphics.getWidth()/2-cardWidth/2);
			a.add(Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+4*(offset+cardHeight)));
			
			a.add((Gdx.graphics.getWidth()/2)-(cardWidth/2));
			a.add(Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+3*(offset+cardHeight)));
			
			a.add((Gdx.graphics.getWidth()/2)-(cardWidth/2));
			a.add(Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+2*(offset+cardHeight)));
			
			a.add(Gdx.graphics.getWidth()-cardWidth-cardWidth/2);
			a.add(Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+offset+cardHeight+cardHeight/2));
			
			a.add(cardWidth/2);
			a.add(Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+offset+cardHeight+cardHeight/2));
			
			a.add((Gdx.graphics.getWidth()/2)-(cardWidth/2));
			a.add(Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+offset+cardHeight));
			
			
			return a;
		case DUET:
			a.removeAll(a, true);
			cardWidth = (Gdx.graphics.getWidth()-(5*10))/5;
			cardHeight = (int)(cardWidth*1.4533);
			offset = Gdx.graphics.getHeight()/36;
			
			a.add(cardWidth/2);
			a.add(Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+2*(offset+cardHeight)));
			
			a.add(Gdx.graphics.getWidth()-cardWidth-cardWidth/2);
			a.add(Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+2*(offset+cardHeight)));
			
			a.add((Gdx.graphics.getWidth()/2)-(cardWidth/2));
			a.add(Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+2*(offset+cardHeight)));
			
			a.add((Gdx.graphics.getWidth()/2)-(cardWidth/2));
			a.add(Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+3*(offset+cardHeight)));
			
			a.add((Gdx.graphics.getWidth()/2)-(cardWidth/2));
			a.add(Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+offset+cardHeight));

			return a;
		case HEARTSONG:
			a.removeAll(a, true);
			cardWidth = (Gdx.graphics.getWidth()-(5*10))/5;
			cardHeight = (int)(cardWidth*1.4533);
			offset = Gdx.graphics.getHeight()/36;
			
			a.add(0);
			a.add(Gdx.graphics.getHeight()/2-cardHeight);
			
			a.add((Gdx.graphics.getWidth()/3)-(cardWidth/2)-cardWidth/5);
			a.add(Gdx.graphics.getHeight()/2-cardHeight/2);
			
			a.add((Gdx.graphics.getWidth()/2)-(cardWidth/2));
			a.add(Gdx.graphics.getHeight()/2);
			
			a.add(Gdx.graphics.getWidth()-((Gdx.graphics.getWidth()/3)-(cardWidth/2)+cardWidth-cardWidth/5));
			a.add(Gdx.graphics.getHeight()/2-cardHeight/2);
			
			a.add(Gdx.graphics.getWidth()-cardWidth);
			a.add(Gdx.graphics.getHeight()/2-cardHeight);
			return a;
		case RETUNING:
			a.removeAll(a, true);
			cardWidth = (Gdx.graphics.getWidth()-(5*10))/5;
			cardHeight = (int)(cardWidth*1.4533);
			offset = Gdx.graphics.getHeight()/36;
			
			a.add(0);
			a.add(Gdx.graphics.getHeight()/2);
			
			a.add((Gdx.graphics.getWidth()/3)-(cardWidth/2)-cardWidth/5);
			a.add(Gdx.graphics.getHeight()/2-cardHeight/2);
			
			a.add((Gdx.graphics.getWidth()/2)-(cardWidth/2));
			a.add(Gdx.graphics.getHeight()/2-cardHeight);
			
			a.add(Gdx.graphics.getWidth()-((Gdx.graphics.getWidth()/3)-(cardWidth/2)+cardWidth-cardWidth/5));
			a.add(Gdx.graphics.getHeight()/2-cardHeight/2);
			
			a.add(Gdx.graphics.getWidth()-cardWidth);
			a.add(Gdx.graphics.getHeight()/2);
			return a;
		case SINGING_EARTH:
			a.removeAll(a, true);
			cardWidth = (Gdx.graphics.getWidth()-(5*10))/5;
			cardHeight = (int)(cardWidth*1.4533);
			offset = Gdx.graphics.getHeight()/36;
			
			a.add((Gdx.graphics.getWidth()/2)-(cardWidth/2));
			a.add(Gdx.graphics.getHeight()/2);
			
			a.add(0);
			a.add(Gdx.graphics.getHeight()/2-cardHeight-offset);
			
			a.add(0);
			a.add(Gdx.graphics.getHeight()/2);
			
			a.add(Gdx.graphics.getWidth()-cardWidth);
			a.add(Gdx.graphics.getHeight()/2);
			
			a.add(Gdx.graphics.getWidth()-cardWidth);
			a.add(Gdx.graphics.getHeight()/2-cardHeight-offset);
		
			return a;
		case ANGELS_OF_SOUND:
			a.removeAll(a, true);
			cardWidth = (Gdx.graphics.getWidth()-(4*10))/3;
			cardHeight = (int)(cardWidth*1.4533);
			offset = Gdx.graphics.getHeight()/20;
			
			a.add(Gdx.graphics.getWidth()/60+offset);
			a.add((Gdx.graphics.getHeight()/2)-(cardHeight/2));
			
			a.add(Gdx.graphics.getWidth()/60+offset);
			a.add((Gdx.graphics.getHeight()/2)-(cardHeight/2)+ cardHeight);
			
			
			a.add((Gdx.graphics.getWidth()/3)-(cardWidth/4)+offset);
			a.add((Gdx.graphics.getHeight()/2)-(cardHeight/2));
			
			a.add((Gdx.graphics.getWidth()/3)-(cardWidth/4)+offset);
			a.add((Gdx.graphics.getHeight()/2)-(cardHeight/2)+ cardHeight);
			
			
			a.add((Gdx.graphics.getWidth()/3)+(cardWidth/2)+offset);
			a.add((Gdx.graphics.getHeight()/2)-(cardHeight/2));
			
			a.add((Gdx.graphics.getWidth()/3)+(cardWidth/2)+offset);
			a.add((Gdx.graphics.getHeight()/2)-(cardHeight/2)+ cardHeight);
				
			
			a.add(Gdx.graphics.getWidth()-(cardWidth)+(Gdx.graphics.getWidth()/25)+offset);
			a.add((Gdx.graphics.getHeight()/2)-(cardHeight/2));
			
			a.add(Gdx.graphics.getWidth()-(cardWidth)+(Gdx.graphics.getWidth()/25)+offset);
			a.add((Gdx.graphics.getHeight()/2)-(cardHeight/2)+ cardHeight);
				

			return a;
		case INDIVIDUAL:
			a.removeAll(a, true);
			cardWidth = (Gdx.graphics.getWidth()-(8*10))/8;
			cardHeight = (int)(cardWidth*1.4533);
			offset = Gdx.graphics.getWidth()/20;
					
		
			a.add(Gdx.graphics.getWidth()/2+cardWidth/2);
			a.add(Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+1*(offset+cardHeight)+cardHeight/2));
			
			a.add(Gdx.graphics.getWidth()/2-cardWidth-cardWidth/2);
			a.add(Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+1*(offset+cardHeight)+cardHeight/2));
			
			a.add(Gdx.graphics.getWidth()/2+cardWidth/2);
			a.add(Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+2*(offset+cardHeight)+cardHeight/2));
			
			a.add(Gdx.graphics.getWidth()/2-cardWidth-cardWidth/2);
			a.add(Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+2*(offset+cardHeight)+cardHeight/2));
			
			a.add(Gdx.graphics.getWidth()/2+cardWidth/2);
			a.add(Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+3*(offset+cardHeight)+cardHeight/2));
			
			a.add(Gdx.graphics.getWidth()/2-cardWidth-cardWidth/2);
			a.add(Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+3*(offset+cardHeight)+cardHeight/2));
			
			a.add(Gdx.graphics.getWidth()/2+cardWidth/2);
			a.add(Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+4*(offset+cardHeight)+cardHeight/2));
			
			a.add(Gdx.graphics.getWidth()/2-cardWidth-cardWidth/2);
			a.add(Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+4*(offset+cardHeight)+cardHeight/2));
			
			a.add(Gdx.graphics.getWidth()/2+cardWidth*2);
			a.add(Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+4*(offset+cardHeight)+cardHeight/2));
			
			a.add(Gdx.graphics.getWidth()/2-(cardWidth+cardWidth/2)*2);
			a.add(Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+4*(offset+cardHeight)+cardHeight/2));
			return a;
		case MULTI:
			a.removeAll(a, true);
			cardWidth = (Gdx.graphics.getWidth()-(11*10))/11;
			cardHeight = (int)(cardWidth*1.4533);
			offset = Gdx.graphics.getWidth()/80;
					
			a.add((Gdx.graphics.getWidth()/2)-(cardWidth/2));
			a.add(Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+1*(offset+cardHeight)));	
			
			a.add((Gdx.graphics.getWidth()/2)-(cardWidth/2));
			a.add(Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+2*(offset+cardHeight)));
		
			a.add((Gdx.graphics.getWidth()/2)-(cardWidth/2));
			a.add(Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+3*(offset+cardHeight)));
				
			a.add(Gdx.graphics.getWidth()/2-cardWidth/2);
			a.add(Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+4*(offset+cardHeight)));
			
			a.add(Gdx.graphics.getWidth()/2-cardWidth/2);
			a.add(Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+5*(offset+cardHeight)));
			
			a.add(Gdx.graphics.getWidth()/2-cardWidth/2);
			a.add(Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+6*(offset+cardHeight)));
			
			a.add(Gdx.graphics.getWidth()/2-cardWidth/2);
			a.add(Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+7*(offset+cardHeight)));
			
			a.add(Gdx.graphics.getWidth()/2-cardWidth/2);
			a.add(Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+8*(offset+cardHeight)));
			
			a.add(Gdx.graphics.getWidth()/2+cardWidth);
			a.add(Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/6+4*(offset+cardHeight)+cardHeight/2));
			
	
			return a;
		default:
			return a;
		}

	}
	
}
