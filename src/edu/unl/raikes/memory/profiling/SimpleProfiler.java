package edu.unl.raikes.memory.profiling;

/**
 * A very simple memory profiler that leverages the Java Runtime 
 * for a rough approximation of memory usage.
 * @author Karl Shaffer
 */
public class SimpleProfiler {
	
	private static String SEPARATOR = "==================================================\n";
	private static String REPORT_FORMAT = ""
			+ "STARTING MEMORY: %,d bytes\n"
			+ "ENDING MEMORY: %,d bytes\n"
			+ "USAGE: %,d bytes\n"
			+ "TIME: %d milliseconds"; 
	
	
	// Time variables.
	private long startTime; 
	private long endTime; 
	
	// Memory variables. 
	private long startFreeMemory;
	private long startTotalMemory; 
	private long endFreeMemory;
	private long endTotalMemory; 
	
	private boolean running; 
	
	public SimpleProfiler() {
		this.running = false; 
	}
	
	/**
	 * Starts the profiler. 
	 * @return The {@link Profiler}
	 */
	public SimpleProfiler start() {
		if (running) {
			throw new IllegalStateException("Cannot start the profiler while it is already running."); 
		}
		
		Runtime runtime = Runtime.getRuntime(); 
		
		this.running = !this.running; 
		this.startTime = System.currentTimeMillis(); 
		this.startTotalMemory = runtime.totalMemory(); 
		this.startFreeMemory = runtime.freeMemory(); 
		return this; 
	}
	
	/**
	 * Ends the profiler.
	 * @return The {@link Profiler}
	 */
	public SimpleProfiler stop() {
		if (!running) {
			throw new IllegalStateException("Cannot stop the profiler while it is not running.");
		}
		
		Runtime runtime = Runtime.getRuntime(); 
		
		this.running = !this.running; 
		this.endTime = System.currentTimeMillis(); 
		this.endTotalMemory = runtime.totalMemory(); 
		this.endFreeMemory = runtime.freeMemory(); 
		return this; 
	}
	
	/**
	 * A report of the simple profiling done with information about memory and time usage.
	 * @return
	 */
	public String getReport() {
		String toReturn = ""; 
		
		toReturn += SEPARATOR; 
		long startMemoryUsage = startTotalMemory - startFreeMemory; 
		long endMemoryUsage = endTotalMemory - endFreeMemory; 
		long delta = endMemoryUsage - startMemoryUsage;
		long time = endTime - startTime; 
		toReturn += String.format(REPORT_FORMAT, startMemoryUsage, endMemoryUsage, delta, time); 
		toReturn += "\n" + SEPARATOR; 
		
		return toReturn; 
	}
}
