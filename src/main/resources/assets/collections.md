# Collections

Data storing in bigger amounts by stacking them together for further manipulation.

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

- two dimension arrays

```java
int[][] multi = new int[5][10];

int[][] multi = new int[5][];
multi[0] = new int[10];
multi[1] = new int[10];
multi[2] = new int[10];
multi[3] = new int[10];
multi[4] = new int[10];

int[][] multi = new int[][]{
  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
};

```

## Lists

List is one of the most commanly used java object. Its a *fancier* array and you do not even have to thing about size of the list, as it expands automatically whenever we add a new item. 
There are various type of lists, one of the most comman one is `ArrayList`, thats what we will be using in the further exercises.

- `ArrayList`
- `LinkedList`
- `Vector`
- `Stack`

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

Mostly used methods on Lists

Method|Return type|Description
:---|:---:|:---
`list1.size()` | int | Returns size of the list
`list1.add(item)` | Object | Add an item to the list
`list1.remove(item)` | Object | Remove an object from the list
`list1.addAll(items)` | Other object list | Concats nother list
`list1.clear()` | void | Clears all the items from the list

- More [info](http://tutorials.jenkov.com/java-collections/list.html) on the lists

## Maps

Maps is a dictionary where you hold a `key` and a `value`. Whenever you map a value with some key, you can quickly find it by passing in a key in a `.get(key)` method.

There are all kinds of maps out there, most comman one is `HashMap`.

- `HashMap`
- `Hashtable`
- `EnumMap`
- `IdentityHashMap`
- `LinkedHashMap`
- `Properties`
- `TreeMap`
- `WeakHashMap`

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

Most common methods in the `Map`

Method|Return type|Description
:---|:---:|:---
`map.size()` | int | Returns size of the map
`map.put(key1, value1)` | Object, Object | Add a value to the sided key
`map.remove(key1)` | Object | A value and a bindded key
`map.clear()` | void | Clears all the items from the list
`map.replace(key1, value1)` | void | Replace value for a key
`map.isEmpty()` | boolean | Checks if map is empty
`map.containsKey(key1)` | boolean | Checks if map has a provided key
`map.containsValue(value1)` | boolean | Checks if map has a provided value
`map.values(value1)` | Collection / List | Returns a collection of values

- More [info](http://tutorials.jenkov.com/java-collections/map.html)  on the map
