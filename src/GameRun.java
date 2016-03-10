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
		
 	public void RunGameAgain()
	{
			chooseGameType();
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
		RunGameAgain();
	}
	public void runGameTwoPlayer(){
		int length = userI.getNumberPlayers();
		for(int i = 0; i<length; i++){
			playerlist.add(new Player(userI.GetName()));
		}
		while(!( playerlist.get(0).isDead())&&!( playerlist.get(1).isDead())){
			
			for(int ind = 0; ind < playerlist.size(); ind++){
			
				System.out.print(playerlist.get(1).name+" ") ;
				RoundStartMulti(userI.PlayerChoiceOne(),ind ,playerlist.indexOf(userI.opponentChoice(playerlist)));
				playerlist.get(ind).restoreMana();
				}
			
			}
		
		System.out.println(" \nGame Over.");
		RunGameAgain();
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
	public void RoundStartMulti(String attackChoice, int index, int choice )
	{
		
		switch(attackChoice){
		case"attack":
			MultiplayerSpell(index, choice);
			break;
		
		default:
			
				playerlist.get(index).healMe();
			break;
		}
	}
	public void MultiplayerSpell(int ind, int target)
	{
		int damagetoOpponent;
		String spellchoice;
		
			 spellchoice = userI.PlayerChoiceTwo();
			damagetoOpponent = playerlist.get(ind).castSpell(spellchoice);
			playerlist.get(target).health -= damagetoOpponent;
			System.out.println(" \nYou have been hurt by a level " + damagetoOpponent + " "
					+ spellchoice + "\nYour current health is " + playerlist.get(target).health);
		
		}
}

		

