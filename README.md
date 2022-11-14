# 구글 SMTP 서버를 이용한 이메일 전송 레퍼런스 코드

### Description
구글 SMTP 서버를 이용한 이메일 전송 레퍼런스 코드는 기본적으로 유어클래스 컨텐츠에서 사용되는 코드를 이용해 회원 가입 후, 이메일을 전송하는 로직을 구현한 예제 코드로 구성되어 있습니다.
* 라이브 세션용 예제 코드
  * [구글 SMTP 서버 사용을 위한 설정]()
  * [이메일 전송 관련 예제 코드]()
  
> 예제 코드에 대한 더 구체적인 정보는 아래에서 확인하세요.

---

### 이메일 전송 관련 예제 코드
구글 SMTP 서버와 JavaMailSender를 이용해 회원 등록 후, 이메일을 전송하는 예제 코드입니다.
* 소스 코드 경로
  * 구글 SMTP 서버 정보를 application.yml에 추가하는 부분
    * [src/main/resources/application-local.yml]()
  * 구글 SMTP 서버 설정을 위한 Spring Bean 등록
    * [src/main/com/codestates/helper/email/EmailConfiguration]()
  * 심플 이메일 전송 로직
    * [src/main/com/codestates/helper/email/SimpleEmailSendable]()
  * 템플릿 이메일 전송 로직
    * [src/main/com/codestates/helper/email/TemplateSendable]()
  * 타임리프로 구성된 이메일 템플릿
    * [src/main/resources/templates/email-registration-member.html]()

---
