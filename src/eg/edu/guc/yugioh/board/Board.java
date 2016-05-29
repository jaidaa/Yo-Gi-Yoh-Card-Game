package eg.edu.guc.yugioh.board;

import java.io.IOException;
import java.util.ArrayList;

import eg.edu.guc.yugioh.board.player.Deck;
import eg.edu.guc.yugioh.board.player.Field;
import eg.edu.guc.yugioh.board.player.Phase;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;

public class Board {
	private Player activePlayer;
	private Player opponentPlayer;
	private Player winner = null;
	private boolean game;
	
	public boolean isGame() {
		return game;
	}
	public void setGame(boolean game) {
		this.game = game;
	}
	public Board (){
		Card.setBoard(this);
		game = false;
	}
	public void whoStarts(Player p1, Player p2) throws IOException{
		int whostarts = (int) (Math.random()*2);
		if (whostarts == 0){
			activePlayer = p1;
			opponentPlayer = p2;
		}
		else{
			activePlayer = p2;
			opponentPlayer = p1;
		}
		}
	public void startGame(Player p1, Player p2) throws IOException{

		
		whoStarts(p1,p2);
		activePlayer.getField().addNCardsToHand(5);
		opponentPlayer.getField().addNCardsToHand(5);
		activePlayer.getField().addCardToHand();
				
		
	}
	public void nextPlayer() {
		if (winner==null){
	
	Player temp = activePlayer;
		activePlayer = opponentPlayer;
		opponentPlayer = temp;
		getActivePlayer().getField().addCardToHand();
		activePlayer.getField().setPhase(Phase.MAIN1);
		
		} 
	}
	public Player getActivePlayer() {
		return activePlayer;
	}
	public void setActivePlayer(Player activePlayer) {
	    this.activePlayer = activePlayer;
	}
	public Player getOpponentPlayer() {
		return opponentPlayer;
	}
	public void setOpponentPlayer(Player opponentPlayer) {
		this.opponentPlayer = opponentPlayer;
	}
	public Player getWinner() {
		return winner;
	}
	public void setWinner(Player winner) {
	this.winner = winner;
	}
	
	
	

	
}
