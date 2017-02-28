package model;

/**
 * Created by tamasferenc on 2017.02.28..
 */
public abstract class Table
{
    protected Player[] players;
    protected Deck baseDeck;
    protected Player currentPlayer;
    protected int rounds;
    protected CardComperator comperator;

    public abstract void distributeCards(Player[] player);
    public abstract Player getCurrentPlayer();
    public abstract int getRounds();
    public abstract String toString();
}
