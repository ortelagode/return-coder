package com.example.test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.example.model.Death;
import com.example.model.Villager;
import com.example.util.Util;

public class DeathTest {

	/*
	 * TEST 1 deathAge = 0; deathYear = 12; startDeathYear=1 result -1
	 * 
	 * TEST 2 deathAge = 10; deathYear = -3; startDeathYear=1 result -1
	 * 
	 * TEST 3 deathAge = 10; deathYear = 12; startDeathYear=-5 result -1
	 * 
	 * TEST 4 deathAge = 12; deathYear = 10; startDeathYear=1 result -1
	 * 
	 * TEST 5 deathAge = 10; deathYear = 12; startDeathYear=5 result -1
	 * 
	 */
	@ParameterizedTest
	@CsvSource({ "0, 12, 1", "10, -3, 1", "10, 12, -5", "12, 10, 1", "10, 12, 5" })
	public void failingScenarioTest(int deathAge, int deathYear, int startDeathYear) {
		Death death = new Death(startDeathYear);
		BigDecimal average = death.averageDeaths(Arrays.asList(new Villager(deathAge, deathYear)));
		Assertions.assertEquals(BigDecimal.valueOf(-1), average);
	}

	@Test
	public void successScenarioYear1Test() {
		Death death = new Death(1);
		BigDecimal average = death.averageDeaths(Arrays.asList(new Villager(10, 12), new Villager(13, 17)));
		Assertions.assertEquals(BigDecimal.valueOf(4.5), average);
	}

	@Test
	public void successScenarioYear3Test() {
		Death death = new Death(3);
		BigDecimal average = death.averageDeaths(Arrays.asList(new Villager(13, 19), new Villager(11, 15)));
		Assertions.assertEquals(BigDecimal.valueOf(13.5), average);
	}

	/*
	 * ... Execution time RECURSIVE for n=40 is: 319520234 Execution time RECURSIVE
	 * for n=41 is: 514500726 Execution time RECURSIVE for n=42 is: 840627137
	 * Execution time RECURSIVE for n=43 is: 1356819061 Execution time RECURSIVE for
	 * n=44 is: 2378179096 Execution time RECURSIVE for n=45 is: 3564974794
	 * Execution time RECURSIVE for n=46 is: 5564226124 Execution time RECURSIVE for
	 * n=47 is: 8814718329 Execution time RECURSIVE for n=48 is: 14172246996
	 * Execution time RECURSIVE for n=49 is: 23672313587
	 */
	@Test
	public void fibonacciRecursive() {
		for (int i = 0; i < 100; i++) {
			long start = System.nanoTime();
			Util.nextValue(i);
			long end = System.nanoTime();
			System.out.println("Execution time RECURSIVE for n=" + i + " is: " + (end - start));
		}
	}

	/*
	 * Execution time OPTIMIZED for n=77 is: 23545 Execution time OPTIMIZED for n=78
	 * is: 19639 Execution time OPTIMIZED for n=79 is: 24559 Execution time
	 * OPTIMIZED for n=80 is: 17602 Execution time OPTIMIZED for n=81 is: 21818
	 * Execution time OPTIMIZED for n=82 is: 18126 Execution time OPTIMIZED for n=83
	 * is: 26382 Execution time OPTIMIZED for n=84 is: 11352 Execution time
	 * OPTIMIZED for n=85 is: 26985 Execution time OPTIMIZED for n=86 is: 19859
	 * Execution time OPTIMIZED for n=87 is: 28805 Execution time OPTIMIZED for n=88
	 * is: 20825 Execution time OPTIMIZED for n=89 is: 27301 Execution time
	 * OPTIMIZED for n=90 is: 24890 Execution time OPTIMIZED for n=91 is: 30899
	 * Execution time OPTIMIZED for n=92 is: 24177 Execution time OPTIMIZED for n=93
	 * is: 32041 Execution time OPTIMIZED for n=94 is: 23966 Execution time
	 * OPTIMIZED for n=95 is: 31079 Execution time OPTIMIZED for n=96 is: 17923
	 * Execution time OPTIMIZED for n=97 is: 24977 Execution time OPTIMIZED for n=98
	 * is: 21110 Execution time OPTIMIZED for n=99 is: 27966 Execution time
	 * OPTIMIZED for n=100 is: 22042
	 */
	@Test
	public void fibonacciOptimized() {
		for (int i = 1; i <= 100; i++) {
			long start = System.nanoTime();
			BigInteger n = Util.fib(i);
			long end = System.nanoTime();
			System.out.println("Execution time OPTIMIZED for n=" + i + " is: " + (end - start));
			System.out.println("FIBB OPTIMIZED for n=" + i + " is: " + n);
		}
	}
}
