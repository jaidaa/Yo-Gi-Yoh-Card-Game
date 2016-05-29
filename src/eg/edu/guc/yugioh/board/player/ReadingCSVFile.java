package eg.edu.guc.yugioh.board.player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.Card;
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

public class ReadingCSVFile {

	public static ArrayList<Card> loadFileMonster(String path) throws IOException{
		ArrayList<Card> result = new ArrayList<Card>(30);
		String [] string = null;
        String currentLine = "";
        FileReader fileReader= new FileReader(path);
        BufferedReader br = new BufferedReader(fileReader);
        while ((currentLine = br.readLine()) != null) {
        string = currentLine.split(",");
        int attack=Integer.parseInt(string[3]);
        int defense=Integer.parseInt(string[4]);
        int level=Integer.parseInt(string[5]);
        MonsterCard monster= new MonsterCard(string[1],string[2],attack,defense,level);
        result.add(monster);
        }
        
        return result;

}
	
	public static ArrayList<Card> loadFileSpells(String path) throws IOException{
		ArrayList<Card> result = new ArrayList<Card>(10);
		String [] string = null;
        String currentLine = "";
        FileReader fileReader= new FileReader(path);
        BufferedReader br = new BufferedReader(fileReader);
        while ((currentLine = br.readLine()) != null) {
        string = currentLine.split(",");
        switch(string[1]){
        case"CardDestruction": CardDestruction spell= new CardDestruction (string[1],string[2]);result.add(spell);break;
        case"ChangeOfHeart":  ChangeOfHeart spell1= new ChangeOfHeart  (string[1],string[2]);result.add(spell1);break;
        case"DarkHole": DarkHole spell2= new DarkHole (string[1],string[2]);result.add(spell2);break;
        case"GracefulDice": GracefulDice spell3= new GracefulDice (string[1],string[2]);result.add(spell3);break;
        case"HarpieFeatherDuster": HarpieFeatherDuster spell4= new HarpieFeatherDuster (string[1],string[2]);result.add(spell4);break;
        case"HeavyStorm":  HeavyStorm spell5= new HeavyStorm(string[1],string[2]);result.add(spell5);break;
        case"MagePower": MagePower spell6= new MagePower (string[1],string[2]);result.add(spell6);break;
        case"MonsterReborn": MonsterReborn spell7= new MonsterReborn (string[1],string[2]);result.add(spell7);break;
        case"PotOfGreed": PotOfGreed spell8= new PotOfGreed (string[1],string[2]);result.add(spell8);break;
        case"Raigeki": Raigeki spell9= new Raigeki (string[1],string[2]);result.add(spell9);break;
        default:break;
        }
          
        
        }
        
        return result;

}
	
	
	
	
	
}

