# Classes

Rationale: Class is like a container that *holds data* and can do *things*.

- Object `knows` about itself - instance variables (state)
- Object can `do` something - methods (behaviour)

Note on dictionary: `instance` == `object`

### Mini exercise

- Procedural code VS Object oriented (Lots of shapes!)

- Create 3 shapes (Square, circle, triangle) that could `rotate()` and `playSound()`
- Adding one more shape with different `rotate()` and `playSound()`
- Reusing code

## Class

- class - is like a blueprint, how can you make an object
- object - is an instance that can be used and created
- variable types
    - instance
    - local

### Mini exercise
- Create a list of object that could store a movie data
- Object should hold: title, genre, rating
- Object should have a method to `playIt()`

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

More about classes can be found [here](http://tutorials.jenkov.com/java/classes.html)

## Encapsulation

Encapsulation - how the variable/method is well hidden in the class.

- `private` - only class can see it
- `public` - everyone can see it

There are also *protected* and *default* encapsulation types, but we will be talking about them later on.

- Using variables
 - Instance variables **have default values**
 - Local variables **must be initialized**

- Comparing variables
 - Primitive variables can be compated using `==`
 - Objects must use a method
 - Using `==` on variables will compare their references

## Constructors

Defines a way to build different kind of variations of the object.

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

## Final methods / variables

By using `final` keyword on methods or variables, we state that variable or method (through inheritance) cannot be changes any more.

We can use this keyword on
- Classes
- Methods
- Variables

```java
package lt.vcs.classes;

public class Dog {

    public void someMethod() {
        final int variable = 3;

        // code

        variable = 10; // Cannot change the variable
    }

}
```

## Static methods / variables

By using static methods we don't need to initialize a class before we use. Its method/variable belongs to the class
object itself and it can be used instantly.

- Static variables

```java
package lt.vcs.classes;

public class Dog {
    public static int LEGS = 4;
}
```

- Static methods

```java
package lt.vcs.classes;

public class Dog {
    public static boolean isDogBarking() {
        return true;
    }
}
```

To use static methods we need to define the class the static method belongs to, and execute the method.

```java
package lt.vcs;

import lt.vcs.classes.Dog;

public class Main {

    public static void main(String[] args) {
        Dog.isDogBarking();
    }

}
```

As this kind of variable can only belong to one instance, it is most commonly used with another keyword `final` to create constants (variables that do not change).

```java
package lt.vcs.classes;

public class Dog {

    public static final int LEGS = 4;

}
```

## This


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

## Method overloading

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

## Constructor overloading

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

