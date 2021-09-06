from collections import deque
def transfer(S, T = []):
    while len(S) != 0:
        T.append(S.pop())
    return T

#
# S = [1,2,3]
# print(transfer(S))

def rec_remove(S):
    if len(S) == 0:
        return S
    S.pop()
    rec_remove(S)

# print(rec_remove(S))

def rev_transfer(S, T = deque()):
    while len(S) != 0:
        T.append(S.pop())
    while len(T) != 0:
        S.append(T.popleft())
    return S


S = [1,2,3]
print(rev_transfer(S))