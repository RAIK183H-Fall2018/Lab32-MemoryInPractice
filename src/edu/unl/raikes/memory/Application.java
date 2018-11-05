package edu.unl.raikes.memory;

import edu.unl.raikes.memory.models.Year;
import edu.unl.raikes.memory.profiling.SimpleProfiler;

/**
 * Main runner for the Memory Usage Lab.
 * @author Karl Shaffer
 */
public class Application {
	
	/**
	 * Main for the application. Profiles the creation of all the years.
	 * @param args The application arguments.
	 */
	public static void main(String args[]) {
		SimpleProfiler profiler = new SimpleProfiler().start(); 
		
		// 2018 + 1 to account for year zero.
		Year[] years = new Year[2019]; 
		
		// Create the years from year 0 until 2018.
		for (int i = 0; i <= 2018; i++) {
			years[i] = new Year(i);
		}
		
		profiler.stop(); 
		System.out.println(profiler.getReport());
	}
}
