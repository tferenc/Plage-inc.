import java.util.Scanner;

import game.DiseaseCardGame;
import game.GameTable;
import player.Player;
import utility.CardComparator;
import utility.Logger;

public class Main {

	public static void main(String[] args) {
		Logger logger = new Logger();
		DiseaseCardGame game = new DiseaseCardGame();
		Player[] players = game.getTable().getPlayers();
		GameTable table = game.getTable();
		CardComparator cComp = new CardComparator();

		game.initializePlayers(logger);
		setUpplayerNames(game, logger);
		game.setStartingPlayer(logger);
		game.printDealer(logger);

		// while(players[0].getHand().getSize() > 0 ||
		// players[1].getHand().getSize() > 0){
		//
		// }

		playGame(game, logger, table, cComp);

	}

	public static void setUpplayerNames(DiseaseCardGame game, Logger logger) {
		Player[] players = game.getTable().getPlayers();
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < players.length; i++) {
			game.setPlayerName(players[i], i, logger, sc);
		}
	}

	public static void playGame(DiseaseCardGame game, Logger logger, GameTable table, CardComparator cc) {
		Player winner = null;
		logger.print("Jelenlegi játékos: " + table.getCurrentPlayer().getName());
		logger.print(table.getCurrentPlayer().getHand().getTopCard().toString());
		winner = cc.compare(table.getCurrentPlayer(), table.getOtherPlayer());
		logger.print(table.getOtherPlayer().getName() + ":");
		logger.print(table.getOtherPlayer().getHand().getTopCard().toString());
		logger.print("A kör nyertesese: " + winner.getName());

		System.out.println("----------------------------------");
		logger.print(("\n" + table.getCurrentPlayer().getName()));
		logger.print(table.getCurrentPlayer().getHand().getTopCard().toString());
		System.out.println((table.getCurrentPlayer().getHand().getTopCard().getLethality()));
		System.out.println((table.getCurrentPlayer().getHand().getTopCard().getVictims()));
		System.out.println((table.getCurrentPlayer().getHand().getTopCard().getIncubationTime()));
		
		logger.print("\n" + table.getOtherPlayer().getName());
		logger.print(table.getOtherPlayer().getHand().getTopCard().toString());
		System.out.println((table.getOtherPlayer().getHand().getTopCard().getLethality()));
		System.out.println((table.getOtherPlayer().getHand().getTopCard().getVictims()));
		System.out.println((table.getOtherPlayer().getHand().getTopCard().getIncubationTime()));
		
		System.out.println(table.getCurrentPlayer().getHand().getTopCard().getVictims() > table.getOtherPlayer().getHand().getTopCard().getVictims() );
	}

}
