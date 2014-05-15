package com.sound.healing.cards;

import java.util.HashMap;

public class CardSpec {
	
	HashMap<Integer, Object> cardProperties;
	
	public CardSpec(HashMap<Integer, Object> cardProperties) {
		this.cardProperties = cardProperties;
	}
	
	public CardSpec(String name, CardType type, String image, String description, String sound1, String sound2, int id) {
		cardProperties = new HashMap<Integer,Object>();
		cardProperties.put(CardEnum.NAME.getEnumID(), name);
		cardProperties.put(CardEnum.TYPE.getEnumID(), type);
		cardProperties.put(CardEnum.IMAGE.getEnumID(), image);
		cardProperties.put(CardEnum.DESCRIPTION.getEnumID(), description);
		cardProperties.put(CardEnum.SOUND1.getEnumID(), sound1);
		cardProperties.put(CardEnum.SOUND2.getEnumID(), sound2);
		cardProperties.put(CardEnum.ID.getEnumID(), id);
	}

	public Object getCardProperty(int propertyId){
		return cardProperties.get(propertyId);
	}
	
	public HashMap<Integer, Object> getCardProperties() {
		return cardProperties;
	}
	
	public void setCardProperty(int propertyId, String affirmation){
		cardProperties.put(propertyId, affirmation);
		
		
	}
	
	
}
