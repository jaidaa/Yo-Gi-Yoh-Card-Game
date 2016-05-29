package eg.edu.guc.yugioh.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import eg.edu.guc.yugioh.board.player.Phase;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.ChangeOfHeart;
import eg.edu.guc.yugioh.cards.spells.MagePower;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.exceptions.DefenseMonsterAttackException;
import eg.edu.guc.yugioh.exceptions.MonsterMultipleAttackException;
import eg.edu.guc.yugioh.exceptions.WrongPhaseException;

public class OppPanelofCard extends JPanel implements MouseListener{
	  	ArrayList<MonstersButtons> monsters;
	  	ArrayList<SpellsButtons> spells;
	  
	  	
	  	public ArrayList<MonstersButtons> getMonsters() {
			return monsters;
		}

		public void setMonsters(ArrayList<MonstersButtons> monsters) {
			this.monsters = monsters;
		}

		public ArrayList<SpellsButtons> getSpells() {
			return spells;
		}

		public void setSpells(ArrayList<SpellsButtons> spells) {
			this.spells = spells;
		}

		
	  	
	  
	  
	public OppPanelofCard() {
		setLayout(new GridLayout(2,5));
		setVisible(true);
		this.setOpaque(false);
		this.setBorder(BorderFactory.createLineBorder(Color.red));
		
		
		monsters= new ArrayList<MonstersButtons> ();
		spells= new ArrayList<SpellsButtons> ();
		
	
		ArrayList<MonsterCard> monsterarea= MyFrame.getBoard().getOpponentPlayer().getField().getMonstersArea();
		ArrayList<SpellCard> spellarea=MyFrame.getBoard().getOpponentPlayer().getField().getSpellArea();
		
		if(spellarea.isEmpty()){
			//ma3andosh wala monster 3l monster area lesa
			
			for(int i=0; i<5;i++){
					SpellsButtons	spellButton = new SpellsButtons();
					spellButton.addMouseListener(this);
					spellButton.setOpaque(false);
					spellButton.setContentAreaFilled(false);
					spellButton.setBorderPainted(false);
					spells.add(spellButton);
					this.add(spellButton);
					
			}
			
		}else{//3ando 3l a2al one monster fl monstersarea beta3to
		for(int i =0; i<spellarea.size();i++){
			SpellsButtons	spellButton = new SpellsButtons(spellarea.get(i));
			spellButton.addMouseListener(this);
			if(spellarea.get(i).isHidden()==true){
				spellButton.setText("Hidden spell");
			}
			else spellButton.setText(spellarea.get(i).getName());
			
			spells.add(spellButton);
			this.add(spellButton);
		}
		//fill the rest with empty Buttons
		for(int i= spellarea.size(); i<5;i++){
			SpellsButtons	spellButton = new SpellsButtons();
			spellButton.setOpaque(false);
			spellButton.setContentAreaFilled(false);
			spellButton.setBorderPainted(false);
			spellButton.addMouseListener(this);
			spells.add(spellButton);
			this.add(spellButton);
		}
		}
		//khalast el 5 spaces beto3 el spell area
		//now fill the monstersarea
		if(monsterarea.isEmpty()){
			for(int i=0; i<5;i++){
				MonstersButtons	monsButton = new MonstersButtons();
				monsButton.setOpaque(false);
				monsButton.setContentAreaFilled(false);
				monsButton.setBorderPainted(false);
				monsButton.addMouseListener(this);
				monsters.add(monsButton);
				this.add(monsButton);
				}
		}
		else{//3ando 3l a2al one monster fl monstersarea beta3to
			for(int i =0; i<monsterarea.size();i++){
				MonstersButtons	monsButton = new MonstersButtons(monsterarea.get(i));
				monsButton.addMouseListener(this);
				if(monsterarea.get(i).isHidden()==true){
					monsButton.setText("Hidden monsterl");
				}
				else monsButton.setText(monsterarea.get(i).getName());
				
				monsters.add(monsButton);
				this.add(monsButton);
			}
			//fill the rest with empty Buttons
			for(int i= monsterarea.size(); i<5;i++){
				MonstersButtons	monsbutton = new MonstersButtons();
				monsbutton.setOpaque(false);
				monsbutton.setContentAreaFilled(false);
				monsbutton.setBorderPainted(false);
				monsbutton.addMouseListener(this);
				monsters.add(monsbutton);
				this.add(monsbutton);
			}
			}
		
		
				
		
	
	}
	public  void refreshMonstersArea(Player p, OppPanelofCard field) {
		field.monsters.clear();
		field.spells.clear();
		field.repaint();
		field.removeAll();
		
	  
	
		ArrayList<MonsterCard> monsterarea= p.getField().getMonstersArea();
		ArrayList<SpellCard> spellarea=p.getField().getSpellArea();
		
		if(spellarea.isEmpty()){
			//ma3andosh wala monster 3l monster area lesa
			
			for(int i=0; i<5;i++){
					SpellsButtons	spellButton = new SpellsButtons();
					spellButton.setOpaque(false);
					spellButton.setSize(80, 100);
					
					spellButton.setContentAreaFilled(false);
					spellButton.setBorderPainted(false);
					spellButton.addMouseListener(this);
					spells.add(spellButton);
					this.add(spellButton);
					
			}
			
		}else{//3ando 3l a2al one monster fl monstersarea beta3to
		for(int i =0; i<spellarea.size();i++){
			SpellsButtons	spellButton = new SpellsButtons(spellarea.get(i));
			spellButton.addMouseListener(this);
			if(spellarea.get(i).isHidden()==true){
				spellButton.setText("Hidden spell");
			}
			else spellButton.setText(spellarea.get(i).getName());
			
			spells.add(spellButton);
			this.add(spellButton);
		}
		//fill the rest with empty Buttons
		for(int i= spellarea.size(); i<5;i++){
			SpellsButtons	spellButton = new SpellsButtons();
			spellButton.setOpaque(false);
			spellButton.setContentAreaFilled(false);
			spellButton.setBorderPainted(false);
			spellButton.addMouseListener(this);
			spells.add(spellButton);
			this.add(spellButton);
		}
		}
		//khalast el 5 spaces beto3 el spell area
		//now fill the monstersarea
		if(monsterarea.isEmpty()){
			for(int i=0; i<5;i++){
				MonstersButtons	monsButton = new MonstersButtons();
				monsButton.setOpaque(false);
				monsButton.setContentAreaFilled(false);
				monsButton.setBorderPainted(false);
				monsButton.addMouseListener(this);
				monsters.add(monsButton);
				this.add(monsButton);
				}
		}
		else{//3ando 3l a2al one monster fl monstersarea beta3to
			for(int i =0; i<monsterarea.size();i++){
				MonstersButtons	monsButton = new MonstersButtons(monsterarea.get(i));
				monsButton.addMouseListener(this);
				if(monsterarea.get(i).isHidden()==true){
					monsButton.setText("Hidden monsterl");
				}
				else monsButton.setText(monsterarea.get(i).getName());
				
				monsters.add(monsButton);
				this.add(monsButton);
			}
			//fill the rest with empty Buttons
			for(int i= monsterarea.size(); i<5;i++){
				MonstersButtons	monsbutton = new MonstersButtons();
				monsbutton.setOpaque(false);
				monsbutton.setContentAreaFilled(false);
				monsbutton.setBorderPainted(false);
				monsbutton.addMouseListener(this);
				monsters.add(monsbutton);
				this.add(monsbutton);
			}
			}
		
		
		//SecondFrame.activedeck.refreshActiveDeck(p, SecondFrame.activedeck);
	 	//SecondFrame.oppdeck.refreshOppDeck(p, SecondFrame.oppdeck);
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
	


	@Override
	public void mouseClicked(MouseEvent e) {
	/*	if(p1== MyFrame.getBoard().getActivePlayer()){
			//monsters area
			if(monsters!=null){
				
				
				for(int i =0; i<monsters.size();i++){
				if(e.getSource()==monsters.get(i)){
					addMouseListener(this);
					FourthFrame buttonFrame= new FourthFrame((Buttons) e.getSource());
					buttonFrame.setVisible(true);
					buttonFrame.validate();
				}
			}
			
		}//spells area
			
				if(spells!=null){
					
					
					for(int i =0; i<spells.size();i++){
					if(e.getSource()==spells.get(i)){
						addMouseListener(this);
						ThirdFrame buttonFrame= new ThirdFrame((Buttons) e.getSource());
						buttonFrame.setVisible(true);
						buttonFrame.validate();
					}
				}
				
			}
			}*/
		}
	

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
		/*	if(monsters!=null){
				for(int i =0; i < MyFrame.getBoard().getOpponentPlayer().getField().getMonstersArea().size();i++){
					if(monsters.get(i)!=null && !monsters.get(i).getMonster().isHidden()){
					if (e.getSource()== monsters.get(i)){
						Card c= MyFrame.getBoard().getOpponentPlayer().getField().getMonstersArea().get(i);
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
			if(spells!=null){
				for(int i =0; i < MyFrame.getBoard().getOpponentPlayer().getField().getSpellArea().size();i++){
					if(spells.get(i)!=null){
					if (e.getSource()== spells.get(i)){
						Card c= MyFrame.getBoard().getOpponentPlayer().getField().getSpellArea().get(i);
						JLabel cardInfo= new JLabel(getAllinfo(c));
						cardInfo.setText(getAllinfo(c));
						cardInfo.addMouseListener(this);
						cardInfo.setBounds(10,60,150,150);
						cardInfo.setVisible(true);
						SecondFrame.setCardInfo(cardInfo);
					}
				}
				}
			}*/
		}
		
	

	private String getAllinfo(Card c) {
		if(c instanceof SpellCard){
			return "<html>"+ c.getName()+"</html>";
		}
		else{
			MonsterCard mc= (MonsterCard)c;
			return "<html>"+ mc.getName()+"<br> "+ mc.getAttackPoints() +
					"<br> "+ mc.getDefensePoints() + "<br>"+ mc.getLevel()+"</html>";
		}
	

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		/*if(monsters!=null){
			
			
			for(int i =0; i<monsters.size();i++){
			if(e.getSource()==monsters.get(i)){
				addMouseListener(this);
				FourthFrame buttonFrame= new FourthFrame((JButton) e.getSource());
				buttonFrame.setVisible(true);
				buttonFrame.validate();
			}
			}
			}
		if(spells!=null){
			  for(int i =0; i<spells.size();i++){
					if(e.getSource()==spells.get(i)){
						addMouseListener(this);
						FourthFrame buttonFrame= new FourthFrame((JButton) e.getSource());
						buttonFrame.setVisible(true);
						buttonFrame.validate();
					}
				}
				
		  }
		
	/*	
		if(monsters!=null){//switch monster mode or declare attack
			for(int i =0; i<monsters.size();i++){
				if(e.getSource()== monsters.get(i)){
					try{
					if(MyFrame.getBoard().getOpponentPlayer().getField().getPhase()!=Phase.BATTLE){
						MyFrame.getBoard().getOpponentPlayer().switchMonsterMode(monsters.get(i).getMonster());
						
						SecondFrame.lf1.setText("Player's LifePoints:"+ MyFrame.getBoard().getActivePlayer().getLifePoints());
						SecondFrame.lf2.setText("Player's LifePoints:"+ MyFrame.getBoard().getOpponentPlayer().getLifePoints());
						
						SecondFrame.field1.refreshMonstersArea( MyFrame.getBoard().getOpponentPlayer(),SecondFrame.getField1());
						refreshMonstersArea(MyFrame.getBoard().getActivePlayer(),SecondFrame.getField2());
					
						
						this.revalidate();
					
					}else{
					if (MyFrame.getBoard().getActivePlayer().getField().getMonstersArea().isEmpty()){
			                  	MyFrame.getBoard().getActivePlayer().getField().declareAttack(monsters.get(i).getMonster(),null);
			                  	SecondFrame.lf1.setText("Player's LifePoints:"+ MyFrame.getBoard().getActivePlayer().getLifePoints());
								SecondFrame.lf2.setText("Player's LifePoints:"+ MyFrame.getBoard().getOpponentPlayer().getLifePoints());
								
								SecondFrame.field1.refreshMonstersArea( MyFrame.getBoard().getOpponentPlayer(),SecondFrame.getField1());
								refreshMonstersArea(MyFrame.getBoard().getActivePlayer(),SecondFrame.getField2());
							
					}
					else{ 
						MonsterCard attacker= monsters.get(i).getMonster();
						String[] monstersInOppMonstersArea = new String[5];	
						for(int i1 =0; i1<MyFrame.getBoard().getActivePlayer().getField().getMonstersArea().size();i1++){
							 monstersInOppMonstersArea [i1]= MyFrame.getBoard().getActivePlayer().getField().getMonstersArea().get(i1).getName();
						}
						MonsterCard attackON= getChoice(1,monstersInOppMonstersArea);
						//lazem eli yedeclare attack aw ay method yb2a el active player
						MyFrame.getBoard().getActivePlayer().declareAttack(attacker, attackON);
						SecondFrame.lf1.setText("Player's LifePoints:"+ MyFrame.getBoard().getActivePlayer().getLifePoints());
						SecondFrame.lf2.setText("Player's LifePoints:"+ MyFrame.getBoard().getOpponentPlayer().getLifePoints());
						
						SecondFrame.field1.refreshMonstersArea( MyFrame.getBoard().getOpponentPlayer(),SecondFrame.getField1());
						refreshMonstersArea(MyFrame.getBoard().getActivePlayer(),SecondFrame.getField2());
					
					}}
					//refreshMonstersArea( MyFrame.getBoard().getActivePlayer(),SecondFrame.getField1());
					SecondFrame.lf1.setText("Player's LifePoints:"+ MyFrame.getBoard().getActivePlayer().getLifePoints());
					SecondFrame.lf2.setText("Player's LifePoints:"+ MyFrame.getBoard().getOpponentPlayer().getLifePoints());
					
					SecondFrame.field1.refreshMonstersArea( MyFrame.getBoard().getOpponentPlayer(),SecondFrame.getField1());
					refreshMonstersArea(MyFrame.getBoard().getActivePlayer(),SecondFrame.getField2());
				
					
					this.revalidate();
					
					}
					
					catch(WrongPhaseException exp){
						JOptionPane.showMessageDialog(this, "Wrong phase!");
						
					}catch(DefenseMonsterAttackException exp2){
						JOptionPane.showMessageDialog(this, "You can't attack in defense mode!");
					}
					catch(MonsterMultipleAttackException exp1){
						JOptionPane.showMessageDialog(this, "You cant attack twice with the same monster!");
					}
					
					
				}
			}
			}
			
			if(spells!=null){
				for(int i =0; i<spells.size();i++){
					if(e.getSource()== spells.get(i)){
						SpellsButtons s= (SpellsButtons)e.getSource();
						try{//activate el spell 3ala monster ezay?
							if(s.getSpell() instanceof ChangeOfHeart || s.getSpell() instanceof MagePower)
							{// the only 2 spellCards that needs monster 
								String[] monstersInMonstersArea = new String[5];
							ddd	for(int i1 =0; i1<MyFrame.getBoard().getActivePlayer().getField().getMonstersArea().size();i1++){
									 monstersInMonstersArea [i1]= MyFrame.getBoard().getOpponentPlayer().getField().getMonstersArea().get(i1).getName();
								}
								MonsterCard oppMonster= getChoiceOpp(1,monstersInMonstersArea);
								MyFrame.board.getOpponentPlayer().getField().activateSetSpell(s.getSpell(), oppMonster);
								
								
									
									//refreshMonstersArea( MyFrame.getBoard().getActivePlayer(),SecondFrame.getField1());
									SecondFrame.lf1.setText("Player's LifePoints:"+ MyFrame.getBoard().getActivePlayer().getLifePoints());
									SecondFrame.lf2.setText("Player's LifePoints:"+ MyFrame.getBoard().getOpponentPlayer().getLifePoints());
									
									SecondFrame.field1.refreshMonstersArea( MyFrame.getBoard().getActivePlayer(),SecondFrame.getField1());
									refreshMonstersArea(MyFrame.getBoard().getOpponentPlayer(),SecondFrame.getField2());
									
									this.revalidate();
								
							}
							else{
							MyFrame.board.getOpponentPlayer().getField().activateSetSpell(s.getSpell(), null);
							
							
					
								//refreshMonstersArea( MyFrame.getBoard().getActivePlayer(),SecondFrame.getField1());
								SecondFrame.lf1.setText("Player's LifePoints:"+ MyFrame.getBoard().getActivePlayer().getLifePoints());
								SecondFrame.lf2.setText("Player's LifePoints:"+ MyFrame.getBoard().getOpponentPlayer().getLifePoints());
								
								SecondFrame.field1.refreshMonstersArea( MyFrame.getBoard().getActivePlayer(),SecondFrame.getField1());
								refreshMonstersArea(MyFrame.getBoard().getOpponentPlayer(),SecondFrame.getField2());
									this.revalidate();
						
							
							}
						} 
						catch(WrongPhaseException exp){
							JOptionPane.showMessageDialog(this, "You cant activate spell during BATTLE phase!");
								}
						//refreshMonstersArea( MyFrame.getBoard().getActivePlayer(),SecondFrame.getField1());
						SecondFrame.lf1.setText("Player's LifePoints:"+ MyFrame.getBoard().getActivePlayer().getLifePoints());
						SecondFrame.lf2.setText("Player's LifePoints:"+ MyFrame.getBoard().getOpponentPlayer().getLifePoints());
						
						SecondFrame.field1.refreshMonstersArea( MyFrame.getBoard().getActivePlayer(),SecondFrame.getField1());
						refreshMonstersArea(MyFrame.getBoard().getOpponentPlayer(),SecondFrame.getField2());
						this.revalidate();
						}
				}}
				
			
	*/}

/*	private void refreshGui() {
	
		Activedeck.getActivedeck().setText("ActiveDeck "+ activedeck.getSize1());
		oppdeck.setText("OppDeck "+ oppdeck.getSize1());
		//update el life points
		lf1.setName(("Player's LifePoints:"+ MyFrame.getBoard().getActivePlayer().getLifePoints()));
		lf2.setName("Player's LifePoints:"+ MyFrame.getBoard().getOpponentPlayer().getLifePoints());
		//update el phase
		phase.setName("Current Phase is: "+ MyFrame.getBoard().getActivePlayer().getField().getPhase());
		//update el your TURN label
		turn.setName("Your Turn: "+ MyFrame.getBoard().getActivePlayer().getName());
		//refresh grave yard
		refreshGraveYard(MyFrame.getBoard().getActivePlayer(),activegraveyard);
		refreshGraveYard(MyFrame.getBoard().getOpponentPlayer(),oppgraveyard);
		//refresh el spells area
		refreshSpellsArea(MyFrame.getBoard().getActivePlayer(), field1);
		refreshSpellsArea(MyFrame.getBoard().getOpponentPlayer(), field2);
		//refresh el monsters area
		refreshMonstersArea(MyFrame.getBoard().getActivePlayer(),field1);
		refreshMonstersArea(MyFrame.getBoard().getOpponentPlayer(),field2);
		//refresh el hand
		refreshHand1(MyFrame.getBoard().getActivePlayer(),getHand1());
		refreshHand2(MyFrame.getBoard().getOpponentPlayer(),hand2);
		
		
		
	}
		
	}
*/
	private MonsterCard getChoiceOpp(int counter, String[] list) {
		MonsterCard result= null; 
		for(int i =0; i< counter;i++){
			 
			 String s=(String)JOptionPane.showInputDialog(this,"Choose monsters to activate spell on","Monster Choice", JOptionPane.PLAIN_MESSAGE,null,list,list[0]);
		 
		 
		 for(int j=0; i< MyFrame.getBoard().getActivePlayer().getField().getMonstersArea().size();j++){
			 if(MyFrame.getBoard().getActivePlayer().getField().getMonstersArea().get(j).getName().equals(s)){
				 result=(MyFrame.getBoard().getActivePlayer().getField().getMonstersArea().get(j));
			 }
		 }
			 }
		 return result;

	}

	private MonsterCard getChoice(int counter, String[] list) {
		MonsterCard result= new MonsterCard();
		 for(int i =0; i< counter;i++){
		 
			 String s=(String)JOptionPane.showInputDialog(this,"Choose monster to attack ON ","Monster Choice", JOptionPane.PLAIN_MESSAGE,null,list,list[0]);
		 
		 //hadawar 3l monster eli hwa e5taro fl monstersarea bet3t el opp
		 for(int j=0; j< MyFrame.getBoard().getActivePlayer().getField().getMonstersArea().size();j++){
			 if(MyFrame.getBoard().getActivePlayer().getField().getMonstersArea().get(j).getName().equals(s)){
				 result=MyFrame.getBoard().getActivePlayer().getField().getMonstersArea().get(j);
				 break;
			 }
		 }
			 }
		 return result;
	
	
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
