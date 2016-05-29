package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class HarpieFeatherDuster extends SpellCard {

	public HarpieFeatherDuster(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	public HarpieFeatherDuster() {
		// TODO Auto-generated constructor stub
	}
	public void action(MonsterCard monster){
	
		for (int i=0; i<getBoard().getOpponentPlayer().getField().getSpellArea().size();){
			SpellCard temp = getBoard().getOpponentPlayer().getField().getSpellArea().remove(i);
			getBoard().getOpponentPlayer().getField().getGraveyard().add(temp);
			temp.setLocation(Location.GRAVEYARD);
		}
	}

}
