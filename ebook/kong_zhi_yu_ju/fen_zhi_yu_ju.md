## 7.1 分支语句

分支语句提供了一种控制机制，使得程序具有了“判断能力”，能够像人类的大脑一样分析问题。分支语句又称条件语句，条件语句使部分程序可根据某些表达式的值被有选择地执行。Java编程语言提供了if和switch两种分支语句。

### 7.1.1 if语句 {#if}

由if语句引导的选择结构有if结构、if-else结构和else-if结构三种。

#####1.  if结构

如果条件表达式为true就执行语句组，否则就执行if结构后面的语句。如果语句组只有一条语句，可以省略大括号，当从编程规范角度不要省略大括号，省略大括号会是程序的可读性变差。语法结构如下：

```java

if (条件表达式) {
   语句组
}
```

if结构示例代码如下：
if (条件表达式) {
    语句组 
}
if结构示例代码如下：


```java
int score = 95;
if (score >= 85) {
	System.out.println("您真优秀！");
}
if (score < 60) {
	System.out.println("您需要加倍努力！");
}
if ((score >= 60) && (score < 85)) {
	System.out.println("您的成绩还可以，仍需继续努力！");
}
```


程序运行结果如下：

	您真优秀！

#####2.  if-else结构

所有的语言都有这个结构，而且结构的格式基本相同，语句如下：

```java
if (条件表达式) {
   语句组1 
} else {
   语句组2 
}
```

当程序执行到if语句时，先判断条件表达式，如果值为true，则执行语句组1，然后跳过else语句及语句组2，继续执行后面的语句。如果条件表达式的值为false，则忽略语句组1而直接执行语句组2，然后继续执行后面的语句。

if-else结构示例代码如下：

```java
int score = 95;
if (score < 60) {
	System.out.println("不及格");
} else {
	System.out.println("及格");
}

```
程序运行结果如下：

	及格
	
#####3.  else-if结构

else-if结构如下：

```java
if (条件表达式1) {
    语句组1 
} else if (条件表达式2) {
    语句组2
} else if (条件表达式3) {
    语句组3 
... 
} else if (条件表达式n) {
    语句组n
} else {
    语句组n＋1
}

```
可以看出，else-if结构实际上是if-else结构的多层嵌套，它明显的特点就是在多个分支中只执行一个语句组，而其他分支都不执行，所以这种结构可以用于有多种判断结果的分支中。

else-if结构示例代码如下：

```java
int testScore = 76;
char grade;
if (testScore >= 90) {
	grade = 'A';
} else if (testScore >= 80) {
	grade = 'B';
} else if (testScore >= 70) {
	grade = 'C';
} else if (testScore >= 60) {
	grade = 'D';
} else {
	grade = 'F';
}
System.out.println("Grade = " + grade);
```
输出结果如下：

	Grade = C

其中char grade是声明字符变量，然后经过判断最后结果是C。

### 7.1.2 switch语句 {#switch}

switch提供多分支程序结构语句。下面先介绍一下switch语句基本形式的语法结构，如下所示：

```java
switch (表达式) { 
    case 值1：
		语句组1 
    case 值2：
		语句组2 
    case 值3：
		语句组3 
    		... 
    case 判断值n：
		语句组n 
    default：
		语句组n＋1 
}
```
 
switch语句中“表达式”计算结果只能是int、byte、short和char类型，不能是long更不能其他的类型。每个case后面只能跟一个int、byte、short和char类型的常量，default语句可以省略。

当程序执行到switch语句时，先计算条件表达式的值，假设值为A，然后拿A与第1个case语句中的值1进行匹配，如果匹配则执行语句组1，语句组执行完成后不跳出switch，只有遇到break才跳出switch。如果A没有与第1个case语句匹配，则与第2个case语句进行匹配，如果匹配则执行语句组2，以此类推，直到执行语句组n。如果所有的case语句都没有执行，就执行default的语句组n＋1，这时才跳出switch。

示例代码如下：


```java
int testScore = 75;

char grade;
switch (testScore / 10) {			①
case 9:
	grade = '优';
	break;
case 8:
	grade = '良';
	break;
case 7:			 // 7是贯通的		②
case 6:
	grade = '中';
	break;
default:
	grade = '差';
}
System.out.println("Grade = " + grade);
```
输出结果如下：

	Grade = 中

上述代码将100分制转换为：“优”、“良”、“中”、“差”评分制，其中7分和6分都是“中”成绩，把case 7和case 6当成一种情况考虑。代码第①行计算表达式获得0~9分数值。代码第②行的case 7是贯通的，就它的后面不加break，程序流执行完当前case后，则会进入到下一个case，因此本来中case 7和case 6都执行相同的代码。