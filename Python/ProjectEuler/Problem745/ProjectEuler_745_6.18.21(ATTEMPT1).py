# -*- coding: utf-8 -*-
"""
Created on Thu Jun 17 17:42:53 2021

@author: morga
"""

from math import sqrt 

import time

twi = time.time()
n = 100
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
#prime_set = {2}
my_prime_list = [2]    # initialize a list to store primes


#final_set = setQ.difference(prime_set)
#answer += len(prime_set)
#h = 3;


p = 0
while (p+4) <= n:
    p += 4 
    unionSet.add(p)        

unionSet = unionSet.difference(initialSet)      
     
for i in unionSet:
    m = i
    multi_sum = 1
    while(m >= 4):
        if sqrt(m) % 1 == 0:
            multi_sum = m
            break;
        if m / 4 % 1 == 0:
            m /= 4
            multi_sum *= 4
        if m / 4 % 1 != 0:
            break
                                
    answer += multi_sum 
    print(i, multi_sum, answer)


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
            h = q*q
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
                x = 0
                m = i
                multi_sum = 1
                while(m >= 4):
                    if sqrt(m) % 1 == 0:
                        multi_sum = m
                        break;
                    if (m / w) % 1 == 0:
                        m /= w
                        multi_sum *= w
                    
                    if m / w % 1 != 0:
                        break
                                
                answer += multi_sum
                print(i, multi_sum,answer)
            
            #prime_set.add(q)
            break
            
    k = 0    # reset index
        
count += len(unionSet)
answer += (n-count)   

print(answer%1000000007);    

twf = time.time()
print('time took!:', twf-twi)