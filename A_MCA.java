//  1) Write a Java program using arithmetic operators in a switch case .[ int+String etc] using enum.
import java.util.Scanner;

enum OpType {
    ADD, SUB, MUL, DIV, CONCAT, INT_STR
}

public class ArithmeticOperations {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Integer inputs
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();
        
        // String inputs
        sc.nextLine(); // Consume newline
        System.out.print("Enter first text: ");
        String txt1 = sc.nextLine();
        
        System.out.print("Enter second text: ");
        String txt2 = sc.nextLine();
        
        // Perform operations
        processOp(OpType.ADD, num1, num2, txt1, txt2);
        processOp(OpType.SUB, num1, num2, txt1, txt2);
        processOp(OpType.MUL, num1, num2, txt1, txt2);
        processOp(OpType.DIV, num1, num2, txt1, txt2);
        processOp(OpType.CONCAT, num1, num2, txt1, txt2);
        processOp(OpType.INT_STR, num1, num2, txt1, txt2);
        
        sc.close();
    }

    private static void processOp(OpType op, int num1, int num2, String txt1, String txt2) {
        switch (op) {
            case ADD:
                System.out.println("Sum: " + (num1 + num2));
                break;
            case SUB:
                System.out.println("Difference: " + (num1 - num2));
                break;
            case MUL:
                System.out.println("Product: " + (num1 * num2));
                break;
            case DIV:
                if (num2 != 0) {
                    System.out.println("Quotient: " + (num1 / num2));
                } else {
                    System.out.println("Cannot divide by zero.");
                }
                break;
            case CONCAT:
                System.out.println("String Concatenation: " + txt1 + txt2);
                break;
            case INT_STR:
                System.out.println("Integer + String: " + num1 + txt1);
                System.out.println("String + Integer: " + txt1 + num2);
                break;
            default:
                System.out.println("Invalid operation.");
        }
    }
}

/* OUTPUT
Enter first number: 10
Enter second number: 5
Enter first text: Hello
Enter second text: World
Sum: 15
Difference: 5
Product: 50
Quotient: 2
String Concatenation: HelloWorld
Integer + String: 10Hello
String + Integer: Hello5
*/

//  2) Write a Java program with constructor overloading.
class Person {
    private String name;
    private int age;

    // Default constructor
    public Person() {
        this.name = "Unknown";
        this.age = 0;
    }

    // Constructor with one parameter (name)
    public Person(String name) {
        this.name = name;
        this.age = 0;
    }

    // Constructor with two parameters (name & age)
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        Person p1 = new Person();             // Calls default constructor
        Person p2 = new Person("Anil");      // Calls single-parameter constructor
        Person p3 = new Person("Kumar", 25);    // Calls two-parameter constructor

        p1.display();
        p2.display();
        p3.display();
    }
}


/*
Name: Unknown, Age: 0
Name: Anil, Age: 0
Name: Kumar, Age: 25

*/


//  3) Write a Java program for method overloading using "this" keyword for instance variables.
class Person {
    private String name;
    private int age;

    // Method Overloading using "this" keyword

    public void setDetails(String name) {
        this.name = name;  // Using "this" for instance variable
    }

    public void setDetails(int age) {
        this.age = age;  // Using "this" for instance variable
    }

    public void setDetails(String name, int age) {
        this.name = name;
        this.age = age;  // Using "this" for both instance variables
    }

    public void display() {
        System.out.println("Name: " + this.name + ", Age: " + this.age);
    }

    public static void main(String[] args) {
        Person p = new Person();

        p.setDetails("Anil");  // Calls method with one String parameter
        p.display();

        p.setDetails(25);       // Calls method with one int parameter
        p.display();

        p.setDetails("Kumar", 30); // Calls method with two parameters
        p.display();
    }
}


/* OUTPUT 
Name: Anil, Age: 0
Name: Anil, Age: 25
Name: Kumar, Age: 30
*/

//  4) Write a Java program for recursion .
import java.util.Scanner;

class RecursionExample {
    // Recursive method to calculate factorial
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1; // Base case
        }
        return n * factorial(n - 1); // Recursive case
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int result = factorial(n);
        System.out.println("Factorial of " + n + " is: " + result);

        sc.close();
    }
}


/* OUTPUT 
Enter a number: 5
Factorial of 5 is: 120
*/

//  5) Write a Java program demonstrating static variables, methods, and blocks.
class StaticExample {
    // Static variable
    static int count = 0;

    // Static block
    static {
        System.out.println("Static block executed");
        count = 100; // Initializing static variable
    }

    // Constructor to increment count
    public StaticExample() {
        count++;
    }

    // Static method
    public static void displayCount() {
        System.out.println("Count: " + count);
    }

    public static void main(String[] args) {
        System.out.println("Main method started");

        StaticExample obj1 = new StaticExample();
        StaticExample obj2 = new StaticExample();

        // Calling static method
        StaticExample.displayCount();
    }
}


/* OUTPUT 
Static block executed
Main method started
Count: 102
*/

//  6) Write a Java program for types of nested classes [local, anonymous, non-static, static].
class OuterClass {
    private String outerMessage = "Hello from OuterClass!";

    // 1️⃣ Non-static (Inner) Class
    class InnerClass {
        void display() {
            // Accessing instance variable of the outer class (this is valid here)
            System.out.println("Non-static Inner Class: " + outerMessage);
        }
    }

    // 2️⃣ Static Nested Class
    static class StaticNestedClass {
        void display() {
            // Cannot access outer class instance variables directly.
            System.out.println("Static Nested Class: Can access only static members.");
        }
    }

    // Method demonstrating Local Inner Class
    void showLocalInnerClass() {
        // 3️⃣ Local Inner Class
        class LocalInner {
            void display() {
                System.out.println("Local Inner Class: Defined inside a method.");
            }
        }
        LocalInner local = new LocalInner();
        local.display();
    }

    // Method demonstrating Anonymous Inner Class
    void showAnonymousInnerClass() {    
        // 4️⃣ Anonymous Inner Class
        Runnable anonymous = new Runnable() {
            public void run() {
                System.out.println("Anonymous Inner Class: Created without a class name.");
            }
        };
        anonymous.run();
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();

        // Non-static Inner Class (requires outer class instance)
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.display();

        // Static Nested Class (can be instantiated without an outer instance)
        OuterClass.StaticNestedClass staticNested = new OuterClass.StaticNestedClass();
        staticNested.display();

        // Local Inner Class
        outer.showLocalInnerClass();

        // Anonymous Inner Class
        outer.showAnonymousInnerClass();
    }
}


/* OUTPUT 
Non-static Inner Class: Hello from OuterClass!
Static Nested Class: Can access only static members.
Local Inner Class: Defined inside a method.
Anonymous Inner Class: Created without a class name.
*/

//  7) Write a Java program demonstrating how Varags works.
public class VarargsExample {

    // Method to demonstrate varargs with numbers
    public static void printNumbers(int... numbers) {
        // If no numbers are passed
        if (numbers.length == 0) {
            System.out.println("No numbers were passed!");
        } else {
            // Printing numbers
            System.out.print("Numbers: ");
            for (int num : numbers) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Calling method with multiple integer arguments
        printNumbers(1, 2, 3, 4, 5);

        // Calling method with no arguments
        printNumbers();
    }
}
/* OUTPUT 
Numbers: 1 2 3 4 5
No numbers were passed!
*/

//  8) Write a Java program for Inheritance including multi-level, multiple [diamond ambiguity], and "final" keyword
class Animal {
    public final void eat() {
        System.out.println("Animal is eating."); 
    } // final method
    public void sleep() {
        System.out.println("Animal is sleeping."); 
    }
}

// Multi-level Inheritance
class Mammal extends Animal {
    public void sound() {
        System.out.println("Mammal makes sound.");
    }
}

class Dog extends Mammal {
    public void breed() {
        System.out.println("Dog breed is Labrador.");
    }

    @Override
    public void sleep() {
        System.out.println("Dog is sleeping.");
    }
}

// Interfaces for Multiple Inheritance (Diamond Problem)
interface AnimalBehavior {
    void run();
}
interface MammalBehavior {
    void swim();
}

// Resolving Diamond Problem via interfaces
class HybridDog implements AnimalBehavior, MammalBehavior {
    @Override
    public void run() {
        System.out.println("Hybrid Dog is running.");
    }

    @Override
    public void swim() {
        System.out.println("Hybrid Dog is swimming.");
    }
}

public class InheritanceExample {
    public static void main(String[] args) {
        // Multi-level inheritance example
        Dog dog = new Dog();
        dog.eat();   // from Animal class (final method)
        dog.sleep(); // overridden in Dog class
        dog.sound(); // from Mammal class
        dog.breed(); // from Dog class

        // Multiple inheritance via interfaces (diamond problem resolution)
        HybridDog hybridDog = new HybridDog();
        hybridDog.run();  // from AnimalBehavior
        hybridDog.swim(); // from MammalBehavior
    }
}



/* OUTPUT 
Animal is eating.
Animal is sleeping.
Mammal makes sound.
Dog breed is Labrador.
Hybrid Dog is running.
Hybrid Dog is swimming.
*/

//  9) Write a Java program on Polymorphism and for compile time [method overloading], and run-time [method overriding] include @Override.
// Parent class (Superclass)
class Animal {
    // Method Overriding (Runtime Polymorphism)
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

// Child class (Subclass)
class Dog extends Animal {
    // Using @Override annotation for method overriding
    @Override
    void sound() {
        System.out.println("Dog barks");
    }

    // Method Overloading (Compile-time Polymorphism)
    void sound(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("Dog barks");
        }
    }

    void sound(String type) {
        System.out.println("Dog makes a " + type + " sound");
    }
}

public class PolymorphismExample {
    public static void main(String[] args) {
        // Runtime Polymorphism (Method Overriding)
        Animal myAnimal = new Animal();  // Animal reference
        myAnimal.sound();  // Output: Animal makes a sound

        // Dog reference
        Dog myDog = new Dog();
        myDog.sound();  // Output: Dog barks

        // Method Overloading (Compile-time Polymorphism)
        myDog.sound(3);  // Output: Dog barks (printed 3 times)
        myDog.sound("growl");  // Output: Dog makes a growl sound

        // Runtime Polymorphism with a reference of type Animal
        Animal myDogAsAnimal = new Dog();  // Upcasting
        myDogAsAnimal.sound();  // Output: Dog barks (Method overridden in Dog class)
    }
}

/* OUTPUT 
Animal makes a sound
Dog barks
Dog barks
Dog barks
Dog barks
Dog makes a growl sound
Dog barks
*/

//  10) Write a Java program for creating and importing packages .
/*
ProjectRoot/
│── myapp/
│   └── utilities/
│       └── MathUtility.java   <-- (Inside package myapp.utilities)
│
└── TestMathUtility.java       <-- (Outside package, in ProjectRoot)
*/

// Import the MathUtility class from the myapp.utilities package
import myapp.utilities.MathUtility;

public class TestMathUtility {
    public static void main(String[] args) {
        // Define a number
        int number = 5;

        // Call methods from the MathUtility class
        int squareResult = MathUtility.square(number);
        int cubeResult = MathUtility.cube(number);

        // Print results
        System.out.println("Square of " + number + " is: " + squareResult);
        System.out.println("Cube of " + number + " is: " + cubeResult);
    }
}

// TestMathUtility.java 
package myapp.utilities;

public class MathUtility {
    public static int square(int number) {
        return number * number;
    }

    public static int cube(int number) {
        return number * number * number;
    }
}


/* OUTPUT 

*/

//  11) Import Math package using "import static"
import static java.lang.Math.*;  // Import all static methods from Math

public class MathExample {
    public static void main(String[] args) {
        double num = 25;
        
        System.out.println("Square root of " + num + " is " + sqrt(num));
        System.out.println("Power: 2^3 = " + pow(2, 3));
        System.out.println("Pi value: " + PI);
    }
}

/* OUTPUT 
Square root of 25.0 is 5.0
Power: 2^3 = 8.0
Pi value: 3.141592653589793
*/

//  12) Write a Java program using Interfaces including variable, concrete methods, and abstract methods.
// Define an interface with variables, abstract, default, and static methods
interface Vehicle {
    // Interface variable (constant)
    int MAX_SPEED = 120;  // Final & static by default

    // Abstract method (must be implemented)
    void start();

    // Concrete method (default)
    default void stop() {
        System.out.println("Vehicle is stopping...");
    }

    // Concrete method (static)
    static void displayMaxSpeed() {
        System.out.println("Max Speed: " + MAX_SPEED + " km/h");
    }
}

// Implementing the interface in a class
class Car implements Vehicle {
    // Implementing the abstract method
    public void start() {
        System.out.println("Car is starting...");
    }
}

// Main class
public class InterfaceExample {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.start();   // Calls the implemented method
        myCar.stop();    // Calls the default method from interface
        Vehicle.displayMaxSpeed(); // Calls static method from interface
    }
}


/* OUTPUT 
Car is starting...
Vehicle is stopping...
Max Speed: 120 km/h
*/

//  13) Write a Java program for SAM [Single Abstract method] .
// Defining the SAM interface
@FunctionalInterface
interface Greeting {
    // Single abstract method (SAM)
    void sayHello(String name);

    // You can have other methods, but there should be exactly one abstract method
    // This can be a default or static method
    default void greet() {
        System.out.println("Greetings!");
    }
}

public class Main {
    public static void main(String[] args) {
        Greeting greeting = (name) -> System.out.println("Hello, " + name);
        greeting.sayHello("John"); // Output: Hello, John
        greeting.greet(); // Output: Greetings!
    }
}

/* OUTPUT 
Hello, John
Greetings!
*/

//  14) Write a Java program to demonstrate Abstract classes using hierarchical inheritance.
// Abstract class
abstract class Animal {
    // Abstract method (to be implemented by subclasses)
    abstract void makeSound();

    // Concrete method (common for all animals)
    void sleep() {
        System.out.println("Animal is sleeping...");
    }
}

// Subclass 1: Dog
class Dog extends Animal {
    // Implementing abstract method
    @Override
    void makeSound() {
        System.out.println("Dog barks: Woof Woof!");
    }
}

// Subclass 2: Cat
class Cat extends Animal {
    // Implementing abstract method
    @Override
    void makeSound() {
        System.out.println("Cat meows: Meow Meow!");
    }
}

// Main class
public class AbstractDemo {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        Animal myCat = new Cat();

        myDog.makeSound();  // Calls Dog's implementation
        myDog.sleep();      // Calls concrete method from Animal
        
        myCat.makeSound();  // Calls Cat's implementation
        myCat.sleep();      // Calls concrete method from Animal
    }
}

/* OUTPUT 
Dog barks: Woof Woof!
Animal is sleeping...
Cat meows: Meow Meow!
Animal is sleeping...
*/

//  15) Write a Java program for Pre-defined exceptions like ArithmeticException using try-catch and finally blocks and handle the exceptions.
public class ExceptionHandlingDemo {
    public static void main(String[] args) {
        int n1 = 10, n2 = 0, result;

        try {
            // Attempt division by zero (causes ArithmeticException)
            result = n1 / n2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            // Handle the exception
            System.out.println("Error: Cannot divide by zero! " + e.getMessage());
        } finally {
            // Finally block always executes
            System.out.println("Execution completed, whether an exception occurred or not.");
        }
        
        System.out.println("Program continues...");
    }
}

/* OUTPUT 
ERROR!
Error: Cannot divide by zero! / by zero
Execution completed, whether an exception occurred or not.
Program continues...

*/

//  16) Write a Java program for User-defined exceptions using try with multiple catch [rethrow] blocks and handle the exceptions using "throw" keyword.
// User-defined exception class
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class UserDefinedExceptionDemo {
    // Method to check age
    static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above.");
        } else {
            System.out.println("You are eligible to vote.");
        }
    }

    public static void main(String[] args) {
        try {
            int age = 15;  // Change this value to test different cases
            checkAge(age);
        } catch (InvalidAgeException e) {
            System.out.println("Custom Exception Caught: " + e.getMessage());
            throw new RuntimeException("Rethrowing exception: " + e.getMessage()); // Rethrowing
        } catch (RuntimeException e) {
            System.out.println("Runtime Exception Caught: " + e.getMessage());
        } finally {
            System.out.println("Execution completed.");
        }

        System.out.println("Program continues...");
    }
}

/* OUTPUT 
Custom Exception Caught: Age must be 18 or above.
ERROR!
Execution completed.
Exception in thread "main" java.lang.RuntimeException: Rethrowing exception: Age must be 18 or above.
	at Main.main(Main.java:24)
*/

//  17) Write a Java program for User-defined exceptions using nested try blocks by extending Throwable class.[catching subclass exceptions]
class DivisionByZeroException extends Throwable {
    public DivisionByZeroException(String message) {
        super(message);
    }
}

class InvalidCalculationException extends DivisionByZeroException {
    public InvalidCalculationException(String message) {
        super(message);
    }
}

public class NestedTryUserException {
    public static void main(String[] args) {
        try {
            try {
                int result = 1 / 0; // This will cause ArithmeticException
                throw new InvalidCalculationException("This is a SubCustomException");
            } catch (ArithmeticException e) {
                System.out.println("Caught ArithmeticException: " + e.getMessage());
                throw new DivisionByZeroException("Now throwing CustomException");
            }
        } catch (DivisionByZeroException e) {
            System.out.println("Caught CustomException: " + e.getMessage());
        }
    }
}
/* OUTPUT 
Caught ArithmeticException: / by zero
Caught CustomException: Now throwing CustomException
*/

//  18) Write a Java program with "Try with resource" using user-defined threads and execute them.
// A thread in Java is the smallest unit of execution within a program. It allows multiple operations to run concurrently (at the same time) rather than sequentially, improving performance and responsiveness.
class FileProcessorCustomThread extends Thread implements AutoCloseable {
    private String threadName;
    
    public FileProcessorCustomThread(String threadName) {
        this.threadName = threadName;
    }
    
    @Override
    public void run() {
        System.out.println(threadName + " is running...");
        try {
            Thread.sleep(2000); // Simulate some work
        } catch (InterruptedException e) {
            System.out.println(threadName + " was interrupted.");
        }
        System.out.println(threadName + " has completed execution.");
    }
    
    @Override
    public void close() {
        System.out.println(threadName + " is closing resources.");
    }
}

public class TryWithResourcesThreads {
    public static void main(String[] args) {
        try (FileProcessorCustomThread thread1 = new FileProcessorCustomThread("Thread-1");
             FileProcessorCustomThread thread2 = new FileProcessorCustomThread("Thread-2")) {
            
            thread1.start();
            thread2.start();
            
            thread1.join(); // Ensure thread completion before exiting try block
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread execution was interrupted.");
        }
    }
}
/* OUTPUT 
Thread-1 is running...
Thread-2 is running...
Thread-2 has completed execution.
Thread-1 has completed execution.
Thread-2 is closing resources.
Thread-1 is closing resources.
*/

//  19) Write a Java program for "synchronization" by creating multiple user-defined threads, using "throws" keyword, and notify(), join(), wait(), notifyAll(), thread life cycle.
// Synchronization in Java is a mechanism that allows multiple threads to safely access shared resources without conflicts. It ensures that only one thread can access a critical section of code at a time, preventing race conditions and inconsistent data.

class KitchenResource {
    private boolean available = false;
    
    public synchronized void prepareOrder() throws InterruptedException {
        while (available) {
            wait();
        }
        System.out.println(Thread.currentThread().getName() + " prepared an order.");
        available = true;
        notifyAll();
    }
    
    public synchronized void serveOrder() throws InterruptedException {
        while (!available) {
            wait();
        }
        System.out.println(Thread.currentThread().getName() + " served an order.");
        available = false;
        notifyAll();
    }
}

class ChefThread extends Thread {
    private KitchenResource resource;
    
    public ChefThread(KitchenResource resource, String name) {
        super(name);
        this.resource = resource;
    }
    
    @Override
    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                resource.prepareOrder();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted.");
        }
    }
}

class WaiterThread extends Thread {
    private KitchenResource resource;
    
    public WaiterThread(KitchenResource resource, String name) {
        super(name);
        this.resource = resource;
    }
    
    @Override
    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                resource.serveOrder();
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted.");
        }
    }
}

public class RestaurantOrderProcessing {
    public static void main(String[] args) {
        KitchenResource resource = new KitchenResource();
        
        ChefThread chef = new ChefThread(resource, "Chef");
        WaiterThread waiter = new WaiterThread(resource, "Waiter");
        
        chef.start();
        waiter.start();
        
        try {
            chef.join();
            waiter.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        
        System.out.println("All threads have completed execution.");
    }
}

/* OUTPUT 
Chef prepared an order.
Waiter served an order.
Chef prepared an order.
Waiter served an order.
Chef prepared an order.
Waiter served an order.
All threads have completed execution.

*/

//  20) Write a Java program for auto-boxing and unboxing .
// Auto-boxing: Automatic conversion of primitive types (int, double, etc.) to wrapper classes (Integer, Double, etc.).
// Unboxing: Automatic conversion of wrapper class objects back to primitive types.
public class BillPayment {
    public static void main(String[] args) {
        // Auto-boxing: Converting primitive to Wrapper Object
        Integer billAmount = 500; // int → Integer
        Double tax = 12.5; // double → Double
        
        // Processing bill (Unboxing: Wrapper Object → Primitive)
        double totalAmount = billAmount + tax; // Integer → int, Double → double
        
        // Displaying the values
        System.out.println("Bill Amount: " + billAmount); 
        System.out.println("Tax: " + tax);
        System.out.println("Total Payable: " + totalAmount);
        
        // Example of manual boxing & unboxing
        Integer discount = Integer.valueOf(50); // Explicit boxing
        int finalAmount = (int) totalAmount - discount; // Corrected unboxing
        
        System.out.println("Final Payable Amount (After Discount): " + finalAmount);
    }
}

/* OUTPUT 
Bill Amount: 500
Tax: 12.5
Total Payable: 512.5
Final Payable Amount (After Discount): 462

*/

//  21) Write a Java program to "finalize()" in garbage collection.
/*
Garbage Collection (GC) in Java is the automatic memory management process where the JVM reclaims memory occupied by unused objects to prevent memory leaks and improve efficiency.

What is finalize()?
. The finalize() method is called by the Garbage Collector before an object is destroyed.
. It is used to clean up resources (like closing files, releasing memory, etc.).
. Not guaranteed to run immediately after an object becomes eligible for garbage collection.
 */
class GarbageExample {
    private String name;

    public GarbageExample(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(name + " is being collected by Garbage Collector.");
    }

    public static void main(String[] args) {
        GarbageExample obj1 = new GarbageExample("Object 1");
        GarbageExample obj2 = new GarbageExample("Object 2");

        // Nullify references (Objects are now eligible for GC)
        obj1 = null;
        obj2 = null;

        // Request Garbage Collector
        System.gc();

        System.out.println("End of main method.");
    }
}


/* OUTPUT 
End of main method.
Object 1 is being collected by Garbage Collector.
Object 2 is being collected by Garbage Collector.

*/

//  22) Write a Java program using Command line arguments with [] Strings.
public class CommandLineExample {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No command line arguments provided.");
            return;
        }

        System.out.println("Command Line Arguments:");
        for (int i = 0; i < args.length; i++) {
            System.out.println("Argument " + (i + 1) + ": " + args[i]);
        }
    }
}

/* OUTPUT 
javac CommandLineExample.java
java CommandLineExample Alice 25 Developer

Command Line Arguments:
Argument 1: Alice
Argument 2: 25
Argument 3: Developer

*/

//  23) Write a Java program of String class with all methods.
public class StringMethodsExample {
    public static void main(String[] args) {
        // Creating a String
        String str = "  Hello, Java World!  ";
        
        // 1️⃣ Basic String Operations
        System.out.println("Original String: " + str);
        System.out.println("Length: " + str.length()); // Returns length of string
        System.out.println("Char at index 7: " + str.charAt(7)); // Fetch character at index

        // 2️⃣ String Case Conversion
        System.out.println("Upper Case: " + str.toUpperCase());
        System.out.println("Lower Case: " + str.toLowerCase());

        // 3️⃣ Trimming White Spaces
        System.out.println("Trimmed String: \"" + str.trim() + "\"");

        // 4️⃣ Searching in String
        System.out.println("Index of 'Java': " + str.indexOf("Java"));
        System.out.println("Last index of 'o': " + str.lastIndexOf("o"));
        System.out.println("Contains 'World': " + str.contains("World"));

        // 5️⃣ String Comparison
        String str2 = "hello, java world!";
        System.out.println("Equals (case-sensitive): " + str.equals(str2));
        System.out.println("Equals Ignore Case: " + str.equalsIgnoreCase(str2));

        // 6️⃣ String Substring
        System.out.println("Substring (7 to 11): " + str.substring(7, 11));

        // 7️⃣ String Replacement
        System.out.println("Replace 'Java' with 'Python': " + str.replace("Java", "Python"));

        // 8️⃣ Checking Start and End
        System.out.println("Starts with 'Hello': " + str.trim().startsWith("Hello"));
        System.out.println("Ends with '!': " + str.trim().endsWith("!"));

        // 9️⃣ Splitting a String
        String sentence = "Apple,Banana,Cherry";
        String[] words = sentence.split(",");
        System.out.println("Split String:");
        for (String word : words) {
            System.out.println(word);
        }

        // 🔟 String Joining
        String joinedString = String.join(" - ", words);
        System.out.println("Joined String: " + joinedString);

        // 1️⃣1️⃣ String Conversion
        int number = 123;
        String numStr = String.valueOf(number);
        System.out.println("String from int: " + numStr);

        // 1️⃣2️⃣ Immutable Nature of String
        str.concat(" This is extra!"); // This won't change the original string
        System.out.println("After concat (no change due to immutability): " + str);

        // 1️⃣3️⃣ Converting String to Char Array
        char[] charArray = str.toCharArray();
        System.out.print("Char Array: ");
        for (char ch : charArray) {
            System.out.print(ch + " ");
        }
        System.out.println();

        // 1️⃣4️⃣ Checking if String is Empty or Blank
        String emptyStr = "";
        String blankStr = "   ";
        System.out.println("Is empty string empty? " + emptyStr.isEmpty());
        System.out.println("Is blank string blank? " + blankStr.isBlank());

        // 1️⃣5️⃣ Comparing Using CompareTo
        System.out.println("CompareTo 'Apple' vs 'Banana': " + "Apple".compareTo("Banana"));
    }
}

/* OUTPUT 
Original String: "  Hello, Java World!  "
Length: 22
Char at index 7: ,
Upper Case:   HELLO, JAVA WORLD!  
Lower Case:   hello, java world!  
Trimmed String: "Hello, Java World!"
Index of 'Java': 9
Last index of 'o': 15
Contains 'World': true
Equals (case-sensitive): false
Equals Ignore Case: false
Substring (7 to 11): , Ja
Replace 'Java' with 'Python':   Hello, Python World!  
Starts with 'Hello': true
Ends with '!': true
Split String:
Apple
Banana
Cherry
Joined String: Apple - Banana - Cherry
String from int: 123
After concat (no change due to immutability):   Hello, Java World!  
Char Array:     H e l l o ,   J a v a   W o r l d ! 

*/

//  24) Write a Java program of Object class with all methods [11 methods].
class Car implements Cloneable {
    private String brand;

    public Car(String brand) {
        this.brand = brand;
    }

    // Overriding toString()
    @Override
    public String toString() {
        return "Car{brand='" + brand + "'}";
    }

    // Overriding equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Car car = (Car) obj;
        return brand.equals(car.brand);
    }

    // Overriding hashCode()
    @Override
    public int hashCode() {
        return brand.hashCode();
    }

    // Implementing clone()
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // finalize() (Deprecated)
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Car object is being garbage collected: " + this);
    }
}

public class ObjectMethodsDemo {
    public static void main(String[] args) throws InterruptedException, CloneNotSupportedException {
        Car car1 = new Car("Tesla");
        Car car2 = new Car("Tesla");

        // 1. getClass()
        System.out.println("Class: " + car1.getClass().getName());

        // 2. toString()
        System.out.println("Car: " + car1);

        // 3. equals()
        System.out.println("car1 equals car2: " + car1.equals(car2));

        // 4. hashCode()
        System.out.println("car1 HashCode: " + car1.hashCode());

        // 5. clone()
        Car clonedCar = (Car) car1.clone();
        System.out.println("Cloned Car: " + clonedCar);

        // 6. wait(), 7. notify(), 8. notifyAll() (Using synchronized block)
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Thread 1 waiting...");
                    lock.wait();
                    System.out.println("Thread 1 resumed!");
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread 2 notifying...");
                lock.notify();
            }
        });

        t1.start();
        Thread.sleep(1000); 
        t2.start();

        // 9. finalize() (Trigger GC)
        car1 = null;
        car2 = null;
        System.gc(); 
        Thread.sleep(1000); // Allow GC to run
    }
}
/* OUTPUT 
Class: Car
Car: Car{brand='Tesla'}
car1 equals car2: true
car1 HashCode: 83575398
Cloned Car: Car{brand='Tesla'}
Thread 1 waiting...
Thread 2 notifying...
Thread 1 resumed!
Car object is being garbage collected: Car{brand='Tesla'}

*/


// 25. write a java program using applets, awt
/*
An Applet is a Java program that runs inside a web browser or an Applet viewer. It was mainly used for embedding Java applications inside web pages.

🛠 Key Features of Applets:
✔ Runs inside a browser or Applet viewer.
✔ Uses the java.applet.Applet class.
✔ Cannot run standalone (needs a browser or appletviewer).
✔ Does not have a main() method.
✔ Uses HTML <applet> tag for execution.

AWT: AWT (Abstract Window Toolkit) is a Java package (java.awt) used for creating Graphical User Interfaces (GUIs).
✔ Provides basic UI components (Button, Label, TextField, etc.).
✔ Uses native OS components (platform-dependent).
✔ Not as flexible as Swing or JavaFX.
✔ Provides event handling through Event Listeners.

 */


// SimpleApplet.java
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class SimpleApplet extends Applet implements ActionListener {
    private TextField textField;
    private Button button;
    private Label label;

    @Override
    public void init() {
        // Set layout
        setLayout(new FlowLayout());

        // Create Components
        label = new Label("Enter your name:");
        textField = new TextField(20);
        button = new Button("Submit");

        // Add event listener
        button.addActionListener(this);

        // Add components to Applet
        add(label);
        add(textField);
        add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = textField.getText();
        showStatus("Hello, " + name + "!"); // Displays in Applet's status bar
    }
}
// applet.html
<html>
<body>
    <applet code="SimpleApplet.class" width="300" height="150"></applet>
</body>
</html>

/* OUTPUT 
javac SimpleApplet.java
appletviewer applet.html

*/

// 27 .Write a java program using swings.
// Swing is a part of Java's javax.swing package used for creating GUI applications.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");  
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 2));

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());
            if (username.equals("admin") && password.equals("123")) {
                JOptionPane.showMessageDialog(frame, "Login Successful!");
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid Credentials!");
            }
        });

        frame.add(userLabel); frame.add(userField);
        frame.add(passLabel); frame.add(passField);
        frame.add(new JLabel()); frame.add(loginButton);

        frame.setVisible(true);
    }
}

/*
 --------------------------------
| Username:  [__________]        |
| Password:  [__________]        |
|                                |
|         [Login]                |
 --------------------------------

// Successful login
 -----------------
| Login Successful! |
 -----------------
        [ OK ]


// Invalid login
  -------------------
| Invalid Credentials! |
 -------------------
        [ OK ]
 */


// 28
-



// 28) write a Java program reading and writing files using Byte Streams.
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class FileCopy {
    public static void main(String[] args) {
        String inputFile = "input.txt";  String outputFile = "output.txt"; // Input file
        // Output file
        try (
                FileInputStream fis = new FileInputStream(inputFile);
                FileOutputStream fos = new FileOutputStream(outputFile);
            ) {
                int byteData;
                while ((byteData = fis.read()) != -1) {
                    fos.write(byteData); // Write the byte to the output file
                }
                System.out.println("File copied successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }   
    }
}
 
/*OUTPUT
File copied successfully!
*/ 

// 29) write a Java program using Random access file.
import java.io.RandomAccessFile;
import java.io.IOException;
public class RandomAccessFileExample {
    public static void main(String[] args) {
        String filePath = "sample.txt";
        try (
                RandomAccessFile raf = new RandomAccessFile(filePath,"rw")
            ) {
                raf.writeUTF("Hello, this is a test for RandomAccessFile!");
                // Move the file pointer to the beginning
                raf.seek(0);
                // Read and print data from the file
                String content = raf.readUTF();
                System.out.println("File Content: " + content);

                // Move the pointer and write additional data
                raf.seek(7);
                raf.writeUTF("World!");
                // Move back to the beginning and read modified content
                raf.seek(0);
                System.out.println("Modified Content: " + raf.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
—-----------
/*OUTPUT
File Content: Hello, this is a test for RandomAccessFile!
Modified Content: Hello, World!
*/ 



-
//  30) write a Java program for reading and writing Binary data.
 //JAVA FILE(BinaryDataExample.java)

import java.io.*;
public class BinaryDataExample {
    public static void main(String[] args) {
        String filePath = "data.bin";
        // Write binary data to the file

        try (
                DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))
            ) {
                dos.writeInt(25); // Write an integer
                dos.writeDouble(3.14); // Write a double
                dos.writeUTF("Hello, Binary World!"); // Write a string
                System.out.println("Data written successfully. ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Read binary data from the file
        try (
                DataInputStream dis = new DataInputStream(new FileInputStream(filePath))
            ) {
                int number = dis.readInt();
                double piValue = dis.readDouble();
                String message = dis.readUTF();
                System.out.println("Read Data:");
                System.out.println("Integer: " + number);
                System.out.println("Double: " + piValue);
                System.out.println("String: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


/*OUTPUT
Data written successfully.
Read Data:

Integer: 25
Double: 3.14
String: Hello, Binary World!
*/ 


// 31) write a java program for converting binary data to object type
import java.io.*;
import java.util.Scanner;

class Person implements Serializable {
    String name;
    int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String toString() {
        return name + " - " + age;
    }
}

public class BinaryToObject {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        
        Person person = new Person(name, age);
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(person);
        oos.close();
        
        ByteArrayInputStream bais = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Person deserializedPerson = (Person) ois.readObject();
        ois.close();
        
        System.out.println("Deserialized: " + deserializedPerson);
        scanner.close();
    }
}

/*OUTPUT
Enter name: Alice
Enter age: 25
Deserialized: Alice - 25
*/ 





// 32) 
import java.io.*;
import java.util.Scanner;

class Person implements Serializable {
    String name;
    int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ObjectToBinary {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        
        Person person = new Person(name, age);
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(person);
        oos.close();
        
        byte[] binaryData = baos.toByteArray();
        System.out.println("Binary Data: " + new String(binaryData));
        
        scanner.close();
    }
}

/*OUTPUT
Enter name: Alice
Binary Data: ¬í�sr�PersonË=Ýd�I�ageL�namet�Ljava/lang/String;xp�t�Alice
*/ 
