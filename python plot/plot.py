
import matplotlib.pyplot as plt

x = []
y = []
for line in open('log.txt', 'r'):
    lines = [i for i in line.split('\t')]
    x.append(lines[0])
    y.append(int(lines[1]))

print(line)

plt.title("Students Marks")
plt.xlabel('Roll Number')
plt.ylabel('Marks')
plt.yticks(y)
plt.plot(x, y, marker='o', c='g')

plt.show()
