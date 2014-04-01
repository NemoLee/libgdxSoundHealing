package com.sound.healing.cards;

import java.util.HashMap;

public class AllCards {
	
	private Card[] cards = new Card[52];
	private Card currentCard;
	
	private static final AllCards INSTANCE = new AllCards();
	
	public AllCards() {
		createCards();
		currentCard = cards[0];
	}
	
	private void createCards() {
	CardSpec[] c = new CardSpec[52];
		c[0] = new CardSpec("Tribal Chant", CardType.ROOT, "1.jpg", "", "/s_(71).mp3", "/s_(72).mp3", 1);
		c[1] = new CardSpec("Sound Ground", CardType.ROOT, "2.jpg", "", "/s_(74).mp3", "/s_(75).mp3", 2);
		c[2] = new CardSpec("Highland Air", CardType.ROOT, "3.jpg", "", "/s_(76).mp3", "/s_(77).mp3", 3);
		c[3] = new CardSpec("Big Bang", CardType.ROOT, "4.jpg", "", "/s_(78).mp3", "/s_(79).mp3", 4);
		c[4] = new CardSpec("Touch Bass", CardType.ROOT, "5.jpg", "", "/s_(80).mp3", "/s_(81).mp3", 5);
		c[5] = new CardSpec("Plainsong", CardType.ROOT, "6.jpg", "", "/s_(82).mp3", "/s_(83).mp3", 6);
		//CardType.SACRAL
		c[6] = new CardSpec("Resonance", CardType.SACRAL, "7.jpg", "", "/s_(84).mp3", "/s_(85).mp3", 7);
		c[7] = new CardSpec("Vibration Creation", CardType.SACRAL, "8.jpg", "", "/s_(87).mp3", "/s_(88).mp3", 8);
		c[8] = new CardSpec("Over Strung", CardType.SACRAL, "9.jpg", "", "/s_(89).mp3", "/s_(90).mp3", 9);
		c[9] = new CardSpec("Lost Chord", CardType.SACRAL, "10.jpg", "", "/s_(91).mp3", "/s_(92).mp3", 10);
		c[10] = new CardSpec("Perfect Pitch", CardType.SACRAL, "11.jpg", "", "/s_(93).mp3", "/s_(94).mp3", 11);
		c[11] = new CardSpec("Unison", CardType.SACRAL, "12.jpg", "", "/s_(95).mp3", "/s_(96).mp3", 12);
		//Solar Plexus
		c[12] = new CardSpec("Warrior Song", CardType.SOLARPLEXUS, "13.jpg", "", "/s_(97).mp3", "/s_(98).mp3", 13);
		c[13] = new CardSpec("Rising Star", CardType.SOLARPLEXUS, "14.jpg", "", "/s_(100).mp3", "/s_(101).mp3", 14);
		c[14] = new CardSpec("Distant Drums", CardType.SOLARPLEXUS, "15.jpg", "", "/s_(102).mp3", "/s_(103).mp3", 15);
		c[15] = new CardSpec("Unsound", CardType.SOLARPLEXUS, "16.jpg", "", "/s_(104).mp3", "/s_(105).mp3", 16);
		c[16] = new CardSpec("Chorale", CardType.SOLARPLEXUS, "17.jpg", "", "/s_(106).mp3", "/s_(107).mp3", 17);
		c[17] = new CardSpec("Super Troopers", CardType.SOLARPLEXUS, "18.jpg", "", "/s_(108).mp3", "/s_(109).mp3", 18);
		//CardType.HEART
		c[18] = new CardSpec("Heartsong", CardType.HEART, "19.jpg", "", "/s_(110).mp3", "/s_(111).mp3", 19);
		c[19] = new CardSpec("Ovation", CardType.HEART, "20.jpg", "", "/s_(113).mp3", "/s_(114).mp3", 20);
		c[20] = new CardSpec("Heavy Metal", CardType.HEART, "21.jpg", "", "/s_(115).mp3", "/s_(116).mp3", 21);
		c[21] = new CardSpec("Cacophony", CardType.HEART, "22.jpg", "", "/s_(117).mp3", "/s_(118).mp3", 22);
		c[22] = new CardSpec("Harmonics", CardType.HEART, "23.jpg", "", "/s_(119).mp3", "/s_(120).mp3", 23);
		c[23] = new CardSpec("Benediction", CardType.HEART, "24.jpg", "", "/s_(121).mp3", "/s_(122).mp3", 24);
		//CardType.THROAT
		c[24] = new CardSpec("Fanfare", CardType.THROAT, "25.jpg", "", "/s_(123).mp3", "/s_(124).mp3", 25);
		c[25] = new CardSpec("Anthem", CardType.THROAT, "26.jpg", "", "/s_(126).mp3", "/s_(127).mp3", 26);
		c[26] = new CardSpec("Speechless", CardType.THROAT, "27.jpg", "", "/s_(128).mp3", "/s_(129).mp3", 27);
		c[27] = new CardSpec("Cracked Bells", CardType.THROAT, "28.jpg", "", "/s_(130).mp3", "/s_(131).mp3", 28);
		c[28] = new CardSpec("Dawn Chorus", CardType.THROAT, "29.jpg", "", "/s_(132).mp3", "/s_(133).mp3", 29);
		c[29] = new CardSpec("Sacred Sound", CardType.THROAT, "30.jpg", "", "/s_(134).mp3", "/s_(135).mp3", 30);
		//THIRD EYE
		c[30] = new CardSpec("Silent Music", CardType.THIRDEYE, "31.jpg", "", "/s_(136).mp3", "/s_(137).mp3", 31);
		c[31] = new CardSpec("Mantra", CardType.THIRDEYE, "32.jpg", "", "/s_(139).mp3", "/s_(140).mp3", 32);
		c[32] = new CardSpec("Rigid Tempo", CardType.THIRDEYE, "33.jpg", "", "/s_(141).mp3", "/s_(142).mp3", 33);
		c[33] = new CardSpec("Off Key", CardType.THIRDEYE, "34.jpg", "", "/s_(143).mp3", "/s_(144).mp3", 34);
		c[34] = new CardSpec("Tuning Fork", CardType.THIRDEYE, "35.jpg", "", "/s_(145).mp3", "/s_(146).mp3", 35);
		c[35] = new CardSpec("Incantation", CardType.THIRDEYE, "36.jpg", "", "/s_(147).mp3", "/s_(148).mp3", 36);
		//CardType.CROWN
		c[36] = new CardSpec("Crystal Grail", CardType.CROWN, "37.jpg", "", "/s_(149).mp3", "/s_(150).mp3", 37);
		c[37] = new CardSpec("Attunement", CardType.CROWN, "38.jpg", "", "/s_(152).mp3", "/s_(153).mp3", 38);
		c[38] = new CardSpec("Dissonance", CardType.CROWN, "39.jpg", "", "/s_(154).mp3", "/s_(155).mp3", 39);
		c[39] = new CardSpec("Lament", CardType.CROWN, "40.jpg", "", "/s_(156).mp3", "/s_(157).mp3", 40);
		c[40] = new CardSpec("Grace Note", CardType.CROWN, "41.jpg", "", "/s_(158).mp3", "/s_(159).mp3", 41);
		c[41] = new CardSpec("Sacred Gong", CardType.CROWN, "42.jpg", "", "/s_(160).mp3", "/s_(161).mp3", 42);
		//CardType.WHOLEBODY
		c[42] = new CardSpec("Octave Jump", CardType.WHOLEBODY, "43.jpg", "", "/s_(162).mp3", "/s_(163).mp3", 43);
		c[43] = new CardSpec("Breath of Life", CardType.WHOLEBODY, "44.jpg", "", "/s_(165).mp3", "/s_(166).mp3", 44);
		c[44] = new CardSpec("Discord", CardType.WHOLEBODY, "45.jpg", "", "/s_(167).mp3", "/s_(168).mp3", 45);
		c[45] = new CardSpec("Out of Tune", CardType.WHOLEBODY, "46.jpg", "", "/s_(169).mp3", "/s_(170).mp3", 46);
		c[46] = new CardSpec("Orchestra", CardType.WHOLEBODY, "47.jpg", "", "/s_(171).mp3", "/s_(172).mp3", 47);
		c[47] = new CardSpec("Singing Bowl", CardType.WHOLEBODY, "48.jpg", "", "/s_(173).mp3", "/s_(174).mp3", 48);
		//ANGELS
		c[48] = new CardSpec("Crescendo", CardType.ANGEL, "49.jpg", "", "/s_(175).mp3", "/s_(176).mp3", 49);
		c[49] = new CardSpec("Dulcimer", CardType.ANGEL, "50.jpg", "", "/s_(178).mp3", "/s_(179).mp3", 50);
		c[50] = new CardSpec("Sanctus", CardType.ANGEL, "51.jpg", "", "/s_(181).mp3", "/s_(182).mp3", 51);
		c[51] = new CardSpec("Carillon", CardType.ANGEL, "52.jpg", "", "/s_(184).mp3", "/s_(185).mp3", 52);
		for(int i = 0; i < 52; i++){
			cards[i] = new Card(c[i]);
		}
	}
	
	public Card[] getCards() {
		return cards;
	}
	
	public Card getCard(int id){
		return cards[id];
	}

	public static AllCards getInstance() {
		return INSTANCE;
	}

	public Card getCurrentCard() {
		return currentCard;
	}
	public void setCurrentCard(Card currentCard) {
		this.currentCard = currentCard;
	}
}
