## 十四：-Java中的static

在我们接触对象类之前，我们写的类变量和方法都是有`static`关键字的，不相信吗？让我们来回顾第一个Java版的hello world程序：
```java
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
```
这个`main`方法作为Java程序的入口，是被声明为**static**的，在一个Java可执行程序中，只能有一个这样子的方法。在这个方法中，我们定义了第一个Java对象。如果在这个**static**方法中要调用别的Class Main中的变量和方法，这个变量或方法也必须是**static**的，否则我们会收到编译错误：
>> Non-static filed 'xxx' cannot be referenced from a static context
>> Non-static method 'xxx' cannot be referenced from a static context

然后，我们开始定义自己的对象类，在对象类中，我们开始定义不带static关键字的类属性和类方法。这些不带static关键字的类属性和方法是特定于对象的，也就是说每一个对象可以有不同的属性值。举例来说，Person类中的name属性， 第一个对象实例的name="Ada", 第二个对象实例的name="Alan"，也就是不同对象有不同的属性值。

### static属性
在定义对象类的时候，如果在声明属性的时候加入static关键字会有什么作用呢？类似如下代码？
```java
public class StaticObj {
    public static int objectCount;
    public String name;
  ...
}
```
**static**属性是基于类的，不同的实例对象拥有共同的static属性值。一般，我们要做统计的时候，比如统计一个类被初始化成了多少个实例对象，或者一个网站一共有多少访问人数，这样子的属性是可以声明为static的，如下示例代码就是统计StaticObj被初始化成了多少个实例对象：
```java
public class StaticObj {
    public static int objectCount;
    public String name;

    public StaticObj(String name)
    {
        objectCount++;
        this.name = name;
    }
  ...
}
```
static属性与非static属性(对象属性)的区别可以参考如下表格：

|static属性|非static属性(对象属性)|
|---|---|
|为本类的所有实例对象共享|只是实例对象的一部分|
|调用的时候使用Class.name|调用的时候使用objVariable.name|
|只有一个值|不同的实例对象可以有不同的值|
|存储在一个地方|和每个实例对象存储在一起，存储在不同的地方|
|在任何对象创建之前已经分配内存|伴随着每个实例对象的创建动态分配内存|

### static方法
和static属性一样，在声明方法的时候可以加入static关键字将方法声明为static的。**static**的方法是基于类的，为本类的所有实例对象共享的。调用的时候需要使用`Class.method()`。
对于static方法，需要注意如下几点：
+ 每一个Java的可执行程序的`main`方法都是static的。
+ **static**方法中只能引用static的属性和方法。
+ 一般，建议**static**方法的访问可见性是public的，仅供本类使用的内部方法不建议声明为static方法。

本节课中使用的示例代码可以从GitHub中下载[StaticObj](https://github.com/7788wangzi/IntroJava/blob/master/StaticObj.java)

示例代码的客户类如下：
```java
public class Main {

    public static void main(String[] args) {

        StaticObj obj1 = new StaticObj("Static Obj1");
        System.out.println("obj1 name: "+obj1.getObjectName());
        System.out.println("obj1 Class name: "+StaticObj.getClassName());
        System.out.println("StaticObj instance count: "+StaticObj.objectCount);
        StaticObj obj2 = new StaticObj("Static Obj2");
        System.out.println("obj2 Class name: "+StaticObj.getClassName());
        System.out.println("obj2 name: "+obj2.getObjectName());
        System.out.println("StaticObj instance count: "+StaticObj.objectCount);
        StaticObj obj3 = new StaticObj("Static Obj3");
        System.out.println("obj3 Class name: "+StaticObj.getClassName());
        System.out.println("obj3 name: "+obj3.getObjectName());
        System.out.println("StaticObj instance count: "+StaticObj.objectCount);
    }
}
```
