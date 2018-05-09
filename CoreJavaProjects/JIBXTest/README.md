# [JiBX Tutorial](https://www.journaldev.com/83/jibx-tutorial)

# How to Execute

1. cd JIBXTest
2. ant bind
3. cd bin
4. java -cp .:../lib/jibx-run.jar com/journaldev/jibx/test/JibxTest

Output:

```html
Employee ID:12345
Employee as XML String:<?xml version="1.0" encoding="UTF-8"?>
<Employee id="237871">
  <name>Cisco</name>
  <hiredate>Jan 03, 2011</hiredate>
</Employee>
```