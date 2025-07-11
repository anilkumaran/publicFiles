

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None
        self.tail = None

    def append(self, data):
        new_node = Node(data)
        if self.head is None:
            self.head = new_node
        else:
            self.tail.next = new_node
        self.tail = new_node

    def prepend(self, data):
        new_node = Node(data)
        new_node.next = self.head
        self.head = new_node

    def insert_at(self, position, data):
        if not self.head:
            self.head = Node(data)
            print(f"Inserted {data} at position {position}.")
            return

        # Insert at head
        new_node = Node(data)
        if position == 0:
            new_node.next = self.head
            self.head = new_node
            print(f"Inserted {data} at position {position}.")
            return 

        current_node = prev_node = self.head
        current_index = 0
        print(f"Inserting {data} at position {position}")
        while current_node:
            print(f"Current node: {current_node.data}, index: {current_index}")
            if current_index == position-1:
                prev_node.next = new_node
                new_node.next = current_node
                print(f"Inserted {data} at position {position}.")
                break
            prev_node = current_node
            current_node = current_node.next
            current_index += 1
        return

    def search(self, key):
        ''' Returns KeyFound, prev_node, next_node '''
        if self.head is None:
            print("Key not found. The linked list is empty.")
            return False, None, None
        if key == self.head.data:
            print(f"Key {key} found at the head")
            return True, None, self.head.next

        current_node = prev_node = self.head
        current_index = 0
        while current_node:
            if current_node.data == key:
                if current_node.data == self.tail.data:
                    print(f"Key {key} found at the tail at index {current_index}.")
                else:
                    print(f"Key {key} found between {prev_node.data} and {current_node.next.data} at index {current_index}.")
                return True, prev_node, current_node
            else:
                prev_node = current_node
                current_node = current_node.next
            current_index += 1
        print(f"Key {key} not found.")
        return False, None, None

    def delete(self, key):
        if self.head is None:
            print("Key not found. The linked list is empty.")
            return
        key_found, prev_node, current_node = self.search(key)
        if key_found:
            next_node = current_node.next
            prev_node.next = next_node
            current_node = None
            print(f"Key {key} deleted successfully.")
            return

    def print_linked_list(self):
        current_node = self.head
        if current_node is None:
            print("The linked list is empty.")
            return
        while current_node:
            print(current_node.data, end=" -> ")
            current_node = current_node.next
        print("None")
        return
    
    '''
    0   1   2
    8   9   5

    
    curr
    1
    9

    rr
    t
    0
    8

    '''
    def reverse_in_place_using_array(self):
        # self.print_linked_list()
        if self.head is None:
            print(f"Linked list is empty.")
            return
        reversed_ll = LinkedList()
        current_node = self.head
        data_l = []
        while current_node:
            data_l.append(current_node.data)
            current_node = current_node.next
        data_l.reverse()
        print(f"data_l: {data_l}")
        for element in data_l:
            reversed_ll.append(element)
        print("Reversed successfully")
        return reversed_ll
       
    def reverse_in_place(self):
        if self.head is None:
            print(f"Linked list is empty.")
            return
        reversed_ll = LinkedList()
        current_node = self.head
        while current_node:
            reversed_ll.prepend(current_node.data)
            current_node = current_node.next
        print("Reversed successfully")
        return reversed_ll
    
ll = LinkedList()
ll.append(2)
# ll.prepend(15)
ll.append(5)
ll.append(7)
# ll.prepend(10)

ll.print_linked_list()
# ll.search(7)
# # ll.print_linked_list()
# ll.delete(7)
# ll.print_linked_list()
# ll.insert_at(3, 88)

# ll = ll.reverse_in_place()
# ll.print_linked_list()
print(ll.head.data)
print(ll.head.next.data)
print(ll.tail.data)
print(ll.tail.next)
