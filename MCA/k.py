import matplotlib.pyplot as plt

marks = [85, 90, 88]
subjects = ['Math', 'Science', 'English']

# plt.pie(marks, labels=subjects, autopct='%1.1f%%', startangle=90)
plt.pie(marks, labels=subjects, autopct='%1.1f%%', colors=['#ff9999','#66b3ff','#99ff99'])
plt.title("Marks Distribution of a Student")
plt.show()
