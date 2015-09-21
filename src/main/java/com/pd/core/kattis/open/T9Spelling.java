package com.pd.core.kattis.open;

import java.util.HashMap;
import java.util.Scanner;

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

public class T9Spelling {

	// Lower case characters or space
	char oldChar;

	public void readAndProess() {
		try (Scanner in = new Scanner(System.in)) {
			final String totalCases = in.nextLine();

			int num = -1;
			num = Integer.parseInt(totalCases);
			final HashMap<String, Integer> inputToStringMap = T9CallerMap.INSTANCE.getInputToStringMap();

			for (int i = 0; i < num; i++) {
				final String input = in.nextLine();
				parseInputAndLog(input, i + 1, inputToStringMap);
			}
		}
	}

	public void parseInputAndLog(final String input, final int caseNumber,
			final HashMap<String, Integer> inputToStringMap) {
		final StringBuilder builder = new StringBuilder("Case #").append(caseNumber).append(": ");

		Integer prevNum = null;
		if (input != null && input.length() > 0) {
			for (int index = 0; index < input.length(); index++) {
				final char currentChar = input.charAt(index);
				// New String will make a new string for every input thus
				// increasing memory usage
				final Integer keyPressForCurrentCharacter = inputToStringMap.get(currentChar + "");
				if (areTwoConsecutiveCharactersSame(input, index, currentChar)
						|| areCharactersFromSameKeyPressSet(prevNum, keyPressForCurrentCharacter)) {
					builder.append(" ");
				}
				builder.append(keyPressForCurrentCharacter);
				prevNum = keyPressForCurrentCharacter;
			}
		}
		System.out.println(builder.toString());
	}

	private boolean areTwoConsecutiveCharactersSame(final String input, final int index, final char currentChar) {
		return index > 0 && currentChar == input.charAt(index - 1);
	}

	private boolean areCharactersFromSameKeyPressSet(final Integer prevNum, final Integer currentNumber) {

		final char strPrevNum = oldChar;
		final char strCurrentNumber = String.valueOf(currentNumber).charAt(0);

		boolean result = false;
		if (strPrevNum == strCurrentNumber) {

			result = true;
		}
		oldChar = strCurrentNumber;
		return result;
	}

	public static void main(final String args[]) {
		// timelimit for this is 1 second
		final T9Spelling spelling = new T9Spelling();
		spelling.readAndProess();
	}
}

enum T9CallerMap {

	INSTANCE;
	/*
	 * To insert the character ‘B’ for instance, the program would press “22”.
	 * In order to insert two characters in sequence from the same key, the user
	 * must pause before pressing the key a second time. The space character ‘ ’
	 * should be printed to indicate a pause. For example, “2 2” indicates “AA”
	 * whereas “22” indicates “B”.
	 */

	final String SPACE = " ";

	enum String2Integer {
		a(2), b(22), c(222), d(3), e(33), f(333), g(4), h(44), i(444), j(5), k(55), l(555), m(6), n(66), o(666), p(
				7), q(77), r(777), s(7777), t(8), u(88), v(888), w(9), x(99), y(999), z(9999);
		// Pressing zero emits a space
		Integer enuStr;

		private String2Integer(final Integer enuStr) {
			this.enuStr = enuStr;
		}

		public Integer numberInput() {
			return enuStr;
		}
	};

	HashMap<String, Integer> keysToCharMap;

	public HashMap<String, Integer> getInputToStringMap() {
		if (keysToCharMap == null) {
			load();
		}
		return keysToCharMap;
	}

	public void load() {
		if (keysToCharMap == null) {
			// Create a map of exact requirement, since it's known
			keysToCharMap = new HashMap<String, Integer>(27);
			for (final String2Integer currValue : String2Integer.values()) {
				keysToCharMap.put(currValue.toString(), currValue.enuStr);
			}
			{
				// Add SPECIAL CASE
				keysToCharMap.put(SPACE, 0);
			}
		}
	}
}