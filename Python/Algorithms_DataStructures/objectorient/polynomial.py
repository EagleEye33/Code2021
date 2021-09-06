import math
class Polynomial:

    def __init__(self, poly):
        self._poly = poly

    def __len__(self):
        return len(self._poly)

    def Derivative(self):
        result = [0] * (len(self._poly) - 1)
        coef = len(self._poly) -1
        for j in range(len(self) - 1):
            result[j] = self._poly[j] * coef
            coef -= 1
        return result

if __name__ == '__main__':
    pol = Polynomial([3, 2, 1])
    print(pol.Derivative())