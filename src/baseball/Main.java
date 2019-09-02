package baseball;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter pitcher's first name: ");		
		String firstName = scanner.nextLine();
		System.out.print("Enter pitcher's last name: ");
		String lastName = scanner.nextLine();
		System.out.print("Enter position (RP for relief pitcher or SP for starting pitcher): ");
		String position = scanner.nextLine();
		double strikePcnt;
		do {
			System.out.print("Enter strike average, ie. a pitcher's ability to throw strikes such as .56 aka 56% of time: ");
			while (!scanner.hasNextDouble()) {
				System.out.println("That's not a number!");
				System.out.print("Enter strike average, ie. a pitcher's ability to throw strikes such as .56 or 56% of time: ");
				scanner.next();
			}
			strikePcnt = scanner.nextDouble();
		} while (strikePcnt <= 0 || strikePcnt >= 1); //no negative strike percentage and no pitcher throws strikes 100%
		scanner.nextLine();
		
		Pitcher pitcher = new Pitcher(firstName, lastName, position, strikePcnt);
		
		System.out.println();
		
		System.out.print("Enter batter's first name: ");
		firstName = scanner.nextLine();
		System.out.print("Enter batter's last name: ");
		lastName = scanner.nextLine();
		System.out.print("Enter position (C, 1B, 2B, 3B, LF, CF, RF) and/or look up for abbrevs and their meanings: ");
		position = scanner.nextLine();
		double bA;
		do {
			System.out.print("Enter batting avg such as .25: ");
			while (!scanner.hasNextDouble()) {
				System.out.println("That's not a number!");
				System.out.println("Enter batting avg such as .25: ");
				scanner.next();
			}
			bA = scanner.nextDouble();
		} while (bA <= 0 || bA >= 0.4); //no negative batting average and no batter hits .400 these days
		
		System.out.println();
		
		scanner.close();
		Batter batter = new Batter(firstName, lastName, position, bA);
		
		int strikes = 0;
		int balls = 0;
		boolean hitOrKOrBB = false; // simulation ends when pitcher strikes out batter or batter gets a hit or walks (this program does not account for looking ks)
		
		System.out.println(pitcher.getName() + " is pitching to " + batter.getName());
		while (!hitOrKOrBB) {
			if (pitcher.pitch()) {
				if (batter.hit()) {
					System.out.println(batter.getName() + " got a hit!");
					hitOrKOrBB = !hitOrKOrBB;
				} else {// pitcher gets batter to swing and miss
					System.out.println(batter.getName() + " swung and missed");
					strikes++;
					System.out.println("The count is " + balls + " balls and " + strikes + " strikes");
					if (strikes == 3) {
						System.out.println(batter.getName() + " struck out.");
						hitOrKOrBB = !hitOrKOrBB;
					}
				}
			} else {// pitcher pitches a ball
				System.out.println(pitcher.getName() + " threw a ball");
				balls++;
				System.out.println("The count is " + balls + " balls and " + strikes + " strikes");
				if (balls == 4) {
					System.out.println(batter.getName() + " walked.");
					hitOrKOrBB = !hitOrKOrBB;
				}
			}
		}
			
	}

}
