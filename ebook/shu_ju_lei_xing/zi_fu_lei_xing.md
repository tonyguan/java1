## 5.5 字符类型

字符类型表示单个字符，Java中char声明字符类型，Java中的字符常量必须用单引号括起来的单个字符，如下所示：

```java
char c = 'A';
```

Java字符采用双字节Unicode编码，占两个字节（16位），因而可用十六进制（无符号的）编码形式表示，它们的表现形式是\un，其中n为16位十六进制数，所以&#039;A&#039;字符也可以用Unicode编码&#039;\u0041&#039;表示，如果对字符编码感兴趣可以到维基百科（https://zh.wikipedia.org/wiki/Unicode字符列表）查询。

示例代码如下：


```java
public class HelloWorld {

	public static void main(String[] args) {
		
		char c1 = 'A';		
		char c2 = '\u0041';	
		char c3 = '花';		
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
	}
}

```

上述代码变量c1和c2都是保存的&#039;A&#039;，所以输出结果如下：

	A
	A
	花
	
提示 字符类型也属于是数值类型，可以与int等数值类型进行数学计算或进行转换。这是因为字符类型在计算机中保存的是Unicode编码，双字节Unicode的存储范围在\u0000~\uFFFF，所以char类型取值范围0~2<sup>16</sup>-1。

在Java中，为了表示一些特殊字符，前面要加上反斜杠（\），这称为字符转义。常见的转义符的含义参见表5-3。

表 5-3 转义符

| **字符表示** | **Unicode编码** | **说　　明** |
| --- | --- | --- |
| \t | \u0009 | 水平制表符tab |
| \n | \u000a | 换行 |
| \r | \u000d | 回车 |
| \&quot; | \u0022 | 双引号 |
| \&#039; | \u0027 | 单引号 |
| \\ | \u005c | 反斜线 |

示例如下：

```java
//在Hello和World插入制表符
String specialCharTab1 = "Hello\tWorld.";
//在Hello和World插入制表符，制表符采用Unicode编码\u0009表示
String specialCharTab2 = "Hello\u0009World.";
//在Hello和World插入换行符
String specialCharNewLine = "Hello\nWorld.";
//在Hello和World插入回车符
String specialCharReturn = "Hello\rWorld.";
//在Hello和World插入双引号
String specialCharQuotationMark = "Hello\"World\".";
//在Hello和World插入单引号
String specialCharApostrophe = "Hello\'World\'.";
//在Hello和World插入反斜杠
String specialCharReverseSolidus = "Hello\\World.";

System.out.println("水平制表符tab1: " + specialCharTab1);
System.out.println("水平制表符tab2: " + specialCharTab2);
System.out.println("换行: " + specialCharNewLine);
System.out.println("回车: " + specialCharReturn);
System.out.println("双引号: " + specialCharQuotationMark);
System.out.println("单引号: " + specialCharApostrophe);
System.out.println("反斜杠: " + specialCharReverseSolidus);	
```

输出结果如下：

	水平制表符tab1: Hello	World.
	水平制表符tab2: Hello	World.
	换行: Hello
	World.
	回车: Hello
	World.
	双引号: Hello"World".
	单引号: Hello'World'.
	反斜杠: Hello\World.
	