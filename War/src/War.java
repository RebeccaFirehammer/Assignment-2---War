import java.util.Scanner;

public class War {

	public static void main(String args[]){
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter A or B: ");
		String game = reader.next();
		
		if (game.equals("A")|| game.equals("a"))
			new GameA();
		else if (game.equals("B")|| game.equals("b"))
			new GameB();	
		else if (game.equals("C")|| game.equals("c"))
			new GameC();	
	}
}