package com.pd.core.kattis.open;

public class MergeSortedArrays {

    public static void main(final String[] args) {
	final int inputArray1[] = { 1, 4, 5, 7, 8, 9, 12, 13, 14, 17, 40 };
	final int inputArray2[] = { 4, 5, 11, 14, 15, 17, 18, 19, 112, 122, 122, 122, 122 };

	final int[] mergedArray = new MergeSortedArrays().merge(inputArray1, inputArray2);
	for (final int curr : mergedArray) {
	    System.out.print(curr + ", ");
	}
    }

    private int[] merge(final int[] inputArray1, final int[]  inputArray2) {
	// TODO Auto-generated method stub

	final int upOneLength = inputArray1.length;
	final int upTwoLength = inputArray2.length;

	boolean isMergePending = true;
	final int[] mergedArray = new int[upOneLength + upTwoLength];

	int upOne = 0;
	int upTwo = 0;
	int curr = 0;
	while (isMergePending) {
	    // { 1, 4, 5, 7, 8, 9, 12, 13, 14, 17, 40 };
	    // { 4, 5, 11, 14, 15, 17, 18, 19, 112, 122, 122, 122, 122 };
	    if (upOne < upOneLength && upTwo < upTwoLength) {
		if (inputArray1[upOne] < inputArray2[upTwo]) {
		    mergedArray[curr++] = inputArray1[upOne++];
		}else{
		    mergedArray[curr++] = inputArray2[upTwo++];
		}
	    } else {
		while (upOne < upOneLength) {
		    mergedArray[curr++] = inputArray1[upOne++];
		}
		while (upTwo < upTwoLength) {
		    mergedArray[curr++] = inputArray2[upTwo++];
		}
	    }


	    if (upOne == upOneLength && upTwo == upTwoLength) {
		isMergePending = false;
	    }
	}
	return mergedArray;
    }
}
