# Other

How to do other things that don't fall into specific categories.

## Basics

Printing something out in java we use `System.out.println(string1)`

Commented code is never executed by the computer. To comment something out, use:
- Comment line use `//` before the line
- Or `/*` and `*/` to comment out a block of code

```java
package lt.vcs;

public class TestOther {
    public static void main(String[] args) {

        // Comments are not executed by the computer
        
        System.out.println("Hello world");
    }
}
```

To read something from the user, we use `Scanner` class. First we need to create
the scanner to be able to use it. To do it
- We can create a local scanner `Scanner scanner = new Scanner(System.in);` that will me used **inside** the `main(){ // code }` method
- Or we can declare it for all the methods in the class by using `public static Scanner scanner = new Scanner(System.in);` **outside** the `main()`

```java
package lt.vcs;

import java.util.Scanner;

public class TestOther2 {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int inputVariable = scanner.nextInt();

        // Printing output
        System.out.println("User has entered: " + inputVariable);
    }
}
```

## Reading from file

```java
package lt.vcs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SimpleRead {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("names.txt"));
        try {
            String line = br.readLine();
            while (line != null) {
                if (line.length() > 0) {
                    System.out.println("Line from file: " + line);
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
    }
}
```

## Unit testing

```java
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MyTests {

    @Test
    public void multiplicationOfZeroIntegersShouldReturnZero() {
        MyClass tester = new MyClass(); // MyClass is tested

        // assert statements
        assertEquals("10 x 0 must be 0", 0, tester.multiply(10, 0));
        assertEquals("0 x 10 must be 0", 0, tester.multiply(0, 10));
        assertEquals("0 x 0 must be 0", 0, tester.multiply(0, 0));
    }
}
```

## Exceptions

- Checked exceptions
- Unchecked exceptions

- Try executing code with *might-be* exception

```java
import java.io.*;

public class ExcepTest {

   public static void main(String args[]) {
      try {
         int a[] = new int[2];
         System.out.println("Access element three :" + a[3]);
      } catch(ArrayIndexOutOfBoundsException e) {
         System.out.println("Exception thrown  :" + e);
      }
   }
}
```

- Delegate catching

```java
import java.io.*;
public class className {

   public void deposit(double amount) throws RemoteException {
      // Method implementation
      throw new RemoteException();
   }
   // Remainder of class definition
}
```

- Finally

```java
try {
   // Protected code
} catch(ExceptionType1 e1) {
   // Catch block
} catch(ExceptionType2 e2) {
   // Catch block
} catch(ExceptionType3 e3) {
   // Catch block
} finally {
   // The finally block always executes.
}
```

