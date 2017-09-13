## 17.3 访问互联网资源

Java的java.net包中还提供了高层次网络编程类——URL，通过URL类访问互联网资源。使用URL进行网络编程，不需要对协议本身有太多的了解，相对而言是比较简单的。

### 17.3.1 URL概念

互联网资源是通过URL指定的，URL是Uniform Resource Locator简称，翻译过来是“一致资源定位器”，但人们都习惯URL简称。

URL组成格式如下：

协议名://资源名

“协议名”指明获取资源所使用的传输协议，如http、ftp、gopher和file等，“资源名”则应该是资源的完整地址，包括主机名、端口号、文件名或文件内部的一个引用。例如：

    http://www.sina.com/ 
    http://home.sohu.com/home/welcome.html 
    http://www.51work6.com:8800/Gamelan/network.html#BOTTOM


### 17.3.2 HTTP/HTTPS协议

访问互联网大多都基于HTTP/HTTPS协议。下面介绍一下HTTP/HTTPS协议。

####1.  HTTP协议

HTTP是Hypertext Transfer Protocol的缩写，即超文本传输协议。HTTP是一个属于应用层的面向对象的协议，其简捷、快速的方式适用于分布式超文本信息的传输。它于1990年提出，经过多年的使用与发展，得到不断完善和扩展。HTTP协议支持C/S网络结构，是无连接协议，即每一次请求时建立连接，服务器处理完客户端的请求后，应答给客户端然后断开连接，不会一直占用网络资源。

HTTP/1.1协议共定义了8种请求方法：OPTIONS、HEAD、GET、POST、PUT、DELETE、TRACE和CONNECT。作为Web服务器，必须实现GET和HEAD方法，其他方法都是可选的。

*   GET方法：是向指定的资源发出请求，发送的信息“显式”地跟在URL后面。GET方法应该只用在读取数据，例如静态图片等。GET方法有点像使用明信片给别人写信，“信内容”写在外面，接触到的人都可以看到，因此是不安全的。
*   POST方法：是向指定资源提交数据，请求服务器进行处理，例如提交表单或者上传文件等。数据被包含在请求体中。POST方法像是把“信内容”装入信封中，接触到的人都看不到，因此是安全的。

####2.  HTTPS协议

HTTPS是Hypertext Transfer Protocol Secure，即超文本传输安全协议，是超文本传输协议和SSL的组合，用以提供加密通信及对网络服务器身份的鉴定。

简单地说，HTTPS是HTTP的升级版，HTTPS与HTTP的区别是：HTTPS使用https://代替http://，HTTPS使用端口443，而HTTP使用端口80来与TCP/IP进行通信。SSL使用40位关键字作为RC4流加密算法，这对于商业信息的加密是合适的。HTTPS和SSL支持使用X.509数字认证，如果需要的话，用户可以确认发送者是谁。

### 17.3.3 使用URL类

Java 的java.net.URL类用于请求互联网上的资源，采用HTTP/HTTPS协议，请求方法是GET方法，一般是请求静态的、少量的服务器端数据。

URL类常用构造方法：

*   URL(String spec)：根据字符串表示形式创建URL对象。
*   URL(String protocol, String host, String file)：根据指定的协议名、主机名和文件名称创建URL对象。
*   URL(String protocol, String host, int port, String file)：根据指定的协议名、主机名、端口号和文件名称创建URL对象。

URL类常用方法：

*   InputStream openStream()：打开到此URL的连接，并返回一个输入流。
*   URLConnection openConnection()：打开到此URL的新连接，返回一个URLConnection对象。

下面通过一个示例介绍一下如何使用java.net.URL类，示例代码如下：


```java
//HelloWorld.java文件
package com.a51work6;
...
public class HelloWorld {

	public static void main(String[] args) {
		// Web网址
		String url = "http://www.sina.com.cn/";

		URL reqURL;
		try {
			reqURL = new URL(url); ①
		} catch (MalformedURLException e1) {
			return;
		}

		try ( // 打开网络通信输入流
				InputStream is = reqURL.openStream();②
				InputStreamReader isr = new InputStreamReader(is, "utf-8");
				BufferedReader br = new BufferedReader(isr)) {				
	
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();								
			while (line != null) {
				sb.append(line);
				sb.append('\n');
				line = br.readLine();								
			}
			// 日志输出
			System.out.println(sb);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

```


上述代码第①行创建URL对象，参数是一个HTTP网址。代码第②行通过URL对象的openStream()方法打开输入流。

### 17.3.4 使用HttpURLConnection发送GET请求

由于URL类只能发送HTTP/HTTPS的GET方法请求，如果要想发送其他的情况或者对网络请求有更深入的控制时，可以使用HttpURLConnection类型。

示例代码如下：


```java
//HelloWorld.java文件
package com.a51work6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HelloWorld {

	// Web服务网址
	static String urlString = "http://www.51work6.com/service/mynotes/WebService.php?"
			+ "email=<换成你在51work6.com注册时填写的邮箱>&type=JSON&action=query"; ①

	public static void main(String[] args) {

		BufferedReader br = null;
		HttpURLConnection conn = null;

		try {
			URL reqURL = new URL(urlString);						
			conn = (HttpURLConnection) reqURL.openConnection();②
			conn.setRequestMethod("GET");	③
			
			// 打开网络通信输入流
			InputStream is = conn.getInputStream();④
			// 通过is创建InputStreamReader对象
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			// 通过isr创建BufferedReader对象
			br = new BufferedReader(isr);

			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			// 日志输出
			System.out.println(sb);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.disconnect(); ⑤
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

```

上述代码第①行是一个Web服务网址字符串。

**提示 发送GET请求时发送给服务器的参数是放在URL的“?”之后，参数采用键值对形式，例如：第①行的URL中type=JSON是一个参数，type是参数名，JSON是参数名，服务器端会根据参数名获得参数值。多个参数之间用“&amp;”分隔，例如type=JSON&amp;action=query就是两个参数。**

代码第②行是reqURL.openConnection()方法打开一个连接，返回URLConnection对象，由于本次连接是HTTP连接，所以返回的是HttpURLConnection对象。URLConnection是抽象了，HttpURLConnection是URLConnection的子类。

代码第③行conn.setRequestMethod(&quot;GET&quot;)是设置请求方法为GET方法。代码第④行是通过conn.getInputStream()打开输入流，上一节实例使用的URL的openStream()方法获得输入流。代码第⑤行conn.disconnect()是断开连接，这可以释放资源。

从服务器端返回的数据是JSON字符串，格式化后内容如下：

```java
{
    "ResultCode": 0,
    "Record": [
        {
            "ID": 5238,
            "CDate": "2017-05-18",
            "Content": "欢迎来到智捷课堂。"
        },
        {
            "ID": 5239,
            "CDate": "2018-10-18",
            "Content": "Welcome to zhijieketang."
        }
    ]
}

```

**提示 上述示例中URL所指向的Web服务是有作者所在的智捷课堂提供的，读者要想使用这个Web服务需要www.51work6.com进行注册，注册时需要提供你自己有效的邮箱，这个邮箱用来激活用户。在网络请求时需要提交email参数，这个参数是你在注册时填写的邮箱。
**
### 17.3.5 使用HttpURLConnection发送POST请求

HttpURLConnection也可以发送HTTP/HTTPS的POST请求，下面介绍使用HttpURLConnection发送POST请求。

示例代码如下：

```java
//HelloWorld.java文件
package com.a51work6;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HelloWorld {

	// Web服务网址
	static String urlString = "http://www.51work6.com/service/mynotes/WebService.php";①	

	public static void main(String[] args) {

		BufferedReader br = null;
		HttpURLConnection conn = null;
		try {
			URL reqURL = new URL(urlString);
			conn = (HttpURLConnection) reqURL.openConnection();②
			conn.setRequestMethod("POST");	③
			conn.setDoOutput(true); ④

			String param = String.format("email=%s&type=%s&action=%s",
							 "<换成你在51work6.com注册时填写的邮箱>", "JSON", "query");⑤	
			// 设置参数
			DataOutputStream dStream = new DataOutputStream(conn.getOutputStream());⑥
			dStream.writeBytes(param);⑦
			dStream.close();⑧

			// 打开网络通信输入流
			InputStream is = conn.getInputStream();
			// 通过is创建InputStreamReader对象
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			// 通过isr创建BufferedReader对象
			br = new BufferedReader(isr);

			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			// 日志输出
			System.out.println(sb);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

```


上述代码第①行URL后面不带参数，这是因为要发送的是POST请求，POST请求参数是放在请求体中。代码第②行是通过reqURL.openConnection()是建立HTTP连接，代码第③行是设置HTTP请求方法为POST，代码第④行conn.setDoOutput(true)是设置请求过程可以传递参数给服务器。

代码第⑤是设置请求参数格式化字符串&quot;email=%s&amp;type=%s&amp;action=%s&quot;，其中%s是占位符。

代码第⑥行～第⑧行是将请求参数发送给服务器，代码第⑥行中conn.getOutputStream()是打开输出流，new DataOutputStream(conn.getOutputStream())是创建基于数据输出流。代码第⑦行dStream.writeBytes(paramString)是向输出流中写入数据，第⑧行dStream.close()是关闭流，并将数据写入到服务器端。

### 13.3.6 实例：Downloader

为了进一步熟悉URL类，这一节介绍一个下载程序Downloader。Downloader.java代码如下：

```java
//Downloader.java文件
package com.a51work6;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Downloader {

	// Web服务网址
	private static String urlString = "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/"
			+ "static/superman/img/logo/bd_logo1_31bdc765.png";

	public static void main(String[] args) {
		download();
	}

	// 下载方法
	private static void download() {

		HttpURLConnection conn = null;

		try {
			// 创建URL对象
			URL reqURL = new URL(urlString);
			// 打开连接
			conn = (HttpURLConnection) reqURL.openConnection();①

			try (// 从连接对象获得输入流
					InputStream is = conn.getInputStream();	②
					BufferedInputStream bin = new BufferedInputStream(is); ③
					// 创建文件输出流
					OutputStream os = new FileOutputStream("./download.png"); ④
					BufferedOutputStream bout = new BufferedOutputStream(os);) { ⑤

				byte[] buffer = new byte[1024];
				int bytesRead = bin.read(buffer);
				while (bytesRead != -1) {
					bout.write(buffer, 0, bytesRead);
					bytesRead = bin.read(buffer);
				}
			} catch (IOException e) {
			}
			System.out.println("下载完成。");
		} catch (IOException e) {
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
	}
}

```

上述代码第①行打开连接获得HttpURLConnection对象。代码第②行是从连接对象获得输入流。代码第③行创建缓冲流输入流，使用缓冲流可以提高读写效率。

代码第④行是创建文件输出流，代码第⑤行是创建缓冲流输出流。

运行Downloader程序，如果成功会在当前目录获得一张图片。