# Im

### 목표 : 게시판형 커뮤니티 웹사이트 제작 및 배포     

---

### <기능 수정 및 개선 내용>

#### 1. 241221 @Async 활용에 의한 사용자 경험 개선      
Problem: 회원가입 및 아이디/비밀번호 찾기 과정에서 이메일 인증 발송 시, 서버 응답 시간이 길어져 사용자가 3초의 대기 시간을 겪으면 부정적인 사용자 경험을 초래할 가능성        
Solution: @Async를 활용하여 이메일 발송 기능을 비동기 처리, 서버 응답 시간을 단축(3.2s -> 0.1s)       
Result: 이메일 인증 발송 버튼을 누른 후 사용자가 대기해야 하는 시간을 줄여, 빠르고 원활한 사용자 경험을 제공      
Link : <a href="https://yooninkwon.tistory.com/9"/>Blog    

#### 2. 241229 서버 2차 데이터 검증 기능 추가    
Problem : 클라이언트 측에서 HTML 및 JavaScript 조작을 통해 데이터 변조가 가능하여, 서버에 부적합한 데이터가 저장되는 보안 취약점 발생     
Solution : 서버에 2차 데이터 검증 로직을 추가하여 클라이언트에서 변조된 데이터를 차단하고, 입력값의 유효성과 무결성을 보장    
Result : 클라이언트 측 데이터 변조로 인해 발생할 수 있는 부적합한 데이터 저장 문제 해결    
Link : <a href="https://yooninkwon.tistory.com/11"/>Blog



---
### 현실에서 외로움을 느끼거나 주변에 털어놓기 힘든 비밀을 공유할 수 있는 커뮤니티 플랫폼입니다. 사용자가 자유롭게 고민을 나눌 수 있는 공간을 제공하는 것을 목표로 합니다.      
****개발 기간**** : 2024.12.15 ~ 2024.01.04      
****개발 인원**** : 1명 / 개인프로젝트    
****언어**** : Java 17, HTML/CSS, JavaScript     
****프레임워크**** : Spring Boot      
****DB**** : mariaDB 10.3.39    
****Server**** : AWS EC2    
****Link**** : <a href="https://yooninkwon.tistory.com/category/%EA%B0%9C%EC%9D%B8%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8/I%27m">Blog</a>       
****Service**** : <a href="http://www.imoknow.co.kr">www.imoknow.co.kr</a>    

<img src="https://github.com/user-attachments/assets/974992f5-926b-4eb2-b218-0593d119a752" width="450" height="250">

---

**<구현 기능>**

#### [회원가입]

1.회원가입 시 정보(아이디, 닉네임, 이메일) 중복확인 기능
+ JPA exists 메소드 이용

2.google 이메일 연동, 인증번호 발송 및 일치여부 확인 기능
+ Redis를 활용하여 인증번호 유효시간 5분 설정
  
3.회원가입 시 비밀번호 암호화 기능 (비밀번호 암호화)   
+ BCryptPasswordEncoder를 이용한 비밀번호 hasing
  
4.아이디, 비밀번호 찾기(비밀번호 재설정) 기능
+ JPA save 메소드 이용
   
#### [게시글]  

1.게시글 작성, 조회, 수정, 삭제 기능
+ MyBatis를 활용한 CRUD 구현
     
#### [로그인 및 권한 관리]    

1.로그인 및 로그아웃
+ HTTP Session을 사용하여 로그인/로그아웃 기능 구현

2.비로그인 사용자의 특정 페이지 접근 제한
+ HandlerInterceptor를 활용해 비로그인 사용자의 특정 페이지 접근 제한

 


---


 

 

