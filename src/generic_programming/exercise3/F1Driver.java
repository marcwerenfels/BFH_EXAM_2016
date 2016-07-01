package generic_programming.exercise3;

import java.util.Random;

public class F1Driver {
	
	private String lastName;
	private String firstName;
	private int age;
	private int racesWon;
	
	private static Random random = new Random();
	
	public static String[] names = {"Hamilton", "Rosberg", "Vettel", "Raikkonen", "Bottas", "Massa"};

	public F1Driver() {
		this.lastName = names[random.nextInt(names.length)];
		this.firstName = (char) (65+random.nextInt(26)) + ".";
		this.age = random.nextInt(20) + 20;
		this.racesWon = random.nextInt(10);
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public int getAge() {
		return age;
	}

	public int getRacesWon() {
		return racesWon;
	}
		

}

