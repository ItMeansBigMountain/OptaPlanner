# time-tabling Project

## INIT
```shell script
mvn clean install   
```

> **_NOTE:_**  mvn clean install tells Maven to do the clean phase in each module before running the install phase for
> each module. What this does is clear any compiled files you have, making sure that you're really compiling each module
> from scratch

## Running the application in dev mode
You can run your application in dev mode that enables live coding using:

```shell script
mvn compile quarkus:dev   
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.
