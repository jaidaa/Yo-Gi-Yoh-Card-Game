package eg.edu.guc.yugioh.gui;

import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.ChangeOfHeart;
import eg.edu.guc.yugioh.cards.spells.MagePower;
import eg.edu.guc.yugioh.exceptions.DefenseMonsterAttackException;
import eg.edu.guc.yugioh.exceptions.MonsterMultipleAttackException;
import eg.edu.guc.yugioh.exceptions.WrongPhaseException;

public class FourthFrame extends JFrame implements MouseListener {

	MonstersButtons declareAttack;
	MonstersButtons switchMode;
	SpellsButtons activateSetSpell;
	
	
	public FourthFrame(JButton button) throws HeadlessException {
		super();
		setBounds(100,100,500,300);
		this.setTitle("Choose Action");
		this.setLayout(new GridLayout(2,1));
		this.setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);//exit on click

		if(button instanceof MonstersButtons){
			declareAttack = new MonstersButtons(((MonstersButtons) button).getMonster());
			declareAttack.setText("Declare attack");
			declareAttack.setBackground(Color.BLACK);
			declareAttack.setForeground(Color.RED); 
			getContentPane().add(declareAttack);
			declareAttack.addMouseListener(this);
			 add(declareAttack);
			 
			 switchMode = new MonstersButtons(((MonstersButtons) button).getMonster());
			 switchMode.setText("Switch Monster Mode");
			 switchMode.setBackground(Color.BLACK);
			 switchMode.setForeground(Color.RED); 
				getContentPane().add(switchMode);
				switchMode.addMouseListener(this);
				 add(switchMode);
				 
			 
		}
		
		if(button instanceof SpellsButtons){
			activateSetSpell = new SpellsButtons(((SpellsButtons) button).getSpell());
			activateSetSpell.setText("Activate Spell");
			activateSetSpell.setBackground(Color.BLACK);
			activateSetSpell.setForeground(Color.RED); 
			 getContentPane().add(activateSetSpell);
			 activateSetSpell.addMouseListener(this);
			 add(activateSetSpell);	
		}
		
		this.validate();
	}

	public FourthFrame(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public FourthFrame(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public FourthFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource()== declareAttack){
			MonstersButtons m = (MonstersButtons) e.getSource();
			if(MyFrame.getBoard().getOpponentPlayer().getField().getMonstersArea().isEmpty()){
				//attack directly 3l lifepoints
			try{	
			MyFrame.getBoard().getActivePlayer().getField().declareAttack(m.getMonster(), null);
			SecondFrame.lf1.setText("Player's LifePoints:"+ MyFrame.getBoard().getActivePlayer().getLifePoints());
			SecondFrame.lf2.setText("Player's LifePoints:"+ MyFrame.getBoard().getOpponentPlayer().getLifePoints());
			
			//SecondFrame.field1.removeAll();
			
			//PanelofCards active = new PanelofCards();
			//SecondFrame.setField1(active);
			
			SecondFrame.field1.refreshMonstersArea( MyFrame.getBoard().getActivePlayer(),SecondFrame.getField1());
			SecondFrame.field2.refreshMonstersArea(MyFrame.getBoard().getOpponentPlayer(),SecondFrame.getField2());
		    
			this.setVisible(false);
			this.revalidate();
			} 
			catch(WrongPhaseException e1){
				JOptionPane.showMessageDialog(this, "Wrong phase!");
			}
			catch (DefenseMonsterAttackException e2){
				JOptionPane.showMessageDialog(this, "You can't attack in defense mode!");
			}
			catch(MonsterMultipleAttackException exp){
				JOptionPane.showMessageDialog(this, "You cant attack twice with the same monster!");
			}
			}
			else {// el opp 3ando monsters
				MonsterCard attacker= m.getMonster();
				String[] monstersInOppMonstersArea = new String[5];	
				for(int i1 =0; i1<MyFrame.getBoard().getOpponentPlayer().getField().getMonstersArea().size();i1++){
					 monstersInOppMonstersArea [i1]= MyFrame.getBoard().getOpponentPlayer().getField().getMonstersArea().get(i1).getName();
				}
				MonsterCard attackON= getChoice(1,monstersInOppMonstersArea);
				//lazem eli yedeclare attack aw ay method yb2a el active player
				try{
					MyFrame.getBoard().getActivePlayer().getField().declareAttack(attacker, attackON);
					SecondFrame.lf1.setText("Player's LifePoints:"+ MyFrame.getBoard().getActivePlayer().getLifePoints());
					SecondFrame.lf2.setText("Player's LifePoints:"+ MyFrame.getBoard().getOpponentPlayer().getLifePoints());
					
					//SecondFrame.field1.removeAll();		
					PanelofCards active= new PanelofCards();
					SecondFrame.setField1(active);
				//SecondFrame.field1.refreshMonstersArea( MyFrame.getBoard().getActivePlayer(),SecondFrame.getField1());
				//SecondFrame.field2.refreshMonstersArea(MyFrame.getBoard().getOpponentPlayer(),SecondFrame.getField2());
				this.setVisible(false);
				this.revalidate();
				}catch(WrongPhaseException e1){
					JOptionPane.showMessageDialog(this, "Wrong phase!");
				}
				catch (DefenseMonsterAttackException e2){
					JOptionPane.showMessageDialog(this, "You can't attack in defense mode!");
				}
				catch(MonsterMultipleAttackException exp){
					JOptionPane.showMessageDialog(this, "You cant attack twice with the same monster!");
				}
				
			}
		}
		if(e.getSource()== switchMode){
			MonstersButtons m = (MonstersButtons) e.getSource();
			try{MyFrame.getBoard().getActivePlayer().getField().switchMonsterMode(m.getMonster());
			SecondFrame.lf1.setText("Player's LifePoints:"+ MyFrame.getBoard().getActivePlayer().getLifePoints());
			SecondFrame.lf2.setText("Player's LifePoints:"+ MyFrame.getBoard().getOpponentPlayer().getLifePoints());
			
			SecondFrame.field1.refreshMonstersArea( MyFrame.getBoard().getActivePlayer(),SecondFrame.getField1());
			SecondFrame.field2.refreshMonstersArea(MyFrame.getBoard().getOpponentPlayer(),SecondFrame.getField2());
			this.setVisible(false);
			this.revalidate();
			}
			catch(WrongPhaseException exp){
				JOptionPane.showMessageDialog(this, "Wrong phase!");
			}this.setVisible(false);
		}
		
		if(e.getSource()==activateSetSpell){
		// System.out.println("Happ");
			SpellsButtons s= (SpellsButtons)e.getSource();
			
			if(s.getSpell() instanceof ChangeOfHeart){//choose mons from opp and add it to you
				String[] monstersInMonstersArea = new String[5];
				for(int i1 =0; i1<MyFrame.getBoard().getOpponentPlayer().getField().getMonstersArea().size();i1++){
					 monstersInMonstersArea [i1]= MyFrame.getBoard().getOpponentPlayer().getField().getMonstersArea().get(i1).getName();
				}
				MonsterCard oppMonster= getChoiceOpp(1,monstersInMonstersArea);
			try{MyFrame.board.getOpponentPlayer().getField().activateSetSpell(s.getSpell(), oppMonster);
			SecondFrame.lf1.setText("Player's LifePoints:"+ MyFrame.getBoard().getActivePlayer().getLifePoints());
			SecondFrame.lf2.setText("Player's LifePoints:"+ MyFrame.getBoard().getOpponentPlayer().getLifePoints());
			
			SecondFrame.field1.refreshMonstersArea( MyFrame.getBoard().getActivePlayer(),SecondFrame.getField1());
			SecondFrame.field2.refreshMonstersArea(MyFrame.getBoard().getOpponentPlayer(),SecondFrame.getField2());
			this.revalidate();
			}catch(WrongPhaseException exp){
				JOptionPane.showMessageDialog(this, "Wrong phase!");
			}
			} if(s.getSpell() instanceof MagePower){//choose one mons from your field and it gains....
				String[] monstersInMonstersArea = new String[5];
				for(int i1 =0; i1<MyFrame.getBoard().getActivePlayer().getField().getMonstersArea().size();i1++){
					 monstersInMonstersArea [i1]= MyFrame.getBoard().getActivePlayer().getField().getMonstersArea().get(i1).getName();
				}
				MonsterCard LuckyMonster= getChoice(1,monstersInMonstersArea);
				try{
					MyFrame.getBoard().getOpponentPlayer().getField().activateSetSpell(s.getSpell(), LuckyMonster);
				SecondFrame.lf1.setText("Player's LifePoints:"+ MyFrame.getBoard().getActivePlayer().getLifePoints());
				SecondFrame.lf2.setText("Player's LifePoints:"+ MyFrame.getBoard().getOpponentPlayer().getLifePoints());
				
				SecondFrame.field1.refreshMonstersArea( MyFrame.getBoard().getActivePlayer(),SecondFrame.getField1());
				SecondFrame.field2.refreshMonstersArea(MyFrame.getBoard().getOpponentPlayer(),SecondFrame.getField2());
				// SecondFrame.field1.removeAll();
				 //SecondFrame.field2.removeAll();
				this.setVisible(false);
				this.revalidate();
				}catch(WrongPhaseException exp){
					JOptionPane.showMessageDialog(this, "Wrong phase!");
				}
			}
			else{//ay spell tanya
			try{	MyFrame.getBoard().getActivePlayer().getField().activateSetSpell(s.getSpell(), null);
			SecondFrame.lf1.setText("Player's LifePoints:"+ MyFrame.getBoard().getActivePlayer().getLifePoints());
			SecondFrame.lf2.setText("Player's LifePoints:"+ MyFrame.getBoard().getOpponentPlayer().getLifePoints());
			
			SecondFrame.field1.removeAll();
			 SecondFrame.field2.removeAll();
			//SecondFrame.field1.refreshMonstersArea( MyFrame.getBoard().getActivePlayer(),SecondFrame.getField1());
			//SecondFrame.field2.refreshMonstersArea(MyFrame.getBoard().getOpponentPlayer(),SecondFrame.getField2());
			this.setVisible(false);
			this.revalidate();
		
			}
			catch(WrongPhaseException exp){
				JOptionPane.showMessageDialog(this, "Wrong phase!");
			}
			}this.setVisible(false);
		}
		
	}

	private MonsterCard getChoiceOpp(int counter, String[] list) {
		MonsterCard result= new MonsterCard(); 
		for(int i =0; i< counter;i++){
			 
			 String s=(String)JOptionPane.showInputDialog(this,"Choose monsters to activate spell on","Monster Choice", JOptionPane.PLAIN_MESSAGE,null,list,list[0]);
		 
		 
		 for(int j=0; j< MyFrame.getBoard().getOpponentPlayer().getField().getMonstersArea().size();j++){
			 if(MyFrame.getBoard().getOpponentPlayer().getField().getMonstersArea().get(j).getName().equals(s)){
				 result=(MyFrame.getBoard().getOpponentPlayer().getField().getMonstersArea().get(j));
			 }
		 }
			 }
		 return result;

	}

	private MonsterCard getChoice(int counter, String[] list) {
	
		MonsterCard result= new MonsterCard();
		ArrayList<MonsterCard> sac= new ArrayList();
		 for(int i =0; i< counter;i++){
		    //ChooseFrame choose= new ChooseFrame(list);
			String s=(String)JOptionPane.showInputDialog(this,"Choose monster to perform action ON ","Monster Choice", JOptionPane.PLAIN_MESSAGE,null,list,list[0]);
		    System.out.println(s);
		 //hadawar 3l monster eli hwa e5taro fl monstersarea bet3t el opp
		    int size=MyFrame.getBoard().getOpponentPlayer().getField().getMonstersArea().size();
		 for(int j=0; j<size ;j++){
			 if(MyFrame.getBoard().getOpponentPlayer().getField().getMonstersArea().get(j).getName().equals(s)){
				 result=MyFrame.getBoard().getOpponentPlayer().getField().getMonstersArea().get(j);
				
			 }
		 }//System.out.println(result);
			 }
		 return result;
	
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	

}
