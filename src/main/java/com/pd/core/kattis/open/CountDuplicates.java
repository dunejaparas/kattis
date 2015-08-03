package com.pd.core.kattis.open;

public class CountDuplicates {

    public static void main(final String[] args) {
	final int dupArray[] = { 1, 4, 4, 5, 5, 7, 8, 9, 11, 12, 13, 14, 14, 15, 17, 17, 18, 19, 40, 112, 122, 122, 122, 122 };
	final int duplicatesCount = new CountDuplicates().getDuplicatesCount(dupArray);
	System.out.println("duplicatesCount " + duplicatesCount);
    }

    private int getDuplicatesCount(final int[] dupArray) {
	int count = 0;
	int prevDup = -1;
	for (int index = 0; index < dupArray.length - 1; index++) {
	    if (dupArray[index] == dupArray[index + 1] && prevDup != dupArray[index]) {
		count++;
		prevDup = dupArray[index];
	    }
	}
	return count;
    }

}
