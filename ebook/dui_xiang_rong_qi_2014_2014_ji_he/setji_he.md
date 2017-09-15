## 15.3 Set集合

Set集合是由一串无序的，不能重复的相同类型元素构成的集合。图15-3是一个班级的Set集合。这个Set集合中有一些学生，这些学生是无序的，不能通过类似于List集合的序号访问，而且不能有重复的同学。

![15-3](..../assets/15-3.jpg)

图15-3　Set集合

**提示 List集合中的元素是有序的、可重复的，而Set集合中的元素是无序的、不能重复的。List集合强调的是有序，Set集合强调的是不重复。当不考虑顺序，且没有重复元素时，Set集合和List集合可以互相替换的。**

Set接口直接实现类主要是HashSet，HashSet是基散列表数据结构的实现。

### 15.3.1 常用方法

Set接口也继承自Collection接口，Set接口中大部分都是继承自Collection接口，这些方法如下。

#####1.  操作元素

*   add(Object element)：在Set集合的尾部添加指定的元素。该方法是从Collection集合继承过了的。
*   remove(Object element)：如果Set集合中存在指定元素，该方法是从Collection集合继承过了的。
*   clear()：从Set集合中移除所有元素。该方法是从Collection集合继承过了的。

#####2.  判断元素

*   isEmpty()：判断Set集合中是否有元素，没有返回true，有返回false。该方法是从Collection集合继承过了的。
*   contains(Object element)：判断Set集合中是否包含指定元素，包含返回true，不包含返回false。该方法是从Collection集合继承过了的。

#####3.  其他

*   iterator()：返回迭代器（Iterator）对象，迭代器对象用于遍历集合。该方法是从Collection集合继承下来的。
*   size()：返回Set集合中的元素数，返回值是int类型。该方法是从Collection集合继承下来的。

示例代码如下：

```java
//HelloWorld.java文件
package com.a51work6;

import java.util.HashSet;
import java.util.Set;

public class HelloWorld {

	public static void main(String[] args) {

		Set set = new HashSet(); ①

		String b = "B";

		// 向集合中添加元素
		set.add("A");
		set.add(b); ②
		set.add("C");
		set.add(b);  ③
		set.add("D");
		set.add("E");

		// 打印集合元素个数
		System.out.println("集合size = " + set.size()); ④
		// 打印集合
		System.out.println(set);

		// 删除集合中第一个"B"元素
		set.remove(b);
		// 判断集合中是否包含"B"元素
		System.out.println("是否包含\"B\"：" + set.contains(b));
		// 判断集合是否为空
		System.out.println("set集合是空的：" + set.isEmpty());

		// 清空集合
		set.clear();
		System.out.println(set);
	}
}
```

运行结果：

	集合size = 5
	[A, B, C, D, E]
	是否包含"B"：false
	set集合是空的：false
	[]
	

代码第①行声明Set类型集合变量set，使用HashSet类实例化set，Set是接口不能实例化。添加集合元素时试图添加重复的元素，见代码第②行和第③行，但是Set集合不能添加重复元素，所有代码第④行打印集合元素个数是5。

### 15.3.2 遍历集合

Set集合中的元素由于没有序号，所以不能使用for循环进行遍历，但可以使用for-each循环和迭代器进行遍历。事实上这两种遍历方法也是继承自Collection集合，也就是说所有的Collection集合类型都有这两种遍历方式。

示例代码如下：

```java
//HelloWorld.java文件
package com.a51work6;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HelloWorld {

	public static void main(String[] args) {

		Set set = new HashSet();

		String b = "B";
		// 向集合中添加元素
		set.add("A");
		set.add(b);
		set.add("C");
		set.add(b);
		set.add("D");
		set.add("E");

		// 1.使用for-each循环遍历
		System.out.println("--1.使用for-each循环遍历--");
		for (Object item : set) {
			String s = (String) item;
			System.out.println("读取集合元素: " + s);
		}

		// 2.使用迭代器遍历
		System.out.println("--2.使用迭代器遍历--");
		Iterator it = set.iterator();
		while (it.hasNext()) {
			Object item = it.next();
			String s = (String) item;
			System.out.println("读取集合元素: " + s);
		}
	}
}

```
上述代码采用两种方法遍历Set集合，具体实现与List集合完全一样，这里不再赘述。