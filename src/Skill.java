
public class Skill {
	
	public String name;
	public int cost;
	
	/**
	 * 0 - strength
	 * 1 - Dex
	 * 2 - Mental
	 * 3 - Charisma
	 * 4 - Willpower
	 */
	public int type;
	
	public String getName()
	{
		return name;
	}
	
	public String toString()
	{
		return name + " ("+ cost + "):";
	}
	
	public Skill(String name, int cost, int type)
	{
		this.name = name;
		this.cost = cost;
		this.type = type;
		
	}

}
