# Spring Boot 개념과 활용

- 스프링부트 프로젝트 구조 

  : main application 보다 하위구조에 있는 클래스들은 모두 빈으로 등록되어
 스프링이 스캔한다. 
 
- 의존성 관리 이해 
 
  :parent pom을 통해 거슬러 올러가면 모든 버전들이 정의되어있어서 직접 버전을 명시하지 않아도
  자동으로 적절한 버전을 찾아와 사용할 수 있다.
  
  - 이점 : `관리해야할 의존성들이 줄어든다.` 
  * dependency 버전을 명시하는 버릇을 들이자
  
  (cf: ModelMapper dependency : DTO 랑 domain 객체랑 필드 값을 매핑해준다. )
  
 - 자동 설정 개요
 
 
  * @EnableAutoConfiguration(@SpringBootApplication 안에 있다)
  * Bean은 두 단계로 나눠서 읽힌다.
    - 1 : @ComponentScan
    - 2 : @EnableAutoConfiguration
    - `똑같은 빈을 다르게 등록한다면 AutoConfiguration이 앞의 ComponentScan이 등록한 빈을 덮어 쓴다`
    
    
  * @ComponentScan : component 어노테이션을 가진 애들은 스캔하여 bean으로 등록 
    - @Component : 개발자가 직접 작성한 class -> bean등록 
    - @Configuration : spring IOC 컨테이너에게 해당 클래스를 bean 구성 class 임을 명시
      
      @Repository
      
      @Service
      
      @Controller : view 반환
     
      @RestController : Json형태로 객체 데이터 반환 
      
      
  * @EnableAutoConfiguration
    - spring.factories 밑에 있다.
    - @Configuration
    - @ConditionalOn~~~ : 조건부여 
   
   
- 자동 설정 구현 
  - Xxx-Spring-Boot-`Autoconfigure` 모듈 : 자동 설정
  - Xxx-Spring-Boot-Starter 모듈 : 필요한 의존성 정의 
  
  - 설정 순서 
    1. pom.xml 에 dependency 추가
    2. @Configuration 파일 작성
    3. src/main/resource/META-INF에 spring.factories 파일 만들기
    4. spring.factories 안에 자동 설정 파일 추가 
    5. mvn install
    
    - ####`똑같은 빈을 다르게 등록한다면 AutoConfiguration이 앞의 ComponentScan이 등록한 빈을 덮어 쓴다`
    - ####`"ComponentScan이 등록한 빈이 더 우선시 되어야한다"`
   * 덮어쓰기 방지하기
   
      * @ConditionalOnMissingBean
   * 빈 재정의에 대한 수고 덜기 
     - @ConfigurationProperties("Holoman")
     - @EnableConfigurationProperties("HolomanProperties")
     - 프로퍼티 키 값 자동 완성 
     
    
   -  ####  내장 서블릿 컨테이너
   
      - 스프링 부트는 서버가 아니다.
        - 톰캣 객체 생성
        - 포트 설정
        - 톰켓에 컨텍스트 추가
        - 서블릿 만들기
        - 톰켓에 서블릿 추가
        - 컨텍스트에 서블릿 맵핑
      - 이 모든 과정을 보다 유연하게 설정 및 실행 -> 스프링 부트 자동설정
      
      - ##### 서블릿 컨테이너를 만드는 것과 서블릿을 만드는 것이 나뉘어서 작동함
      
   - ### Spring 웹 MVC
     - 자동 설정으로 제공하는 여러 기본 기능
     - Spring MVC 확장
        - @Configuration + WebMvcConfigurer
     - Spring MVC 재정의
        - @Configuration + @EnableWebMvc
      
      
### 4부 . 스프링 부트 활용

  - ApplicationEvent 등록 
    - applicationContext 만들기 전에 사용하는 리스너는 @Bean으로 등록할 수 없다.
        - SpringApplication.addListners()로 실행
  - WebApplication Type 설정
  - 애플리케이션 아규먼트 사용하기
    - ApplicationArgument를 빈으로 등록해주니까 가져다 쓰면 된다.
  - 애플리케이션 실행한 뒤 뭔가 실행해야 한다면
    - ->` ApplicationRunner` OR  CommandLineRunner
    - 순서 지정 -> @Order
    
  -  ### 외부설정
     - properties / YAML / 환경 변수 / 커맨드 라인 아규먼트
     - 타입-세이프 프로퍼티 @ConfigurationProperties
        - 여러 프로퍼티를 묶어서 읽을 수 있다.
        - 빈으로 등록하여 다른 빈에 주입할 수 있다
            - @EnableConfigurationProperties
            - ` @Component`
            - @Bean
        - 융통성 있는 바인딩
            - context-path(케밥)
            - context_path(언더스코어)
            - contextPath(카멜)
            - CONTEXTPATH
        - 프로퍼티 타입 컨버젼
            - @DurationUnit
        - 프로퍼티 값 검증
            - @Validated
            - @JSR-303
            
  - ### 프로파일
    - @Profile 위치 
        - @Configuration
        - @Component
    - 어떤 프로파일을 활성화 할 것인가
        - spring.profiles.active
        - spring.profiles.include(어떤 프로퍼티를 추가할 것인가)
        
        
  - ### 로깅
  
    - 로깅 퍼사드 vs 로거 
    - SLF4j(심플로깅퍼사) , Commons Logging (로깅 퍼사드)
    - 로깅 퍼사드의 장점 : log 를 바꿔쓸 수 있어서 , 프레임을 쓰는 애플리케이션에서 로그를 원하는 걸로 바꿀 수 있다. 
    
    - Spring - JCL 
        - Commons Logging -> SLF4j 
        - pom.xml 에 exclusion 안해도 됌 
        
    - 스프링 부트 로깅
       - 기본 포맷
       - --debug : 일부 핵심 라이브러리맘ㄴ 디버깅 모드로
       - --trace : 전부 다 디버깅 
       - 컬러 출력 : SPring.output.ansi.enabled( 기본은 콘솔에만 출력함 )
       - 파일 출력 : Logging.file (파일 지정)또는 logging.path(디렉토리 경로 설정)
       - 로그 레벨 조정 : Logging.level 패키지 = 로그 레벨 
       
       
  -  로그 : 커스텀 로그 설정 파일 사용하기
    - Logback : logback-spring.xml
    - Log4J2 : log4j2-spring.xml
    - Logback extension : 프로파일 <springProfile name ="프로파일">
    
    
  - 테스트 
    - @SpringBootTest
        - @Runwith(SpringRunner.class) 와 함꼐 사용
        - 빈 설정 파일은 알아서 찾는다.
        - webEnvironment
            - MOCK : mock servlet environment 내장 톰캣 구동 안함
            - RANDON_PORT, DEFINED_PORT : 내장 톰캣 사용 
            - NONE  : 서블릿 환경 제공 안 함.
    
    - MockBean 
        - ApplicationContext에 들어있는 빈을 Mock으로 만든 객체로 교체 함.
        - 모든 @Test 마다 자동으로 리셋
    
    
   
    
        