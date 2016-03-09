
public class AI extends Player{
	Dice AIdecision = new Dice();
	public AI(String Name)
	
	{
		super(Name);
		
	}
	public String AttackDecision(int playerHealthStatus, int AIHealthStatus)
	{
		String choice;
		if(playerHealthStatus == 1){
			choice = "attack";
			System.out.println("The evil one attacks!");
		}else if( AIHealthStatus <= 12)
		{
			choice = "heal";
		}else{
			choice = "attack";
			System.out.println("The evil one attacks!");
		}
		return choice;
		
	}

	public String SpellDecision()
	{
		String choice;
		if(mana >= spellbook.manaCost("magicmissle") + 6){
			choice = "magicmissle";
		}else if(mana >= spellbook.manaCost("rayoffrost") + 6){
			choice = "rayoffrost";
		}else if(mana >= spellbook.manaCost("fireball") + 6){
			choice = "fireball";
		}else if(mana >= spellbook.manaCost("rockslide") + 6){
			choice = "rockslide";
		}else if(mana >= spellbook.manaCost("rockslide")){
			choice = "rockslide";
		}else{
			choice = "rainbowfart";
		}
			return choice;
		
	}
}

