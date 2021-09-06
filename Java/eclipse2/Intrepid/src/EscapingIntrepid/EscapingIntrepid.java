package EscapingIntrepid;

import java.util.Scanner;

public class EscapingIntrepid {

	
	
	//public static Scanner scan = new Scanner(System.in);
	//public static String question = "0";
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String question = "0";
		
		//Can also instantiate this was as well
		//Scanner scan = new Scanner(System.in);
		//String question = 0;
		//question = "0";
		
		boolean on = true; 
		
		while (on == true) { //Game Loop
			
			switch (question) {
			
			case "0": //The first question (Main Case)
				System.out.println("Welcome to Intrepid! Would you like to play? \n[1] Yes \n[2] No");
				
				question = "1"; //Sets question to next question
				
				break;
			
			case "1":
				
				switch(scan.next()) { //scans answer from the first question 
				
				case "1": //If your answer was 1 (Inner Case)
					
					System.out.println("");
					System.out.println("You awake in a room. It's cold. You look out the window; YOU'RE IN SPACE! You hear footsteps " + 
					"coming towards your door! You look up and see an open air vent.");
					
					System.out.println("[1] Climb into the air vent \n[2] Stay put and see what happens"); 
					
					question = "2"; //sets next question
					
					break;
					
				case "2"://If your answer was 2
					
					System.out.println("");
					System.out.println("Are you Sure? \n[1] No \n[2] Yes");
					
					question = "Z";
					
					break;
					
				default:
					
					System.out.println("");
					System.out.println("Please enter one of the options: 1 or 2");
					
					question = "1"; //default will run until valid input is entered to move on to next main case
					
					break;
				}	
				
			break; //breaks out of loop to check question
				
			case "2":
				
				switch(scan.next()) {
				
				case "1":
					
					System.out.println("");
					System.out.println("Someone else is up here as well! They took you as a threat and shot you with a laser gun! " + 
					"GAME OVER!");
					
					System.out.println("\nPlay again? \n[1] Yes \n[2] No");
					
					question = "Z";
					
					break;
				
				case "2":
					
					System.out.println("");
					System.out.println("Whoever it was, they weren't coming to your room. They are gone now. You peek out the door " + 
					"and don't see anyone in sight. There are signs that label hallways and rooms. Oddly enough they are in English. " + 
					"How convenient, however, you're at a fork in the road now. The hallway to the left leads to the ship's control " + 
					"room. The hallway to the right leads to the escape pods. What do you do?");
					
					System.out.println("[1] Left (Control Room) \n[2] Right (Escape Pods)"); //options for answer
					
					question = "3";
					
					break;
					
				
					
				default:
					
					System.out.println("");
					System.out.println("The air is thin in space so your brain might not be working properly. The available options"
							+ " are 1 or 2.");
					
					question = "2"; //Must answer this 
					
					break;
				}
				
			break;
				
			case "3": //Main loops Branch into two possible endings
				
				switch(scan.next()) { //inner cases remain virtually the same. Different text, and a different resulting next question
				
				case "1":
					
					System.out.println("");
					System.out.println("Making your way to the control room huh? I hope you know how to fly this thing. As you sneak " + 
					"down the hallways you turn a corner and see two figures talking to each other. These fools look like reptilians! " + 
					"However, by the way they are communicating they seem distressed.They don't look very harmful and you get a gut " + 
					"feeling that you should approach them. Do you listen to your gut or find another way around?");
					
					System.out.println("[1] Approach them \n[2] Find another route"); 
					
					question = "a";
					
					break;
					
				case "2":
					
					System.out.println("");
					System.out.println("You decide that the escape pod is probably your best bet. As you walk the hallways, " + 
					"following the signs to the escape pods you see a room labeled 'Human Experiments'. Your curiosity kicks in. " + 
					"Maybe there are others?");
					
					System.out.println("[1] Go in the room \n[2] Mind your business and continue");
					
					question = "A";
					
					break;
					
				default:
					
					System.out.println("");
					System.out.println("Is that too hard of a question? You have a 50/50 chance! 1 or 2? ");
					
					question = "3";
					
					break;
				}
				
			break;
				
			case "a": //Lower case letters denote one story line in finding the control room
				
				switch(scan.next()) {
				
				case "1": 
					
					System.out.println("");
					System.out.println("You approach them and they are shocked to see you out in the halls. They speak english and asked " + 
					"how you were able to escape. They explain that they are sick of their rulers and the experiments on the humans are " + 
					"inhumane. They plan on rebelling and say they can help you escape. Are they trustworthy? Are they just saying " + 
					"this to capture you? Will you go with them?");
					
					System.out.println("[1] Go with them \n[2] No way, never trust an alien!");
					
					question = "b";
					
					break;
					
				case "2":
					
					System.out.println("");
					System.out.println("You want to avoid any confrontation that isn't necessary. You flee down a corridor but you are " + 
					"cornered by two other ship natives. They don't like humans. It's over for you. GAME OVER!");
					
					System.out.println("\nPlay again? \n[1] Yes \n[2] No");
					
					question = "Z";
					
					break;
					
				default:
					
					System.out.println("");
					System.out.println("Maybe your finger slipped. The options are 1 or 2");
					
					question = "a";
					
					break;
				}
				
			break;		
			
			case "A": //Upper case letters denote second story line in finding the escape pod
				
				switch(scan.next()) {
				
				case "1":
					
					System.out.println("");
					System.out.println("You peek through the door to see if you can see any immediate threats. Nothing. You go in and peek " + 
					"around a bit. It looks and smells like a hospital room. You see someone laying in a bed behind curtains. You pull it " + 
					"open and he begs you to unchain him because 'they' will be coming back soon. ");
					
					System.out.println("[1] Leave before they get there \n[2] Unchain the man");
					
					question = "B";
					
					break;
					
				case "2":
					
					System.out.println("");
					System.out.println("You decide that it is too risky to try to be saving anyone else. As you continue to trek through " + 
					"the hallways you turn a corner and are grabbed by one of the ships natives. It's over for you. If only you had someone " + 
					"with you to help you fight off this monster. GAME OVER!");
					
					System.out.println("\nPlay again? \n[1] Yes \n[2] No");
					
					question = "Z";
					
					break;
					
				default:
					
					System.out.println("");
					System.out.println("The force is not strong with you. Try 1 or 2");
					
					question = "A";
					
					break;
				}
				
			break;
			
			case "b": 
				
				switch(scan.next()) {
				
				case "1":
					
					System.out.println("");
					System.out.println("You decide that these are some pretty trustworthy fellows. They tell you to try to stay " + 
					"behind them as you walk and stay out of sight. You're almost to the control room, but two natives approach. You " + 
					"try to stay calm and out of their sight. They start talking to the ones leading you. You've been spotted. " + 
					"Everyone takes cover and shots are being fired. One of them tosses you a gun. You notice that the door you are " + 
					"next to says, 'Control Room' Will you stay and fight or go into the control room?");
					
					System.out.println("[1] Stay and fight \n[2] Go into the control room");
					
					question = "c";
					
					break;
					
				case "2":
					
					System.out.println("");
					System.out.println("You tell them thanks for the offer but you're gonna find another way out of this ship. But " + 
					"they already told you their plans on rebelling and they can't let that information get out. You've been shot. " + 
					"GAME OVER! ");
					
					System.out.println("\nPlay again? \n[1] Yes \n[2] No");
					
					question = "Z";
					
					break;
					
				default:
					System.out.println("");
					System.out.println("Curiosity is an admirable trait, but there is nothing to see here. Please pick: 1 or 2");
					
					question = "b";
					
					break;
				}
				
			break;
			
			case "B": 
				
				switch(scan.next()) {
				
				case "1":
					
					System.out.println("");
					System.out.println("There's no way you can trust this guy and you don't want to meet whoever is coming. You " + 
					"start to leave, but the man starts screaming. It attracts the guards. They found you. GAME OVER!");
					
					System.out.println("\nPlay again? \n[1] Yes \n[2] No");
					
					question = "Z";
					
					break;
					
				case "2":
					
					System.out.println("");
					System.out.println("He introduces himself as Jim. He says he knows the way out. As you continue through the " + 
					"hallways together Jim gets caught and grabbed by one of the ships natives. He looks like some sort of reptilian " + 
					"being. Do you try to save Jim or do you run away and continue towards the escape pods?");
					
					System.out.println("[1] Save Jim \n[2] Run!");
					
					question = "C";
					
					break;
					
				default:
					System.out.println("");
					System.out.println("I'm not quite sure how you got here, but this is not where you want to be going. Try again: 1 or 2");
					
					question = "B";
					
					break;
				}
				
			break;
			
			case "c": 
				
				switch(scan.next()) {
				
				case "1":
					
					System.out.println("");
					System.out.println("It will probably be better to have a native help you fly this ship. You continue to fight " + 
					"despite having the losing end of the battle. You get some lucky shots in and you come out victorious with your " + 
					"alien partner. Your partner says his goodbyes to his dead accomplice. You get into the control room and your " + 
					"alien friend takes the ship off of auto-pilot and sets a course for earth. Time for you to go home but your " + 
					"friend has quite the journey to make to overthrow his alien rulers. Congratulations you have escaped Intrepid!");
					
					System.out.println("\nPlay again? \n[1] Yes \n[2] No");
					
					question = "Z";
					
					break;
					
				case "2":
					
					System.out.println("");
					System.out.println("You go into the control room and close the door behind you. You run up to the chair and look " + 
					"at the buttons before you. These things speak english, but these buttons are definitely in a language you can't " + 
					"decipher. You need your alien accomplices to help you drive this ship so you run back out to continue to fight. " + 
					"Your partners have been defeated. It's over for you. GAME OVER!");
					
					System.out.println("\nPlay again? \n[1] Yes \n[2] No");
					
					question = "Z";
					
					break;
					
				default:
					
					System.out.println("");
					System.out.println("You have only had two options the entire game, why change now? 1 or 2");
					
					question = "c";
					
					break;
				}
				
			break;
				
			case "C": 
				
				switch(scan.next()) {
				
				case "1":
					
					System.out.println("");
					System.out.println("As much as you don't want to touch this gross looking monster you start to choke him out " + 
					"from behind. With your help, you and Jim are able to overcome the monster and start heading for the pods! You " + 
					"get to the pod room. There is only one pod. Jim looks at you and shoves you down without saying anything. He " + 
					"gets into the pod and shoots out into space. The guards hear what's going on and run into the room and find " + 
					"you. They are not happy. GAME OVER!");
					
					System.out.println("\nPlay again? \n[1] Yes \n[2] No");
					
					question = "Z";
					
					break;
					
				case "2": 
					
					System.out.println("");
					System.out.println("Sorry Jim every man for himself! Better you than us! Jim seemed like a kind of sketchy dude " + 
					"anyways. You find the escape pod room. Lucky enough there is only pod left. You hop in and shoot out of the " + 
					"spaceship. Direct course to Earth. Congratulations you escaped Intrepid!");
					
					System.out.println("\nPlay again? \n[1] Yes \n[2] No");
					
					question = "Z";
					
					break;
					
				default:
					
					System.out.println("");
					System.out.println("I am beginning to think you are trying to spite me. Pick 1 or 2");
					
					question = "C";
					
					break;
				}	
				
			break; 
			
			case "Z": //Main Case 'Z' refers to any 'Play Again' question. Will either restart or quit while loop
				
				switch(scan.next()) {
				case "1":
					
					System.out.println("");
					
					question = "0";
					
					break;
					
				case "2":
					
					System.out.println("");
					System.out.println("Goodbye!");

					question = "666";
					
					on = false; //The on boolean is changed to false which will stop the while loop
					
					break;
					
				default:
					
					System.out.println("");
					System.out.println("Make up your mind! 1 or 2");
					
					question = "Z";
					
					break;
				}
				
			break;	
			}	
		}	
	}
}
