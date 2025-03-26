
// 1. Reverse of a number

#include <stdio.h>

int main() {
    int n, reversed = 0, remainder;

    // Input from user
    printf("Enter an integer: ");
    scanf("%d", &n);

    // Reverse the number
    while (n != 0) {
        remainder = n % 10;          // Extract last digit
        reversed = reversed * 10 + remainder; // Append to reversed number
        n /= 10;                     // Remove last digit
    }

    printf("Reversed number: %d\n", reversed);
    return 0;
}

// 4 C program for prime numbers between 1 and n

#include <stdio.h>
#include <math.h>

int is_prime(int num) {
    if (num < 2) return 0;
    int limit = (int)sqrt(num);  // Taking the integer part of sqrt(num)
    for (int i = 2; i <= limit; i++) {
        if (num % i == 0) return 0;
    }
    return 1;
}

int main() {
    int n;
    printf("Enter a number: ");
    scanf("%d", &n);

    printf("Prime numbers between 1 and %d are:\n", n);
    for (int i = 2; i <= n; i++) {
        if (is_prime(i)) {
            printf("%d ", i);
        }
    }
    return 0;
}


// 13.Write a C program to count the lines, words and characters in a given text
#include <stdio.h>
int main() {
    char c; int lines = 0, words = 0, chars = 0, in_word = 0;
    printf("Enter text (end with ~):\n");
    while ((c = getchar()) != '~') {
        chars++;
        if (c == '\n') lines++;
        if (c == ' ' || c == '\n' || c == '\t') in_word = 0;
        else if (!in_word) { in_word = 1; words++; }
    }
    printf("Characters: %d\nWords: %d\nLines: %d\n", chars, words, lines+1);
    return 0;
}

// 15. Write a C program that uses functions to perform the following operations: i) Reading a complex number ii) Writing a complex number iii) Addition of two complex numbers.
// Addition: z1+z2 =(a1+a2) + i(b1+b2)
// Subtraction: z1-z2 = (a1-a2) + i(b1-b2)
// Multiplication: z1 * z2 = (a1a2 – b1b2) + i(a1b2 + a2b1)
// Division = (a1a2 + b1b2) / (a2^2 + b2^2) + i((a2b1 - a1b2)/(a2^2 + b2^2))

#include <stdio.h>

typedef struct {
    float real;
    float imag;
} Complex;

Complex readComplex() {
    Complex num;
    printf("Enter real and imaginary parts: ");
    scanf("%f %f", &num.real, &num.imag);
    while (getchar() != '\n'); // Clear input buffer
    return num;
}

void printComplex(Complex num) {
    printf("%.2f + %.2fi\n", num.real, num.imag);
}

Complex addComplex(Complex n1, Complex n2) {
    return (Complex){n1.real + n2.real, n1.imag + n2.imag};
}

Complex subtractComplex(Complex n1, Complex n2) {
    return (Complex){n1.real - n2.real, n1.imag - n2.imag};
}

Complex multiplyComplex(Complex n1, Complex n2) {
    return (Complex){n1.real * n2.real - n1.imag * n2.imag,
                     n1.real * n2.imag + n1.imag * n2.real};
}

Complex divideComplex(Complex n1, Complex n2) {
    float denominator = n2.real * n2.real + n2.imag * n2.imag;
    return (Complex){(n1.real * n2.real + n1.imag * n2.imag) / denominator,
                     (n1.imag * n2.real - n1.real * n2.imag) / denominator};
}

int main() {
    Complex n1, n2, result;
    
    printf("Enter first complex number:\n");
    n1 = readComplex();
    
    printf("Enter second complex number:\n");
    n2 = readComplex();
    
    printf("Addition: ");
    printComplex(addComplex(n1, n2));
    
    printf("Subtraction: ");
    printComplex(subtractComplex(n1, n2));
    
    printf("Multiplication: ");
    printComplex(multiplyComplex(n1, n2));
    
    printf("Division: ");
    printComplex(divideComplex(n1, n2));
    
    return 0;
}


// 16. Write a C program which copies one file to another
#include <stdio.h>
#include <stdlib.h>

FILE* openFile(const char *filename, const char *mode) {
    FILE *file = fopen(filename, mode);
    if (file == NULL) {
        perror("Error opening file");
        exit(EXIT_FAILURE);
    }
    return file;
}

void copyFile(const char *source, const char *destination) {
    FILE *sfp = openFile(source, "rb"); // Open source file in binary read mode
    FILE *dfp = openFile(destination, "wb"); // Open destination file in binary write mode

    char buffer[1024]; // Buffer to hold data during copy
    size_t bytesRead;

    while ((bytesRead = fread(buffer, 1, sizeof(buffer), sfp)) > 0) {
        fwrite(buffer, 1, bytesRead, dfp);
    }

    // Close both files
    fclose(sfp);
    fclose(dfp);

    printf("File copied successfully!\n");
}

int main() {
    const char *sourceFile = "source.txt";
     // Replace with your source file name
    const char *destinationFile = "destination.txt"; // Replace with your destination file name

    copyFile(sourceFile, destinationFile); // Call the copy function

    return 0;
}
