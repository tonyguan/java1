## 9.4 可变字符串

可变字符串在追加、删除、修改、插入和拼接等操作不会产生新的对象。

### 9.4.1 StringBuffer和StringBuilder

Java提供了两个可变字符串类StringBuffer和StringBuilder，中文翻译为“字符串缓冲区”。

StringBuffer是线程安全的，它的方法是支持线程同步[^8]，线程同步会操作串行顺序执行，在单线程环境下会影响效率。StringBuilder是StringBuffer单线程版本，Java 5之后发布的，它不是线程安全的，但它的执行效率很高。

StringBuffer和StringBuilder具有完全相同的API，即构造方法和方法等内容一样。StringBuilder的中构造方法有4个：

*   StringBuilder()：创建字符串内容是空的StringBuilder对象，初始容量默认为16个字符。
*   StringBuilder(CharSequence seq)：指定CharSequence字符串创建StringBuilder对象。CharSequence接口类型，它的实现类有：String、StringBuffer和StringBuilder等，所以参数seq可以是String、StringBuffer和StringBuilder等类型。
*   StringBuilder(int capacity)：创建字符串内容是空的StringBuilder对象，初始容量由参数capacity指定的。
*   StringBuilder(String str)：指定String字符串创建StringBuilder对象。

上述构造方法同样适合于StringBuffer类，这里不再赘述。

**提示 字符串长度和字符串缓冲区容量区别。字符串长度是指在字符串缓冲区中目前所包含字符串长度，通过length()获得；字符串缓冲区容量是缓冲区中所能容纳的最大字符数，通过capacity()获得。当所容纳的字符超过这长度时，字符串缓冲区自动扩充容量，但这是以牺牲新能为代价的扩容。**

字符串长度和字符串缓冲区容量示例代码如下：

```java
// 字符串长度length和字符串缓冲区容量capacity
StringBuilder sbuilder1 = new StringBuilder();
System.out.println("包含的字符串长度：" + sbuilder1.length());
System.out.println("字符串缓冲区容量：" + sbuilder1.capacity());

StringBuilder sbuilder2 = new StringBuilder("Hello");
System.out.println("包含的字符串长度：" + sbuilder2.length());
System.out.println("字符串缓冲区容量：" + sbuilder2.capacity());

// 字符串缓冲区初始容量是16，超过之后会扩容
StringBuilder sbuilder3 = new StringBuilder();
for (int i = 0; i < 17; i++) {
    sbuilder3.append(8);
}
System.out.println("包含的字符串长度：" + sbuilder3.length());
System.out.println("字符串缓冲区容量：" + sbuilder3.capacity());
```

输出结果：

    包含的字符串长度：0
    字符串缓冲区容量：16
    包含的字符串长度：5
    字符串缓冲区容量：21
    包含的字符串长度：17
    字符串缓冲区容量：34
    

### 9.4.2 字符串追加

StringBuilder在提供了很多修改字符串缓冲区的方法，追加、插入、删除和替换等，这一节先介绍字符串追加方法。字符串追加方法是append，append有很多重载方法，可以追加任何类型数据，它的返回值还是StringBuilder。StringBuffer的追加法与StringBuffer完全一样，这里不再赘述。

字符串追加示例代码如下：

```java
//添加字符串、字符
StringBuilder sbuilder1 = new StringBuilder("Hello");	①
sbuilder1.append(" ").append("World");			②
sbuilder1.append('.');							③
System.out.println(sbuilder1);

StringBuilder sbuilder2 = new StringBuilder();
Object obj = null;
//添加布尔值、转义符和空对象
sbuilder2.append(false).append('\t').append(obj);	④
System.out.println(sbuilder2);

//添加数值
StringBuilder sbuilder3 = new StringBuilder();
for (int i = 0; i < 10; i++) {
	sbuilder3.append(i); 	
} 
System.out.println(sbuilder3);
```

运行结果：

    Hello World.
    false	null
    0123456789

上述代码第①行是创建一个包含Hello字符串StringBuilder对象。代码第②行是两次连续调用append方法，由于所有的append方法都返回StringBuilder对象，所有可以连续调用该方法，这种写法比较简洁。如果连续调用append方法不行喜欢，可以append方法占一行，见代码第③行。

代码第④行连续追加了布尔值、转义符和空对象，需要注意的是布尔值false转换为false字符串，空对象null也转换为&quot;null&quot;字符串。

### 9.4.3 字符串插入、删除和替换

StringBuilder中实现插入、删除和替换等操作的常用方法说明如下：

*   StringBuilder insert(int offset, String str)：在字符串缓冲区中索引为offset的字符位置之前插入str，insert有很多重载方法，可以插入任何类型数据。
*   StringBuffer delete(int start, int end)：在字符串缓冲区中删除子字符串，要删除的子字符串从指定索引start开始直到索引end - 1处的字符。start和end两个参数与substring(int beginIndex, int endIndex)方法中的两个参数含义一样。
*   StringBuffer replace(int start, int end, String str)字符串缓冲区中用str替换子字符串，子字符串从指定索引start开始直到索引end - 1处的字符。start和end同delete(int start, int end)方法。

以上介绍的方法虽然是StringBuilder方法，但StringBuffer也完全一样，这里不再赘述。

示例代码如下：

```java
// 原始不可变字符串
String str1 = "Java C";
// 从不可变的字符创建可变字符串对象
StringBuilder mstr = new StringBuilder(str1);

// 插入字符串
mstr.insert(4, " C++"); ①
System.out.println(mstr);

// 具有追加效果的插入字符串
mstr.insert(mstr.length(), " Objective-C");	②
System.out.println(mstr);

// 追加字符串
mstr.append(" and Swift");
System.out.println(mstr);

// 删除字符串
mstr.delete(11, 23);	③
System.out.println(mstr);

```

运行输出结果：

    Java C++ C
    Java C++ C Objective-C
    Java C++ C Objective-C and Swift
    Java C++ C and Swift
    

上述代码第①行mstr.insert(4, &quot; C++&quot;)是在索引4，插入字符串，原始字符串索引如同9-7所示，索引4位置是一个空格，在它之前插入字符串。代码第②行mstr.insert(mstr.length(), &quot; Objective-C&quot;)是按照字符串的长的插入，也就是在尾部追加字符串。在执行代码第③行删除字符串之前的字符串如图9-8所示，mstr.delete(11, 23)语句是要删除&quot;Objective-C &quot;子字符串，第一个参数是子字符串开始索引11；第二个参数是23，结束字符的索引是22（end - 1），所以参数end是23。

![9-7](..../assets/9-7.jpg)
图9-7　原始字符串索引

![9-8](..../assets/9-8.jpg)
图9-8　删除之前字符串索引

[^8]: 线程同步是一个多线程概念，就是当多个线程访问一个方法时，只能由一个优先级别高的线程先访问，在访问期间会锁定该方法，其他线程只能等到它访问完成释放锁，才能访问。有关多线程问题将在后面章节详细介绍。