# iris-graal

graalvm & spring-boot (native) application

## Instruction

- compile: `mvn -Pnative native:compile`
- compile to image: `mvn -Pnative spring-boot:build-image`

## Another approach

GoogleContainerTools/jib

```xml
    <plugin>
        <groupId>com.google.cloud.tools</groupId>
        <artifactId>jib-maven-plugin</artifactId>
    </plugin>
```

`mvn compile jib:build -Dimage=azusachino/iris-graal:1.0.0`

## References

- [spring docs](https://docs.spring.io/spring-boot/docs/current/reference/html/native-image.html)
