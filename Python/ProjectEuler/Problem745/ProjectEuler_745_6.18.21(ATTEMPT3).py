# -*- coding: utf-8 -*-
"""
Created on Sun Jun 20 23:23:01 2021

@author: wyatt
"""
from math import sqrt 

import time


twi = time.time()
n = 1000
PerfectSquareDict = {};
#i = 1;
answer = 0;
count = 0

initialSet = set()
unionSet = set()
currentSet = set()
testSet = set()   

for i in range(int(((sqrt(n/4) + 1)) // 1), int(sqrt(n)) + 1):
    PerfectSquareDict[i] = i*i;

for x in range(int(((sqrt(n/2) + 1)) // 1), int(sqrt(n)) + 1):
    answer += PerfectSquareDict[x];
    initialSet.add(PerfectSquareDict[x])
    count += 1
    
for x in range(int(((sqrt(n/3) + 1)) // 1), int(((sqrt(n/2) +1 )) // 1)):
    answer = answer + 2 * PerfectSquareDict[x];
    initialSet.add(PerfectSquareDict[x])
    initialSet.add(PerfectSquareDict[x] *2)
    count += 2
    
for x in range(int(((sqrt(n/4) + 1)) // 1), int(((sqrt(n/3) + 1)) // 1)):
    answer = answer + 3 * PerfectSquareDict[x];
    initialSet.add(PerfectSquareDict[x])
    initialSet.add(PerfectSquareDict[x] *2)
    initialSet.add(PerfectSquareDict[x] *3)
    count += 3
    

Perfect_square_prime_dict = {2:4};
my_prime_list = [2]    # initialize a list to store primes

k = 0    # keeps track of loop iterations
for q in range(3, int(((sqrt(n/4) + 1)) // 1)): # numbers to be tested for divisibility    
    
    while k < len(my_prime_list):   # requires index within list range
        
        if my_prime_list[k] <= sqrt(q):    # requires value at index be <= to sqrt of number
            
            if q % my_prime_list[k] == 0:    # requires number be divisible by value at index
                break      
            else:    
                k += 1
                
        else:     
            my_prime_list.append(q)    # add the number to list of primes
            Perfect_square_prime_dict[q] = q*q

            break
            
    k = 0    # reset index


unionSet = unionSet.difference(initialSet)   

  
for g in my_prime_list:
    h = g*g
    w = h
    currentSet.add(h)
    while (h+w) < n:
        h += w 
        currentSet.add(h)
    currentSet = currentSet.difference(initialSet)
    testSet = currentSet.difference(unionSet)
    unionSet = unionSet.union(currentSet)
    currentSet.clear()
                
    for i in testSet:
        w = g*g
        k = 0
        m = i / w
        multi_sum = w
        w = 4         
        while (m / w) >= 1:
            if (m / w) % 1 == 0:
                m /= w
                multi_sum *= w
                w = 4
                k = 0
            if k+1 == len(my_prime_list):
                break;
            else:
                k += 1
                x = my_prime_list[k]
                w = x*x
                                    
        answer += multi_sum
        print(i, multi_sum,answer)
        
count += len(unionSet)
answer += (n-count)   

print(answer%1000000007, n-count);    

twf = time.time()
print('time took!:', twf-twi)














