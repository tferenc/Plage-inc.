package game;

import java.util.Random;
import java.util.Scanner;

import player.Player;
import utility.Logger;

public class DiseaseCardGame {

	private GameTable gameTable = new GameTable();

	public void initializePlayers(Logger logger) {
		logger.print("Initializing players...");
		gameTable.distributeCards();
	}

	public void setPlayerName(Player p, int playerNum, Logger logger, Scanner sc) {
		logger.print("Please enter a name for the " + (playerNum + 1) + ". player: \n");
		p.setName(sc.nextLine());
	}

	public void printDealer(Logger logger) {

		Player[] players = gameTable.getPlayers();
		Player currentPlayer = gameTable.getCurrentPlayer();

		if (currentPlayer.equals(players[0])) {
			logger.print("The dealer will be " + gameTable.getPlayers()[1].getName() + ".");
		} else {
			logger.print("The dealer will be " + gameTable.getPlayers()[0].getName() + ".");
		}
	}
	
	public GameTable getTable(){
		return gameTable;
	}

	public void setStartingPlayer(Logger logger) {
		Random r = new Random();
		r.setSeed(System.currentTimeMillis());
		int index = r.nextInt(2);

		gameTable.setCurrentPlayer(index);
		logger.print(gameTable.getCurrentPlayer().getName() + " will start.");
	}

}
