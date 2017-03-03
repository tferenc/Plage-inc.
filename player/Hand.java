package player;

import game.DiseaseCard;
import model.Deck;

public class Hand {
	private Deck hand;

	public Hand() {
		hand = new Deck();
	}

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

	public void removeCard(DiseaseCard card) {
		hand.getCards().remove(card);
	}
	
	public int getSize(){
		return hand.getCards().size();
	}

	public void putFirstCardToBack() {
		DiseaseCard temp = null;
		temp = getTopCard();
		removeCard(getTopCard());
		addCard(temp);
	}
}
