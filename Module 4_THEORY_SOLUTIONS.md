# Module 4: Theoretical & Conceptual Solutions

This document contains comprehensive answers for all **36 theoretical questions** in Java Module 4 Assignment (Generics, `java.util` Collection Framework, List, Set, Map, Queues, Concurrency, and Specialized Classes).

---

## 1. Generics

### Q1. What is the purpose of generics in Java, and how do they improve type safety and code reusability?
- **Purpose**: Generics (introduced in Java 5) allow types (classes and interfaces) to be parameters when defining classes, interfaces, and methods.
- **Type Safety**: Before generics, collections stored raw `Object` references, requiring manual casting and risking `ClassCastException` at runtime. Generics catch type mismatches at **compile-time**.
- **Code Reusability**: A single generic algorithm (e.g., `List<T>`, generic sorting, custom `Stack<T>`) can operate on different data types without duplicating code.

### Q2. Explain the syntax for creating a user-defined generic class in Java. Provide an example.
- **Syntax**: `public class ClassName<T1, T2, ...> { ... }`
- **Example**:
  ```java
  public class Container<T> {
      private T content;
      public void set(T content) { this.content = content; }
      public T get() { return content; }
  }
  ```

### Q3. What is the difference between `? extends T` and `? super T` in generics? Provide an example of when to use each.
- **`? extends T` (Upper Bounded Wildcard)**: Accepts `T` or any subclass of `T`. Used when you only **read/produce** data from a structure (Producer Extends - *PECS* principle).
  - *Example*: `void readNumbers(List<? extends Number> list) { for(Number n : list) ... }`
- **`? super T` (Lower Bounded Wildcard)**: Accepts `T` or any superclass of `T`. Used when you only **write/consume** data into a structure (Consumer Super - *PECS* principle).
  - *Example*: `void addIntegers(List<? super Integer> list) { list.add(10); }`

### Q4. How do raw types differ from parameterized types in generics, and why should raw types be avoided?
- **Raw Types**: Using a generic class without specifying a type argument (e.g., `List list = new ArrayList();`).
- **Parameterized Types**: Specifying the concrete type argument (e.g., `List<String> list = new ArrayList<>();`).
- **Why Avoid Raw Types**: Raw types bypass compile-time type checking, eliminate generic type safety, and can lead to unpredictable `ClassCastException` errors at runtime.

---

## 2. Java.util Package & Collection Framework

### Q5. What is the `java.util` package, and why is it essential in Java programming?
- The `java.util` package contains the Java Collections Framework, utility classes (date/time, random numbers, string tokenizers), internationalization facilities, and event models. It provides foundational data structures and algorithms out of the box.

### Q6. What are the key features of the Collection Framework in `java.util`?
- **High Performance**: Highly efficient, production-grade implementations (dynamic arrays, hash tables, balanced trees, linked lists).
- **Interoperability**: Common interfaces (`List`, `Set`, `Map`, `Queue`) allow collections to be passed across APIs seamlessly.
- **Extensibility**: Easy to implement custom collections or wrappers.
- **Built-in Algorithms**: Searching, sorting, shuffling, reversing via `Collections` utility class.

### Q7. Explain the differences between `Collection` and `Collections` in `java.util`.
- **`Collection`**: A root **interface** in the collection hierarchy representing a group of objects.
- **`Collections`**: A **utility class** consisting exclusively of static methods that operate on or return collections (e.g., `Collections.sort()`, `Collections.reverse()`, `Collections.unmodifiableList()`).

### Q8. What is the role of the `Iterator` interface in the `java.util` package?
- The `Iterator` interface allows sequential traversal over elements of any collection with methods `hasNext()`, `next()`, and `remove()`. It provides a universal, safe mechanism to inspect and selectively remove elements during iteration.

### Q9. What is the purpose of the `Comparator` and `Comparable` interfaces in the `java.util` package?
- **`Comparable` (`java.lang`)**: Defines the *natural ordering* of a class via `int compareTo(T other)`. Implemented by the class itself.
- **`Comparator` (`java.util`)**: Defines *custom, external ordering* via `int compare(T o1, T o2)`. Multiple comparators can exist for sorting by different attributes (e.g., by name, by age, by salary).

### Q10. What are the key interfaces in the Java Collection Framework, and how are they related?
- The core hierarchy starts at `Iterable` -> `Collection` -> branched into `List` (ordered, indexed), `Set` (unique), and `Queue`/`Deque` (FIFO/LIFO processing). `Map` (key-value pairs) sits parallel to `Collection`.

### Q11. What is the difference between `Collection` and `Map` interfaces in Java?
- **`Collection`**: Represents a sequence/bag of individual elements `[E1, E2, E3]`.
- **`Map`**: Represents mappings of key-value pairs `<Key, Value>` where keys must be unique. `Map` does not extend `Collection`.

### Q12. Explain the differences between `Set`, `List`, and `Queue` in the Collection Framework.
- **`List`**: Ordered collection; preserves insertion order; permits duplicates; supports random indexed access (`get(i)`).
- **`Set`**: Unordered/sorted collection; **no duplicate** elements allowed.
- **`Queue`**: Designed for holding elements prior to processing; typical FIFO order (`offer()`, `poll()`, `peek()`).

### Q13. What is the significance of the `Iterable` interface, and how is it used in the Collection Framework?
- `Iterable<T>` is the root interface of all collections. It mandates the `iterator()` method, enabling any implementing class to be used in Java's **enhanced for-each loop** (`for (T item : collection)`).

### Q14. What are the benefits of using the Collection Framework over arrays?
- **Dynamic Sizing**: Automatically resizes as elements are added/removed.
- **Rich Built-in APIs**: Methods for search, sort, filter, remove, sublist.
- **Diverse Data Structures**: Support for hash sets, linked lists, balanced search trees, priority queues, and concurrent structures.

---

## 3. List Interface

### Q15. What is the `List` interface, and how does it differ from the `Set` interface?
- `List` maintains elements by positional index and allows duplicates. `Set` models a mathematical set containing no duplicate elements and generally does not provide indexed access.

### Q16. What is the difference between `ArrayList` and `LinkedList` in terms of performance and usage?
- **`ArrayList`**: Backed by a dynamic array. Fast $O(1)$ random access (`get(i)`), but slow $O(N)$ insertion/deletion in the middle or beginning due to array shifting.
- **`LinkedList`**: Backed by a doubly-linked list. Fast $O(1)$ insertions/deletions at ends, but slow $O(N)$ random access.

### Q17. What is the role of the `Vector` class, and how does it differ from `ArrayList`?
- `Vector` is a legacy synchronized dynamic array. Every method in `Vector` is synchronized, making it thread-safe but introducing performance overhead. `ArrayList` is unsynchronized and faster for single-threaded applications.

### Q18. How is the `Stack` class implemented, and how does it relate to the `List` interface?
- `Stack` extends `Vector` (which implements `List`). Because it inherits from `Vector`, `Stack` allows indexed operations that violate pure LIFO semantics. Modern Java prefers `Deque<T> stack = new ArrayDeque<>()`.

---

## 4. Set Interface

### Q19. What is the difference between `HashSet`, `LinkedHashSet`, and `TreeSet` in Java?
- **`HashSet`**: Backed by a hash table. $O(1)$ operations, no ordering guarantee.
- **`LinkedHashSet`**: Backed by a hash table + doubly-linked list. $O(1)$ operations, preserves **insertion order**.
- **`TreeSet`**: Backed by a Red-Black Tree. $O(\log N)$ operations, elements are **sorted in natural ascending/custom comparator order**.

### Q20. How does `HashSet` handle duplicate elements? Explain with an example.
- When `add(e)` is called, `HashSet` computes `e.hashCode()` to locate the bucket. If a match is found, it uses `e.equals(existing)` to check equality. If `equals()` returns `true`, the insertion is rejected and returns `false`.

### Q21. What is the significance of `equals()` and `hashCode()` methods in `HashSet`?
- The **`hashCode()`/`equals()` contract** states that if two objects are equal according to `equals()`, they must produce the same `hashCode()`. Failing to override both properly causes duplicates in hash-based collections.

---

## 5. Map Interface

### Q22. What is the difference between `HashMap`, `LinkedHashMap`, and `TreeMap`?
- **`HashMap`**: Fast $O(1)$ lookups, no ordering guarantee.
- **`LinkedHashMap`**: $O(1)$ lookups, maintains insertion order or access order (for LRU caching).
- **`TreeMap`**: $O(\log N)$ lookups, keys are sorted in natural or custom order.

### Q23. How does `HashMap` handle collisions?
- In Java 8+, `HashMap` handles collisions via separate chaining. Entries with the same hash share a bucket as a linked list. If a bucket's collision count exceeds 8 (TREEIFY_THRESHOLD), the linked list converts into a **Red-Black balanced tree**, reducing lookup complexity from $O(N)$ to $O(\log N)$.

### Q24. What is the difference between `Hashtable` and `HashMap`? Why is `Hashtable` considered legacy?
- `Hashtable` is synchronized on every method (slow), does not allow `null` keys or values, and is legacy. `HashMap` is unsynchronized, allows one `null` key and multiple `null` values, and is preferred. For concurrent environments, `ConcurrentHashMap` is used.

---

## 6. Specialized Classes

### Q25. What is the purpose of the `PriorityQueue` class in Java?
- `PriorityQueue` implements an unbounded priority heap where elements are processed based on priority (natural order or custom Comparator) rather than FIFO order.

### Q26. How is the `Deque` interface different from the `Queue` interface?
- `Queue` allows element insertion at the tail and removal from the head (single-ended). `Deque` (Double-Ended Queue) allows insertions, removals, and peeks at **both ends**.

### Q27. What is the difference between `BlockingQueue` and `PriorityQueue`?
- `BlockingQueue` (`java.util.concurrent`) blocks the calling thread when trying to dequeue from an empty queue or enqueue to a full queue (ideal for Producer-Consumer patterns). `PriorityQueue` is non-blocking and not thread-safe.

### Q28. What is the role of `WeakHashMap` in Java, and how is it different from `HashMap`?
- `WeakHashMap` stores keys using `WeakReference`. When a key is no longer referenced anywhere else in the application, the Garbage Collector reclaims it and the entry is discarded automatically.

---

## 7. Concurrency and Thread-Safety

### Q29. How is `Vector` different from `ArrayList` in terms of thread safety?
- `Vector` synchronizes every method call, providing thread safety at the cost of performance. `ArrayList` has no synchronization.

### Q30. What is the role of `ConcurrentHashMap` in Java, and how does it achieve thread safety?
- `ConcurrentHashMap` provides thread-safe operations without locking the entire map. It uses **lock striping, non-blocking CAS (Compare-And-Swap) operations, and synchronized node bins**, allowing multiple threads to read and write concurrently without blocking each other.

### Q31. What are the differences between `CopyOnWriteArrayList` and `ArrayList`?
- `CopyOnWriteArrayList` creates a cloned copy of the backing array on every write operation (`add`, `set`, `remove`). Iterators read from a snapshot without locking and will never throw `ConcurrentModificationException`.

### Q32. What is the difference between `synchronizedCollection` and `ConcurrentHashMap`?
- `Collections.synchronizedMap()` locks the **entire map** with a single mutex for every read and write. `ConcurrentHashMap` locks only individual bucket bins, enabling high concurrent throughput.

---

## 8. Utility Methods in Collections Class

### Q33. What are some commonly used methods in the `Collections` utility class?
- `Collections.sort(list)` - Sorts a list.
- `Collections.binarySearch(list, key)` - Performs binary search.
- `Collections.shuffle(list)` - Randomizes element order.
- `Collections.reverse(list)` - Inverts list order.
- `Collections.frequency(col, obj)` - Counts occurrences.
- `Collections.unmodifiableList(list)` - Creates read-only view.
- `Collections.min(col)` / `Collections.max(col)` - Finds extreme values.

### Q34. How can you make a collection thread-safe using the `Collections` class?
- By wrapping the collection with synchronized wrapper methods:
  - `Collections.synchronizedList(new ArrayList<>())`
  - `Collections.synchronizedSet(new HashSet<>())`
  - `Collections.synchronizedMap(new HashMap<>())`

---
*Document prepared for Mohd. Ahsan's Java Assignment Module 4.*
