## 14.3 捕获异常

在学习本内容之前，你先考虑一下，在现实生活中是如何对待领导交给你的任务呢？当然无非是两种：自己有能解决的自己处理；自己无力解决的反馈给领导，让领导自己处理。

那么对待受检查异常亦是如此。当前方法有能力解决，则捕获异常进行处理；没有能力解决，则抛出给上层调用方法处理。如果上层调用方法还无力解决，则继续抛给它的上层调用方法，异常就是这样向上传递直到有方法处理它，如果所有的方法都没有处理该异常，那么JVM会终止程序运行。

这一节先介绍一下捕获异常。

### 14.3.1 try-catch语句

捕获异常是通过try-catch语句实现的，最基本try-catch语句语法如下：


```java
try{
    //可能会发生异常的语句
} catch(Throwable e){
    //处理异常e
} 

```


#####1.  try代码块

try代码块中应该包含执行过程中可能会发生异常的语句。一条语句是否有可能发生异常，这要看语句中调用的方法。例如日期格式化类DateFormat的日期解析方法parse()，该方法的完整定义如下：

public Date parse(String source) throws ParseException

方法后面的throws ParseException说明：当调用parse()方法时有可以能产生ParseException异常。

提示 静态方法、实例方法和构造方法都可以声明抛出异常，凡是抛出异常的方法都可以通过try-catch进行捕获，当然运行时异常可以不捕获。一个方法声明抛出什么样的异常需要查询API文档。

#####2.  catch代码块

每个try代码块可以伴随一个或多个catch代码块，用于处理try代码块中所可能发生的多种异常。catch(Throwable e)语句中的e是捕获异常对象，e必须是Throwable的子类，异常对象e的作用域在该catch代码块中。

下面看看一个try-catch示例：

```java
//HelloWorld.java文件
package com.a51work6;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloWorld {

	public static void main(String[] args) {
		Date date = readDate();
		System.out.println("日期  = " + date);
	}

	// 解析日期
	public static Date readDate() {				①

		try {
			String str = "2018-8-18";	 //"201A-18-18"	
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");	
			// 从字符串中解析日期
			Date date = df.parse(str);				②
			return date;
		} catch (ParseException e) {				③
			System.out.println("处理ParseException…");
			e.printStackTrace();					④
		}
		return null;
	}
}

```

上述代码第①行定义了一个静态方法用来将字符串解析成日期，但并非所有的字符串都是有效的日期字符串，因此调用代码第②行的解析方法parse()有可能发生ParseException异常，ParseException是受检查异常，在本例中使用try-catch捕获。代码第③行的e就是ParseException对象。代码第④行e.printStackTrace()是打印异常堆栈跟踪信息，本例中的&quot;2018-8-18&quot;字符串是有个有效的日期字符串，因此不会发生异常。如果将字符串改为无效的日期字符串，如&quot;201A-18-18&quot;，则会打印信息。

	处理ParseException
	
	java.text.ParseException: Unparseable date: &quot;201A-18-18&quot;
	
	日期 = null
	
	at java.text.DateFormat.parse(Unknown Source)
	
	at com.a51work6.HelloWorld.readDate(HelloWorld.java:24)
	
	at com.a51work6.HelloWorld.main(HelloWorld.java:13)

**提示 在捕获到异常之后，通过e.printStackTrace()语句打印异常堆栈跟踪信息，往往只是用于调试，给程序员提示信息。堆栈跟踪信息对最终用户是没有意义的，本例中如果出现异常很有可能是用户输入的日期无效，捕获到异常之后给用户弹出一个对话框，提示用户输入日期无效，请用户重新输入，用户重新输入后再重新调用上述方法。这才是捕获异常之后的正确处理方案。
**

### 14.3.2 多catch代码块

如果try代码块中有很多语句会发生异常，而且发生的异常种类又很多。那么可以在try后面跟有多个catch代码块。多catch代码块语法如下：

```java

try{
	//可能会发生异常的语句
} catch(Throwable e){
	//处理异常e
} catch(Throwable e){
	//处理异常e
} catch(Throwable e){
	//处理异常e
}
```

在多个catch代码情况下，当一个catch代码块捕获到一个异常时，其他的catch代码块就不再进行匹配。

**注意 当捕获的多个异常类之间存在父子关系时，捕获异常顺序与catch代码块的顺序有关。一般先捕获子类，后捕获父类，否则子类捕获不到。**

示例代码如下：


```java
//HelloWorld.java文件
package com.a51work6;
...
public class HelloWorld {

	public static void main(String[] args) {
		Date date = readDate();
		System.out.println("读取的日期  = " + date);
	}

	public static Date readDate() {

		FileInputStream readfile = null;
		InputStreamReader ir = null;
		BufferedReader in = null;
		try {
			readfile = new FileInputStream("readme.txt"); ①
			ir = new InputStreamReader(readfile);	
			in = new BufferedReader(ir); 					
			// 读取文件中的一行数据
			String str = in.readLine(); ②
			if (str == null) {
				return null;
			}

			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date date = df.parse(str);  ③
			return date;

		} catch (FileNotFoundException e) { ④
			System.out.println("处理FileNotFoundException...");
			e.printStackTrace();
		} catch (IOException e) { ⑤
			System.out.println("处理IOException...");
			e.printStackTrace();
		} catch (ParseException e) { ⑥
			System.out.println("处理ParseException...");
			e.printStackTrace();
		}
		return null;
	}
}
```

上述代码通过Java I/O（输入输出）流技术从文件readme.txt中读取字符串，然后解析成为日期。由于Java I/O技术还没有介绍，读者先不要关注I/O技术细节，这考虑调用它们的方法会发生异常就可以了。

在try代码块中第①行代码调用FileInputStream构造方法可以会发生FileNotFoundException异常。第②行代码调用BufferedReader输入流的readLine()方法可以会发生IOException异常。从图14-1可见FileNotFoundException异常是IOException异常的子类，应该先FileNotFoundException捕获，见代码第④行；后捕获IOException，见代码第⑤行。

如果将FileNotFoundException和IOException捕获顺序调换，代码如下：


```java
try{
	//可能会发生异常的语句
} catch (IOException e) {
	// IOException异常处理
} catch (FileNotFoundException e) {
	// FileNotFoundException异常处理
}
```

那么第二个catch代码块永远不会进入，FileNotFoundException异常处理永远不会执行。

由于上述代码第⑥行ParseException异常与IOException和FileNotFoundException异常没有父子关系，捕获ParseException异常位置可以随意放置。

### 14.3.3 try-catch语句嵌套

Java提供的try-catch语句嵌套是可以任意嵌套，修改14.3.2节示例代码如下：


```java
//HelloWorld.java文件
package com.a51work6;
...
public class HelloWorld {

	public static void main(String[] args) {
		Date date = readDate();
		System.out.println("读取的日期  = " + date);
	}

	public static Date readDate() {

		FileInputStream readfile = null;
		InputStreamReader ir = null;
		BufferedReader in = null;
		try {
			readfile = new FileInputStream("readme.txt");
			ir = new InputStreamReader(readfile);
			in = new BufferedReader(ir);

			try {    ①
				String str = in.readLine(); ②
				if (str == null) {
					return null;
				}

				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date date = df.parse(str); ③
				return date;
				
			} catch (ParseException e) {
				System.out.println("处理ParseException...");
				e.printStackTrace();
			}	 ④

		} catch (FileNotFoundException e) { ⑤
			System.out.println("处理FileNotFoundException...");
			e.printStackTrace();
		} catch (IOException e) { ⑥
			System.out.println("处理IOException...");
			e.printStackTrace();
		}
		return null;
	}
}
```


上述代码第①~④行是捕获ParseException异常try-catch语句，可见这个try-catch语句就是嵌套在捕获IOException和FileNotFoundException异常的try-catch语句中。

程序执行时内层如果会发生异常，首先由内层catch进行捕获，如果捕获不到，则由外层catch捕获。例如：代码第②行的readLine()方法可能发生IOException异常，该异常无法被内层catch捕获，最后被代码第⑥行的外层catch捕获。

**注意 try-catch不仅可以嵌套在try代码块中，还可以嵌套在catch代码块或finally代码块，finally代码块后面会详细介绍。try-catch嵌套会使程序流程变的复杂，如果能用多catch捕获的异常，尽量不要使用try-catch嵌套。特别对于初学者不要简单地使用Eclipse的语法提示不加区分地添加try-catch嵌套，要梳理好程序的流程再考虑try-catch嵌套的必要性。**

### 14.3.4 多重捕获

多catch代码块客观上提高了程序的健壮性，但是程序代码量大大增加。如果有些异常虽然种类不同，但捕获之后的处理是相同的，看如下代码。


```java

try{
	//可能会发生异常的语句
} catch (FileNotFoundException e) {
	//调用方法methodA处理
} catch (IOException e) {
	//调用方法methodA处理
} catch (ParseException e) {
	//调用方法methodA处理
}
```

三个不同类型的异常，要求捕获之后的处理都是调用methodA方法。是否可以把这些异常合并处理，Java 7推出了多重捕获（multi-catch）技术，可以帮助解决此类问题，上述代码修改如下：

```java
try{
	//可能会发生异常的语句
} catch (IOException | ParseException e) {
	//调用方法methodA处理
}
```

在catch中多重捕获异常用“|”运算符连接起来。

**注意 有的读者会问什么不写成FileNotFoundException | IOException | ParseException 呢？这是因为由于FileNotFoundException属于IOException异常，IOException异常可以捕获它的所有子类异常了。**