# importing only the Queue from the queue module
from queue import Queue

# taking an object of Queue()
q = Queue()
print("Initially the size of queue is %s" % q.qsize())
print("Checking whether queue is empty or not. Empty?? = %s" % q.empty())

# enqueueing some value in the object of Queue
q.put('A')
q.put('B')
q.put('C')
q.put('D')
q.put('E')

print("After adding some value, size of queue is %s" % q.qsize())
print("Checking whether queue is full or not. Full?? = %s" % q.full())

# retrieving the values of the Queue
for i in range(q.qsize()):
    print("Retrieved = ", end=' ')
    print(q.get())

# after retrieving, check the size of the object
print("Size of queue is = %s " % q.qsize())
