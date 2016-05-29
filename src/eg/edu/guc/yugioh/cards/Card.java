package eg.edu.guc.yugioh.cards;

import eg.edu.guc.yugioh.board.Board;

public abstract class Card {
    private final String name;
    private final String description;
    private boolean isHidden;
    private Location location;
    private static Board board= new Board();

public Card(String name, String description){
	this.name = name;
	this.description = description;
	isHidden = true;
	location = Location.DECK;
	}

public Card (){
	this("","");
}


public String getName() {
	return name;
}





public String getDescription() {
	return description;
}



public boolean isHidden() {
	return isHidden;
}


public void setHidden(boolean isHidden) {
	this.isHidden = isHidden;
}

public Location getLocation() {
	return location;
}


public void setLocation(Location location) {
	this.location = location;
}


public static Board getBoard() {
	return board;
}


public static void setBoard(Board board) {
	Card.board = board;
}


public abstract void action(MonsterCard monster);


}
