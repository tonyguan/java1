## 4.4 常量

常量事实上是那些内容不能被修改的变量，常量与变量类似也需要初始化，即在声明常量的同时要赋予一个初始值。常量一旦初始化就不可以被修改。它的声明格式为：

**final 数据类型 变量名 = 初始值;**

final关键字表示最终的，它可以修改很多元素，修饰变量就变成了常量。示例代码如下：


```java
public class HelloWorld {
	
	// 静态常量，替代const
	public static final double PI = 3.14; ①
	
	// 声明成员常量
	final int y = 10;	②
	
	public static void main(String[] args) {
		// 声明局部常量
		final double x = 3.3; ③
	} 
}

```


事实上常量有三种类型：静态常量、成员常量和局部常量。代码第①行的是声明静态常量，使用在final 之前public static修饰，用来保留字const。public static修饰的常量作用域是全局的，不需要创建对象就可以访问它，在类外部访问形式：HelloWorld. PI，这种常量在编程中使用很多。

代码第②行声明成员常量，作用域类似于成员变量，但不能修改。代码第③行声明局部常量，作用域类似于局部变量，但不能修改。