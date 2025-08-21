# 1. Program to show use of break in loop
numbers = [3, 6, 9, 12, 15, 18]
search_for = 12

for num in numbers:
    print("Checking:", num)
    if num == search_for:
        print("Number found! Breaking the loop.")
        break   # exit the loop immediately

''' OUTPUT
Checking: 3
Checking: 6
Checking: 9
Checking: 12
Number found! Breaking the loop.
'''

print("----------------------------------------------------------------------------------------")
# 2. Program to read and write from a text file

# Writing to a file
with open("example.txt", "w") as file:
    file.write("Hello, this is a test file.\n")
    file.write("This file contains some sample text.\n")    

# reading from a file
with open("example.txt", "r") as file:
    content = file.read()
    print("File content:")
    print(content)


''' OUTPUT
File content:
Hello, this is a test file.
This file contains some sample text.
''' 


print("----------------------------------------------------------------------------------------")
# 3. Program to update the stock item using a dictionary
stock = {
    "Apple": {"quantity": 24, "price": 60},
    "Banana": {"quantity": 12, "price": 70},
    "Orange": {"quantity": 10, "price": 80}
}
print("Stock before update:", stock)
def update_stock(item_name, quantity):
    if item_name in stock:
        stock[item_name]["quantity"] += quantity
        print(f"Updated {item_name} stock to {stock[item_name]['quantity']}.")
    else:
        print("Item not found in stock.")

# Example usage
update_stock("Apple", 20)
print("Stock after update:", stock)


''' OUTPUT
Stock before update: {'Apple': {'quantity': 24, 'price': 60}, 'Banana': {'quantity': 12, 'price': 70}, 'Orange': {'quantity': 10, 'price': 80}}
Updated Apple stock to 44.
Stock after update: {'Apple': {'quantity': 44, 'price': 60}, 'Banana': {'quantity': 12, 'price': 70}, 'Orange': {'quantity': 10, 'price': 80}}
'''

print("----------------------------------------------------------------------------------------")
# 4. Program to read csv and show summary
import pandas as pd

# Example usage
roll_no = int(input("Enter roll number to search: "))
# Read CSV into a DataFrame
df = pd.read_csv("students.csv")

# Filter for the given roll_no
student = df[df["roll_no"] == roll_no]

if student.empty:
    print(f"No student found with roll number {roll_no}")
    exit()

# Extract row (iloc[0] because result is a DataFrame with one row)
row = student.iloc[0]

# Calculate total, average, result
total = row["math"] + row["science"] + row["english"]
average = total / 3
result = "Pass" if average >= 40 else "Fail"

# Print summary
print("---- Student Summary ----")
print(f"Roll No : {row['roll_no']}")
print(f"Name    : {row['name']}")
print(f"Math    : {row['math']}")
print(f"Science : {row['science']}")
print(f"English : {row['english']}")
print(f"Total   : {total}")
print(f"Average : {average:.2f}")
print(f"Result  : {result}")


## output
'''
Enter roll number to search: 101
---- Student Summary ----
Roll No : 101
Name    : Krishna
Math    : 85
Science : 90
English : 88
Total   : 263
Average : 87.67
Result  : Pass
'''
