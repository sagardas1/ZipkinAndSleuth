##### Zipkin and Sleuth
Step1: Download zipkin-server-2.12.9-exec.jar.zip.  
and extract the zip file \
and make it up by \
```java -jar zipkin-server-2.12.9-exec.jar``` \
i.e : \
 ```java -Xms512M -Xmx1024M -Dserver.port=9411 -jar zipkin-server-2.12.9-exec.jar --STORAGE_TYPE=mem```
1. Increase the heap memory size \
```-Xms512M -Xmx1024M```
2. give the server port \
   ```-Dserver.port=9411```
3. give the storage :
```--STORAGE_TYPE=mem``` \
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
Add
```
spring.zipkin.base-url= http://localhost:9411
spring.sleuth.sampler.probability=1.0
```



