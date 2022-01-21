package com.example.model;

import java.math.BigDecimal;
import java.math.BigInteger;
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
	public BigDecimal averageDeaths(List<Villager> villagers) {
		BigInteger sumOfDeaths = BigInteger.valueOf(0);
		if (villagers.size() == 0) {
			return BigDecimal.valueOf(0);
		}
		for (Villager villager : villagers) {
			villager.setBirthYear(startDeathYear);
			if (villager.getBirthYear() == -1) {
				return BigDecimal.valueOf(-1);
			}
			sumOfDeaths = sumOfDeaths.add(deathsPerYear(villager.getBirthYear()));
		}
		return new BigDecimal(sumOfDeaths).divide(BigDecimal.valueOf(villagers.size()));
	}

	/**
	 * @param year
	 * @return number of deaths in a specific year
	 */
	private BigInteger deathsPerYear(int year) {
		BigInteger deathCount = BigInteger.valueOf(0);
		for (int i = 1; i <= year; i++) {
			deathCount = deathCount.add(Util.fib(i));
		}
		return deathCount;
	}

}
