package chp5;

public class Bulb {

	private boolean on;
	
	public Bulb()
	{
		this.on = false;
	}
	
	public boolean isOn()
	{
		return this.on;
	}
	
	public void  turnOn()
	{
		this.on = true;
	}
	
	public void turnOff()
	{
		this.on = false;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("The bulb is turned on: " + on);
		return builder.toString();
}
}
