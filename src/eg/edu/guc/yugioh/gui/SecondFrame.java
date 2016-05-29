package eg.edu.guc.yugioh.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

//import javafx.scene.layout.Border;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;



public class SecondFrame extends JFrame implements MouseListener {
// el attribues eli htb2a 3l field
	static  JButton activedeck;
	static  JButton oppdeck;
	static  JButton activegraveyard;
	 static  JButton oppgraveyard;
     static PanelofCards field1;
	static  OppPanelofCard field2;
	 static  Activehand hand1;
	 static Opphand hand2;
	 static JLabel turn;
	 static JLabel phase;
	private JLabel name1;
	private JLabel name2;
	static JLabel lf1;
	static JLabel lf2;
	JButton endT;
	JButton endP;
	static JLabel cardInfo;
	JLabel background;
	static GameOver gameOver;

	
	
	public SecondFrame() {
		super();
	//	setBounds(0,0,1300,1300);
		setBounds(10,10,1000,700);
		 this.setTitle("Started");
		this.setLayout(null);
		this.setVisible(true);
		getContentPane().setBackground(Color.white);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		cardInfo=new JLabel();
		cardInfo.setBackground(Color.black);
		cardInfo.setForeground(Color.RED);
	
		cardInfo.setBounds(10,80,150,150);
		cardInfo.setVisible(true);
		cardInfo.addMouseListener(this);
		add(cardInfo);
		

		endT= new JButton("End Turn");
		
		endT.setBackground(Color.black);
		endT.setForeground(Color.RED);
	
		endT.setBounds(10,10,150,20);
		endT.addMouseListener(this);
		add(endT);
		
		endP= new JButton("End Phase");
		endP.setOpaque(false);
		endP.setBackground(Color.black);
		endP.setForeground(Color.RED);
	
		endP.addMouseListener(this);
		endP.setOpaque(false);
		endP.setBounds(10,30,150,20);
		add(endP);
		
		field1= new PanelofCards();
		field1.setBounds(270,130,500,150);
		field1.addMouseListener(this);
		add(field1);
		
		
		/*panelCards = new CardsPanel();
		panelCards.setBounds(270, 130, 500, 150);
		panelCards.addMouseListener(this);
		add(panelCards);
		*/
		//setHand1(new Activehand());
		
		hand1= new Activehand();
		hand1.setBounds(260,30, 500, 150);
		hand1.addMouseListener(this);
		add(hand1);
		
		hand2 = new Opphand();
		hand2.setBounds(270, 550, 500, 150);
		hand2.addMouseListener(this);
		add(hand2);
		
		field2= new OppPanelofCard();
		
		field2.setBounds(270, 400, 500, 150);
		field2.addMouseListener(this);
		add(field2);
		/*panelCards2 = new CardsPanel();
		panelCards2.setBounds(270, 400, 500, 150);
		panelCards2.addMouseListener(this);
		add(panelCards2);
	*/

		activedeck= new Activedeck();
		activedeck.setText("ActiveDeck "+ MyFrame.getBoard().getActivePlayer().getField().getDeck().getDeck().size());
		activedeck.setBounds(130, 205, 115, 75);
        activedeck.addMouseListener(this);
		add(activedeck);
		
		oppdeck= new Oppdeck();
		oppdeck.setText("OppDeck "+ MyFrame.getBoard().getOpponentPlayer().getField().getDeck().getDeck().size());
		oppdeck.setBounds(130, 480, 115, 75);
		oppdeck.addMouseListener(this);
		add(oppdeck);
		
		activegraveyard= new JButton("ActiveGraveyard");
	    activegraveyard.setBounds(130, 130, 115, 75);
	    activegraveyard.addMouseListener(this);
		add(activegraveyard);
		
		
		oppgraveyard= new JButton("OppGraveyard");
		oppgraveyard.setBounds(130, 405, 115, 75);
		oppgraveyard.addMouseListener(this);
		add(oppgraveyard);
		
	    this.setTitle(MyFrame.getBoard().getActivePlayer().getName()+"'s turn");
		/*turn= new JLabel("Your Turn: "+ Card.getBoard().getActivePlayer().getName());
		System.out.println(Card.getBoard().getOpponentPlayer().getName()+"sss");
		turn.setBounds(10,40, 150, 100);
		turn.addMouseListener(this);
		this.validate();
		this.repaint(); 
		add(turn);*/
		
		phase= new JLabel("Current Phase is: "+ MyFrame.getBoard().getActivePlayer().getField().getPhase());
		phase.setBackground(Color.black);
		phase.setForeground(Color.RED);
		phase.setBounds(10,60, 150, 100);
		phase.addMouseListener(this);
		add(phase);
		
		name1= new JLabel("Player 1 name:"+ MyFrame.text1.getText());
		name1.setBackground(Color.black);
		name1.setForeground(Color.RED);
		name1.setBounds(780,29, 500, 500);
		name1.addMouseListener(this);
		add(name1);
	
		name2= new JLabel("Player 2 name:"+ MyFrame.text2.getText());
		name2.setBackground(Color.black);
		name2.setForeground(Color.RED);
		name2.setBounds(780,50, 500, 500);
		name2.addMouseListener(this);
		add(name2);
		
		lf1= new JLabel("Player 2 LifePoints:"+ MyFrame.getBoard().getActivePlayer().getLifePoints());
		lf1.setBackground(Color.black);
		lf1.setForeground(Color.RED);
		lf1.setBounds(780,45, 150, 100);
		add(lf1);
		
		lf2= new JLabel("Player 1 LifePoints:"+ MyFrame.getBoard().getOpponentPlayer().getLifePoints());
		lf2.setBackground(Color.black);
		lf2.setForeground(Color.RED);
		lf2.setBounds(780,516, 150, 100);
		add(lf2);
		
		background = new JLabel();
		background.setBounds(0,0,1200,675);
		background.setLayout(null);
		background.setIcon(new ImageIcon("back2.jpg"));
		//background.setOpaque(true);
		getContentPane().add(background);

	/*	this.addMouseListener(panelCards);
		this.addMouseListener(panelCards2);
		this.addMouseListener(activedeck);
		this.addMouseListener(hand1);
		this.addMouseListener(hand2);
		this.addMouseListener(oppdeck);
		*/
		this.validate();
		this.repaint(); 

	}

	public JLabel getCardInfo() {
		return cardInfo;
	}

	public static  void setCardInfo(JLabel cardf) {
	cardInfo.setText(cardf.getText());

	}

	@Override
	public void mouseClicked(MouseEvent e) {
			}
		


	
  

	
	public void setOppdeck(Oppdeck oppdeck) {
		this.oppdeck = oppdeck;
	}

	public JButton getActivegraveyard() {
		return activegraveyard;
	}

	public void setActivegraveyard(JButton activegraveyard) {
		this.activegraveyard = activegraveyard;
	}

	public JButton getOppgraveyard() {
		return oppgraveyard;
	}

	public void setOppgraveyard(JButton oppgraveyard) {
		this.oppgraveyard = oppgraveyard;
	}

	
	
	public  Opphand getHand2() {
		return hand2;
	}

	//public  void setHand2(Opphand hand2) {
		//SecondFrame.hand2 = hand2;
	//}

	public static JLabel getTurn() {
		return turn;
	}

	public static void setTurn(JLabel turn) {
		SecondFrame.turn = turn;
	}

	public static JLabel getPhase() {
		return phase;
	}

	public static void setPhase(JLabel phase) {
		SecondFrame.phase = phase;
	}

	public JLabel getName1() {
		return name1;
	}

	public void setName1(JLabel name1) {
		this.name1 = name1;
	}

	public JLabel getName2() {
		return name2;
	}

	public void setName2(JLabel name2) {
		this.name2 = name2;
	}

	public static JLabel getLf1() {
		return lf1;
	}

	public static void setLf1(JLabel lf1) {
		SecondFrame.lf1 = lf1;
	}

	public static JLabel getLf2() {
		return lf2;
	}

	public static void setLf2(JLabel lf2) {
		SecondFrame.lf2 = lf2;
	}

	public JButton getEndT() {
		return endT;
	}

	public void setEndT(JButton endT) {
		this.endT = endT;
	}

	public JButton getEndP() {
		return endP;
	}

	public void setEndP(JButton endP) {
		this.endP = endP;
	}



public static  PanelofCards getField1() {
		return field1;
	}

	public static void setField1(PanelofCards field1) {
		field1 = field1;
	}

	public static  OppPanelofCard getField2() {
		return field2;
	}

	public void setField2(OppPanelofCard field2) {
		this.field2 = field2;
	}


	  

		  /* ArrayList<Card> hand = p.getField().getHand();
			int s = hand.size();
			if(s!=0){
			for(int i=0; i<s; i++){
				Card c =MyFrame.getBoard().getActivePlayer().getField().getHand().get(i);
				if(c instanceof MonsterCard){
					MonsterCard m = (MonsterCard) c;
					MonstersButtons mons = new MonstersButtons(m);
					mons.setText(h.getName());
				    mons.addMouseListener(h);
					h.add(mons);
					h.add(mons);
					}
				else {
					SpellCard s1 = (SpellCard) c ;
					SpellsButtons spell = new SpellsButtons(s1);
					spell.setText(h.getName());
					spell.addMouseListener(h);
					h.add(spell);
					h.add(spell);
					
				}
				}}*/
   
	

	


	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	private String getAllinfo(Card card) {
		if(card instanceof SpellCard){
			return "<html>"+ card.getName()+"</html>";
		}
		if(card instanceof MonsterCard){
			MonsterCard mc= (MonsterCard)card;
			return "<html>"+ mc.getName()+"<br> "+ mc.getAttackPoints() +
					"<br> "+ mc.getDefensePoints() + "<br>"+ mc.getLevel()+"</html>";
		} return "";
	
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource()== endT){
			this.repaint();
			this.revalidate();
			MyFrame.getBoard().getActivePlayer().endTurn();
			this.setTitle(MyFrame.getBoard().getActivePlayer().getName());
			SecondFrame.activedeck.setText("Active deck"+ MyFrame.getBoard().getActivePlayer().getField().getDeck().getDeck().size());			
			SecondFrame.oppdeck.setText("Opp deck"+ MyFrame.getBoard().getOpponentPlayer().getField().getDeck().getDeck().size());
			
			hand1.refreshHand1(MyFrame.getBoard().getActivePlayer(), hand1);
			hand2.refreshHand2(MyFrame.getBoard().getOpponentPlayer(), hand2);
			field1.refreshMonstersArea(MyFrame.getBoard().getActivePlayer(), field1);
			//field1.refreshSpellsArea(MyFrame.getBoard().getActivePlayer(), field1);
			field2.refreshMonstersArea(MyFrame.getBoard().getOpponentPlayer(), field2);
			//field2.refreshSpellsArea(MyFrame.getBoard().getOpponentPlayer(), field2);
			lf1.setText("Player 1  LifePoints:"+ MyFrame.getBoard().getActivePlayer().getLifePoints());
			lf2.setText("Player 2 LifePoints:"+ MyFrame.getBoard().getOpponentPlayer().getLifePoints());
			
			phase.setText("Current Phase is: "+ MyFrame.getBoard().getActivePlayer().getField().getPhase());
			
			if(MyFrame.getBoard().getWinner()!=null){
				gameOver = new GameOver();
				gameOver.setVisible(true);
				gameOver.validate();
				this.dispose();
			}
			this.revalidate();
			
			return;
	
			
		}
		
		
		if(e.getSource()==endP){
			this.repaint();
			this.revalidate();
			
			MyFrame.getBoard().getActivePlayer().endPhase();
			phase.setText("Current Phase is: "+ MyFrame.getBoard().getActivePlayer().getField().getPhase());
			SecondFrame.activedeck.setText("Active deck"+ MyFrame.getBoard().getActivePlayer().getField().getDeck().getDeck().size());			
			SecondFrame.oppdeck.setText("Opp deck"+ MyFrame.getBoard().getOpponentPlayer().getField().getDeck().getDeck().size());
	     
			int graveSize= MyFrame.getBoard().getActivePlayer().getField().getGraveyard().size();
			if(graveSize!=0)
			activegraveyard.setText("Active grav:" + MyFrame.getBoard().getActivePlayer().getField().getGraveyard().get(graveSize-1).getName());
			
			int graveSize2= MyFrame.getBoard().getOpponentPlayer().getField().getGraveyard().size();
			if(graveSize2!=0)
			oppgraveyard.setText("Opp grav:" + MyFrame.getBoard().getOpponentPlayer().getField().getGraveyard().get(graveSize2-1).getName());
			
			hand1.refreshHand1(MyFrame.getBoard().getActivePlayer(), hand1);
			hand2.refreshHand2(MyFrame.getBoard().getOpponentPlayer(), hand2);
			field1.refreshMonstersArea(MyFrame.getBoard().getActivePlayer(), field1);
			//field1.refreshSpellsArea(MyFrame.getBoard().getActivePlayer(), field1);
			field2.refreshMonstersArea(MyFrame.getBoard().getOpponentPlayer(), field2);
			//field2.refreshSpellsArea(MyFrame.getBoard().getOpponentPlayer(), field2);
			lf1.setText("Player1 LifePoints:"+ MyFrame.getBoard().getActivePlayer().getLifePoints());
			lf2.setText("Player2 LifePoints:"+ MyFrame.getBoard().getOpponentPlayer().getLifePoints());
			
			if(MyFrame.getBoard().getWinner()!=null){
				gameOver = new GameOver();
				gameOver.setVisible(true);
				gameOver.validate();
				this.dispose();
			}
			this.revalidate();
			return;
		}
	
		
		if(hand1!=null){
			
				
				for(int i =0; i<getHand1().getHand().size();i++){
				if(e.getSource()==getHand1().getHand().get(i)){
					getHand1().addMouseListener(this);
					ThirdFrame buttonFrame= new ThirdFrame((JButton) e.getSource());
					buttonFrame.setVisible(true);
					buttonFrame.validate();
					
					if(MyFrame.getBoard().getWinner()!=null){
						gameOver = new GameOver();
						gameOver.setVisible(true);
						gameOver.validate();
						this.dispose();
					}
					this.repaint();
					this.revalidate();
				}
			 
			}this.repaint();
			SecondFrame.activedeck.setText("Active deck"+ MyFrame.getBoard().getActivePlayer().getField().getDeck().getDeck().size());			
			SecondFrame.oppdeck.setText("Opp deck"+ MyFrame.getBoard().getOpponentPlayer().getField().getDeck().getDeck().size());
	     
			int graveSize= MyFrame.getBoard().getActivePlayer().getField().getGraveyard().size();
			if(graveSize!=0)
			activegraveyard.setText("Active grav:" + MyFrame.getBoard().getActivePlayer().getField().getGraveyard().get(graveSize-1).getName());
			
			int graveSize2= MyFrame.getBoard().getOpponentPlayer().getField().getGraveyard().size();
			if(graveSize2!=0)
			oppgraveyard.setText("Opp grav:" + MyFrame.getBoard().getOpponentPlayer().getField().getGraveyard().get(graveSize2-1).getName());
			
			lf1.setText("Player's LifePoints:"+ MyFrame.getBoard().getActivePlayer().getLifePoints());
			lf2.setText("Player's LifePoints:"+ MyFrame.getBoard().getOpponentPlayer().getLifePoints());
			
			phase.setText("Current Phase is: "+ MyFrame.getBoard().getActivePlayer().getField().getPhase());
			hand1.refreshHand1(MyFrame.getBoard().getActivePlayer(), hand1);
			
			if(MyFrame.getBoard().getWinner()!=null){
				gameOver = new GameOver();
				gameOver.setVisible(true);
				gameOver.validate();
				this.dispose();
			}
			this.revalidate();
		}
	
		if(hand2!=null){
			for(int i=0; i<hand2.getHand2().size(); i++){
				if(e.getSource()==hand2.getHand2().get(i)){
					this.repaint();
					this.revalidate();
					hand2.addMouseListener(this);
					ThirdFrame buttonFrame= new ThirdFrame(hand2.getHand2().get(i));
					buttonFrame.setVisible(true);
					buttonFrame.validate();
					
					if(MyFrame.getBoard().getWinner()!=null){
						gameOver = new GameOver();
						gameOver.setVisible(true);
						gameOver.validate();
						this.dispose();
					}
					this.repaint();
					this.revalidate();
				}
			}
			this.repaint();
			
			SecondFrame.activedeck.setText("Active deck"+ MyFrame.getBoard().getActivePlayer().getField().getDeck().getDeck().size());			
			SecondFrame.oppdeck.setText("Opp deck"+ MyFrame.getBoard().getOpponentPlayer().getField().getDeck().getDeck().size());
	     
			int graveSize= MyFrame.getBoard().getActivePlayer().getField().getGraveyard().size();
			if(graveSize!=0)
			activegraveyard.setText("Active grav:" + MyFrame.getBoard().getActivePlayer().getField().getGraveyard().get(graveSize-1).getName());
			
			int graveSize2= MyFrame.getBoard().getOpponentPlayer().getField().getGraveyard().size();
			if(graveSize2!=0)
			oppgraveyard.setText("Opp grav:" + MyFrame.getBoard().getOpponentPlayer().getField().getGraveyard().get(graveSize2-1).getName());
			
			lf1.setText("Player's LifePoints:"+ MyFrame.getBoard().getActivePlayer().getLifePoints());
			lf2.setText("Player's LifePoints:"+ MyFrame.getBoard().getOpponentPlayer().getLifePoints());
			
			phase.setText("Current Phase is: "+ MyFrame.getBoard().getActivePlayer().getField().getPhase());
			
			hand2.refreshHand2(MyFrame.getBoard().getOpponentPlayer(), hand2);
			
			if(MyFrame.getBoard().getWinner()!=null){
				gameOver = new GameOver();
				gameOver.setVisible(true);
				gameOver.validate();
				this.dispose();
			}
			this.revalidate();
		}
		}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static  Activehand getHand1() {
		return hand1;
	}

//	public static void setHand1(Activehand hand1) {
	//	SecondFrame.hand1 = hand1;
	//}
}
