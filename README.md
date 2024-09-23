# be engineer 과제

## Project 정책

- Code Test Coverage 는 90이상을 유지합니다. 실제 구현 프로젝트에서는 낮추어 사용합니다.
- Code Formatting 을 CI에서 테스트합니다.

## 사용되는 기술

- Java
  - Java 17 LTS
  - Lombok
- Spring
  - Spring Boot
  - Spring Validation
- Database
  - JPA/Hibernate
  - Spring Data JPA
  - QueryDSL
- Logging
  - Logback
- Test
  - JUnit5
  - MockWebServer
  - Mockito
  - Jedis Mock
  - Jacoco
- Code Format
  - Spotless
  - Prettier
- Build
  - Gradle with Kotlin
- Etc
  - OpenAPI
  - Gson
  - 
### 실행

### admin api

```shell
./gradlew clean :mss-admin:build
cd mss-admin/build/libs/
java -jar ./mss-admin-1.0.0.jar --spring.profiles.active=dev
```

Health Check
브라우저 실행 후 주소창에 http://localhost:8500 입력

### coordi api

```shell
./gradlew clean :mss-coordi:build
cd mss-coordi/build/libs/
java -jar ./mss-coordi-1.0.0.jar --spring.profiles.active=dev
```

Health Check
브라우저 실행 후 주소창에 http://localhost:8100 입력

### 코드 포맷팅

```shell
> ./gradlew spotlessCheck # 파일이 코드 포맷 룰을 지키고 있는지 검사
> ./gradlew spotlessApply # 파일에 코드 포맷 룰을 적용
```

### 테스트

```shell
> ./gradlew testAll
```
