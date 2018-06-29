import heapq

q = []

heapq.heappush(q, (2, 'B'))
heapq.heappush(q, (1, 'A'))
heapq.heappush(q, (3, 'C'))

while q:
    item = heapq.heappop(q)
    print(item)
