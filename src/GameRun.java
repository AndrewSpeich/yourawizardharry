import java.util.ArrayList;
import java.util.Scanner;

public class GameRun 
{
	boolean tryAgain;
	int damageToPlayer;

	
	Scanner firstscan = new Scanner(System.in);
	UserInterface userI = new UserInterface();
	Player firstPlayer ;
	AI firstAI = new AI("Evil Wizard");
	ArrayList<Player> playerlist = new ArrayList<>();
	
	
	public void chooseGameType(){
		System.out.println("Welcome! Singleplayer, or Multiplayer");
		if(firstscan.nextLine().equalsIgnoreCase("Multiplayer")){
			runGameTwoPlayer();
		}else
		{
			RunGameOnePlayer();
		}
	}
		
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
		firstPlayer = new Player(userI.GetName());
		while(!firstPlayer.isDead() && !firstAI.isDead()){
			
			RoundStart(userI.PlayerChoiceOne(), "Player1");
			firstPlayer.restoreMana();
			
			RoundStart(firstAI.AttackDecision(firstPlayer.health, firstAI.health),"AI");
			firstAI.restoreMana();
			}
		System.out.println(" \nGame Over.");
	}
	public void runGameTwoPlayer(){
		
		for(int i = 0; i<2; i++){
			playerlist.add(new Player(userI.GetName()));
		}
		while(!( playerlist.get(0).isDead())&&!( playerlist.get(1).isDead())){
			
			System.out.print(playerlist.get(0).name+" ") ;
			RoundStartMulti(userI.PlayerChoiceOne(), "Player1");
			playerlist.get(0).restoreMana();
			
			System.out.print(playerlist.get(1).name+" ") ;
			RoundStartMulti(userI.PlayerChoiceOne(),"Player2");
			playerlist.get(1).restoreMana();
			
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
	public void RoundStartMulti(String attackChoice, String playerName)
	{
		
		switch(attackChoice){
		case"attack":
			MultiplayerSpell(playerName);
			break;
		case"heal":
			if(playerName .equals("Player2")){
				playerlist.get(1).healMe();
			}else
				playerlist.get(0).healMe();
			break;
		default:
			if(playerName .equals("Player2")){
				playerlist.get(1).healMe();
			}else
				playerlist.get(0).healMe();
		}
	}
	public void MultiplayerSpell(String whichPlayer)
	{
		int damagetoOpponent;
		String spellchoice;
		
		switch(whichPlayer){
		case"Player2":
			 spellchoice = userI.PlayerChoiceTwo();
			damagetoOpponent = playerlist.get(1).castSpell(spellchoice);
			playerlist.get(0).health -= damagetoOpponent;
			System.out.println(" \nYou have been hurt by a level " + damagetoOpponent + " "
					+ spellchoice + "\nYour current health is " + playerlist.get(0).health);
			break;
		case"Player1":
			 spellchoice = userI.PlayerChoiceTwo();
				damagetoOpponent = playerlist.get(0).castSpell(spellchoice);
				playerlist.get(1).health -= damagetoOpponent;
				System.out.println(" \nYou have been hurt by a level " + damagetoOpponent + " "
						+ spellchoice + "\nYour current health is " + playerlist.get(1).health);
			break;
		default:
			System.out.println("error error in PlayerOrAISpell");
			break;
		}
	}
}
		

