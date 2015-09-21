package com.pd.core.kattis.open;

/*
 Reverse and Add

	 The problem is as follows: choose a number, reverse its digits and add it to the original.
	 If the sum is not a palindrome ( which means, it is not the same number from left to right
	 and right to left), repeat this procedure. eg.

	 input 195
	 195 (initial number) + 591 (reverse of initial number) = 786
	 786 + 687 = 1473
	 1473 + 3741 = 5214
	 5214 + 4125 = 9339 (palindrome)

	 In this particular case the palindrome 9339 appeared after the 4th addition. This method leads
	 to palindromes in a few step  for almost all of the integers. But there are interesting exceptions.
	 196 is the first number for which no palindrome has been found. It is not proven though, that there
	 is no such a palindrome.

	 Your program should accept as its first argument a path to a filename. Each line in this file is one
	 test case. Each test case will contain an integer n < 4,294,967,295. Assume each test case will
	 always have an answer and that it is computable with less  than 1000 iterations (additions)

	 For each line of input, generate a line of output which is the number of iterations (additions) to
	 compute the palindrome and the resulting palindrome. (they should be on one line and separated by a
	 single space character)
 */
import java.io.*;

public class Palindrome {

	private static final String MESSAGE_REACHED_MAX = "Reached %s iterations. Palindrome not found";
	int iterationsRequired = 0;
	final int MAX_ITERATIONS = 1000;

	private void processNumber(long checkNumber) {
		checkNumber = reverseAndAdd(checkNumber);
		iterationsRequired++;
		if (iterationsRequired >= MAX_ITERATIONS) {
			System.out.println(String.format(MESSAGE_REACHED_MAX, MAX_ITERATIONS));
		} else {
			if (isPalindrome(checkNumber)) {
				System.out.println(iterationsRequired + " " + checkNumber);
			} else {
				processNumber(checkNumber);
			}
		}
	}

	private boolean isPalindrome(final long inputNumber) {
		final long reversedNumber = getReversedNumber(inputNumber);
		return (inputNumber == reversedNumber);
	}

	private long reverseAndAdd(final long inputNumber) {
		final long reversedNumber = getReversedNumber(inputNumber);
		return (inputNumber + reversedNumber);
	}

	private long getReversedNumber(final long inputNumber) {
		long reducingNumber = inputNumber;
		long reversedNumber = 0;

		while (reducingNumber != 0) {
			final long modValue = reducingNumber % 10;
			reversedNumber = reversedNumber * 10 + modValue;
			reducingNumber = reducingNumber / 10;
		}
		return reversedNumber;
	}

	private void readFile(final String filePath) {
		if (filePath != null && !filePath.trim().isEmpty()) {

			final File fileToRead = new File(filePath);
			if (fileToRead.exists()) {
				try (final BufferedReader bufferedReader = new BufferedReader(new FileReader(fileToRead))) {
					if (bufferedReader.ready()) {
						String currLine = null;
						while ((currLine = bufferedReader.readLine()) != null) {

							iterationsRequired = 0;
							final long inputValue = Long.parseLong(currLine);

							if (inputValue >= 0 && inputValue < 4294967295l) {
								processNumber(inputValue);
							}
						}
					}
				} catch (final IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(final String[] args) {
		String filePath = "./src/main/java/com/pd/core/kattis/open/inputFilePalindrome.txt";
		if (args.length == 1 && args[0] != null) {
			filePath = args[0];
		}
		final Palindrome palinObj = new Palindrome();
		palinObj.readFile(filePath);
	}

}
