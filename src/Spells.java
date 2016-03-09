
public class Spells {
	Dice roll = new Dice();
	int cost;
	
	public boolean manaCheck(int mana, String spell){
		manaCost(spell);
		if(mana < cost){
		return true	;
		}else{
			return false;
		}
	}
	public void manaCost(String name){
		switch (name){
			case "MagicMissle":
				cost = 18;
				break;
			case "RayofFrost":
				cost = 12;
				break;
			case "Fireball":
				cost = 15;
				break;
			case "RockSlide":
				cost = 9;
				break;
		}
		
	}
	public int magicMissle(){
		System.out.println("Fizzle Fizzle magic missle");
		return roll.RollResult(12);
	}
	
	public int rayOfFrost(){
	System.out.println("Frost laser");
	return roll.RollResult(8);
	}
	
	public int fireball(){
		System.out.println("Whoosh!");
		return roll.RollResult(10);
	}
	
	public int rockSlide(){
		System.out.println("Rumble");
		return roll.RollResult(6);
	}

}
