package eg.edu.guc.yugioh.cards.spells;

import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class CardDestruction extends SpellCard {

	public CardDestruction(String name, String description) {
		super(name, description);
		
	}
	public ArrayList<Card> getshand1(){
	 return getBoard().getActivePlayer().getField().getHand();
	}
	public ArrayList<Card> getsgraveyard1(){
		 return getBoard().getActivePlayer().getField().getGraveyard();
		}
	public ArrayList<Card> getshand2(){
		 return getBoard().getOpponentPlayer().getField().getHand();
		}
		public ArrayList<Card> getsgraveyard2(){
			 return getBoard().getOpponentPlayer().getField().getGraveyard();
			}
	
	public void action(MonsterCard monster){
		int size2 = getBoard().getOpponentPlayer().getField().getHand().size();
		int size1 = getBoard().getActivePlayer().getField().getHand().size();
		 int counter1=0;
		 int counter2=0;
		for (int i =0; i<getBoard().getActivePlayer().getField().getHand().size(); ){
			getsgraveyard1().add(getshand1().remove(i));
			counter1=counter1+1;
		}
		
		for (int i =0; i<getBoard().getOpponentPlayer().getField().getHand().size(); ){
			getsgraveyard2().add(getshand2().remove(i));
			counter2=counter2+1;
		}
		
		getBoard().getActivePlayer().getField().addNCardsToHand(counter1);
		getBoard().getOpponentPlayer().getField().addNCardsToHand(counter2);
		
	
	}
	
	

}
