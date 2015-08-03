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

public class SpiralPrintNonRecursive {
    public static void main(final String args[]) {
	final SpiralPrintNonRecursive spiralPrinting = new SpiralPrintNonRecursive();
	spiralPrinting.start();
    }

    private void start() {

	final int[][] basic = { { 1, 2, 3, 4, 5, 6 } };
	ArrayList<Integer> spiralOrder = spiralOrder(basic);
	System.out.println(spiralOrder);

	final int[][] secondInput = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
	spiralOrder = spiralOrder(secondInput);
	System.out.println(spiralOrder);

	final int[][] thirdInput = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };
	spiralOrder = spiralOrder(thirdInput);
	System.out.println(spiralOrder);

	final int[][] fourthInput = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 }, { 19, 20, 21, 22, 23, 24 } };
	spiralOrder = spiralOrder(fourthInput);
	System.out.println(spiralOrder);


	final int[][] firstInput = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
	spiralOrder = spiralOrder(firstInput);
	System.out.println(spiralOrder);
    }

    ArrayList<Integer> spiralOrder(final int[][] matrix) {
	final ArrayList<Integer> result = new ArrayList<Integer>();

	if (matrix.length == 0) {
	    return result;
	}

	int startRow = 0;
	int endRow = matrix.length - 1;
	int left = 0;
	int right = matrix[0].length - 1;

	while (true) {
	    // L 2 R
	    for (int i = left; i <= right; i++) {
		result.add(matrix[startRow][i]);
	    }
	    startRow++;
	    if (endRow < startRow || right < left) {
		break;
	    }
	    // T 2 B
	    for (int i = startRow; i <= endRow; i++) {
		result.add(matrix[i][right]);
	    }
	    right--;
	    if (endRow < startRow || right < left) {
		break;
	    }
	    // R 2 L
	    for (int i = right; i >= left; i--) {
		result.add(matrix[endRow][i]);
	    }
	    endRow--;
	    if (endRow < startRow || right < left) {
		break;
	    }
	    for (int i = endRow; i >= startRow; i--) {
		result.add(matrix[i][left]);
	    }
	    left++;
	    if (endRow < startRow || right < left) {
		break;
	    }
	}
	return result;
    }
}
