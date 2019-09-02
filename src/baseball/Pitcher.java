package baseball;
import java.util.Random;

public class Pitcher extends Player {
	private String position;
	private double strikeAverage; // measures pitcher's control, doesn't take into account velo, spin rate, etc.
	
	public Pitcher(String fName, String lName, String pos, double strikeAverage) {
		super(fName, lName);
		position = pos;
		this.strikeAverage = strikeAverage;
	}
	
	public boolean pitch() {
		// uses pitcher's strikeAverage to determine whether he throws a strike
		// (method returns true) or a ball (method returns false)
		Random r = new Random();
		return (r.nextDouble() < strikeAverage);
	}
	
	public String getName() {
		return super.getName();
	}
}
