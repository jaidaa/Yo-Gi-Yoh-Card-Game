package eg.edu.guc.yugioh.gui;

import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;

public class Opphand extends JPanel implements MouseListener {
	private ArrayList<JButton> opphand;
	public Opphand() {
		opphand = new ArrayList<JButton>();
		this.setOpaque(false);
		ArrayList<Card> hand = Card.getBoard().getOpponentPlayer().getField().getHand();
		int s = hand.size();
		if(s!=0){
		for(int i=0; i<s; i++){
		
			Card h = Card.getBoard().getOpponentPlayer().getField().getHand().get(i);
			if(h instanceof MonsterCard){
				MonsterCard m = (MonsterCard) h;
				MonstersButtons mons = new MonstersButtons(m);
				//mons.setText(h.getName());
				mons.addMouseListener(this);
				opphand.add(mons);
				this.add(mons);
				}
			else {
				SpellCard s1 = (SpellCard) h;
				SpellsButtons spell = new SpellsButtons(s1);
				//spell.setText(h.getName());
				spell.addMouseListener(this);
				opphand.add(spell);
				this.add(spell);
				
			}
		
		}
		}
	}
	
	public void refreshHand2(Player p, Opphand h){//ghayart fiha hagat bas lazem neghayar f kol el updates 
		h.repaint();
		h.removeAll();
		
		h.opphand.clear();
		
		opphand = new ArrayList<JButton>();
		ArrayList<Card> hand = p.getField().getHand();
		int s = hand.size();
		if(s!=0){
		for(int i=0; i<s; i++){
		
			Card card = Card.getBoard().getOpponentPlayer().getField().getHand().get(i);
			if(card instanceof MonsterCard){
				MonsterCard m = (MonsterCard) card;
				MonstersButtons mons = new MonstersButtons(m);
				//mons.setText(h.getName());
				mons.addMouseListener(this);
				opphand.add(mons);
				this.add(mons);
				}
			else {
				SpellCard s1 = (SpellCard) card;
				SpellsButtons spell = new SpellsButtons(s1);
				//spell.setText(h.getName());
				spell.addMouseListener(this);
				opphand.add(spell);
				this.add(spell);
				
			}
		
		}
		}
		SecondFrame.activedeck.setText("Active deck "+ MyFrame.getBoard().getActivePlayer().getField().getDeck().getDeck().size());
		SecondFrame.oppdeck.setText("Opp deck : "+ MyFrame.getBoard().getOpponentPlayer().getField().getDeck().getDeck().size());
	
		int graveSize= MyFrame.getBoard().getActivePlayer().getField().getGraveyard().size();
		if(graveSize!=0)
		SecondFrame.activegraveyard.setText("Active grav:" + MyFrame.getBoard().getActivePlayer().getField().getGraveyard().get(graveSize-1).getName());
		
		int graveSize2= MyFrame.getBoard().getOpponentPlayer().getField().getGraveyard().size();
		if(graveSize2!=0)
		SecondFrame.oppgraveyard.setText("Opp grav:" + MyFrame.getBoard().getOpponentPlayer().getField().getGraveyard().get(graveSize2-1).getName());
		
		SecondFrame.lf1.setText("Player's LifePoints:"+ MyFrame.getBoard().getActivePlayer().getLifePoints());
		SecondFrame.lf2.setText("Player's LifePoints:"+ MyFrame.getBoard().getOpponentPlayer().getLifePoints());
		
		SecondFrame.phase.setText("Current Phase is: "+ MyFrame.getBoard().getActivePlayer().getField().getPhase());
		
		if(MyFrame.getBoard().getWinner()!=null){
			SecondFrame.gameOver = new GameOver();
			SecondFrame.gameOver.setVisible(true);
			SecondFrame.gameOver.validate();
		}this.repaint();
		this.revalidate();
		  }

	public ArrayList<JButton> getHand2(){
		return opphand;
	}
	public void setHand2(ArrayList<JButton> activehand){
		this.opphand = opphand;
	}

	public Opphand(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public Opphand(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public Opphand(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(opphand!=null){
			if(MyFrame.getBoard().getActivePlayer().equals( MyFrame.getP2()))
			for(int i=0; i<getHand2().size(); i++){
				if(e.getSource()==getHand2().get(i)){
					addMouseListener(this);
					ThirdFrame buttonFrame= new ThirdFrame(getHand2().get(i));
					buttonFrame.setVisible(true);
					buttonFrame.validate();
				}
			}
		
		}
		}
		
	

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	/*if(opphand!=null){
		for(int i =0; i < opphand.size();i++){
			if(opphand.get(i)!=null){
			if (e.getSource()==opphand.get(i)){
				Card c= MyFrame.board.getOpponentPlayer().getField().getHand().get(i);
				JLabel cardInfo= new JLabel(getAllinfo(c));
				cardInfo.setText(getAllinfo(c));
				cardInfo.addMouseListener(this);
				cardInfo.setBounds(10,60,150,150);
				cardInfo.setVisible(true);
				SecondFrame.setCardInfo(cardInfo);
			}
		}
		}
	}*/}
		
	private String getAllinfo(Card card) {
		if(card instanceof SpellCard){
			return "<html>"+ card.getName()+"</html>";
		}
		else{
			MonsterCard mc= (MonsterCard)card;
			return "<html>"+ card.getName()+"<br> "+ mc.getAttackPoints() +
					"<br> "+ mc.getDefensePoints() + "<br>"+ mc.getLevel()+"</html>";
		}
	
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void add (Card h1){
		JButton b = new JButton();
		if (h1 instanceof MonsterCard){
			MonsterCard m1 = (MonsterCard) h1;
			MonstersButtons m = new MonstersButtons(m1);
			m.setText(m1.getName());
			m.addMouseListener(this);
			opphand.add(m);
			
		}
		else {
			SpellCard m1 = (SpellCard) h1;
			SpellsButtons m = new SpellsButtons(m1);
			m.setText(m1.getName());
			m.addMouseListener(this);
			opphand.add(m);
			
		}
	}

}
