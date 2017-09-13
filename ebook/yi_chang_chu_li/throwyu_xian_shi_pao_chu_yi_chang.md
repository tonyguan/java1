## 14.7 throw与显式抛出异常

Java异常相关的关键字中有两个非常相似，它们是throws和throw，其中throws关键字前面14.5节已经介绍了，throws用于方法后声明抛出异常，而throw关键字用来人工引发异常。本节之前读者接触到的异常都是由于系统生成的，当异常发生时，系统一个异常对象，并将其抛出。但也可以通过throw语句显式抛出异常，语法格式如下：

```java
throw Throwable或其子类的实例
```

所有Throwable或其子类的实例都可以通过throw语句抛出。

显式抛出异常目的有很多，例如不想某些异常传给上层调用者，可以捕获之后重新显式抛出另外一种异常给调用者。

修改14.4节示例代码如下：

```java
//HelloWorld.java文件
package com.a51work6;
… …
public class HelloWorld {

	public static void main(String[] args) {
		try {
			Date date = readDate();
			System.out.println("读取的日期  = " + date);
		} catch (MyException e) {
			System.out.println("处理MyException...");
			e.printStackTrace();
		}
	}

	public static Date readDate() throws MyException {		

		// 自动资源管理
		try (FileInputStream readfile = new FileInputStream("readme.txt");
				InputStreamReader ir = new InputStreamReader(readfile);
				BufferedReader in = new BufferedReader(ir)) {

			// 读取文件中的一行数据
			String str = in.readLine();
			if (str == null) {
				return null;
			}

			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date date = df.parse(str);
			return date;

		} catch (FileNotFoundException e) { ①
			throw new MyException(e.getMessage()); ②
		} catch (IOException e) { ③
			throw new MyException(e.getMessage()); ④
		} catch (ParseException e) {
			System.out.println("处理ParseException...");
			e.printStackTrace();
		}
		return null;
	}
}

```

如果软件设计者不希望readDate()方法中捕获的FileNotFoundException和IOException异常出现在main()方法（上层调用者）中，那么可以在捕获到FileNotFoundException和IOException异常时，通过throw语句显式抛出一个异常，见代码第②行和第④行throw new MyException(e.getMessage())语句，MyException是自定义的异常。

**注意 throw显式抛出的异常与系统生成并抛出的异常，在处理方式上没有区别，就是两种方法：要么捕获自己处理，要么抛出给上层调用者。在本例中是声明抛出，所以在readDate()方法后面要声明抛出MyException异常。**