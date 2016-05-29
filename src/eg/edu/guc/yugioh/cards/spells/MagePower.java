package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.MonsterCard;

public class MagePower extends SpellCard {

	public MagePower(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	public MagePower() {
		// TODO Auto-generated constructor stub
	}
	public void action(MonsterCard monster){
		
		int numberOfSpellCards=getBoard().getActivePlayer().getField().getSpellArea().size();
		int ATK=monster.getAttackPoints();
		monster.setAttackPoints(ATK+(500*numberOfSpellCards));
		int DFS=monster.getDefensePoints();
		monster.setDefensePoints(DFS+(500*numberOfSpellCards));
	}

}

