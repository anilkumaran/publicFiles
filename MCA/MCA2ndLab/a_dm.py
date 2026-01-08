# 8 write a program to read an excel sheet and replace nan values with mean in age.

import pandas as pd

df = pd.read_excel('employees.xlsx')

mean_age = df['Age'].mean()
df['Age'] = df['Age'].fillna(mean_age)

df.to_excel('employees_cleaned.xlsx', index=False)

print("Original Data with NaN:")
print(pd.read_excel('employees.xlsx'))
print("\nCleaned Data:")
print(df)

'''
Output

Original Data with NaN:
    ID     Name   Age
0  101    Alice  25.0
1  102      Bob   NaN
2  103  Charlie  35.0

Cleaned Data:
    ID     Name   Age
0  101    Alice  25.0
1  102      Bob  30.0
2  103  Charlie  35.0
'''



# 28. write a program to demonstrate simple random sampling with replacement.
import pandas as pd

# Creating a sample DataFrame
data = {
    'Car': ['Car A', 'Car B', 'Car C', 'Car D', 'Car E'],
    'FuelType': ['Diesel', 'Petrol', 'Diesel', 'CNG', 'Diesel']
}
df = pd.DataFrame(data)

# Replace 'Diesel' with 'petrol' in the 'FuelType' column
df['FuelType'] = df['FuelType'].replace('Diesel', 'petrol')

print("Original Data (Simulated):")
print(pd.DataFrame(data)) # Printing original for comparison
print("\nUpdated Data:")
print(df)
# OUTPUT:
'''
Original Data (Simulated):
     Car FuelType
0  Car A   Diesel
1  Car B   Petrol
2  Car C   Diesel
3  Car D      CNG
4  Car E   Diesel

Updated Data:
     Car FuelType
0  Car A   petrol
1  Car B   Petrol
2  Car C   petrol
3  Car D      CNG
4  Car E   petrol
'''

# 25. write a program to demonstrate attribute subset – backword elimination.
import pandas as pd
import numpy as np
import random

df=pd.read_excel("income2.xlsx",na_values=["????","??"],sheet_name="Sheet1",index_col=0)
df.dropna(axis=0,inplace=True)
s=df.columns
ss=list(s)
for i in s:
    print(df[ss].head(2))
    ss.pop()
    print()

'''
OUTPUT:

Price Age KM HP MetColor Automatic CC Doors
0 13500 23.0 46986.0 90.0 1.0 0 2000 3
1 13750 23.0 72937.0 90.0 1.0 0 2000 3

Price Age KM HP MetColor Automatic CC
0 13500 23.0 46986.0 90.0 1.0 0 2000
1 13750 23.0 72937.0 90.0 1.0 0 2000

Price Age KM HP MetColor Automatic
0 13500 23.0 46986.0 90.0 1.0 0
1 13750 23.0 72937.0 90.0 1.0 0

Price Age KM HP MetColor
0 13500 23.0 46986.0 90.0 1.0
1 13750 23.0 72937.0 90.0 1.0

Price Age KM HP
0 13500 23.0 46986.0 90.0
1 13750 23.0 72937.0 90.0

Price Age KM
0 13500 23.0 46986.0
1 13750 23.0 72937.0

Price Age
0 13500 23.0
1 13750 23.0

Price
0 13500
1 13750
'''
# 31 write a program to demonstrate FP-Growth construction.
# pip install pandas mlxtend

import pandas as pd
from mlxtend.preprocessing import TransactionEncoder
from mlxtend.frequent_patterns import fpgrowth

dataset = [
    ['Milk', 'Bread', 'Nuts', 'Eggs'],
    ['Milk', 'Bread', 'Nuts'],
    ['Milk', 'Eggs'],
    ['Bread', 'Eggs'],
    ['Milk', 'Bread', 'Eggs', 'Nuts'],
    ['Milk', 'Bread', 'Eggs']
]

te = TransactionEncoder()
te_ary = te.fit(dataset).transform(dataset)
df = pd.DataFrame(te_ary, columns=te.columns_)

frequent_itemsets = fpgrowth(df, min_support=0.5, use_colnames=True)

# 4. Display Results
print("Transaction Data (One-Hot):")
print(df)
print("\nFrequent Itemsets (Min Support 50%):")
print(frequent_itemsets)

'''
OUTPUT
Transaction Data (One-Hot):
   Bread   Eggs   Milk   Nuts
0   True   True   True   True
1   True  False   True   True
2  False   True   True  False
3   True   True  False  False
4   True   True   True   True
5   True   True   True  False

Frequent Itemsets (Min Support 50%):
     support             itemsets
0   0.833333               (Milk)
1   0.833333               (Eggs)
2   0.833333              (Bread)
3   0.500000               (Nuts)
4   0.666667         (Milk, Eggs)
5   0.666667        (Bread, Eggs)
6   0.666667        (Bread, Milk)
7   0.500000  (Bread, Milk, Eggs)
8   0.500000        (Nuts, Bread)
9   0.500000         (Nuts, Milk)
10  0.500000  (Nuts, Bread, Milk)
'''
