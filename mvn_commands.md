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
mvn install:install-file -DgroupId=org.mybatis.generator -DartifactId=mybatis-generator-core -Dversion-1.3.6 -Dpackaging=jar -Dfile=/Users/spring/Downloads/mybatis-generator-core-1.3.6.jar
```