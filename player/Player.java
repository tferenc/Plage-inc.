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
		switch(chooseStat()){
		case "lethality":{
			Integer currentPlayerStat = getHand().getTopCard().getLethality();
			Integer otherPlayerStat = otherPlayer.getHand().getTopCard().getLethality();
			
			if(currentPlayerStat.equals(otherPlayerStat))
				return 0;
			else if(currentPlayerStat > otherPlayerStat)
				return 1;
			else
				return -1;
		}	
		case "victims":{
			Integer currentPlayerStat = getHand().getTopCard().getVictims();
			Integer otherPlayerStat = otherPlayer.getHand().getTopCard().getVictims();
			
			if(currentPlayerStat.equals(otherPlayerStat))
				return 0;
			else if(currentPlayerStat > otherPlayerStat)
				return 1;
			else
				return -1;
		}
		case "incubationTime":{
			Integer currentPlayerStat = getHand().getTopCard().getIncubationTime();
			Integer otherPlayerStat = otherPlayer.getHand().getTopCard().getIncubationTime();
			
			if(currentPlayerStat.equals(otherPlayerStat))
				return 0;
			else if(currentPlayerStat > otherPlayerStat)
				return 1;
			else
				return -1;
		}	
		}
	}
}
