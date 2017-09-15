## 5.7 数值类型相互转换

学习了前面的数据类型后，大家会思考一个问题，数据类型之间是否可以转换呢？数据类型的转换情况比较复杂。基本数据类型中数值类型之间可以互相转换，布尔类型不能与它们之间进行转换。但有些不兼容类型之间，如String（字符串）转换为int整数等，可以借助于一些类的方法实现。本节只讨论数值类型的互相转换。

从图5-1可见数值类型包括了byte、short、char、int、long、float和double，这些数值类型之间的转换有两个方向：自动类型转换和强制类型转换。

### 5.7.1 自动类型转换

自动类型转换就是需要类型之间转换是自动的，不需要采取其他手段，总的原则是小范围数据类型可以自动转换为大范围数据类型，列类型转换顺序如图5-2所示，从左到右是自动。

![5-2](..../assets/5-2.jpg)

图5-2　数据类型转换顺序
**
注意 如图5-2所示，char类型比较特殊，char自动转换为int、long、float和double，但byte和short不能自动转换为char，而且char也不能自动转换为byte或short。**

自动类型转换不仅发生在赋值过程中，在进行数学计算时也会发生自动类型转换，在运算中往往是先将数据类型转换为同一类型，然后在进行计算。计算规则如表5-4所示。

表5-4 计算过程中自动类型转换规则

| **操作数1类型** | **操作数2类型** | **转换后的类型** |
| --- | --- | --- |
| byte、short、char | 　　　int | 　　int |
| byte、short、char、int | 　　　long | 　　long |
| byte、short、char、int、long | 　　　float | 　　float |
| byte、short、char、int、long、float | 　　　double | 　　double |

示例如下：

```java
// 声明整数变量
byte byteNum = 16;
short shortNum = 16;
int intNum = 16;
long longNum = 16L;

// byte类型转换为int类型
intNum = byteNum;
// 声明char变量
char charNum = '花';
// char类型转换为int类型
intNum = charNum;

// 声明浮点变量
// long类型转换为float类型
float floatNum = longNum;
// float类型转换为double类型
double doubleNum = floatNum;

//表达式计算后类型是double
double result = floatNum * intNum + doubleNum / shortNum;	①

```
上述代码第①行中表达式loatNum * intNum + doubleNum / shortNum进行数学计算，该表达式是由4个完全不同的数据类型组成，范围最大的是double，所以在计算过程中它们先转换成double，所以最后的结果是double。

### 5.7.2 强制类型转换

在数值类型转换过程中，除了需要自动类型转换外，有时还需要强制类型转换，强制类型转换是在变量或常量之前加上“(目标类型)”实现，示例代码如下：

```java
//int型变量
int i = 10;
//把int变量i强制转换为byte
byte b = (byte) i;

```
上述代码(byte) i表达式实现强制类型转换。强制类型转换主要用于大宽度类型转换为小宽度类型情况，如把int转换为byte。示例代码如下：

```java
//int型变量
int i = 10;
//把int变量i强制转换为byte
byte b = (byte) i;
int i2 = (int)i; ①
int i3 = (int)b; ②

```

上述代码第①行是将int类型的i变量“强制类型转换”为int类型，这显然是没有必要，但是语法也是允许的。代码第②行是将byte类型的b变量强制转换为int类型，从图5-2可见这个转换是自动，不需要强制转换，本例中这个转换没有实际意义，但有时为了提高精度需要种转换。示例代码如下：


```java
//int型变量
int i = 10;
float c1 = i / 3; ①
System.out.println(c1); ②
//把int变量i强制转换为float
float c2 = (float)i / 3; ③
System.out.println(c2); ④
```

输出结果：

    3.0
    
    3.3333333
    
上述代码比较输出结果发现c1和c2变量小数部分差别比较大的，这种差别在一些金融系统中是不允许的。在代码第①行i除以3从结果是小数，但由于两个操作数都是整数int类型，小数部分被截掉了，结果是3，然后再赋值给float 类型的c1变量，最后c1保持的是3.0。为了防止两个整数进行除法等运算导致小数位被截掉问题，可以将其中一个操作数强制类型转换为float，见代码第③行，这样计算过程中操作数是float类型，结果也是float不会截掉小数部分。

再看一个强制类型转换与精度丢失的示例。


```java
long yourNumber = 6666666666L;
System.out.println(yourNumber);
int myNuber = (int)yourNumber;
System.out.println(myNuber);

```

输出结果：

    6666666666
    -1923267926
    
上述代码输出结果可见，经过强制类型转换后，原本的6666666666L变成了负数。当大宽度数值转换为小宽度数值时，大宽度数值的高位被截掉，这样就会导致数据精度丢失。除非大宽度数值的高位没有数据，就是这个数比较小的情况，例如将6666666666L换为6L就不会丢失精度。