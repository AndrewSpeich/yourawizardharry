import java.util.Scanner;

public class UI 
{
	
	int damageToPlayer;
	String name1;
	
	Player1 firstPlayer = new Player1(GetName());
	AI firstAI = new AI("Evi Wizard");
	Scanner firstscan = new Scanner(System.in);
	
	
	public void RunGameOnePlayer()
	{
		while(firstPlayer.health>0 && firstAI.health>0){
			
			RoundStart(PlayerChoiceOne(), "Player1");
			RoundStart(firstAI.AttackDecision(firstPlayer.health, firstAI.health),"AI");
		}
		
	}
	
	public String GetName()
	{
		System.out.println("What's your name fool? ");
		name1 = firstscan.next();
	return name1;
	}	
	public void RoundStart(String attackChoice, String playerName)
	{
		
		switch(attackChoice){
		case"attack":
			PlayerOrAISpell(playerName);
			break;
		case"heal":
			firstPlayer.healMe();
			break;
		default:
			firstPlayer.healMe();
		}
				
	}
	public String PlayerChoiceOne()
	{
		System.out.println("What would you like to do?\n");
		System.out.print("Attack or Heal");
		String firstPlayerChoice = firstscan.next().toLowerCase();
		return firstPlayerChoice;
	}
	public String PlayerChoiceTwo()
	{	
		System.out.println("What spell shall you yell?");
		System.out.println("Available spells - MagicMissle - RayofFrost - Fireball - RockSlide");
		String secondDecision = firstscan.next().toLowerCase();
		return secondDecision;
	}
	public void PlayerOrAISpell(String whichPlayer)
	{
		switch(whichPlayer){
		case"AI":
			firstAI.castSpell(firstAI.SpellDecision());
			break;
		case"Player1":
			firstPlayer.castSpell(PlayerChoiceTwo());
		}
	}
	
}
		

