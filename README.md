# Java SE 8 Concepts Practice

### JAVA STREAM API SUMMARY
### A stream in Java is a sequence of data.  A stream pipeline has three parts: (i) Source, (ii) Intermediate Operations, (iii) Terminal Operations.

### (i) Source: creates the data in the stream (required).

### (ii) Intermediate Stream Operations: transform the stream into another one.  
There can be as few or as many intermediate operations as desired.  Since streams use lazy evaluation, the intermediate operations do not run until the terminal operation runs.  THERE CAN BE ZERO OR MORE INTERMEDIATE OPERATIONS; INTERMEDIATE OPERATIONS CAN EXIST MULTIPLE TIMES IN A PIPELINE.

**Intermediate Stream Operations Examples:**
- The **filter()** method returns a Stream with elements that match a given expression. 
- The **flatMap()** method takes each element in a stream and makes any elements it contains top-level elements in a single stream.  The flatMap() method flattens nested lists into a single level and removes empty lists.
- The **sorted()** method returns a stream with the elements sorted.  Just like sorting arrays, Java uses natural ordering unless one specifies a comparator.  
- The **peek()** method is useful for debugging because it allows one to perform a stream operation without actually changing the stream.  The most common use for peek() is to output the contents of the stream as it goes by.  
- The **distinct()** method returns a stream with duplicate values removed. 
- The **limit()** and **skip()** methods make a Stream smaller. 
- The **map()** method creates a one-to-one mapping from the elements in the stream to the elements of the next step of the stream.  The map() method returns a Stream transforming each element to another through a Function. 

### (iii) Terminal Stream Operations: actually produce a result.  
Since streams can be used only once, the stream is no longer valid after a terminal operation completes.  TERMINAL OPERATIONS CANNOT EXIST MULTIPLE TIMES IN A PIPELINE.  IF NO TERMINAL OPERATION IS IN THE PIPELINE, A STREAM IS RETURNED BUT NOT EXECUTED.

**Terminal Stream Operations Examples:**
- The **count()** method determines the number of elements in a finite stream. 
- The **min()** and **max()** methods allow one to pass a custom comparator and find the smallest or largest value in a finite stream according to that sort order.
- The **findAny()** and **findFirst()** methods return an element of the stream unless the stream is empty.**
- The **allMatch()**, **anyMatch()** and **noneMatch()** methods search a stream and return information about how the stream pertains to the predicate.**
- The **forEach()** method is a looping construct.
- The **reduce()** method combines a stream into a single object.
- The **collect()** method is a special type of reduction called a mutable reduction.  A mutable reduction collects into the same object as it goes.

** Denotes search methods of the Stream API.

NOTE: You can perform a terminal operation without any intermediate operations but not the other way around.
