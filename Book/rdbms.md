## RSRM (结果集返回机制)
CV, Cursor Variable, 游标变量
SQL Server：SQL Server中类似游标变量的功能称为“表值参数”(Table-Valued Parameters)，其允许将一个表结构作为参数传递给存储过程或函数。
PostgresSQL：PostgresSQL中使用REFCURSOR来返回结果集，其类似于Oracle中的CV。
MySQL：MySQL中没有直接的游标变量的概念，但可以通过调用存储过程和变量来实现类似的功能。
DB2：DB2数据库中也有游标变量，但它们的使用可能与Oracle的实现有所不同。
SQLite：SQLite是一种嵌入式数据库，不同于传统的客户/服务器数据库，因此查询和结果处理的方式也可能不同。

Cursor Variable(游标变量)：Oracle数据库中的术语，用于引用查询结果集的变量。
