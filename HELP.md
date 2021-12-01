# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/#build-image)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-spring-mvc-template-engines)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-developing-web-applications)
* [Java Mail Sender](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-email)
* [Spring Security](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-security)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)



### PostgresSQL setup
	## Step 1
	sudo -u postgres createuser --interactive --password thedaycare
	Shall the new role be a superuser? (y/n) n
	Shall the new role be allowed to create databases? (y/n) y
	Shall the new role be allowed to create more new roles? (y/n) n
	Password: thedaycare

	## Step 2
	sudo -u postgres createdb thedaycare -O thedaycare


	## Step 3
	sudo vim /etc/postgresql/10/main/pg_hba.conf
	# "local" is for Unix domain socket connections only
	# local   all             all                                     peer    # OG
	local   all             all                                     trust
	# IPv4 local connections:
	# host    all             all             127.0.0.1/32            md5     # OG
	host    all             all             127.0.0.1/32            trust


	## Step 4
	sudo service postgresql restart


	## Step 5
	psql -U thedaycare -d thedaycare -W

