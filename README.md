## Project : Devs on Deck -- Soloproject --
#### Wireframe
```
	![DevsOnDeck](https://github.com/MoneemSuibgui/DevsOnDeck/assets/125930635/955762a4-6067-4333-ad3b-7ff2fffdad06)
```
#### Tasks :
```
    • Implement CRUD of the application
    • Creation of forms with fields validation
    • Effective use of REST APIs and tested using Postman
    • Implementation of MVC architecture
```

#### Key achivements :
```
    I developed web site for developers and recruiters
```
#### Technologies:
```
    HTML5, Bootstrap library, JavaScript, Springboot framework, MySQL
```
#### Dependencies needed for project :
```
    <!-- DEPENDENCIES FOR STARTING SPRING PROJECTS-->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		
   <!-- DEPENDENCY FOR USING H2 DATAASE & junit  & assertj  -->
		<dependency>
		    <groupId>com.h2database</groupId>
		    <artifactId>h2</artifactId>
		    <scope>test</scope>
		</dependency>
		<dependency>
		    <groupId>junit</groupId>
		    <artifactId>junit</artifactId>
		    <scope>test</scope>
		</dependency>
		<dependency>
		    <groupId>org.assertj</groupId>
		    <artifactId>assertj-core</artifactId>
		    <scope>test</scope>
		</dependency>
   <!-- DEPENDENCIES FOR DISPLAYING JSPS AND USING JSTL TAGS -->
		<dependency>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-jasper</artifactId>
		</dependency>
		<dependency>
			<groupId>jakarta.servlet.jsp.jstl</groupId>
			<artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
		</dependency>
		<dependency>
			<groupId>org.glassfish.web</groupId>
			<artifactId>jakarta.servlet.jsp.jstl</artifactId>
		</dependency>
   <!-- DEPENDENCIES FOR INTEGRATING SQL DATABASE AND USING JPA -->
   <!-- Note: Project will not run until a schema has been created and the
        proper settings in application properties are present for
        connecting to a database. -->
		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
   <!-- DEPENDENCY FOR USING VALIDATION ANNOTATIONS -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
		<!-- DEPENDENCY FOR USING BCRYPT  -->
		<dependency>
			<groupId>org.mindrot</groupId>
			<artifactId>jbcrypt</artifactId>
			<version>0.4</version>
		</dependency>
   <!-- DEPENDENCIES FOR BOOTSTRAP -->
		<dependency>
			<groupId>org.webjars</groupId>
			<artifactId>webjars-locator</artifactId>
			<version>0.46</version>
		</dependency>
		<dependency>
			<groupId>org.webjars</groupId>
			<artifactId>bootstrap</artifactId>
			<version>5.2.3</version>
		</dependency>
```


#### application.properties file :

```
    # Where are jsp files? HERE!
    spring.mvc.view.prefix=/WEB-INF/
    # Data Persistence
    spring.datasource.url=jdbc:mysql://localhost:3306/<<YOUR_SCHEMA_NAME>>?
    spring.datasource.username=username
    spring.datasource.password=password
    spring.jpa.hibernate.ddl-auto=update
    # For Update and Delete method hidden inputs
    spring.mvc.hiddenmethod.filter.enabled=true
```

#### JSP tags library imports,external styling ,settings :
```
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <!-- c:out ; c:forEach etc. --> 
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <!-- Formatting (dates) --> 
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
    <!-- form:form -->
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <!-- for rendering errors on PUT routes -->
    <%@ page isErrorPage="true" %>
    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="UTF-8">
        <title>Title !!</title>
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
        <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
    </head>
    <body>
       
    </body>
    </html>
```
