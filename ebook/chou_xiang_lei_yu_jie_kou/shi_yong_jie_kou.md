## 13.2 使用接口

比抽象类更加抽象的是接口，在接口中所有的方法都是抽象的。

提示 Java 8之后接口中新增加了默认方法，因此“接口中所有的方法都是抽象的”这个提法在Java 8之后是有待商榷。

### 13.2.1 接口概念

其实13.1.1节抽象类Figure可以更加彻底，即Figure接口，接口中所有方法都是抽象的，而且接口可以有成员变量。将13.1.1节几何图形类改成接口后，类图如图13.2所示。

![](./assets/13-2.jpg)

图13-2　接口几何图形类图

**提示 在UML类图中接口的图标是“I”，见图13-2所示中的Figure接口。类的图标是“C”，见图13-2所示中的Triangle接口。**

### 13.2.2 接口声明和实现

在Java中接口的声明使用的关键字是interface，声明接口Figure示例代码如下：


```java
//Figure.java文件
package com.a51work6;

public interface Figure { ①
	//接口中静态成员变量
	String name = "几何图形"; //省略public static final ②
	
	// 绘制几何图形方法
	void onDraw(); //省略public ③
}

```

代码第①行是声明Figure接口，声明接口使用interface关键字，interface前面的修饰符是public或省略。public是公有访问级别，可以在任何地方访问。省略是默认访问级别，只能在当前包中访问。

代码第②行声明接口中的成员变量，在接口中成员变量都静态成员变量，即省略了public static final修饰符。代码第③行是声明抽象方法，即省略了public关键字。

某个类实现接口时，要在声明时使用implements关键字，当实现多个接口之间用逗号（,）分隔。实现接口时要实现接口中声明的所有方法。

实现接口Figure示例代码如下：

```java
//Ellipse.java文件
package com.a51work6.imp;

import com.a51work6.Figure;

//几何图形椭圆形
public class Ellipse implements Figure {

	//绘制几何图形方法
	@Override
	public void onDraw() {
		System.out.println("绘制椭圆形...");
	}
}

//Triangle.java文件
package com.a51work6.imp;

import com.a51work6.Figure;

//几何图形三角形
public class Triangle implements Figure {

	// 绘制几何图形方法
	@Override
	public void onDraw() {
		System.out.println("绘制三角形...");
	}
}
```

上述代码声明了两个具体类Ellipse和Triangle，它们实现了接口Figure中的抽象方法onDraw。

调用代码如下：

```java
//HelloWorld.java文件
import com.a51work6.imp.Ellipse;
import com.a51work6.imp.Triangle;

public class HelloWorld {

	public static void main(String[] args) {

		// f1变量是父类类型，指向子类实例，发生多态
		Figure f1 = new Triangle();
		f1.onDraw();
		System.out.println(f1.name);		①
		System.out.println(Figure.name); 	②

		// f2变量是父类类型，指向子类实例，发生多态
		Figure f2 = new Ellipse();
		f2.onDraw();
	}
}

```
上述代码中实例化两个具体类Triangle和Ellipse，对象f1和f2是Figure接口引用类型。接口Figure中声明了成员变量，它是静态成员变量，代码第①行和第②行是访问name静态变量。

**注意 接口与抽象类一样都不能被实例化。
**
### 13.2.3 接口与多继承

在C++语言中一个类可以继承多个父类，但这会有潜在的风险，如果两个父类在有相同的方法，那么子类如何继承哪一个方法呢？这就是C++多继承所导致的冲突问题。

在Java中只允许继承一个类，但可实现多个接口。通过实现多个接口方式满足多继承的设计需求。如果多个接口中即便有相同方法，它们也都是抽象的，子类实现它们不会有冲突。

图13-3所示是多继承类图，其中的有两个接口InterfaceA和InterfaceB，从类图中可以见两个接口中都有一个相同的方法void methodB()。AB实现了这两个接口，继承了Object父类。

![](./assets/13-3.jpg)

图13-3　多继承类图

接口InterfaceA和InterfaceB代码如下：


```java
//InterfaceA.java文件
package com.a51work6;

public interface InterfaceA {

	void methodA();

	void methodB();		
}

//InterfaceB.java文件
package com.a51work6;

public interface InterfaceB {

	void methodB();

	void methodC();
}

```

从代码中可见两个接口都有两个方法，其中方法methodB()完全相同。

实现接口InterfaceA和InterfaceB的AB类代码如下：


```java
//AB.java文件
package com.a51work6.imp;

import com.a51work6.InterfaceA;
import com.a51work6.InterfaceB;

public class AB extends Object implements InterfaceA, InterfaceB {	①	

	@Override
	public void methodC() {
	}

	@Override
	public void methodA() {
	}

	@Override
	public void methodB() {			②
	}
}

```

在AB类中的代码第②行实现methodB()方法。注意在AB类声明时，实现两个接口，接口之间使用逗号（，）分隔，见代码第①行。

### 13.2.4 接口继承

Java语言中允许接口和接口之间继承。由于接口中的方法都是抽象方法，所以继承之后也不需要做什么，因此接口之间的继承要比类之间的继承简单的多。如同4-4所示，其中InterfaceB继承了InterfaceA，在InterfaceB中还覆盖了InterfaceA中的methodB()方法。ABC是InterfaceB接口的实现类，从图可见ABC需要实现InterfaceA和InterfaceB接口中的所有方法。

![](./assets/13-4.jpg)

图13-4　接口继承类图

接口InterfaceA和InterfaceB代码如下：


```java
//InterfaceA.java文件
package com.a51work6;

public interface InterfaceA {

	void methodA();

	void methodB();		
}

//InterfaceB.java文件
package com.a51work6;

public interface InterfaceB extends InterfaceA {

	@Override
	void methodB();
	
	void methodC();
}

```

InterfaceB继承了InterfaceA，声明时也使用extends关键字。InterfaceB 中的methodB()覆盖了InterfaceA，事实上在接口中覆盖方法，并没有实际意义，因为它们都是抽象的，都是留给子类实现的。

实现接口InterfaceB的ABC类代码如下：


```java
//ABC.java文件
package com.a51work6.imp;

import com.a51work6.InterfaceB;

public class ABC implements InterfaceB {

	@Override
	public void methodA() {
	}

	@Override
	public void methodB() {
	}

	@Override
	public void methodC() {
	}
}
```


ABC类实现了接口InterfaceB，事实上是实现InterfaceA和InterfaceB中所有方法，相当于同时实现InterfaceA和InterfaceB接口。

### 13.2.5 Java 8新特性默认方法和静态方法

在Java 8之前，尽管Java语言中接口已经非常优秀了，但相比其他面向对象的语言而言Java接口存在如下不足之处：

**1.  不能可选实现方法，接口的方法全部是抽象的，实现接口时必须全部实现接口中方法，哪怕是有些方法并不需要，也必须实现。
2.  没有静态方法。**

针对这些问题，Java 8在接口中提供了声明默认方法和静态方法的能力。接口示例代码如下：


```java
//InterfaceA.java文件
package com.a51work6;

public interface InterfaceA {

	void methodA();

	String methodB();

	// 默认方法
	default int methodC() {		
		return 0;
	}

	// 默认方法
	default String methodD() {
		return "这是默认方法...";
	}

	// 静态方法
	static double methodE() {
		return 0.0;
	}
}

```

在接口InterfaceA中声明了两个抽象方法methodA和methodB，两个默认方法methodC和methodD，还有声明了静态方法methodE。接口中的默认方法类似于类中具体方法，给出了具体实现，只是方法修饰符是default。接口中静态方法类似于类中静态方法。

实现接口示例代码如下：


```java
//ABC.java文件
package com.a51work6.imp;

import com.a51work6.InterfaceA;

public class ABC implements InterfaceA {

	@Override
	public void methodA() {
	}

	@Override
	public String methodB() {
		return "实现methodB方法...";
	}

	@Override
	public int methodC() {
		return 500;
	}
}

```


实现接口时接口中原有的抽象方法在实现类中必须实现。默认方法可以根据需要有选择实现（覆盖）。静态方法不需要实现，实现类中不能拥有接口中的静态方法。

上述代码中ABC类实现了InterfaceA接口，InterfaceA接口中的两个默认方法ABC只是实现（覆盖）了methodB。

调用代码如下：


```java
//HelloWorld.java文件
package com.a51work6.imp;

import com.a51work6.InterfaceA;

public class HelloWorld {

	public static void main(String[] args) {

		//声明接口类型，对象是实现类，发生多态
		InterfaceA abc = new ABC();

		// 访问实现类methodB方法
		System.out.println(abc.methodB());

		// 访问默认方法methodC
		System.out.println(abc.methodC());			①

		// 访问默认方法methodD
		System.out.println(abc.methodD());			②

		// 访问InterfaceA静态方法methodE
		System.out.println(InterfaceA.methodE());		③
	}
}
```

运行结果：

	实现methodB方法...
	500
	这是默认方法...
	0.0

从运行结果可见，代码第①行调用默认方法methodC，是调用类AB中的实现。代码第②行调用默认方法methodD，是调用接口InterfaceA中的实现。代码第③行调用接口静态方法，只能通过接口名（InterfaceA）调用，不能通过实现类ABC调用，可以这样理解接口中声明的静态方法与其他实现类没有任何关系。