public class Buffer // Provides data and operations onto the fixed-length queue
{
	private LinkedList<Object> buf_list;
	private int elements = 0; // Number of elements currently on the queue
	private int buf_size; // Maximum number of elements allowed on queue
	public static semaphore sem;

	public Buffer(int n) // Queue creation, with n indicating the maximum capacity
							
	{
		buf_list = new LinkedList<Object>();
		elements = 0;
		buf_size = n;
		sem = new semaphore(1);
	}

	public void addElementsToBuff(int elementToAdd, int threadID) {
		sem.getLock(); //locks the critical section of code
		
		buf_list.add(elementToAdd); //adds generated elements from users to the buffer list
		elements++; //increments elements so that we know which overall element is being added
		sem.releaseLock(); // releases the critical section of code
	
		System.out.println("User " + threadID + " adds element " + elements + "/" + buf_size);
		
	}

	public void finalSummation() { // Calculates the total sum of element value  within the buffer
									
		int sum = 0;

		for (int i = 0; i < buf_size; i++) //loops through the linked list and gets the value using i as index
			sum = sum + (int) buf_list.pop();

		System.out.println("--------------------------");
		System.out.println("Count total: " + sum);
		System.out.println("--------------------------");
	}
}
