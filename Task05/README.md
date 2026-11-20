# Task 5 – Event-Handling Styles

**Source:** Assignment 4, Task 5 (pages 6–7).

## Files
- `task5.java` – one converter program demonstrating four registration styles, selected by command-line argument.

## Four styles
1. Frame method callback (method reference).
2. Named inner class.
3. Anonymous inner class.
4. Lambda expression.

Each selected listener is shared by the Convert button and Enter key in the amount field. A `WindowAdapter` handles closing. The result is displayed in both the result label and a dialog.

## Compile and run
Requires JDK 8 or later.

```bash
javac task5.java
java task5 1
java task5 2
java task5 3
java task5 4
```

## Result
Use a numeric amount to display the converted value, or enter invalid text to display **Invalid amount**. The rates are illustrative fixed values, not live exchange rates.

## Evidence
Add one valid-conversion screenshot and one invalid-input screenshot for the lambda version (`java task5 4`). Record the code changes needed when adding the Enter-key trigger and dialog output.