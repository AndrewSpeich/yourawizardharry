
public class Spells {
	Dice roll = new Dice();
	int cost;
	
	public boolean manaCheck(int mana, String spell){
		if(mana < manaCost(spell)){
		return false;
		}else{
		return true;
		}
	}
	public int manaCost(String name){
		switch (name){
			case "magicmissile":
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
			default:
				cost = 2;
				break;
		}
		return cost;
		
	}
	public int magicMissle(){
		System.out.println(" \nFizzle Fizzle magic missile");
		return roll.RollResult(12);
	}
	
	public int rayOfFrost(){
	System.out.println(" \nFrost laser");
	return roll.RollResult(8);
	}
	
	public int fireball(){
		System.out.println(" \nWhoosh!");
		return roll.RollResult(10);
	}
	
	public int rockSlide(){
		System.out.println(" \nRumble");
		return roll.RollResult(6);
	}

}
