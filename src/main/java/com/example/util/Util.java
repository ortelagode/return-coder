package com.example.util;

public class Util {

	public static int nextValue(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		return nextValue(n - 2) + nextValue(n - 1);
	}

	public static int fib(int n) {
		if (n == 0)
			return 0;

		if (n == 1 || n == 2) {
			return 1;
		}

		int k = (n & 1) == 1 ? (n + 1) / 2 : n / 2;

		int fibK = fib(k);
		int fibKMinus1 = fib(k - 1);

		return (int) ((n & 1) == 1 ? (Math.pow(fibK, 2) + Math.pow(fibKMinus1, 2)) : (2 * fibKMinus1 + fibK) * fibK);

	}

}
