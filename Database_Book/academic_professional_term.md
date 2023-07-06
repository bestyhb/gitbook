# Standard Query Language Professional and Academic Concept

## Professional Words (专业名词)

### segment
segment，段，数据文件空间（或占用数据文件空间）的统称，或数据库对象使用的空间的集合。段可以有表段、索引段、回滚段、临时段和高速缓存段等。一个或者多个段构成一个表空间。
在数据库中，一段指包含一个或多个区域的一部分，各个区域由称为区的单元构成，一个或多个段构成一个表空间。
在图像中，一段定义为两点之间可能的最短路径。在位图中，最小的段为离两点之间最短路径最近段所有像素段集合。在矢量图中，通过指定两个端点然后在两端点之间构成一条直线，便可产生一段。两个或多个段端到端的放置起来可构成一条折线。
在通信系统中，一段是网络的一部分。在网络段中，数据可任意在两点之间自由流动而不需通过交换机、路由器、网桥、集线器。段的大小可定义为其中工作站数量或者它携带的网络通信量。一个TCP TPDU称为一个段，由20B头文件组成，最大总长度为65535B。当一个段比MTU更大时，这个段就会被网络层分割成小碎片。
在现实交通中，航空行业的航段概念通常分为旅客航段和飞行航段。旅客航段通常是指能够构成旅客航程的航段，例如北京——济南——上海航线；旅客航程有3种可能：北京——上海、北京——济南、济南——上海，就是说旅客有这三种航段需求。

[segment（数据文件空间）_百度百科](https://baike.baidu.com/item/segment/1272972?fr=ge_ala)
[程序员必备的数据库知识：数据存储结构](https://baijiahao.baidu.com/s?id=1756797014007089410&wfr=spider&for=pc)

### shrink
shrink，段重组  

[关于收缩表和表空间的相关概念（Shrinking Database Segments Online）_ITPUB博客](http://blog.itpub.net/29802484/viewspace-1869232/)


## Academic Terms (学术术语)

### HWM
HWM, high water mark，高水标记，简单来说，HWM就是一个segment中已使用和未使用block的分界线，这个概念在segment的存储内容中是比较重要的。
