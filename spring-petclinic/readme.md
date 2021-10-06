## 백기선님의 예제로 배우는 스프링 입문 강좌

### Spring PetClinic Sample Application [![Build Status](https://travis-ci.org/spring-projects/spring-petclinic.png?branch=main)](https://travis-ci.org/spring-projects/spring-petclinic/)

##### Understanding the Spring Petclinic application with a few diagrams
<a href="https://speakerdeck.com/michaelisvy/spring-petclinic-sample-application">See the presentation here</a>

## Running petclinic locally
Petclinic is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Maven](https://spring.io/guides/gs/maven/). You can build a jar file and run it from the command line:


# 8강. DI(Dependency Injection)
-필요한 의존성을 어떻게 받아올 것인가. 

**@Autowired / @Inject를 어디에 붙일까**

**생성자(권장)**
:` 필수적으로 사용해야하는 레퍼런스없이는 인스턴스를 만들지 못하도록 강제할 수 있기 떄문에`
* 필드
* Setter
`(예외 : 순환참조 - A와 B가 서로 참조시에 생성자 Injection 사용으 만들지 못한다.
따라서 필드 or Setter Injection 을 사용해야한다. )`
- 과제 : 
 ownerController에 petRepository  주입하기 

# 9강. AOP(Aspect Oriented Program) 
- 흩어진 코드를 한 곳으로 모아 

: `어떤 로직을 기준으로 핵심적인 관점, 부가적인 관점으로 나누어서, 그 관점을 기준으로 각각 모듈화한다.`
- 소스 코드상에서 다른 부분을 반복하여 쓰는 코드 -> 수정 시에도 일일이 수정해줘야하는 번거로움 존재 
- `AOP의 취지 : 이 부분들을 Aspect로 모듈화하고 핵심적인 비즈니스 로직에서 분리하여 재사용` 

**다양한 AOP 구현 방법**
- Compile (A.java -> (AOP) -> A.class(AspectJ))
- ByteCode 조작(A.java -> A.class->(AOP)->메모리)
- **` 프록시 패턴 (Spring AOP) : 디자인 패턴을 사용하여 AOP 효과 구현`**
 
 # 10강 프록시 패턴 

- 기존코드를 변경하지 않고 기능을 추가할 수 있다.
- `한 클래스가 Spring AOP 의 대상이라면 그 기존 클래스의 빈이 만들어질 떄, Spring AOP가 
프록스(기능이 추가된 클래스)자동으로 만들고 원본 클래스 대신 프록시를 -> 빈으로 등록한다.`
- 그리고 원본 클래스가 사용되는 지점에서 프록시를 대신 사용한다. 

- ex)  `@Transactional`


# 11강 Spring @AOP
- 직접 AOP 기능 구현해보기  
- @LogExecutionTime 으로 메스도 처리 시간 로깅하기 
- @LogExecutionIme  Annotation은 실제 기능이 아닌 `Marker의 역할만 수행`
- 실제 기능은 Aspect(Aspect class)가 @LogExecutionTime 어노테이션이 달린 곳을 찾아 적용

# 12강 Spring PSA(Portable Service Abstraction)
-기존  서블릿 기반으로 url mapping이 동작 -> Spring 어노테이션을 통하여 동작 

###### **스프링 웹 MVC**

 - Model / View / Controller
 - `@Controller & @RequestMapping`
 - `Servlet or Reactive`
 - `Tomcat, netty ...`
 - 서비스를 추상화 계층에 만듬 ->  http servlet 을 직접 쓰지 않아도 됌/ 서비스를 로우 레벨에서 사용하지 않아도 된다.  /  매핑도 간편하다. 
 
 
#### **스프링 트랜잭션**

이거하나로 해결 
- `@Transactional`

-> 기존 원래 트랜잭션 처리
dbConnection.setAutoCommit(false);

-> ...

-> dbConnection.commit or dbConnection.rollback;
