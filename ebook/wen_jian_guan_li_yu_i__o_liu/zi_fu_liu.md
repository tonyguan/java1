## 16.4 字符流

上一节介绍了字节流，本节详细介绍一下字符流的API。掌握字符流的API先要熟悉它的两个抽象类：Reader和Writer，了解它们有哪些主要的方法。

### 16.4.1 Reader抽象类

Reader是字符输入流的根类，它定义了很多方法，影响着字符输入流的行为。下面详细介绍一下。

Reader主要方法如下：

*   int read()：读取一个字符，返回值范围在0~65535(0x00~0xffff)之间。如果因为已经到达流末尾，则返回值-1。
*   int read(char[] cbuf)：将字符读入到数组cbuf中，返回值为实际读取的字符的数量，如果因为已经到达流末尾，则返回值-1。
*   int read(char[] cbuf, int off, int len)：最多读取len个字符，数据放到以下标off开始字符数组cbuf中，将读取的第一个字符存储在元素cbuf[off]中，下一个存储在cbuf[off+1]中，依次类推。返回值为实际读取的字符的数量，如果因为已经到达流末尾，则返回值-1。
*   void close()：流操作完毕后必须关闭。

上述所有方法都可以会抛出IOException，因此使用时要注意处理异常。

### 16.4.2 Writer抽象类

Writer是字符输出流的根类，它定义了很多方法，影响着字符输出流的行为。下面详细介绍一下。

Writer主要方法如下：

*   void write(int c)：将整数值为c的字符写入到输出流，c是int类型占有32位，写入过程是写入c的16个低位，c的16个高位将被忽略。
*   void write(char[] cbuf)：将字符数组cbuf写入到输出流。
*   void write(char[] cbuf, int off, int len)：把字符数组cbuf中从下标off开始，长度为len的字符写入到输出流。
*   void write(String str)：将字符串str中的字符写入输出流。
*   void write(String str,int off,int len)：将字符串str 中从索引off开始处的len个字符写入输出流。
*   void flush()：刷空输出流，并输出所有被缓存的字符。由于某些流支持缓存功能，该方法将把缓存中所有内容强制输出到流中。
*   void close( )：流操作完毕后必须关闭。

上述所有方法都可以会抛出IOException，因此使用时要注意处理异常。

**注意 Reader和Writer都实现了AutoCloseable接口，可以使用自动资源管理技术自动关闭它们。**

### 16.4.3 案例：文件复制

前面两个介绍了字符流常用的方法，下面通过一个案例熟悉一下它们的使用，该案例实现了文件复制，数据源是文件，所以会用到文件输入流FileReader，数据目的地也是文件，所以会用到文件输出流FileWriter。

FileReader和FileWriter中主要方法都是继承自Reader和Writer前面两个节已经详细介绍了，这里不再赘述。下面介绍一下它们的构造方法，FileReader构造方法主要有：

*   FileReader(String fileName)：创建FileReader对象，fileName是文件名。如果文件不存在则抛出FileNotFoundException异常。
*   FileReader(File file)：通过File对象创建FileReader对象。如果文件不存在则抛出FileNotFoundException异常。

FileWriter构造方法主要有：

*   FileWriter(String fileName)：通过指定fileName文件名创建FileWriter对象。如果fileName文件存在，但如果是一个目录或文件无法打开则抛出FileNotFoundException异常。
*   FileWriter(String fileName, boolean append)：通过指定fileName文件名创建FileWriter对象，append参数如果为 true，则将字符写入文件末尾处，而不是写入文件开始处。如果fileName文件存在，但如果是一个目录或文件无法打开则抛出FileNotFoundException异常。
*   FileWriter(File file)：通过File对象创建FileWriter对象。如果file文件存在，但如果是一个目录或文件无法打开则抛出FileNotFoundException异常。
*   FileWriter(File file, boolean append)：通过File对象创建FileWriter对象，append参数如果为 true，则将字符写入文件末尾处，而不是写入文件开始处。如果file文件存在，但如果是一个目录或文件无法打开则抛出FileNotFoundException异常。

**注意 字符文件流只能复制文本文件，不能是二进制文件。**

下面采用文件字符流重新实现16.3.3节文件复制案例，代码如下：

```java
//FileCopy.java文件
package com.a51work6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) {

		try (FileReader in = new FileReader("./TestDir/build.txt");
				FileWriter out = new FileWriter("./TestDir/subDir/build.txt")) {

			// 准备一个缓冲区
			char[] buffer = new char[10];
			// 首先读取一次
			int len = in.read(buffer);

			while (len != -1) {
				String copyStr = new String(buffer);
				// 打印复制的字符串
				System.out.println(copyStr);
				// 开始写入数据
				out.write(buffer, 0, len);
				// 再读取一次
				len = in.read(buffer);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```

控制台输出结果：

	AI-162.376
	456862.376


上述代码与16.3.3节非常相似，只是将文件输入流改为FileReader，文件输出流改为FileWriter，缓冲区使用的是字符数组。

### 16.4.4 使用字符缓冲流

BufferedReader和BufferedWriter称为字符缓冲流。BufferedReader特有方法和构造方法有：

*   String readLine()：读取一个文本行，如果因为已经到达流末尾，则返回值null。
*   BufferedReader(Reader in)：构造方法，通过一个底层输入流in对象创建缓冲流对象，缓冲区大小是默认的，默认值8192。
*   BufferedReader(Reader in, int size)：构造方法，通过一个底层输入流in对象创建缓冲流对象，size指定的缓冲区大小，缓冲区大小应该是2的n次幂，这样可提供缓冲区的利用率。

BufferedWriter特有方法和构造方法主要有：

*   void newLine()：写入一个换行符。
*   BufferedWriter(Writer out)：构造方法，通过一个底层输出流out 对象创建缓冲流对象，缓冲区大小是默认的，默认值8192。
*   BufferedWriter(Writer out, int size)：构造方法，通过一个底层输出流out对象创建缓冲流对象，size指定的缓冲区大小，缓冲区大小应该是2的n次幂，这样可提供缓冲区的利用率。

下面将16.4.3节的文件复制的案例改造成缓冲流实现，代码如下：

```java
//FileCopyWithBuffer.java文件
package com.a51work6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyWithBuffer {

	public static void main(String[] args) {

		try (FileReader fis = new FileReader("./TestDir/JButton.html");
				BufferedReader bis = new BufferedReader(fis);
				FileWriter fos = new FileWriter("./TestDir/subDir/JButton.html");
				BufferedWriter bos = new BufferedWriter(fos)) {

			// 首先读取一行文本
			String line = bis.readLine();	①
			
			while (line != null) {					
				// 开始写入数据
				bos.write(line); ②
				//写一个换行符
				bos.newLine();	③
				// 再读取一行文本
				line = bis.readLine();
			}
			System.out.println("复制完成");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

```

上述代码第①行是通过字节缓冲流readLine方法读取一行文本，当读取是文本为null时说明流已经读完了。代码第②行是写入文本到输出流，由于在输入流的readLine方法会丢掉一个换行符或回车符，为了保持复制结果完全一样，因此需要在写完一个文本后，调用输出流的newLine方法写入一个换行符。

### 16.4.5 字节流转换字符流

有时需要将字节流转换为字符流，InputStreamReader和OutputStreamWriter是为实现这种转换而设计的。

InputStreamReader构造方法如下：

*   InputStreamReader(InputStream in)：将字节流in转换为字符流对象，字符流使用默认字符集。
*   InputStreamReader(InputStream in, String charsetName)：将字节流in转换为字符流对象，charsetName指定字符流的字符集，字符集主要有：US-ASCII、ISO-8859-1、UTF-8和UTF-16。如果指定的字符集不支持会抛出UnsupportedEncodingException异常。

OutputStreamWriter构造方法如下：

*   OutputStreamWriter(OutputStream out)：将字节流out转换为字符流对象，字符流使用默认字符集。
*   OutputStreamWriter(OutputStream out,String charsetName)：将字节流out转换为字符流对象，charsetName指定字符流的字符集，如果指定的字符集不支持会抛出UnsupportedEncodingException异常。

下面将16.4.3节的文件复制的案例改造成缓冲流实现，代码如下：

```java
//FileCopyWithBuffer.java文件
package com.a51work6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileCopyWithBuffer {

	public static void main(String[] args) {

		try ( // 创建字节文件输入流对象
				FileInputStream fis = new FileInputStream("./TestDir/JButton.html"); ①
				// 创建转换流对象
				InputStreamReader isr = new InputStreamReader(fis);
				// 创建字符缓冲输入流对象
				BufferedReader bis = new BufferedReader(isr);

				// 创建字节文件输出流对象
				FileOutputStream fos = new FileOutputStream("./TestDir/subDir/JButton.html");
				// 创建转换流对象
				OutputStreamWriter osw = new OutputStreamWriter(fos);
				// 创建字符缓冲输出流对象
				BufferedWriter bos = new BufferedWriter(osw)) { ②

			// 首先读取一行文本
			String line = bis.readLine();

			while (line != null) {
				// 开始写入数据
				bos.write(line);
				// 写一个换行符
				bos.newLine();
				// 再读取一行文本
				line = bis.readLine();
			}
			System.out.println("复制完成");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```


上述代码第①行~第②行只是一条语句，将这6个流放到try (…)，由JVM自动管理关闭。上述流从一个文件字节流，构建转换流，再构建缓冲流，这个过程比较麻烦，在I/O流开发过程中经常遇到这种流的“链条”。