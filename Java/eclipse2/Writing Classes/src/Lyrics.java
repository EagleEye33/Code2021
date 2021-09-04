import java.util.Scanner;

public class Lyrics {
	
	
	private String songLyrics1;
    private String songLyrics2;
	private String songLyrics3;
	
	
	public Lyrics()
	{
		this.songLyrics1 = "Into this world we're thrown, dun dun dun-dunnad-dun";
		this.songLyrics2 = "Come Together! du-du-du-du-du Right Now! du du du du......."
				+ ".... Over me - Shaundandalaaaaa wewerrrr";
		this.songLyrics3 = "You see I've been through the desert on a horse with no "
				+ "name... it felt good to be out of the rain.. dedelea.. in the desert, "
				+ "you can't remember your name for' there ain't no one to give you no pain.";
	}
	
	public String getsongLyrics1() 
	{
		return songLyrics1;
	}
	
	public String getsongLyrics2()
	{
		return songLyrics2;
	}
	public String getsongLyrics3()
	{
		return songLyrics3;
	}
}
