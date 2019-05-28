### 数组的概念
在Java中，数组是由**相同数据类型**的很多元素组成的一组序列。在数组中的每一个元素都有一个唯一的地址，对数组元素的存取都可以通过这个地址，我们把这个地址叫做索引(index)。一个整数(integer)类型的数组可以形象地表示成如下这张图片。  
![数组元素和索引](https://upload-images.jianshu.io/upload_images/5761673-0b32abde264f9827.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

需要**注意**的是，在Java中，数组第一个元素的索引值是0，最后一个元素的所有是(数组的长度-1)。

### 数组的声明
声明（定义变量）一个数组变量可以使用如下语法：
```java
datatype[] arrayVariableName= new datatype[numberOfArrayElements];
```
例如，声明一个int类型的数组，可以这么写：
```java
int[] myArray = new int[10];
```
对以上这个数组的说明：
1. 首先，这是一个int类型的数组，其中存放的所有元素都是int类型。
2. 数组中共有10个元素，即数组的容量(大小)是10.
3. 数组中每一个元素都是0。直到我们显式地修改其中的值。

除此之外，我们在声明数组的时候也可以直接给每个元素赋值，如下数组的声明也是合法的：

```java
int[] nums={5, 3, 6, 8, 11, 2};
```

如果我们在声明数组的时候没有直接给每个元素赋值操作，像这个数组`int[] nums=new int[10];`，那么数组中的每个元素都保持相应数据类型的默认值，如下是Java中八种基本数据类型的默认值：
|数据类型|默认值（0值）|
|---|---|
|int/short/long/byte|0|
|char|'\u0000'|
|boolean|false|
|double/float|0.0|
**注意**：Java中引用类型的默认值为Null，Null是上一篇文中提到的"没有对象"的意思。String类型也是引用类型，其默认值是Null。另外，数组本身也是引用类型，它的默认值是Null，即，如果我们声明一个数组`int[] nums=null;`，那么，nums本身是没有被赋值的，nums==Null，此时对nums进行操作时系统就会抛出java.lang.NullPointerException的错误。

### 数组的操作练习
定义一个长度为10的整型数组，数组变量名称nums，修改数组第一，第二，第三元素的值分为98，86，90。
**解答**:
首先，定义int类型数组：
```java
int[] nums = new int[10];
```
此时的数组元素如下：  
![声明长度为10的整数型数组](https://upload-images.jianshu.io/upload_images/5761673-28da4ff8e4a877b5.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
通过index访问数组元素，元素1，元素2，元素3的值并修改，此时请注意数组元素的索引是从0开始的，即第一个元素是`nums[0]`:
```java
nums[0]=98;
nums[1]=86;
nums[2]=90;
```
修改过后的数组元素如下：  
![修改后的数组元素](https://upload-images.jianshu.io/upload_images/5761673-fd2afd1f565d533c.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
### java.lang.ArrayIndexOutOfBoundsException
由于数组是有大小的，如果我们通过数组索引来存取数组元素时使用了不恰当的索引值，系统就会抛出ArrayIndexOutOfBoundsException。例如，`int[] nums=new int[10]`这个数组元素的索引值范围时0 ~ 9，一旦我们访问`nums[10]`或时`nums[-1]`, 数组索引出界的异常就会被触发。

