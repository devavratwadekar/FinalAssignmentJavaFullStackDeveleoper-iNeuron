package in.ineuron.main;

import java.util.Scanner;

public class NegativeNumberExceptionDemo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.print("Enter a positive integer: ");
			int number = scanner.nextInt();

			if (number < 0) {
				throw new NegativeNumberException("Negative number not allowed");
			}

			System.out.println("You entered: " + number);
		} catch (NegativeNumberException e) {
			System.out.println("Exception caught: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Invalid input. Please enter a valid positive integer.");
		} finally {
			scanner.close();
		}
	}
}

class NegativeNumberException extends Exception {

	private static final long serialVersionUID = 1L;

	public NegativeNumberException(String message) {
		super(message);
	}
}
