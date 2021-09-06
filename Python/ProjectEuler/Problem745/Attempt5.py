# -*- coding: utf-8 -*-
"""
Created on Mon Jun 21 04:19:00 2021

@author: wyatt
"""

from sympy.ntheory import factorint

#from math import sqrt

import time

from collections import Counter

#MyList = []

twi = time.time()
n = 100
#my_prime_list = [2]    # initialize a list to store primes
answer = 0

'''k = 0    # keeps track of loop iterations
for q in range(3, int(sqrt(n)) + 1): # numbers to be tested for divisibility    
    while k < len(my_prime_list):   # requires index within list range
        
        if my_prime_list[k] <= sqrt(q):    # requires value at index be <= to sqrt of number
            
            if q % my_prime_list[k] == 0:    # requires number be divisible by value at index  
                
                break      
            else:    
                k += 1
                
        else:     
            my_prime_list.append(q)    # add the number to list of primes
                    
            break
            
    k = 0    # reset index
    '''


for c in range(1, n+1):          
    c = Counter(factorint(c))
    j = 1
    for i in c:
        k = c[i] - (c[i] % 2)
        j *= i**k
    answer += j
    
print(answer);    

twf = time.time()
print('time took!:', twf-twi)