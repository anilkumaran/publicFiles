
class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None


class MyBinarySearchTree:
    def __init__(self):
        self.root = None
    
    def append(self, val):
        if self.root is None: self.root = Node(val)
        else:
            temp_node = self.root
            while temp_node.left or temp_node.right:
                if val < temp_node.val: temp_node = temp_node.left
                elif val > temp_node.val: temp_node = temp_node.right
                else: raise ValueError("Value already exists in the tree")
            if val < temp_node.val: temp_node.left = Node(val)
            else: temp_node.right = Node(val)

    def pre_order(self):
        ''' Root -> Left -> Right '''
        temp_node = self.root
        while temp_node.left or temp_node.right:
            print("")

bt = MyBinarySearchTree()
bt.append(10)
bt.append(20)
bt.append(30)