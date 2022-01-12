package com.example.model;

public class Villager {

	private int birthYear;
	private int deathAge;
	private int deathYear;

	public Villager(int deathAge, int deathYear) {
		this.deathAge = deathAge;
		this.deathYear = deathYear;
	}

	public void setBirthYear(int startDeathYear) {
		this.birthYear = this.deathYear - this.deathAge;
		if (this.deathAge < 1 || this.deathYear < 1 || startDeathYear < 1 || this.deathYear < this.deathAge
				|| this.birthYear < startDeathYear) {
			this.birthYear = -1;
		}
	}

	public int getBirthYear() {
		return birthYear;
	}

}
