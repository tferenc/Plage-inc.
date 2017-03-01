package game;

import java.util.Random;
import java.util.Scanner;

import player.Player;
import utility.Logger;

public class DiseaseCardGame {

	private GameTable gameTable = new GameTable();
	private Logger logger;
	private Scanner sc = new Scanner(System.in);

	public void initializePlayers() {
		logger.print("Initializing players...");
		gameTable.distributeCards();
	}

	public void setPlayerName(Player p, int playerNum) {
		logger.print("Please enter a name for the " + playerNum + ". player: \n");
		p.setName(sc.nextLine());
		sc.close();
	}

	public void printDealer() {

		Player[] players = gameTable.getPlayers();
		Player currentPlayer = gameTable.getCurrentPlayer();

		if (currentPlayer.equals(players[0])) {
			logger.print("The dealer will be " + gameTable.getPlayers()[1].getName() + ".");
		} else {
			logger.print("The dealer will be " + gameTable.getPlayers()[0].getName() + ".");
		}
	}

	public void setStartingPlayer() {
		Random r = new Random();
		r.setSeed(System.currentTimeMillis());
		int index = r.nextInt(2);

		gameTable.setCurrentPlayer(index);
		logger.print(gameTable.getCurrentPlayer().getName() + " will start.");
	}

}
