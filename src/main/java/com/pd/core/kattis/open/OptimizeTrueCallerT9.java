package com.pd.core.kattis.open;

/*
 Sample Input 1	Sample Output 1
 4
 hi
 yes
 foo  bar
 hello world

 Case #1: 44 444
 Case #2: 999337777
 Case #3: 333666 6660 022 2777
 Case #4: 4433555 555666096667775553
 */

import java.util.Scanner;

public class OptimizeTrueCallerT9 {
    final static char[] textInput = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
	'w', 'x', 'y', 'z', ' ' };
    final static int[]  keyPress  = { 2, 22, 222, 3, 33, 333, 4, 44, 444, 5, 55, 555, 6, 66, 666, 7, 77, 777, 7777, 8, 88, 888, 9, 99, 999, 9999, 0 };

    // Lower case characters or space
    int    oldChar;
    int    oldKeyPress;

    public void readAndProess() {
	try (Scanner in = new Scanner(System.in)) {
	    final String totalCases = in.nextLine();

	    final int num = Integer.parseInt(totalCases);

	    for (int i = 0; i < num; i++) {
		final String input = in.nextLine();
		parseInputAndLog(input, i + 1);
	    }
	}
    }

    public void parseInputAndLog(final String input, final int caseNumber) {
	final StringBuilder builder = new StringBuilder("Case #").append(caseNumber).append(": ");

	if (input != null && input.length() > 0) {
	    for (final char currentChar : input.toCharArray()) {
		getKeyPresForCurrChar(currentChar);
		final int keyPressForCurrentCharacter = oldKeyPress;
		if (areCharactersFromSameKeyPressSet(keyPressForCurrentCharacter)) {
		    builder.append(" ");
		}
		builder.append(keyPressForCurrentCharacter);
	    }
	}
	System.out.println(builder.toString());
    }

    private int getKeyPresForCurrChar(final char currentChar) {

	int index = 0;
	if (currentChar == oldChar) {
	    index = oldKeyPress;
	} else {
	    for (final char charInputSet : textInput) {
		if (currentChar == charInputSet) {
		    oldKeyPress = keyPress[index];
		    break;
		}
		index++;
	    }
	}
	return keyPress[index];
    }

    private int firstDigit(int x) {
	while (x > 9) {
	    x /= 10;
	}
	return x;
    }

    private boolean areCharactersFromSameKeyPressSet(final int currentNumber) {
	final int strCurrentNumber = firstDigit(currentNumber);
	boolean result = false;
	if (oldChar == strCurrentNumber) {
	    result = true;
	}
	oldChar = strCurrentNumber;
	return result;
    }

    public static void main(final String args[]) {
	// timelimit for this is 1 second
	final OptimizeTrueCallerT9 spelling = new OptimizeTrueCallerT9();
	spelling.readAndProess();
    }
}
