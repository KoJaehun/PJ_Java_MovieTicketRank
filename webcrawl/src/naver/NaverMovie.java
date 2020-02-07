package naver;

import java.io.IOException;
import java.text.DecimalFormat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import domain.MovieDTO;
import persistence.MovieDAO;

public class NaverMovie {

	public static void main(String[] args) throws IOException {

		// 네이버 하이큐 영화 댓글 수집
		// Oracle DB에 저장
		// DAO, DTO 그대로 DAUM

		// 제목 h_movie
		// 평점 .input_netizen .star_score em
		// 작성자 .score_result .score_reple dt em a span
		// 내용 p.desc_review
		// 작성일자 .score_result .score_reple dt em:last-child
		// 수집

		String base = "https://movie.naver.com/movie/bi/mi/pointWriteFormList.nhn?code=191431&type=after&isActualPointWriteExecute=false&isMileageSubscriptionAlready=false&isMileageSubscriptionReject=false&page=";
		int page = 1;			// 수집한 페이지 수
		String url = base + page;
		int count = 0;			// 전체 댓글 수
		String title = ""; 		// 영화제목
		int total = 0;			// 평점을 모두 더하는 변수 
		double scoreAvg = 0.0; // 평균 평점
		String compare = ""; // 마지막페이지 종료를 위한 변수 

		MovieDAO mDao = new MovieDAO();
		
		// 영화제목 수집
		Document movieDoc = Jsoup.connect("https://movie.naver.com/movie/bi/mi/point.nhn?code=191431").get();
		title = movieDoc.select("h3.h_movie > a:nth-child(1)").first().text();

		label : while (true) {
			Document doc = Jsoup.connect(url).get();
			Elements reply = doc.select("div.score_result li");

			if (reply.isEmpty()) {
				break;
			}
			int score, regdate = 0;
			String writer, content = "";
			
			
			// 평점 1건 수집
			for (int i = 0; i < reply.size(); i++) {
				
				writer = reply.get(i).select(".score_reple dt em:first-child").text();
				score = Integer.parseInt(reply.get(i).select("div.star_score > em").text());
				content = reply.get(i).select(".score_reple > p").text();
				// basedate = reply.get(i).select(".score_reple dt em:last-child").text();
				regdate = Integer.parseInt(reply.get(i).select(".score_reple dt em:last-child").text().substring(0, 10).replace(".", ""));

				if(i==0) {
					if(compare.equals(writer)) {
						break label;
					} else {
						compare = writer;
					}
				}
				
				count++;		// 누적 평점을 계산
				total += score; // total = total + score;

				
				
				
				System.out.println("▒▒▒▒▒▒▒▒▒▒" + count + "건▒▒▒▒▒▒▒▒▒▒");
				System.out.println("평점 : " + score);
				System.out.println("작성자 : " + writer);
				System.out.println("내용 : " + content);
				System.out.println("작성일자 : " + regdate);
			}

			page = page + 1;
			url = base + page;
		}
		scoreAvg = (double) total / count;
		double result = scoreAvg;
		DecimalFormat df = new DecimalFormat("0.0");
		
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("■■ " + (page-1) + "페이지");
		System.out.println("■■ " + count + "건의 평점을 수집 완료");
		System.out.println("■■ 평균 평점은" + df.format(result) + "점 :)");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
	}

}
