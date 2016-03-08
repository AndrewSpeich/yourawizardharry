
public class Spells {
	Dice roll = new Dice();
	
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
