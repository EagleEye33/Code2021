# -*- coding: utf-8 -*-
"""
Created on Thu May 27 14:01:49 2021

@author: morga
"""
import time

twi = time.time()
m = 1000
pListF = []


while(m > 99):
    m -= 1
    n = 999
    while(n > 99):
        j = m*n
        n -= 1
        t = list(map(int, str(j)))
        Plist = [0] * len(t) 
        for i in range(1, len(t) + 1):
            Plist[i-1] = t[len(t) - i]
        if Plist == t:
            pListF.append(j)
            break
 
print(max(pListF))
twf = time.time()

print('Wyatt time:', twf-twi)

tmi = time.time()
def isPal(x):
    l1 = x.copy()
    l1.reverse()
    if(l1 == x):
        return 1
    else:
        return 0
    
pals = []
for m in reversed(range(1000)):
    for n in reversed(range(1000)):
        j = m*n
        t = list(map(int,str(j)))
        if isPal(t) == 1:
            pals.append(j)
            break
    pal = max(pals)
    
print('The Palindrome is: ', pal)
tmf = time.time()

print('Morgan time:', tmf-tmi)