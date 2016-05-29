package eg.edu.guc.yugioh.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;

 public class SpellsButtons extends JButton implements MouseListener {
	SpellCard spell;
	
	public SpellCard getSpell() {
		return spell;
	}

	public void setSpell(SpellCard spell) {
		this.spell = spell;
	}

	public SpellsButtons(SpellCard sp) {
		spell=sp;
		this.setName(sp.getName());
	}

	public SpellsButtons() {
		// TODO Auto-generated constructor stub
	}

	public SpellsButtons(Icon icon) {
		super(icon);
		// TODO Auto-generated constructor stub
	}

	public SpellsButtons(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}

	public SpellsButtons(Action a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	public SpellsButtons(String text, Icon icon) {
		super(text, icon);
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
