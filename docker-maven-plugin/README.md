# docker-maven-plugin

This plugin main use to generate a docker-compose.yml file under /root.
it has one goal name build, will bind with compile phase. You can run it with:

```sh
mvn docker:build
```

or assign parameters like below:

```sh
mvn docker:build -Dbuildimages=maven:3-jdk-7,maven:3-jdk-8
```

or set automatic execute in compile phase

    <plugin>
         <groupId>com.ericsson.mstv.plugin</groupId>
         <artifactId>docker-maven-plugin</artifactId>
         <version>1.0-SNAPSHOT</version>
           <executions>
            <execution>
                <id>build</id>
                    <phase>compile</phase>
                    <goals>
                       <goal>build</goal>
                    </goals>
            </execution>
           </executions>
    </plugin>


```sh
mvn compile
```
