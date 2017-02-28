package game;

import model.Table;
import player.Hand;
import player.Player;

/**
 * Created by tamasferenc on 2017.02.28..
 */
public class GameTable extends Table
{

    @Override
    public void distributeCards(Player[] player, Hand hand)
    {
        while(baseDeck.getSize() != 0)
        {
            player[0].getHand().addCard(baseDeck.getCards().get(0));
            baseDeck.removeCard(0);
            player[1].getHand().addCard(baseDeck.getCards().get(0));
            baseDeck.removeCard(0);
        }
    }

    @Override
    public Player getCurrentPlayer()
    {
        return  currentPlayer;
    }

    @Override
    public int getRounds()
    {
        return rounds;
    }

    @Override
    public String toString()
    {
        return null;
    }
}
