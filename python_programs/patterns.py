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
