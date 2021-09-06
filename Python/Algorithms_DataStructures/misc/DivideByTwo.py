import math
input1 = int(input('input an integer greater than 2: '))
result = math.floor(math.log(input1, 2))
print("the number of times you'd have to divide that number by 2 for it to be strictly less than 2 is: ", result)