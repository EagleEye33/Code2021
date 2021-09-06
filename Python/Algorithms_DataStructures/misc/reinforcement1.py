import math
import random

def is_multiple(n, m):
    return bool(m % n == 0)

print(is_multiple(10, 1))
print()

invalue = int(input("Enter a value to check > "))

print("%d is Even!\n" % invalue if math.pow(-1, invalue) == 1 else "%d is not even.\n" % invalue)

def minmax():
    data = [int(x) for x in input("enter some numbers: ").split()]
    max, min = data[0], data[0]
    for i in range(len(data)):
        if data[i] > max:
            max = data[i]
        if data[i] < min:
            min = data[i]
    return print("the max is %d" % max, "and the min is %d " % min)

minmax()

def summation1(n):
    result = 0
    for i in range(n):
        result += i*i
    return result

print(summation1(int(input("enter integer: "))))

intN = int(input("input integer: "))
print("the sum of squares is ", sum([i*i for i in range(intN)]))

def Oddsummation1(n):
    result = 0
    for i in range(1, n, 2):
        result += i*i
    return result

print(Oddsummation1(int(input("enter integer: "))))

Oddint = int(input("input integer: "))
print("the sum of ODD squares is ", sum([i*i for i in range(1, Oddint, 2)]))

for i in range(50, 81, 10):
    print(i)

for i in range(8, -9, -2):
    print(i)

int3 = int(input("enter int: "))
print([math.pow(2, i) for i in range(int3) if math.pow(2, i) <= int3])


def choice():
    input10 = int(input("enter an int: "))
    return random.randrange(input10, input10+10)

print(choice())
