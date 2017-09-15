## 15.1 集合概述

Java中提供了丰富的集合接口和类，它们来自于java.util包。如同15-1所示是Java主要的集合接口和类，从图中可见Java集合类型分为：Collection和Map，Collection子接口有：Set、Queue和List等接口。每一种集合接口描述了一种数据结构。

本章重点介绍List、Set和Map接口，因此图15-1中只列出了这三个接口的具体实现类，事实上Queue也有具体实现类，由于很少使用，这里不再赘述，读者感兴趣可以自己查询API文档。

![![19-1](..../assets/19-1.jpeg)](../assets/15-1.jpg)

图15-1　Java主要集合接口和类

**提示 在Java SE中List名称的类型有两个，一个是java.util.List，另外一个是java.awt.List。java.util.List是一个接口，这本章介绍的List集合。而java.awt.List是一个类，用于图形用户界面开发，它是一个图形界面中的组件。
**

**提示 学习Java中的集合，首先从两大接口入手，重点掌握List、Set和Map三个接口，熟悉这些接口中提供的方法。然后再熟悉这些接口的实现类，并了解不同实现类之间的区别。**