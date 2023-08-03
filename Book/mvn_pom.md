- [mvn pom](#mvn-pom)
- [POM dependency](#pom-dependency)
- [POM Build](#pom-build)

# mvn pom

```XML
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    
    <parent>
    <!--
        <artifactId>zzj</artifactId>
        <groupId>org.btf.zzj</groupId>
        <version>1.0-SNAPSHOT</version>
    -->
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.5.6</version>
        <relativePath></relativePath>
    </parent>

    <modelVersion>4.0.0</modelVersion>
    <groupId>com.sbriny</groupId>
    <artifactId>iTextDemo</artifactId>
    <packaging>jar</packaging>
    <version>1.0-SNAPSHOT</version>
    <name>ProjDemo</name>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
    </dependencies>

    <build>
    </build>
</project>
```

# POM dependency

```XML
<dependency>
    <groupId>javax.xml.bind</groupId>
    <artifactId>jaxb-api</artifactId>
    <version>2.3.0</version>
</dependency>
<dependency>
    <groupId>com.sun.xml.bind</groupId>
    <artifactId>jaxb-impl</artifactId>
    <version>2.3.0</version>
</dependency>
<dependency>
    <groupId>com.sun.xml.bind</groupId>
    <artifactId>jaxb-core</artifactId>
    <version>2.3.0</version>
</dependency>
<dependency>
    <groupId>javax.activation</groupId>
    <artifactId>activation</artifactId>
    <version>1.1.1</version>
</dependency>

<!-- Spring -->
<!-- Spring Boot AOP -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
<!-- Spring Boot WEB -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<!--
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-actuator</artifactId>
    <version>2.3.12.RELEASE</version>
</dependency>
-->
<!-- 配置文件自动映射 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor</artifactId>
    <optional>true</optional>
</dependency>

<!-- Test -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
<!--Junit4-->
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
</dependency>
<dependency>
    <groupId>org.junit.platform</groupId>
    <artifactId>junit-platform-launcher</artifactId>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.junit.vintage</groupId>
    <artifactId>junit-vintage-engine</artifactId>
    <scope>test</scope>
</dependency>

<!--Database-->
<!-- MySQL的JDBC驱动 -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.17</version>
    <!--<scope>runtime</scope>-->
</dependency>
<!--手动导入Oracle ojdbc-->
<dependency>
    <groupId>com.oracle</groupId>
    <artifactId>ojdbc8</artifactId>
    <version>11.2.0</version>
</dependency>
<!-- https://mvnrepository.com/artifact/com.oracle.database.nls/orai18n -->
<dependency>
    <groupId>com.oracle.database.nls</groupId>
    <artifactId>orai18n</artifactId>
    <version>21.1.0.0</version>
</dependency>
<!-- Spring Boot JDBC -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
<!-- Mybatis -->
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>2.2.0</version>
</dependency>
<!-- Mybatis Generator -->
<dependency>
    <groupId>org.mybatis.generator</groupId>
    <artifactId>mybatis-generator-core</artifactId>
    <version>1.3.6</version>
</dependency>
<!--Generator 第三方插件 (https://github.com/itfsw/mybatis-generator-plugin) -->
<dependency>
    <groupId>com.itfsw</groupId>
    <artifactId>mybatis-generator-plugin</artifactId>
    <version>1.3.8</version>
</dependency>
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.3.1</version>
</dependency>
<dependency>
    <groupId>org.apache.velocity</groupId>
    <artifactId>velocity-engine-core</artifactId>
    <version>2.0</version>
</dependency>

<!--Lombok-->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>

<!-- Swagger3 -->
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-boot-starter</artifactId>
    <version>3.0.0</version>
</dependency>

<!--Valid-->
<!--
-->
<dependency>
    <groupId>javax.validation</groupId>
    <artifactId>validation-api</artifactId>
</dependency>
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>6.0.1.Final</version>
</dependency>

<!--JSON处理器-->
<!--Jackson-->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-core</artifactId>
    <version>2.11.2</version>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.11.2</version>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-annotations</artifactId>
    <version>2.11.2</version>
</dependency>
<!-- Google Gson -->
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
</dependency>
<!--
<dependency>
    <groupId>com.goole.zxing</groupId>
    <artifactId>core</artifactId>
    <version>3.0.0</version>
</dependency>
<dependency>
    <artifactId>com.google.zxing</artifactId>
    <artifactId>javase</artifactId>
    <version>3.0.0</version>
</dependency>
-->
<!-- Alibaba Fast JSON-->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.47</version>
</dependency>


<!-- 微信支付SDK -->
<dependency>
    <groupId>com.github.wechatpay-apiv3</groupId>
    <artifactId>wechatpay-apache-httpclient</artifactId>
    <version>0.4.8</version>
    <!--
    <version>0.3.0</version>
    -->
</dependency>
<!-- AliPay SDK -->
<dependency>
    <groupId>com.alipay.sdk</groupId>
    <artifactId>alipay-sdk-java</artifactId>
    <version>4.34.71.ALL</version>
</dependency>

<!-- iText -->
<dependency>
    <groupId>com.lowagie</groupId>
    <artifactId>itext</artifactId>
    <version>2.1.7</version>
</dependency>
<!-- PDF文件处理 -->
<dependency>
    <groupId>org.apache.pdfbox</groupId>
    <artifactId>pdfbox</artifactId>
    <version>2.0.24</version>
</dependency>
```

# POM Build

```XML
<build>
    <resources>
        <resource>
            <!-- xml放在java目录下-->
            <directory>src/main/java</directory>
            <includes>
                <include>**/*.xml</include>
            </includes>
        </resource>
        <!--指定资源的位置（xml放在resources下，可以不用指定）-->
        <resource>
            <directory>src/main/resources</directory>
        </resource>
    </resources>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <version>2.5.6</version>
        </plugin>
        <!--忽略编译错误-->
        <plugin>
            <groupId>org.apache.maven.plugin</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <configuration>
                <testFailureIgnore>true</testFailureIgnore>
            </configuration>
        </plugin>
        <!-- Generator -->
        <plugin>
            <groupId>org.mybatis.generator</groupId>
            <artifactId>mybatis-generator-maven-plugin</artifactId>
            <version>1.3.2</version>
            <configuration>
                <!--控制台输出 mvn mybatis-generator:generate -e 具体过程-->
                <verbose>true</verbose>
                <!--允许覆盖生成的文件,需要注意的是: MyBatis Generator 只会覆盖旧的 `PO`和`DAO`，对于 mapper.xml 不会覆盖，而是追加，这样做的目的是防止用户自己写的 sql 语句一不小心都被 MyBatis Generator 给覆盖-->
                <overwrite>false</overwrite>
                <!--代码生成器配置文件位于项目的相对Path-->
                <configurationFile>src/main/java/com/sbriny/generator.xml</configurationFile>
                <!-- <includeCompileDependencies>true</includeCompileDependencies> -->
            </configuration>
            <dependencies>
                <!-- MySQL的JDBC驱动 -->
                <dependency>
                    <groupId>mysql</groupId>
                    <artifactId>mysql-connector-java</artifactId>
                    <version>8.0.17</version>
                </dependency>
                <!--手动导入Oracle ojdbc-->
                <dependency>
                    <groupId>com.oracle</groupId>
                    <artifactId>ojdbc8</artifactId>
                    <version>11.2.0</version>
                </dependency>
                <!--第三方插件：https://github.com/itfsw/mybatis-generator-plugin-->
                <dependency>
                    <groupId>com.itfsw</groupId>
                    <artifactId>mybatis-generator-plugin</artifactId>
                    <version>1.3.8</version>
                </dependency>
            </dependencies>
        </plugin>

    </plugins>
</build>
```