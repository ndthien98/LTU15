import os
filenames = os.listdir()
i = 1
for f in filenames:
    img = "![img" + str(i) + "](" + f + ")"
    print(img)
    i = i + 1