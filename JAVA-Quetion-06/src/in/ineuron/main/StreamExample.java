package in.ineuron.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
	public static void main(String[] args) {
		
		// Create a large dataset
		List<Integer> numbers = new ArrayList<>();
		for (int i = 1; i <= 1000000; i++) {
			numbers.add(i);
		}
		System.out.println("------------------------------");

		// Filtering the data
		List<Integer> filteredNumbers = numbers.stream().filter(n -> n % 2 == 0) // Keep only even numbers
				.collect(Collectors.toList());

		System.out.println("Filtered numbers:");
		filteredNumbers.forEach(System.out::println);
		System.out.println("------------------------------");

		// Sorting the data
		List<Integer> sortedNumbers = numbers.stream().sorted(Comparator.reverseOrder()) // Sort in descending order
				.collect(Collectors.toList());

		System.out.println("Sorted numbers:");
		sortedNumbers.forEach(System.out::println);
		System.out.println("------------------------------");
	}
}
