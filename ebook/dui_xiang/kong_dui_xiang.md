## 11.2 空对象

一个引用变量没有通过new分配内存空间，这个对象就是空对象，Java使用关键字null表示空对象。示例代码如下：

```java
String name = null;
name = "Hello World";
```

引用变量默认值是null。当试图调用一个空对象的实例变量或实例方法时，会抛出空指针异常NullPointerException，如下代码所示：

```java
String name = null;
//输出null字符串
System.out.println(name);
//调用length()方法
int len = name.length();		 ①
```

但是代码运行到第①行时，系统会抛出异常。这是因为调用length()方法时，name是空对象。程序员应该避免调用空对象的成员变量和方法，代码如下：

```java
//判断对象是否为null
if (name != null) {
    int len = name.length();
}
```

**提示 产生空对象有两种可能性：第一是程序员自己忘记了实例化，第二是空对象是别人传递给我们的。第一种程序员必须防止这种情况发生，应该仔细检查自己的代码，为自己创建的所有对象进行实例化并初始化。第二种情况需要通过判断对象非null进行避免。**