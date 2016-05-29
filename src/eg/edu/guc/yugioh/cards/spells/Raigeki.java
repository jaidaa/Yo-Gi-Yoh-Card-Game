package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class Raigeki extends SpellCard {

	public Raigeki(String name, String description) {
		super(name, description);
		
	}

	public Raigeki() {
		this("","");
		
	}
	public void action(MonsterCard monster){
		
		for (int i=0; i<getBoard().getOpponentPlayer().getField().getMonstersArea().size();){
			MonsterCard temp = getBoard().getOpponentPlayer().getField().getMonstersArea().remove(i);
			getBoard().getOpponentPlayer().getField().getGraveyard().add(temp);
			temp.setLocation(Location.GRAVEYARD);
		
		}
	}

}
