
public class Spells {
	Dice roll = new Dice();
	int cost;
	
	public boolean manaCheck(int mana, String spell){
		if(mana < manaCost(spell)){
		return true	;
		}else{
			return false;
		}
	}
	public int manaCost(String name){
		switch (name){
			case "magicmissle":
				cost = 18;
				break;
			case "rayoffrost":
				cost = 12;
				break;
			case "fireball":
				cost = 15;
				break;
			case "rockslide":
				cost = 9;
				break;
		}
		return cost;
		
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
