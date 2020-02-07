## Project : MovieTicketRank
DESC : 현재 영화 예매순위 1~10위 영화를 네이버와 다음에서 평점을  
수집하여 요약통계량 및 분석 결과를 제공

#### File설명(Package 및 class)
1. daum: Daum에서 수집
  + OneNews.java: 뉴스 1건의 제목과 본문을 수집
  + ListNews.java: 뉴스 목록(1Page)에서 뉴스별 제목과 본문을 수집
  + PageNews.java: 페이지를 돌면서 뉴스 목록에서 뉴스별 제목과 본문을 수집
  + DaumMovie.java: 다음 영화 1건에 평점을 수집
  
2. naver: Naver에서 수집
  + NaverMovie.java: 네이버 영화 1건에 평점을 수집
  
3. domain: DTO들이 모여있는 패키지
  + MovieDTO.java: 평점 수집결과를 Oracle DB에 저장할 때 사용하는 DTO
  
4. persistence: DAO들이 모여있는 패키지
  + MovieDAO.java : 평점 수집결과를 Oracle DB에 저장할 때 사용하는 DAO
  
5. mybatis: Mybatis 프레임워크 관련 환경설정
  + db.properties: Oracle 접속 환경
  + Configuration.xml: Mybatis 사용 환경(Mapper, DB 접속 등)
  + SqlMapConfig.java: SqlSessionFactory를 생성
  + MovieMapper.xml: Mybatis의 SQL들이 모여있는 파일
  
6. ticketrank: 실제 프로젝트
  + TicketMain: 메인 프로그램(프로그램 출력부)
  + DaumTicket: 영화 예매순위 1~10위 DAUM 평점을 수집 및 DB에 저장
  + NaverTicket: 영화 예매순위 1~10위 NAVER 평점을 수집 및 DB에 저장
  + TicketDTO: DaumTicket와 NaverTicket 클래스에서 TicketMain으로 댓글수와 평점의 합을 전달할 때 사용하는 DTO
  
### 
