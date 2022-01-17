package com.example.model;

import java.util.List;

import com.example.util.Util;

/**
 * Contains all operations of deaths in a year
 * 
 * @author godeo
 *
 */
public class Death {

	private final int startDeathYear;

	public Death(int startDeathYear) {
		this.startDeathYear = startDeathYear;
	}

	/**
	 * @param villagers
	 * @return the average of all deaths that have happened in the years these
	 *         villagers were born
	 */
	public double averageDeaths(List<Villager> villagers) {
		int sumOfDeaths = 0;
		if (villagers.size() == 0) {
			return 0;
		}
		for (Villager villager : villagers) {
			villager.setBirthYear(startDeathYear);
			if (villager.getBirthYear() == -1) {
				return -1;
			}
			sumOfDeaths = sumOfDeaths + deathsPerYear(villager.getBirthYear());
		}
		return (double) sumOfDeaths / villagers.size();
	}

	/**
	 * @param year
	 * @return number of deaths in a specific year
	 */
	private int deathsPerYear(int year) {
		int deathCount = 0;
		for (int i = 1; i <= year; i++) {
			deathCount = deathCount + Util.fib(i);
		}
		return deathCount;
	}

}
