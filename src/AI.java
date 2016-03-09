
public class AI extends Player{
	Dice AIdecision = new Dice();
	public AI(String Name)
	{
		super("Computer");
		
	}
	public boolean DecideAction()
	{
		boolean choice;
		int result = AIdecision.RollResult(20);
		if(result>15){
			choice = true;
		}else if(result<= 15 & result>10 )
		{
			choice = false;
		}else if(result<=10 & result>5){
			choice = true;
		}else{
			choice = false;
		}
		return choice;
	}

}

