## 12.3 成员变量隐藏和方法覆盖

子类继承父类后，有子类中有可能声明了与父类一样的成员变量或方法，那么会出现什么情况呢？

### 12.3.1 成员变量隐藏

子类成员变量与父类一样，会屏蔽父类中的成员变量，称为“成员变量隐藏”。示例代码如下：


```java
//ParentClass.java文件
package com.a51work6;

class ParentClass {
    // x成员变量
    int x = 10;								①
}

class SubClass extends ParentClass {
	// 屏蔽父类x成员变量
    int x = 20;								②

    public void print() {
		// 访问子类对象x成员变量
		System.out.println("x = " + x);			③
		// 访问父类x成员变量
		System.out.println("super.x = " + super.x);	④
	}
}
```

调用代码如下：
	
```java
//HelloWorld.java文件
package com.a51work6;

public class HelloWorld {

	public static void main(String[] args) {
		//实例化子类SubClass
		SubClass pObj = new SubClass();
		//调用子类print方法
		pObj.print();
	}
}
```


运行结果如下：

	x = 20
	super.x = 10


上述代码第①行是在ParentClass类声明x成员变量，那么在它的子类SubClass代码第②行也声明了x成员变量，它会屏蔽父类中的x成员变量。那么代码第③行的x是子类中的x成员变量。如果要调用父类中的x成员变量，则需要super关键字，见代码第④行的super.x。

### 12.3.2 方法的覆盖（Override）

如果子类方法完全与父类方法相同，即：相同的方法名、相同的参数列表和相同的返回值，只是方法体不同，这称为子类覆盖（Override）父类方法。

示例代码如下：


```java
//ParentClass.java文件
package com.a51work6;

class ParentClass {
	// x成员变量
	int x;

	protected void setValue() {				①
		x = 10;
	}
}

class SubClass extends ParentClass {
	// 屏蔽父类x成员变量
	int x;

	@Override
	public void setValue() { // 覆盖父类方法		②
		// 访问子类对象x成员变量
		x = 20;
		// 调用父类setValue()方法
		super.setValue();			
	}

	public void print() {
		// 访问子类对象x成员变量
		System.out.println("x = " + x);
		// 访问父类x成员变量
		System.out.println("super.x = " + super.x);
	}
}
```


调用代码如下：


```java
//HelloWorld.java文件
package com.a51work6;

public class HelloWorld {

	public static void main(String[] args) {
		//实例化子类SubClass
		SubClass pObj = new SubClass();
		//调用setValue方法
		pObj.setValue();
		//调用子类print方法
		pObj.print();		
	}
}
```


运行结果如下：

	x = 20
	super.x = 10

上述代码第①行是在ParentClass类声明setValue方法，那么在它的子类SubClass代码第②行覆盖父类中的setValue方法，在声明方法时添加@Override注解，@Override注解不是方法覆盖必须的，它只是锦上添花，但添加@Override注解有两个好处：

1\. 提高程序的可读性。

2\. 编译器检查@Override注解的方法在父类中是否存在，如果不存在则报错。

**注意 方法重写时应遵循的原则：**

#####1.  覆盖后的方法不能比原方法有更严格的访问控制（可以相同）。例如将代码第②行访问控制public修改private，那么会发生编译错误，因为父类原方法是protected。
#####2.  覆盖后的方法不能比原方法产生更多的异常。