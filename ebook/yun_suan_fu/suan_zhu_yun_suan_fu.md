## 6.1 算术运算符

Java中的算术运算符主要用来组织数值类型数据的算术运算，按照参加运算的操作数的不同可以分为一元运算符和二元运算符。

### 6.1.1 一元运算符 {#-0}

算术一元运算一共有3个，分别是-、++和--。具体说明参见表6-1。

表6-1一元算术运算

| **运　算　符** | **名　　称** | **说　　明** | **例　　子** |
| --- | --- | --- | --- |
| - | 取反符号 | 取反运算 | b = -a |
| ++ | 自加一 | 先取值再加一，或先加一再取值 | a++或++a |
| -- | 自减一 | 先取值再减一，或先减一再取值 | a--或--a |

表6-1中，-a是对a取反运算，a++或a--是在表达式运算完后，再给a加一或减一。而++a或--a是先给a加一或减一，然后再进行表达式运算。

示例代码如下：


```java
int a = 12;
System.out.println(-a); ①
int b = a++; ②
System.out.println(b);
b = ++a; ③
System.out.println(b);

```

输出结果如下：

    -12
    12
    14

上述代码第①行是-a，是把a变量取反，结果输出是-12。第②行代码是先把a赋值给b变量再加一，即先赋值后++，因此输出结果是12。第③行代码是把a加一，然后把a赋值给b变量，即先++后赋值，因此输出结果是14。

### 6.1.2 二元运算符 {#-1}

二元运算符包括：+、-、*、/和%，这些运算符对数值类型数据都有效，具体说明参见表6-2。

表6-2二元算术运算

| **运　算　符** | **名　　称** | **说　　明** | **例　　子** |
| --- | --- | --- | --- |
| + | 加 | 求a加b的和，还可用于String类型，进行字符串连接操作 | a + b |
| - | 减 | 求a减b的差 | a - b |
| * | 乘 | 求a乘以b的积 | a * b |
| / | 除 | 求a除以b的商 | a / b |
| % | 取余 | 求a除以b的余数 | a % b |

示例代码如下：

```java
//声明一个字符类型变量
char charNum = 'A';		
// 声明一个整数类型变量
int intResult = charNum + 1;			①
System.out.println(intResult);

intResult = intResult - 1;
System.out.println(intResult);

intResult = intResult * 2;
System.out.println(intResult);

intResult = intResult / 2;
System.out.println(intResult);

intResult = intResult + 8;
intResult = intResult % 7;
System.out.println(intResult);

System.out.println("-------");

// 声明一个浮点型变量
double doubleResult = 10.0;
System.out.println(doubleResult);

doubleResult = doubleResult - 1;
System.out.println(doubleResult);

doubleResult = doubleResult * 2;
System.out.println(doubleResult);

doubleResult = doubleResult / 2;
System.out.println(doubleResult);

doubleResult = doubleResult + 8;
doubleResult = doubleResult % 7;
System.out.println(doubleResult);
```

输出结果如下：

    66
    65
    130
    65
    3
    -------
    10.0
    9.0
    18.0
    9.0
    3.0
    
上述例子中分别对数值类型数据进行了二元运算，其中代码第①行将字符类型变量charNum与整数类型进行加法运算，参与运算的该字符（&#039;A&#039;）的Unicode编码65。其他代码比较简单不再赘述。

### 6.1.3 算术赋值运算符 {#-2}

算术赋值运算符只是一种简写，一般用于变量自身的变化，具体说明参见表6-3。

表6-3 算术赋值符

| **运　算　符** | **名　　称** | **例　　子** |
| --- | --- | --- |
| += | 加赋值 | a += b、a += b+3 |
| -= | 减赋值 | a -= b |
| *= | 乘赋值 | a *= b |
| /= | 除赋值 | a /= b |
| %= | 取余赋值 | a %= b |

示例代码如下：

```java
int a = 1;
int b = 2;
a += b; 	// 相当于 a = a + b
System.out.println(a);

a += b + 3; // 相当于 a = a + b + 3
System.out.println(a);
a -= b; 	// 相当于 a = a - b
System.out.println(a);

a *= b; 	// 相当于 a=a*b
System.out.println(a);

a /= b;		// 相当于 a=a/b
System.out.println(a);

a %= b;		// 相当于 a=a%b
System.out.println(a);
```

输出结果如下：

    3
    8
    6
    12
    6
    0
    
上述例子分别对整型进行了+=、-=、*=、/=和%=运算，具体语句不再赘述。