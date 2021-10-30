import pandas as pd
import matplotlib.pyplot as plt

read_file = pd.read_csv(r'log/log.txt')
read_file.to_csv(r'log/log.csv', index=None)

base_df = pd.read_csv("log.csv", names=['activity', 'dur'])

print(base_df)

log = pd.DataFrame(base_df)

y = base_df["activity"]
x = base_df["dur"]

fig, ax = plt.subplots()

ax.plot(x, y, color='blue')

ax.set(xlabel='Duration', ylabel='Activity',
       title='Activity Tracker')
# ax.grid()

fig.savefig("python plot/img/activity.png")

plt.show()
