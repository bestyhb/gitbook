定制化流程：
1. 修改项目代码
2. 打包
3. 依赖安装
`mvn install:install-file -DgroupId=org.mybatis.generator -DartifactId=mybatis-generator-core -Dversion-1.3.6 -Dpackaging=jar -Dfile=/Users/spring/Downloads/mybatis-generator-core-1.3.6.jar`

# 开源项目定制化

## MyBatis Generator
性质：开源
定制化内容：JavaTypeResolver（类型转换器）
项目地址：[mybatis/generator: A code generator for MyBatis.](https://github.com/mybatis/generator)
操作：重新实现`JavaTypeResolver`接口，将项目原有的`JavaTypeResolver`
定制化代码：
```Java

```
# 非开源项目定制化