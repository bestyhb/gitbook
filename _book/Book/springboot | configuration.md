## Abstruct（提纲）
配置文件采用properties和yaml格式，两种语法参照。
配置映射：创建配置类，将配置文件与JavaBean在Spring容器中绑定。
配置处理：使用不同方式获取配置
注解
@Conditional

## SpringBoot Profile (项目配置)
### Profile Block (YAML文档块)
``` yaml
server:
    port: 8081
spring: 
    profiles: 
    active: prod
---
server:
    port: 8083
spring: 
    profiles: dev
---
server:
    port: 8084
spring:
    profiles: prod
```
