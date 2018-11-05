package edu.unl.raikes.memory.models;

/**
 * Simple model class that models a Calendar Day. 
 * @author Karl Shaffer
 */
public class Day {
	private Month month; 
	private Year year; 
	private int day; 
	
	public Day(Year year, Month month, int day) {
		this.year = year;
		this.month = month; 
		this.day = day; 
	}

	/**
	 * @return The {@link Month} corresponding to this specific 
	 *             {@link Day}.
	 */
	public Month getMonth() {
		return month;
	}

	/**
	 * @return The {@link Year} corresponding to this specific 
	 * 		   {@link Year}.
	 */
	public Year getYear() {
		return year;
	}

	/**
	 * @return The numerical value for a this specific day. 
	 *         
	 */
	public int getDay() {
		return day;
	}
}
