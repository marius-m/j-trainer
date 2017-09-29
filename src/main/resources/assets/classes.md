# Classes

- Object `knows` about itself - instance variables (state)
- Object can `do` something - methods (behaviour)
- `instance` == `object`

### Exercise
- Procedural code VS Object oriented (Lots of shapes!)

- Create 3 shapes (Square, circle, triangle) that could `rotate()` and `playSound()`
- Adding one more shape with different `rotate()` and `playSound()`
- Reusing code

## Classes

- class - is like a blueprint, how can you make an object
- object - is an instance that can be used and created
- variable types
 - instance
 - local

### Exercise
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

## Encapsulation

Encapsulation - how the variable/method is well hidden in the class.

- `private` - only class can see it
- `protected` - only extended classes can see it
- default - classes in the same package can see it
- `public` - everyone can see it

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

