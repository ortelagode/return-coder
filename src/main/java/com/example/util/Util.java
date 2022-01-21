package com.example.util;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Util {

	private static Map<Integer, BigInteger> fibMap = new HashMap<>();

	public static int nextValue(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		return nextValue(n - 2) + nextValue(n - 1);
	}

	public static BigInteger fib(int n) {
		if (n == 0)
			return BigInteger.valueOf(0);

		if (n == 1 || n == 2) {
			return BigInteger.valueOf(1);
		}

		if (fibMap.get(n) != null) {
			return fibMap.get(n);
		}

		int k = (n & 1) == 1 ? (n + 1) / 2 : n / 2;

		BigInteger fibK = fibMap.get(k) != null ? fibMap.get(k) : fib(k);
		BigInteger fibKMinus1 = fibMap.get(k - 1) != null ? (BigInteger) fibMap.get(k - 1) : (BigInteger) fib(k - 1);

		BigInteger fibN = (n & 1) == 1 ? (fibK.multiply(fibK).add(fibKMinus1.multiply(fibKMinus1)))
				: (BigInteger.valueOf(2).multiply(fibKMinus1).add(fibK).multiply(fibK));

		fibMap.put(n, fibN);
		return fibN;

	}

}
