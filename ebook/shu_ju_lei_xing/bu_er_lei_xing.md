## 5.6 布尔类型

在Java语言中声明布尔类型的关键字是boolean，它只有两个值：true和false。

提示 在C语言中布尔类型是数值类型，它有两个取值：1和0。而在Java中的布尔类型取值不能用1和0替代，也不属于数值类型，不能与int等数值类型之间进行数学计算或类型转化。

示例代码如下：

```java
boolean isMan = true;
boolean isWoman = false;
```
如果试图给它们赋值true和false之外的常量，如下所示。

```java
boolean isMan = 1;
boolean isWoman = 'A';
```

则发生类型不匹配编译错误。