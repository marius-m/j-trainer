# Java basics

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

