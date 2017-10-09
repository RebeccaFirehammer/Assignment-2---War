package gamePlay;
import java.util.Scanner;

public class Driver {

	public static void main(String args[]){
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter A, B, or C: ");
		String game = reader.next();
		War war;
		
		if (game.equals("A")|| game.equals("a"))
			war = new GameA();
		else if (game.equals("B")|| game.equals("b"))
			war = new GameB();	
		else if (game.equals("C")|| game.equals("c"))
			war = new GameC();	
	}
}