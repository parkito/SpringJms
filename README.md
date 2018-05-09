# SpringMVC + ActiveMQ Publisher-Consumer example

This repository contains example of applications communicate
via ActiveMQ MOM.

## Description

**Publisher** publishes data from internal inmemory database (Derby) to
embedded message queue (embedded active mq)

**Consumer** connect to publisher's embedded queue and receivers message

**Dto** is shared data transfer object for publisher-consumer communication

Application could be compiled with javac versions 1.8, 9, 10

There is data in publisher's inmemory data base. It is being transferring via active mq
to consumer. Consumer saves data in internal inmemory data base. Data of consumer is accessible
by we UI (http://localhost/). 

<a href="https://github.com/parkito/SpringJms"><img src="https://d1.awsstatic.com/product-marketing/Messaging/sqs_seo_queue.1dc710b63346bef869ee34b8a9a76abc014fbfc9.png" title="FVCproductions" alt="FVCproductions"></a>

## How to use

1) **Dto** project should be installed to your local repository
You can use maven for it
 ```xml
 mvn install:install-file -Dfile=...\SpringTemplates\jms\dto\target\dto-1.0-SNAPSHOT.jar -DgroupId=ru.siksmfp.spring.jms -DartifactId=dto -Dversion={1.0-SNAPSHOT} -Dpackaging=jar
```
2) **Publisher** can be run by main method

3) **Consumer** can be run by main method as well.
If you want to use UI you can deploy .war of consumer on tomcat.
Web UI has path '/' 

Publisher can be run by main method. 

## License

[MIT](https://github.com/parkito/SpringJms/blob/master/LICENSE)
