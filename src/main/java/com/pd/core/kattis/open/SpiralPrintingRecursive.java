package com.pd.core.kattis.open;


/*
 *
 Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

 Input:
 1    2   3   4
 5    6   7   8
 9   10  11  12
 13  14  15  16
 Output:
 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10


 Input:
 1   2   3   4  5   6
 7   8   9  10  11  12
 13  14  15 16  17  18
 Output:
 1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11

 For example, given the following matrix:
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 You should return
 [1,2,3,6,9,8,7,4,5].


 */
import java.util.ArrayList;

public class SpiralPrintingRecursive {
    public static void main(final String args[]) {
	final SpiralPrintingRecursive spiralPrinting = new SpiralPrintingRecursive();
	spiralPrinting.start();
    }

    private void start() {
	final int[][] basic = { { 1, 2, 3, 4, 5, 6 } };
	process(basic);

	final int[][] firstInput = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
	process(firstInput);

	final int[][] secondInput = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
	process(secondInput);

	final int[][] thirdInput = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };
	process(thirdInput);

	final int[][] fourthInput = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 }, { 19, 20, 21, 22, 23, 24 } };
	process(fourthInput);

    }

    private void process(final int[][] input) {
	final ArrayList<Integer> spiral = spiralOrder(input, 0, 0, input.length, input[0].length);
	for (final int curr : spiral) {
	    System.out.print(curr + " ");
	}
	System.out.println();
    }

    public ArrayList<Integer> spiralOrder(final int[][] input2DArr, int rowX, int columnY, final int maxForX, final int maxForY) {
	final ArrayList<Integer> result = new ArrayList<Integer>();
	// only one element left

	if (maxForX <= 0 || maxForY <= 0) {
	    return result;
	}

	if (maxForX == 1 && maxForY == 1) {
	    result.add(input2DArr[rowX][columnY]);
	    return result;
	}

	// add whole row moving right
	for (int i = 0; i < maxForY - 1; i++) {
	    result.add(input2DArr[rowX][columnY++]);
	}

	// add all from current column move top to down
	for (int i = 0; i < maxForX - 1; i++) {
	    result.add(input2DArr[rowX++][columnY]);
	}

	// add whole row moving right to left
	if (maxForX > 1) {
	    for (int i = 0; i < maxForY - 1; i++) {
		result.add(input2DArr[rowX][columnY--]);
	    }
	}

	// add all from current column move up
	if (maxForY > 1) {
	    for (int i = 0; i < maxForX - 1; i++) {
		result.add(input2DArr[rowX--][columnY]);
	    }
	}

	if (maxForX == 1 || maxForY == 1) {
	    result.addAll(spiralOrder(input2DArr, rowX, columnY, 1, 1));
	} else {
	    result.addAll(spiralOrder(input2DArr, rowX + 1, columnY + 1, maxForX - 2, maxForY - 2));
	}
	return result;
    }
}
