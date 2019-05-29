## 十：Java中的类

数组为存放一组相同数据类型的数据提供了方便，并且通过数组索引index很容易实现对元素的存取，但是数组也存在如下限制：

1.  数组容量不可扩展，数组的容量在定义时已经确定，事后没有能力扩大或缩小容量
2. 如果在数组的某一个位置插入新元素，后续的元素没有办法做到自动给依次后移
3. 如果在数组的某一个位置删除元素，后续的元素也没有办法做到自动依次前提

针对以上限制，Java引入了另一种可变数组ArrayList，要使用ArrayList，首先引入`ArrayList`：
```java
import java.util.ArrayList;
```
不同于C#的是，Java中的ArrayList只能存放同一数据类型的元素， 声明数据ArrayList对象可以使用泛型的方式：
```java
ArrayList<Object> arrayListName = new ArrayList<Object>();
```

由于`<>`中只能是对象类型，我们在声明基本数据类型的数组变量时，是不能写作`ArrayList<int> a = new ArrayList<int>();` 这种形式的，解决方法是Java帮我们封装了与基本数据类型相对应的对象类，如下表所示是基本数据类型的对象类：

|基本数据类型|对象类|
|---|---|
|int|Integer|
|char|Character|
|boolean|Boolean|
|double|Double|

通过封装类，我们可以定义基本数据类型的ArrayList数组变量了：
```java
ArrayList<Integer> intArrayList = new ArrayList<Integer>();
ArrayList<Double> doubleArrayList = new ArrayList<Double>();
ArrayList<Character> charArrayList = new ArrayList<Character>();
```
### ArrayList属性和方法
Java提供了许多有用(常用)的ArrayList方法来方便我们操作ArrayList数组。如下表所示，即是ArrayList最常用的一些方法：

> 以数组[5,9,2]为例

|方法名称|举例|描述|
|---|---|---|
|size()|list.size()|返回ArrayList数组的当前长度，之所以说是当前长度，是因为ArrayList可以随时改变数组的长度|
|toString()|list.toString()|以特定的格式返回数组中的元素，例如`[5, 9, 2]`|
|set(index, value)|list.set(0, 9)|将数组某一索引处的值为修改为给定值，调用后的数组为`[9, 9, 2]`|
|get(index)|list.get(0)|返回数组某一索引处的值，返回结果9|
|add(value)|list.add(1)|添加指定数值到数组的末尾，此时数组为`[9, 9, 2, 1]`|
|add(index, value)|list.add(0, 5)| 在数组某一索引处，插入给定值，改元素以后的元素位置依次往后推一个位置，此时数组为`[5, 9, 9, 2, 1]`|
|indexOf(value)|list.indexOf(2)|获取给定数值的第一次出现位置的索引值，本例中，返回3|
|contains(value)|list.contains(2)|若数组包含给定值，则返回true，否则，返回false|
|remove(index)|list.remove(3)|移除数组某一索引处的值，该索引以后的所有元素依次往前移一个位置，此时数组为`[5, 9, 9, 1]`|

以上表格中用到的示例代码为：

```java
ArrayList<Integer> intArrayList = new ArrayList<Integer>();
System.out.println(intArrayList.size());
intArrayList.add(5);
intArrayList.add(9);
intArrayList.add(2);
System.out.println(intArrayList.toString());
intArrayList.set(0,9);
System.out.println(intArrayList.toString());
System.out.println(intArrayList.get(0));
intArrayList.add(1);
System.out.println(intArrayList.toString());
intArrayList.add(0,5);
System.out.println(intArrayList.toString());
System.out.println(intArrayList.indexOf(2));
System.out.println("intArrayList是否包含2: "+ intArrayList.contains(2));
System.out.println("IntArrayList是否包含3： "+ intArrayList.contains(3));
intArrayList.remove(3);
System.out.println(intArrayList.toString());

> 输出结果
0
[5, 9, 2]
[9, 9, 2]
9
[9, 9, 2, 1]
[5, 9, 9, 2, 1]
3
intArrayList是否包含2: true
IntArrayList是否包含3： false
[5, 9, 9, 1]
```

通过使用ArrayList数组，我们解决了数组的容量不可扩展，插入删除元素不方便的限制。
