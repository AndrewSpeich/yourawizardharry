
public class Dice {

	public void rollDice(int sides){
		int roll;
		roll = (int) Math.round(Math.random()*(sides-1))+1;
	}
}
