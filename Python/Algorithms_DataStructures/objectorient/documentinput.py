import os
def readLines(text):
  counter = 'end of file'
  length = ord('a')
  while length != ord('z') + 1:
    with open(text) as f:
        print(chr(length), ":", end='')
        for c in f.read():
          if c == chr(length):
            print('X', sep=' ', end='', flush=True)
        length += 1
        print()
  return counter

os.chdir(r'C:\Users\wyatt\Downloads')
q = readLines('test.txt')
print(q)

counter = 0
for i in range(1, 10):
    for j in range(i):
        counter += 1

print(counter)
