## MVC Architecture

There are three architectures of a java code for web application, we call them: model 1, model 2, and MVC architecture

### Model 1 Architecture
JSP

### Model 2 Architecture
The code are structured in three parts: Model, View, Controller

- Models define the class or entity model of the web application.
- Views are the pages that to displaying to user.
- Controllers control which class to load, which view to render.

For Servlet, the mappings are:  

|1| 2|  
|----|----|  
|Controller|Servlet|  
|View|JSP|  
|Model|like ToDo class|

### Front Controller - Spring MVC - DispatcherServlet

The DispatcherServlet

The Spring Web model-view-controller (MVC) framework is designed around a DispatcherServlet that handles all the HTTP requests and responses. The request processing workflow of the Spring Web MVC DispatcherServlet is illustrated in the following diagram −

![](https://www.tutorialspoint.com/spring/images/spring_dispatcherservlet.png)
 
Following is the sequence of events corresponding to an incoming HTTP request to DispatcherServlet −
- After receiving an HTTP request, DispatcherServlet consults the HandlerMapping to call the appropriate Controller. 
- The Controller takes the request and calls the appropriate service methods based on used GET or POST method. The service method will set model data based on defined business logic and returns view name to the DispatcherServlet.
- The DispatcherServlet will take help from ViewResolver to pickup the defined view for the request.
- Once view is finalized, The DispatcherServlet passes the model data to the view which is finally rendered on the browser.
- All the above-mentioned components, i.e. HandlerMapping, Controller, and ViewResolver are parts of WebApplicationContext w which is an extension of the plainApplicationContext with some extra features necessary for web applications.
