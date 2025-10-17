
class MyStatistics:
    def factorial(self, n):
        if n == 0 or n == 1:
            return 1
        return n * self.factorial(n - 1)

    def nPr(self, n, r):
        return self.factorial(n) // self.factorial(n - r)

    def nCr(self, n, r):
        return self.factorial(n) // (self.factorial(r) * self.factorial(n - r))

    def generate_permutation(self, arr):
        if len(arr) == 0: return [[]]
        if len(arr) == 1: return [arr]
        for e in arr: pass



s = MyStatistics()
items = [1]
print(s.generate_permutation(items))
