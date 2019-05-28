## 实战2-分式计算器
### 概述
通过前几节课我们学习了Java中对象类的属性，方法，构造方法，封装等相关知识，这节课通过一个分式计算器项目来练习Java类的知识。**分式**由两个部分组成：分子和分母，在本项目中需要定义两个类，`Fraction`类，是一个对象类，这个类中定义了分式的属性，构造方法和分式的运算方法。`FrationCalculator`类是一个客户类，这个类主要处理与用户的交互，调用`Fraction`类获取分式计算结果，并将结果返回给用户。

### `Fraction`类
**属性**
+ 定义两个private的整型变量，名称分别为numerator和denominator

**构造方法**
+ 第一个构造方法是有两个形参，通过两个形参来初始化类的numerator和denominator属性
    - 如果用户输入的denominator是0，则抛出`IllegalArgumentException()`的异常
    - 如果用户输入的denominator是负值，则将符号转移到numerator中，例如，输入-3/-5，则返回3/5，输入3/-5，则返回-3/5
    *例如*： Fraction myFraction = new Fraction(3, 5)， 则myFraction的numerator = 3， denominator = 5。
+ 第二个构造方法是有一个形参，通过该形参来初始化类的numerator属性
    - 将denominator的值设为默认值1
    *例如*：Fraction myFraction = new Fraction(3) ，则myFraction的numerator = 3， denominator = 1
+ 第三个构造方法是没有形参
    - 将numerator的值设为默认值0，将denominator的值设为默认值1
    *例如*: Fraction myFraction = new Fraction()， 则myFraction的numerator = 0，denominator = 1，分式的值为0

在程序的后两个构造方法中，我们要尽量借助`this`关键字利用前一个构造方法来简化代码。

**方法**

|方法名| 参数|返回值|描述|
|---|---|---|---|
|getNumerator()|none|int|返回分式中numerator的值|
|getDenominator()|none|int|返回分式中denominator的值|
|toString()|none|String|以"numerator/denominator"的格式返回分式的值|
|toDouble()|none| double|计算分式的值，返回double类型的计算结果|
|add()| Fraction other| Fraction|返回与另一个分式相加以后的分式|
|subtract()| Fraction other | Fraction|返回与另一个分式相减以后的分式|
|multiply()| Fraction other | Fraction|返回与另一个分式相乘以后的分式|
|divide()| Fraction other | Fraction | 返回与另一个分式相除以后的分式|
|equals()| Object other | boolean | 检查两个分式是否相等|
|toLowestTerms()| none | none | 对分式进行约分|
|gcd()| int num, int den| int|返回两个整数的最大公约数，定义为static方法|


**equals()**  
重写Object类的`public boolean equals(Object other)`方法。首先判断对象是否是Fraction类，然后判断传入的分式与当前分式是否相等。  
**注意**: 1/2与2/4比较，结果返回true。  
**toLowestTerms()**  
将分式的分子与分母进行约分操作，更新分式numerator和denominator的属性值，保持分式整体的值不变。约分的关键是找到分子与分母的最大公约数，关于求最大公约数的算法，以下是辗转相除法的伪代码：
```
if a equals b
    return a or b;

find the reminder of a dived by b
if reminder equals zero
    return b
else
    set a to b
    set b to reminder
```
### `FractionCalculator`类
在这个类中，我们打印信息到控制台，接收用户从控制台输入的信息，对信息进行处理，并返回结果。  

**程序逻辑**  
+ 首先，输出提示信息，让用户输入操作符(+,-,/,*,=)，如果用户输入q或Q，则退出程序。
+ 用户输入操作符，检查用户输入的操作符是否合法，不合法则提示用户重新输入，直到用户输入合法操作符
+ 提示用户输入第一个分式，检查用户输入的分式是否合法，不合法则提示用户重新输入，直到用户输入的分式合法
+ 提示用户输入第二个分式，检查用户输入的分式是否合法，不合法则提示用户重新输入，直到用户输入的分式合法
+ 打印计算结果
```
> This program is a fraction calculator  
It will add, subtract, multiply and divide fractions until you type Q to quit.
Please enter your fractions in the form a/b, where a and b are integers.
>------------------------------------------------------------------------------------
>Please enter an operation (+, -, /, *, = or Q to quit)+
Please enter first fraction (a/b) or integer (a): 1/2
Please enter second fraction (a/b) or integer (a): 1/4
1/2 + 1/4 = 3/4
Please enter an operation (+, -, /, *, = or Q to quit)-
Please enter first fraction (a/b) or integer (a): 2/3
Please enter second fraction (a/b) or integer (a): 1/3
2/3 - 1/3 = 1/3
Please enter an operation (+, -, /, *, = or Q to quit)*
Please enter first fraction (a/b) or integer (a): 1/4
Please enter second fraction (a/b) or integer (a): 3/5
1/4 * 3/5 = 3/20
Please enter an operation (+, -, /, *, = or Q to quit)/
Please enter first fraction (a/b) or integer (a): 3/5
Please enter second fraction (a/b) or integer (a): 2/5
3/5 / 2/5 = 3/2
Please enter an operation (+, -, /, *, = or Q to quit)=
Please enter first fraction (a/b) or integer (a): 1/4
Please enter second fraction (a/b) or integer (a): 2/8
1/4 = 2/8 is true
Please enter an operation (+, -, /, *, = or Q to quit)q
>
>Process finished with exit code 0
```
### 附录
关于该项目的示例代码，可以从GitHub中下载[Project - FracCalc](https://github.com/7788wangzi/IntroJava/tree/master/Project%20-%20FracCalc)。
