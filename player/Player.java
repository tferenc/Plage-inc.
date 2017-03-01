package player;

import java.util.Scanner;

import game.DiseaseCard;
import utility.Logger;

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
		Logger logger = new Logger();
		String choosedStat = null;
		
		Scanner sc = new Scanner(System.in);
		logger.print("Choose your stat! \n Lethality(1) Victims(2) IncubationTime(3)");
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
			double currentPlayerStat = getHand().getTopCard().getVictims();
			double otherPlayerStat = otherPlayer.getHand().getTopCard().getVictims();
			
			if(currentPlayerStat == otherPlayerStat)
				return 0;
			else if(currentPlayerStat > otherPlayerStat)
				return 1;
			else
				return -1;
		}
		case "incubationTime":{
			short currentPlayerStat = getHand().getTopCard().getIncubationTime();
			short otherPlayerStat = otherPlayer.getHand().getTopCard().getIncubationTime();
			
			if(currentPlayerStat == otherPlayerStat)
				return 0;
			else if(currentPlayerStat > otherPlayerStat)
				return 1;
			else
				return -1;
		}	
		}
		return 0;
	}
}
