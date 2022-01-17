package com.example.model;

/**
 * This Villager class holds the information about a villager. Year of birth,
 * death age and death year.
 * 
 * @author godeo
 */
public class Villager {

	private int birthYear;
	private int deathAge;
	private int deathYear;

	/**
	 * @param deathAge
	 * @param deathYear
	 */
	public Villager(int deathAge, int deathYear) {
		this.deathAge = deathAge;
		this.deathYear = deathYear;
	}

	/**
	 * This method calculates and sets birthYear by checking edge cases.
	 * 
	 * @param startDeathYear
	 */
	public void setBirthYear(int startDeathYear) {
		this.birthYear = this.deathYear - this.deathAge;
		if (this.deathAge < 1 || this.deathYear < 1 || startDeathYear < 1 || this.deathYear < this.deathAge
				|| this.birthYear < startDeathYear) {
			this.birthYear = -1;
		}
	}

	/**
	 * @return birthYear
	 */
	public int getBirthYear() {
		return birthYear;
	}

	/**
	 * @return deathYear
	 */
	public int getDeathAge() {
		return deathAge;
	}

	/**
	 * @param deathAge
	 */
	public void setDeathAge(int deathAge) {
		this.deathAge = deathAge;
	}

	/**
	 * @return deathYear
	 */
	public int getDeathYear() {
		return deathYear;
	}

	/**
	 * @param deathYear
	 */
	public void setDeathYear(int deathYear) {
		this.deathYear = deathYear;
	}

}
