# Concurrency project
 A Java project to explore the concept of concurrency and semaphores
#Notes
A monitor is a synchronization construct which can perform both mutual exclusion and cooperation. Monitors can notify other threads that conditions are now true. The monitor can be used to implement locks but is not a lock in it's self. 
A lock stops more than one thread from running a critical section of code at the same time. 
Blocking locks Good for long critical sections Costly if lock accessed lots  
Spinning locks Sit in a tight loop until lock acquisition Good for short critical sections Costly for long critical sections Avoid queue management 
