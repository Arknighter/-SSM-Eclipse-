package com.yjh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yjh.po.Article;
import com.yjh.po.Catalog;
import com.yjh.po.Manager;

/**
 * Article�ӿ��ļ�
 */
public interface ArticleDao {
	
	/**
	 * ȫ������
	 */
	public List<Article> findArticleAll();
	
	/**
	 * �������
	 */
	public int addArticle(Article article);
	
	/**
	 * �������arnumber
	 */
	public String findarnumbermax();
	
	/**
	 * ��ҳȫ��
	 */
	public List<Article> findArticleAllPage(@Param(value="startPos") Integer startPos,
	        @Param(value="pageSize") Integer pageSize);
		
	/**
	 * ��������
	 */
	public long getArticleAllCount();
	
	
	
	/**
	 * ����arid ɾ������
	 */
	public int delArticle(Integer id);
	
	/**
	 * ����arid ��������
	 */
	public Article findByIdArticle(Integer id);
	
	/**
	 * �༭����
	 */
	public int updateArticle(Article article);
	
	
	
	/**
	 * ����artitleģ�� ��������
	 */
	public List<Article> findByNameArticle(String name);
	
	/**
	 * ����addArtClick
	 */
	public int addArtClick(Integer id);
	
	/**
	 * ���ݵ����ȫ��
	 */
	public List<Article> CilickArticle();
	
	
}
