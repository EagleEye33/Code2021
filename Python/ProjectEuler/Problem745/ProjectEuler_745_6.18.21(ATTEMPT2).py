# -*- coding: utf-8 -*-
"""
Created on Sat Jun 19 05:25:49 2021

@author: wyatt
"""

import math

import time

twi = time.time()

q = 1;
n = 1000000;
answer = 1
squareList = [];
squareDictionary = {};

for i in range (1,(int(math.sqrt(n) // 1))):
    squareList.append(i*i);
squareList.append(int(math.sqrt(n) // 1) ** 2);


for i in range (1, len(squareList) + 1):
    squareDictionary[i] = squareList[i-1];
    
for i in range(n,1,-1):
    if math.sqrt(i) % 1 == 0:
        answer += i;
        continue;
    m = i
    j = 2
    multi_sum = 1
    while m >= 4:
        if m / squareDictionary[j] % 1 == 0:
            multi_sum *= squareDictionary[j]
            m /= squareDictionary[j]
            j = 2
        elif int(m // squareDictionary[j]) < 2:
            break;
        else:
            j += 1
                            
    answer += multi_sum
            
twf = time.time()

print(answer);
print('time took:', twf-twi);