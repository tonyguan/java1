## 11.4 this关键字

前面章节中使用过this关键字，this指向对象本身，一个类可以通过this来获得一个代表它自身的对象变量。this使用在如下三种情况中：

*   调用实例变量。
*   调用实例方法。
*   调用其他构造方法。

使用this变量的示例代码：

```java
//Person.java文件
package com.a51work6;

import java.util.Date;

public class Person {

	// 名字
	private String name;
	// 年龄
	private int age;
	// 出生日期
	private Date birthDate;

	// 三个参数构造方法
	public Person(String name, int age, Date d) {	①
		this.name = name;②
		this.age = age;③
		birthDate = d;
		System.out.println(this.toString());	④	
	}

	public Person(String name, int age) {		
		// 调用三个参数构造方法
		this(name, age, null);	⑤	
	}

	public Person(String name, Date d) {
		// 调用三个参数构造方法
		this(name, 30, d); 	⑥
	}

	public Person(String name) {
		// System.out.println(this.toString());
		// 调用Person(String name, Date d)构造方法
		this(name, null); 	⑦
	}

	@Override
	public String toString() {
		return "Person [name=" + name 	⑧
				+ ", age=" + age ⑨
				+ ", birthDate=" + birthDate + "]";
	}
}

```

上述代码中多次用到了this关键字，下面详细分析一下。代码第①行声明三个参数构造方法，其中参数name和age与实例变量name和age命名冲突，参数是作用域为整个方法的局部变量，为了防止局部变量与成员变量命名发生冲突，可以使用this调用成员变量，见代码第②行和第③行。注意代码第⑧行和第⑨行的name和age变量没有冲突，所以可以不使用this调用。

this也可以调用本对象的方法，见代码第④行的this.toString()语句，这本例中this可以省略。

在多个构造方法重载时，一个构造方法可以调用其他的构造方法，这样可以减少代码量，上述代码第⑤行this(name, age, null)使用this调用其他构造方法。类似调用还有代码第⑥行的this(name, 30, d)和第⑦行的this(name, null)。

**注意 使用this调用其他构造方法时，this语句一定是该构造方法的第一条语句。例如在代码第⑦行之前调用toString()方法则会发生错误。**
