## 10.4 包

在程序代码中给类起一个名字是非常重要的，但是有时候会出现非常尴尬的事情，名字会发生冲突，例如：项目中自定义了一个日期类，我为它取名为Date，但是会发现Java SE核心库中还有两个Date，它们分别位于java.util包和java.sql包中。

### 10.4.1 包作用

在Java中为了防止类、接口、枚举和注释等命名冲突引用了包（package）概念，包本质上命名空间（namespace）[^9]。在包中可以定义一组相关的类型（类、接口、枚举和注释），并为它们提供访问保护和命名空间管理。

在前面提到的Date类名称冲突问题，很好解决，将不同Date类放到不同的包中，我们自定义Date，可以放到自己定义的包com.a51work6中，这样就不会与java.util包和java.sql包中Date发生冲突问题了。

### 10.4.2 包定义

Java中使用package语句定义包，package语句应该放在源文件的第一行，在每个源文件中只能有一个包定义语句，并且package语句适用于所有类型（类、接口、枚举和注释）的文件。定义包语法格式如下：
```java
package pkg1[.pkg2[.pkg3…]];
```
pkg1~ pkg3都是组成包名一部分，之间用点（.）连接，它们命名应该是合法的标识符，其次应该遵守Java包命名规范，即全部小写字母。

定义包示例代码如下：
```java
// Date.java文件
package com.a51work6;

public class Date {

}
```
com.a51work6是自定义的包名，包名一般是公司域名的倒置。

**提示 我们公司的域名是51work6.com，倒置后是com.51work6，其中51work6是非法标识符（不能用数字开头），所以com.51work6包名是非法的，于是将包名改为com.a51work6。**

如果在源文件中没有定义包，那么类、接口、枚举和注释类型文件将会被放进一个无名的包中，也称为默认包。

定义好包后，包采用层次结构管理这些类型（类、接口、枚举和注释），如图10-1所示是在Eclipse包资源视图中查看包，可见有默认包和com.a51work6包。如果文件系统中查看这些包，会发现如同10-2所示的层次结构，源文件目录是根目录，也是默认包目录，可见其中有一个HelloWorld.java文件。com是文件夹，a51work6子文件夹，在a51work6中包含：Animal.java和Date.java两个文件。Java编译器把包对应于文件系统的目录管理，不仅是源文件，编译之后的字节码文件也采用文件系统的目录管理的。

![10-1](.../assets/10-1.jpg)

图10-1　Eclipse包资源视图中查看包

![10-2](.../assets/10-2.jpg)

图10-2　文件系统目录与包

### 10.4.3 包引入

为了能够使用一个包中类型（类、接口、枚举和注释），需要在Java程序中明确引入该包。使用import语句实现引入包，import语句应位于package语句之后，所有类的定义之前，可以有0~n条import语句，其语法格式为：
```java
import package1[.package2…].(类型名|*);
```
“包名.类型名”形式只引入具体类型，“包名.*”采用通配符，表示引入这个包下所有的类型。但从编程规范的角度提倡明确引入类型名，即“包名.类型名”形式可以提高程序的可读性。

如果需要在程序代码中使用com.a51work6包中Date类。示例代码如下：

```java

// HelloWorld.java文件
import com.a51work6.Date;	①

public class HelloWorld {

	public static void main(String[] args) {
		
		Date date = new Date(); ②
		System.out.println(date);
	}
}

```

上述代码第②行使用了Date类，需要引入Date所在的包，见代码第①行，import是关键字，代码第①行的import语句采用“包名.类型名”形式。

**提示 如果在一个源文件中引入两个相同包名+类型名，见如下代码，代码第②行会发生编译错误。为避免这个编译错误，可以在没有引入包的类型名前加上包名，详见如下代码第②行中的java.util.Date。**

```java
// HelloWorld.java文件
import com.a51work6.Date;
//import java.util.Date;  ①

public class HelloWorld {

	public static void main(String[] args) {		
		Date date = new Date();		
		System.out.println(date);
		java.util.Date now = new java.util.Date(); ②
		System.out.println(now);
		
	}
}
```

**注意 当前源文件与要使用的类型（类、接口、枚举和注释）在同一个包中，可以不用引入包。**

### 10.4.4 常用包

Java SE提供一些常用包，其中包含了Java开发中常用的基础类。这些包有：java.lang、java.io、java.net、java.util、java.text、java.awt和javax.swing。

#####1.  java.lang包

java.lang包含中包含了Java语言的核心类，如Object、Class、String、包装类和Math等，还有包装类Boolean、Character、Integer、Long、Float和Double。使用java.lang包中的类型，不需要显示使用import语句引入，它是由解释器自动引入。

#####2.  java.io包

java.io包含中提供多种输入/输出流类，如InputStream、OutputStream、Reader和Writer。还有文件管理相关类和接口，如File和FileDescriptor类以及FileFilter接口。

#####3.  java.net包

java.net包含进行网络相关的操作的类，如URL、Socket和ServerSocket等。

#####4.  java.util包

java.util包含一些实用工具类和接口，如集合、日期和日历相关类和接口。

#####5.  java.text包

java.text包中提供文本处理、日期式化和数字格式化等相关类和接口。

#####6.  java.awt和javax.swing包

java.awt和javax.swing包提供了Java图形用户界面开发所需要的各种类和接口。java.awt提供是一些基础类和接口，javax.swing提供了一些高级组件。

[^9]: 命名空间，也称名字空间、名称空间等，它表示着一个标识符（identifier）的可见范围。一个标识符可在多个命名空间中定义，它在不同命名空间中的含义是互不相干的。这样，在一个新的命名空间中可定义任何标识符，它们不会与任何已有的标识符发生冲突，因为已有的定义都处于其他命名空间中。 ——引自于 维基百科 https://zh.wikipedia.org/wiki/命名空间