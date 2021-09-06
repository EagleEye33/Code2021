package chp5;

public class TV {

	private int channel;
	private int volume;
	private boolean on;
	private int maxChannel;
	private int maxVolume;
	
	public TV() {
		this.channel = 1;
		this.volume = 1;
		this.on = false;
		this.maxChannel = 1;
		this.maxVolume = 1;
				
	}
	
	public int getChannel() {
		return this.channel;
		
	}
	
	public int getVolume() {
		return this.volume;
	}
	
	public boolean isOn() {
		return this.on;
	}
	
	public int getMaxChannel() {
		return this.maxChannel;
	}
	
	public int getMaxVolume() {
		return this.maxVolume;
	}
	
	public void setChannel(int someChannel) {
		
		if(on)
			if (on && someChannel >= 1 && someChannel <= this.maxChannel) {
				this.channel = someChannel;
			}
		
		
	}
	
	public void setVolume(int someVolume) {
		if(on == true && someVolume >= 1 && someVolume <= maxVolume)
		{
			volume = someVolume;
		}
		
		else
		{
		}
	}
	
	public void setMaxChannel(int maxC) 
		{maxChannel = maxC;}
	
	
	public void setMaxVolume(int maxVol) 
		{maxVolume = maxVol;}
	
	
	public void turnOn() 
		{ on = true;}
	
	
	public void turnOff() 
		{ on = false;}
	
	
	public void channelUp() {
		
		if (on) {
			this.channel++;
			if(this.channel > this.maxChannel) {
				this.channel = 1;
			}
			}
		
	}
	
	 public void channelDown() 
		 {if(on == true && channel == 1)
			{
				channel = maxChannel;
			}
			else if(on == true && channel > 1)
			{
				channel = channel - 1;
			}
			else
			{
			}
			}
	 
	 
	  public void volumeUp() 
		 {
				if(on == true && volume < maxVolume)
				{
					volume = volume + 1;
				}
				else
				{
				}
		 }
	  
	 
	 public void volumeDown() 
		 {	if(on == true && volume > 0)
			{
				volume = volume - 1;
			}
			else
			{
			}
			}
	 
	 
	 public String toString() {
		 return "\n\tChannel: " + channel
					+ "\n\tVolume: " + volume 
					+ "\n\ton: " + on 
					+ "\n\tmaxChannel: " + maxChannel 
					+ "\n\tmaxVolume: " + maxVolume;

	 }
	 
	 
}


