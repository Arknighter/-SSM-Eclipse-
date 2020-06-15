package com.yjh.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;

import com.yjh.po.Catalog;

/**
 * Catalog(栏目)service接口
 *
 */
public interface CatalogService {
	//全查catalog
	public List<Catalog> findCatalogAll();
	//分页查询catalog
	public void findCatalogAllPage(HttpServletRequest request,Model model);
	//查找上一条数据
	public String prenumber(String number);
	//上移
	public boolean exchage(String numb, String prenumb);
	//查找最大canmuber
	public String canumbermax();
	//添加catalog
	public int addCatalog(Catalog catalog);
	//根据id查找catalog
	public Catalog findByIdCatalog(Integer id);
	//更新catalog
	public int updateCatalog(Catalog catalog);
	//根据栏目名模糊查找
	public List<Catalog> findByCaname(String caname);
	
}
