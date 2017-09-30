# Structure in code

## Methods

- Simple method

```java
public static void methodName() {
   // body
}
```

- Method that returns a value after calculation

```java
public static int methodName() {
   // body
   return 0;
}
```

- Method that takes in arguments and returns a value
- Method `uses` parameters

```java
public static int methodName(int a, int b) {
   // body
   return 0;
}
```

- Caller `passes` arguments

```java
package lt.vcs;

public class Main {

    public static void main(String[] args) {
        methodName(1, 2);
    }

    public static int methodName(int a, int b) {
        return a + b;
    }

}
```

- Pass by value
    - Passing in primitive variable will create a copy
- Pass by reference
    - Passing in a reference to the object will modify the same object
