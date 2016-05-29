package eg.edu.guc.yugioh.cards;

public class MonsterCard extends Card {
	private int level;
	private int defensePoints;
	private int attackPoints;
	private Mode mode;
	private boolean attackFlag;
	private boolean switchmons;

	public boolean isSwitchmons() {
		return switchmons;
	}
	public void setSwitchmons(boolean switchmons) {
		this.switchmons = switchmons;
	}
	public MonsterCard(String name, String description, int level, int attack, int defence){
		super(name, description);
		this.level = level;
		attackPoints = attack;
		defensePoints = defence;
		mode = Mode.DEFENSE;

	}
	public boolean isAttackFlag() {
		return attackFlag;
	}
	public void setAttackFlag(boolean attackFlag) {
		this.attackFlag = attackFlag;
	}
	public MonsterCard(){
		this("","",0,0,0);
	}
	public int getLevel() {
		return level;
	}


	public String toString(){

		return(this.getName());

	}



	public int getDefensePoints() {
		return defensePoints;
	}

	public void setDefensePoints(int defensePoints) {
		this.defensePoints = defensePoints;
	}

	public int getAttackPoints() {
		return attackPoints;
	}

	public void setAttackPoints(int attackPoints) {
		this.attackPoints = attackPoints;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}


	public void action(MonsterCard monster){
		if(this.getMode()==Mode.ATTACK){
			if(monster.getMode()==Mode.ATTACK){
				if(this.getAttackPoints() > monster.getAttackPoints()){
					Card.getBoard().getOpponentPlayer().getField().removeMonsterToGraveyard(monster);
					int diff=this.getAttackPoints()-monster.getAttackPoints();
					Card.getBoard().getOpponentPlayer().setLifePoints(Card.getBoard().getOpponentPlayer().getLifePoints()-diff);
				}
				else if(this.getAttackPoints() == monster.getAttackPoints()){
					Card.getBoard().getOpponentPlayer().getField().removeMonsterToGraveyard(monster);
					Card.getBoard().getActivePlayer().getField().removeMonsterToGraveyard(this);
				}
				else {
					//System.out.println(Card.getBoard().getOpponentPlayer().getLifePoints());
					Card.getBoard().getActivePlayer().getField().removeMonsterToGraveyard(this);
					int diff=monster.getAttackPoints()-this.getAttackPoints();
					Card.getBoard().getActivePlayer().setLifePoints(Card.getBoard().getActivePlayer().getLifePoints()-diff);
					
				}
			}
			//defense
			else{
				if(monster.getMode()==Mode.DEFENSE){
					if(this.getAttackPoints()>monster.getDefensePoints()){
						Card.getBoard().getOpponentPlayer().getField().removeMonsterToGraveyard(monster);
					}
					else if(this.getAttackPoints()<monster.getDefensePoints()){
						int diff=monster.getDefensePoints()-this.getAttackPoints();
						Card.getBoard().getActivePlayer().setLifePoints(Card.getBoard().getActivePlayer().getLifePoints()-diff);

					}
				}
			}
		}

	}
	public void action(){
		if(Card.getBoard().getOpponentPlayer().getField().getMonstersArea().isEmpty())
		Card.getBoard().getOpponentPlayer().setLifePoints(Card.getBoard().getOpponentPlayer().getLifePoints()-this.getAttackPoints());
	}
	public void switchMode() {

		if (mode == Mode.ATTACK) {

			mode = Mode.DEFENSE;
			setHidden(true);

		} else {

			mode = Mode.ATTACK;
			setHidden(false);

		}
	}
	
}
