# -*- coding: utf-8 -*-
"""
Created on Tue Jun 15 02:32:39 2021

@author: wyatt
"""
import math

import time

twi = time.time()

q = 1;
n = 1000000;
answer = 0

squareDictionary = {};

for i in range (1,(int(math.sqrt(n/2) // 1)) + 1):
    squareDictionary[i] = i*i
    
for i in range(n,0,-1):
    if math.sqrt(i) % 1 == 0:
        answer += i;
        continue;
    m = int(math.sqrt(i // 2));
    for j in range(m,0,-1):  
        if i % squareDictionary[j] == 0:
            answer += squareDictionary[j];
            #if squareDictionary[j] == 1:
                #q += 1;
            break;
            
twf = time.time()

print(answer);
print('time took:', twf-twi);
#print(max(squareList));