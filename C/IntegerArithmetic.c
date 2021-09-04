#include <stdio.h>

int main(void) {
    
    int a, b, c, d, result;
    a = 100; b = 2; c = 25; d = 4; 

    result = a - b;
    printf("a - b = %i\n", result);

    result = b * c; 
    printf("a * b = %i\n", result);

    result = a / c;
    printf("a / c = %i\n", result);

    printf("a * b + c * d = %i\n\n", a * b + c * d);

    a = 25; b = 2;

    d = 2;

    printf("6 + a / 5 * b = %i\n", 6 + a / 5 * b);
    printf("c / d * d = %f\n", (float)c / d * d);
    printf("a / b * b + a %% b = %i\n", a / b * b + a % b);

    int _ = 99;
    printf("%i", _); 

    return 0;
}