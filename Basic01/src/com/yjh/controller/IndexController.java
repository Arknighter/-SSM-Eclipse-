package com.yjh.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjh.po.Article;
import com.yjh.po.Catalog;
import com.yjh.service.ArticleService;
import com.yjh.service.CatalogService;
import com.yjh.utils.DelHTMLTag;


/**
 * 界面链接跳转
 *
 */

@Controller
public class IndexController {
	
	//依赖注入
		@Autowired
		private ArticleService articleService;
		@Autowired
		private CatalogService catalogService;
	
	
		/**
		 * 根据arid查询文章
		 */
		@RequestMapping("/welcome/findByIdArticle/{id}")
		public String findByIdArticle(@PathVariable("id") int id,Model model) {
			Article article = articleService.findByIdArticle(id);
			articleService.addArtClick(id);
			List<Catalog> cataloglist  = catalogService.findCatalogAll();
			List<Article> articlelist = articleService.findArticleAll();
			List<Article> artlist = articleService.CilickArticle();
			model.addAttribute("cArticles", artlist);
			model.addAttribute("article", article);
			model.addAttribute("articles", articlelist);
			model.addAttribute("catalogs", cataloglist);
			return "Articlemain";
		}
		
		
		
	@RequestMapping("/welcome")
	public String toeveryindex(Model model) {
		List<Article> articlelist = articleService.findArticleAll();
		List<Article> artlist = articleService.CilickArticle();
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
		}
		List<Catalog> cataloglist = catalogService.findCatalogAll();
		model.addAttribute("articles", articlelist);
		model.addAttribute("cArticles", artlist);
		model.addAttribute("catalogs", cataloglist);
		return "EveryOneindex";
	}

	@RequestMapping("/index")
	public String toindex() {
		
		return "index";
	}
	
	
	@RequestMapping("/login")
	public String tologin() {
		return "login";
	}
	
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
	
	
	
	@RequestMapping("/toleft")
	public String toleft() {
		return "left";
	}
	@RequestMapping("/totop")
	public String totop() {
		return "top";
	}
	@RequestMapping("/tomain")
	public String tomain() {
		return "main";
	}
	@RequestMapping("/toswich")
	public String toswitch() {
		return "swich";
	}
	@RequestMapping("/tobottom")
	public String tobottom() {
		return "bottom";
	}
	
	
	@RequestMapping("/toManagerAdd")
	public String toManagerAdd() {
		return "mainadd";
	}
	
}
