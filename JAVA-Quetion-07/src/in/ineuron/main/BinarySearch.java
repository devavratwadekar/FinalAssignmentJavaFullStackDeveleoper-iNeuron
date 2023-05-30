package in.ineuron.main;

import java.util.Scanner;

public class BinarySearch {
	public static void main(String[] args) {
		int[] sortedArray = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 }; // Sorted array to search in

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the target value: ");
		int target = scanner.nextInt();

		int index = binarySearch(sortedArray, target);

		if (index != -1) {
			System.out.println("Target value found at index " + index);
		} else {
			System.out.println("Target value not found in the array.");
		}
	}

	public static int binarySearch(int[] array, int target) {
		int left = 0;
		int right = array.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (array[mid] == target) {
				return mid; // Target found at index mid
			} else if (array[mid] < target) {
				left = mid + 1; // Search in the right half
			} else {
				right = mid - 1; // Search in the left half
			}
		}

		return -1; // Target not found
	}
}
