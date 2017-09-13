## 9.1 Java中的字符串

Java中的字符串是由双引号括起来的多个字符，下面示例都是表示字符串常量：

```java
"Hello World"															①
"\u0048\u0065\u006c\u006c\u006f\u0020\u0057\u006f\u0072\u006c\u0064"		②
"世界你好"																③
"A"																	④
""
```

Java中的字符采用Unicode编码，所以Java字符串可以包含中文等亚洲字符，见代码第③行的&quot;世界你好&quot;字符串。代码第②行的字符串是用Unicode编码表示的字符串，事实上它表示的也是&quot;Hello World&quot;字符串，可通过System.out.print方法将Unicode编码表示的字符串输出到控制台，则会看到Hello World字符串。

另外，单个字符如果用双引号括起来，那它表示的是字符串，而不是字符了，见代码第④行的&quot;A&quot;是表示字符串A，而不是字符A。

**注意 字符串还有一个极端情况，就代码第⑤行的&quot;&quot;表示空字符串，双引号中没有任何内容，空字符串不是null，空字符串是分配内存空间，而null是没有分配内存空间。

**Java SE提供了三个字符串类：String、StringBuffer和StringBuilder。String是不可变字符串，StringBuffer和StringBuilder是可变字符串。