
public class Player {
	int health = 100;
	int mana = 100;
	int healthcap = 100;
	int manacap = 100;
	String name;
	int defense = 10;
	Dice roll = new Dice();
	Spells spellbook = new Spells();
	public Player(String named){
		name = named;
		
	}
	public void getHealth(){
		System.out.println( "Your health is:"+ health);
	}
	
	public void getMana(){
		System.out.println( "Your mana is:"+ mana);
	}
	public void checkMana(){
		if(mana>manacap){
			mana = manacap;
			System.out.println("Mana maxed");
		}
	}
	public void checkHealth(){
		if(health>healthcap){
			health = healthcap;
			System.out.println("\nHealth maxed");
			}else{
				System.out.println(name + "'s Health is " + health);
			}
	}
	public void healMe(){
		int healthgain= roll.RollMultiple(3,4);
		health += healthgain;
		System.out.println(" \n" + name + " gained " + healthgain + " health.");
		checkHealth();
		
	}
	
	public void restoreMana(){
		mana += roll.RollResult(20);
	}
	public boolean isDead(){
		if (health <= 0){
			System.out.println(name + " died");
			return true;
		}
		else{
			return false;
		}
	}
	public int castSpell(String spellName){
		int damageoutput = 0;
		switch (spellName.toLowerCase()){
		case "magicmissle":
			if(spellbook.manaCheck(mana, spellName)){
				mana -= spellbook.manaCost(spellName);
				damageoutput += spellbook.magicMissle();
			}else{
				System.out.println(name + "'s spell fails.");
			}
			break;		
		case "fireball":
			if(spellbook.manaCheck(mana, spellName)){
				mana -= spellbook.manaCost(spellName);
				damageoutput += spellbook.fireball();
			}else{
				System.out.println(name + "'s spell fails.");
			}
			break;
		case "rayoffrost":
			if(spellbook.manaCheck(mana, spellName)){
				mana -= spellbook.manaCost(spellName);
				damageoutput += spellbook.rayOfFrost();
			}else{
				System.out.println(name + "'s spell fails.");
			}
			break;
		case "rockslide":
			if(spellbook.manaCheck(mana, spellName)){
				mana -= spellbook.manaCost(spellName);
				damageoutput += spellbook.rockSlide();
			}else{
				System.out.println(name + "'s spell fails.");
			}
			break;
		default:
			System.out.println("\nCheck your chant! Spelling in spells is crucial."
					+ "\nYou lost mana from you pathetic spellcasting!");
			if(spellbook.manaCheck(mana, spellName)){
				mana -= spellbook.manaCost(spellName);
				damageoutput += 0;
			}else{
				System.out.println("\nThings aren't looking good, you do not have the "
						+ "\nmana to even cast a basic rainbowfart.");
			}
			break;
		}
		return damageoutput;
	}
}
