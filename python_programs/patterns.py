rows = 5

for i in range(rows):
    # spaces
    for j in range(rows-i-1):
        # Change the first and last empty strings to spaces to get different patterns
        print(" ", end = "")
    # stars
    print("*"*(2*i+1))

# For Rhombus or Diamond
for row in range(rows-1, 0, -1):
    # spaces
    print(""*(rows-row), end="")
    # stars
    print("*"*(2*row-1))
