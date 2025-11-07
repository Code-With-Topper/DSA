# DSA Programs in **Java** (15 Console Programs)

This package contains 15 clean, self-contained Java programs for common Data Structures & Algorithms lab exercises. Each file has a `main` method and runs from the console.

## List of Programs
1. **String Operations** — `StringOps.java`  
   Length, copy, concat, compare, reverse (menu-driven).

2. **Array Operations** — `ArrayOps.java`  
   Create/display, insert@pos, delete@pos, linear search.

3. **Stack (Array-based)** — `StackArray.java`  
   Push, pop, peek, display.

4. **Infix to Postfix Conversion** — `InfixToPostfix.java`  
   Handles +, -, *, /, ^ and parentheses.

5. **Postfix Evaluation** — `EvalPostfix.java`  
   Evaluates postfix expressions with single-digit operands.

6. **Queue (Simple Array)** — `QueueArray.java`  
   Enqueue, dequeue, display (front..rear).

7. **Circular Queue** — `CircularQueue.java`  
   Fixed-size circular queue with wrap-around.

8. **Selection Sort** — `SelectionSort.java`

9. **Insertion Sort** — `InsertionSort.java`

10. **Singly Linked List (Menu)** — `LinkedListDemo.java`  
    Insert at begin/end, delete by value, display.

11. **Shell Sort** — `ShellSort.java`

12. **Linear Search** — `LinearSearch.java`

13. **Binary Search** — `BinarySearch.java`  
    Assumes array input is sorted ascending.

14. **Counting Sort (Linear-time)** — `CountingSort.java`  
    Works for integers in range `[0..10000]`. Increase `MAXV` if needed.

15. **Radix Sort (LSD, base 10)** — `RadixSort.java`

---

## How to Compile (Java 8+)
Open a terminal in the project folder and run:
```bash
javac *.java
```

## How to Run
Each program has its own `main`. Example:
```bash
java SelectionSort
```
Enter `n` followed by `n` integers; the program prints the sorted sequence.

Menu-driven programs (Stack/Queue/Strings/Linked List) prompt you with choices. Enter `0` to exit those menus.

---

## Notes
- All programs are interactive. Provide input as prompted.
- `CountingSort.java` expects non-negative integers within `[0..10000]` by default.
- `EvalPostfix.java` expects single-digit operands for simplicity (extend if needed).
- `CircularQueue.java` uses `MAX=5` to visualize wrap-around; increase if required.
- Code kept straightforward for lab use and viva demonstrations.
