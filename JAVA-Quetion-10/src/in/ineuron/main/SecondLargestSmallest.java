package in.ineuron.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SecondLargestSmallest {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();

		try (// Read integers from the user
		Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter the number of elements: ");
			int count = scanner.nextInt();
			System.out.println("Enter the elements:");

			for (int i = 0; i < count; i++) {
				int num = scanner.nextInt();
				numbers.add(num);
			}
		}
		// Find the second largest and second smallest elements
		int secondLargest = findSecondLargest(numbers);
		int secondSmallest = findSecondSmallest(numbers);

		// Print the results
		System.out.println("Second largest element: " + secondLargest);
		System.out.println("Second smallest element: " + secondSmallest);
	}

	public static int findSecondLargest(List<Integer> numbers) {
		if (numbers.size() < 2) {
			throw new IllegalArgumentException("List should contain at least two elements.");
		}

		List<Integer> sortedList = new ArrayList<>(numbers);
		Collections.sort(sortedList, Collections.reverseOrder());
		return sortedList.get(1);
	}

	public static int findSecondSmallest(List<Integer> numbers) {
		if (numbers.size() < 2) {
			throw new IllegalArgumentException("List should contain at least two elements.");
		}

		List<Integer> sortedList = new ArrayList<>(numbers);
		Collections.sort(sortedList);
		return sortedList.get(1);
	}
}
