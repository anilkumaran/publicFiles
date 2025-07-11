class Stack:
    def __init__(self):
        self.stack = []
    isEmpty = lambda self: not bool(self.stack)
    push = lambda self, data: self.stack.append(data)
    pop = lambda self: self.stack.pop()

    def search(self, key):
        for element in self.stack:
            if key == element:
                print(f"Found key {key} at index {self.stack.index(key)}")
                return True, self.stack.index(key)
        return False, None

    def delete(self, key):
        found, index = self.search(key)
        if found:
            del self.stack[index]
            print(f"Deleted key {key} successfully")
        else:
            print("Key not found")
    
    def printStack(self):
        for element in self.stack:
            print(f"{element}", end=" ")
        print()


s = Stack()
s.push(10)
s.push(20)
s.push(30)
s.push(40)

s.printStack()
s.pop()
s.search(10)
s.printStack()
