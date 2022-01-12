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

}
