package edu.sjsu.cmpe.library.jobs;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 
public class BackgroundThread {
 
    public static void startThread(final Listener listener) {
    	int numThreads = 1;
	    ExecutorService executor = Executors.newFixedThreadPool(numThreads);
 
	    Runnable backgroundTask = new Runnable() {
 
    	    @Override
    	    public void run() {
    	    	System.out.println("Starting Listener");
    	    	listener.listenForMessages();
    	    }
    
    	};
 
    	System.out.println("Submitting the background task");
    	executor.execute(backgroundTask);
    	System.out.println("Background task submitted");
    
    	executor.shutdown();
    	System.out.println("End of background task");
    }
}
