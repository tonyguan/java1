## 10.3 类

类是Java中的一种重要的引用数据类型，是组成Java程序的基本要素。它封装了一类对象的数据和操作。

### 10.3.1 类声明

Java语言中一个类的实现包括：类声明和类体。类声明语法格式如下。


```java
[public][abstract|final] class className [extends superclassName] [implements interfaceNameList] {
    //类体
}
```

其中，class是声明类的关键字，className是自定义的类名；class前面的修饰符public、abstract、final用来声明类，它们可以省略，它们的具体用法后面章节会详细介绍；superclassName为父类名，可以省略，如果省略则该类继承Object类，Object类所有类的根类，所有类都直接或间接继承Object；interfaceNameList是该类实现的接口列表，可以省略，接口列表中的多个接口之间用逗号分隔。

**提示 本书语法表示符号约定，在语法说明中，括号（[]）部分表示可以省略；竖线（|）表示“或关系”，例如abstract|final，说明可以使用abstract或final关键字，两个关键字不能同时出现。
**
声明动物（Animal）类代码如下：

```java
// Animal.java
public class Animal extends Object {
    //类体
}
```

上述代码声明了动物（Animal）类，它继承了Object类。继承Object类extends Object代码可以省略。

类体是类的主体，包括数据和操作，即成员变量和成员方法。下面就来展开介绍一下。

### 10.3.2 成员变量

声明类体中成员变量语法格式如下：

```java
class className {

    [public | protected | private ] [static] [final] type variableName; //成员变量

}
```
其中type是成员变量数据类型，variableName是成员变量名。type前的关键字都是成员变量修饰符，它们说明如下：

1.  public、protected和private修饰符用于封装成员变量。
2.  static修饰符用于声明静态变量，所以静态变量也称为“类变量”。
3.  final修饰符用于声明变量，该变量不能被修改。

下面看一个声明成员变量示例：

```java
// Animal.java
public class Animal extends Object {

	//动物年龄
	int age = 1;
	//动物性别
	public boolean sex = false;
	//动物体重
	private double weight = 0.0;	
	
}
```

上述代码中没有展示静态变量声明，有关静态变量稍后会详细介绍。

### 10.3.3 成员方法

声明类体中成员方法语法格式如下：

```java
class className {

	    [public | protected | private ] [static] [final | abstract] [native] [synchronized] 
				type methodName([paramList]) [throws exceptionList] {
      		      //方法体
       }
}
```

其中type是方法返回值数据类型，methodName是方法名。type前的关键字都是方法修饰符，它们说明如下：

1.  public、protected和private修饰符用于封装方法。
2.  static修饰符用于声明静态方法，所以静态方法也称为“类方法”。
3.  final | abstract不能同时修饰方法，final修饰的方法不能在子类中被覆盖；abstract用来修饰抽象方法，抽象方法必须在子类中被实现。
4.  native修饰的方法，称为“本地方法”，本地方法调用平台本地代码（如：C或C++编写的代码），不能实现跨平台。
5.  synchronized修饰的方法是同步的，当多线程方式同步方法时，只能串行地执行，保证是线程安全的。

方法声明中还有([paramList])部分，它是方法的参数列表。throws exceptionList是声明抛出异常列表。

下面看一个声明方法示例：
```java
public class Animal {// extends Object {

	//动物年龄
	int age = 1;
	//动物性别
	public boolean sex = false;
	//动物体重
	private double weight = 0.0;
	
	public void eat() { ①
		 // 方法体
		return;	②
	}

	int run() { ③
		// 方法体
		return 10; ④
	}

	protected int getMaxNumber(int number1, int number2) { ⑤
		// 方法体
		if (number1 > number2) {		
			return number1; ⑥
		}
		return number2;
	}
}

```

上述代码第①、③、⑤行声明了三个方法。方法在执行完毕后把结果返还给它的调用者，方法体包含“return 返回结果值;”语句，见代码第④行的“return 10;”，“返回结果值”数据类型与方法的返回值类型要匹配。如果方法返回值类型为void时，方法体包含“return;”语句，见代码第②行，如果“return;”语句是最后一行则可以省略。

**提示 通常return语句通常用在一个方法体的最后，否则会产生编译错误，除非用在if-else语句中，见代码第⑥行。**