package player;

import java.util.Scanner;

import game.DiseaseCard;

public class Player implements Comparable<Player>{
	
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
		String choosedStat = null;
		
		Scanner sc = new Scanner(System.in);
		int choosedStatID = sc.nextInt();
		sc.close();
		
		switch(choosedStatID){
		case 1:
			choosedStat = "lethality";
		case 2:
			choosedStat = "victims";
		case 3:
			choosedStat = "incubationTime";
		}
		
		return choosedStat;
	}
	
	public String toString(){
		return "Name: " + name + "\n, Current card: " + hand.toString();
	}

	@Override
	public int compareTo(Player otherPlayer) {
		return 0;
	}
}
