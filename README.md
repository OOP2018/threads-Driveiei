## Threads and Synchronization

This lab illustrates the problem of synchronization when many threads are operating on a shared object.  The general issue is called "thread safety", and it is a major cause of errors in computer software.

## Assignment

To the problems on the lab sheet and record your answers here.

1. Record average run times.
2. Write your explanation of the results. Use good English and proper grammar.  Also use good Markdown formatting.

## ThreadCount run times

These are the average runtime using 3 or more runs of the application.
The Counter class is the object being shared by the threads.
The threads use the counter to add and subtract values.

| Counter class           | Limit              | Runtime (sec)   |
|:------------------------|:-------------------|-----------------|
| Unsynchronized counter  |         10,000,000 |        0.011888 |
| Using ReentrantLock     |         10,000,000 |        0.990816 |
| Syncronized method      |         10,000,000 |        0.825174 |
| AtomicLong for total    |         10,000,000 |        0.335520 |

## 1. Using unsynchronized counter object
answer the question (1.1 - 1.3)
- 1.1) The total result sometimes be zero. but, the result usually random between negative or positive number. 
- 1.3) If both threads(add and subtract) get the value in the same time, the result will be erroneously. Because, when addtask and subtask
	   get zero value. when one of them return the result, the other will override the result without calculation.  
	   
## 2. Implications for Multi-threaded Applications

- If the customer have the money in the account 5,000 baht. If he needs to withdraw 800 baht, he can withdraw 200 baht with his ATM, e-banking, mobile banking and banking teller in the same time. He will get 800 baht with his account that remains 4,800 baht.

## 3. Counter with ReentrantLock

answer questions 3.1 - 3.4
- 3.1) The total result always be zero.
- 3.2) Because ReentrantLock have a lock that controlling access to a shared resource by multiple threads. Commonly, a lock provides exclusive access to a shared resource: only one thread at a time can acquire the lock and all access to the shared resource requires that the lock be acquired first. 
- 3.3) A ReentrantLock is owned by the thread last successfully locking, but not yet unlocking it. A thread invoking lock will return.
- 3.4) To solve the problem that if super.add(amount) failed, then It will not run the finally. Consider if super.add(amount) failed but lock.unlock() is run. So, the next thread might be error if it's called lock.lock() again.

## 4. Counter with synchronized method

answer question 4
- 4.1) The total result always be zero.
- 4.2) Because the SynchronousCounter override the add method to be synchronized method.
- 4.3) Synchronized have a behavior to block the next thread like when one thread is executing a synchronized method for an object, all other threads that invoke synchronized methods for the same object block (suspend execution) until the first thread is done with the object. Threads can access the method one at a time. Without synchronized all threads can access this method simultaneously. We will use synchronize when need to access the method only one time.

## 5. Counter with AtomicLong

- 5.1) Because An AtomicLong is automically update incremented sequence numbers all the time. So, it will not override the another thread like unsynchronized counter.
- 5.2) An AtomicLong is a long value that may be updated automically. An AtomicLong is used in applications such as atomically incremented sequence numbers, and cannot be used as a replacement for a Long.

## 6. Analysis of Results

- 6.1) The fastest is counter that using AtomicLong. The slowest is counter that using ReentrantLock.
- 6.2) The counter that using ReentrantLock. Althrough the ReentrantLock is the slowest process, The AtomicLong isn't good to solve the complex problem because when the thread run in parallel time, the lastest thread will check isn't it error compute or not. If it's error then it'll compute again with new information after before thread calculate. So, the AtomicLong will compute very long time. The synchronized execute only one thread. It differents from ReentrantLock that the synchronized will lock on thread and randomly choose the next thread but the ReentrantLock might better use in this case because ReentrantLock will lock one thread and checks the others thread which one take the most time to run so, accessing that thread and to the others. This process might be safety althrough it's the slowest process from the table.
 
## 7. Using Many Threads (optional)

