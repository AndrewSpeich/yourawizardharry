import java.util.Scanner;

public class GameRun 
{
	boolean tryAgain;
	int damageToPlayer;

	GuiCreate firstGUI = new GuiCreate();
	Scanner firstscan = new Scanner(System.in);
	UserInterface userI = new UserInterface();
	Player firstPlayer = new Player(userI.GetName());
	AI firstAI = new AI("Evil Wizard");
		
	public void RunGameAgainOnePlayer()
	{
			RunGameOnePlayer();
			System.out.print(" \nWould you like to play again?\n");
			if(userI.PlayAgain()){
				GameRun retry = new GameRun();
				retry.RunGameOnePlayer();
			}else{
				System.out.println("Fine be that way.");
			}		
	}
	
	public void RunGameOnePlayer()
	{
		while(!firstPlayer.isDead() && !firstAI.isDead()){
			
			RoundStart(userI.PlayerChoiceOne(), "Player1");
			firstPlayer.restoreMana();
			
			RoundStart(firstAI.AttackDecision(firstPlayer.health, firstAI.health),"AI");
			firstAI.restoreMana();
			}
		System.out.println(" \nGame Over.");
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
			if(playerName .equals("AI")){
				firstAI.healMe();
			}else
				firstPlayer.healMe();
			break;
		default:
			if(playerName .equals("AI")){
				firstAI.healMe();
			}else
				firstPlayer.healMe();
		}
	}
	
}
		

