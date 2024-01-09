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
