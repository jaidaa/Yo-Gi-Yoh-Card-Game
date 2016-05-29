package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.MonsterCard;

public class DarkHole extends Raigeki {

	public DarkHole(String name, String description) {
		super(name,description);
		// TODO Auto-generated constructor stub
	}
	public void action(MonsterCard monster){
		super.action(null);
		
			for (int i=0; i<getBoard().getActivePlayer().getField().getMonstersArea().size(); ){
				MonsterCard temp = getBoard().getActivePlayer().getField().getMonstersArea().remove(i);
				getBoard().getActivePlayer().getField().getGraveyard().add(temp);
			}
			
		}
}
