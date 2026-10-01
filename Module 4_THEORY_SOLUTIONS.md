# Module 4: In-Depth Theoretical & Conceptual Solutions

This document provides exhaustive, university-level theoretical explanations, architectural breakdowns, code examples, internal mechanics, and complexity comparisons for all **36 theoretical questions** in Java Module 4.

---

# Section 1: Generics

---

### Q1. What is the purpose of generics in Java, and how do they improve type safety and code reusability?

#### 1. Purpose of Generics
Generics were introduced in Java 5 (JSR 14) to enable **types (classes and interfaces) to be parameters** when defining classes, interfaces, and methods. Much like formal parameters used in method declarations provide a way to pass different values to a method, type parameters provide a way for you to re-use the same code with different inputs.

#### 2. Enhancing Type Safety (Compile-Time vs Runtime)
Before Java 5, collections stored raw `Object` references. This approach had two major flaws:
1. **Explicit Casting Required**: Every retrieval from a collection required explicit downcasting.
2. **Runtime Failures**: If an incompatible object was added accidentally, the compiler could not catch it, resulting in a runtime `ClassCastException`.

```java
// BEFORE GENERICS (Pre-Java 5) - Error-prone & Unsafe
List rawList = new ArrayList();
rawList.add("Hello World");
rawList.add(100); // Accidental insertion of Integer

String s1 = (String) rawList.get(0); // Requires explicit cast
String s2 = (String) rawList.get(1); // RUNTIME ERROR: ClassCastException!

// WITH GENERICS (Java 5+) - 100% Type-Safe
List<String> genericList = new ArrayList<>();
genericList.add("Hello World");
// genericList.add(100); // COMPILE-TIME ERROR: Incompatible types detected immediately!
String s = genericList.get(0); // No casting required!
```

#### 3. Code Reusability & Algorithm Abstraction
Generics eliminate the need to write duplicate classes for different data types. A single generic class (like `ArrayList<E>`, `HashMap<K,V>`, or a custom `Stack<T>`) can operate on integers, strings, floating-point numbers, or custom domain models (e.g., `Employee`, `Student`) while maintaining strict type integrity.

---

### Q2. Explain the syntax for creating a user-defined generic class in Java. Provide an example.

#### 1. Generic Class Syntax
A generic class is defined with one or more type parameters enclosed in angle brackets `<>` immediately following the class name.
```java
public class GenericClassName<T1, T2, ..., Tn> {
    // Member fields of type T1, T2...
    // Constructors and methods using type parameters
}
```

#### 2. Standard Type Parameter Naming Conventions
- `E` - Element (used extensively by the Java Collections Framework)
- `K` - Key (used in Maps)
- `V` - Value (used in Maps)
- `N` - Number
- `T` - Type (first generic type)
- `S`, `U`, `V` - 2nd, 3rd, 4th generic types

#### 3. Comprehensive Implementation Example
```java
public class Repository<T, ID> {
    private final Map<ID, T> storage = new HashMap<>();

    public void save(ID id, T entity) {
        storage.put(id, entity);
    }

    public T findById(ID id) {
        return storage.get(id);
    }

    public boolean exists(ID id) {
        return storage.containsKey(id);
    }

    public static void main(String[] args) {
        // Instantiating with concrete types (User entity with Long ID)
        Repository<String, Long> userRepo = new Repository<>();
        userRepo.save(1001L, "Mohd Ahsan");
        System.out.println("Found User: " + userRepo.findById(1001L));
    }
}
```

---

### Q3. What is the difference between `? extends T` and `? super T` in generics? Provide an example of when to use each.

#### 1. The PECS Principle (Producer Extends, Consumer Super)
Wildcards (`?`) represent unknown types in Java Generics. To control read and write capabilities, Java provides bounded wildcards:

| Feature | Upper Bounded Wildcard (`? extends T`) | Lower Bounded Wildcard (`? super T`) |
|---|---|---|
| **Meaning** | Unknown type that is `T` or a **subclass** of `T`. | Unknown type that is `T` or a **superclass** of `T`. |
| **PECS Role** | **Producer**: You only **read/get** data from the structure. | **Consumer**: You only **write/put** data into the structure. |
| **Read Capability** | ✅ Safe to read as type `T`. | ⚠️ Can only be read as raw `Object`. |
| **Write Capability** | ❌ Cannot add elements (except `null`) because exact subtype is unknown. | ✅ Safe to add objects of type `T` or subclasses of `T`. |

#### 2. Code Example Demonstrating PECS
```java
public class WildcardDemo {

    // PRODUCER: Reading numbers to compute their sum (? extends Number)
    public static double sumOfList(List<? extends Number> list) {
        double sum = 0.0;
        for (Number n : list) {
            sum += n.doubleValue(); // Safe to read as Number
        }
        // list.add(10); // COMPILE ERROR: Cannot add to ? extends Number
        return sum;
    }

    // CONSUMER: Writing integers into a destination list (? super Integer)
    public static void addIntegers(List<? super Integer> list) {
        list.add(1); // Safe to write Integer
        list.add(2);
        list.add(3);
        // Integer val = list.get(0); // COMPILE ERROR: Read only yields Object
    }
}
```

---

### Q4. How do raw types differ from parameterized types in generics, and why should raw types be avoided?

#### 1. Definitions
- **Raw Type**: The name of a generic class or interface used without any type arguments (e.g., `List list = new ArrayList();`).
- **Parameterized Type**: A generic class or interface used with explicit concrete type arguments (e.g., `List<String> list = new ArrayList<>();`).

#### 2. Why Raw Types Exist
Raw types were retained solely for **backward compatibility** with legacy code written before Java 5 (1998–2004).

#### 3. Dangers & Why Raw Types Must Be Avoided
1. **Loss of Compile-Time Verification**: Raw types revert the compiler back to treating everything as `Object`.
2. **Pollution of Type System**: Mixing raw types with parameterized types causes *heap pollution*, which defers type errors to runtime crashes.
3. **Compiler Warnings**: Every use of a raw type generates an unchecked conversion warning.

---

# Section 2: Java.util Package & Collection Framework

---

### Q5. What is the `java.util` package, and why is it essential in Java programming?
The `java.util` package is one of the foundational packages in the Java Standard Library. It provides:
1. **The Collections Framework**: High-performance data structures (lists, sets, maps, queues, trees, hash tables).
2. **Date and Time Facilities**: Legacy date classes (`Date`, `Calendar`, `TimeZone`, `GregorianCalendar`).
3. **Utility Classes**: `Random` for pseudo-random number generation, `Scanner` for tokenized I/O parsing, `StringTokenizer`, `Base64`, and `Optional`.
4. **Concurrency Utilities**: High-throughput concurrent structures in `java.util.concurrent`.

---

### Q6. What are the key features of the Collection Framework in `java.util`?
1. **Consistent Architecture**: High-level abstractions (`Collection`, `List`, `Set`, `Map`) with interchangeable implementations.
2. **Reduces Programming Effort**: Developers do not need to implement data structures like balanced trees or resizable arrays from scratch.
3. **High Performance**: Built-in implementations are tuned for optimal time and memory efficiency.
4. **Extensible & Interoperable**: Standardized interfaces allow third-party libraries and APIs to exchange data seamlessly.

---

### Q7. Explain the differences between `Collection` and `Collections` in `java.util`.

| Property | `Collection` | `Collections` |
|---|---|---|
| **Type** | Root **Interface** (`java.util.Collection<E>`) | **Utility Class** (`java.util.Collections`) |
| **Purpose** | Defines common behavior for sets, lists, and queues. | Contains static utility algorithms operating on collections. |
| **Instantiation** | Cannot be instantiated directly; implemented by classes like `ArrayList`, `HashSet`. | Cannot be instantiated; private constructor, contains only `static` methods. |
| **Key Methods** | `add()`, `remove()`, `size()`, `clear()`, `contains()`, `iterator()` | `sort()`, `binarySearch()`, `shuffle()`, `reverse()`, `unmodifiableList()`, `synchronizedMap()` |

---

### Q8. What is the role of the `Iterator` interface in the `java.util` package?
The `Iterator<E>` interface allows traversal across any collection regardless of its internal physical layout (contiguous array, linked node chain, or tree structure).

#### Core Methods:
- `boolean hasNext()`: Returns `true` if the iteration has more elements.
- `E next()`: Returns the next element and advances the cursor.
- `default void remove()`: Safely removes the last element returned by `next()` from the underlying collection.

#### Safe Deletion Advantage:
Modifying a collection directly (e.g., `list.remove()`) during a standard for-each loop triggers a `ConcurrentModificationException` due to fail-fast iterators. The `Iterator.remove()` method is the only safe way to remove elements during traversal.

---

### Q9. What is the purpose of the `Comparator` and `Comparable` interfaces in the `java.util` package?

| Comparison Factor | `Comparable<T>` (`java.lang`) | `Comparator<T>` (`java.util`) |
|---|---|---|
| **Concept** | Natural / Default Ordering | Custom / Multiple Ordering Strategies |
| **Method Signature** | `int compareTo(T o)` (1 argument) | `int compare(T o1, T o2)` (2 arguments) |
| **Implementation Location** | Implemented directly by the target domain class. | Implemented in separate classes or inline lambda expressions. |
| **Modifiability** | Requires access to the source code of the class. | Does not require source access; can sort third-party classes. |
| **Usage** | `Collections.sort(list)` | `Collections.sort(list, comparator)` |

---

### Q10. What are the key interfaces in the Java Collection Framework, and how are they related?

```
                      ┌───────────────┐
                      │   Iterable    │
                      └───────┬───────┘
                              │
                      ┌───────▼───────┐
                      │  Collection   │
                      └──┬────┬────┬──┘
                         │    │    │
         ┌───────────────┘    │    └────────────────┐
         │                    │                     │
 ┌───────▼───────┐    ┌───────▼───────┐     ┌───────▼───────┐
 │     List      │    │      Set      │     │     Queue     │
 └───────────────┘    └───────┬───────┘     └───────┬───────┘
                              │                     │
                      ┌───────▼───────┐     ┌───────▼───────┐
                      │  SortedSet    │     │     Deque     │
                      └───────┬───────┘     └───────────────┘
                              │
                      ┌───────▼───────┐
                      │ NavigableSet  │
                      └───────────────┘

 Parallel Hierarchy:
                      ┌───────────────┐
                      │      Map      │
                      └───────┬───────┘
                              │
                      ┌───────▼───────┐
                      │   SortedMap   │
                      └───────┬───────┘
                              │
                      ┌───────▼───────┐
                      │ NavigableMap  │
                      └───────────────┘
```

---

### Q11. What is the difference between `Collection` and `Map` interfaces in Java?
1. **Structure**: `Collection` represents a group of individual objects ($[E_1, E_2, \dots]$), whereas `Map` represents a group of key-value pairs ($\langle K, V \rangle$).
2. **Hierarchy**: `Map` is **not** a subtype of `Collection` because its operations require key-based indexing (`put(k, v)`, `get(k)`).
3. **Views**: `Map` provides three collection views: `keySet()` (Set of keys), `values()` (Collection of values), and `entrySet()` (Set of `Map.Entry` objects).

---

### Q12. Explain the differences between `Set`, `List`, and `Queue` in the Collection Framework.

| Feature | `List` | `Set` | `Queue` |
|---|---|---|---|
| **Duplicates** | Allowed | Disallowed (Unique only) | Allowed |
| **Ordering** | Strict insertion order (0-indexed) | Unordered (`HashSet`) or Sorted (`TreeSet`) | FIFO processing order or Priority order |
| **Positional Access** | Supports `get(index)`, `set(index, e)` | No index-based access | Access restricted to head (`peek()`, `poll()`) |
| **Primary Implementations**| `ArrayList`, `LinkedList`, `Vector` | `HashSet`, `LinkedHashSet`, `TreeSet` | `PriorityQueue`, `ArrayDeque`, `LinkedList` |

---

### Q13. What is the significance of the `Iterable` interface, and how is it used in the Collection Framework?
- `Iterable<T>` is the super-interface for `Collection<E>`.
- Any class implementing `Iterable<T>` must provide an `Iterator<T> iterator()` method.
- **Language Integration**: The Java compiler automatically translates every **for-each loop** (`for (T item : items)`) into `Iterator` method calls (`hasNext()` and `next()`).

---

### Q14. What are the benefits of using the Collection Framework over arrays?
1. **Dynamic Resizing**: Arrays in Java have fixed length determined at allocation. Collections dynamically expand and shrink automatically.
2. **Type-Safe Generics**: Collections integrate seamlessly with generics to prevent runtime type mismatches.
3. **Rich Algorithmic Support**: Collections support `contains()`, `removeIf()`, `retainAll()`, `stream()`, and binary searches out of the box.
4. **Diverse Implementations**: Easy switching between dynamic arrays, hash tables, linked lists, and balanced trees without changing consumer business logic.

---

# Section 3: List Interface

---

### Q15. What is the `List` interface, and how does it differ from the `Set` interface?
A `List` represents an ordered sequence of elements.
- **Index-Based Operations**: Elements can be inserted, retrieved, or deleted by exact numerical position (`list.get(2)`).
- **Duplicate Elements**: Lists allow duplicate entries, including multiple `null` entries.
- **Difference from Set**: `Set` models a mathematical set with strictly unique elements and no positional index access.

---

### Q16. What is the difference between `ArrayList` and `LinkedList` in terms of performance and usage?

| Operation | `ArrayList` Time Complexity | `LinkedList` Time Complexity | Architectural Explanation |
|---|---|---|---|
| **Random Access (`get(i)`)** | **$O(1)$** | $O(N)$ | ArrayList calculates memory offset directly: $\text{Base} + (i \times \text{size})$. LinkedList must traverse nodes. |
| **Insertion at Beginning** | $O(N)$ | **$O(1)$** | ArrayList must shift all $N$ elements right. LinkedList adjusts head node pointer. |
| **Insertion at End** | **$O(1)$ amortized** | **$O(1)$** | ArrayList appends at tail pointer; LinkedList appends to tail pointer. |
| **Removal from Middle** | $O(N)$ | $O(N)$ seek + $O(1)$ unlink | ArrayList shifts elements left; LinkedList takes $O(N)$ to find the node. |
| **Memory Overhead** | Low (contiguous array) | High (stores 2 pointers per node: prev and next) | LinkedList allocates an extra `Node` object for every element. |

---

### Q17. What is the role of the `Vector` class, and how does it differ from `ArrayList`?
- `Vector` is a legacy synchronized dynamic array from Java 1.0.
- **Synchronization**: Every public method in `Vector` is marked `synchronized`, making it thread-safe but introducing performance overhead in single-threaded programs.
- **Growth Rate**: `Vector` doubles its capacity ($100\%$ growth) when full by default, whereas `ArrayList` expands by $50\%$ ($\text{newCapacity} = \text{oldCapacity} + (\text{oldCapacity} \gg 1)$).
- **Modern Alternative**: Modern code uses `ArrayList` for single-threaded code or `CopyOnWriteArrayList` / `Collections.synchronizedList()` for multithreading.

---

### Q18. How is the `Stack` class implemented, and how does it relate to the `List` interface?
- `java.util.Stack` extends `Vector`. Because it inherits from `Vector`, it implements the `List` interface.
- **Design Flaw**: Because it extends `Vector`, `Stack` inherits non-stack methods like `insertElementAt(index)` and `get(index)`, which violate pure Last-In-First-Out (LIFO) stack principles.
- **Recommended Practice**: Use `Deque<T> stack = new ArrayDeque<>()` which enforces strict LIFO operations without synchronization overhead.

---

# Section 4: Set Interface

---

### Q19. What is the difference between `HashSet`, `LinkedHashSet`, and `TreeSet` in Java?

| Characteristic | `HashSet` | `LinkedHashSet` | `TreeSet` |
|---|---|---|---|
| **Internal Data Structure** | Hash Table (`HashMap`) | Hash Table + Doubly-Linked List | Red-Black Balanced Binary Search Tree |
| **Time Complexity (Add/Search)**| **$O(1)$** | **$O(1)$** | **$O(\log N)$** |
| **Iteration Order** | Completely unpredictable | Guaranteed **Insertion Order** | Guaranteed **Ascending Sorted Order** |
| **Null Elements** | Allows one `null` element | Allows one `null` element | **No `null` allowed** (throws `NullPointerException` on comparison) |

---

### Q20. How does `HashSet` handle duplicate elements? Explain with an example.
1. When `set.add(e)` is invoked, `HashSet` internally delegates to `map.put(e, PRESENT)`.
2. It computes the hash code of `e` to find the target bucket index.
3. If an existing object exists in that bucket, it evaluates `e.equals(existing)`.
4. If `equals()` returns `true`, the old entry is overwritten/rejected, and `add()` returns `false`.

```java
Set<String> set = new HashSet<>();
set.add("Java"); // Returns true (added)
set.add("Java"); // Returns false (duplicate rejected via equals check)
```

---

### Q21. What is the significance of `equals()` and `hashCode()` methods in `HashSet`?
- **The Hash Contract**:
  1. If `a.equals(b)` is `true`, then `a.hashCode()` **must equal** `b.hashCode()`.
  2. If `a.hashCode() == b.hashCode()`, `a.equals(b)` may or may not be `true` (hash collision).
- **Failure Consequence**: If a custom class overrides `equals()` without overriding `hashCode()`, two logically equal objects will hash into different buckets, causing `HashSet` to store duplicates and breaking set uniqueness guarantees.

---

# Section 5: Map Interface

---

### Q22. What is the difference between `HashMap`, `LinkedHashMap`, and `TreeMap`?
- **`HashMap`**: Fastest general-purpose map ($O(1)$ lookup/insert), no ordering guarantees.
- **`LinkedHashMap`**: Maintains doubly-linked list across entries to guarantee either **insertion order** or **access order** (for LRU caching).
- **`TreeMap`**: Red-Black tree implementation where keys are always sorted in natural or custom `Comparator` order ($O(\log N)$ lookup/insert).

---

### Q23. How does `HashMap` handle collisions?

```
 Bucket Array (Table)
 ┌────┐
 │ 0  │ ──► null
 ├────┤
 │ 1  │ ──► [Node A] ──► [Node B] ──► [Node C]  (Separate Chaining: Linked List)
 ├────┤
 │ 2  │ ──► [Root]                              (Treeified: Red-Black Tree when items >= 8)
 │    │     ├── [Left Child]
 │    │     └── [Right Child]
 └────┘
```

1. **Separate Chaining**: When two distinct keys hash to the same bucket index, entries are chained as a linked list in that bucket.
2. **Treeification (Java 8+)**: If the number of collisions in a single bucket reaches **8** (`TREEIFY_THRESHOLD`) and total table capacity is at least **64**, the bucket converts from a linked list into a **Red-Black Tree**.
3. **Complexity Improvement**: This conversion prevents Worst-Case performance degradation from $O(N)$ down to $O(\log N)$ under heavy hash collision attacks.

---

### Q24. What is the difference between `Hashtable` and `HashMap`? Why is `Hashtable` considered legacy?
- **`Hashtable`**: Synchronized methods (slow), does not allow `null` keys or values, uses legacy enumeration.
- **`HashMap`**: Unsynchronized (fast), allows one `null` key and multiple `null` values, provides fail-fast iterators.
- **Why Legacy**: Coarse-grained method synchronization in `Hashtable` causes severe thread contention. Modern concurrent applications use `ConcurrentHashMap`.

---

# Section 6: Specialized Classes

---

### Q25. What is the purpose of the `PriorityQueue` class in Java?
- `PriorityQueue` implements an unbounded priority heap where elements are processed based on **priority** rather than FIFO order.
- It is backed by a binary min-heap where the head (`peek()`/`poll()`) is always the smallest element (or highest priority defined by a custom `Comparator`).
- Time complexity: $O(\log N)$ for `offer()` and `poll()`, $O(1)$ for `peek()`.

---

### Q26. How is the `Deque` interface different from the `Queue` interface?
- **`Queue`**: Single-ended queue. Elements enter at the rear (`offer()`) and leave at the front (`poll()`).
- **`Deque` (Double-Ended Queue)**: Supports insertion, removal, and inspection at **both ends** (`addFirst()`, `addLast()`, `removeFirst()`, `removeLast()`). Can function as both a FIFO queue and a LIFO stack.

---

### Q27. What is the difference between `BlockingQueue` and `PriorityQueue`?
- **`PriorityQueue`**: Non-blocking, single-threaded or unsynchronized data structure. Throws exceptions or returns `null`/`false` when empty.
- **`BlockingQueue` (`java.util.concurrent`)**: Thread-safe queue designed for concurrent Producer-Consumer architectures. Methods like `put()` block when full, and `take()` blocks when empty.

---

### Q28. What is the role of `WeakHashMap` in Java, and how is it different from `HashMap`?
- `HashMap` holds **strong references** to its keys, preventing the Garbage Collector from freeing the key object as long as the map is alive.
- `WeakHashMap` wraps keys in `java.lang.ref.WeakReference`. When a key has no other strong references in the application, the JVM garbage collector reclaims the key, and `WeakHashMap` automatically discards the associated key-value entry. Ideal for temporary metadata caching.

---

# Section 7: Concurrency & Thread-Safety

---

### Q29. How is `Vector` different from `ArrayList` in terms of thread safety?
- `Vector` provides thread safety by locking the entire object instance on every method call (`public synchronized boolean add(E e)`).
- `ArrayList` provides no synchronization.
- While `Vector` is thread-safe, its synchronized overhead makes it much slower. For thread-safe list operations, modern Java uses `Collections.synchronizedList()` or `CopyOnWriteArrayList`.

---

### Q30. What is the role of `ConcurrentHashMap` in Java, and how does it achieve thread safety?
- `ConcurrentHashMap` is designed for high-concurrency environments.
- **How It Works (Java 8+)**:
  - **Lock Striping & Node-Level Synchronization**: Instead of locking the whole map, it synchronizes only on the head node of the specific bucket being modified.
  - **CAS (Compare-And-Swap) Operations**: Non-blocking atomic operations for inserting new bucket heads.
  - **Lock-Free Reads**: Reads (`get()`) proceed without locking using `volatile` field visibility.

---

### Q31. What are the differences between `CopyOnWriteArrayList` and `ArrayList`?
- In `CopyOnWriteArrayList`, any mutating operation (`add()`, `set()`, `remove()`) makes a fresh, underlying copy of the entire internal array.
- **Benefits**: Iterators iterate over an immutable snapshot of the array at the moment the iterator was created. It is **100% thread-safe** and will **never throw `ConcurrentModificationException`**.
- **Ideal Use Case**: Read-heavy, write-rare scenarios (e.g., event listener registries).

---

### Q32. What is the difference between `synchronizedCollection` and `ConcurrentHashMap`?
- `Collections.synchronizedMap()` wraps a map with a single mutual exclusion lock (mutex). Every thread must wait in line for both read and write operations.
- `ConcurrentHashMap` uses bucket-level locking and lock-free CAS reads, allowing multiple threads to read and write concurrently without bottlenecking.

---

# Section 8: Utility Methods in Collections Class

---

### Q33. What are some commonly used methods in the `Collections` utility class?
1. `Collections.sort(List<T>)`: Sorts a list in natural ascending order using TimSort ($O(N \log N)$).
2. `Collections.binarySearch(List<T>, key)`: Searches sorted list in $O(\log N)$ time.
3. `Collections.shuffle(List<?>)`: Randomly permutes list elements in $O(N)$ time.
4. `Collections.reverse(List<?>)`: Inverts the order of elements in $O(N)$ time.
5. `Collections.unmodifiableList(list)`: Returns an immutable read-only view of a collection.
6. `Collections.frequency(collection, obj)`: Counts total occurrences of an object in a collection.
7. `Collections.min(col)` / `Collections.max(col)`: Finds minimum/maximum element based on natural or custom ordering.

---

### Q34. How can you make a collection thread-safe using the `Collections` class?
By utilizing synchronization wrapper methods provided in `Collections`:
```java
List<String> syncList = Collections.synchronizedList(new ArrayList<>());
Set<Integer> syncSet = Collections.synchronizedSet(new HashSet<>());
Map<String, Object> syncMap = Collections.synchronizedMap(new HashMap<>());
```
*Note: When iterating over a synchronized collection, manual synchronization on the collection object is required to prevent race conditions during iteration.*

---

### Q35. What is the difference between fail-fast and fail-safe iterators?
- **Fail-Fast Iterators** (e.g., `ArrayList`, `HashMap`, `HashSet`): Track a modification count (`modCount`). If the collection is structurally modified during iteration by any method other than `Iterator.remove()`, it immediately throws `ConcurrentModificationException`.
- **Fail-Safe / Weakly Consistent Iterators** (e.g., `CopyOnWriteArrayList`, `ConcurrentHashMap`): Operate on a cloned snapshot or live CAS view. They will **never** throw `ConcurrentModificationException` during concurrent modifications.

---

### Q36. What is the Time and Space Complexity summary for core Java Collections?

| Data Structure | Get / Search | Insert | Delete | Space Complexity | Ordering |
|---|---|---|---|---|---|
| **`ArrayList`** | $O(1)$ index / $O(N)$ value | $O(1)$ amortized | $O(N)$ shift | $O(N)$ contiguous | Insertion Order |
| **`LinkedList`** | $O(N)$ | $O(1)$ ends / $O(N)$ mid | $O(1)$ ends | $O(N)$ pointers | Insertion Order |
| **`HashSet`** | $O(1)$ | $O(1)$ | $O(1)$ | $O(N)$ buckets | Unordered |
| **`LinkedHashSet`** | $O(1)$ | $O(1)$ | $O(1)$ | $O(N) + \text{links}$ | Insertion Order |
| **`TreeSet`** | $O(\log N)$ | $O(\log N)$ | $O(\log N)$ | $O(N)$ tree nodes | Natural / Sorted |
| **`HashMap`** | $O(1)$ | $O(1)$ | $O(1)$ | $O(N)$ buckets | Unordered |
| **`TreeMap`** | $O(\log N)$ | $O(\log N)$ | $O(\log N)$ | $O(N)$ tree nodes | Natural / Sorted |
| **`PriorityQueue`** | $O(1)$ peek / $O(N)$ search | $O(\log N)$ | $O(\log N)$ poll | $O(N)$ heap array | Priority / Min-Heap |

---
*This complete in-depth theoretical analysis is a part of Mohd. Ahsan's Java Assignment Module 4.*
