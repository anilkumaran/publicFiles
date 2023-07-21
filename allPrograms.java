
// Hello World
class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!"); 
    }
}

// try catch example
public class DivideByZeroHandler {
    public static void main(String[] args) {
        int numerator = 10;
        int denominator = 0;

        try {
            int result = numerator / denominator;
            System.out.println("Result: " + result);
        }
        catch (ArithmeticException e) {
            System.out.println("Error: ArithmeticException occured");
        }
    }
}

// Palindrome
public class PalindromeChecker {
    public static void main(String[] args) {
        String inputString = "radar"; // Change this string to test other cases
        boolean isPalindrome = inputString.replaceAll("[^a-zA-Z0-9]", "").equalsIgnoreCase(new StringBuilder(inputString).reverse().toString());
        if (isPalindrome) {
            System.out.println("Given number is palindrome");
        }
        else {
            System.out.println("Given number is not palindrome");

        }
    }
}

// print even and odd numbers
public class EvenOddNumbers {
    public static void main(String[] args) {
        int n = 10; // Change this number to set the range

        System.out.println("Even numbers:");
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }

        System.out.println("\nOdd numbers:");
        for (int i = 0; i <= n; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }
    }
}

// prime number
public class PrimeNumbersFinder {
    public static void main(String[] args) {
        int start = 1;
        int end = 19;

        System.out.println("Prime numbers between " + start + " and " + end + ":");
        for (int num = start; num <= end; num++) {
            if (isPrime(num)) {
                System.out.print(num + " ");
            }
        }
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
