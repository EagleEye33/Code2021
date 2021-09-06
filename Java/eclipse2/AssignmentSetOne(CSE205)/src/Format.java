import java.text.*; // For NumberFormat class
import java.util.*; // For Locale class
public class Format
{
	public static void main(String args[])
	{
		double num = 89123265365.122; 
		double money = 123456789.32;
		double per_num = 0.34;

		// Create a NumberFormat object with formatting for current Locale i.e. US		
		// To use other Locale objects loook them up. Some examples are CANADA, UK, US, CHINA, FRANCE
		NumberFormat nf = NumberFormat.getInstance();
		// To format for a specific Locale, say UK, use the following -
		// NumberFormat nf = NumberFormat.getInstance(Locale.UK);

		// Print out the double variable formatted according to the specified format
		System.out.println("Value before number formatting = " + num);
		System.out.println("Value after number formatting = " + nf.format(num));

		// Create a NumberFormat object with formatting for currencies of different locales
		NumberFormat money_format_US = NumberFormat.getCurrencyInstance(Locale.US);
		NumberFormat money_format_UK = NumberFormat.getCurrencyInstance(Locale.UK);

		// Print out the double variable "money" formatted according to the specified format
		System.out.println("\n\nValue before currency formatting =" + money);
		System.out.println("Value after formatting to USD= " + money_format_US.format(money));
		System.out.println("Value after formatting to POUNDS= " + money_format_UK.format(money));

		// Create a NumberFormat object to format a number in xx.xx% 
		NumberFormat percent = NumberFormat.getPercentInstance();

		// Print out the double variable formatted according to the specified format
		System.out.println("\n\nValue before percent formatting = " + per_num);
		System.out.println("Value after percent formatting = " + percent.format(per_num));
	}
}