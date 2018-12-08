# QueryDSL
Demo QueryDSL

## QueryDSL generate sources `mvn package`
apt-maven-plugin contains JPAannotationProcessor which generates QObjects. Go to target/generated-sources to check out the generated QPerson. They contain the metadata for each entity table.
QPerson is a generated class for the Person entity.

## Browser test
### Index controller
[http://localhost:8080/](http://localhost:8080/)
### People controller
[http://localhost:8080/people?search=Ivan](http://localhost:8080/people?search=Ivan)
### Data Base console
[http://localhost:8080/h2-console/](http://localhost:8080/h2-console/)

`JDBC URL:` `jdbc:h2:mem:demodb`
