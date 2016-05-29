package eg.edu.guc.yugioh.gui;

import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import eg.edu.guc.yugioh.cards.Card;

public class Oppgrave extends JButton implements MouseListener  {
	private ArrayList<GraveyardButtons> oppgrave;

	public Oppgrave() {
		

		oppgrave = new ArrayList<GraveyardButtons>();
		/*ArrayList<Card> grave = Card.getBoard().getOpponentPlayer().getField().getGraveyard();
		int s = grave.size();
		if(s!=0){
		for(int i=0; i<s; i++){
			Card h = Card.getBoard().getOpponentPlayer().getField().getGraveyard().get(i);
		    GraveyardButtons d = new GraveyardButtons(h.getName());
			d.setText(h.getName());
			d.addMouseListener(this);
			oppgrave.add(d);
			this.add(d);
		}
		}*/
	
		
	}
	public ArrayList<GraveyardButtons> getGrave2(){
		return oppgrave;
	}
	public void setGrave2(ArrayList<GraveyardButtons> activegrave){
		this.oppgrave = activegrave;
	}

	public Oppgrave(LayoutManager layout) {
		super();
		// TODO Auto-generated constructor stub
	}

	public Oppgrave(boolean isDoubleBuffered) {
		super();
		// TODO Auto-generated constructor stub
	}

	public Oppgrave(LayoutManager layout, boolean isDoubleBuffered) {
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
