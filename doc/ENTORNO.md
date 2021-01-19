# ENTORNO DE DESARROLLO
Conversión do proxecto de eclipse a maven
## MAVEN
### ESTRUTURA DE CARPETAS
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
### POM
#### Dependencias

- Webapi
- MysqlConnector
- JSTL

#### Probando:

````
mvn tomcat7:run
````
## MYSQL
### Docker
- Scripts de inicio :
  - Engadir o docker-compose o volume a `- "./images/mysql/scripts/init.sql:/docker-entrypoint-initdb.d/1.sql"`
    
- Persistencias :
  - Persistir os cambio na bd establecendo o volume `- "./images/mysql/db:/var/lib/mysql"`
    


