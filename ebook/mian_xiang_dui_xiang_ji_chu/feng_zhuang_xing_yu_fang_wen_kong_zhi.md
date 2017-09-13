## 10.6 封装性与访问控制

Java面向对象的封装性是通过对成员变量和方法进行访问控制实现的，访问控制分为4个等级：私有、默认、保护和公有，具体规则如表10-1所示。

表10-1 Java类成员的访问控制

| **访问控制等级** | **同一个类** | **同一个包** | **不同包的子类** | **不同包非子类** |
| --- | --- | --- | --- | --- |
| 私有 | Yes |  |  |  |
| 默认 | Yes | Yes |  |  |
| 保护 | Yes | Yes | Yes |  |
| 公有 | Yes | Yes | Yes | Yes |

下面详细解释一下这4种访问级别。

### 10.6.1 私有级别

私有级别的关键字是private，私有级别的成员变量和方法只能在其所在类的内部自由使用，在其他的类中则不允许直接访问。私有级别限制性最高。私有级别示例代码如下：
```java
// PrivateClass.java文件
package com.a51work6;

public class PrivateClass {			①
	
	private int x; 					②

	public PrivateClass() {		③
		x = 100;
	}

	private void printX() {			④
		System.out.println("Value Of x is" + x);
	}

}

// HelloWorld.java文件调用PrivateClass
package com.a51work6;

public class HelloWorld {
	public static void main(String[] args) {
		
		PrivateClass p;
		p = new PrivateClass();

		//编译错误，PrivateClass中的方法 printX()不可见
		p.printX();					⑤
	}
}

```
上述代码第①行声明PrivateClass类，其中的代码第②行是声明私有实例变量x，代码第③行是声明公有的构造方法，构造方法将在第12章详细介绍。代码第④行声明私有实例方法。

HelloWorld类中代码第⑤行会有编译错误，因为PrivateClass中printX()的方法是私有方法。

### 10.6.2 默认级别

默认级别没有关键字，也就是没有访问修饰符，默认级别的成员变量和方法，可以在其所在类内部和同一个包的其他类中被直接访问，但在不同包的类中则不允许直接访问。

默认级别示例代码如下：

```java
// DefaultClass.java文件
package com.a51work6;

public class DefaultClass {

	int x;							①

	public DefaultClass() {
		x = 100;
	}

	void printX() {				②
		System.out.println("Value Of x is" + x);
	}

}

```

上述代码第①行的x变量前没有访问限制修饰符，代码第②行的方法也是没有访问限制修饰符。它们的访问级别都有默认访问级别。

在相同包（com.a51work6）中调用DefaultClass类代码如下：
```java
// com.a51work6包中HelloWorld.java文件
package com.a51work6;

public class HelloWorld {

	public static void main(String[] args) {

		DefaultClass p;
		p = new DefaultClass();
		p.printX();
	}
}

```

默认访问级别可以在同一包中访问，上述代码可以编译通过。

在不同的包中调用DefaultClass类代码如下：

```java
// 默认包中HelloWorld.java文件
import com.a51work6.DefaultClass;

public class HelloWorld {

	public static void main(String[] args) {

		DefaultClass p;
		p = new DefaultClass();
		// 编译错误，DefaultClass中的方法 printX()不可见
		p.printX();
	}
}

```
该HelloWorld.java文件与DefaultClass类不在同一个包中，printX()是默认访问级别，所以p.printX()方法无法编译通过。

### 10.6.3 公有级别

公有级别的关键字是public，公有级别的成员变量和方法可以在任何场合被直接访问，是最宽松的一种访问控制等级。

公有级别示例代码如下：

```java
// PublicClass.java文件
package com.a51work6;

public class PublicClass {

	public int x; 				①

	public PublicClass() {
		x = 100;
	}

	public void printX() {		②
		System.out.println("Value Of x is" + x);
	}

}

```
上述代码第①行的x变量是公有级别，代码第②行的方法也是公有级别。调用PublicClass类代码如下：
```java
// 默认包中HelloWorld.java文件
import com.a51work6.PublicClass;

public class HelloWorld {

	public static void main(String[] args) {

		PublicClass p;
		p = new PublicClass();
		p.printX();
	}
}

```

该HelloWorld.java文件与PublicClass类不在同一个包中，可以公有的printX()方法。

### 10.6.4 保护级别

保护级别的关键字是protected，保护级别在同一包中完全与默认访问级别一样，但是不同包中子类能够继承父类中的protected变量和方法，这就是所谓的保护级别，“保护”就是保护某个类的子类都能继承该类的变量和方法。

保护级别示例代码如下：

// ProtectedClass.java文件
package com.a51work6;

public class ProtectedClass {

	protected int x;  ①

	public ProtectedClass() {
		x = 100;
	}

	protected void printX() {	②
		System.out.println("Value Of x is " + x);
	}

}
上述代码第①行的x变量是保护级别，代码第②行的方法也是保护级别。
在相同包（com.a51work6）中调用ProtectedClass类代码如下：

```java
// 默认包中HelloWorld.java文件
package com.a51work6;

import com.a51work6.ProtectedClass;

public class HelloWorld {

	public static void main(String[] args) {

		ProtectedClass p;
		p = new ProtectedClass();
		// 同一包中可以直接访问ProtectedClass中的方法 printX()
		p.printX();
		
	}
}
```

同一包中保护访问级别与默认访问级别一样，可以直接访问ProtectedClass的printX()方法，上述代码可以编译通过。
在不同的包中调用ProtectedClass类代码如下：

```java
// 默认包中HelloWorld.java文件
import com.a51work6.ProtectedClass;

public class HelloWorld {

	public static void main(String[] args) {

		ProtectedClass p;
		p = new ProtectedClass();
		// 编译错误，不同包中不能直接访问保护方法printX()
		p.printX();
		
	}
}
```

该HelloWorld.java文件与ProtectedClass类不在同一个包中，不同包中不能直接访问保护方法printX()，所以p.printX()方法无法编译通过。
在不同的包中继承ProtectedClass类代码如下：

```java
// 默认包中SubClass.java文件
import com.a51work6.ProtectedClass;

public class SubClass extends ProtectedClass {
	
	void display() {
		//printX()方法是从父类继承过来	
		printX(); ①
		//x实例变量是从父类继承过来
		System.out.println(x);	②
	}
}
```

不同包中SubClass从ProtectedClass类继承了printX()方法和x实例变量。代码第①行是调用从父类继承下来的方法，代码第②行是调用从父类继承下来的实例变量。

**提示 访问成员有两种方式：一种是调用，即通过类或对象调用它的成员，如p.printX()语句；另一种是继承，即子类继承父类的成员变量和方法。**

*   公有访问级别任何情况下两种方式都可以；
*   默认访问级别在同一包中两种访问方式都可以，不能在包之外访问；
*   保护访问级别在同一包中与默认访问级别一样，两种访问方式都可以。但是在不同包之外只能继承访问；
*   私有访问级别只能在本类中通过调用方法访问，不能继承访问。

**提示 访问类成员时，在能满足使用的前提下，应尽量限制类中成员的可见性，访问级别顺序是：私有级别→默认级别→保护级别→公有级别。**