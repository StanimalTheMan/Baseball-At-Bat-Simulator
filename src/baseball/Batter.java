package baseball;
import java.util.Random;

public class Batter extends Player {
	private String position;
	private double average;
	
	public Batter(String fName, String lName, String pos, double avg) {
		super(fName, lName);
		position = pos;
		average = avg;
	}
	
	public boolean hit() {
		// Assume pitcher has thrown a strike, use batter's average to determine whether he hits the pitch
		// (method returns true) or swings and misses (method returns false)
		Random r = new Random(); // might be inefficient to locate random here
		return (r.nextDouble() < average);
	}
	
	public String getName() {
		return super.getName();
	}
}
