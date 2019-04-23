
## Maven

Maven is a java build tool, it's used to build java code, package the resource files, and create the .jar or .war.

Maven Workflow:
1. Compile java code to Classes.
2. Run the Unit test if the test code is written.
3. Packaging files, resources.
4. Build into installer (.jar, or .war).

The package file structure, take .war for example:

```
|- META-INF  
|- WEB-INF  
  |- classes   
    |- *.class  (could under sub-folders)
  |- lib  
    |- *.jar  (for example, bootstrap-3.3.6.jar, jquery-1.9.1.jar, jstl-1.2.jar)  
  |- views  
    |- *.jsp  (for example, login.jsp, todo.jsp)  
  |- web.xml  
```
