# 如何查询指定表结构？
``` SQL
select t.COLUMN_NAME,
    decode(s.DATA_TYPE,
        'DATE',
        'DATE',
        s.DATA_TYPE || '(' || s.DATA_LENGTH || ')'),
        t.COMMENTS
    from all_col_comments t, all_tab_columns s
    where t.Table_Name = 'V_YYXT_ZYXX'
    and s.Table_Name = 'V_YYXT_ZYXX'
    and t.COLUMN_NAME = s.COLUMN_NAME
order by t.column_name;
```

# 如何查询指定schema下的表？
`select table_name from sys.dba_tables where owner='SCHEMA'`
`select table_name from all_tables where owner='SCHEMA'`