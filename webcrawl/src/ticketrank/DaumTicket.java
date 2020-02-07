package ticketrank;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import domain.MovieDTO;
import persistence.MovieDAO;

public class DaumTicket {
	String base = "";
	int page = 1;	   // 수집한 페이지수(1page = 댓글 10개)
	String url = "";
	int count = 0;	   // 전체 댓글 수
	int total = 0; 	   // 평점을 모두 더하는 변수
	MovieDAO mDao = new MovieDAO();
	
	
	public TicketDTO daumCrawler(String movie, String code) throws IOException {
		base = "https://movie.daum.net/moviedb/grade?movieId="+code+"&type=netizen&page=";
		url = base + page;
		System.out.println("■■■■ DAUM START ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		while(true) {
			Document doc = Jsoup.connect(url).get();
			Elements reply = doc.select("ul.list_netizen div.review_info");
			
			// 마지막페이지면 수집 종료
			if(reply.isEmpty()) {
				break;
			}
			
			int score, regdate = 0;
			String writer, content, basedate, subdate = "";
			
				for (Element one : reply) {
					count++;
					writer = one.select("em.link_profile").text();
					score = Integer.parseInt(one.select("em.emph_grade").text());
					content = one.select("p.desc_review").text();
					basedate = one.select("span.info_append").text();
					subdate = basedate.substring(0, 10);
					regdate = Integer.parseInt(subdate.replace(".", ""));
					
					// 누적 평점을 계산
					total += score; // total = total + score;
					
					MovieDTO mDto = new MovieDTO(movie, content, writer, score, "daum", regdate);
					
					// DB에 저장!
					mDao.addMovie(mDto);
					System.out.println("▒▒▒▒▒▒▒▒▒▒" + count + "건▒▒▒▒▒▒▒▒▒▒");
					System.out.println("영화 : " + movie);
					System.out.println("평점 : " + score);
					System.out.println("작성자 : " + writer);
					System.out.println("내용 : " + content);
					System.out.println("작성일자 : " + regdate);
				}
				// 다음페이지로 이동하기 위해 page + 1 증가
				page = page + 1;
				// 다음 페이지로 이동할 URL 작성
				url = base + page;
			}
		System.out.println("■■■■ DAUM END ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		
		// TicketMain
		TicketDTO tDto = new TicketDTO(count, total);
		return tDto;
	}
}
