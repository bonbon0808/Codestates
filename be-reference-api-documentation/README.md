# API 문서화 레퍼런스 코드

### Description
API 문서화 레퍼런스 코드는 유어클래스 컨텐츠에서 사용되는 코드 + 라이브 세션에서 사용되는 예제 코드로 구성되어 있습니다.
* 라이브 세션용 예제 코드
  * [Controller에서 Stub 사용 예제 코드](#controller에서-stub-사용-예제-코드)
  * [AOP를 이용한 Stub 사용 예제 코드](#aop를-이용한-stub-사용-예제-코드)
  
> 예제 코드에 대한 더 구체적인 정보는 아래에서 확인하세요.

---

### Controller에서 Stub 사용 예제 코드
Controller에서 Stub을 사용함으로써 서비스 계층 및 데이터 액세스 계층의 코드 구현 없이 API 엔드포인트 호출 테스트 기능을 빠르게 제공하기 위한 예제 코드입니다.
* 소스 코드 경로
  * [src/main/java/com/codestates/example/stub_example/fix_stub_controller](https://github.com/codestates-seb/be-reference-api-documentation/tree/main/src/main/java/com/codestates/example/stub_example/fix_stub_controller)

---

### AOP를 이용한 Stub 사용 예제 코드
AOP를 통해 Controller에 Stub을 부가 기능으로 제공함으로써 Controller에서 Stub을 제거할 수 있는 예제 코드입니다.
* 소스 코드 경로
  * [src/main/java/com/codestates/example/stub_example/stub_advice](https://github.com/codestates-seb/be-reference-api-documentation/tree/main/src/main/java/com/codestates/example/stub_example/stub_advice)
  
---
