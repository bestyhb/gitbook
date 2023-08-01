# mvn commands
|          commands       |   attention     |fafd|
|-------------------------|-----------------|----|
|`mvn archetype:generate` | |**列出已存在模版，可省去参数单独执行**     |
|                         |  -DgroupId      |项目组ID，一般为组织域名|
|                         |  -DartifactId   |项目名Name，一般为项目名|
|                         |  -DarchetypeArtifactId|制订ArchetypeId, 例如maven-archetype-quickstart用于快速创建一个简单的Maven项目|
|                         |  -DinteractiveMode  |使用交互模式|
| `mvn compile`           | 
| `mvn test`              |
| `mvn clean`             |
| `mvn package`           |
| `mvn install`           |
| `mvn deploy`            |


```bash
mvn install -DskipTests
mvn package -Dmaven.test.failure.ignore=true
mvn install:install-file -DgroupId=org.mybatis.generator -DartifactId=mybatis-generator-core -Dversion=1.3.6 -Dpackaging=jar -Dfile=/Users/spring/Downloads/mybatis-generator-core-1.3.6.jar
```

Archetpye：
1. Maven项目的模版工具包，定义了Maven项目的基本框架，是为开发人员提供的数千种创建Maven项目模版，帮助Maven用户快速生成项目框架（目录结构以及POM文件）；
2. 由5个模块组成：
   * maven-archetype-plugin（Maven Archetype插件）
   * archetype-packaging（描述Maven Archetype的生命周期、构建项目软件包）
   * archetype-common（核心类）
   * archetype-models（描述类与引用）
   * archetype-testing（内部测试组件）
   > maven-archetype-plugin插件实现了Maven-Archetype的所有功能。


> Maven的所有功能都是通过插件实现的，包括Archetype。