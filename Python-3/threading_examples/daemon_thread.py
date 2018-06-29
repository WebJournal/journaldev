import threading
import time


def print_work_a():
    print('Starting of thread :', threading.currentThread().name)
    time.sleep(2)
    print('Finishing of thread :', threading.currentThread().name)


def print_work_b():
    print('Starting of thread :', threading.currentThread().name)
    print('Finishing of thread :', threading.currentThread().name)


a = threading.Thread(target=print_work_a, name='Thread-a', daemon=True)
b = threading.Thread(target=print_work_b, name='Thread-b')

b.start()
a.start()
