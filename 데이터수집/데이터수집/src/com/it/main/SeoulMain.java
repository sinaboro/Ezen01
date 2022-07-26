package com.it.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.it.dao.*;
public class SeoulMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        SeoulMain sm=new SeoulMain();
         //sm.seoulAttractions();  
        //sm.seoulNature();
        //sm.seoulHotel();
	}
	
	public void seoulAttractions()
	{
		DataDAO dao=new DataDAO();
		try
		{
			int k=1;
			for(int i=1;i<=35;i++)
			{
			   Document doc=Jsoup.connect("https://korean.visitseoul.net/attractions?curPage="+i).get(); //명소 목록 페이지
			   Elements poster=doc.select("ul.article-list li.item div.thumb"); //썸네일 이미지
			   Elements comment=doc.select("ul.article-list li.item div.infor-element span.text-dot-d"); //썸네일 장소 설명
			   Elements link=doc.select("ul.article-list li.item a"); // 썸네일 장소 세부설명 링크
			   Elements title=doc.select("ul.article-list li.item div.infor-element span.title"); //썸네일 장소 이름
			   for(int j=0;j<poster.size();j++)
			   {
				   try{
					   System.out.println("번호:"+k);
					   System.out.println(title.get(j).text()); //title의 텍스트만 추출 후 출력
					   System.out.println(poster.get(j).attr("style")); // poster style의 속성값을 반환
					   System.out.println(comment.get(j).text()); //장소를 설명하는 부분의 텍스트만 추출 후 출력
					   System.out.println(link.get(j).attr("href")); // link의 url을 반환 후 출력
					   Document doc2=Jsoup.connect("https://korean.visitseoul.net"+link.get(j).attr("href")).get();// 사진속 장소의 상세페이지
					   Element address=doc2.select("div.detail-map-infor:eq(1) dl dd").get(0); // 사진 속 장소의 주소 및 교통정보
					   System.out.println("주소:"+address.text()); // 주소 및 교통정보의 텍스트만 추출 후 출력
					   System.out.println("=========================================================");
				       
					   SeoulLocationVO vo=new SeoulLocationVO();
					   vo.setNo(k); 
					   vo.setTitle(title.get(j).text()); // vo에 title 텍스트만 추출 후 저장
					   vo.setMsg(comment.get(j).text()); // vo에 comment 텍스트만 추출 후 저장
					   String image=poster.get(j).attr("style"); // poster style의 속성값을 image에 저장
					   image=image.substring(image.indexOf("(")+1,image.lastIndexOf(")")); //'('다음부터 ')'까지 내용을 반환
					   // style="background-image:url(/comm/getImage?srvcId=POST&amp;parentSn=5548&amp;fileTy=POSTTHUMB&amp;fileNo=1&amp;thumbTy=M)"
					   image="https://korean.visitseoul.net"+image;
					   vo.setPoster(image); // vo에 image값을 저장
					   vo.setAddress(address.text()); // vo에 address의 텍스트만 추출 후 저장
					   dao.seoulLocationInsert(vo); // vo에 저장된 값을 연동 된 데이터베이스에 입력
					   k++;
				   }catch(Exception ex) {}
			   }
			}
		}catch(Exception ex){}
	}
	
	public void seoulHotel()
	{
		DataDAO dao=new DataDAO();
		try
		{
			int k=1;
			for(int i=1;i<=33;i++)
			{
			   Document doc=Jsoup.connect("https://korean.visitseoul.net/hotels?curPage="+i).get(); // 서울 호텔목록 페이지
			   Elements poster=doc.select("ul.article-list li.item div.thumb img"); // 썸네일 이미지
			   Elements link=doc.select("ul.article-list li.item a"); // 썸네일장소 세부설명 링크
			   Elements title=doc.select("ul.article-list li.item div.infor-element span.title"); // 호텔이름
			   Elements score=doc.select("div.infor-element-inner span.trip-ico img"); //평점
			   for(int j=0;j<poster.size();j++)
			   {
				   try {
						   System.out.println("번호:"+k);
						   System.out.println(title.get(j).text());
						   System.out.println(poster.get(j).attr("src"));
						   System.out.println(link.get(j).attr("href"));
						   System.out.println("score-alt" + score.get(j).attr("alt"));
						   Document doc2=Jsoup.connect("https://korean.visitseoul.net"+link.get(j).attr("href")).get(); 
						   Element address=doc2.select("div.detail-map-infor dl dd").get(0); //dd = 호텔 주소
						   Elements images=doc2.select("div.wide-slide div.item"); // 호텔 내부 이미지사진
						   String simg="";
						   for(int m=0;m<images.size();m++)
						   {
							   System.out.println(images.get(m).attr("style"));
							   String temp=images.get(m).attr("style");
							   // background-image:url(http://media-cdn.tripadvisor.com/media/photo-s/10/f5/38/a8/twin-rom--v17512289.jpg)"
							   // http://media-cdn.tripadvisor.com/media/photo-s/10/f5/38/a8/twin-rom--v17512289.jpg
							   temp=temp.substring(temp.indexOf("(")+1,temp.lastIndexOf(")"));
							   simg+=temp+"^";
						   }
						   simg=simg.substring(0,simg.lastIndexOf("^"));
						   System.out.println("주소:"+address.text());
						   
						   System.out.println("=========================================================");
					       SeoulHotelVO vo=new SeoulHotelVO();
					       vo.setNo(k);
					       vo.setName(title.get(j).text());
					       vo.setAddress(address.text());
					       vo.setPoster(poster.get(j).attr("src"));
					       String s=score.get(j).attr("alt");
					       // alt=""  평점:4.5
					       s=s.substring(s.indexOf(":")+1);
//					       vo.setScore(Double.parseDouble(s.trim()));
					       vo.setScore(0.0);
					       vo.setImages(simg);
					       dao.seoulHotelInsert(vo);
						   k++;
				   }catch(Exception ex) {
					   ex.printStackTrace();
				   }
			   }
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	/*
	 *  NO      NOT NULL NUMBER         
		TITLE   NOT NULL VARCHAR2(200)  
		POSTER  NOT NULL VARCHAR2(300)  
		MSG     NOT NULL VARCHAR2(4000) 
		ADDRESS NOT NULL VARCHAR2(300)
	 */
	public void seoulNature()
	{
		DataDAO dao=new DataDAO();
		try
		{
			int k=1;
			for(int i=1;i<=14;i++)
			{
			   Document doc=Jsoup.connect("https://korean.visitseoul.net/nature?curPage="+i).get();
			   
			   Elements poster=doc.select("ul.article-list li.item div.thumb");
			   Elements comment=doc.select("ul.article-list li.item div.infor-element span.text-dot-d");
			   Elements link=doc.select("ul.article-list li.item a");
			   Elements title=doc.select("ul.article-list li.item div.infor-element span.title");
			   for(int j=0;j<poster.size();j++)
			   {
				  try
				  {
				   System.out.println("번호:"+k);
				   System.out.println(title.get(j).text());
				   System.out.println(poster.get(j).attr("style"));
				   System.out.println(comment.get(j).text());
				   System.out.println(link.get(j).attr("href"));
				   Document doc2=Jsoup.connect("https://korean.visitseoul.net"+link.get(j).attr("href")).get();
				   /*
				    *   <div class="detail-map-infor"> :eq(0)
				    *     <dl>
				    *     </dl>
				    *   </div>
				    *   <div class="detail-map-infor"> :eq(1)
				    *     <dl>
				    *     </dl>
				    *   </div>
				    *   <div class="detail-map-infor"> :eq(2)
				    *     <dl>
				    *     </dl>
				    *   </div>
				    */
				   Element address=doc2.select("div.detail-map-infor:eq(1) dl dd").get(0);
				   System.out.println("주소:"+address.text());
				   System.out.println("=========================================================");
			       SeoulNatureVO vo=new SeoulNatureVO();
			       vo.setNo(k);
			       vo.setTitle(title.get(j).text());
			       vo.setAddress(address.text());
			       vo.setMsg(comment.get(j).text());
			       String s=poster.get(j).attr("style");
			       s=s.substring(s.indexOf("(")+1,s.lastIndexOf(")"));
			       s="https://korean.visitseoul.net"+s;
			       vo.setPoster(s);
			       dao.seoulNatureInsert(vo);
				   k++;
				  }catch(Exception ex) {}
			   }
			}
		}catch(Exception ex){}
	}

}
