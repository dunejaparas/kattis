package com.pd.core.kattis.open;

public class SwapNumbersNoThirdVar {

    public static void main(final String[] args) {
	int a = 7;
	int b = 9;

	System.out.println(a);
	System.out.println(b);
	a = a + b;
	b = a - b;
	a = a - b;
	System.out.println(a);
	System.out.println(b);
	a = a ^ b;
	b = a ^ b;
	a = a ^ b;
	System.out.println(a);
	System.out.println(b);

    }

}
