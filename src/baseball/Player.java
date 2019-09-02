package baseball;

public abstract class Player {
	//public static int outs = 0;
	
	private String firstName;
	private String lastName;
	
	public Player(String fname, String lname) {
		firstName = fname;
		lastName = lname;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getName() {
		return firstName + " " + lastName;
	}
}
