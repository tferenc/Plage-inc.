package player;

import java.util.Scanner;

import game.DiseaseCard;

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
		target.addCard(card);
		hand.removeCard(card);
	}
	
	public String chooseStat(){
		Scanner sc = new Scanner(System.in);
		String choosedStat = sc.nextLine();
		sc.close();
		
		return choosedStat;
	}
	
	public String toString(){
		return "Name: " + name + "\n, Current card: " + hand.toString();
	}
}
