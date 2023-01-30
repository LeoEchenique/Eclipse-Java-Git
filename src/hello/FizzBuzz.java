package hello;

import java.util.Scanner;

public class FizzBuzz {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number: ");
		String input = scanner.nextLine();

		int number = Integer.parseInt(input);
		scanner.close();

		String result = calculateResult(number);

		System.out.println(result);

	}

	public static String calculateResult(int number) {

		if (number % 3 == 0 && number % 5 == 0) return "FizzBuzz";
		if (number % 5 == 0) return "Fizz";
		if (number % 3 == 0) return "Buzz";
		return Integer.toString(number) + " NOPE";
	}
}
