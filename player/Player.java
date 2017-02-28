package player;

import java.util.Scanner;

public class Player {
	
	private Hand hand;
	private String name;
	
	public Player(Hand hand, String name) {
		this.hand = hand;
		this.name = name;
	}

	public Hand getHand(){
		return hand;
	}
	
	public void giveCard(DiseaseCard card, Player target){
		
	}
	
	public String chooseStat(){
		Scanner sc = new Scanner(System.in);
	}
	
	public String toString(){
		return null;
	}
}
