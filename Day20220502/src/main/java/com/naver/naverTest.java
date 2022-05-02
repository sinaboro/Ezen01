package com.naver;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class naverTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int pages=2;
		
		for(int i=1; i<pages; i++) {
		
			String url = "https://news.naver.com/main/list.naver?mode=LS2D&sid2=249&sid1=102&mid=shm&date=20220502&page="+i;
			
			Document doc = Jsoup.connect(url).get();
			//System.out.println(doc);
			Elements  elements = doc.getElementsByAttributeValue("class", "list_body newsflash_body");
			Element  element= elements.get(0);
			//System.out.println(element);
			
			Elements photoElements = element.getElementsByAttributeValue("class", "photo");
			//System.out.println(photoElements);
			
					
			for(int j=0; j<photoElements.size(); j++) {
				
				Element articleElement = photoElements.get(j);
				//System.out.println(articleElement);
				Elements aElements = articleElement.select("a");
				Element aElement = aElements.get(0);
				//System.out.println(aElements);
				
				String newsUrl = aElement.attr("href");  //기사 링크
				//System.out.println(newsUrl);
				
				Element  imgElement = aElement.select("img").get(0);
				String imgUrl = imgElement.attr("src");
				//System.out.println(imgUrl);
				String title  = imgElement.attr("alt");
				//System.out.println(title);
				
				Document detailDoc = Jsoup.connect(newsUrl).get();
				Element  contentElement  = detailDoc.getElementById("dic_area");
				String  content = contentElement.text();
				
				System.out.println(title);
				System.out.println(content);
				System.out.println();
			}
		}
	}

}
