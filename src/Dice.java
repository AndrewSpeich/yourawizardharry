
public class Dice 
{

	
	public int RollResult(int sidesNumber)
		{
		int rollResult = (int) Math.round(Math.random()*(sidesNumber -1))+1;
		return rollResult;
		}
	
	public int RollMultiple(int sidesNumber,int amountOfDice)
	{
		int reRollResult = 0;
		
		for(int count = 0; count < amountOfDice; count++)
		{
			 reRollResult += RollResult(sidesNumber);
		}
		return reRollResult;
	}
}

