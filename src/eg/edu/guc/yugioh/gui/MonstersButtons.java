package eg.edu.guc.yugioh.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

import eg.edu.guc.yugioh.cards.Mode;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class MonstersButtons extends JButton implements MouseListener{
 MonsterCard monster;
 
	public MonsterCard getMonster() {
	return monster;
}

public void setMonster(MonsterCard monster) {
	this.monster = monster;
}

	public MonstersButtons() {
		// TODO Auto-generated constructor stub
	}
	
	public MonstersButtons( MonsterCard mons){
		monster=mons;
		//this.setName(mons.getName());
		if(mons.isHidden()==false){
			this.setName(mons.getName());
		}
		else this.setName("Hidden");
		
	}

	public MonstersButtons(Icon arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public MonstersButtons(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public MonstersButtons(Action arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public MonstersButtons(String arg0, Icon arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
