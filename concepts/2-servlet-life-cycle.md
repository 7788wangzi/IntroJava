## Servlet Life Cycle

### Overview

`init()` method
- the `init` method only execute once when the application is started.

`service()` method  
  Request Method - Get, Post, Put, Delete  
  `doGet(HttpServletRequest, HttpServletResponse)  `  
  `doPost(HttpServletRequest, HttpServletResponse)  `  

`destroy()` method
- the `destroy` method only execute once when the application is stopped.
