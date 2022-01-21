package com.example.util;

import java.util.HashMap;
import java.util.Map;

public class Util {

	private static Map<Integer, Integer> fibMap = new HashMap<>();

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

		if (fibMap.get(n) != null) {
			return fibMap.get(n);
		}

		int k = (n & 1) == 1 ? (n + 1) / 2 : n / 2;

		int fibK = fibMap.get(k) != null ? fibMap.get(k) : fib(k);
		int fibKMinus1 = fibMap.get(k - 1) != null ? fibMap.get(k - 1) : fib(k - 1);

		int fibN = (int) ((n & 1) == 1 ? (Math.pow(fibK, 2) + Math.pow(fibKMinus1, 2))
				: (2 * fibKMinus1 + fibK) * fibK);

		fibMap.put(n, fibN);
		return fibN;

	}

}
