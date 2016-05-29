package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.MonsterCard;

public class GracefulDice extends SpellCard {

	public GracefulDice(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	public GracefulDice() {
		this("","");
		// TODO Auto-generated constructor stub
	}
	public void action(MonsterCard monster){
		int no = (int) (Math.random()*9);
		if (no==0){
			no = 10;
		}
		int size =getBoard().getActivePlayer().getField().getMonstersArea().size();
		for(int i=0;i<size;i++){
			int DFS=getBoard().getActivePlayer().getField().getMonstersArea().get(i).getDefensePoints();
			getBoard().getActivePlayer().getField().getMonstersArea().get(i).setDefensePoints(DFS+(no*100));
		    int ATK=getBoard().getActivePlayer().getField().getMonstersArea().get(i).getAttackPoints();
		    getBoard().getActivePlayer().getField().getMonstersArea().get(i).setAttackPoints(ATK+(no*100));
		}
		
	}

}
