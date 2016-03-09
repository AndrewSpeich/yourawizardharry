import java.util.Scanner;

public class UI 
{
	
	int damageToPlayer;
	String name1;

	Scanner firstscan = new Scanner(System.in);
	
	public String GetName()
	{
		System.out.println("What's your name fool? ");
		name1 = firstscan.nextLine();
	return name1;
	}	
	Player firstPlayer = new Player(GetName());
	AI firstAI = new AI("Evil Wizard");
	
	public void RunGameOnePlayer()
	{
		while(firstPlayer.health>0 && firstAI.health>0){
			
			RoundStart(PlayerChoiceOne(), "Player1");
			
			RoundStart(firstAI.AttackDecision(firstPlayer.health, firstAI.health),"AI");
		}
		
	}
	
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
	
	public void PlayerOrAISpell(String whichPlayer)
	{
		int damagetoOpponent;
		String AIspell = firstAI.SpellDecision();
		switch(whichPlayer){
		case"AI":
			damagetoOpponent = firstAI.castSpell(AIspell);
			firstPlayer.health -= damagetoOpponent;
			System.out.println(" \nYou have been hurt by a level " + damagetoOpponent + " "
					+ AIspell + "\nYour current health is " + firstPlayer.health);
			break;
		case"Player1":
			damagetoOpponent = firstPlayer.castSpell(PlayerChoiceTwo());
			firstAI.health -= damagetoOpponent;
			System.out.println(" \nYou hit your opponent! \nYou did " + damagetoOpponent + " damage.\n"
					+ "Your opponents remaining heath is " + firstAI.health + "\n ");
			break;
		default:
			System.out.println("error error in PlayerOrAISpell");
			break;
		}
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
	
}
		

