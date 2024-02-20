##### Zipkin and Sleuth
Step1: Download zipkin-server-2.12.9-exec.jar.zip.  
and make it up by \
```java -jar zipkin-server-2.12.9-exec.jar.zip``` \
Url: http://localhost:9411/zipkin/ \
Step2: Add these two dependencies in ```pom.xml``` file
```
<dependency>
<groupId>org.springframework.cloud</groupId>
<artifactId>spring-cloud-sleuth-zipkin</artifactId>
</dependency>

<dependency>
<groupId>org.springframework.cloud</groupId>
<artifactId>spring-cloud-starter-sleuth</artifactId>
</dependency>
```
Step 3:
in ```application.properties``` file \
Add \
```
spring.zipkin.base-url= http://localhost:9411
spring.sleuth.sampler.probability=1.0
```
