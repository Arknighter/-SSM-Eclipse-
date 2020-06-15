package com.yjh.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjh.po.Article;
import com.yjh.po.Catalog;
import com.yjh.service.ArticleService;
import com.yjh.service.CatalogService;
import com.yjh.utils.DelHTMLTag;

@Controller
@CrossOrigin
public class ArticleController {
	//����ע��
	@Autowired
	private ArticleService articleService;
	@Autowired
	private CatalogService catalogService;
	
	
	
	/**
	 * ����artitleģ�� ��������
	 */
	@RequestMapping("/findByNameArticle")
	public String findByNameArticle(Model model ,HttpServletRequest request) {
		String name = request.getParameter("arname");
		List<Article> articlelist =articleService.findByNameArticle(name);
		List<Catalog> cataloglist = catalogService.findCatalogAll();
		model.addAttribute("ArticleList", articlelist);
		model.addAttribute("catalogs", cataloglist);
		for (Article article : articlelist) {
			int maxlength=10;
			String aritle= article.getArtitle();
			if(aritle.length()<10){
				maxlength = aritle.length();
			}
			article.setArtitle(aritle.substring(0, maxlength));
			String arcontent = article.getArcontent();
			//System.out.println(arcontent);
			DelHTMLTag delHTMLTag = new DelHTMLTag();
			String newcontent = delHTMLTag.delHTMLTag(arcontent);
			//System.out.println(newcontent);
			int maxleng= 20;
			if(newcontent.length()<20){
				maxleng = newcontent.length();
			}
			
			article.setArcontent(newcontent.substring(0, maxleng));
			if(article.getArstate().endsWith("1")){
				article.setArstate("��ʾ");
			}
			if(article.getArstate().endsWith("2")){
				article.setArstate("������ʾ");
			}
		}
		return "articlelist";
	}
	
	
	
	/**
	 * ����arid��ѯ����
	 */
	@RequestMapping("/findByIdArticle/{id}")
	public String findByIdArticle(@PathVariable("id") int id,Model model) {
		Article article = articleService.findByIdArticle(id);
		List<Catalog> cataloglist  = catalogService.findCatalogAll();
		model.addAttribute("article", article);
		model.addAttribute("CatalogList", cataloglist);
		return "articleupdate";
	}
	
	/**
	 * ����arid��ѯ���¸�������
	 */
	@RequestMapping("/updateArticle")
	@ResponseBody
	public String updateArticle(Article article) {
		int rows = articleService.updateArticle(article);
		if(rows == 1) {
			return "OK";
		}
		return "Fle";
	}
	
	
	
	
	/**
	 * ����aridɾ������
	 */
	@RequestMapping("/delArticle")
	@ResponseBody
	public String delArticle(Integer id) {
		int rows = articleService.delArticle(id);
		if(rows > 0) {
			return "OK";
		}else {
			return "FATL";
		}
	}
	
	
	
	
	
	/**
	 * ��ҳȫ������
	 */
	@RequestMapping("/findArticleAllPage")
	public String findArticleAllPage(HttpServletRequest request,Model model) {		
		articleService.findArticleAllPage(request, model);
		return "articlelist";
	}
	
	/**
	 * ȫ������
	 */
	@RequestMapping("/findAllArticle")
	public String findAllArticle(Model model) {
		List<Article> articlelist = articleService.findArticleAll();
		for (Article article : articlelist) {
			int maxlength=10;
			String aritle= article.getArtitle();
			if(aritle.length()<10){
				maxlength = aritle.length();
			}
			article.setArtitle(aritle.substring(0, maxlength));
			String arcontent = article.getArcontent();
			//System.out.println(arcontent);
			DelHTMLTag delHTMLTag = new DelHTMLTag();
			String newcontent = delHTMLTag.delHTMLTag(arcontent);
			//System.out.println(newcontent);
			int maxleng= 20;
			if(newcontent.length()<20){
				maxleng = newcontent.length();
			}
			
			article.setArcontent(newcontent.substring(0, maxleng));
			if(article.getArstate().endsWith("1")){
				article.setArstate("��ʾ");
			}
			if(article.getArstate().endsWith("2")){
				article.setArstate("������ʾ");
			}
		}
		List<Catalog> cataloglist = catalogService.findCatalogAll();
		model.addAttribute("ArticleList", articlelist);
		model.addAttribute("catalogs", cataloglist);
		return "articlelist";
	}
	
	
	
	/**
	 * �������arnumber
	 */
	@RequestMapping(value = "/findarnumbermax")
	public String findarnumbermax(Model model) {
		List<Catalog> cataloglist = catalogService.findCatalogAll();
		String arnumber = Integer.parseInt(articleService.findarnumbermax())+1+"";
		if(arnumber == null || arnumber.length()<=0 ){
			arnumber="0";
		}
		model.addAttribute("arnumber", arnumber);
		model.addAttribute("CatalogList", cataloglist);
		return "articleadd";
	}
	
	
	/**
	 * �������
	 */
	@RequestMapping(value = "/addArticle",method = RequestMethod.POST)
	@ResponseBody
	public String addArticle(int caid,String artitle,String arcontent,String aruser,String arstate
			,String arnumber,Article article,HttpServletRequest request) {		
		//��ȡʱ��
		String artime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		//��Ŵ���
		Random r = new Random();
		String rs = String.valueOf(Math.abs(r.nextInt())).substring(0, 4);
		String times = new SimpleDateFormat("yyyyMMdd").format(new Date()).substring(2);
		String arid = times+rs;
		
		article.setArid(arid);
		article.setArtime(artime);
		int rows = articleService.addArticle(article);
		System.out.println("rows====="+rows);
		if(rows > 0) {
			return "OK";
		}
		return "Fla";
	}
	
	
}
