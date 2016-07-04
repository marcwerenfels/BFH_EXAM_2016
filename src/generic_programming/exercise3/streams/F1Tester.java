package generic_programming.exercise3.streams;

import java.util.Comparator;
import java.util.stream.Stream;

public class F1Tester {

	public static void main(String[] args) {

		Stream.generate(F1Car::new).limit(50)
				.sorted(Comparator.comparing(F1Car::getMaxSpeed).reversed())
				.map(F1Car::getTeam).distinct()
				.limit(3)
				.forEach(System.out::println);

        Stream.generate(F1Car::new).limit(50)
                .filter(c -> c.getDriver().getRacesWon() >= 8)
                .mapToInt(F1Car::getMaxSpeed).average()
                .ifPresent(System.out::println);

        Stream.generate(F1Car::new).limit(50)
                .sorted(Comparator.comparing(c -> c.getDriver().getRacesWon()))
                .limit(3)
                .map(F1Car::getDriver).map(d -> d.getFirstName() + " " + d.getLastName())
                .forEach(System.out::println);


	}

}
