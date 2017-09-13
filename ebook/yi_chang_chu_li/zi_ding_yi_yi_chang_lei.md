## 14.6 自定义异常类

有些公司为了提高代码的可重用性，自己开发了一些Java类库或框架，其中少不了自己编写了一些异常类。实现自定义异常类需要继承Exception类或其子类，如果自定义运行时异常类需继承RuntimeException类或其子类。

实现自定义异常类示例代码如下：

```java
package com.a51work6;

public class MyException extends Exception { ①
    
    public MyException() { ②

    }
    public MyException(String message) { ③
        super(message);
    }
}
```


上述代码实现了自定义异常，自定义异常类一般需要提供两个构造方法，一个是代码第②行的无参数的默认构造方法，异常描述信息是空的；另一个是代码第③行的字符串参数的构造方法，message是异常描述信息，getMessage()方法可以获得这些信息。

自定义异常就这样简单，主要是提供两个构造方法就可以了，