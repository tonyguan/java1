## 6.2 关系运算符

关系运算是比较两个表达式大小关系的运算，它的结果是布尔类型数据，即true或false。关系运算符有6种：==、!=、&gt;、&lt;、&gt;=和&lt;=，具体说明参见表6-4。

表6-4 关系运算符
![](./assets/表6-4.jpg)

**提示 ==和!=可以应用于基本数据类型和引用类型。当用于引用类型比较时，比较的是两个引用是否指向同一个对象，但当时实际开发过程多数情况下，只是比较对象的内容是否相当，不需要比较是否为同一个对象。
**
示例代码如下：

```java

int value1 = 1;
int value2 = 2;

if (value1 == value2) {
	System.out.println("value1 == value2");
}

if (value1 != value2) {
	System.out.println("value1 != value2");
}

if (value1 > value2) {
	System.out.println("value1 > value2");
}

if (value1 < value2) {
	System.out.println("value1 < value2");
}

if (value1 <= value2) {
	System.out.println("value1 <= value2");
}
```

运行程序输出结果如下：

	value1 != value2
	value1 < value2
	value1 <= value2
	