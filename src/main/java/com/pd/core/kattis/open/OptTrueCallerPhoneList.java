package com.pd.core.kattis.open;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class OptTrueCallerPhoneList {

    public void readAndProcess(final InputStreamReader in) throws IOException, InterruptedException {
	try (final BufferedReader br = new BufferedReader(in)) {
	    final String numTestCases = br.readLine();
	    final int num = Integer.parseInt(numTestCases);// All sane input
	    for (int i = 0; i < num; i++) {
		final String phoneNumbersCountInTest = br.readLine();
		final int totalPhoneNumbers = Integer.parseInt(phoneNumbersCountInTest);
		final ArrayList<String> allNumbersAL = new ArrayList<String>();

		for (int numbersCount = 0; numbersCount < totalPhoneNumbers; numbersCount++) {
		    final String phoneNumber = br.readLine();
		    allNumbersAL.add(phoneNumber);
		}

		isConsistent = true;
		checkDataUsingThread(totalPhoneNumbers, allNumbersAL);
		if (isConsistent) {
		    System.out.println("YES");
		} else {
		    System.out.println("NO");
		}
	    }
	}
    }

    private void checkDataUsingThread(final int totalPhoneNumbers, final ArrayList<String> allNumbersAL) throws InterruptedException {
	final Thread thread = new Thread(new Runnable() {
	    @Override
	    public void run() {
		Collections.sort(allNumbersAL);
		parseInputAndPrint(allNumbersAL);
	    }
	});
	thread.start();
	thread.join();
    }


    boolean isConsistent = true;

    private void setConsistent(final boolean newValue) {
	isConsistent = newValue;
    }

    public void parseInputAndPrint(final ArrayList<String> currNumAL) {
	final int totalPhoneNumbers = currNumAL.size();
	for (int outerLoop = 0; outerLoop < totalPhoneNumbers - 1; outerLoop++) {
	    final String firstNumber = currNumAL.get(outerLoop);
	    final String nextNumber = currNumAL.get(outerLoop + 1);
	    if (isPrefix(firstNumber, nextNumber)) {
		setConsistent(false);
		break;
	    }
	    if (!isConsistent) {
		break;
	    }

	}

    }

    public boolean isPrefix(final String outerNumber, final String innerNumber) {
	final int outerLength = outerNumber.length();
	final int innerLength = innerNumber.length();
	if (outerLength != innerLength) {
	    final String smallerNumber = outerLength < innerLength ? outerNumber : innerNumber;
	    final String largerNumber = outerLength > innerLength ? outerNumber : innerNumber;
	    return largerNumber.startsWith(smallerNumber);
	}
	return outerNumber.equals(innerNumber);
    }

    public static void main(final String[] args) throws IOException, InterruptedException {
	final OptTrueCallerPhoneList solvedPhoneList = new OptTrueCallerPhoneList();
	solvedPhoneList.readAndProcess(new InputStreamReader(System.in));
    }
}