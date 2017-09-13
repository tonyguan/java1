## 14.5 throws与声明方法抛出异常

在一个方法中如果能够处理异常，则需要捕获并处理。但是本方法没有能力处理该异常，捕获它没有任何意义，则需要在方法后面声明抛出该异常，通知上层调用者该方法有可以发生异常。

方法后面声明抛出使用throws关键字，回顾一下10.3.3节成员方法语法格式如下：

```java
class className {
    [public | protected | private ] [static] [final | abstract] [native] [synchronized] type methodName([paramList]) [throws exceptionList] {
        //方法体
    }
}

```


其中参数列表之后的[throws exceptionList]语句是声明抛出异常。方法中可能抛出的异常（除了Error和RuntimeException及其子类外）都必须通过throws语句列出，多个异常之间采用逗号（,）分隔。

**注意 如果声明抛出的多个异常类之间有父子关系，可以只声明抛出父类。但如果没有父子关系情况下，最好明确声明抛出每一个异常，因为上层调用者会根据这些异常信息进行相应的处理。假如一个方法中有可能抛出IOException和ParseException两个异常，那么声明抛出IOException和ParseException呢？还是只声明抛出Exception呢？因为Exception是IOException和ParseException的父类，只声明抛出Exception从语法是允许的，但是声明抛出IOException和ParseException更好一些。**

如果将14.3节示例进行修改，在readDate()方法后声明抛出异常，代码如下：


```java
//HelloWorld.java文件
package com.a51work6;
...
public class HelloWorld {

	public static void main(String[] args) { ①

		try {
			Date date = readDate(); ②
			System.out.println("读取的日期  = " + date);
		} catch (IOException e) { ③
			System.out.println("处理IOException...");
			e.printStackTrace();
		} catch (ParseException e) { ④
			System.out.println("处理ParseException...");
			e.printStackTrace();
		}

	}

	public static Date readDate() throws IOException, ParseException { ⑤

		// 自动资源管理
		FileInputStream readfile = new FileInputStream("readme.txt");	⑥
		InputStreamReader ir = new InputStreamReader(readfile);		
		BufferedReader in = new BufferedReader(ir);				

		// 读取文件中的一行数据
		String str = in.readLine();  ⑦
		if (str == null) {
			return null;
		}

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = df.parse(str);   ⑧
		return date;
	}

}
```

由于readDate()方法中代码第⑥、⑦、⑧行都有可能引发异常。在readDate()方法内又没有捕获处理，所有需要在代码第⑤行方法后声明抛出异常，事实上有三个异常FileNotFoundException、IOException和ParseException，由于FileNotFoundException属于IOException异常，所以只声明IOException和ParseException就可以了。

一旦readDate()方法声明抛出了异常，那么它的调用者main()方法，也会面临同样的问题：要么捕获自己处理，要么抛出给上层调用者。如果一旦发生异常main()方法也选择抛出那么程序运行就会终止。本例中main()方法是捕获异常进行处理，捕获异常过程前面已经介绍过了，这里不再赘述。