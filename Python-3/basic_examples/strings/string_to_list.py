s = ' abc$ # 321 '

print(f'List of Characters ={list(s)}')
print(f'List of Characters without leading and trailing whitespaces ={list(s.strip())}')


s = '  Welcome To JournalDev  '
print(f'List of Words ={s.split()}')

s = 'Apple,Mango,Banana'
print(f'List of Items in CSV ={s.split(",")}')

