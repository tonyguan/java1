## 9.2 使用API文档

Java中很多类，每一个类又有很多方法和变量，通过查看Java API文档能够知道这些类、方法和变量如何使用。Java官方为Java SE提供了基于HTML的API文档。作为Java程序员应该熟悉如何使用API文档。

本节介绍一下如何使用Java SE的API文档。Java官方提供了Java 8在线API文档，网址是http://docs.oracle.com/javase/8/docs/api/，页面如图9-1所示。

![](./assets/9-1.jpg)
图9-1　Java 8在线API文档

**提示 很多读者希望能够有离线的中文Java API文档，但Java官方只提供了Java 6的中文API文档，该文件下载地址是http://download.oracle.com/technetwork/java/javase/6/docs/zh/api.zip，下载完成后解压api.zip文件，找到其中的index.html文件，双击就会在浏览器中打开API文档了。
**
下面介绍一下如何使用API文档，熟悉一下API文档页面中的各个部分含义，如图9-2所示，类和接口中，斜文字体显示是接口，正常字体才是类。

![9-2](.../assets/9-2.jpg)

图9-2　API文档页面各个部分

在类窗口还有很多内容，向下拖曳滚动条会看到如图9-3所示页面，其中“字段摘要”描述了类中的实例变量和静态变量；“构造方法摘要”描述了类中所有构造方法；“方法摘要”描述了类中所有方法。这些“摘要”只是一个概要说明，单击链接可以进入到该主题更加详细的描述，如图9-4所示单击了compareTo方法看到的详细信息。

![9-3](.../assets/9-3.jpg)

图9-3　类窗口页面其他内容

![9-4](.../assets/9-4.jpg)

图9-4　 compareTo方法详细描述

查询API的一般流程是：找包→找类或接口→查看类或接口→找方法或变量。读者可以尝试查找一下String、StringBuffer和StringBuilder这些字符串类的API文档，熟悉一下这些类的用法。