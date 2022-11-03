import java.util.*;

public class listCount {

	public static void main(String[] args) {
		int num_users = 0;
		int elements = 0;
		int bufferSize = 0;

		System.out.println("Enter number of users:"); // Specify number of users
		Scanner sc1 = new Scanner(System.in); // declared scanner
		num_users = sc1.nextInt(); // number of users equals user input

		System.out.println("Enter number of elements per user:"); // Specify number of elements submitted per user
																	

		Scanner sc2 = new Scanner(System.in); // declared scanner 2
		elements = sc2.nextInt(); // number of elements equals user input2

		bufferSize = num_users * elements; // The total number of elements is calcualted for the buffer size
		long start_time = System.currentTimeMillis(); // Starts the count for how long the program takes

		Buffer b;
		b = new Buffer(bufferSize); // Create buffer

		// Create X users that will concurrently add elements to the Buffer object b
		//You will want to think about creating a method that will add elements
		// to the buffer

		Thread[] threads = new Thread[num_users];              // Threads are created using the number of users
		for (int i = 0; i < threads.length; i++) {             // So these threads are dynamically made
			threads[i] = new Thread(new user(i, elements, b));
			threads[i].start(); //start thread i
		}

		try {
			for (int i = 1; i < num_users; i++)
				threads[i].join(); //joining the threads 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		b.finalSummation(); // When buffer is full, calculate SUM of elements within the buffer
							
		long end_time = System.currentTimeMillis();
		System.out.println("Time to complete: " + (end_time - start_time)); //prints the time taken to compute 
	}
}
