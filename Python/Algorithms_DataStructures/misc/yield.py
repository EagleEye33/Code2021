def factors(n): # generator that computes factors
    for k in range(1, n+1):
        if n % k == 0: # divides evenly, thus k is a factor
            yield k

for factor in factors(100):
    print(factor)

def factors(n): # traditional function that computes factors
    results = [ ] # store factors in a new list
    for k in range(1,n+1):
        if n % k == 0: # divides evenly, thus k is a factor
            results.append(k) # add k to the list of factors
    return results

print(factors(100))

def fibonacci():
    a=0
    b=1
    while True: # keep going...
        yield a # report value, a, during this pass
        future = a + b
        a=b # this will be next value reported
        b = future # and subsequently this

for fib in fibonacci():
    print(fib)