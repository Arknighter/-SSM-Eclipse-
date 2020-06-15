package com.yjh.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.yjh.dao.ArticleDao;
import com.yjh.dao.CatalogDao;
import com.yjh.po.Article;
import com.yjh.po.Catalog;
import com.yjh.po.Manager;
import com.yjh.po.Page;
import com.yjh.service.ArticleService;
import com.yjh.utils.DelHTMLTag;


@Service("articleService")
@Transactional
public class ArticleServiceImpl implements ArticleService {
	
	//注解的方式注入CatalogDao
	@Autowired
	private ArticleDao articleDao;
	@Autowired
	private CatalogDao catalogDao;

	@Override
	public List<Article> findArticleAll() {
		// TODO Auto-generated method stub
		return articleDao.findArticleAll();
	}

	@Override
	public String findarnumbermax() {
		return articleDao.findarnumbermax();
	}

	@Override
	public int addArticle(Article article) {
		// TODO Auto-generated method stub
		return articleDao.addArticle(article);
	}

	@Override
	public void findArticleAllPage(HttpServletRequest request, Model model) {
		String pageNow = request.getParameter("pageNow"); 
		Page page = null; 
		
		List<Article> articlelist = new ArrayList<Article>();
		
		int totalCount = (int) articleDao.getArticleAllCount();
		
		if (pageNow != null) { 
            page = new Page(totalCount, Integer.parseInt(pageNow)); 
            articlelist = this.articleDao.findArticleAllPage(page.getStartPos(), page.getPageSize());       
        } else { 
            page = new Page(totalCount, 1); 
            articlelist = this.articleDao.findArticleAllPage(page.getStartPos(), page.getPageSize());  
        } 
		List<Catalog> cataloglist = catalogDao.findCatalogAll();
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
				article.setArstate("显示");
			}
			if(article.getArstate().endsWith("2")){
				article.setArstate("不可显示");
			}
		}
			model.addAttribute("page", page); 			
			
	}

	@Override
	public int delArticle(Integer id) {
		// TODO Auto-generated method stub
		return articleDao.delArticle(id);
	}

	@Override
	public Article findByIdArticle(Integer id) {
		// TODO Auto-generated method stub
		return articleDao.findByIdArticle(id);
	}

	@Override
	public int updateArticle(Article article) {
		// TODO Auto-generated method stub
		return articleDao.updateArticle(article);
	}

	@Override
	public List<Article> findByNameArticle(String name) {
		// TODO Auto-generated method stub
		return articleDao.findByNameArticle(name);
	}

	@Override
	public int addArtClick(Integer id) {
		// TODO Auto-generated method stub
		return articleDao.addArtClick(id);
	}

	@Override
	public List<Article> CilickArticle() {
		// TODO Auto-generated method stub
		return articleDao.CilickArticle();
	}
	
	
	
}
