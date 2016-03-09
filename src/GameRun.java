import java.util.Scanner;

public class GameRun 
{
	boolean tryAgain;
	int damageToPlayer;

	Scanner firstscan = new Scanner(System.in);
	UserInterface userI = new UserInterface();
	Player firstPlayer = new Player(userI.GetName());
	AI firstAI = new AI("Evil Wizard");
		
	public void RunGameOver()
	{
		while(tryAgain)
		{
			GameRun retry = new GameRun();
			retry.RunGameOnePlayer();
			System.out.print(" \nWould you like to play again?");
			userI.PlayAgain();
		}
		
	}
	
	public void RunGameOnePlayer()
	{
		while(firstPlayer.health>0 && firstAI.health>0){
			
			RoundStart(userI.PlayerChoiceOne(), "Player1");
			firstPlayer.restoreMana();
			
			RoundStart(firstAI.AttackDecision(firstPlayer.health, firstAI.health),"AI");
			firstAI.restoreMana();
			}
		
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
			damagetoOpponent = firstPlayer.castSpell(userI.PlayerChoiceTwo());
			firstAI.health -= damagetoOpponent;
			System.out.println(" \nYou hit your opponent! \nYou did " + damagetoOpponent + " damage.\n"
					+ "Your opponents remaining heath is " + firstAI.health);
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
		

