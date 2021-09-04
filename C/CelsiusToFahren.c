#include <stdio.h>

int main(void) {

    float TempF = 27, TempC;

    TempC = (TempF - 32) / 1.8;

    printf("27 degrees Fahrenheit in Celsius is %f\n", TempC);
    
    float x = 2.55;
    double result = 3*(x*x*x) - 5*(x*x) + 6;

    printf("3x^3 - 5x^2 + 6 = %f\n", result);

    double result2 = (3.31e-8 * 2.01e-7) / (7.16e-6 + 2.01e-8);

    printf("result2: %e\n", result2);

    int i = 365, j = 7;
    int Next_multiple = i + j - i % j;

    printf("First: %i\n", Next_multiple);

    i = 12258; j = 23;
    Next_multiple = i + j - i % j;

    printf("Second: %i\n", Next_multiple);

    i = 996; j = 4;
    Next_multiple = i + j - i % j;

    printf("Third: %i\n", Next_multiple);

    return 0;
    }