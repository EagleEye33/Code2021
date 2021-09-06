n = 1; m = 1; j = 0;

while(m<4000000):
    if m % 2 == 0:
        j += m
    m = n + m
    n = m - n;

print(j);

