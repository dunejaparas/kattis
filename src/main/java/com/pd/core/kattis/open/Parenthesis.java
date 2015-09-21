package com.pd.core.kattis.open;

/*
 Question 1: Parenthesis

 Given a string made up of the following 6 characters ( ) { } [ ] determine if it is well-formed or not.
 Well-formed meaning Parentheses, braces and brackets match in nested pairs.

 Your program should accept as its first argument a path to a filename. Each line in this file contains a
 string comprising the characters mentioned above. e.g.

 ({[()]})
 ([)]

 Print out True or False if the string is well-formed e.g. for the example above:

 True
 False
 */

import java.io.*;
import java.util.Stack;

public class Parenthesis {
	private static final char OPEN_SQUARE = '[';
	private static final char OPEN_BRACKET = '(';
	private static final char OPEN_CURLY = '{';
	private static final char CLOSE_SQUARE = ']';
	private static final char CLOSE_BRACKET = ')';
	private static final char CLOSE_CURLY = '}';

	public boolean isParentesisOK(final String checkCurrentLine) {
		final Stack<Character> bracesStack = new Stack<Character>();
		for (int i = 0; i < checkCurrentLine.length(); i++) {
			final char currChar = checkCurrentLine.charAt(i);
			if (currChar == OPEN_CURLY || currChar == OPEN_BRACKET || currChar == OPEN_SQUARE) {
				bracesStack.push(currChar);
			}

			if (currChar == CLOSE_CURLY || currChar == CLOSE_BRACKET || currChar == CLOSE_SQUARE) {
				if (bracesStack.isEmpty()) {
					return false;
				}

				final char lastBrace = bracesStack.peek();
				if (currChar == CLOSE_CURLY && lastBrace == OPEN_CURLY
						|| currChar == CLOSE_BRACKET && lastBrace == OPEN_BRACKET
						|| currChar == CLOSE_SQUARE && lastBrace == OPEN_SQUARE) {
					bracesStack.pop();
				} else {
					return false;
				}
			}
		}
		return bracesStack.isEmpty();
	}

	public void readFile(final String filePath) {
		if (filePath != null && !filePath.trim().isEmpty()) {
			final File fileToRead = new File(filePath);
			if (fileToRead.exists()) {
				try (final BufferedReader bufferedReader = new BufferedReader(new FileReader(fileToRead))) {
					if (bufferedReader.ready()) {
						String currLine = null;
						while ((currLine = bufferedReader.readLine()) != null) {
							if (isParentesisOK(currLine)) {
								System.out.println("True");
							} else {
								System.out.println("False");
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
		String filePath = "./src/main/java/com/pd/core/kattis/open/inputFileParenthesis.txt";
		if (args.length == 1 && args[0] != null) {
			filePath = args[0];
		}
		final Parenthesis parenthesisCheckObj = new Parenthesis();
		parenthesisCheckObj.readFile(filePath);
	}

}
