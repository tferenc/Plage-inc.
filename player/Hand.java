package player;

import game.DiseaseCard;
import model.Card;
import model.Deck;

public class Hand {
	private Deck hand;
	private boolean isEmpty;

	public boolean isEmpty() {
		if (hand.getCards().size() > 0) {
			return false;
		} else {
			return true;
		}
	}

	public void addCard(DiseaseCard card) {
		hand.getCards().add(card);
	}

	public Deck getHand() {
		return hand;
	}

	public DiseaseCard getTopCard() {
		return hand.getCards().get(0);
	}
	
	public void removeCard(Card card)
	{	
		for (int j = 0; j < hand.getSize(); j++) {
			if (hand.getCards().toArray()[j] == card) {
				hand.removeCard(j);
			}		
		}
		
	}
}
