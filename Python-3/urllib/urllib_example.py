import urllib.request
import urllib.parse

# Simple GET Call
data = urllib.request.urlopen('https://www.wikipedia.org')
# Print response byte array
#print(data.read())

# Making REST web service call
rest = urllib.request.urlopen('http://localhost:3000/employees')
print(rest.read())


# Request with Header Data to send User-Agent header
url = 'https://www.journaldev.com'

headers = {}
headers['User-Agent'] = 'Mozilla/5.0 (X11; Linux i686) AppleWebKit/537.17 (KHTML, like Gecko) Chrome/24.0.1312.27 Safari/537.17'

req = urllib.request.Request(url, headers=headers)
resp = urllib.request.urlopen(req)
#print(resp.read())

#Making POST request
post_url = 'http://localhost:3000/employees'
headers = {}
headers['Content-Type'] = 'application/json'
post_data = urllib.parse.urlencode({'name' : 'Lisa', 'salary'  : '10000'}).encode('ascii')
post_response = urllib.request.urlopen(url=post_url, data=post_data)
print(post_response.read())

#print response headers
print(post_response.info())
print('Response Content Type is = ', post_response.info()["content-type"])


