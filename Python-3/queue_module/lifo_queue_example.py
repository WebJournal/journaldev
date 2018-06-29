import queue

q = queue.LifoQueue()

q.put('A')
q.put('B')
q.put('C')

for i in range(q.qsize()):
    print(q.get())