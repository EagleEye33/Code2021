# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""
import math
n = 13;
a = 41;
primeList = [2,3,5,7,11,13];
while(n < 1999999):
    n += 2;
    m = int(math.sqrt(n // 1));
    for i in primeList[:]:
        if i > m:
            primeList.append(n);
            a += n;
            break;
        elif n % i == 0:
            break;
print(a);      