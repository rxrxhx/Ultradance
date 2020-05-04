
public class Move {
	
	private int dancerID;
	private String info;
	public Move(int dancerID, String info)
	{
		this.dancerID = dancerID;
		this.info = info;
	}
	
	public int getDancerID()
	{
		return dancerID;
	}
	
	public String getInfo()
	{
		return info;
	}

}
