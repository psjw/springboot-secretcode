# 스프링부트/JPA - 컨트롤러 구현 편

### Chapter 2 . Spring JPA를 통한 CRUD 구현


####41.	사용자 비밀번호 초기화 요청(아이디입력 후 전화번호로 문자 전송받음)의 기능을 수행하는 API를 작성해 보세요.
- 아이디에 대한 정보 조회후
- 비밀번호를 초기화한 이후에 이를 문자 전송 로직 호출
- 초기화 비밀번호는 문자열 10자로 설정함


####42. 내가 좋아요한 공지사항을 보는 API를 작성해 보세요.


####43. 사용자 이메일과 비밀번호를 통해서 JWT을 발행하는 API를 작성해 보세요.
[조건]
- JWT 토큰발행시 사용자 정보가 유효하지 않을때 예외 발생
- 사용자정보가 존재하지 않는경우(UserNotFoundException) 에 대해서 예외 발생
- 비밀번호가 일치하지 않는 경우(PasswordNotMatchException) 에 대해서 예외 발생


####44. 사용자의 이메일과 비밀번호를 통해서 JWT을 발행하는 로직을 작성해 보세요.
- JWT 토큰발행


####45. JWT 토큰 발행시 발행 유효기간을 1개월로 저장하는 API를 작성해 보세요.

