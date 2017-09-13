## 4.1 标识符、关键字和保留字

任何一种计算机语言都离不开标识符和关键字，因此下面将详细介绍Java标识符、关键字和保留字。

### 4.1.1 标识符 {#-0}

标识符就是变量、常量、方法、枚举、类、接口等由程序员指定的名字。构成标识符的字母均有一定的规范，Java语言中标识符的命名规则如下：

1.  区分大小写：Myname与myname是两个不同的标识符。
2.  首字符，可以是下划线（_）或美元符或字母，但不能是数字；
3.  除首字符外其他字符，可以是下划线（_）、美元符、字母和数字。
4.  关键字不能作为标识符。

例如，身高、identifier、userName、User_Name、$Name、_sys_val等为合法的标识符，注意中文“身高”命名的变量是合法的；而2mail、room#和class为非法的标识符，注意#是非法字符，而class是关键字。
**
注意 Java语言中字母采用的是双字节Unicode编码<sup><sup id="596144984728568-footnote-ref-7"><a href="#596144984728568-footnote-7">[7]</a></sup></sup>。Unicode叫作统一编码制，它包含了亚洲文字编码，如中文、日文、韩文等字符。**

### 4.1.2 关键字 {#-1}

关键字是类似于标识符的保留字符序列，由语言本身定义好的，不能挪作他用，Java语言中有50个关键字，如表4-1所示。

表 4-1 Java关键字

| abstract | assert | boolean | break | byte |
| --- | --- | --- | --- | --- |
| case | catch | char | class | const |
| continue | default | do | double | else |
| enum | extends | final | finally | float |
| for | goto | if | implements | import |
| instanceof | int | interface | long | native |
| new | package | private | protected | public |
| return | strictfp | short | static | super |
| switch | synchronized | this | throw | throws |
| transient | try | void | volatile | while |

关键字很多这里不再一一介绍了，但是读者需要记住一点的是Java中的关键字全部是小写字母。

### 4.1.2 保留字 {#-2}

Java中有一些字符序列即不能当作标识符使用，也不是关键字，也不能在程序中使用，这些字符序列称为保留字。Java语言中的保留字只有两个goto和const：

1.  goto：在其他语言中叫做“无限跳转”语句，在Java语言中不再使用goto语句，因为“无限跳转”语句会破坏程序结构。在Java语言中goto的替换语句可以通过break、continue和return实现“有限跳转”。
2.  const：在其他语言中是声明常量关键字，在Java语言中声明常量使用public static final 方式声明。

[^7]: Unicode是国际组织制定的可以容纳世界上所有文字和符号的字符编码方案。