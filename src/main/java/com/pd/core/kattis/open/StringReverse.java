package com.pd.core.kattis.open;

public class StringReverse {

	public static void main(final String[] args) {
		final StringReverse stringReverse = new StringReverse();
		// reverse a string (input : Hel'lo output: oll'eh) special characters
		// retain their position

		stringReverse.process("hel'lo");
		stringReverse.process("HeL'lo");
	}

	private void process(final String inputString) {
		System.out.print(inputString + "\t\t");
		final int length = inputString.length();

		final char[] input = inputString.toCharArray();
		for (int up = 0, down = length - 1; up < down; up++, down--) {
			if (isNAAlphabet(input[up])) {
				up++;
			}
			if (isNAAlphabet(input[down])) {
				down--;
			}

			final char tmp = input[up];
			input[up] = input[down];
			input[down] = tmp;
		}

		System.out.println(new String(input));
	}

	private boolean isNAAlphabet(final char inputChar) {
		if ((inputChar <= 'a' || 'z' <= inputChar) && (inputChar <= 'A' || 'Z' <= inputChar)) {
			return true;
		}
		return false;
	}
}