package com.yjh.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.yjh.po.Article;
import com.yjh.po.Manager;

/**
 *Article(文章)service接口
 *
 */
public interface ArticleService {
	
	//全查文章
	public List<Article> findArticleAll();
	
	//查找最大arnumber
	public String findarnumbermax();
	
	//添加文字
	public int addArticle(Article article);
	
	//分页查询
	public void findArticleAllPage(HttpServletRequest request,Model model);
	
	//根据arid删除文章
	public int delArticle(Integer id);
	
	//根据arid查找文章
	public Article findByIdArticle(Integer id);
	//根据arid查找文章后更新文章
	public int updateArticle(Article article);
	
	// 根据artitle模糊 查找文章
	public List<Article> findByNameArticle(String name);
	
	//点击量
	public int addArtClick(Integer id);
	
	//click
	public List<Article> CilickArticle();
}
