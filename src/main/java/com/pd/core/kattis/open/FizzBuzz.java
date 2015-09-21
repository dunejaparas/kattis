package com.pd.core.kattis.open;

/*
 Write a program that prints the numbers from 1 to 100.
 But for multiples of three print "Fizz" instead of the number
 and for the multiples of five print "Buzz".
 For numbers which are multiples of both three and five print "FizzBuzz".
 */

public class FizzBuzz {

	public static void main(final String args[]) {
		for (int index = 0; index < 99; index++) {
			if (index % 3 == 0 && index % 5 == 0) {
				System.out.println(index + "  FizzBuzz");
			} else if (index % 3 == 0) {
				System.out.println(index + "  Fizz");
			} else if (index % 5 == 0) {
				System.out.println(index + "  Buzz");
			} else {
				System.out.println(index);
			}
		}
	}
}
