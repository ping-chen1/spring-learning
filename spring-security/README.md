# spring-security
## 一、介绍
Spring Security框架提供了身份验证、授权和防止常见攻击.
## 二、前提
java 8以及更高的版本.</br>
## 三、引入
### 3.1、springboot方式
```java
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```
由于spring boot提供了Maven bom 管理版本,如果想要改变版本可以通过下面的方式:
```java
<properties>
   <spring-security.version>5.2.15.RELEASE</spring-security.version>
</dependencies>
```
或者可以通过以下方式改变spring的版本
```java
<properties>
   <spring.version>5.2.19.RELEASE</spring.version>
</dependencies>
```
如果您使用其他功能(例如LDAP,OpenID和其他功能),则还需要包含相应的项目模块.
### 3.2、非springboot方式
使用spring security bom版本来确保spring security一致的版本
```java
<dependency>
   <groupId>org.springframework.security</groupId>
   <artifactId>spring-security-bom</artifactId>
   <version>5.2.15.RELEASE</version>
   <type>pom</type>
   <scope>import</scope>
</dependency>
```
最小的spring security依赖如下：
```java
<dependency>
   <groupId>org.springframework.security</groupId>
   <artifactId>spring-security-web</artifactId>
</dependency>
<dependency>
   <groupId>org.springframework.security</groupId>
   <artifactId>spring-security-config</artifactId>
</dependency>
```
## 四、特性

Spring Security为身份验证,授权和防止常见利用提供全面支持.它还提供与其他库的集成以简化其使用.

## 五、项目模块
spring security3.0之后,代码被分为单独的jar模块.
### 5.1、core --> spring-security-core.jar
包括核心认证和访问控制类和接口,远程支持和基本配置API.每一个使用spring Security的应用都需要引入.支持独立的应用,远程客户端,服务层方法安全和JDBC用户配置,包含下面的包:
* org.springframework.security.core
* org.springframework.security.access
* org.springframework.security.authentication
* org.springframework.security.provisioning
### 5.2、Remoting --> spring-security-remoting.jar
提供spring 远程应用的整合,只有使用spring rmoting 编写远程客户端的时候才会使用到,主要的包：
* org.springframework.security.remoting
