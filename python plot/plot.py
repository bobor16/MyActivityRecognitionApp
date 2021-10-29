import pandas as pd
import matplotlib.pyplot as plt

read_file = pd.read_csv(r'log.txt')
read_file.to_csv(r'log.csv', index=None)

base_df = pd.read_csv("log.csv", names=['activity', 'dur'])

print(base_df)

log = pd.DataFrame(base_df)

x = base_df["activity"]
y = base_df["dur"]

fig, ax = plt.subplots()

ax.plot(x, y, color='aqua')

ax.set(xlabel='Activity', ylabel='Duration',
       title='Raw')
# ax.grid()

plt.show()
