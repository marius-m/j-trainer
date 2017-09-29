# Basics

## First program

- Everything should be typed into `main()` method
- Note that code is executed inside `main(){` and `}`

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

- Declare variable to use it later
- Main building tools for holding various data
- Exercises can be found [here](/?inputDoc=tasks_lt#simple-statements)

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

- Changing variable: reassign, add, subtract, etc.
- Exercises can be found [here](/?inputDoc=tasks_lt#simple-statements)

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

- Change behaviour on various conditions
- Exercises can be found [here](/?inputDoc=tasks_lt#simple-statements)

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

- Do something again and again
- Exercises can be found [here](/?inputDoc=tasks_lt#cycles)

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

## Strings

- Letters, words, sentences, paragraphs, etc.

```java
package lt.vcs;

public class TestStrings {
    public static void main(String[] args) {
        String name = "Peter";
        System.out.println("My name is: " + name);

        // Checking if strings are equal
        if (name.equals("John")) {
            // false
        }

        // Picking a concrete letter in a string
        char letterN = name.charAt(1); // letterN = 'n';

        // Two word junction
        String nameConjunction = "John" + "Peter";

        // Word contains supplied part of string
        if (name.contains("tan")) {
            // true
        }

        // Word starts with supplied string
        if (name.startsWith("Ant")) {
            //true
        }
    }
}
```

## Variables

- Primitive `variable`
- Object `reference`

- Object creation
 - Declare: `Dog myDog;`
 - Create: `Dog myDog = new Dog();`
 - Link: `Dog myDog = new Dog ();`

- No reference - `null`
- Assigning only once - using `final`
- Assigning multiple times, and same object
- Arrays are objects too