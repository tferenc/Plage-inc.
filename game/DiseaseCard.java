package game;

import model.Card;

public class DiseaseCard extends Card {
	
	private int lethality;
	private double victims;
	private short incubationTime;
	
	public DiseaseCard(String name, 
						int lethality, 
						double victims, 
						short incubationTime) {
		
		this.name = name;
		this.lethality = lethality;
		this.victims = victims;
		this.incubationTime = incubationTime;
	}
	
	public int getLethality() {
		return lethality;
	}
	
	public double getVictims() {
		return victims;
	}
	
	public short getIncubationTime() {
		return incubationTime;
	}

	@Override
	public String toString() {
		return name +" - [Halálozási arány: " + lethality + "%" +
				" Áldozatok: " + victims + "/100k" + 
				" Lappangás: " + incubationTime + "nap";
	}
	
	

	
	
	

}
