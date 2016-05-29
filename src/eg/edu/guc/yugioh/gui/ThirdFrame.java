package eg.edu.guc.yugioh.gui;

import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.ChangeOfHeart;
import eg.edu.guc.yugioh.cards.spells.MagePower;
import eg.edu.guc.yugioh.exceptions.MultipleMonsterAdditionException;
import eg.edu.guc.yugioh.exceptions.NoMonsterSpaceException;
import eg.edu.guc.yugioh.exceptions.NoSpellSpaceException;
import eg.edu.guc.yugioh.exceptions.WrongPhaseException;

public class ThirdFrame extends JFrame implements MouseListener {
	MonstersButtons summonMonster;
	MonstersButtons setMonster;
	SpellsButtons activateSpell;
	SpellsButtons setSpell;
	JLabel message;
	

	public ThirdFrame() throws HeadlessException {
		
		}
	public ThirdFrame(JButton h){
		super();
		setBounds(100,100,500,300);
		this.setTitle("Choose Action");
		this.setLayout(new GridLayout(2,1));
		this.setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);//exit on click
		
		if (h instanceof MonstersButtons){
			
			summonMonster = new MonstersButtons(((MonstersButtons) h).getMonster());
			summonMonster.setText("Summon Monster");
			summonMonster.setBackground(Color.BLACK);
			summonMonster.setForeground(Color.RED); 
		
			getContentPane().add(summonMonster);
			
			
			summonMonster.addMouseListener(this);
			//summonMonster.setBounds(130, 130, 115, 75);
			 add(summonMonster);
			 
			 setMonster = new MonstersButtons(((MonstersButtons) h).getMonster());
			 setMonster.setText("Set Monster");
			 setMonster.setBackground(Color.BLACK);
			 setMonster.setForeground(Color.RED); 
			 getContentPane().add(setMonster);
			 setMonster.addMouseListener(this);
			 //setMonster.setBounds(130, 160, 115, 75);
			 add(setMonster);
			 
			}
		if(h instanceof SpellsButtons) {
			setSpell = new SpellsButtons(((SpellsButtons) h).getSpell());
			setSpell.setText("Set Spell");
			setSpell.setBackground(Color.BLACK);
			setSpell.setForeground(Color.RED); 
			 getContentPane().add(setSpell);
			setSpell.addMouseListener(this);
			 //setSpell.setBounds(130, 130, 115, 75);
			 add(setSpell);
			 
			activateSpell = new SpellsButtons(((SpellsButtons) h).getSpell());
			activateSpell.setText("Activate spell");
			activateSpell.setBackground(Color.BLACK);
			activateSpell.setForeground(Color.RED); 
			 getContentPane().add(activateSpell);
			
			activateSpell.addMouseListener(this);
		//	activateSpell.setBounds(130, 160, 115, 75);
			 add(activateSpell);
			
		}
			
			
			this.validate();
			
			
	}

	public ThirdFrame(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public ThirdFrame(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public ThirdFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==summonMonster){
			MonstersButtons m = (MonstersButtons) e.getSource();
			int level = m.getMonster().getLevel();
			
			try{//summon with sacrifices
				
				if (level<=4) {
			MyFrame.board.getActivePlayer().summonMonster(m.getMonster());
			
				}
				else {//saving monsters area in string of names
			String[] monstersInMonstersArea = new String[5];
			
				for(int i =0; i<MyFrame.getBoard().getActivePlayer().getField().getMonstersArea().size();i++){
					 monstersInMonstersArea [i]= MyFrame.getBoard().getActivePlayer().getField().getMonstersArea().get(i).getName();
				}
				if(level>=5 && level<=6){//needs only 1 sacrifice
					if(MyFrame.getBoard().getActivePlayer().getField().getMonstersArea().size()<1){
						JOptionPane.showMessageDialog(this, "You don't have enough sacrifices!");
					  
					}else{
						
					ArrayList<MonsterCard> sacrifices= getChoice(1,monstersInMonstersArea);
					
						MyFrame.board.getActivePlayer().summonMonster(m.getMonster(), sacrifices);
					}
						
					  						  	
					  	
					    
						SecondFrame.getHand1().refreshHand1(Card.getBoard().getActivePlayer(), SecondFrame.hand1);
						SecondFrame.hand2.refreshHand2(Card.getBoard().getOpponentPlayer(), SecondFrame.hand2);
						
						SecondFrame.getField1().refreshMonstersArea( MyFrame.getBoard().getActivePlayer(),SecondFrame.getField1());
						SecondFrame.getField2().refreshMonstersArea(MyFrame.getBoard().getOpponentPlayer(), SecondFrame.getField2());
								
						SecondFrame.lf1.setText("Player's LifePoints:"+ MyFrame.getBoard().getActivePlayer().getLifePoints());
						SecondFrame.lf2.setText("Player's LifePoints:"+ MyFrame.getBoard().getOpponentPlayer().getLifePoints());
					
						
						this.repaint();
						this.revalidate();		
				}
				if(level>=7 && level <=8){//needs 2 
					if(MyFrame.getBoard().getActivePlayer().getField().getMonstersArea().size()<2){
						JOptionPane.showMessageDialog(this, "You don't have enough sacrifices!");
					}else{
					ArrayList<MonsterCard> sacrifices= getChoice(2,monstersInMonstersArea);
					
					MyFrame.board.getActivePlayer().summonMonster(m.getMonster(), sacrifices);	
					
					
					SecondFrame.getHand1().refreshHand1(Card.getBoard().getActivePlayer(), SecondFrame.hand1);
					SecondFrame.hand2.refreshHand2(Card.getBoard().getOpponentPlayer(), SecondFrame.hand2);
					
					SecondFrame.getField1().refreshMonstersArea( MyFrame.getBoard().getActivePlayer(),SecondFrame.getField1());
					SecondFrame.getField2().refreshMonstersArea(MyFrame.getBoard().getOpponentPlayer(), SecondFrame.getField2());
							
					SecondFrame.lf1.setText("Player's LifePoints:"+ MyFrame.getBoard().getActivePlayer().getLifePoints());
					SecondFrame.lf2.setText("Player's LifePoints:"+ MyFrame.getBoard().getOpponentPlayer().getLifePoints());
					
					this.repaint();
					this.revalidate();
				}}
				SecondFrame.getHand1().refreshHand1(Card.getBoard().getActivePlayer(), SecondFrame.hand1);
				SecondFrame.hand2.refreshHand2(Card.getBoard().getOpponentPlayer(), SecondFrame.hand2);
				
				SecondFrame.getField1().refreshMonstersArea( MyFrame.getBoard().getActivePlayer(),SecondFrame.getField1());
				SecondFrame.getField2().refreshMonstersArea(MyFrame.getBoard().getOpponentPlayer(), SecondFrame.getField2());
						
				SecondFrame.lf1.setText("Player's LifePoints:"+ MyFrame.getBoard().getActivePlayer().getLifePoints());
				SecondFrame.lf2.setText("Player's LifePoints:"+ MyFrame.getBoard().getOpponentPlayer().getLifePoints());
				
					
				}
				
				SecondFrame.getHand1().refreshHand1(Card.getBoard().getActivePlayer(), SecondFrame.hand1);
				SecondFrame.hand2.refreshHand2(Card.getBoard().getOpponentPlayer(), SecondFrame.hand2);
				
				SecondFrame.getField1().refreshMonstersArea( MyFrame.getBoard().getActivePlayer(),SecondFrame.getField1());
				SecondFrame.getField2().refreshMonstersArea(MyFrame.getBoard().getOpponentPlayer(), SecondFrame.getField2());
						
				SecondFrame.lf1.setText("Player's LifePoints:"+ MyFrame.getBoard().getActivePlayer().getLifePoints());
				SecondFrame.lf2.setText("Player's LifePoints:"+ MyFrame.getBoard().getOpponentPlayer().getLifePoints());
				
				this.revalidate();
				this.setVisible(false);
			}
			
			catch(NoMonsterSpaceException exp){
				JOptionPane.showMessageDialog(this, "No space left in monsters area!");
							}
			catch(MultipleMonsterAdditionException exp){
				JOptionPane.showMessageDialog(this,"You can only add one monster per turn!");
				
			}
			catch(WrongPhaseException exp){
				JOptionPane.showMessageDialog(this,"You cant add monster, it's BATTLE phase!");
				
			}
		this.setVisible(false);
		}
		if(e.getSource()==setMonster){
			MonstersButtons m = (MonstersButtons) e.getSource();
			
			int level = m.getMonster().getLevel();
			
			try{//set with sacrifices
				
				if (level<=4) {
					
					Card.getBoard().getActivePlayer().setMonster(m.getMonster());
					SecondFrame.hand1.refreshHand1(Card.getBoard().getActivePlayer(),SecondFrame.hand1);
				}
			
				else { //saving monsters area in string of names
			    
				if(level>=5 && level<=6){//needs only 1 sacrifice
					if(MyFrame.getBoard().getActivePlayer().getField().getMonstersArea().size()<1){
						JOptionPane.showMessageDialog(this, "You don't have enough sacrifices!");
					}else{
						String[] monstersInMonstersArea = new String[5];
						
						for(int i =0; i<MyFrame.getBoard().getActivePlayer().getField().getMonstersArea().size();i++){
							 monstersInMonstersArea [i]= MyFrame.getBoard().getActivePlayer().getField().getMonstersArea().get(i).getName();
						}
					ArrayList<MonsterCard> sacrifices= getChoice(1,monstersInMonstersArea);
				//	if(sacrifices.size()<1){
					//	JOptionPane.showMessageDialog(this, "You don't have enough sacrifices!");
					//}
					
					MyFrame.board.getActivePlayer().setMonster(m.getMonster(), sacrifices);
					}
				
					
				}
				if(level>=7 && level <=8){//needs only 2 sacrifices
					if(MyFrame.getBoard().getActivePlayer().getField().getMonstersArea().size()<2){
							JOptionPane.showMessageDialog(this, "You don't have enough sacrifices!");
					}else{
						String[] monstersInMonstersArea = new String[5];
						
						for(int i =0; i<MyFrame.getBoard().getActivePlayer().getField().getMonstersArea().size();i++){
							 monstersInMonstersArea [i]= MyFrame.getBoard().getActivePlayer().getField().getMonstersArea().get(i).getName();
						}
					ArrayList<MonsterCard> sacrifices= getChoice(2,monstersInMonstersArea);
					//if(sacrifices.size()<2){
						//JOptionPane.showMessageDialog(this, "You don't have enough sacrifices!");
				//	}
					MyFrame.board.getActivePlayer().setMonster(m.getMonster(), sacrifices);	
				}
				}
			}
				SecondFrame.getHand1().refreshHand1(Card.getBoard().getActivePlayer(), SecondFrame.hand1);
				SecondFrame.hand2.refreshHand2(Card.getBoard().getOpponentPlayer(), SecondFrame.hand2);
				
				SecondFrame.getField1().refreshMonstersArea( MyFrame.getBoard().getActivePlayer(),SecondFrame.getField1());
				SecondFrame.getField2().refreshMonstersArea(MyFrame.getBoard().getOpponentPlayer(), SecondFrame.getField2());
			
				SecondFrame.lf1.setText("Player's LifePoints:"+ MyFrame.getBoard().getActivePlayer().getLifePoints());
				SecondFrame.lf2.setText("Player's LifePoints:"+ MyFrame.getBoard().getOpponentPlayer().getLifePoints());
			
				SecondFrame.lf1.setText("Player's LifePoints:"+ MyFrame.getBoard().getActivePlayer().getLifePoints());
				SecondFrame.lf2.setText("Player's LifePoints:"+ MyFrame.getBoard().getOpponentPlayer().getLifePoints());
				
				this.revalidate();
				this.setVisible(false);
			}
		
			catch(NoMonsterSpaceException exp){
				JOptionPane.showMessageDialog(this,"No MonsterSpace!");
				
			}
			catch(MultipleMonsterAdditionException exp){
				JOptionPane.showMessageDialog(this,"You can can only one monster per turn!");
				
			}	this.setVisible(false);
		}
		
		if(e.getSource()==activateSpell){
			SpellsButtons s= (SpellsButtons)e.getSource();
			try{//activate el spell 3ala monster ezay?
				if(s.getSpell() instanceof ChangeOfHeart || s.getSpell() instanceof MagePower)
				{// the only 2 spellCards that needs monster 
					String[] monstersInMonstersArea = new String[5];
					for(int i =0; i<MyFrame.getBoard().getOpponentPlayer().getField().getMonstersArea().size();i++){
						 monstersInMonstersArea [i]= MyFrame.getBoard().getOpponentPlayer().getField().getMonstersArea().get(i).getName();
					}
					MonsterCard oppMonster= getChoiceOpp(1,monstersInMonstersArea);
					MyFrame.board.getActivePlayer().getField().activateSetSpell(s.getSpell(), oppMonster);
					
					//if(MyFrame.board.getActivePlayer().activateSpell(s.getSpell(), oppMonster)){
						//SecondFrame.getPanelCards().add(s);
						SecondFrame.getField1().refreshMonstersArea( MyFrame.getBoard().getActivePlayer(),SecondFrame.getField1());
						SecondFrame.getField2().refreshMonstersArea(MyFrame.getBoard().getOpponentPlayer(), SecondFrame.getField2());
						//SecondFrame.getField1().refreshSpellsArea(MyFrame.getBoard().getActivePlayer(), SecondFrame.getField1());
						//SecondFrame.getField1().refreshSpellsArea(MyFrame.getBoard().getOpponentPlayer(), SecondFrame.getField2());
						SecondFrame.lf1.setText("Player's LifePoints:"+ MyFrame.getBoard().getActivePlayer().getLifePoints());
						SecondFrame.lf2.setText("Player's LifePoints:"+ MyFrame.getBoard().getOpponentPlayer().getLifePoints());
						
						this.revalidate();
					
						this.setVisible(false);
					}
				
				else{
				MyFrame.board.getActivePlayer().activateSpell(s.getSpell(), null);
				
				//if(MyFrame.board.getActivePlayer().activateSpell(s.getSpell(), null)){
					//SecondFrame.getPanelCards().add(s);
					SecondFrame.getField1().refreshMonstersArea( MyFrame.getBoard().getActivePlayer(),SecondFrame.getField1());
					SecondFrame.getField2().refreshMonstersArea(MyFrame.getBoard().getOpponentPlayer(), SecondFrame.getField2());
					//SecondFrame.getField1().refreshSpellsArea(MyFrame.getBoard().getActivePlayer(), SecondFrame.getField1());
					//SecondFrame.getField1().refreshSpellsArea(MyFrame.getBoard().getOpponentPlayer(), SecondFrame.getField2());
					this.revalidate();
				
					this.setVisible(false);
				}
				
			} 
			catch(WrongPhaseException exp){
				JOptionPane.showMessageDialog(this,"You cant activate spell during BATTLE phase!");
			
			}
			catch (NoSpellSpaceException exp){
				JOptionPane.showMessageDialog(this,"No space to add more spells!");
			}
			this.setVisible(false);
		}
		if(e.getSource()==setSpell){
			SpellsButtons s= (SpellsButtons)e.getSource();
            try{
            	MyFrame.board.getActivePlayer().setSpell(s.getSpell());
            	
            		SecondFrame.getField1().refreshMonstersArea( MyFrame.getBoard().getActivePlayer(),SecondFrame.getField1());
    				SecondFrame.getField2().refreshMonstersArea(MyFrame.getBoard().getOpponentPlayer(), SecondFrame.getField2());
    				
    				
    				SecondFrame.hand1.refreshHand1(MyFrame.getBoard().getActivePlayer(), SecondFrame.hand1);
    				SecondFrame.hand2.refreshHand2(MyFrame.getBoard().getOpponentPlayer(), SecondFrame.hand2);
    				
    				SecondFrame.lf1.setText("Player's LifePoints:"+ MyFrame.getBoard().getActivePlayer().getLifePoints());
    				SecondFrame.lf2.setText("Player's LifePoints:"+ MyFrame.getBoard().getOpponentPlayer().getLifePoints());
    				
    				this.revalidate();
    			
            		this.setVisible(false);
            		
            	}
            catch(WrongPhaseException exp){
				JOptionPane.showMessageDialog(this,"You cant set spell during BATTLE phase!");
			
			}
            catch(NoSpellSpaceException exp){
            	JOptionPane.showMessageDialog(this,"No space to add more spells!");
				
            	
            }	this.setVisible(false);
		}
		
	}
	
	
	 private MonsterCard getChoiceOpp(int counter,
			String[] list) {
	 
		MonsterCard result= new MonsterCard();
		 for(int i =0; i< counter;i++){
		 
			 String s=(String)JOptionPane.showInputDialog(this,"Choose monsters to activate spell on","Monster Choice", JOptionPane.PLAIN_MESSAGE,null,list,list[0]);
		 
		 
		 for(int j=0; j< MyFrame.getBoard().getOpponentPlayer().getField().getMonstersArea().size();j++){
			 if(MyFrame.getBoard().getOpponentPlayer().getField().getMonstersArea().get(j).getName().equals(s)){
				 result=MyFrame.getBoard().getOpponentPlayer().getField().getMonstersArea().get(j);
			 }
		 }
			 }
		 return result;
		
	}
	public ArrayList<MonsterCard> getChoice (int counter, String[] list){
		 ArrayList<MonsterCard> result=  new ArrayList<MonsterCard>(2);
		 for(int i =0; i< counter;i++){
		 
			 String s=(String)JOptionPane.showInputDialog(this,"Choose monsters to sacrifice with","Monster Choice", JOptionPane.PLAIN_MESSAGE,null,list,list[0]);
		 
		 
		 for(int j=0; j< MyFrame.getBoard().getActivePlayer().getField().getMonstersArea().size();j++){
			 if(MyFrame.getBoard().getActivePlayer().getField().getMonstersArea().get(j).getName().equals(s)){
				 result.add(MyFrame.getBoard().getActivePlayer().getField().getMonstersArea().get(j));
			 }
		 }
			 }
		 return result;
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
