
Synchronization:    
Is the concept that ensures that the each Thread can access the shared resource one at a time, so that the
result become predictable and expected results. This is sequential, slow because single thread can access the
resource at a time, blocking operations, in sequential operations.

We can achieve synchronization in different ways:
1. synchronized blocks
2. using final Object lock = new Object() + synchronized blocks
3. voilatile keyword -> Definition: volatile guarantees that reads and writes to a variable go directly to main memory
(not a CPU-local cache), so every thread always sees the most recently written value — this is purely a visibility guarantee,
not mutual exclusion.

4. 

Asynchronous:
Is the concept where multiple threads are allowed to access the shared resources without waiting for the
previous threads to complete their execution.

Race Conditions:
Is the situation where the multiple threads can access the shared resources at a time, so that the final
outcome would be unpredictable, the outcome probably the positive or negative based on the timing and sequence
of the each thread execution.


