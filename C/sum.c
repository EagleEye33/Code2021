/*This program adds two integer values
 and displays the sum*/
#include <stdio.h>

int main(void) {

    //Declare variables
    int sum, value1, value2;

    //Assign values and calculate their sum
    value1 = 25;
    value2 = 50;
    sum = value1 + value2;

    //Display the result
    printf("The sum of %i and %i is %i\n",value1,value2,sum);

    return 0;
}