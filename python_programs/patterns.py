rows = 5
for i in range(rows):
    # spaces
    for j in range(rows-i-1):
        # Change the first and last empty strings to spaces to get different patterns
        print("", end = "")

    # stars
    print("*"*(2*i+1))
    print()



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
