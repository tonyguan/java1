## 1.3 Java平台

Java不仅是编程语言，还是一个开发平台，Sun公司根据Java应用领域的不同将Java分成三个平台：Java SE、Java EE和Java ME。

### 1.3.1 Java SE

Java SE是Java Standard Edition，主要目的是为台式机和工作站桌面应用（Application）程序的版本。Java SE是其他平台的基础，本书主要介绍的就是Java SE版本中的技术。

Java SE中主要包含了：JRE（Java SE Runtime Environment，Java SE运行环境）、JDK（Java Development Kit，Java开发工具包）和Java核心类库。如果只是运行Java程序，不考虑开发Java程序，那么只安装JRE就可以了。在JRE中包含了Java程序运行所需要的Java虚拟机（JVM，Java Virtual Machine）。JDK中包含了JRE和一些开发工具，这些工具包括：编译器、文档生成器和文件打包等工具。

另外，Java SE中还提供了Java应用程序开发需要的基本的和核心的类库，这些类库：字符串、集合、输入输出、网络通信和图形用户界面等。事实上学习Java就是在学习Java语法和Java类库使用。

### 1.3.2 Java EE

Java EE是Java Enterprise Edition，主要目的是为简化企业级系统的开发、部署和管理。Java EE是以Java SE为基础的，并提供了一套服务、API接口和协议，能够开发企业级分布式系统、Web应用程序和业务组件等，其中的包括：JSP、Servlet、EJB、JNI和Java Mail等。

### 1.3.3 Java ME

Java ME是Java Micro Edition，主要是面向消费类电子产品，为消费电子产品提供一个Java的运行平台，使得Java程序能够在手机、机顶盒、PDA等产品上运行。Java ME在早期的诺基亚塞班手机系统有很多应用，而现在的iOS和Android等智能手机中基本上没有它的用武之地。