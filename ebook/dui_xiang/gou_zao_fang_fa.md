## 11.3 构造方法

在11.1节使用了表达式new String(&quot;Hello World&quot;)，其中String(&quot;Hello World&quot;)是调用构造方法。构造方法是类中特殊方法，用来初始化类的实例变量，这个就是构造方法，它在创建对象（new运算符）之后自动调用。

Java构造方法的特点：

1.  构造方法名必须与类名相同。
2.  构造方法没有任何返回值，包括void。
3.  构造方法只能与new运算符结合使用。

构造方法示例代码如下：

```java
//Rectangle.java文件
package com.a51work6;

// 矩形类
public class Rectangle {

	// 矩形宽度
	int width;
	// 矩形高度
	int height;
	// 矩形面积
	int area;

	// 构造方法
	public Rectangle(int w, int h) {		①
		width = w;
		height = h;
		area = getArea(w, h);
	}
	...
}

```

代码第①行是声明了一个构造方法，其中有两个参数w和h，用来初始化Rectangle对象的两个成员变量width和height，注意前面没有任何的返回值。

### 11.3.1 默认构造方法

有时在类中根本看不到任何的构造方法。例如本节中User类代码如下：

```java
//User.java文件
package com.a51work6;

public class User {
	
	// 用户名
	private String username;

	// 用户密码
	private String password;

}
```

从上述User类代码，只有两个成员变量，看不到任何的构造方法，但是还是可以调用无参数的构造方法创建User对象，见如下代码。

```java
//HelloWorld.java文件
...
User user = new User();
```

Java虚拟机为没有构造方法的类，提供一个无参数的默认构造方法，默认构造方法其方法体内无任何语句，默认构造方法相当于如下代码：

```java
//默认构造方法
public User() { 
}
```

默认构造方法的方法体内无任何语句，也就不能够初始化成员变量了，那么这些成员变量就会使用默认值，成员变量默认值是与数据类型有关，具体内容可以参考9.1.2节中的表9-1所示。这里不再赘述。


### 11.3.2 构造方法重载

在一个类中可以有多个构造方法，它们具体有相同的名字（与类名相同），参数列表不同，所以它们之间一定是重载关系。

构造方法重载示例代码如下：

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

	public Person(String n, int a, Date d) {①
		name = n;
		age = a;
		birthDate = d;
	}

	public Person(String n, int a) {②
		name = n;
		age = a;
	}

	public Person(String n, Date d) {③
		name = n;
		age = 30;
		birthDate = d;
	}

	public Person(String n) {④
		name = n;
		age = 30;
	}
	
	public String getInfo() {		
		StringBuilder sb = new StringBuilder();
		sb.append("名字: ").append(name).append('\n');
		sb.append("年龄: ").append(age).append('\n');
		sb.append("出生日期: ").append(birthDate).append('\n');		
		return  sb.toString();
	}
}

```

上述代码Person类代码提供了4个重载的构造方法，如果有准确的姓名、年龄和出生日期信息，则可以选用代码第①行的构造方法创建Person对象；如果只有姓名和年龄信息则可选用代码第②行的构造方法创建Person对象；如果只有姓名和出生日期信息则可选用代码第③行的构造方法创建Person对象；如果只有姓名信息则可选用代码第④行的构造方法创建Person对象。

### 11.3.3 构造方法封装

构造方法也可以进行封装，访问级别与普通方法一样，构造方法的访问级别参考表11-1所示。示例代码如下：

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

	// 公有级别限制
	public Person(String n, int a, Date d) {①
		name = n;
		age = a;
		birthDate = d;
	}

	// 默认级别限制
	Person(String n, int a) { ②
		name = n;
		age = a;
	}

	// 保护级别限制
	protected Person(String n, Date d) {	③
		name = n;
		age = 30;
		birthDate = d;
	}

	// 私有级别限制
	private Person(String n) { ④
		name = n;
		age = 30;
	}

	...
}

```

上述代码第①行是声明公有级别的构造方法。代码第②行是声明默认级别，默认级别只能在同一个包中访问。代码第③行是保护级别的构造方法，该构造方法在同一包中与默认级别相同，在不同包中可以被子类继承。代码第④行是私有级别构造方法，该构造方法只能在当前类中使用，不允许在外边访问，私有构造方法可以应用于单例设计模式[^10]等设计。

[^10]: 单例模式是一种常用的软件设计模式，单例模式可以保证系统中一个类只有一个实例。