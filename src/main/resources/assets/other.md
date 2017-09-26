# Other

## Basics

- Printing something out 
- Comments

```java
package lt.vcs;

public class TestOther {
    public static void main(String[] args) {

        // Comments are not executed by the computer
        
        System.out.println("Hello world");
    }
}
```

- Taking user input

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

## Methods

- Simple method

```java
public static void methodName() {
   // body
}
```

- Method that returns something

```java
public static int methodName() {
   // body
}
```

- Method that takes in arguments and returns something

```java
public static int methodName(int a, int b) {
   // body
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

