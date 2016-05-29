package eg.edu.guc.yugioh.gui;

import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;

public class Oppdeck extends JButton implements MouseListener  {

	private DeckButtons oppdeck;
    private int size1;
	public Oppdeck() {
		oppdeck = new DeckButtons();
		size1= Card.getBoard().getOpponentPlayer().getField().getDeck().getDeck().size();
		/*ArrayList<Card> deck = Card.getBoard().getOpponentPlayer().getField().getDeck().getDeck();
		size = deck.size();
		String sizeStr=""+size;
		this.setName(sizeStr);
		*/
	
	}
	public  void refreshOppDeck(Player p, Oppdeck deck){
		//((List<Card>) oppdeck).clear();
		this.removeAll();
		
		
		deck.repaint();
		deck.revalidate();
		
		int size= p.getField().getDeck().getDeck().size();
		oppdeck.setText("Opp deck"+ size );
		
		this.revalidate();
		
	
	}
	
	
	public int getSize1() {
		return size1;
	}


	public void setSize1(int size1) {
		this.size1 = size1;
	}


	public DeckButtons getDeck2(){
		return oppdeck;
	}
	public void setDeck2(ArrayList<DeckButtons> activeDeck){
		this.oppdeck = oppdeck;
	}


	public Oppdeck(LayoutManager layout) {
		super();
		// TODO Auto-generated constructor stub
	}

	public Oppdeck(boolean isDoubleBuffered) {
		super();
		// TODO Auto-generated constructor stub
	}

	public Oppdeck(LayoutManager layout, boolean isDoubleBuffered) {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
