def str_append(s, n):
    output = ''
    i = 0
    while i < n:
        output += s
        i = i + 1
    return output


def str_append_list_join(s, n):
    l1 = []
    i = 0
    while i < n:
        l1.append(s)
        i += 1
    return ''.join(l1)


if __name__ == "__main__":
    print('Append using + operator:', str_append('Hi', 10))
    print('Append using list and join():', str_append_list_join('Hi', 10))
    # use below for this case, above methods are created so that we can
    # check performance using timeit module
    print('Append using * operator:', 'Hi' * 10)
