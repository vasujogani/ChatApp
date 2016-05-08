import java.util.Random;
import java.util.Scanner;


public class Donald {

	private Random randPaul;
	private String[] uglyWomyn = {"Hillary Clinton","Rosie O'Donnall","Megyn Kelly"};
	private String[] uglies = {"fat","a slob","a liar","ugly"};
	private String[] killinCountries = {"China", "Mexico", "Japan"};
	private String[] killinPeople = {"Chinese","Mexican","Japanese"};
	private String[] stealingItem = {"manufacturing","jobs"};
	private String[] stealing = {"taking", "stealing"};
	private String[] walls = {"I will build a wall, and make Mexico pay for it!",
			"I am going to build a wall, and make Mexico pay for it!",
			"A wall will be built, and Mexico will pay for it!",
			"Who's going to pay for the wall? Crowd: MEX-I-CO!!!",
			"Its going to be a beautiful wall.",
	};
	private String[] cruzs = {"Looks like Ly'in Ted Cruz has lied again!",
			"No need to spill the beans: a picture is worth a thousand words.",
			"If Ted targets my wife again, I'll spill the beans on his wife!",
			"Look at Ted, hes sweating soooo badly."
			};
	private String[] bushes = {
			"@Jeb: I don't need to apoligize because I said nothing wrong.",
			"Jeb, take your Guac-bowles and go home.",
			"Jeb, I'm at 30% in the polls, and you're at 1%."
	};
	private String[] jebs = {"low energy", "a loser", "a lightwieght","a foolish guac-bowle merchant",
			"a fool"};
	private String[] marcos = {
			"Look at Marco Rubio, he has such little hands!",
			"Little Marco, I can assure you that nothing of mine is small. Ivana Trump will vouch for me.",
	};
	
	public Donald() {
		randPaul = new Random();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Donald trump = new Donald();

		System.out.println("Ladies and Gentlemen, I present to you, the one, the only, DONALD J TRUMP!!!");
		
		boolean done = false;
		
		while(!done){
			System.out.println("Donald: "+trump.talk());
			done = scanner.nextLine().equals("Lets Make America Great Again");
		}
		
		System.out.println("fine");
		
	}
	public String talk(){
		int rand = randPaul.nextInt(10);
		switch(rand){
			case 0: return "Rand, I've had you up to here: -----[4ft].";
			case 1: return uglyChicks();
			case 2: return killinUs();
			case 3: return wall();
			case 4: return lyinTed();
			case 5: return bashTheBush();
			case 6: return littleMarco();
			default: return "I Will Make America Great Again!";
		}
		
	}
	public String littleMarco(){
		int marco = randPaul.nextInt(marcos.length);
		return marcos[marco];
	}
	public String bashTheBush(){
		if(randPaul.nextBoolean()){
			int bush = randPaul.nextInt(bushes.length);
			return bushes[bush];
		}else{
			int jeb = randPaul.nextInt(jebs.length);
			return "Jeb Bush is "+jebs[jeb]+".";
		}
		
	}
	public String lyinTed(){
		int cruz = randPaul.nextInt(cruzs.length);
		return cruzs[cruz];
	}
	public String wall(){
		int rand = randPaul.nextInt(walls.length);
		return walls[rand];
	}
	public String killinUs(){
		int country = randPaul.nextInt(killinCountries.length);
		int steal = randPaul.nextInt(stealing.length);
		int item = randPaul.nextInt(stealingItem.length);
		String response = killinCountries[country]+", they're killin' us.";
		response += " They are "+stealing[steal]+" our "+stealingItem[item]+".";
		response+=" Don't get me wrong, I love the "+killinPeople[country]+" people, but they're killin' us.";
		return response;
	}	
	public String uglyChicks(){
		int womyn = randPaul.nextInt(uglyWomyn.length);
		int insult = randPaul.nextInt(uglies.length);
		return uglyWomyn[womyn]+" is "+uglies[insult];
	}
}
