## 类的构造方法
我们在客户类中使用**new**关键字来定义一个类的对象的时候，这个语句调用的是类的一个构造方法。构造方法的作用主要是初始化我们类的属性，即为类的属性赋值。类的构造方法声明语句如下：
```java
public class ClassName{
...
  public ClassName()
  {
    field = value;
  }
}
```
由此可见，类的构造方法有2个特点：
+ 构造方法的方法名字和类的名字相同
+ 构造方法不写返回类型，因为构造方法返回自己类的一个实例，所以它的返回类型就是自己的类，故不写。（PS: 如果错误地写上了返回类型，那么这个方法就不再是构造方法了。)

### 构造方法的重载
首先，我们在编写对象类的时候，如果没有定义任何构造方法，那么系统就默认给我们定义了一个没有任何参数的构造方法。 即，如果我们定义一个对象类：
```java
public class Person{
  String name;
  int age;
}
```
那么，我们可以在客户类中使用new关键字来定义一个Person类的对象实例，这个Person对象中的所有属性使用本数据类型的默认值(Zero值）：
```java
Person perA = new Person();
```
其次，一旦我们在对象类中声明了构造方法，无论我们声明的构造方法是有参数的还是没有参数的，那么在客户类中，我们只能使用自己声明的构造方法来定义类对象。
第三，构造方法可以重载，在对象类中，我们可以声明多个构造方法，这些构造方法的参数个数一定不同。构造方法的重载，示例代码如下：
```java
public class Person{
    String name;
    int age;

    public Person(String name, int age)
    {
        this.name = name;
        this.age  = age;
    }

    public Person(String name)
    {
        this.name = name;
        this.age =0;
    }
    
    public Person()
    {
        this.name="";
        this.age=0;                
    }
}
```
### 构造方法中的This关键字
在一个构造方法中是不能使用构造方法的名字来调用另外一个构造方法的，这个时候我们就要使用Java代码中的**This**关键字。在构造方法的重载中的代码，我们也可以通过使用This关键字来简化构造方法的重载，简化后的示例代码如下：
```java
public class Person{
    String name;
    int age;

    public Person(String name, int age)
    {
        this.name = name;
        this.age  = age;
    }

    public Person(String name)
    {
        this(name,0);
    }

    public Person()
    {
        this("");
    }
}
```
