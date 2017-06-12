# GAE-Restful-Jersey-Spring-Hibernate [Eclipse Project]
Application is used GAE with Restful Jersey + Spring + Hibernate Configration

# Requirement
Java 8
App Engine SDK[App Engine 1.9.34]

# Details

RestSrpingGAE is the application with jar file so need to import in eclipse.
mvc-dispatcher-servlet.xml need to update credential for mysql 

<bean id="dataSource"
		class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="driverClassName" value="com.mysql.jdbc.Driver"></property>
		<property name="url"
			value="jdbc:mysql://localhost:3306/RestGae?createDatabaseIfNotExist=true"></property>
		<property name="username" value="root"></property>
		<property name="password" value="root"></property>
	</bean>

