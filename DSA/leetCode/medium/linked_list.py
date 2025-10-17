class Node:
    def __init__(self, val):
        self.val = val
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None
        self.tail = None

    def append(self, val):
        if self.head is None:
            self.head = Node(val)
            self.tail = self.head
        else:
            self.tail.next = Node(val)
            self.tail = self.tail.next
    
    def prepend(self, val):
        new_node = Node(val)
        new_node.next = self.head
        self.head = new_node
        if self.tail is None:
            self.tail = new_node

    def print_ll(self):
        temp_node = self.head
        while temp_node.next is not None:
            print(f"l: {temp_node.val}")
            temp_node = temp_node.next
        print(f"l: {temp_node.val}")

    def reverse(self):
        l = []
        temp_node = self.head
        while temp_node is not None:
            l.append(temp_node.val)
            temp_node = temp_node.next
        l.reverse()
        print(f"Reversed list: {l}")


ll = LinkedList()
ll.append(10)
ll.append(20)
ll.append(30)
ll.append(40)
ll.print_ll()
ll.reverse()