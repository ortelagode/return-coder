package com.example.test;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.example.model.Death;
import com.example.model.Villager;

public class DeathTest {

	@ParameterizedTest
	@CsvSource({ "0, 12, 1", "10, -3, 1", "10, 12, -5", "12, 10, 1", "10, 12, 5" })
	public void code(int deathAge, int deathYear, int startDeathYear) {
		Death death = new Death(startDeathYear);
		double average = death.averageDeaths(Arrays.asList(new Villager(deathAge, deathYear)));
		Assertions.assertEquals(-1.0, average);
	}

	@Test
	public void test() {
		Death death = new Death(1);
		double average = death.averageDeaths(Arrays.asList(new Villager(10, 12), new Villager(13, 17)));
		Assertions.assertEquals(4.5, average);
	}
}
