
import java.util.*;

public class user implements Runnable {
	private int id;
	private int num_elements;
	public static Buffer buf;
	int i;

	public user(int i, int el, Buffer b) // User arguments: User ID, number of
											// elements to add, buffer object
	{
		id = i;
		num_elements = el;
		buf = b;
	}

	public void add_elements() {
		// Add integer element to buffer, element value should iterate from 0,
		// 1, 2 .... num_elements
		// every time the user submits onto the buffer
		for (i = 0; i < num_elements; i++) {

			buf.addElementsToBuff(i, id); // passes thread id and loops through
											// the number of elements for each
											// user

		}
	}

	public void run() {
		add_elements(); // runs add_elements for each thread

	}

}