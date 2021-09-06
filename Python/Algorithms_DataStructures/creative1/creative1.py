import math
def Oddproduct(data):
    temp1 = temp2 = counter = 0
    for i in range(len(data)):
        if data[i] % 2 == 1:
            if counter < 1:
                temp1 = data[i]
            else:
                temp2 = data[i]
            counter += 1
        if counter == 2:
            return temp1, temp2

input1 = [int(x) for x in input("enter some ints: ").split()]

print(Oddproduct(input1))

def distinctList(data):
    data.sort()
    for i in range(len(data) - 1):
        if data[i] == data[i+1]:
            return bool(0)
    return bool(1)


input1 = [int(x) for x in input("enter some ints: ").split()]

print("That list is distinct: ", distinctList(input1))

def scale(data, factor):
    for j in range(len(data)):
        data[j] *= factor
    return data

input1 = [int(x) for x in input("enter some ints: ").split()]
print(scale(input1, 3))

def scale(data, factor):
    i = 0
    list1 = [1, 2, 3]
    for val in data:
        val *= factor
        list1[i] = val
        i += 1
    return list1

input1 = [int(x) for x in input("enter some ints: ").split()]
print(scale(input1, 3))

print([k*(k+1) for k in range(0, 10)])

print([chr(i) for i in range(ord('a'), ord('z')+1)])

def dotproduct(data1, data2):
    for i in range(len(data1)):
        data1[i] *= data2[i]
    return data1

input1 = [int(x) for x in input("enter array 1: ").split()]
input2 = [int(x) for x in input("enter array 2: ").split()]

print(dotproduct(input1, input2))

def numOfValues(data):
    counter = 0
    for i in data:
        if i == 'a' or i == 'e' or i == 'i' or i == 'o' or i == 'u':
            counter += 1
    return counter

input1 = input("enter a string: ")
print(numOfValues(input1))

def makeChange(total, actual):
    oh = ten = five = one = q = d = n = p = 0.0

    result = total - actual
    oh, result = divmod(result, 100)
    ten, result = divmod(result, 10)
    five, result = divmod(result, 5)
    one, result = divmod(result, 1)
    q, result = divmod(result, 0.25)
    d, result = divmod(result, .1)
    n, result = divmod(result, 0.05)
    p = result
    result = 100 * oh + 10 * ten + 5 * five + one + .25 * q + .1 * d + .05 * n + p
    result = round(result, 2)
    return result


x, y = float(input("enter amount you paid: ")), float(input("enter amount owed: "))
print(makeChange(x, y))

