package com.yjh.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.yjh.po.Article;
import com.yjh.po.Manager;

/**
 *Article(����)service�ӿ�
 *
 */
public interface ArticleService {
	
	//ȫ������
	public List<Article> findArticleAll();
	
	//�������arnumber
	public String findarnumbermax();
	
	//�������
	public int addArticle(Article article);
	
	//��ҳ��ѯ
	public void findArticleAllPage(HttpServletRequest request,Model model);
	
	//����aridɾ������
	public int delArticle(Integer id);
	
	//����arid��������
	public Article findByIdArticle(Integer id);
	//����arid�������º��������
	public int updateArticle(Article article);
	
	// ����artitleģ�� ��������
	public List<Article> findByNameArticle(String name);
	
	//�����
	public int addArtClick(Integer id);
	
	//click
	public List<Article> CilickArticle();
}
