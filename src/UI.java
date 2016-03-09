import java.util.Scanner;

public class UI {
	
	int damageToPlayer;
	Scanner firstscan = new Scanner(System.in);
	
	System.out.print("What's your name fool? ");
	Player user1 = new Player(firstscan.next());
	
	public String FirstDecision()
	{
		System.out.println("What would you like to do?\n");
		System.out.print("Attack or Heal");
		String firstDecision = firstscan.next();
		return firstDecision;
	}
	public void SecondDecision()
	{	
		String secondDecision = firstscan.next().toLowerCase();
		user1.castSpell(secondDecision);
		}
	}
	
		
}
