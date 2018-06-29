import subprocess

process = subprocess.Popen(['ls', '-ltr'], stdout=subprocess.PIPE, stderr=subprocess.PIPE)

print(process.communicate())

process = subprocess.Popen(['echo', 'Pankaj'], stdout=subprocess.PIPE, stderr=subprocess.PIPE, stdin=None)

print(process.communicate())

process = subprocess.Popen(['ping', '-c 1', 'journaldev.com'], stdout=subprocess.PIPE)

print(process.communicate())
