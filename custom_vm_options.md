
> HELP -> Edit Custom VM Options -> Edit `idea.vmoptions` File

| command                             | exception                                                                        |
| ----------------------------------- | -------------------------------------------------------------------------------- |
| `-Deditable.java.test.console=true` | 允许IDEA执行TEST对控制台的操作                                                   |
| `-Xmx4096m`                         | 修改IDEA内存 / 设置JVM最大堆内存为1024MB                                         |
| `Xms1024m`                          | JVM初始堆内存为1024MB。此值可以与-Xmx相同以避免每次垃圾回收完成后JVM重新分配内存 |
| `-Xss512k` |每个线程栈大小为512KB。JDK5.0后每个线程栈大小为1MB，之前每版本的每个线程栈大小为256KB。                                                                                  |
