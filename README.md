# :laughing: Project : MovieTicketRank
DESC : 현재 영화 예매순위 1~10위 영화를 네이버와 다음에서 평점을  
수집하여 요약통계량 및 분석 결과를 제공

### :exclamation:Attention(Warning):exclamation:
  > Project는 ticketrank, domain, persistence, mybatis 패키지만 사용 daum과 naver패키지는  
  프로젝트를 진행하기 위한 연습용 예제 코드

### :star:1.Use Tools
- Language & Library: JAVA, jSoup, Mybatis, Oracle, Sql
- IDE: Eclipse, SqlDeveloper

### :star:2.Process Logic(ticketrank)
**1. 네이버 예매순위 1-10위 영화제목과 네이버영화코드 수집**  
**2. 다음 예매순위 1-10위 다음영화코드 수집**  
**3. 2차원 배열에 1-10위 영화제목, 네이버코드, 다음코드 저장**  
**4. 사용자에게 화면 출력(영화순위 1~10위)**  
**5. 사용자가 수집 및 분석결과를 확인하고 싶은 번호를 선택**  
**6. 사용자가 입력한 값의 네이버 평점을 수집 및 DB에 저장**  
**7. 사용자가 입력한 값의 다음 평점을 수집 및 DB에 저장**  
**8. 분석 결과 출력**  
  - 네이버 수집 결과(댓글수, 평점의합, 평균평점) 출력  
  - 다음 수집 결과(댓글수, 평점의합, 평균평점) 출력  
  - 네이버 + 다음 결과(댓글수, 평점의합, 평균평점) 출력
**9. 종합결과(Report) 출력**  
  - 전체 댓글수, 전체 평균평점, 영화평(ex: 꿀잼)  

### :star:3.File 설명(Package 및 class)
**1. daum: Daum에서 수집**  
  + OneNews.java: 뉴스 1건의 제목과 본문을 수집
  + ListNews.java: 뉴스 목록(1Page)에서 뉴스별 제목과 본문을 수집
  + PageNews.java: 페이지를 돌면서 뉴스 목록에서 뉴스별 제목과 본문을 수집
  + DaumMovie.java: 다음 영화 1건에 평점을 수집
  
**2. naver: Naver에서 수집**  
  + NaverMovie.java: 네이버 영화 1건에 평점을 수집
  
**3. domain: DTO들이 모여있는 패키지**  
  + MovieDTO.java: 평점 수집결과를 Oracle DB에 저장할 때 사용하는 DTO
  
**4. persistence: DAO들이 모여있는 패키지**  
  + MovieDAO.java : 평점 수집결과를 Oracle DB에 저장할 때 사용하는 DAO
  
**5. mybatis: Mybatis 프레임워크 관련 환경설정**  
  + db.properties: Oracle 접속 환경
  + Configuration.xml: Mybatis 사용 환경(Mapper, DB 접속 등)
  + SqlMapConfig.java: SqlSessionFactory를 생성
  + MovieMapper.xml: Mybatis의 SQL들이 모여있는 파일
  
**6. ticketrank: 실제 프로젝트**  
  + TicketMain: 메인 프로그램(프로그램 출력부)
  + DaumTicket: 영화 예매순위 1~10위 DAUM 평점을 수집 및 DB에 저장
  + NaverTicket: 영화 예매순위 1~10위 NAVER 평점을 수집 및 DB에 저장
  + TicketDTO: DaumTicket와 NaverTicket 클래스에서 TicketMain으로 댓글수와 평점의 합을 전달할 때 사용하는 DTO
  

