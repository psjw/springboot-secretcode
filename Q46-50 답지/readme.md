# 스프링부트/JPA - 컨트롤러 구현 편

### Chapter 2 . Spring JPA를 통한 CRUD 구현


####46. JWT 토큰 재발행(특정 정보 인증에 대한) 하는 API를 작성해 보세요.
- 이미 발행된 JWT토큰을 통해서 토큰을 재발행하는 로직을 구현하세요.
- 정상적인 회원에 대해서 재발행 진행


####47. JWT 토큰에 대한 삭제를 요청하는 API를 작성해 보세요.


####48. 사용자 목록 과 사용자 수를 함께 내리는 REST API를 작성해 보세요.
- ResponseData의 구조를 아래와 같이 형식으로 작성해서 결과 리턴
```
{
    "totalCount": N
    , "data": user목록 컬렉션
}
```


####49. 사용자 상세 조회를 조회하는 API를 아래 조건에 맞게 구현해 보세요.
- ResponseMessage 클래스로 추상화해서 전송
```
{
    "header":
    {
        result: true|false
        , resultCode: string
        , message: error message or alert message
        , status: http result code
    },
    "body": 내려야 할 데이터가 있는 경우 body를 통해서 전송
}
```


####50. 사용자 목록 조회에 대한 검색을 리턴하는 API를 작성해 보세요.
- 이메일, 이름, 전화번호에 대한 검색결과를 리턴(각 항목은 or 조건)







