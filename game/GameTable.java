/**
 * Created by tamasferenc on 2017.02.28..
 */

package game;

import java.util.Random;
import model.Table;
import player.Hand;
import player.Player;
public class GameTable extends Table
{

    @Override
    public void distributeCards(Player[] player, Hand hand)
    {
        Random rand = new Random();
        while(baseDeck.getSize() != 0)
        {
            int n = rand.nextInt(baseDeck.getSize());
            player[0].getHand().addCard(baseDeck.getCards().get(n));
            baseDeck.removeCard(n);

            n = rand.nextInt(baseDeck.getSize());
            player[1].getHand().addCard(baseDeck.getCards().get(n));
            baseDeck.removeCard(n);
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
