package eg.edu.guc.yugioh.gui;

import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;

public class Activedeck extends JButton implements MouseListener  {
	private DeckButtons activedeck;
    private int size1;

	public int getSize1() {
		return size1;
	}


	public void setSize1(int size1) {
		this.size1 = size1;
	}


	public Activedeck() {
		activedeck = new  DeckButtons ();
		activedeck.setIcon(new ImageIcon("Card Back.png"));
		this.setOpaque(false);
		size1= Card.getBoard().getActivePlayer().getField().getDeck().getDeck().size();
		activedeck.setText("active deck"+ size1 );
		/*ArrayList<Card> deck = Card.getBoard().getActivePlayer().getField().getDeck().getDeck();
		int size = deck.size();
		String sizeStr=""+size;
		this.setName(sizeStr);*/
	
	
		
	}
	
	public  void refreshActiveDeck(Player p, Activedeck deck){
		//((List<Card>) activedeck).clear();
		this.removeAll();
		
		
		deck.repaint();
		deck.revalidate();
		
		int size= p.getField().getDeck().getDeck().size();
		activedeck.setText("active deck"+ size1 );
	
		this.revalidate();
	
	}
	
	

	public DeckButtons getActivedeck() {
		return activedeck;
	}


	public void setActivedeck(DeckButtons activedeck) {
		this.activedeck = activedeck;
	}


	public Activedeck(LayoutManager layout) {
		super();
		// TODO Auto-generated constructor stub
	}

	public Activedeck(boolean isDoubleBuffered) {
		super();
		// TODO Auto-generated constructor stub
	}

	public Activedeck(LayoutManager layout, boolean isDoubleBuffered) {
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
