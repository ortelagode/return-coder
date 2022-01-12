package com.example.model;

import java.util.List;

import com.example.util.Util;

public class Death {

	private final int startDeathYear;

	public Death(int startDeathYear) {
		this.startDeathYear = startDeathYear;
	}

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

	private int deathsPerYear(int year) {
		int deathCount = 0;
		for (int i = 1; i <= year; i++) {
			deathCount = deathCount + Util.nextValue(i);
		}
		return deathCount;
	}

}
