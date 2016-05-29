package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class HeavyStorm extends HarpieFeatherDuster {

	public HeavyStorm(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	public HeavyStorm() {
		// TODO Auto-generated constructor stub
	}
	public void action(MonsterCard monster){
		super.action(null);
		for (int i=0; i<getBoard().getActivePlayer().getField().getSpellArea().size();){
			SpellCard temp = getBoard().getActivePlayer().getField().getSpellArea().remove(i);
			getBoard().getActivePlayer().getField().getGraveyard().add(temp);
			temp.setLocation(Location.GRAVEYARD);
		}
	}
}
