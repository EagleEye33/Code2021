# -*- coding: utf-8 -*-
"""
Created on Mon Jun 21 01:37:33 2021

@author: wyatt
"""

from math import sqrt 

import time

from collections import Counter


MyList = []

twi = time.time()
n = 10000000
my_prime_list = [2]    # initialize a list to store primes
answer = 3

k = 0    # keeps track of loop iterations
for q in range(3, int(sqrt(n)) + 1): # numbers to be tested for divisibility    
    x = 0
    while k < len(my_prime_list):   # requires index within list range
        
        if my_prime_list[k] <= sqrt(q):    # requires value at index be <= to sqrt of number
            
            if q % my_prime_list[k] == 0:    # requires number be divisible by value at index  
                
                break      
            else:    
                k += 1
                
        else:     
            my_prime_list.append(q)    # add the number to list of primes
            for q in range(my_prime_list[-2]**2, my_prime_list[-1]**2):  
                    x = 0
                    while(q / my_prime_list[x] >= 1):
                        if q / my_prime_list[x] % 1 == 0:
                            MyList.append(my_prime_list[x]) 
                            q /= my_prime_list[x] 
                            x = 0
                        elif len(my_prime_list) - 1 == x:
                            break;
                        else:
                            x += 1
            
                    c = Counter(MyList)
                    j = 1
                    for i in c:
                       k = c[i] - (c[i] % 2)
                       j *= i**k
                    answer += j
                    MyList.clear()
            break
            
    k = 0    # reset index

for q in range(my_prime_list[-1]**2, n+1):  
    x = 0
    while(q / my_prime_list[x] >= 1):
        if q / my_prime_list[x] % 1 == 0:
            MyList.append(my_prime_list[x]) 
            q /= my_prime_list[x] 
            x = 0
        elif len(my_prime_list) - 1 == x:
            break;
        else:
            x += 1
            
    c = Counter(MyList)
    j = 1
    for i in c:
        k = c[i] - (c[i] % 2)
        j *= i**k
    answer += j
    MyList.clear()
    
print(answer);    

twf = time.time()
print('time took!:', twf-twi)