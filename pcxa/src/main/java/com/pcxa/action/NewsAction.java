package com.pcxa.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.pcxa.model.News;
import com.pcxa.service.NewsService;
/**
 * 
 * ����ƣ�NewsAction   
 * �������� ���Ź����������ʵ�� 
 * �����ˣ�WangPeng  
 * ����ʱ�䣺2014-4-29 ����9:49:41   
 * �޸��ˣ�WangPeng   
 * �޸�ʱ�䣺2014-4-29 ����9:49:41   
 * �޸ı�ע��   
 * @version 1.0   
 *
 */
@Controller  
@Namespace("/seller")  
@ParentPackage("struts-default")
@Results(
		   {
		   @Result(name="success",type="chain",location="displayNews"),
		   @Result(name="error",location="/seller/error.jsp")
		   }
		)
public class NewsAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4901688281316140152L;
	
	@Resource
	private NewsService newsServiceImpl ;
	
	private Integer id ;
	private String title ;
	private String time ;
	private String introduction ;
	private String picture_link ;
	
	private News news ;
	private List<News> newsList ;
	
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	public List<News> getNewsList() {
		return newsList;
	}
	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getPicture_link() {
		return picture_link;
	}
	public void setPicture_link(String picture_link) {
		this.picture_link = picture_link;
	}
	/**
	 * �������
	 * @return
	 * @throws Exception
	 */
	@Action(value = "insertNews") 
	public String insertNews() throws Exception{
		news = new News(title, introduction,picture_link, time) ;
		if(newsServiceImpl.insert(news)){
			return SUCCESS ;
		}else{
			return ERROR ;
		}
	}
	/**
	 * ɾ������
	 * @throws Exception
	 */
	@Action(value = "deleteNews") 
	public String deleteNews() throws Exception{
		news = newsServiceImpl.get(id) ;
		newsServiceImpl.delete(news) ;
		return SUCCESS ;
	}
	/**
	 * ��������
	 * @throws Exception
	 */
	@Action(value = "updateNews") 
	public String update() throws Exception{
		news = newsServiceImpl.get(id) ;
		news.setTitle(title) ;
		news.setIntroduction(introduction) ;
		news.setPictureLink(picture_link) ;
		news.setTime(time) ;
		newsServiceImpl.update(news);
		return SUCCESS ;
	}
	/**
	 * չʾ����
	 * @return
	 * @throws Exception
	 */
	@Action(value = "displayNews",results = { @Result(name = "success", location = "/seller/displayNews.jsp")}) 
	public String display() throws Exception{
		newsList = newsServiceImpl.findAllNews() ;
		return SUCCESS;		
	}
	/**
	 * ��ȡ��Ҫ�޸ĵ�����
	 * @return
	 * @throws Exception
	 */
	@Action(value = "modifyNewsPage",results = { @Result(name = "success", location = "/seller/modifyNews.jsp")}) 
	public String modifyNewsPage() throws Exception{
		news = newsServiceImpl.get(id) ;
		return SUCCESS ;
	}
}
