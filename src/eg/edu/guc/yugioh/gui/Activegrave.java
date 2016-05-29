package eg.edu.guc.yugioh.gui;

import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import eg.edu.guc.yugioh.cards.Card;

public class Activegrave extends JButton implements MouseListener {
	private int size;

	public Activegrave() {
		
	
		
		ArrayList<Card> grave = Card.getBoard().getActivePlayer().getField().getGraveyard();
		size = grave.size();
		String sizeStr=""+size;
		this.setName(sizeStr);
		
	}
	
	public Activegrave(LayoutManager layout) {
		super();
		// TODO Auto-generated constructor stub
	}

	public Activegrave(boolean isDoubleBuffered) {
		super();
		// TODO Auto-generated constructor stub
	}

	public Activegrave(LayoutManager layout, boolean isDoubleBuffered) {
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
