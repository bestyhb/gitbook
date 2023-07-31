
* package (包)
Oracle中`package`是由`package`(包头)和`package body`(包体)组成的；

### 如何调用存储过程或方法
```SQL
-- 当前用户调用scott用户中的package，判断某表是否存在与scott中；
SELECT soctt.pag_public_toolkit.f_whether_table_exists('emp') a,
       scott.pkg_public_toolkit.f_whether_table_exists('student') b
FROM dual;
```

### 如何定义包头
``` SQL
-- 定义package包头；
CREATE OR REPLACE PACKAGE scott.pkg_public_toolkit IS 
PROCEDURE p_whether_table_existis(i_table_name IN sys.all_tab_comments.table_name%TYPE, o_flag OUT VARCHAR2, o_message OUT VARCHAR2);
FUNCTION f_whether_table_exists(i_table_name IN sys.all_tab_comments.table_name%TYPE) RETURN VARCHAR2;
END pkg_public_toolkit;
-- 授权给用户；
GRANT EXECUTE ON scott.pkg_public_toolkit TO user;
```

### 怎样给用户定义授权或回收权限对应的包
``` SQL
GRANT EXECUTE ON db.pkg TO u1,u2;
```

### 如何给用户定义或回收操作数据表的权限
``` SQL
GRANT SELECT ON db.table TO user;       --package授权
REVOKE SELECT ON db.table FROM user;    --package收权
-- 授权完成，仅表示'用户n'能够'执行'该pkg，但不能保证'用户n‘能够查询该pkg中的'对象（如：表）
```

### package、procedure、function声明时is和as的区别
在定义package, procedure, function、自定义类型type时，as和is相同无区别；
在声明游标cursor时，只能使用is不能使用as；
在创建视图view时，只能使用as不能使用is。

### begin-end结构中，end后是否都需要添加对应名称
在定义package, procedure, function时，begin-end结构的end结束后都需要携带相映名称；
当定义匿名语句块时，begin-end结构的end结束后不需要携带名称，如：
``` SQL
begin
    -- pl/sql语句
end
```
