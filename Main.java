import java.util.Scanner;

import game.DiseaseCardGame;
import player.Player;
import utility.Logger;

public class Main {

	

	public static void main(String[] args) {
		Logger logger = new Logger();
		DiseaseCardGame game = new DiseaseCardGame();
		
		game.initializePlayers(logger);
		setUpplayerNames(game, logger);
		game.setStartingPlayer(logger);
		game.printDealer(logger);
		
		logger.print(game.getTable().getPlayers()[0].getHand().getTopCard().toString());
	}

	public static void setUpplayerNames(DiseaseCardGame game, Logger logger){
		Player[] players = game.getTable().getPlayers();
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < players.length; i++) {
			game.setPlayerName(players[i], i, logger, sc);
		}
	}

}
