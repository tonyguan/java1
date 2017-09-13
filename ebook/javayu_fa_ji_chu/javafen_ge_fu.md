## 4.2 Java分隔符

在Java源代码中，有一些字符被用作分隔，称为分隔符。分隔符主要有：分号（;）、左右大括号（{}）和空白。

#####1\. 分号

分号是Java语言中最常用的分隔符，它表示一条语句的结束。下面代码：

```java
int totals = 1 + 2 + 3 + 4;

```
等价于

```java
int totals = 1 + 2

+ 3 + 4;

```
#####2\. 大括号

在Java语言中，以左右大括号（{}）括起来语句集合称为语句块（block）或复合语句，语句块中可以有0~n条语句。在定义类或方法时，语句块也被用做分隔类体或方法体。语句块也可以嵌套，且嵌套层次没有限制。示例代码如下：


```java
public class HelloWorld {

	public static void main(String args[]) {

		int m = 5;
		if (m < 10) {
			System.out.println("<10");
		}

	}
}

```

#####3\. 空白

在Java源代码中元素之间允许有空白，空白的数量不限。空白包括空格、制表符（Tab键输入）和换行符（Enter键输入），适当的空白可以改善对源代码可读性。下列几段代码是等价。

```java
if (m < 10) {
	System.out.println("<10"); }
```
等价于

```java
if (m < 10) 
	{
	System.out.println("<10"); 
}
```
等价于

```java
if (m < 10) {
	System.out.println("<10"); 
}
```
