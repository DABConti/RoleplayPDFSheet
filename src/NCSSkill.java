
public class NCSSkill  {
	
	public String name;
	public int cost;
	public int cost2;
	public int cost3;
	
	/**
	 * 0 - strength
	 * 1 - Dex
	 * 2 - Intellegence
	 * 3 - Charisma
	 * 4 - Willpower
	 * 5 - Magic
	 */
	public int type;
	
	public String getName()
	{
		return name;
	}
	
	
	

	public String toString()
	{
		//return name + " ("+ cost + "/" + cost2 + "/"+ cost3 +"xp):";
		return name + ":";
	}
	
	public NCSSkill(String name, int type, int cost, int cost2, int cost3)
	{
		this.name = name;
		this.cost = cost;
		this.cost2 = cost2;
		this.cost3 = cost;
		this.type = type;
		
	}
	
	public NCSSkill(String name, int type)
	{
		this.name = name;
		this.cost = 1;
		this.cost2 = 2;
		this.cost3 = 3;
		this.type = type;
		
	}
}
