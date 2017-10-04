# Basics

Java basics. How to do simple stuff with basic variables.

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
- Exercises can be found [here](/tasks_lt#simple-statements)

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
- Exercises can be found [here](/tasks_lt#simple-statements)

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
- Exercises can be found [here](/tasks_lt#simple-statements)

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

## Switch

Its a more *fancy* way of selection control than `if/else`. When you have a lot of options,
it formats everything in a neat way and easier to read.

```java
package lt.vcs;

public class TestSwitch {

    public static void main(String[] args) {
        int variable = 0;
        switch (variable) {
            case 1:
                // execute code whenever `variable` is 1
                break;

            case 2:
                // execute whenever `variable` is 2
                break;
            default:
                // execute whenever there is no other 'case' defined in the switch
                break;
        }
    }
}
```

After every case you should try to break `switch` statement with keyword `break`, or else the program will
fall through.

```java
package lt.vcs;

public class TestSwitch {

    public static void main(String[] args) {
        int variable = 1;
        switch (variable) {
            case 1:
                // code executed
            case 2:
                // code executed
                break;
            case 3:
                // code not executed
                break;
        }
    }
}
```

## Loops

- Do something again and again
- Exercises can be found [here](/tasks_lt#cycles)

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

String most common methods used in manipulating them:

Method|Return type|Description
:---|:---:|:---
`s.charAt(0)` | char | Returns character at specific index
`s.equals(string2)` | bool | Checks if string has the same character list as provided one
`s.equalsIgnoreCase(string2)` | bool | Same as `equals` but does not check for upper/lower case letters
`s.startsWith(string2)` | bool | Checks if string starts with provided string
`s.endsWith(string2)` | bool | Checks if string ends with provided string
`s.indexOf(char)` | int | Returns first found letter index in a string
`s.lastIndexOf(char)` | int | Returns last found letter index in a string
`s.indexOf(string)` | int | Returns index of first found occurence of provided string
`s.substring(startIndex, endIndex)` | String | Cuts string from provided indexes
`s.replace(foundString, replaceString)` | String | Replaces `foundString` value with `replaceString`
`s.replaceAll(foundString, replaceString)` | String | Same as `replace`, but replaces all found occurences
`s.length()` | int | Length of string caracters
`s.toLowerCase()` | String | Changes all charaters to lowercase
`s.toUpperCase()` | String | Changes all charaters to uppercase
`s.trim()` | String | Removes all spaces from the side of the string
`s.split(separator)` | String[] | Splits string with provided `separator` string
`s.contains(string1)` | String | Checks if string sequence is in the string

- [Official documentation](https://docs.oracle.com/javase/7/docs/api/java/lang/String.html)

# Advanced

More advanced info on basic java usage.

## Variables

Primitive types, such as `int`, `long`, `double`, `boolean` are called variables as they have values.
Objects are called references, as they reference to a memory allocated to the object.

- Primitive `variable`
- Object `reference`

Sequence of object creation. You `declare` the object type and give it a variable `name`.
You create a new object by using keyword `new`. And `link` the object to a variable.

- Object creation
    - Declare: `Dog myDog;`
    - Create: `Dog myDog = new Dog();`
    - Link: `Dog myDog = new Dog ();`

Other stuff to keep an eye on.

- No reference - `null`
- Assigning only once - using `final`
- Assigning multiple times, and same object
- Arrays are objects too
