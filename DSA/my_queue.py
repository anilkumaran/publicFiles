class Queue:
    def __init__(self):
        self.q = []

    isEmpty = lambda self: not bool(self.q)
    peek = lambda self: print([]) if self.isEmpty() else print(self.q[0])
    enQueue = lambda self, data: self.q.append(data)
    def deQueue(self):
        first_element = self.q[0]
        del self.q[0]
        print(f"DeQueued {first_element}")

    def search(self, key):
        for element in self.q:
            if key == element:
                print(f"Found key {key} at index {self.q.index(key)}")
                return True, self.q.index(key)
        return False, None

    def delete(self, key):
        found, index = self.search(key)
        if found:
            del self.q[index]
            print(f"Deleted key {key} successfully")
        else:
            print("Key not found")

    def printQueue(self):
        for element in self.q:
            print(f"{element}", end=" ")
        print()

q = Queue()
q.enQueue(2)
q.enQueue(5)
q.enQueue(7)

q.printQueue()
q.delete(5)
q.printQueue()

# q.search(5)