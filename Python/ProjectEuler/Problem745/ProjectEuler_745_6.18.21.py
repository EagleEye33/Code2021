# -*- coding: utf-8 -*-
"""
Created on Thu Jun 17 17:42:53 2021

@author: morga
"""

from math import sqrt 

Num1Counter = 0;
n = 10000
PerfectSquareDict = {};
i = 1;
answer = 0;

numStore = 0;

while(i*i <= n):
    PerfectSquareDict[i] = i*i;
    i += 1;

for x in range(int(((sqrt(n/2) + 1)) // 1), int(sqrt(n)) + 1):
    answer += PerfectSquareDict[x];
    Num1Counter += 1;
    
for x in range(int(((sqrt(n/3) + 1)) // 1), int(((sqrt(n/2) +1 )) // 1)):
    answer = answer + 2 * PerfectSquareDict[x];
    Num1Counter += 2;
    
for x in range(int(((sqrt(n/4) + 1)) // 1), int(((sqrt(n/3) + 1)) // 1)):
    answer = answer + 3 * PerfectSquareDict[x];
    Num1Counter += 3;
    
Perfect_square_prime_dict = {};

my_prime_list = [2]    # initialize a list to store primes
k = 0    # keeps track of loop iterations
for q in range(3, int(((sqrt(n/4) + 1)// 1))): # numbers to be tested for divisibility    
    
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
    
for i in my_prime_list:
    Perfect_square_prime_dict[i] = i*i;
    
num4 = 0;

for x in reversed(range(2, int(((sqrt(n/4) + 1)) // 1))):
     numStore1 = n // PerfectSquareDict[x];
     for q in Perfect_square_prime_dict:
         if PerfectSquareDict[x] * Perfect_square_prime_dict[q] <= n:
             Collapse = n // (Perfect_square_prime_dict[q] * PerfectSquareDict[x]);
             numStore1 -= Collapse;
             for i in Perfect_square_prime_dict:
                 overlap_Count = Collapse // Perfect_square_prime_dict[i]
                 if overlap_Count < 1 or i == q:
                     break;
                 else:
                     numStore1 += overlap_Count;
         else:
             break;
     if PerfectSquareDict[x] == 4:
         num4 = numStore1;
     answer += PerfectSquareDict[x] * numStore1;
     Num1Counter += numStore1 
     
answer = answer + (n - Num1Counter);

print(n - Num1Counter);
print(answer%1000000007);
print(num4);
     
# 813210021
# 406886821

#6079
#722609