- [Spring Application (应用配置)](#spring-application-应用配置)
- [Abstruct (简介)](#abstruct-简介)
- [Point (要领)](#point-要领)
  - [生成器配置](#生成器配置)
  - [生成器形态](#生成器形态)
    - [控制DAO MAPPER长度](#控制dao-mapper长度)
    - [定义DAO MAPPER形态](#定义dao-mapper形态)
    - [生成数据库Criteria CRUD准则](#生成数据库criteria-crud准则)
    - [转换生成字段特殊类型](#转换生成字段特殊类型)
- [Basic Configuration (完整基础配置)](#basic-configuration-完整基础配置)
- [Advanced Configuration (进阶增强配置)](#advanced-configuration-进阶增强配置)
  - [Plugin (功能插件)](#plugin-功能插件)
    - [原生插件](#原生插件)
    - [第三方插件](#第三方插件)
    - [自己封装插件](#自己封装插件)
  - [Comment (注释模版)](#comment-注释模版)

# Spring Application (应用配置)
**ex:**  
```
spring.datasource.driverClassName=oracle.jdbc.driver.OracleDriver
spring.datasource.url=jdbc:oracle:thin:@//127.0.0.1:1521/XE
spring.datasource.username=ADMIN
spring.datasource.password=12345678

mybatis.comment.file=src/main/resources/com/sbriny/comment.xml
```

# Abstruct (简介)
MyBatis Generator是一个独立代码的生成工具，又称逆向工程或代码生成器。generator可以通过jar来运行，也可以通过`Ant`、`Maven`来运行。

生成的代码分布：
- DAO层 dao 持久层接口；
- MODEL层 model Java模型对象；
- MAP层 mapper 操作数据库的SQLXML；


# Point (要领)

## 生成器配置
**严格遵循generator context配置顺序**  
1. property  
2. plugin  
3. commentGenerator  
4. jdbcConnection  
5. javaTypeResolver  
6. javaModelGenerator  
7. sqlMapGenerator  
8. javaClientGenerator  
9. table  

## 生成器形态
### 控制DAO MAPPER长度  
**context标签**  
* targetRuntime属性 默认值为MyBatis3 包含Selective和Example方法;  
* defaultModelType属性 默认值condition flat表示一张表对应一个po；  
```XML
<!--接口内容丰富-->  
<context id="myContext" targetRuntime="MyBatis3" defaultModelType="flat">
<!--接口简短-->  
<context id="myContext" targetRuntime="MyBatis3Simple" defaultModelType="flat">
```

### 定义DAO MAPPER形态  
**javaClientGenerator标签**  
* type -> XMLMAPPER -> XML MAPPER形态  
* type -> ANNOTATEDMAPPER -> 注解DAO形态，无MAPPER  

### 生成数据库Criteria CRUD准则  
```XML
<table tablename="tablename"
    enableInsert=""
    enableDeleteByExample=""
    enableDeleteByPrimaryKey=""
    enableCountByExample=""
    enableUpdateByExample=""
    enableUpdateByPrimaryKey=""
    enableSelectByExample=""
    enableSelectByPrimaryKey=""
    delimitIdentifiers=""
    domainObjectName=""
    />
```

### 转换生成字段特殊类型  
forceBigDecimals -> false (default)  
JDBC DECIMAL, NUMERIC -> java.lang.Integer  
forceBigDecimals -> true  JDBC DECIMAL, NUMERIC -> java.math.BigDecimal  
useJSR310Types -> false (default)  
JDBC TIME -> java.util.Date  
useJSR310Types -> true  
JDBC DATE -> java.time.LocalDate  
JDBC TIME -> java.time.LocalTime  
JDBC TIMESTAMP -> java.time.LocalDateTime  
JDBC TIME_WTH_TIMEZONE -> java.time.OffsetTime  
JDBC TIMESTAMP_WITH_TIMEZONE -> java.time.OffsetDateTime  

# Basic Configuration (完整基础配置)
```XML
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN" "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
<generatorConfiguration>

    <!--手动定义环境变量的相对或绝对路径-->
    <!--
    <properties resource="/Users/spring/P/zzjdy/wechat_pay/src/main/resources/application-dev.yml"/>
    <properties resource="application-dev.properties"/>
    -->
    
    <!--手动定义MySQL驱动JAR包的变量或常量的绝对路径-->
    <!--
    <classPathEntry location="${spring.datasource.driverLocation}}"/>
    <classPathEntry location="/User/Download/mysql-connector-java/5.1.34/mysql-connector-java-5.1.34.jar"/>
    -->
    
    <context id="myContext" targetRuntime="MyBatis3" defaultModelType="flat">

        <!-- 自动识别数据库关键字，默认false，如果设置为true，根据SqlReservedWords中定义的关键字列表；
   一般保留默认值，遇到数据库关键字（Java关键字），使用columnOverride覆盖 -->
        <property name="autoDelimitKeywords" value="true"/>
        <!-- 生成的Java文件的编码 -->
        <property name="javaFileEncoding" value="utf-8"/>
        <!-- beginningDelimiter和endingDelimiter：指明数据库的用于标记数据库对象名的符号，比如ORACLE就是双引号，MYSQL默认是`反引号； -->
        <property name="beginningDelimiter" value="`"/>
        <property name="endingDelimiter" value="`"/>
        <!-- 格式化java代码 -->
        <property name="javaFormatter" value="org.mybatis.generator.api.dom.DefaultJavaFormatter"/>
        <!-- 格式化XML代码 -->
        <property name="xmlFormatter" value="org.mybatis.generator.api.dom.DefaultXmlFormatter"/>

        <!-- Suppress Generator and Comments -->
        <commentGenerator>
            <!--是否不生成注释-->
            <property name="suppressAllComments" value="true"/>
            <!--是否不生成注释的时间戳-->
            <property name="suppressDate" value="true"/>
            <!--生成时间格式-->
            <property name="dateFormat" value="yyyy-MM-dd HH:mm:ss"/>
            <!--是否不生成注释的字段名称-->
            <property name="addRemarkComments" value="true"/>
        </commentGenerator>
        
        <!-- MySQL JDBC -->
        <!--
        <jdbcConnection driverClass="com.mysql.cj.jdbc.Driver" connectionURL="jdbc:mysql://127.0.0.1:3306/database?useUnicode=true&amp;characterEncoding=utf8&amp;serverTimezone=GMT%2B8&amp;allowPublicKeyRetrieval=true&amp;useSSL=false" userId="user" password="pass">
        -->
            <!--高版本的 mysql-connector-java 需要设置 nullCatalogMeansCurrent=true-->
        <!--
            <property name="nullCatalogMeansCurrent" value="true"/>
        </jdbcConnection>
        -->
        <!--
        <jdbcConnection driverClass="${spring.datasource.driverClassName}" connectionURL="${spring.datasource.url}" userId="${spring.datasource.username}" password="${spring.datasource.password}">
            <property name="nullCatalogMeansCurrent" value="true"/>
        </jdbcConnection>
        -->

        <!-- Oracle OJDBC -->
        <jdbcConnection driverClass="oracle.jdbc.driver.OracleDriver" connectionURL="jdbc:oracle:thin:@//127.0.0.1:1521/XE" userId="ADMIN" password="12345678"/>

        <javaTypeResolver>
            <!--是否转换数据和时间类型-->
            <property name="forceBigDecimals" value="false"/>
            <property name="useJSR310Types" value="false"/>
        </javaTypeResolver>

        <!-- Model Generator -->
        <javaModelGenerator targetPackage="com.sbriny.entity.po" targetProject="src/main/java">
            <!--针对String字段在Set中进行修剪-->
            <property name="trimstrings" value="true"/>
            <!--是否创建在数据库同名子包-->
            <property name="enableSubPackages" value="false"/>
            <!--MODEL对象是否不可改变，即不会有setter方法，只有构造方法-->
            <property name="immutable" value="false"/>
            <!--是否为MODEL对象添加构造函数-->
            <property name="constructorBased" value="false"/>
        </javaModelGenerator>

        <!-- Map Genertor -->
        <sqlMapGenerator targetPackage="com.sbriny.mapper" targetProject="src/main/java">
            <property name="enableSubPackages" value="false"/>
        </sqlMapGenerator>

        <!-- DAO Generator-->
        <javaClientGenerator targetPackage="com.sbriny.dao" targetProject="src/main/java" type="XMLMAPPER">
            <property name="enableSubPackages" value="false"/>
        </javaClientGenerator>
        
        <!--
        1.table可以有多个；
        2.每个数据库中的表都可以写一个table；
        3.tableName可以使用%通配符来匹配所有数据库表,也可以指定具体的表明；
        4.只有匹配的表才会自动生成文件。
         -->
        <!--
        schema为数据库名，oracle需要配置，mysql不需要配置；
        tableName为对应的数据库表名；
        domainObjectName 是要生成的实体类名(可以不指定，默认按帕斯卡命名法将表名转换成类名)；
        enableXXXByExample 默认为 true， 为 true 会生成一个对应Example类，帮助你进行基础的增删改查，不想要可以设为false。
        -->
        <!--
        -->
        <table tableName="%">
            <!--主键-->
            <!--MODEL FIELD命名：是否禁用MODEL属性驼峰命名，true禁用则完全使用字段名-->
            <property name="useActualColumnNames" value="false"/>
            <!--MODEL CLASS命名：去除或替换表前缀-->
            <!--
            <domainObjectRenamingRule searchString="^ADMIN" replaceString=""/>
            -->
        </table>
        
        <!--
        <table schema="btf_paysys" tableName="auth_permission" domainObjectName="AuthPermission"></table>
        <table schema="btf_paysys" tableName="auth_rm" domainObjectName="AuthRole"></table>
        <table schema="btf_paysys" tableName="auth_role" domainObjectName="AuthRole"></table>
        <table schema="btf_paysys" tableName="auth_rp" domainObjectName="AuthRp"></table>
        <table schema="btf_paysys" tableName="auth_ur" domainObjectName="AuthUr"></table>
        <table schema="btf_paysys" tableName="auth_users" domainObjectName="AuthUsers"></table>
        <table schema="btf_paysys" tableName="merchant" domainObjectName="Merchant"></table>
        <table schema="btf_paysys" tableName="merchant_config_info" domainObjectName="MerchantConfigInfo"></table>
        <table schema="btf_paysys" tableName="order_info" domainObjectName="OrderInfo"></table>
        <table schema="btf_paysys" tableName="payment_info" domainObjectName="PaymentInfo" ></table>
        <table schema="btf_paysys" tableName="refund_info" domainObjectName="RefundInfo" ></table>
        <table schema="btf_paysys" tableName="badoc_dic_type" domainObjectName="DocDicType" ></table>
        <table schema="btf_paysys" tableName="badoc_dic_business_type" domainObjectName="DocDicTypeBo" ></table>
        -->

    </context>
</generatorConfiguration>
```

# Advanced Configuration (进阶增强配置)

> 如果只基础配置时，以下需求的时候如何处理：  
> 要求DAO目录下的类后缀都为DAO，Model和Mapper目录相同；  
> 优化注释中无用的内容，能否自定义；  
> 实体类自动支持lombok注解；  
> 显然基础的配置无法满足像类似需求，大佬们早就有成熟的轮子（插件），当然也可以自己造轮子。

## Plugin (功能插件)
插件在基础配置上增强了Generator的功能，现有的分为原生插件和第三方插件。

### 原生插件
```XML
<!--MODEL对象增加equals和hashCode方法-->
<plugin type="org.mybatis.generator.plugins.EqualsHashCodePlugin"/>
<!-- JavaBean 实现 序列化 接口 -->
<plugin type="org.mybatis.generator.plugins.SerializablePlugin"/>
<!-- generator 时,为类生成toString -->
<plugin type="org.mybatis.generator.plugins.ToStringPlugin"/>
```
### 第三方插件
```XML
<!-- 提供clientSuffix、exampleSuffix、modelSuffix来修改对应生成的类和文件的结尾 -->
<plugin type="com.itfsw.mybatis.generator.plugins.TableRenameConfigurationPlugin">
    <!-- TbMapper -> TbDao, TbMapper.xml -> TbDao.xml -->
    <property name="clientSuffix" value="Dao"/>
    <!--  发现如果使用这个修改example后缀后，指定example类目录的插件就会失效-->
    <!--            <property name="exampleSuffix" value="Query"/>-->
    <!-- 实体类添加后缀-->
    <property name="modelSuffix" value="Model"/>
</plugin>

<!-- Example 目标包修改插件 -->
<plugin type="com.itfsw.mybatis.generator.plugins.ExampleTargetPlugin">
    <!-- 修改Example类生成到目标包下 -->
    <property name="targetPackage" value="com.hui.javalearn.dao.example"/>
</plugin>

<!-- 自定义注释插件 -->
<plugin type="com.itfsw.mybatis.generator.plugins.CommentPlugin">
    <!-- 自定义模板路径 -->
    <property name="template" value="${mybatis.comment.file}"/>
</plugin>

<!-- Lombok插件 去除模型中的get和set ,用@Data注解取代 -->
<plugin type="com.itfsw.mybatis.generator.plugins.LombokPlugin">
    <!-- @Data 默认开启,同时插件会对子类自动附加@EqualsAndHashCode(callSuper = true)，@ToString(callSuper = true) -->
    <property name="@Data" value="true"/>
    <!-- @Builder 必须在 Lombok 版本 >= 1.18.2 的情况下开启，对存在继承关系的类自动替换成@SuperBuilder -->
    <property name="@Builder" value="true"/>
    <!-- @NoArgsConstructor 和 @AllArgsConstructor 使用规则和Lombok一致 -->
    <property name="@AllArgsConstructor" value="true"/>
    <property name="@NoArgsConstructor" value="true"/>
    <!-- @Getter、@Setter、@Accessors 等使用规则参见官方文档 -->
    <property name="@Accessors(chain = true)" value="true"/>
    <!-- 临时解决IDEA工具对@SuperBuilder的不支持问题，开启后(默认未开启)插件在遇到@SuperBuilder注解时会调用ModelBuilderPlugin来生成相应的builder代码 -->
    <property name="supportSuperBuilderForIdea" value="true"/>
</plugin>
```

### 自己封装插件

## Comment (注释模版)
为了修改生成默认注释的内容，使用第三方plugin配置生成自定义注释，通过添加指定的注释模版文件，并在generator配置中指定加载，以便每次生成代码携带定制化注释内容。
```XML
<!-- 自定义注释插件 -->
<plugin type="com.itfsw.mybatis.generator.plugins.CommentPlugin">
    <!-- 自定义模板路径 -->
    <property name="template" value="${mybatis.comment.file}"/>
</plugin>
```
```XML
<?xml version="1.0" encoding="UTF-8"?>
<template>
    <!-- #############################################################################################################
    /**
     * This method is called to add a file level comment to a generated java file. This method could be used to add a
     * general file comment (such as a copyright notice). However, note that the Java file merge function in Eclipse
     * does not deal with this comment. If you run the generator repeatedly, you will only retain the comment from the
     * initial run.
     *
     * The default implementation does nothing.
     *
     * @param compilationUnit
     *            the compilation unit
     */
    -->
    <comment ID="addJavaFileComment">
<![CDATA[
/**
 * @author: Yuan
 * @date : ${.now?string["yyyy-MM-dd HH:mm:ss"]}
 */
]]>
    </comment>
    <!-- #############################################################################################################
    /**
     * This method should add a suitable comment as a child element of the specified xmlElement to warn users that the
     * element was generated and is subject to regeneration.
     *
     * @param xmlElement
     *            the xml element
     */
    -->
    <comment ID="addComment">
<!--<![CDATA[-->
<!--&lt;!&ndash;-->
<!--WARNING - ${mgb}-->
<!--This element is automatically generated by MyBatis Generator, do not modify.-->
<!--@project https://github.com/itfsw/mybatis-generator-plugin-->
<!--&ndash;&gt;-->
<!--]]>-->
    </comment>

    <!-- #############################################################################################################
    /**
     * This method is called to add a comment as the first child of the root element. This method could be used to add a
     * general file comment (such as a copyright notice). However, note that the XML file merge function does not deal
     * with this comment. If you run the generator repeatedly, you will only retain the comment from the initial run.
     *
     * The default implementation does nothing.
     *
     * @param rootElement
     *            the root element
     */
    -->
    <comment ID="addRootComment"></comment>

    <!-- #############################################################################################################
    /**
     * This method should add a Javadoc comment to the specified field. The field is related to the specified table and
     * is used to hold the value of the specified column.
     *
     * <b>Important:</b> This method should add a nonstandard JavaDoc tag "@mbg.generated" to the comment. Without
     * this tag, the Eclipse based Java merge feature will fail.
     *
     * @param field
     *            the field
     * @param introspectedTable
     *            the introspected table
     * @param introspectedColumn
     *            the introspected column
     */
    -->
    <comment ID="addFieldComment">
<![CDATA[
<#if introspectedColumn??>
/**
 *
<#if introspectedColumn.remarks?? && introspectedColumn.remarks != ''>
<#list introspectedColumn.remarks?split("\n") as remark>
 * 备注:${remark}
 </#list>
</#if>
 *
 * 表字段:: ${introspectedTable.fullyQualifiedTable}.${introspectedColumn.actualColumnName}
 */
<#else>
</#if>
]]>
    </comment>

    <!-- #############################################################################################################
    /**
     * Adds a comment for a model class.  The Java code merger should
     * be notified not to delete the entire class in case any manual
     * changes have been made.  So this method will always use the
     * "do not delete" annotation.
     *
     * Because of difficulties with the Java file merger, the default implementation
     * of this method should NOT add comments.  Comments should only be added if
     * specifically requested by the user (for example, by enabling table remark comments).
     *
     * @param topLevelClass
     *            the top level class
     * @param introspectedTable
     *            the introspected table
     */
    -->
    <comment ID="addModelClassComment">
<![CDATA[
/**
<#if introspectedTable.remarks?? && introspectedTable.remarks != ''>
 *
<#list introspectedTable.remarks?split("\n") as remark>
 * ${remark}
</#list>
</#if>
 *
 * 表名: ${introspectedTable.fullyQualifiedTable}
 */
]]>
    </comment>

    <!-- #############################################################################################################
    /**
     * Adds the inner class comment.
     *
     * @param innerClass
     *            the inner class
     * @param introspectedTable
     *            the introspected table
     * @param markAsDoNotDelete
     *            the mark as do not delete
     */
    -->
    <comment ID="addClassComment">
<![CDATA[
/**
 *
 * ${introspectedTable.fullyQualifiedTable}
 *
 * ${mgb}<#if markAsDoNotDelete?? && markAsDoNotDelete> do_not_delete_during_merge</#if>
 */
]]>
    </comment>

    <!-- #############################################################################################################
    /**
     * Adds the enum comment.
     *
     * @param innerEnum
     *            the inner enum
     * @param introspectedTable
     *            the introspected table
     */
    -->
    <comment ID="addEnumComment">
<![CDATA[
/**
 *
 * ${introspectedTable.fullyQualifiedTable}
 *
 */
]]>
    </comment>

    <!-- #############################################################################################################
    /**
     * Adds the interface comment.
     *
     * @param innerInterface
     *            the inner interface
     * @param introspectedTable
     *            the introspected table
     */
    -->
    <comment ID="addInterfaceComment">
<![CDATA[
/**
 *
 * ${introspectedTable.fullyQualifiedTable}
 */
]]>
    </comment>

    <!-- #############################################################################################################
    /**
     * Adds the getter comment.
     *
     * @param method
     *            the method
     * @param introspectedTable
     *            the introspected table
     * @param introspectedColumn
     *            the introspected column
     */
    -->
    <comment ID="addGetterComment">
<![CDATA[
<#if introspectedColumn??>
/**
 * 表字段: ${introspectedTable.fullyQualifiedTable}.${introspectedColumn.actualColumnName}
 *
 * @return the value of ${introspectedTable.fullyQualifiedTable}.${introspectedColumn.actualColumnName}
 */
<#else>
/**
 * field ${method.name?replace("get","")?replace("is", "")?uncap_first}
 *
 * @return the value of field ${method.name?replace("get","")?replace("is", "")?uncap_first}
 *
 */
</#if>
]]>
    </comment>

    <!-- #############################################################################################################
    /**
     * Adds the setter comment.
     *
     * @param method
     *            the method
     * @param introspectedTable
     *            the introspected table
     * @param introspectedColumn
     *            the introspected column
     */
    -->
    <comment ID="addSetterComment">
<![CDATA[
<#if introspectedColumn??>
/**
 * 表字段: ${introspectedTable.fullyQualifiedTable}.${introspectedColumn.actualColumnName}
 *
 * @param ${method.parameters[0].name} the value for ${introspectedTable.fullyQualifiedTable}.${introspectedColumn.actualColumnName}
 */
<#else>
/**
 *
 *  field ${method.name?replace("set","")?uncap_first}
 *
 * @param ${method.parameters[0].name} the value for field ${method.name?replace("set","")?uncap_first}
 *
 */
</#if>
]]>
    </comment>

    <!-- #############################################################################################################
    /**
     * Adds the general method comment.
     *
     * @param method
     *            the method
     * @param introspectedTable
     *            the introspected table
     */
    -->
    <comment ID="addGeneralMethodComment">

    </comment>
</template>
```