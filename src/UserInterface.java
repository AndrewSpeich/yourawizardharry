import java.util.Scanner;

public class UserInterface {
	
	Scanner firstscan = new Scanner(System.in);
	String replay;
	String name1;
	boolean playAgain;

	public String PlayerChoiceOne()
	{
		System.out.println(" \nWhat would you like to do?\n");
		System.out.print("Attack or Heal");
		String firstPlayerChoice = firstscan.next().toLowerCase();
		return firstPlayerChoice;
	}
	
	public String PlayerChoiceTwo()
	{	
		System.out.println(" \nWhat spell shall you yell?");
		System.out.println("Available spells - MagicMissle - RayofFrost - Fireball - RockSlide");
		String secondDecision = firstscan.next().toLowerCase();
		return secondDecision;
	}
	public boolean PlayAgain()
	{
		if(replay .equals("yes")){
			playAgain = true;
		}else{
			playAgain = false;
		}
		return playAgain;
	}
	public String GetName()
	{
		System.out.println("What's your name fool? ");
		name1 = firstscan.nextLine();
	return name1;
	}	
}