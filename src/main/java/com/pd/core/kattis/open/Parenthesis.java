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
    public boolean isParentesisOK(final String checkCurrentLine) {
	final Stack<Character> bracesStack = new Stack<Character>();
	for (int i = 0; i < checkCurrentLine.length(); i++) {
	    final char currChar = checkCurrentLine.charAt(i);
	    if (currChar == '{' || currChar == '(' || currChar == '[') {
		bracesStack.push(currChar);
	    }

	    if (currChar == '}' || currChar == ')' || currChar == ']') {
		if (bracesStack.isEmpty()) {
		    return false;
		}

		final char lastBrace = bracesStack.peek();
		if (currChar == '}' && lastBrace == '{' || currChar == ')' && lastBrace == '(' || currChar == ']' && lastBrace == '[') {
		    bracesStack.pop();
		} else {
		    return false;
		}
	    }
	}
	return bracesStack.isEmpty();
    }


    public void readFile(final String filePath) {
	BufferedReader bufferedReader = null;
	try {
	    if (filePath != null && !filePath.trim().isEmpty()) {
		final File fileToRead = new File(filePath);
		if (fileToRead.exists()) {
		    bufferedReader = new BufferedReader(new FileReader(fileToRead));
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
	    final Parenthesis parenthesisCheckObj = new Parenthesis();
	    parenthesisCheckObj.readFile(args[0]);
	}
    }

}
