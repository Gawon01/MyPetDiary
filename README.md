개인 프로젝트 - 반려동물 다이어리

# MyPetDiary
<소개>

- 한 장의 사진과 함께 반려동물과 생활한 오늘을 기록하세요.
- 회원 가입을 통해 자신만의 일기를 작성하세요.
- 작성한 일기를 모바일에서도 볼 수 있습니다!


<개발 환경>

- Oracle
- Spring MVC Project & MyBatis 연동
- Bootstrap
- Android Studio

<주요 기능>

1. 회원 가입 
회원 가입을 통해 나만의 일기를 기록하세요.

2. 로그인 
로그인을 한 사용자만 서비스를 이용할 수 있습니다.

3. 일기 작성 
제목, 내용, 한 장의 이미지를 업로드 할 수 있습니다. 
또한 체크 박스를 통해 모두의 일기장에 공유할 수 있습니다!

4. 일기 수정/삭제
일기를 수정하고 삭제할 수 있습니다.

5. 일기 모아보기 
그동한 작성 한 일기를 리스트로 볼 수 있습니다!

6. 모두의 일기장 <- new!
공유 설정을 한 모든 사용자의 일기를 볼 수 있습니다. 
공유를 원하지 않으시면 게시글의 공유하기 체크박스를 해제해주세요!
  
     
<주요 기능 구현>

- 회원 가입 - DUser 테이블을 이용해 회원 정보 저장, 관리
- 로그인 - Interceptor로 로그인 한 사용자만 서비스를 이용할 수 있습니다.
- 일기 모아보기/상세보기/작성/수정/삭제 - Diary 테이블을 이용해 작성한 일기 내용 관리, MyBatis를 이용해 SQL 작업
- 모바일 연동 (예정) - 모바일 어플에 로그인 후 웹에서 저장한 일기를 스마트폰에서도 볼 수 있습니다.
- 모바일 등록/수정/삭제(예정) - 어플을 이용해 일기를 작성하고 수정, 삭제 할 수 있습니다. 





