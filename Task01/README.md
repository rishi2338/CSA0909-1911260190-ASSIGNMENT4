# Task 1 – GUI Design Review

**Source:** Assignment 4, Task 1 (pages 2–3).

## Files
- `task1.java` – separates input handling from the `FeeService` validation/payment logic.

## Design points
1. Keep UI code separate from payment/service logic.
2. Compare action commands with `equals()`, not `==`.
3. Validate empty, malformed, non-finite and non-positive amounts.
4. Do not run database work or `Thread.sleep()` on the event-dispatch thread.
5. Show clear success and error feedback.
6. Give the Receipt action its own implementation.
7. Use `PreparedStatement` and close JDBC resources with try-with-resources.
8. Handle checked exceptions and window closing.

## Compile and run
Requires JDK 8 or later.

```bash
javac task1.java
java task1
```

The current program is a console demonstration of the service separation; connect a real payment gateway/database before treating a payment as completed.

## Result
Expected: valid input displays a confirmation; missing register number or invalid amount displays a validation message.

## Evidence
Add your own execution screenshot here after running the program.