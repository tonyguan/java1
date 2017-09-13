## 6.5 其他运算符

除了前面介绍的主要运算符，Java还有一些其他一些运算符。

*   三元运算符（? :）。例如x?y:z;，其中x、y和z都为表达式。
*   小括号。起到改变表达式运算顺序的作用，它的优先级最高。
*   中括号。数组下标。
*   引用号（.）。对象调用实例变量或实例方法的操作符，也是类调用静态变量或静态方法的操作符。
*   赋值号（=）。赋值是用等号运算符（=）进行的。
*   instanceof。判断某个对象是否为属于某个类。
*   new。对象内存分配运算符。
*   箭头（-&gt;）。Java 8新增加的，用来声明Lambda表达式。
*   双冒号（::）。Java 8新增加的，用于Lambda表达式中方法的引用。

示例代码如下：

```java
import java.util.Date;

public class HelloWorld {

	public static void main(String[] args) {

		int score = 80;
		String result = score > 60 ? "及格" : "不及格"; // 三元运算符（? : ）
		System.out.println(result);
		
		Date date = new Date();			// new运算符可以创建Date对象
		System.out.println(date.toString());	//通过.运算符调用方法

	}
}
```

此外，还有一些鲜为人知的运算符，随着学习的深入用到后再为大家介绍，这里就不再赘述了。