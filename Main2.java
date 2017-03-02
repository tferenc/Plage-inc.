import java.util.Scanner;

import game.DiseaseCardGame;
import player.Player;
import utility.Logger;

public class Main2 {

	static InitWindow GUIstarter = new InitWindow();
	static GameWindow GUIGame = new GameWindow();
	static Logger logger = new Logger();
	static DiseaseCardGame game = new DiseaseCardGame();

	public static void main(String[] args) {
		GUIstarter.open();		
	}
	
	public static void continues(){
		
		
		game.initializePlayers(logger);
		setUpplayerNames(game, logger);
		game.setStartingPlayer(logger);
		GUIstarter.close();
		
		GUIGame.setTable(game.getTable());
		GUIGame.open();
		
	}

	public static void setUpplayerNames(DiseaseCardGame game, Logger logger){
		Player[] players = game.getTable().getPlayers();
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < players.length; i++) {
			players[i].setName(GUIstarter.getPlayers()[i]);
		}
	}

}
