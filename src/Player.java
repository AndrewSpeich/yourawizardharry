
public class Player {
	int health = 100;
	int mana = 100;
	int healthcap = 100;
	int manacap = 100;
	String name;
	int defense = 10;
	
	public Player(String named){
		name = named;
		
	}
	public void getHealth(){
		System.out.println( "Your health is:"+ health);
	}
	public void checkHealth(){
		if(health>healthcap){
			health = healthcap;
			System.out.println("Health maxed");
		}
	}
	public void getMana(){
		System.out.println( "Your health is:"+ health);
	}
	public void checkMana(){
		if(mana>manacap){
			mana = manacap;
			System.out.println("Health maxed");
		}
	}

}
