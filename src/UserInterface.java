import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
	
	Scanner firstscan = new Scanner(System.in);
	String replay;
	String name1;
	boolean playAgain;
	String opponentchoice;

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
		System.out.println("Available spells - MagicMissile - RayofFrost - Fireball - RockSlide");
		String secondDecision = firstscan.next().toLowerCase();
		return secondDecision;
	}
	public boolean PlayAgain()
	{
		replay = firstscan.next().toLowerCase();
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
	public String opponentChoice(ArrayList<Player> wholeList)
	{
		System.out.println("Which one shall you attack?\n");
		for(int i=0;i<wholeList.size();i++){
			System.out.println(wholeList.get(i));
		}
		opponentchoice = firstscan.next().toLowerCase();
		return opponentchoice;
	}
}