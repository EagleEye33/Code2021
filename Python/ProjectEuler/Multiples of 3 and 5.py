j=0; m=0; n=1;

while(n<1000):
    if n % 3 == 0 or n % 5 ==0:
        m = n
        j += m
    n+=1;

print(j);
