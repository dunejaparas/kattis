package com.pd.core.kattis.open;

/*
 Question 2: Reverse and Add

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


 First submission is considered final
 */
import java.io.*;

public class Palindrome {

    int iterationsRequired = 0;
    int maxIt	      = 0;

    private void processNumber(long checkNumber) {
	checkNumber = reverseAndAdd(checkNumber);
	iterationsRequired++;

	if (isPalindrome(checkNumber)) {
	    System.out.println(iterationsRequired + " " + checkNumber);
	} else {
	    processNumber(checkNumber);
	}
    }

    private boolean isPalindrome(final long checkNumber) {
	long tempVal = checkNumber;
	long reverse = 0;

	while (tempVal != 0) {
	    final long remainder = tempVal % 10;
	    reverse = reverse * 10 + remainder;
	    tempVal = tempVal / 10;
	}
	return (checkNumber == reverse);

    }


    private long reverseAndAdd(final long checkNumber) {
	long tempVal = checkNumber;
	long reverse = 0;

	while (tempVal != 0) {
	    final long remainder = tempVal % 10;
	    reverse = reverse * 10 + remainder;
	    tempVal = tempVal / 10;
	}
	return (checkNumber + reverse);
    }


    private void readFile(final String filePath) {
	BufferedReader bufferedReader = null;
	try {
	    if (filePath != null && !filePath.trim().isEmpty()) {

		final File fileToRead = new File(filePath);
		if (fileToRead.exists()) {
		    bufferedReader = new BufferedReader(new FileReader(fileToRead));
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

		}
	    }
	} catch (final IOException e) {
	} finally {
	    try {
		if (bufferedReader != null) {
		    bufferedReader.close();
		}
	    } catch (final IOException e) {
	    }
	}
    }

    public static void main(final String[] args) {
	if (args.length == 1 && args[0] != null) {
	    final Palindrome palinObj = new Palindrome();
	    palinObj.readFile(args[0]);
	}

	// for (int i = 23000; i < 36000; i++) {
	// System.out.println(i);
	// }
    }

}
