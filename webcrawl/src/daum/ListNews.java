/*
 * 다음 뉴스 목록의 각 기사마다 제목과 본문을 수집 
 * (1Page 내의 목록만 ex : 목록10개 >> 10건의 기사)
 */

package daum;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ListNews {
	public static void main(String[] args) throws IOException {
		String url = "https://news.daum.net/breakingnews/digital";
		
		Document doc = Jsoup.connect(url).get();
		
		Elements urls = doc.select("ul.list_allnews strong.tit_thumb > a.link_txt");
		
		int count = 0;
		for (Element element : urls) {
			count++;
			// attr()을 사용하여 원하는 속성값 추출
			String href = element.attr("href");
			
			Document docNews = Jsoup.connect(href).get();
			
			Elements title = docNews.select("h3.tit_view");
			Elements content = docNews.select("div#harmonyContainer");
			
			System.out.println("■■■■■■■■■■■■■■■■" + count + "건");
			System.out.println(title.text()); // 제목출력
			System.out.println(content.text());
		}
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("■■ Daum 수집한 뉴스 총 " + count + " 건 수집");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
	}
}
