package model;
import java.util.Collection;
import java.util.Vector;

import game.DiseaseCard;
import utility.CSVReader;

public class Deck {

	protected int size;
	protected Collection<DiseaseCard> cards = new Vector<DiseaseCard>();
	private CSVReader reader;

	public Collection addCards() {
		return reader.readlnCards();
	}

	public int getSize() {
		return cards.size();
	}

	public void removeCard(int index) {
		cards.remove(cards.toArray()[index]);
	}
}
