import java.util.*;

public class semaphore {
	// Example class for synchronization primitive you might use - would
	// recommend you consider selecting
	// one or more of the following primitives to complete this exercise:

	// Lock, counting semaphore, binary semaphore, monitor

	// Users will have to submit elements onto the buffer concurrently

	private int count = 0;

	public semaphore(int init_val) {
		count = init_val;
	}

	public synchronized void getLock() {
		count = count - 1;
		if (count < 0) // to avoid deadlock from rushing in
			try {
				wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
	}

	public synchronized void releaseLock() {
		count = count + 1;
		notify(); // notifies the thread to release the lock
	}
}
