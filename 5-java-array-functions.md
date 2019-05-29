## 五：数组常用属性与方法

在数组中，我们最常用的一个属性(field)是length，它是指数组的长度。对于一个整型数组`int[] nums = new int[5];`，获取其长度的语句如下：
```java
int arrayLength = nums.length; // arrayLength = 5
```
### 遍历数组元素
在上一课我们了解了如何通过数组的索引值(index)来直接存取数组元素，如果我们要遍历数组中的每一个元素，就要使用`for (condition) {}`语句了，其中边界条件(condition)是数组索引值<数组的长度。
假如，一个整型数组:
```java
int[] nums = new int[5];
nums[2] = 3;
nums[3] = 4;
```

我们使用如下语句来遍历输出这个数组的每一个元素：
```java
for(int I=0; I<nums.length; I++)
{
System.out.print(nums[I] + " ");
}
```
### Arrays方法
Java语言为我们内置了挺多的数组方法，数组方法定义在一个名为`java.util.Arrays`的包中，使用数组方法之前，我们要通过以下语句来引入Arrays包：
```java
import java.util.Arrays;
```
引入这个包以后，我们可以使用类似于`Arrays.toString()`这样子的方法，这个方法的用法如下：
```java
int[] nums ={5,3,6,8,11,2};
System.out.println(Arrays.toString(nums)); // 输出 [11, 3, 5, 6, 8, 2]
```

需要**注意**的是，当我们不使用`Arrays.toString()`方法，而直接传递数组名给println()时，我们会得到类似下方的一串字符串，这个字符串其实是该数组的内存地址。
```
System.out.println(nums); // 输出[I@6cd8737
```
除了`Arrays.toString()`方法，Arrays提供了以下常用数组方法：

|方法名称|例子|描述|
|---|---|---|
|equals(array1, array2)|Arrays.equals(a,b); 或a.equals(b);|如果两个数组包含的元素个数相同，数组中每一个元素相同，则返回true，否则返回false|
|fill(array, value)|Arrays.fill(a,10);|将数组中的每一个元素都设置为给定的数值|
|copyOf(array, newLength)| Arrays.copyOf(a,10)|从数组a创建一个新数组，新数组长度为10，如a.length>=10，则把a的前10个元素拷贝给新数组，否则，将a的所有元素拷贝给新数组，新数组中剩余元素使用默认值填充|
|sort(array)|Arrays.sort(a)|将数组a中的元素按照从小到大排序|
|binarySearch(array, value)|Arrays.binarySearch(a, 10)|在一个已排序的数组中，查询给定数值的索引值，若找不到给定值，返回-1|

点击此处来查看[Arrays的完整的方法定义](https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html?is-external=true)。

### 数组是个引用类型
在上一课我们也提到过数组是一个引用类型，引用类型与基本数据类型的根本区别是他们传递的是内存地址，而不是值本身。
首先，我们定义两个方法，一个方法接收int型的参数，另一个方法接收int[]类型的参数，在两个方法中，修改传进来参数的值，然后在main函数中查看调用两个方法以后，变量的值是否被修改。

两个方法定义如下：
```java
    public static void changeInt(int arg)
    {
        arg=5;
    }

    public static void changeIntArray(int[] arg)
    {
        arg[0]=5;
    }
```

在main函数中，定义变量，调用方法，并输出变量的值的代码：
```java
        int intArg = 0;
        int[] intArray = new int[2];

        System.out.println("调用前intArg: "+intArg);
        System.out.println("调用前intArray: "+Arrays.toString(intArray));
        changeInt(intArg);
        changeIntArray(intArray);
        System.out.println("调用后intArg: "+intArg);
        System.out.println("调用后intArray: "+Arrays.toString(intArray));
```

输出结果：
```
调用前intArg: 0
调用前intArray: [0, 0]
调用后intArg: 0
调用后intArray: [5, 0]
```
即：
+ 在changeIntArray中对传入的`int[]`参数的修改直接修改了我们在main方法中定义的实参。
+ 在changeInt中对传入的`int`参数的修改并不能修改我们在main方法中定义的实参。

所以结论是：**数组是个对象，它是个引用类型**。
