/*
 * 다음 뉴스 목록을 페이지단위로 읽어서
 * 각 기사마다 제목과 본문을 수집 
 * (1Page : 기사 15건, 10Page = 150건 기사)
 */

package daum;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PageNews {
	public static void main(String[] args) throws IOException {
		String base = "https://news.daum.net/breakingnews/digital?page=";
		int page = 1;
		String url = base + page;
		int count = 0; // 뉴스 건수
		
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒START▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		while(true) { // 1, 2, 3Page
			
			// 해당페이지의 전체 내용(태그)
			Document doc = Jsoup.connect(url).get();
			// 해당 페이지의 기사 목록을 수집(1Page당 15건)
			Elements headLine = doc.select("ul.list_allnews strong.tit_thumb > a.link_txt");
			
			// 마지막 페이지면 수집 종료!
			if(headLine.isEmpty()) {
				break;
			}
			
			// 1 페이지의 기사 목록에서 1건씩 추출 => element에 담기
			for (Element element : headLine) {
				
				// 뉴스 전체 카운트수 +1 증가
				count++;
				
				// 단건 출력된 기사에서 href 속성값 추출
				String href = element.attr("href");
				// 단건 출력된 기사 전체 내용(태그)
				Document docNews = Jsoup.connect(href).get();
				// 단건 출력된 기사의 제목(title)
				Elements title = docNews.select("h3.tit_view");
				// 단건 출력된 기사의 본문(content)
				Elements content = docNews.select("div#harmonyContainer");
				
				// 단건 결과 출력(제목 + 본문)
				System.out.println("■■■■■■■■■■■■■■■■" + count + "건");
				System.out.println("제목: " + title.text()); // 제목출력
				System.out.println("본문: " + content.text());
			}
			
			// 다음페이지 이동
			page = page + 1;
			url = base + page;
		}
		// 수집 완료, 전체 수집된 결과 출력
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒END▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("■■ Daum 수집한 뉴스 총 " + count + " 건 수집");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
	}
}
