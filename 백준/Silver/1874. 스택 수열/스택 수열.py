n = int(input())
inputArr = []
stack = []
op = []
cnt = 1
isBreak = False
for i in range(n):
    num = int(input())
    while(cnt <= num):
        op.append('+')
        stack.append(cnt)
        cnt += 1
    if num == stack[-1]:
        op.append('-')
        stack.pop()
    else:
        isBreak = True
        break
if isBreak:
    print("NO")
else:
    for i in op:
        print(i)