package eg.edu.guc.yugioh.board.player;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.board.player.Field;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.CardDestruction;
import eg.edu.guc.yugioh.cards.spells.ChangeOfHeart;
import eg.edu.guc.yugioh.cards.spells.DarkHole;
import eg.edu.guc.yugioh.cards.spells.GracefulDice;
import eg.edu.guc.yugioh.cards.spells.HarpieFeatherDuster;
import eg.edu.guc.yugioh.cards.spells.HeavyStorm;
import eg.edu.guc.yugioh.cards.spells.MagePower;
import eg.edu.guc.yugioh.cards.spells.MonsterReborn;
import eg.edu.guc.yugioh.cards.spells.PotOfGreed;
import eg.edu.guc.yugioh.cards.spells.Raigeki;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.exceptions.EmptyFieldException;
import eg.edu.guc.yugioh.exceptions.MissingFieldException;
import eg.edu.guc.yugioh.exceptions.UnexpectedFormatException;
import eg.edu.guc.yugioh.exceptions.UnknownCardTypeException;
import eg.edu.guc.yugioh.exceptions.UnknownSpellCardException;

public class Deck {
	private static ArrayList<Card> monsters;
    private static ArrayList<Card> spells;
	private final ArrayList<Card> deck;
	private static String monstersPath = "Database-Monsters.csv";
	private static String spellsPath = "Database-Spells.csv";
	private int exc=1;
	BufferedReader scanner;
	
	
	public static ArrayList<Card> loadFileSpells(String path) throws IOException, MissingFieldException, EmptyFieldException, UnknownCardTypeException, UnknownSpellCardException{
		if(path == null)
			throw new FileNotFoundException("");
		
		ArrayList<Card> result = new ArrayList<Card>();
	
		String [] string = null;
        String currentLine = "";
        FileReader fileReader= new FileReader(path);
        BufferedReader br = new BufferedReader(fileReader);
        int RowNumber=0;
        
        while ((currentLine = br.readLine()) != null) {
        	RowNumber+=1;
        string = currentLine.split(",");
        
        if(!string[0].equals("Spell")){
        	throw new UnknownCardTypeException(path,RowNumber,string[0]);
        }
        
        if(string.length!=3){
    	   throw new MissingFieldException(path,RowNumber);
       }
       //2D array each row is J each colo is i
        for(int i=0;i<string.length;i++){
        	if(string[i].isEmpty() || string[i].equalsIgnoreCase(" "))
        		throw new EmptyFieldException(path,RowNumber,i+1);
        }
       
      
        	
        switch(string[1]){
        case"Card Destruction": CardDestruction spell= new CardDestruction (string[1],string[2]);result.add(spell);break;
        case"Change Of Heart":  ChangeOfHeart spell1= new ChangeOfHeart  (string[1],string[2]);result.add(spell1);break;
        case"Dark Hole": DarkHole spell2= new DarkHole (string[1],string[2]);result.add(spell2);break;
        case"Graceful Dice": GracefulDice spell3= new GracefulDice (string[1],string[2]);result.add(spell3);break;
        case"Harpie's Feather Duster": HarpieFeatherDuster spell4= new HarpieFeatherDuster (string[1],string[2]);result.add(spell4);break;
        case"Heavy Storm":  HeavyStorm spell5= new HeavyStorm(string[1],string[2]);result.add(spell5);break;
        case"Mage Power": MagePower spell6= new MagePower (string[1],string[2]);result.add(spell6);break;
        case"Monster Reborn": MonsterReborn spell7= new MonsterReborn (string[1],string[2]);result.add(spell7);break;
        case"Pot of Greed": PotOfGreed spell8= new PotOfGreed (string[1],string[2]);result.add(spell8);break;
        case"Raigeki": Raigeki spell9= new Raigeki (string[1],string[2]);result.add(spell9);break;
        default:throw new UnknownSpellCardException(path,RowNumber,string[1]);
        }
          
        
        }
		      
        return result;
		
}
	public static boolean helperNameSpell(String [] string){
		switch(string[1]){
        case"Card Destruction": return true;
        case"Change Of Heart":  return true;
        case"Dark Hole": return true;
        case"Graceful Dice": return true;
        case"Harpie's Feather Duster": return true;
        case"Heavy Storm": return true;
        case"Mage Power": return true;
        case"Monster Reborn": return true;
        case"Pot of Greed": return true;
        case"Raigeki": return true;
        default: return false;
        }
	}
	   
	public Deck() throws  IOException, MissingFieldException,UnexpectedFormatException, EmptyFieldException, UnknownCardTypeException {
		deck = new ArrayList<Card>();
	    scanner = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int i=0; i<4; i++){
		try{
			Deck.monsters=loadCardsFromFile(monstersPath);
			break;
		}   
		catch (FileNotFoundException e){
			if(i==3){
				throw e;
			}
			else {
				System.out.println("file not found monster");
				System.out.println("Please enter coorect");
					monstersPath = scanner.readLine();
			}
		}
		catch(EmptyFieldException e1){
			if(i==3){
				throw e1;
			}else{
				System.out.println("empty");
				System.out.println("Please enter correct path");
			
				monstersPath = scanner.readLine();
			}
		}
		catch(MissingFieldException e2){
			if(i==3){
				throw e2;
			}else{
				System.out.println("missing field");
				System.out.println("Please enter correct path");
				monstersPath = scanner.readLine();
			}
		}
		catch(UnknownCardTypeException e3){
			if(i==3){
				throw e3;
			}else{
				System.out.println("unknown type monster");
				System.out.println("Please enter correct path");
				monstersPath = scanner.readLine();
			}
		}
		}	
		
		

		
		for(int i=0; i<4; i++){
		try{
			Deck.spells=loadFileSpells(spellsPath);
			break;
		}   
		catch (FileNotFoundException e){
			if(i==3){
				throw e;
			}
			else {
				System.out.print("file not found spell");
				System.out.println("Please enter correct path");
				spellsPath = scanner.readLine();
			}
		}
		catch(EmptyFieldException e1){
			if(i==3){
				throw e1;
			}else{
				System.out.println("empty field spell");
				System.out.println("Please enter correct path");
				spellsPath = scanner.readLine();
			}
		}
		catch(MissingFieldException e2){
			if(i==3){
				throw e2;
			}else{
				System.out.println("missing field spell");
				System.out.println("Please enter correct path");
				spellsPath = scanner.readLine();
			}
		}
		catch(UnknownCardTypeException e3){
			
			if(i==3){
				throw e3;
			}else{
				System.out.println("unknown type s");
				System.out.println("Please enter correct path");
				spellsPath = scanner.readLine();
			}
			
		}
		catch(UnknownSpellCardException e4){
			if(i==3){
				throw e4;
			}else{
				System.out.println("unknown spell type");
				System.out.println("Please enter correct path");
				spellsPath = scanner.readLine();
			}
		}
		}	
		
		buildDeck(monsters,spells);
		shuffleDeck();
		}
	
	private void buildDeck(ArrayList<Card> Monsters, ArrayList<Card> Spells) {

		int monstersQouta = 15;
		int spellsQouta = 5;

		Random r = new Random();

		for (; monstersQouta > 0; monstersQouta--) {

			MonsterCard monster = (MonsterCard) monsters.get(r.nextInt(monsters
					.size()));

			MonsterCard clone = new MonsterCard(monster.getName(),
					monster.getDescription(), monster.getLevel(),
					monster.getAttackPoints(), monster.getDefensePoints());
			clone.setMode(monster.getMode());
			clone.setHidden(monster.isHidden());
			clone.setLocation(Location.DECK);

			deck.add(clone);

		}

		for (; spellsQouta > 0; spellsQouta--) {
              
              
            		  
			Card spell = spells.get(r.nextInt(spells.size()));

			SpellCard clone;

			if (spell instanceof CardDestruction) {

				clone = new CardDestruction(spell.getName(),
						spell.getDescription());
				clone.setLocation(Location.DECK);
				deck.add(clone);
				continue;

			}

			if (spell instanceof ChangeOfHeart) {

				clone = new ChangeOfHeart(spell.getName(),
						spell.getDescription());
				clone.setLocation(Location.DECK);
				deck.add(clone);
				continue;

			}

			if (spell instanceof DarkHole) {

				clone = new DarkHole(spell.getName(), spell.getDescription());
				clone.setLocation(Location.DECK);
				deck.add(clone);
				continue;

			}

			if (spell instanceof GracefulDice) {

				clone = new GracefulDice(spell.getName(),
						spell.getDescription());
				clone.setLocation(Location.DECK);
				deck.add(clone);
				continue;

			}

			if (spell instanceof HarpieFeatherDuster) {

				clone = new HarpieFeatherDuster(spell.getName(),
						spell.getDescription());
				clone.setLocation(Location.DECK);
				deck.add(clone);
				continue;

			}

			if (spell instanceof HeavyStorm) {

				clone = new HeavyStorm(spell.getName(), spell.getDescription());
				clone.setLocation(Location.DECK);
				deck.add(clone);
				continue;

			}

			if (spell instanceof MagePower) {

				clone = new MagePower(spell.getName(), spell.getDescription());
				clone.setLocation(Location.DECK);
				deck.add(clone);
				continue;

			}

			if (spell instanceof MonsterReborn) {

				clone = new MonsterReborn(spell.getName(),
						spell.getDescription());
				clone.setLocation(Location.DECK);
				deck.add(clone);
				continue;

			}

			if (spell instanceof PotOfGreed) {

				clone = new PotOfGreed(spell.getName(), spell.getDescription());
				clone.setLocation(Location.DECK);
				deck.add(clone);
				continue;

			}

			if (spell instanceof Raigeki) {

				clone = new Raigeki(spell.getName(), spell.getDescription());
				clone.setLocation(Location.DECK);
				deck.add(clone);
				continue;

			}

		}

	}
	/*private void buildDeck(ArrayList<Card> monsters1, ArrayList<Card> spells1){
		ArrayList<Card> monsters=Clone(monsters1);
		ArrayList<Card> spells=Clone(spells1);
		
		int m1= spells1.size();
		int count=0;
		for(int i = 0; i<m1; i++){
			int j = (int)Math.floor ( (Math.random()*spells1.size()));
			SpellCard tmp=(SpellCard)spells.get(j);
			deck.add(i,spells.get(j)); 
			count=i;
			}
		int s= monsters1.size();
		
		for(int i =0; i<s; i++){
			int j = (int)Math.floor( (Math.random()*monsters1.size()));
			MonsterCard m=(MonsterCard)monsters.get(j);
			deck.add(count,monsters.get(j));
			count++;
			
		}
		}*/
	
	public ArrayList<Card> loadCardsFromFile(String path) throws  IOException, MissingFieldException, EmptyFieldException, UnknownCardTypeException{
	
		if(path == null)
			throw new FileNotFoundException("");
		
		ArrayList<Card> result = new ArrayList<Card>();
		String [] string = null;
        String currentLine = "";
        FileReader fileReader= new FileReader(path);
        BufferedReader br = new BufferedReader(fileReader);
        int RowNumber=0;
        while ((currentLine = br.readLine()) != null) {
        	RowNumber+=1;
        string = currentLine.split(",");
        if(!string[0].equals("Monster")){
        	throw new UnknownCardTypeException(path,RowNumber,string[0]);
        }
        if(string.length<6){
     	   throw new MissingFieldException(path,RowNumber);
        }
        
        //2D array each row is J each colo is i
            for(int i=0;i<string.length;i++){
            	if(string[i].isEmpty() || string[i].equalsIgnoreCase(" "))
            		throw new EmptyFieldException(path,RowNumber,i+1);
            }
            if(!string[0].equals("Monster")){
            	throw new UnknownCardTypeException(path,RowNumber,string[0]);
            }
            
        
        if(string[0].equals("Monster")){
        
        	int attack=Integer.parseInt(string[3]);
        int defense=Integer.parseInt(string[4]);
        int level=Integer.parseInt(string[5]);
        MonsterCard monster= new MonsterCard(string[1],string[2],level,attack,defense);
        result.add(monster);
        
        
		}
    
        }
     
        
        return result;
        }
		
	
	public ArrayList<Card> getDeck() {
		return deck;
	}
	private void shuffleDeck(){
		Collections.shuffle(deck);
		}
	
	/*public static ArrayList<Card> Clone(ArrayList<Card> list) {
	    ArrayList<Card> copy = new ArrayList<Card>(list.size());
	    int s=list.size();
	    for(int i=0;i<s;i++){
	    	Card temp=list.get(i);
	    	if (temp instanceof MonsterCard){
	    		String name=temp.getName();
	    		String description=temp.getDescription();
	    		int level=((MonsterCard) temp).getLevel();
	    		int defense= ((MonsterCard) temp).getDefensePoints();
	    		int attack=((MonsterCard) temp).getAttackPoints();
	    		
	    		
	    		MonsterCard monster=new MonsterCard(name,description,level,attack,defense);
	    		copy.add(monster);
	    	}
	    	else{
	    		String name=temp.getName();
	    		String descrip=temp.getDescription();
	    		switch (temp.getName()){
	    		case("Card Destruction"):CardDestruction spell1=new CardDestruction(name,descrip);copy.add(spell1);break;
				case("Change Of Heart"): ChangeOfHeart spell2=new ChangeOfHeart(name,descrip);copy.add(spell2);break;
				case("Dark Hole"): DarkHole spell3=new DarkHole(name,descrip);copy.add(spell3);break;
				case("Graceful Dice"):GracefulDice spell4=new GracefulDice(name,descrip);copy.add(spell4);break;
				case("Harpie's Feather Duster"):HarpieFeatherDuster spell5= new HarpieFeatherDuster(name,descrip);copy.add(spell5);break;
				case("Heavy Storm"): HeavyStorm spell6=new HeavyStorm(name,descrip);copy.add(spell6);break;
				case("Mage Power"):MagePower spell7=new MagePower(name,descrip);copy.add(spell7);break;
				case("Monster Reborn"):MonsterReborn spell8=new MonsterReborn(name,descrip);copy.add(spell8);break;
				case("Pot of Greed"):PotOfGreed spell9= new PotOfGreed(name,descrip);copy.add(spell9);break;
				case("Raigeki"):Raigeki spell10=new Raigeki(name,descrip);copy.add(spell10);break;
	    		
	    		}
	    	}
	    	
	    }
	    return copy;
	}*/
	
	public ArrayList<Card> drawNCards(int n){
		ArrayList<Card> cardsdrawn = new ArrayList<Card>(n);
		for(int i=0; i<n; i++){
			if(Card.getBoard().getActivePlayer().getField().getDeck().isEmpty()){
	        	Card.getBoard().setWinner(Card.getBoard().getOpponentPlayer());
	        	Card.getBoard().setGame(true);
	        	return null;
			}
			else {
				this.getDeck().get(0).setLocation(Location.DECK);
		         cardsdrawn.add(drawOneCard());
		}
		}
		
		return cardsdrawn; 
	}
	
	
      public Card drawOneCard(){
    	  if(!deck.isEmpty()){
    	  return deck.remove(0);
    	  }
    	   return null;
    	   }
	public static ArrayList<Card> getMonsters() {
		return monsters;
	}
	public static void setMonsters(ArrayList<Card> monsters) {
		Deck.monsters = monsters;
	}
	public static ArrayList<Card> getSpells() {
		return spells;
	}
	public static void setSpells(ArrayList<Card> spells) {
		Deck.spells = spells;
	}
	public boolean isEmpty() {
	  if(getDeck().size()==0)
		  return true;
	  else
		return false;
	}
	   public static String getMonstersPath() {
			return monstersPath;
		}

		public static void setMonstersPath(String monstersPath) {
			Deck.monstersPath = monstersPath;
		}

		public static String getSpellsPath() {
			return spellsPath;
		}

		public static void setSpellsPath(String spellsPath) {
			Deck.spellsPath = spellsPath;
		}
		public static void main(String[] args) throws MissingFieldException, EmptyFieldException, UnknownCardTypeException, IOException, UnexpectedFormatException {
			Deck d=new Deck();
		}
  }
