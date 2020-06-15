package com.yjh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yjh.po.Article;
import com.yjh.po.Catalog;
import com.yjh.po.Manager;

/**
 * Article接口文件
 */
public interface ArticleDao {
	
	/**
	 * 全查文章
	 */
	public List<Article> findArticleAll();
	
	/**
	 * 添加文章
	 */
	public int addArticle(Article article);
	
	/**
	 * 查找最大arnumber
	 */
	public String findarnumbermax();
	
	/**
	 * 分页全查
	 */
	public List<Article> findArticleAllPage(@Param(value="startPos") Integer startPos,
	        @Param(value="pageSize") Integer pageSize);
		
	/**
	 * 文章总数
	 */
	public long getArticleAllCount();
	
	
	
	/**
	 * 根据arid 删除文章
	 */
	public int delArticle(Integer id);
	
	/**
	 * 根据arid 查找文章
	 */
	public Article findByIdArticle(Integer id);
	
	/**
	 * 编辑文章
	 */
	public int updateArticle(Article article);
	
	
	
	/**
	 * 根据artitle模糊 查找文章
	 */
	public List<Article> findByNameArticle(String name);
	
	/**
	 * 更新addArtClick
	 */
	public int addArtClick(Integer id);
	
	/**
	 * 根据点击数全查
	 */
	public List<Article> CilickArticle();
	
	
}
