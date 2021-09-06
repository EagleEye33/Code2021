package chp5;

public class TestBulb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Bulb lamp = new Bulb();
		Bulb christmaslight = new Bulb();
		
		lamp.isOn();
		System.out.println(lamp);
		lamp.turnOn();
		System.out.println(lamp);
		christmaslight.turnOn();
		System.out.println(christmaslight);
		christmaslight.turnOff();
		System.out.println(christmaslight);
	}

}
