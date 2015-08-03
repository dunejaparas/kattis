package com.pd.core.kattis.open;

import java.util.Arrays;

/**
 * This method receives an array with positive integers, where all values in the
 * array are repeated - except for one which is unique. Return the unique
 * element in the array.
 *
 * @param intArray
 *            [] array of ints
 * @return the non-repeated int
 *
 *         e.g.
 *         int[] arr = {1,2,3,5,6,3,2,5,1,32,32,3,4,4,1}
 *         int nonRepeated = findNonRepeatedInt(arr);
 *         System.out.println(nonRepeated);
 *         // should print 6
 *
 */
public class FindNonRepeating {
    public static void main(final String[] args) {
	final int arr[] = { 1, 2, 3, 5, 6, 3, 2, 5, 1, 32, 32, 3, 4, 4, 1 };
	System.out.println(nonRepeatingElement(arr));
	System.out.println(findNonRepeatedIntPD(arr));

	final int[] onlineDataSet = { 3, 4, 1, 3, 1, 7, 2, 2, 4 };
	System.out.println(nonRepeatingElement(onlineDataSet));
	System.out.println(findNonRepeatedIntPD(onlineDataSet));

    }


    static int findNonRepeatedIntPD(final int[] intArr) {
	Arrays.sort(intArr);

	// Three test data sets
	// 7 1,2,3,1,0,3,2,7
	// 0 1 1 2 2 3 3 7 7

	// 7 1,2,3,1,6,3,2,7
	// 1 1 2 2 3 3 6 7 7

	// 7 1,2,3,1,9,3,2,7 9 8
	// 1 1 2 2 3 3 7 7 9 779 5

	int nonRepeatedNumber = -1;
	for (int i = 0; i < intArr.length - 2; i++) {
	    if (i == 0 && intArr[0] < intArr[1]) {
		nonRepeatedNumber = intArr[i];
	    } else if (intArr[i] < intArr[i + 1] && intArr[i + 1] < intArr[i + 2]) {
		nonRepeatedNumber = intArr[i + 1];
	    } else if (i == intArr.length - 3) {
		if (intArr[intArr.length - 2] < intArr[intArr.length - 1]) {
		    nonRepeatedNumber = intArr[intArr.length - 1];
		}
	    }
	}
	return nonRepeatedNumber;
    }

    static int nonRepeatingElement(final int[] a) {
	int element = 0;

	for (final int element2 : a) {
	    element ^= element2;
	}

	return element;
    }
}

