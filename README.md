thymeleaf-aows-dialect
======================

This Thymeleaf Dialect is a set of utilities for your templates.

Usage
-----

Adding the dialect to your thymeleaf templates:

	<bean id="templateEngine" class="org.thymeleaf.spring3.SpringTemplateEngine">
		<property name="templateResolvers">
			<list>
				<ref bean="templateResolver" />
			</list>
		</property>
		<property name="additionalDialects">
			<set>
				<bean class="ws.otero.adrian.thymeleaf.AowsDialect" />
			</set>
		</property>
	</bean>

Maven dependency:

	<dependency>
		<groupId>ws.otero.adrian.thymeleaf</groupId>
		<artifactId>aows-dialect</artifactId>
		<version>0.0.1</version>
	</dependency>

In your templates...

### aows:hotdate

info coming soon


Changelog
---------

### 0.0.1
 - First version of the AOWS dialect
 - Introducing the *hotdate* attr


About the author
----------------

 - Adrian Otero (http://adrian.otero.ws)
