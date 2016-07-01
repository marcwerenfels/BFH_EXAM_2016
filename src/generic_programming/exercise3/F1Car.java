package generic_programming.exercise3;

import java.util.Random;

public class F1Car {
	
	private String team;
	private int maxSpeed;
	private F1Driver driver;
	
	private static Random random = new Random();
		
	public static String[] teams = {"Mercedes", "Ferrari", "Williams", "RedBull", "Renault", "Sauber"};

	public F1Car() {
		this.team = teams[random.nextInt(teams.length)];
		this.maxSpeed = 250 + random.nextInt(50);
		this.driver = new F1Driver();
	}
	
	public String getTeam() {
		return team;
	}


	public int getMaxSpeed() {
		return maxSpeed;
	}


	public F1Driver getDriver() {
		return driver;
	}
}

