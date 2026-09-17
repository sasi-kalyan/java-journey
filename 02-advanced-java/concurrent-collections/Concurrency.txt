
Concurrency:
concurrency is a concept where we need to manage the multiple tasks simultaneously or same time.

Single CPU Core:
->Time
   A  A  A  A
      B  B  B  B
         C  C  C  C

Parallelism:
it the concept where multiple tasks run simultaneously independently.

Multi CPU Cores
->Time
AAAAAAA
BBBBBBB
CCCCCCC

Multithreading
is a concept where we can create multi-threads in the env, to utilze the maximum CPU cores, and resulting
concurrency and paralleism in the system.

Concurrent Collections in JAVA:
java.util.concurrent;

ConcurrentHashMap - is a concurrent collection that stores the key, value pairs inside it.
it uses the bucket-level locking mechanism inside it for read/write operations in the map.

the segment/bucket level locking offers the advantage of high concurrency and performance of
the data processing inside the map.

CopyOnWriteArray - is also concurrent collection, which offers good performance when the read
operations are more on app.

when multiple threads are accessing the array for modification and read, it creates a copy of the
underlying array , read happens on the cloned-array rather org array during modification of org array by
other threads.




