## 16.2 I/O流概述

Java将数据的输入输出（I/O）操作当做“流”来处理，“流”是一组有序的数据序列。“流”分为两种形式：输入流和输出流，从数据源中读取数据是输入流，将数据写入到目的地是输出流。

提示 以CPU为中心，从外部设备读取数据到内存，进而再读入到CPU，这是输入（Input，缩写I）过程；将内存中的数据写入到外部设备，这是输出（Output，缩写O）过程。所以输入输出简称为I/O。

### 16.2.1 Java流设计理念

如同16-2所示，数据输入的数据源有多种形式，如文件、网络和键盘等，键盘是默认的标准输入设备。而数据输出的目的地也有多种形式，如文件、网络和控制台，控制台是默认的标准输出设备。

![16-2](..../assets/16-2.jpg)

图16-2　I/O流

所有的输入形式都抽象为输入流，所有的输出形式都抽象为输出流，它们与设备无关。

### 16.2.2 流类继承层次

以字节为单位的流称为字节流，以字符为单位的流称为字符流。Java SE提供4个顶级抽象类，两个字节流抽象类：InputStream和OutputStream；两个字符流抽象类：Reader和Writer。

#####1.  字节输入流

字节输入流根类是InputStream，如图16-3所示它有很多子类，这些类的说明如表16-1所示。

表 16-1 主要的字节输入流

| **类** | **描述** |
| --- | --- |
| FileInputStream | 文件输入流 |
| ByteArrayInputStream | 面向字节数组的输入流 |
| PipedInputStream | 管道输入流，用于两个线程之间的数据传递 |
| FilterInputStream | 过滤输入流，它是一个装饰器扩展其他输入流 |
| BufferedInputStream | 缓冲区输入流，它是FilterInputStream的子类 |
| DataInputStream | 面向基本数据类型的输入流 |

![16-3](..../assets/16-3.jpg)

图16-3　字节输入流类继承层次

#####2.  字节输出流

字节输出流根类是OutputStream，如图16-4所示它有很多子类，这些类的说明如表16-2所示。

表 16-2 主要的字节输出流

| **类** | **描述** |
| --- | --- |
| FileOutputStream | 文件输出流 |
| ByteArrayOutputStream | 面向字节数组的输出流 |
| PipedOutputStream | 管道输出流，用于两个线程之间的数据传递 |
| FilterOutputStream | 过滤输出流，它是一个装饰器扩展其他输出流 |
| BufferedOutputStream | 缓冲区输出流，它是FilterOutputStream的子类 |
| DataOutputStream | 面向基本数据类型的输出流 |

![16-4](..../assets/16-4.jpg)

图16-4　字节输出流类继承层次

#####3.  字符输入流

字符输入流根类是Reader，这类流以16位的Unicode编码表示的字符为基本处理单位。如图16-5所示它有很多子类，这些类的说明如表16-3所示。

表 16-3 主要的字符输入流

| **类** | **描述** |
| --- | --- |
| FileReader | 文件输入流 |
| CharArrayReader | 面向字符数组的输入流 |
| PipedReader | 管道输入流，用于两个线程之间的数据传递 |
| FilterReader | 过滤输入流，它是一个装饰器扩展其他输入流 |
| BufferedReader | 缓冲区输入流，它是也是装饰器，它不是FilterReader的子类 |
| InputStreamReader | 把字节流转换为字符流，它是也一个装饰器，是FileReader的父类 |

![16-5](..../assets/16-5.jpg)

图16-5　字符输入流类继承层次

#####4.  字符输出流

字符输出流根类是Writer，这类流以16位的Unicode编码表示的字符为基本处理单位。如图16-6所示它有很多子类，这些类的说明如表16-4所示。

表 16-4 主要的字符输出流

| **类** | **描述** |
| --- | --- |
| FileWriter | 文件输出流 |
| CharArrayWriter | 面向字符数组的输出流 |
| PipedWriter | 管道输出流，用于两个线程之间的数据传递 |
| FilterWriter | 过滤输出流，它是一个装饰器扩展其他输出流 |
| BufferedWriter | 缓冲区输出流，它是也是装饰器，它不是FilterReader的子类 |
| OutputStreamWriter | 把字节流转换为字符流，它是也一个装饰器，是FileWriter的父类 |

![16-6](..../assets/16-6.jpg)

图16-6　字符输出流类继承层次