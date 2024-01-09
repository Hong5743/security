# security

## Spring Security란?
스프링 시큐리티는 인증 (Authentication) ,권한(Authorize) 부여 및 보호 기능을 제공하는 프레임워크다.

Java / Java EE 프레임워크

개발을 하면서 보안 분야는 시간이 많이 소요되는 활동들 중 하나다. Spring Security를 사용함으로써 짜여진 내부 로직을 통해 인증, 권한 확인에 필요한 기능과 옵션들을 제공한다.

## 인증(Authentication) , 인가(Authorization)
인증과 인가란 무엇일까? 보통 인증 절차를 거친 후 인가 절차를 진행한다.

인증: 해당 사용자가 본인이 맞는지를 확인하는 절차.
인가: 인증된 사용자가 요청된 자원에 접근가능한가를 결정하는 절차

## Spring Security의 특징
Filter를 기반으로 동작한다.
Spring MVC와 분리되어 관리하고 동작할 수 있다.
Bean으로 설정할 수 있다.
Spring Security 3.2부터는 XML설정을 하지 않아도 된다.

## Spring Security Architecture(구조)
![화면 캡처 2024-01-09 130951](https://github.com/Hong5743/security/assets/136396772/2bb67df3-fba1-4c31-84d3-ecbd8a95b566)

이 사진은 스프링 시큐리티의 아키텍처 사진이고 스프링 시큐리티의 흐름은 아래와 같다.

1. Http Request 수신 

-> 사용자가 로그인 정보와 함께 인증 요청을 한다.

2. 유저 자격을 기반으로 인증토큰 생성 

-> AuthenticationFilter가 요청을 가로채고, 가로챈 정보를 통해 UsernamePasswordAuthenticationToken의 인증용 객체를 생성한다.

3. FIlter를 통해 AuthenticationToken을 AuthenticationManager로 위임

-> AuthenticationManager의 구현체인 ProviderManager에게 생성한 UsernamePasswordToken 객체를 전달한다.

4. AuthenticationProvider의 목록으로 인증을 시도

-> AutenticationManger는 등록된 AuthenticationProvider들을 조회하며 인증을 요구한다.

5. UserDetailsService의 요구

-> 실제 데이터베이스에서 사용자 인증정보를 가져오는 UserDetailsService에 사용자 정보를 넘겨준다.

6. UserDetails를 이용해 User객체에 대한 정보 탐색

-> 넘겨받은 사용자 정보를 통해 데이터베이스에서 찾아낸 사용자 정보인 UserDetails 객체를 만든다.

7. User 객체의 정보들을 UserDetails가 UserDetailsService(LoginService)로 전달

-> AuthenticaitonProvider들은 UserDetails를 넘겨받고 사용자 정보를 비교한다.

8. 인증 객체 or AuthenticationException

-> 인증이 완료가되면 권한 등의 사용자 정보를 담은 Authentication 객체를 반환한다.

9. 인증 끝

-> 다시 최초의 AuthenticationFilter에 Authentication 객체가 반환된다.

10. SecurityContext에 인증 객체를 설정

-> Authentication 객체를 Security Context에 저장한다.

최종적으로는 SecurityContextHolder는 세션 영역에 있는 SecurityContext에 Authentication 객체를 저장한다. 사용자 정보를 저장한다는 것은 스프링 시큐리티가 전통적인 세선-쿠키 기반의 인증 방식을 사용한다는 것을 의미한다.

