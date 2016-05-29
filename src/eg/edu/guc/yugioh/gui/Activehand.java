package eg.edu.guc.yugioh.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;

public class Activehand extends JPanel implements MouseListener  {
	 ArrayList<JButton> activehand;

	public ArrayList<JButton> getActivehand() {
		return activehand;
	}
	public void setActivehand(ArrayList<JButton> activehand) {
		this.activehand = activehand;
	}
	public Activehand() {
		activehand = new ArrayList<JButton>();
		this.setLayout(new FlowLayout());
		
		this.setOpaque(false);
		ArrayList<Card> hand = Card.getBoard().getActivePlayer().getField().getHand();
		int s = hand.size();
		if(s!=0){
		for(int i=0; i<s; i++){
			Card h = Card.getBoard().getActivePlayer().getField().getHand().get(i);
			if(h instanceof MonsterCard){
				MonsterCard m = (MonsterCard) h;
				MonstersButtons mons = new MonstersButtons(m);
				mons.setSize(300, 440);
				//mons.setIcon(new ImageIcon(m.getName()+".png"));
				mons.setText(h.getName());
		     	mons.addMouseListener(this);
				activehand.add(mons);
				this.add(mons);
				}
			else {
				SpellCard s1 = (SpellCard) h;
				SpellsButtons spell = new SpellsButtons(s1);
				//spell.setIcon(new ImageIcon(s1.getName()+".png"));
				spell.setText(h.getName());
				spell.addMouseListener(this);
				activehand.add(spell);
				this.add(spell);
				
			}
		
		}
		}
	
	}
	public ArrayList<JButton> getHand(){
		return activehand;
	}
	public void setHand(ArrayList<JButton> activehand){
		this.activehand = activehand;
	}

	public Activehand(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public Activehand(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public Activehand(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(activehand!=null){
			
			
			for(int i =0; i<getHand().size();i++){
			if(e.getSource()==getHand().get(i)){
				addMouseListener(this);
				ThirdFrame buttonFrame= new ThirdFrame((JButton) e.getSource());
				buttonFrame.setVisible(true);
				buttonFrame.validate();
			}
		}
		
	}}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(activehand!=null){
			
			for(int i =0; i < MyFrame.getBoard().getActivePlayer().getField().getHand().size();i++){
				
				if (e.getSource()== this.activehand.get(i)){
					Card c= MyFrame.getBoard().getActivePlayer().getField().getHand().get(i);
					JLabel cardInfo= new JLabel(getAllinfo(c));
					cardInfo.setText(getAllinfo(c));
					cardInfo.addMouseListener(this);
					cardInfo.setBounds(10,60,150,150);
					cardInfo.setVisible(true);
					SecondFrame.setCardInfo(cardInfo);
				}
			}
			
		
	}
	}
	public void refreshHand1(Player p, Activehand h){//ghayart fiha hagat bas lazem neghayar f kol el updates 
		activehand.clear();
		this.removeAll();
		//System.out.print("joo");
		
		h.repaint();
		h.revalidate();
		//activehand = new ArrayList<Buttons>();
		
		
		ArrayList<Card> hand = p.getField().getHand();
		int s = hand.size();
		System.out.println(s);
		if(s!=0){
		for(int i=0; i<s; i++){
			Card card = hand.get(i);
			if(card instanceof MonsterCard){
				MonsterCard m = (MonsterCard) card;
				MonstersButtons mons = new MonstersButtons(m);
				mons.setText(card.getName());
		     	mons.addMouseListener(this);
				activehand.add(mons);//arraylist
				this.add(mons);
				
			
				}
			else {
				SpellCard s1 = (SpellCard) card;
				SpellsButtons spell = new SpellsButtons(s1);
				spell.setText(card.getName());
				spell.addMouseListener(this);
				activehand.add(spell);
				this.add(spell);
				
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
		}
			this.repaint();
			this.revalidate();
		  }
	
	}
	private String getAllinfo(Card card) {
		if(card instanceof SpellCard){
			return "<html>"+ card.getName()+"</html>";
		}
		else{
			MonsterCard mc= (MonsterCard)card;
			return "<html>"+ mc.getName()+"<br> "+ mc.getAttackPoints() +
					"<br> "+ mc.getDefensePoints() + "<br>"+ mc.getLevel()+"</html>";
		}
	
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	/*public void add(Card h1) {
		
		if (h1 instanceof MonsterCard){
			MonsterCard m1 = (MonsterCard) h1;
			MonstersButtons m = new MonstersButtons(m1);
			m.setText(m1.getName());
			m.addMouseListener(this);
			activehand.add(m);
			
		}
		else {
			SpellCard m1 = (SpellCard) h1;
			SpellsButtons m = new SpellsButtons(m1);
			m.setText(m1.getName());
			m.addMouseListener(this);
			activehand.add(m);
			
		}
		
		
	}*/

}
