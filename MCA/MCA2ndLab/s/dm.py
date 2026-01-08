# 9.write a program to read an excel sheet an d replace nan values with median in KM.
import pandas as pd
df=pd.read_excel("income.xlsx",sheet_name='Sheet1',\
index_col=0,na_values=["????","??"])
print("km values before replacing with median : ")
print(df.head(10))
df['KM'].fillna(df['KM'].median(),inplace=True)
print("km values after replacing with median : ")
print(df.head(10))
'''

OUTPUT:
km values before replacing with median :
Price Age KM FuelType ... Automatic CC Doors Weight

0 13500 NaN 46986.0 Diesel ... 0 2000 3 1165
1 13750 23.0 72937.0 NaN ... 0 2000 3 1165
2 13950 NaN NaN NaN ... 0 2000 3 1165
3 14950 26.0 NaN NaN ... 0 2000 3 1165
4 13750 NaN NaN Diesel ... 0 2000 3 1170
5 12950 32.0 61000.0 NaN ... 0 2000 3 1170
6 16900 27.0 NaN Diesel ... 0 2000 3 1245
7 18600 NaN 75889.0 NaN ... 0 2000 3 1245
8 21500 27.0 19700.0 Petrol ... 0 1800 3 1185
9 12950 23.0 71138.0 Diesel ... 0 1900 3 1105

[10 rows x 10 columns]
km values after replacing with median :
Price Age KM FuelType ... Automatic CC Doors Weight
0 13500 NaN 46986.0 Diesel ... 0 2000 3 1165
1 13750 23.0 72937.0 NaN ... 0 2000 3 1165
2 13950 NaN 36860.5 NaN ... 0 2000 3 1165
3 14950 26.0 36860.5 NaN ... 0 2000 3 1165
4 13750 NaN 36860.5 Diesel ... 0 2000 3 1170
5 12950 32.0 61000.0 NaN ... 0 2000 3 1170
6 16900 27.0 36860.5 Diesel ... 0 2000 3 1245
7 18600 NaN 75889.0 NaN ... 0 2000 3 1245
8 21500 27.0 19700.0 Petrol ... 0 1800 3 1185
9 12950 23.0 71138.0 Diesel ... 0 1900 3 1105
'''


# 24. write a program to demonstrate attribute subset - stepforward selection .
import pandas as pd
import numpy as np
import random

df=pd.read_excel("income2.xlsx",na_values=["????","??"],sheet_name="Sheet1",index_col=0)
df.dropna(axis=0,inplace=True)
s=df.columns
ss=list()
for i in s:
    ss.append(i)
    print(df[ss].head(2))
    print()
'''
OUTPUT:
Price
0 13500
1 13750

Price Age
0 13500 23.0
1 13750 23.0

Price Age KM
0 13500 23.0 46986.0
1 13750 23.0 72937.0

Price Age KM HP
0 13500 23.0 46986.0 90.0
1 13750 23.0 72937.0 90.0

Price Age KM HP MetColor
0 13500 23.0 46986.0 90.0 1.0
1 13750 23.0 72937.0 90.0 1.0

Price Age KM HP MetColor Automatic
0 13500 23.0 46986.0 90.0 1.0 0
1 13750 23.0 72937.0 90.0 1.0 0

Price Age KM HP MetColor Automatic CC
0 13500 23.0 46986.0 90.0 1.0 0 2000
1 13750 23.0 72937.0 90.0 1.0 0 2000

Price Age KM HP MetColor Automatic CC Doors
0 13500 23.0 46986.0 90.0 1.0 0 2000 3
1 13750 23.0 72937.0 90.0 1.0 0 2000 3

Price Age KM HP MetColor Automatic CC Doors Weight
0 13500 23.0 46986.0 90.0 1.0 0 2000 3 1165
1 13750 23.0 72937.0 90.0 1.0 0 2000 3 1165


'''
# 27. write a program to demonstrate simple random Sampling.
import pandas as pd
import numpy as np
import random

df=pd.read_excel("income1.xlsx",na_values=["????","??"],sheet_name="Sheet1",index_col=0)
df.dropna(axis=0,inplace=True)
n=int(input('enter no. rows u need and it should be < %i : '%len(df)))
l1=list(df.index.values)
s=random.sample(l1,n)
s.sort()
result = df.loc[s]
print(result)

'''
OUTPUT:
enter no. rows u need and it should be < 76 : 4
Price Age KM FuelType ... Automatic CC Doors Weight
14 22500 32.0 34131.0 Petrol ... 0 1800 3 1185
76 18750 31.0 25266.0 Petrol ... 0 1600 5 1130
95 19950 17.0 30351.0 Diesel ... 0 1995 3 1260
97 15950 19.0 25948.0 Petrol ... 0 1400 3 1100
'''



32.Write a program to implement Decision tree.

import pandas as pd
import numpy as np
from sklearn import tree
from sklearn.preprocessing import LabelEncoder
from sklearn.tree import DecisionTreeClassifier

df=pd.read_excel("DecisionTree.xlsx",na_values=["????","??"],sheet_name="Sheet1")
x=df.iloc[:,:-1]
y=df.iloc[:,5]
#converting to numeric data
labelencoder_x=LabelEncoder()
x=x.apply(LabelEncoder().fit_transform)
regressor=DecisionTreeClassifier()
regressor.fit(x.iloc[:,1:5],y)
m=[]

m.append(int(input(("choose one of '0,1,2' where 'age' is '21-35,<21,>35' : "))))
m.append(int(input(("choose one of '0,1,2' where 'income' is 'High,Low,Medim' : "))))
m.append(int(input(("choose one of '0,1' where 'gender' is 'Female,Male' : "))))
m.append(int(input(("choose one of '0,1' where 'maritalStatus' is 'Married,Single' : "))))
x_in=np.array(m)
y_pred=regressor.predict([x_in])
print("The buying chance for above details is : ",y_pred)
'''
OUTPUT:
choose one of '0,1,2' where 'age' is '21-35,<21,>35' : 1
choose one of '0,1,2' where 'income' is 'High,Low,Medim' : 1
choose one of '0,1' where 'gender' is 'Female,Male' : 0
choose one of '0,1' where 'maritalStatus' is 'Married,Single' : 0
The buying chance for above details is : ['Yes']
'''
