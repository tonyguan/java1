## 7.3 跳转语句

跳转语句能够改变程序的执行顺序，可以实现程序的跳转。Java有4种跳转语句：break、continue、throw和return。本章重点介绍break和continue语句的使用。throw和return将后面章节介绍。

### 7.3.1 break语句 {#break}

break语句可用于上一节介绍的while、repeat-while和for循环结构，它的作用是强行退出循环体，不再执行循环体中剩余的语句。

在循环体中使用break语句有两种方式：带有标签和不带标签。语法格式如下：

```java
break; //不带标签
break label; //带标签，label是标签名
```
不带标签的break语句使程序跳出所在层的循环体，而带标签的break语句使程序跳出标签指示的循环体。

下面看一个示例，代码如下：

```java
int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

for (int i = 0; i < numbers.length; i++) {
    if (i == 3) {
        //跳出循环
        break;
    }
    System.out.println("Count is: " + i);
}
```
在上述程序代码中，当条件i==3的时候执行break语句，break语句会终止循环，程序运行的结果如下：
    
    Count is: 0
    Count is: 1
    Count is: 2
    

break还可以配合标签使用，示例代码如下：


```java
label1: for (int x = 0; x < 5; x++) {　			①
    for (int y = 5; y > 0; y--) {				②
        if (y == x) {
            //跳转到label1指向的循环
            break label1; 	　			③
        }
        System.out.printf("(x,y) = (%d,%d)", x, y);
        // 打印一个换行符，实现换行
        System.out.println();
    }
}
System.out.println("Game Over!");
```


默认情况下，break只会跳出最近的内循环（代码第②行for循环）。如果要跳出代码第①行的外循环，可以为外循环添加一个标签label1，注意在定义标签的时候后面跟一个冒号。代码第③行的break语句后面指定了label1标签，这样当条件满足执行break语句时，程序就会跳转出label1标签所指定的循环。

程序运行结果如下：

    (x,y) = (0,5)
    (x,y) = (0,4)
    (x,y) = (0,3)
    (x,y) = (0,2)
    (x,y) = (0,1)
    (x,y) = (1,5)
    (x,y) = (1,4)
    (x,y) = (1,3)
    (x,y) = (1,2)
    Game Over!
如果break后面没有指定外循环标签，则运行结果如下：

    (x,y) = (0,5)
    (x,y) = (0,4)
    (x,y) = (0,3)
    (x,y) = (0,2)
    (x,y) = (0,1)
    (x,y) = (1,5)
    (x,y) = (1,4)
    (x,y) = (1,3)
    (x,y) = (1,2)
    (x,y) = (2,5)
    (x,y) = (2,4)
    (x,y) = (2,3)
    (x,y) = (3,5)
    (x,y) = (3,4)
    (x,y) = (4,5)
    Game Over!
    
比较两种运行结果，就会发现给break添加标签的意义，添加标签对于多层嵌套循环是很有必要的，适当使用可以提高程序的执行效率。

### 7.3.2 continue语句 {#continue}

continue语句用来结束本次循环，跳过循环体中尚未执行的语句，接着进行终止条件的判断，以决定是否继续循环。对于for语句，在进行终止条件的判断前，还要先执行迭代语句。

在循环体中使用continue语句有两种方式可以带有标签，也可以不带标签。语法格式如下：

```java
continue //不带标签
continue label //带标签，label是标签名

```
下面看一个示例，代码如下：

```java
int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

for (int i = 0; i < numbers.length; i++) {
    if (i == 3) {
        continue;
    }
    System.out.println("Count is: " + i);
}
```
在上述程序代码中，当条件i==3的时候执行continue语句，continue语句会终止本次循环，循环体中continue之后的语句将不再执行，接着进行下次循环，所以输出结果中没有3。程序运行结果如下： 

    Count is: 0
    Count is: 1
    Count is: 2
    Count is: 4
    Count is: 5
    Count is: 6
    Count is: 7
    Count is: 8
    Count is: 9
    
带标签的continue语句示例代码如下：

```java
label1: for (int x = 0; x < 5; x++) {　		①
    for (int y = 5; y > 0; y--) {　		②
        if (y == x) {
            continue label1; 		③
        }
        System.out.printf("(x,y) = (%d,%d)", x, y);
        System.out.println();
    }
}
System.out.println("Game Over!");

```

默认情况下，continue只会跳出最近的内循环（代码第②行for循环），如果要跳出代码第①行的外循环，可以为外循环添加一个标签label1，然后在第③行的continue语句后面指定这个标签label1，这样当条件满足执行continue语句时，程序就会跳转出外循环。

程序运行结果如下： 

    (x,y) = (0,5)
    (x,y) = (0,4)
    (x,y) = (0,3)
    (x,y) = (0,2)
    (x,y) = (0,1)
    (x,y) = (1,5)
    (x,y) = (1,4)
    (x,y) = (1,3)
    (x,y) = (1,2)
    (x,y) = (2,5)
    (x,y) = (2,4)
    (x,y) = (2,3)
    (x,y) = (3,5)
    (x,y) = (3,4)
    (x,y) = (4,5)
    Game Over!
由于跳过了x == y，因此下面的内容没有输出。

    (x,y) = (1,1)
    (x,y) = (2,2)
    (x,y) = (3,3)
    (x,y) = (4,4) 
    