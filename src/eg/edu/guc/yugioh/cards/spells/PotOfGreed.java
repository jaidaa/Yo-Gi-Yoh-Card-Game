package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class PotOfGreed extends SpellCard {

	public PotOfGreed(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	/*public PotOfGreed() {
		this("","");
		// TODO Auto-generated constructor stub
	}*/
    public void action(MonsterCard monster){
    	getBoard().getActivePlayer().getField().addNCardsToHand(2);
		
	}

}
