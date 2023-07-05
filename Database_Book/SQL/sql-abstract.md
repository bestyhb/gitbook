# 操作
```
数据库
    创建
    删除
数据表
    创建
    删除
    修改
数据
    插入
    删除
    修改
    查询
        条件查询
        模糊查询
视图
    创建
过程
    创建存储过程
用户
    设置用户对数据库的使用权限
函数
    定义
触发器
    定义
```

```
数据库
    创建
    create database databasename
    删除
数据表
    创建
    create table tablename
    create table newtablename like oldtablename
    create table newtablename as select * from oldtablename definition only
    删除
    修改
    alter table tablename add column columntype
    alter table tablename add primary primarykeyname (columnname)
数据
    插入
    删除
    修改
    查询
        条件查询
        模糊查询
视图
    创建
过程
    创建存储过程
用户
    设置用户对数据库的使用权限
函数
    定义
触发器
    定义
```

# 方言
| database     | dialect |
| ------------ | ------- |
| SQL Server   | T-SQL   |
| Oracle       | PL/SQL  |
| MS Accessors | JET SQL |

# 名词
| word                                       | comment                                                                               |
| ------------------------------------------ | ------------------------------------------------------------------------------------- |
| ASNI(American National Standard Institute) | 美国国家标准协会，SQL是一种被ASNI标准化的语言，但是有很多不同的实现版本               |
| SQL(Structured Query Language)             | 标准化结构查询语言，SQL是一种计算机编程语言，用于控制用户访问和存储(创建)、检索（提取）和修改关系型数据库中存储的数据 |
| RDBMS                                      | 关系型数据库管理系统，SQL是RDBMS的标准处理语言                                        |
| ISO                                        | 国际标准化组织，SQL被ISO采纳为了国际标准                                              |
| ANSI SQL 89                                | SQL的重要标准版本，被ANSI和ISO共同采纳，虽然主要的RDBMS拥有自己的SQL变种方言，但是她们都遵守ANSI SQL 89 |

# Q&A
```
* 为什么SQL会成功？
答：
在SQL之前，与ISAM或VSAM等早出现的读写API相比，SQL的主要优势：
引入了用一个命令访问多个记录的概念;
消除了如何到达指定记录的需要，例如有或没有索引
SQL之所以广受欢迎，是因为它：
允许用户访问RDBMS中的数据；
允许用户描述数据；
允许用户定义并处理RDBMS中的数据；
允许用户将SQL模块、库、预处理器嵌入到其他编程语言中；
允许用户创建和删除数据库、表、项（记录）；
允许用户创建视图、存储过程、函数；
允许用户设置对数据表、视图、存储过程的权限。
* SQL语言处理器是否为SQL引擎？
* RDBMS引擎是否为传统查询引擎？
```

