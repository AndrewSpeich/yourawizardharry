
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
			choice = "Attack";
		}else if( AIHealthStatus <= 12)
		{
			choice = "heal";
		}else{
			choice = "attack";
		}
		return choice;
		
	}

	public String SpellDecision()
	{
		String choice;
		if(mana >= spellbook.manaCost("magicmissle") + 6){
			choice = "MagicMissle";
		}else if(mana >= spellbook.manaCost("rayoffrost") + 6){
			choice = "rayoffrost";
		}else if(mana >= spellbook.manaCost("fireball") + 6){
			choice = "fireball";
		}else if(mana >= spellbook.manaCost("rockslide") + 6){
			choice = "rockslide";
		}else{
			choice = "rockslide";
			}
			return choice;
		
	}
}

