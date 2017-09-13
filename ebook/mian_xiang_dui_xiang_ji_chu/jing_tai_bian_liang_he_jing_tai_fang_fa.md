## 10.7 静态变量和静态方法

有一个Account（银行账户）类，假设它有三个成员变量：amount（账户金额）、interestRate（利率）和owner（账户名）。在这三个成员变量中，amount和owner会因人而异，对于不同的账户这些内容是不同的，而所有账户的interestRate都是相同的。

amount和owner成员变量与账户个体有关，称为“实例变量”，interestRate成员变量与个体无关，或者说是所有账户个体共享的，这种变量称为“静态变量”或“类变量”。

静态变量和静态方法示例代码如下：

```java
// Account.java文件
package com.a51work6;

public class Account {

	// 实例变量账户金额
	double amount = 0.0;	①
	// 实例变量账户名
	String owner;		②

	// 静态变量利率
	static double interestRate = 0.0668;	③

	// 静态方法
	public static double interestBy(double amt) {	④
		//静态方法可以访问静态变量和其他静态方法
		return interestRate * amt; 	⑤
	}

	// 实例方法
	public String messageWith(double amt) {⑥
		//实例方法可以访问实例变量、实例方法、静态变量和静态方法
		double interest = Account.interestBy(amt);⑦
		StringBuilder sb = new StringBuilder();
		// 拼接字符串
		sb.append(owner).append("的利息是").append(interest);
		// 返回字符串
		return sb.toString();
	}
}

```

static修饰的成员变量是静态变量，见代码第③行。staitc修饰的方法是静态方法，见代码第④行。相反，没有static修饰的成员变量是实例变量，见代码第①行和第②行；没有staitc修饰的方法是实例方法，见代码第⑥行。

**注意 静态方法可以访问静态变量和其他静态方法，例如访问代码第⑤行中的interestRate静态变量。实例方法可以访问实例变量、其他实例方法、静态变量和静态方法，例如访问代码第⑦行interestBy静态方法。**

调用Account代码如下：

```java
// HelloWorld.java文件
package com.a51work6;

public class HelloWorld {

	public static void main(String[] args) {
		// 访问静态变量
		System.out.println(Account.interestRate);①
		// 访问静态方法
		System.out.println(Account.interestBy(1000));②

		Account myAccount = new Account();
		// 访问实例变量
		myAccount.amount = 1000000;③
		myAccount.owner = "Tony";④
		// 访问实例方法
		System.out.println(myAccount.messageWith(1000));⑤

		// 通过实例访问静态变量
		System.out.println(myAccount.interestRate);⑥
	}
}

```

调用静态变量或静态方法时，可以通过类名或实例名调用，代码第①行Account.interestRate通过类名调用静态变量，代码第②行Account.interestBy(1000)是通过类名调用静态方法。代码第⑥行是通过实例调用静态变量。