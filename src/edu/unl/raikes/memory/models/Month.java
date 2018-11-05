package edu.unl.raikes.memory.models;

import java.util.ArrayList;

/** 
 * Simple model class that represents a Calendar Month. 
 * @author Karl Shaffer
 */
public class Month {
	
	enum Type  {
		JANUARY(1, 31), 
		FEBRUARY(2, 28),
		MARCH(3, 31),
		APRIL(4, 30),
		MAY(5, 31),
		JUNE(6, 30),
		JULY(7, 31),
		AUGUST(8, 31),
		SEPTEMBER(9, 30),
		OCTOBER(10, 31),
		NOVEMBER(11, 30),
		DECEMBER(12, 31);
		
		private int numDays; 
		private int numericalValue; 
		
		Type(int numericalValue, int numDays) {
			this.numericalValue = numericalValue; 
			this.numDays = numDays; 
		}

		/**
		 * @return the numDays
		 */
		public int getNumDays() {
			return numDays;
		}

		/**
		 * @return the numericalValue
		 */
		public int getNumericalValue() {
			return numericalValue;
		}
	}
	
	private Year year;
	private int month;
	private Type type; 
	private ArrayList<Day> days;
	
	public Month(Year year, Type type) {
		this.year = year;
		this.type = type; 
		this.month = type.getNumericalValue(); 
		
		days = new ArrayList<Day>(); 
		for (int i = 0; i < type.getNumDays(); i++) {
			days.add(new Day(year, this, i + 1)); 
		}
	}

	/**
	 * @return the year
	 */
	public Year getYear() {
		return year;
	}

	/**
	 * @return The numerical representation of this specific month. 
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @return The {@link Type} of month given which this {@link Month} 
	 *         refers to which references the different Months (Jan, Feb, etc). 
	 */
	public Type getType() {
		return type;
	}

	/**
	 * @return The {@link Day} objects corresponding to this {@link Month}.
	 */
	public ArrayList<Day> getDays() {
		return days;
	}
	
}
