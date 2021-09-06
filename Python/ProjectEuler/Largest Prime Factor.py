pList = []; n = 2; m = 600851475143; j = 0;

while(m / n != 1):
    if m % n == 0:
        pList.append(n)
        m /= n
        n = 2
    else:
        j = 0
        while(j == 0):
            n += 1
            j = 1
            for i in range(2,n):
                if n % i == 0:
                    j = 0;

pList.append(n);

print(pList);