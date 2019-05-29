## 十一：类的属性

Java类的状态标识了一个类的基本特征，类的状态也叫做属性。定义类的属性和定义普通的变量一样，唯一区别是这些变量不是定义在任何方法中，而是定义在方法外边的。一般，属性的定义直接跟在类名称下边。
```java
public class MyObject {
    String field1 = "";
    int field2 = 0;
    double field3 = 0.0;

    ...
}
```

由于类的属性是定义在方法外边的，在方法中我们可以直接访问类的属性。

类的属性的数据类型可以是基本数据类型，也可以是其他对象类型，比如一个自行车类，它的零配件可以是一组零配件类的对象列表：
```java
public class Bicycle {
    Strin brand = "";
    String model = "";
    double listPrice = 0.0;
    int tireSize = 24;
    boolean isSold = false;
    double salePrice = 0.0;
    ArrayList<Accessory> accessaryList = new ArrayList<Accessory>();
    ...
```
### 属性的使用
类的属性和变量无异，只不过它的作用范围会更加地广泛(关于作用域的概念，请参考这篇[文章](https://philbarresi.com/understanding-functional-scope/))。我们可以在声明属性的时候，直接为该属性赋值，也可以在类的方法中，修改属性的值。
```java
public class Bicycle {
   
    boolean isSold = false;
    double salePrice = 0.0;
    boolean soldBicycle()
    {
        salePrice = 354;
        return isSold = true;
    }
}
```
在客户类中，我们也可也通过定义类的对象，以`对象.属性=value`的形式对属性进行修改，示例代码如下：
```java
public class Main {

    public static void main(String[] args) {

        Bicycle bi = new Bicycle();
        bi.isSold = true;
        bi.salePrice = 345;
    }
}
```

### This关键字
在类的方法中调用本类的属性的时候，我们使用到一个Java关键字**This**，这个关键字指代类自己，很常用的一个方法如下：
```java
public class Bicycle {

    boolean soldBicycle()
    {
        this.salePrice = 354;
        this.isSold = true;
        return this.isSold;
    }
```
如果以上示例代码对This的作用表述不明显，那么当我们比较两个同类型对象的时候，用This关键字指代自己就好理解了。
```java
    boolean equal(Bicycle other)
    {
        if(this.brand==other.brand&&this.model==other.model)
            return true;
        else
            return false;
    }
```
