## 15.4 Map集合

Map（映射）集合表示一种非常复杂的集合，允许按照某个键来访问元素。Map集合是由两个集合构成的，一个是键（key）集合，一个是值（value）集合。键集合是Set类型，因此不能有重复的元素。而值集合是Collection类型，可以有重复的元素。Map集合中的键和值是成对出现的。

图15-4所示是Map类型的“国家代号”集合。键是国家代号集合，不能重复。值是国家集合，可以重复。

![15-4](.../assets/15-4.jpeg)

图15-4 Map集合

提示 Map集合更适合通过键快速访问值，就像查英文字典一样，键就是要查的英文单词，而值是英文单词的翻译和解释等。有的时候，一个英文单词会对应多个翻译和解释，这是与Map集合特性对应的。

Map接口直接实现类主要是HashMap，HashMap是基散列表数据结构的实现。

### 15.4.1 常用方法

Map集合中包含两个集合（键和值），所以操作起来比较麻烦，Map接口提供很多方法用来管理和操作集合。主要的方法如下。

#####1.  操作元素

*   get(Object key)：返回指定键所对于的值；如果Map集合中不包含该键值对，则返回null。
*   put(Object key, Object value)：指定键值对添加到集合中。
*   remove(Object key)：移除键值对。
*   clear()：移除Map集合中所有键值对。

#####2.  判断元素

*   isEmpty()：判断Map集合中是否有键值对，没有返回true，有返回false。
*   containsKey(Object key)：判断键集合中是否包含指定元素，包含返回true，不包含返回false。
*   containsValue(Object value)：判断值集合中是否包含指定元素，包含返回true，不包含返回false。

#####3.  查看集合

*   keySet()：返回Map中的所有键集合，返回值是Set类型。
*   values()：返回Map中的所有值集合，返回值是Collection类型。
*   size()：返回Map集合中键值对数。

示例代码如下：


```java
//HelloWorld.java文件
package com.a51work6;

import java.util.HashMap;
import java.util.Map;

public class HelloWorld {

	public static void main(String[] args) {

		Map map = new HashMap();①

		map.put(102, "张三");
		map.put(105, "李四"); ②
		map.put(109, "王五");
		map.put(110, "董六");
		//"李四"值重复
		map.put(111, "李四"); ③
		//109键已经存在，替换原来值"王五"
		map.put(109, "刘备"); ④


		// 打印集合元素个数
		System.out.println("集合size = " + map.size());
		// 打印集合
		System.out.println(map);

		// 通过键取值
		System.out.println("109 - " + map.get(109)); ⑤
		System.out.println("108 - " + map.get(108)); ⑥

		// 删除键值对
		map.remove(109);
		// 判断键集合中是否包含109
		System.out.println("键集合中是否包含109："：" + map.containsKey(109));
		// 判断值集合中是否包含 "李四"
		System.out.println("值集合中是否包含：" + map.containsValue("李四"));

		// 判断集合是否为空
		System.out.println("集合是空的：" + map.isEmpty());

		// 清空集合
		map.clear();
		System.out.println(map);
	}
}
```


运行结果如下：

	集合size = 5
	{102=张三, 105=李四, 109=王五, 110=董六, 111=刘备}
	109 - 王五
	108 - null
	是否包含"B"：false
	值集合中是否包含：true
	集合是空的：false
	{}


代码第①行声明Map类型集合变量map，使用HashMap类实例化map，Map是接口不能实例化。Map集合添加键值对时候需要注意两个问题：第一，如果键已经存在，则会替换原有值，见代码第④行是109键原来对应的是&quot;王五&quot;，该语句会替换为&quot;刘备&quot;；第二，如果这个值已经存在，则不会替换，见代码第②行和第③行，添加了两个相同的值&quot;李四&quot;。

代码第⑤行和第⑥行是通过键取对应的值，如果不存在键值对，则返回null，代码第⑥行的108键对应的值不存在，所有这里打印的null。

### 15.4.2 遍历集合

Map集合遍历与List和Set集合不同，Map有两个集合，因此遍历过程可以只遍历值的集合，也可以只遍历键的集合，也可以同时遍历。这些遍历过程都可以使用for-each循环和迭代器进行遍历。

示例代码如下：


```java
//HelloWorld.java文件
package com.a51work6;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HelloWorld {

	public static void main(String[] args) {

		Map map = new HashMap();

		map.put(102, "张三");
		map.put(105, "李四");
		map.put(109, "王五");
		map.put(110, "董六");
		map.put(111, "李四");

		// 1.使用for-each循环遍历
		System.out.println("--1.使用for-each循环遍历--");
		// 获得键集合
		Set keys = map.keySet(); ①
		for (Object key : keys) {
			int ikey = (Integer) key; // 自动拆箱 ②
			String value = (String) map.get(ikey); // 自动装箱 ③
			System.out.printf("key=%d - value=%s \n", ikey, value);
		}

		// 2.使用迭代器遍历
		System.out.println("--2.使用迭代器遍历--");
		// 获得值集合
		Collection values = map.values(); ④
		// 遍历值集合
		Iterator it = values.iterator();
		while (it.hasNext()) {
			Object item = it.next();
			String s = (String) item;
			System.out.println("值集合元素: " + s);
		}

	}
}
```

上述代码第①行是获得键集合，返回是Set类型。在遍历键时，从集合里取出的元素类型都是Object，代码第②行是将key强制类型转换为Integer，然后又赋值给int整数，这个过程发生了自动拆箱。代码第③行是通过键获得对应的值。

代码第④行是获得值集合，它是Collection类型。遍历Collection集合与Set集合一样，这里不再赘述。