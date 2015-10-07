/*
 * 
 * Krypton's 100% accurate Admin Prediction Software
 * 
 
1. Name: First/Last
2. In-game name:
3. Player ID:
4. Where are you from?:
5: How old are you?:
6. How long you've played Arma(all iterations)?:
7. How long have you played on Asylum?:
8. Have you ever been an admin before?:
9. Why do you want to be an admin for Asylum Gaming?:
10. What the best way to contact you?
11. Are you willing to install programs to assist in your admin responsibilities?
12. How much time can you dedicate to administrating for Asylum Gaming?:
13. When is the best time to contact you for an interview? 

 */


import java.util.*;
public class AdminSimulator {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String fName = "";
		String lName = "";
		int age = 0;
		final double INITIAL_CHANCE = 99; // No one is guaranteed 100% to become an admin, regardless of your app
		double currentChance = 0; // will hold current chance of user's percentage chance of receiving admin
		
		//Simple Name Prompts Below
		System.out.print("Greetings! Enter your first name: ");
		fName = in.nextLine();
		System.out.print("Enter your last name: ");
		lName = in.nextLine();
		
		//Prompt for PlayerID, storing it as a string, not an actual number
		System.out.print("Enter your playerID: ");
		String playerID = in.nextLine();
		
		//Prompty for user's age
		System.out.print("How old are you: ");
		age = in.nextInt();
		
		//chance Check, the 3 checks below will set up the user's current chance based on their age
		if(age == 17)
		{
			currentChance = INITIAL_CHANCE - 5;
		}
		else if(age < 17)
		{
			currentChance = INITIAL_CHANCE - 85;
		}
		
		else // if 18 or older, chances are 99% still
		{
			currentChance = INITIAL_CHANCE;
		}
		
		//Simply Following along the app, prompting for user location
		System.out.print("Where are you from: ");
		String userLocation = in.next();
		
		//Prompt to request User's Arma series playtime in total hours
		System.out.print("How long have you played the Arma series(hours total): ");
		int armaPlaytime = in.nextInt();

		//If user has played less than 1000 hours of ARMA
		if(armaPlaytime < 1000)
		{
			currentChance -= 10;
		}
		
		//Prompt for asylum playtime in hours
		System.out.print("How long have you played on Asylum(hours): ");
		int asylumPlaytime = in.nextInt();
		
		//if user has played less than 1000 hours on ASylum, penalize, but not as agressive as ARMA playtime
		if(asylumPlaytime < 1000)
		{
			currentChance -= 5;
		}
		
		//Prompt to request if user has been an admin/mod in previous endeavors
		System.out.print("Have you ever been an admin/moderator before?(y/n): ");
		String inputYN = in.next();
		
		//IF they have
		if(inputYN.equalsIgnoreCase("y"))
		{
			//if they are not still at chance cap, and ARE over 17
			if(currentChance < 99 && age > 17)
			{
				currentChance += 10;
			
				//if they surpass 99 somehow, reset them back to the 99 max
				if(currentChance > 99)
				{
						
					currentChance = 99;
				}
			
			}
		}
		
		//if they have no experience, penalize
		else if (inputYN.equalsIgnoreCase("n"))
		{
			currentChance -= 5;
		}
		
		//Prompt if user is willing to install programs, repeat checks from above
		System.out.print("Are you willing to install programs to assist in your admin responsibilities?(y/n): ");
		
		inputYN = in.next();
		
		if(inputYN.equalsIgnoreCase("y"))
		{
			//if they are not still at chance cap, and ARE over 17
			if(currentChance < 99)
			{
				currentChance += 5;
			
				//if they surpass 99 somehow, reset them back to the 99 max
				if(currentChance > 99)
				{
						
					currentChance = 99;
				}
			
			}
		}
		
		//If they cant install programs, large penalty
		else if (inputYN.equalsIgnoreCase("n"))
		{
			currentChance -= 15;
		}
		
		//prompt to check user time, in hours per week able to be dedicated, Assuming 5 days a week minimum/average
		System.out.print("How much time can you dedicate to admining for Asylum Gaming?(Hours per week):");
		int hoursToDedicate = in.nextInt();
		
		//if less than 2 hours a day, for 5 days a week average
		if(hoursToDedicate < 10)
		{
			currentChance -= 10;
		}
		
		//if over 20 hours a week, small increase
		if(hoursToDedicate > 20)
		{
			currentChance += 5;
		}
		
		System.out.print("What percentage of the community thinks highly of you?(Enter a number): ");
		int likedPercentage = in.nextInt();
		
		for(int i = 0; i < 10; i++)
		{
			currentChance= chanceRandomizer(currentChance, likedPercentage);
			
		}
		
		//prompt if user would like to see their chances
		System.out.print("Thanks for the application, " + fName + " would you like to see your Chance of receiving Admin?(y/n): ");
		
		inputYN = in.next();
		
		//if they would, display the chance of receiving admin
		if(inputYN.equalsIgnoreCase("y"))
		{
			System.out.println("Your chance of receiving Admin is: " + currentChance);
		}
		
		//display Goodbye message
		System.out.println("Farewell!");
		
		
	}

	// This is the inevitable Randomizer, as no applicant can be guaranteed acceptance to the team!
	public static double chanceRandomizer(double currentChance1, int percentage1) // simply pass our current chance and the percentage
	{
		Random Rand1 = new Random();
		double newChance = currentChance1;
		
		// if less than 40% of the community likes user, penalize further EACH time
		if(percentage1 < 40)
		{
			double randomNum = Rand1.nextInt(10)+1;
			randomNum = randomNum * .01;
			
			newChance = newChance - (newChance * randomNum);
		}
		
		double randomNum = Rand1.nextInt(10)+1;
		randomNum = randomNum * .01;
		
		newChance = newChance - (newChance * randomNum);
		
		return newChance;
	}
}
