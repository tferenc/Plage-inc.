/**
 * Created by tamasferenc on 2017.02.28..
 */
package game;

import java.util.Random;

import model.Deck;
import model.Table;
import player.Hand;
import player.Player;
public class GameTable extends Table
{
    public GameTable() {
        players = new Player[2];
        players[0] = new Player(new Hand(), "player1");
        players[1] = new Player(new Hand(), "player2");
    }

    @Override
    public void distributeCards()
    {
        baseDeck = new Deck();
        Random rand = new Random();
        while(baseDeck.getSize() != 0)
        {
            rand.setSeed(System.currentTimeMillis());
            int n = rand.nextInt(baseDeck.getSize());
            players[0].getHand().addCard(baseDeck.getCards().get(n));
            baseDeck.removeCard(n);

            n = rand.nextInt(baseDeck.getSize());
            players[1].getHand().addCard(baseDeck.getCards().get(n));
            baseDeck.removeCard(n);
        }
    }
    
    public Player[] getPlayers(){
    	return players;
    }
    
    @Override
    public Player getCurrentPlayer()
    {
        return  currentPlayer;
    }

    public void setCurrentPlayer(int index)
    {
        currentPlayer = players[index];
    }

    @Override
    public int getRounds()
    {
        return rounds;
    }

    @Override
    public String toString()
    {
        return ("Round: " + getRounds() + "\nCurrent player: " + getCurrentPlayer().toString());
    }
}
