## * Pattens
rows = 5
for i in range(rows):
    for j in range(rows-i-1):
        print(" ", end = "")
    print("*"*(2*i+1))

#For Rhombus or Diamond
for m in range(rows):
    for n in range(m+1):
        print(" ", end = " ")
    print("*"*(2*(rows-1-m)-1))



# Update spaces in print("", end = "") to get different shapes
'''
print("", end = "")
*
***
*****
*******
*********

print(" ", end = "")
    *
   ***
  *****
 *******
*********

print(" ", end = " ")
        *
      ***
    *****
  *******
*********
'''

'''
# Diamind
print("", end = "")
*
***
*****
*******
*********
*******
*****
***
*


print(" ", end = "")
    *
   ***
  *****
 *******
*********
 *******
  *****
   ***
    *
    
print(" ", end = " ")
        *
      ***
    *****
  *******
*********
  *******
    *****
      ***
        *
'''




## Number patterns

rows = 5
'''
  1
 234
56789
'''

nums = list(range(1,pow(rows,2)+1))
num_of_items = list(range(1, 2*rows, 2))
for i in range(rows):
    # spaces
    for j in range(rows-i-1):
        print(" ", end="")
    # numbers
    for k in range(num_of_items[i]):
        print(f"{nums.pop(0)} ", end="")
    print()



