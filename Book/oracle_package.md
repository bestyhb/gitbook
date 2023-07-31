``` SQL
GRANT SELECT ON db.table TO user;       --package授权
REVOKE SELECT ON db.table FROM user;    --package收权
-- 授权完成，仅表示'用户n'能够'执行'该pkg，但不能保证'用户n‘能够查询该pkg中的'对象（如：表）
```