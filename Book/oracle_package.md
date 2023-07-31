
* package (包)
Oracle中`package`是由`package`(包头)和`package body`(包体)组成的；

### 调用存储过程或方法
```SQL
-- 当前用户调用scott用户中的package，判断某表是否存在与scott中；
SELECT soctt.pag_public_toolkit.f_whether_table_exists('emp') a,
       scott.pkg_public_toolkit.f_whether_table_exists('student') b
FROM dual;
```

### 定义包头
``` SQL
-- 定义package包头；
CREATE OR REPLACE PACKAGE scott.pkg_public_toolkit IS 
PROCEDURE p_whether_table_exists(i_table_name IN sys.all_tab_comments.table_name%TYPE, o_flag OUT VARCHAR2, o_message OUT VARCHAR2);
FUNCTION f_whether_table_exists(i_table_name IN sys.all_tab_comments.table_name%TYPE) RETURN VARCHAR2;
END pkg_public_toolkit;
-- 授权给用户；
GRANT EXECUTE ON scott.pkg_public_toolkit TO user;
```

### 定义包体
``` SQL
CREATE OR REPLACE PACKAGE BODY scott.pkg_public_toolkit IS
PROCEDURE p_whether_table_exists(i_table_name IN sys.all_tab_comments.table_name%TYPE, o_flag OUT VARCHAR2, o_message OUT VARCHAR2) IS v_count NUMBER(1);
BEGIN
-- 判断用户scott中是否存在表
SELECT COUNT(1) INTO v_count FROM user_tab_comments ust WHERE ust.table=upper(i_table_name);
-- 程序执行描述信息
IF v_count>=1 THEN o_message:='存在';
ELSE o_message:='不存在';
END IF;
-- 程序执行标识
o_flag:='T';
EXCEPTION WHEN OTHERS THEN o_flag:='F';
dbms_output.put_line(dbms_utility.format_error_backtrace); -- 报错行号
dbms_output.put_line(SQLCODE || ':' || SQLERRM);           -- 报错编号及内容
END p_whether_table_exists;
FUNCTION f_whether_table_exists(i_table_name IN sys.all_tab_comments.table_name%TYPE) RETURN VARCHAR2 IS 
o_flag VARCHAR2(2);
o_message VARCHAR2(100);
BEGIN 
p_whether_table_exists(i_table_name => i_table_name,o_flag=>o_flag,o_message=>o_message); RETURN o_message;
END f_whether_table_exists;
END pkg_public_toolkit;
```

### 删除包
``` SQL
-- 删除包
DROP PACKAGE [BODY] [user.]package_name;
-- 删除过程
DROP PRODUCT p_whether_table_exists, OpenCurType;
-- 删除实例中创建的包
DROP PACKAGE demo_pack;
```

### 授权用户包权限
``` SQL
GRANT EXECUTE ON db.pkg TO u1,u2;
```

### 授权用户数据表的权限
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
