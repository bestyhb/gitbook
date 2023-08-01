# 如何查询指定表结构？
``` SQL
select t.COLUMN_NAME,
    decode(s.DATA_TYPE,
        'DATA',
        'DATA',
        s.DATA_TYPE || '(' || s.DATA_LENGTH || ')'),
        t.COMMENTS
    from all_col_comments t, all_tab_columns s
    where t.TABLE_NAME = 'TABLE_NAME'
    and s.TaBLE_NAME = 'TABLE_NAME'
    and t.COLUMN_NAME = s.COLUMN_NAME
order by t.column_name;
```
``` SQL
select ALL_COL_COMMENTS.COLUMN_NAME, decode(ALL_TAB_COLUMNS.DATA_TYPE,'data','data',ALL_TAB_COLUMNS.DATA_TYPE || '('|| ALL_TAB_COLUMNS.DATA_LENGTH ||')'), ALL_COL_COMMENTS.COMMENTS from ALL_COL_COMMENTS,ALL_TAB_COLUMNS
WHERE ALL_COL_COMMENTS.Table_Name='TABLE_NAME' and ALL_TAB_COLUMNS.Table_Name='TABLE_NAME' and ALL_COL_COMMENTS.COLUMN_NAME=ALL_TAB_COLUMNS.COLUMN_NAME order by ALL_COL_COMMENTS.COLUMN_NAME;
```

# 如何查询指定schema下的表？
`select table_name from sys.dba_tables where owner='SCHEMA'`
`select table_name from all_tables where owner='SCHEMA'`