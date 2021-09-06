# -*- coding: utf-8 -*-
"""
Created on Tue Aug 24 19:45:36 2021

@author: wyatt
"""
import math

def S(N):
    sqrtN = int(math.sqrt(N))
    a = [0] + [1]*sqrtN
    for i in range(sqrtN,0,-1):
        a[i] = math.floor(N/(i*i)) - sum([a[i*j] for j in range(2,math.floor(sqrtN/i) + 1)])
    total = (sum([i*i*a[i] for i in range(len(a))]))
    return total % 1000000007

print(S(1E14))