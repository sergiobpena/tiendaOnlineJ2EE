# ENTORNO DE DESARROLLO
Conversión do proxecto de eclipse a maven
## ESTRUTURA DE CARPETAS
Reproduccion do arquetipo web de maven :
````
mvn archetype:generate \
    -DgroupId=org.sergio.tenda \
    -DartifactId=TendaJEE \
    -DarchetypeArtifactId=maven-archetype-webapp \
    -DinteractiveMode=false
````
Quedando:

````
+ src-
    + main -
        + java - 
            + tenda - 
                + controlador - 
                + modelo      -
    + test
        + java
````
## POM
### Dependencias

- Webapi
- MysqlConnector
- JSTL

### Probando:

````
mvn tomcat7:run
````