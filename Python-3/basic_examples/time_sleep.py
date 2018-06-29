import time
from threading import Thread


class Worker(Thread):
    def run(self):
        for x in range(0, 11):
            print(x)
            time.sleep(1)


class Waiter(Thread):
    def run(self):
        for x in range(100, 103):
            print(x)
            time.sleep(5)


print("Staring Worker Thread")
Worker().start()
print("Starting Waiter Thread")
Waiter().start()
print("Done")
