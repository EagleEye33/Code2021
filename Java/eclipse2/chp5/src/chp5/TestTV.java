package chp5;

//class TestTV.java
//CSC110AA and CIS163AA
//written by: Wyatt Colyn
//description : Test our TV class.  Creates 2 objects and tests behavior

public class TestTV
{
	public static void main(String[ ] args)
	{
		TV tv1 = new TV();
		tv1.turnOn();
		tv1.setChannel(15);
		tv1.setVolume(8);
		
		System.out.println("tv1:");
		System.out.println("\tchannel:  " + tv1.getChannel());
		System.out.println("\tvolume:   " + tv1.getVolume());
		
		TV tv2 = new TV();
		tv2.setMaxChannel(55);
		tv2.setMaxVolume(13);
		tv2.turnOn();
		tv2.channelUp(); //2
		tv2.channelUp(); //3
		tv2.volumeUp();  //2
		System.out.println("tv2 State of: " +tv2.toString());  
		
		TV tv3 = new TV();
		tv3.setMaxChannel(3);
		tv3.turnOn();
		tv3.channelUp(); //2
		tv3.channelUp(); //3
		tv3.channelUp(); //rolls to 1
		tv3.channelUp(); //2
		System.out.println("tv3:");
		System.out.println("\tchannel:  " + tv3.getChannel());
		
		TV tv4 = new TV();
		tv4.setVolume(5); //no effect - tv off
		tv4.turnOn();
		tv4.volumeDown(); 	
		tv4.volumeDown();
		System.out.println("tv4:");
		System.out.println("\tvolume:  " + tv4.getVolume());
		System.out.println("\ton: "+  tv4.isOn() );
		
	
	}


}

/*Output:
tv1:
	channel:  1
	volume:   1
tv2 State of: 
	Channel: 3
	Volume: 2
	on: true
	maxChannel: 55
	maxVolume: 13
tv3:
	channel:  2
tv4:
	volume:  0
	on: true

*/
