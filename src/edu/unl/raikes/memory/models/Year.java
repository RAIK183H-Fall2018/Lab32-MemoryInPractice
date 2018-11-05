package edu.unl.raikes.memory.models;

import java.util.ArrayList;

/**
 * Simple model class that represents a Calendar Year.
 * @author Karl Shaffer
 */
public class Year {
	private ArrayList<Month> months;
	private int year; 
	
	public Year(int year) {
		this.year = year; 
				
		// Grab the different month types from the inner enumeration. 
		Month.Type[] monthTypes = Month.Type.values(); 
		
		months = new ArrayList<Month>(); 
		for (int i = 0; i < monthTypes.length; i++) {
			months.add(new Month(this, monthTypes[i]));
		}
	}

	/**
	 * @return The {@link Month} objects corresponding to this
	 *         {@link Year}.
	 */
	public ArrayList<Month> getMonths() {
		return months;
	}

	/**
	 * @return The numerical value representing this specific year.
	 */
	public int getYear() {
		return year;
	}
}
