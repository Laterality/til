# Hello world

Spring framework를 사용하는 프로젝트를 생성하는 방법을 설명하기 위한 예제입니다.

STS를 사용하는 방법과 사용하지 않는 방법이 있는데, 본 예제에서는 사용하지 않았습니다.

1. archetype을 `maven-archetype-webapp`으로 Maven Project를 생성합니다.
2. `pom.xml`에 의존성을 추가합니다.
   * `<properties>`에 `<spring.version>5.0.7.RELEASE</sping.version>`을 추가합니다.
   * `<dependencies>`에 다음을 추가합니다.
      ```xml
	  <groupId>org.springframework</groupId>
	  <artifactId>spring-context</artifactId>
	  <version>${spring.version}</version>
	  ```