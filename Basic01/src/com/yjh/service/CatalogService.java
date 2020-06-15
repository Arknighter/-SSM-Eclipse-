package com.yjh.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;

import com.yjh.po.Catalog;

/**
 * Catalog(��Ŀ)service�ӿ�
 *
 */
public interface CatalogService {
	//ȫ��catalog
	public List<Catalog> findCatalogAll();
	//��ҳ��ѯcatalog
	public void findCatalogAllPage(HttpServletRequest request,Model model);
	//������һ������
	public String prenumber(String number);
	//����
	public boolean exchage(String numb, String prenumb);
	//�������canmuber
	public String canumbermax();
	//���catalog
	public int addCatalog(Catalog catalog);
	//����id����catalog
	public Catalog findByIdCatalog(Integer id);
	//����catalog
	public int updateCatalog(Catalog catalog);
	//������Ŀ��ģ������
	public List<Catalog> findByCaname(String caname);
	
}
