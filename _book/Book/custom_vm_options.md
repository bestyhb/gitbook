

#### IDEA
> IDEA Setup VM Options:  
> HELP -> Edit Custom VM Options -> Edit `idea.vmoptions` File

### VM Options
| command                             | exception|
| ----------------------------------- | ------------|
| `-Deditable.java.test.console=true` | 允许IDEA执行TEST对控制台的操作 |
| `-Xmx4096m`                         | JVM最大堆内存空间为1024MB / IDEA内存空间。|
| `Xms1024m`                          | JVM初始堆内存为1024MB。此值可以与-Xmx相同以避免每次垃圾回收完成后JVM重新分配内存。|
| `-Xss512k`                          | 每个线程栈大小为512KB。JDK5.0后每个线程栈大小为1MB，之前每版本的每个线程栈大小为256KB。在相同无力内存下，减小这个值能生成更多线程，当然操作系统对一个进程内的线程数并非无限生成。 线程栈的大小是双刃剑，如果线程栈的空间过小，可能会导致栈溢出，特别是在该线程内有递归、大范围循环时导致出现的可能性更大；如果线程栈空间过大，就会影响到创建栈的数量，如果是多线程应用，就会出现内存溢出的现象。 |
| `-Xmn341m`                          | 年轻代空间为341MB。在整个堆内存大小确定的情况下，增大年轻代将会减小年老代，反之亦然。年轻代的空间关系到JVM垃圾回收，对系统性能影响较大。推荐配置为整个堆空间的3/8。|
| `-XX:NewSize=341m`                  | 年轻代初始空间为341MB。|
| `-XX:MaxNewSize=512m`               | 年轻代最大空间为341M。|
| `-XX:PermSize=512m`                 | 持久代初始空间为512MB。JDK 8 后不支持该选项，改用`-XX:MetaspaceSize=512m`。|
| `-XX:MaxPermSize=512m`              | 持久代最大空间为512MB。JDK 8后不支持该选项，改用`-XX:MaxMetaspaceSize=512m`。|
| `-XX:NewRatio=2`                    | 年轻代（包括1个Eden和2个Survivor区）与年老代的空间比值。表示年轻代与年老代的比为1:2。|
| `-XX:SurvivorRatio=8`               | 年轻代中的Eden区与Survivor区的空间比值。表示2个Survivor区（JVM堆内存年轻代中默认有2个大小相等的Survivor区）与1个Eden区的比值为1:1.8，即1个Survivor区占整个年轻代大小的1/10。|
| `-XX:MaxTenuringThreshold=15`       | JVM内存分配和回收策略中的对象衰老策略。|
| `-XX:ReservedCodeCacheSize=240m`    | 代码缓存空间。代码缓存空间用于存储已编译方法生成的本地代码。|
| `-client`                           | 启用JVM的Client模式。特点是启动速度较快，但运行时性能和内存管理效率不高，适用于客户端应用程序或开发调试的环境下。在32位计算环境下运行Java程序则默认启用该模式。|
| `server`                            | 启用JVM的Server模式。特点是启动速度较慢，但运行时性能和内存管理效率较高，适用于生产环境。在在64位计算环境下运行 Java程序默认启用该模式。|
| `-Dserver.port=8090`                | 启用服务端口为8090。|
