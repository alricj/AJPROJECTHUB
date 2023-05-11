This application is a spring boot rest application that exposes the following api's:
http://localhost:8080/api/adduser
this is Post to the rest service of the user record in json
http://localhost:8080/api/alluser
the above returns all the user as json objects
http://localhost:8080/api/delete/105 for example (the number 105 is an id I wish to delete)
the above api call makes it possible to delete a user by id
http://localhost:8080/api/52 (the number 52 is an id I wish to find)
the above api call makes it possible to find a user by id


There is no need to stand up tomcat, this run with tomcat embedded
java -jar <with the generated war file> should kick this off from the command line
The code can be easily loaded into your IDE as an existing Maven project.
The required version of java is 17 to 20 since the application is written with spring boot
3.0.1

This application will require the creation of a relational database schema called 'bcbsusers'
this was implemented using mysql, reference as follows: https://dev.mysql.com/doc/mysql-getting-started/en/

as follows:
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/bcbsusers
spring.datasource.username=root
spring.datasource.password=<supply your password>
spring.jpa.hibernate.ddl-auto=update

The application runs on the default port 8080
so that the following url should bring up the login page the first time:
http://localhost:8080/api
so that you can see front page listing of the users for scrolling and paginating

The login page is just basic for now. the account is set to admin/admin

after logging in you will be forwarded to the users where you ar able to paginate through 3 records at a time.

I have overridden the 10 records per page so that the pagination can be shown with few records.

The following requirements are met:
2.	The frontend
a.	Build a Typescript frontend (feel free to use a framework or not)
    that presents a login form and communicates with the above NodeJS or Java Service.
b.	Once authenticated, paginate the list of resources
c.	The user should be able to Add and Remove items.

The frontend is built wit a combination of html and jquery.
when the following.


I would love to have the time to implement the spring boot in memory authentication and authorization.
Hope to be given the chance to show how it is done.

It would have like to write the test suite.

beautifying the ui a bit more




