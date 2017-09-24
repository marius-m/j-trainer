# Java basics

![Java](imgs/java_318-32027.jpg)

# who, what, where how

- Marius Merkevičius (Treatwell)
- merkevicius.marius@gmail.com

## Approach
- There are no dumb questions
- Stop. Think. Rinse. Repeat.
- Try it out.

## Popular Why
- "Write once, run anywhere"
- Open-source
- Object oriented
- Fast enough - JIT

## Personal why
- Old (20+ years)
- Most things are done by hand (not used that much)
- Big community
- Lots of examples
- Most problems are alreay solved
- Its compiled
- Strict type
- Easy apply design patterns
- Fun way to learn programming from its core
- Joining up various languages
- Lots of libraries
 - Networking
 - Databases
- Power tools
 - Maven, ANT, Gradle
 - IntelliJ, Eclipse

## Motivation
- Rewarding
- Creative
- Endless ways of doing things
- Popularity
- Endless branches of development 
- Teamwork 
- Remote work 
- Top of the line devices
- Endless learning

## Where it is used
- Desktop GUI
 - AWT, Swing, JavaFX
- Embedded systems
- Web applications
 - Spring
 - JavaEE
 - JSP, JSF
 - GWT
- Mobile applications
 - Android
 - JavaME
 - RoboVM
- Gaming platforms
 - LibGDX
 - LWJGL
 - jMonkeyEngine
- Scientific application
- Cloud computing
 - Hadoop, Cassandra

## Other programming languages
- Scala
- Kotlin
- Clojure, Groovy...

## Where to learn
- Books, many books!
 - [Head First Java](https://www.amazon.com/Head-First-Java-Kathy-Sierra/dp/0596009208)
 - [The Pragmatic Programmer: From Journeyman to Master](https://www.goodreads.com/book/show/4099.The_Pragmatic_Programmer)
- Blogs
- Social media (who to follow)
- Practice, repeat
- Katas
- Pet projects
- Generic programming sites
 - Google
 - StackOverflow
- Sites
 - [JCG](https://www.javacodegeeks.com/)
 - [DZone](https://dzone.com/)
- Tutorial sites
 - https://www.tutorialspoint.com/java/
 - https://docs.oracle.com/javase/tutorial/
 - http://www.learnjavaonline.org/
 - http://www.javatpoint.com/java-tutorial
- Open-source
- Pair programming

## Why its relevant?

- Popularity

![Relevancy1](imgs/relevant_1.png)


- Most used programming langs 

![Relevancy2](imgs/relevant_2.png)

- Most active repositories

![Relevancy3](imgs/relevant_3.png)

- Job postings

![Relevancy4](imgs/relevant_4.png)

## How it works in real life

- Source > Compiler > Bytecode > JVM > Device

![How it works](imgs/how_it_works.png)

## First program run

```java
package lt.vcs;

public class TestHelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello world");
    }
}
```

## Declarations / Assignments

![Variable types](imgs/var_types.png)

```java
// Integer types
int i = 0;
int j = 1;
long y = 100;

// Floating numbers
float i = 1.0;
double d = 10.12345;

// Boolean (true/false)
boolean isNumberPositive = false;

// Char (not used too much)
char symbol1 = 'a';

// String (List of chars)
String myName = "Marius";
```

## Arithmetic operations

```java
package lt.vcs;

public class TestArithmetic {
    public static void main(String[] args) {
        // Basic
        int i = 0;
        i = 1 + 1; // i = 2
        i = 2 - 2; // i = 0
        i = 2 * 2; // i = 4
        i = 2 / 2; // i = 1
        i = 2 % 2; // i = 0

        // Intermediate
        i++; // i = i + 1;
        i += 1; // i = i + 1;
    }
}
```

## Statements

```java
package lt.vcs;

public class TestStatements {
    public static void main(String[] args) {
        int i = 0;
        if (i > 0) {
            System.out.println("Number is positive");
        } else {
            System.out.println("Number is negative");
        }

        // Possible evaluations
        if (i == 0) {
            // code
        }
        if (i != 0) {
            // code
        }
        if (i < 0) {
            // code
        }
        if (i <= 0) {
            // code
        }
        if (i > 0) {
            // code
        }
        if (i >= 0) {
            // code
        }
        if (i >= 0) {
            // code
        }
        if (i >= 0) {
            // code
        }
        if (i % 2 == 0) {
            // code
        }

        // Conjunctions
        boolean isCarRed = false;
        boolean isCarRoofless = true;
        // Logical AND
        if (isCarRed == true && isCarRoofless == true) {
            // code
        }
        // Logical OR
        if (isCarRed == true || isCarRoofless == true) {
            // code
        }
    }
}
```

## Loops

```java
package lt.vcs;

public class TestLoops {
    public static void main(String[] args) {
        // Basic

        // for loop
        for (int i = 0; i < 5; i++) {
            System.out.println("i = " + i);
        }

        // while loop
        int j = 0;
        while (j < 5) {
            System.out.println("j = " + j);
            j = j + 1;
        }

        // do/while
        int k = 0;
        do {
            System.out.println("k = " + k);
            k = k + 1;
        } while (k < 5);

        // Advanced

        // Loop with continue
        for (int i = 0; i < 5; i++) {
            if (i < 3) {
                continue;
            }
            System.out.println(i);
        } // out: 3,4


        // Loop with break
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                break;
            }
            System.out.println(i);
        } // out: 0,1,2
    }
}
```

## Other cool stuff

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
## Strings

```java
package lt.vcs;

public class TestStrings {
    public static void main(String[] args) {
        String name = "Antanas";
        System.out.println("My name is: " + name);

        if (name.equals("Marius")) {
            // false
        }
        if (name.equals("Antanas")) {
            // true
        }

        char letterN = name.charAt(1); // letterN = 'n';

        String nameConjunction = "Marius" + "Antanas"; // nameConjunction = MariusAntanas

        if (name.contains("tan")) { // part of string
            // true
        }

        if (name.startsWith("Ant")) {
            //true
        }
    }
}
```

## Arrays

- Simple initialize

```java
class ArrayDemo {
    public static void main(String[] args) {
        // declares an array of integers
        int[] anArray;

        // allocates memory for 10 integers
        anArray = new int[10];
           
        // initialize first element
        anArray[0] = 100;
        // initialize second element
        anArray[1] = 200;
        // and so forth
        anArray[2] = 300;
        anArray[3] = 400;
        anArray[4] = 500;
        anArray[5] = 600;
        anArray[6] = 700;
        anArray[7] = 800;
        anArray[8] = 900;
        anArray[9] = 1000;

        System.out.println("Element at index 0: "
                           + anArray[0]);
        System.out.println("Element at index 1: "
                           + anArray[1]);
    }
} 
```

- Using arrays with loops

```java
package lt.vcs;

public class TestArrays {

    public static void main(String[] args) {
        double[] myList = {1.9, 2.9, 3.4, 3.5};

        // Print all the array elements
        for (int i = 0; i < myList.length; i++) {
            System.out.println(myList[i] + " ");
        }

        // Summing all elements
        double total = 0;
        for (int i = 0; i < myList.length; i++) {
            total += myList[i];
        }
        System.out.println("Total is " + total);

        // Finding the largest element
        double max = myList[0];
        for (int i = 1; i < myList.length; i++) {
            if (myList[i] > max) max = myList[i];
        }
        System.out.println("Max is " + max);
    }
}
```

- More ways to initialise

```java
int[] myIntArray = new int[3];
int[] myIntArray = {1,2,3};
int[] myIntArray = new int[]{1,2,3};

String[] myStringArray = new String[3];
String[] myStringArray = {"a","b","c"};
String[] myStringArray = new String[]{"a","b","c"};

String[] myStringArray;
myStringArray = new String[]{"a","b","c"};
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

## Lists

```java
import java.util.*;
public class ArrayListDemo {

   public static void main(String args[]) {
      // create an array list
      ArrayList al = new ArrayList();
      System.out.println("Initial size of al: " + al.size());

      // add elements to the array list
      al.add("C");
      al.add("A");
      al.add("E");
      al.add("B");
      al.add("D");
      al.add("F");
      al.add(1, "A2");
      System.out.println("Size of al after additions: " + al.size());

      // display the array list
      System.out.println("Contents of al: " + al);

      // Remove elements from the array list
      al.remove("F");
      al.remove(2);
      System.out.println("Size of al after deletions: " + al.size());
      System.out.println("Contents of al: " + al);
   }
}
```

## Maps

```java
import java.util.*;
public class HashMapDemo {

   public static void main(String args[]) {
   
      // Create a hash map
      HashMap hm = new HashMap();
      
      // Put elements to the map
      hm.put("Zara", new Double(3434.34));
      hm.put("Mahnaz", new Double(123.22));
      hm.put("Ayan", new Double(1378.00));
      hm.put("Daisy", new Double(99.22));
      hm.put("Qadir", new Double(-19.08));
      
      // Get a set of the entries
      Set set = hm.entrySet();
      
      // Get an iterator
      Iterator i = set.iterator();
      
      // Display elements
      while(i.hasNext()) {
         Map.Entry me = (Map.Entry)i.next();
         System.out.print(me.getKey() + ": ");
         System.out.println(me.getValue());
      }
      System.out.println();
      
      // Deposit 1000 into Zara's account
      double balance = ((Double)hm.get("Zara")).doubleValue();
      hm.put("Zara", new Double(balance + 1000));
      System.out.println("Zara's new balance: " + hm.get("Zara"));
   }
}
```

## Classes

- class - blueprint
- object - instance
- variable types
 - instance
 - local 

```java
package lt.vcs.new_folder;

public class Car {
    int wheelCount = 4;
    int doorCount = 2;
    String color = "red";

    void drive() {
        System.out.println("Wrrrrm");
    }

}
```

- this...

```java
package lt.vcs.new_folder;

public class Car {
    int wheelCount = 4;
    int doorCount = 2;
    String color = "red";

    public void setWheelCount(int wheelCount) {
        this.wheelCount = wheelCount;
    }

    public int getWheelCount() {
        return wheelCount;
    }
}
```

## Enums

```java
public enum Level {
    HIGH,
    MEDIUM,
    LOW
}
```

```java
Level level = ...  //assign some Level constant to it

if (level == Level.HIGH) {

} else if(level == Level.MEDIUM) {

} else if(level == Level.LOW) {

}
```

## Class constructors

- No arguments

```java
package lt.vcs.new_folder;

public class Car {
    int wheelCount = 4;
    int doorCount = 2;
    String color = "red";

    public Car() {
        
    }

    void drive() {
        System.out.println("Wrrrrm");
    }

}
```

- With initial arguments

```java
package lt.vcs.new_folder;

public class Car {
    int wheelCount = 4;
    int doorCount = 2;
    String color = "red";

    public Car(int wheelCount, int doorCount) {
        this.wheelCount = wheelCount;
        this.doorCount = doorCount;
    }

    void drive() {
        System.out.println("Wrrrrm");
    }

}
```

- Method overloading

```java
package lt.vcs.new_folder;

public class Car {
    int wheelCount = 4;
    int doorCount = 2;
    String color = "red";

    void drive() {
        System.out.println("Wrrrrm");
    }

    void drive(int wheelCount) {

    }

    void drive(int wheelCount, String color) {

    }

}
```

- Constructor overloading

```java
package lt.vcs.new_folder;

public class Car {
    int wheelCount = 4;
    int doorCount = 2;
    String color = "red";

    public Car() {
    }

    public Car(int wheelCount) {
        this.wheelCount = wheelCount;
    }

    public Car(int wheelCount, int doorCount) {
        this.wheelCount = wheelCount;
        this.doorCount = doorCount;
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

