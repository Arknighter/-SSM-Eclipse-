package com.yjh.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.yjh.dao.CatalogDao;
import com.yjh.po.Catalog;
import com.yjh.po.Manager;
import com.yjh.po.Page;
import com.yjh.service.CatalogService;

@Service("catalogService")
@Transactional
public class CatalogServiceImpl implements CatalogService {

	//注解的方式注入CatalogDao
	@Autowired
	private CatalogDao catalogDao;

	@Override
	public List<Catalog> findCatalogAll() {
		return catalogDao.findCatalogAll();
	}

	@Override
	public void findCatalogAllPage(HttpServletRequest request, Model model) {
		String pageNow = request.getParameter("pageNow"); 
		Page page = null; 
		
		List<Catalog> cataloglist = new ArrayList<Catalog>();
		
		int totalCount = (int) catalogDao.getCatalogAllCount();
		
		if (pageNow != null) { 
            page = new Page(totalCount, Integer.parseInt(pageNow)); 
            cataloglist = this.catalogDao.findCatalogAllPage(page.getStartPos(), page.getPageSize());       
        } else { 
            page = new Page(totalCount, 1); 
            cataloglist = this.catalogDao.findCatalogAllPage(page.getStartPos(), page.getPageSize());  
        } 
		
		model.addAttribute("CatalogList", cataloglist); 
		for (Catalog catalog : cataloglist) {
			if(catalog.getCastate().endsWith("1")){
				catalog.setCastate("启动");
			}
			if(catalog.getCastate().endsWith("2")){
				catalog.setCastate("未启动");
			}
		}
        model.addAttribute("page", page); 		
	}

	@Override
	public boolean exchage(String numb, String prenumb) {
		return catalogDao.exchange(numb, prenumb);
	}

	@Override
	public String prenumber(String number) {
		return catalogDao.prenumber(number);
	}

	@Override
	public String canumbermax() {
		return catalogDao.canumbermax();
	}

	@Override
	public int addCatalog(Catalog catalog) {
		return catalogDao.addCatalog(catalog);
	}

	@Override
	public Catalog findByIdCatalog(Integer id) {
		return catalogDao.findByIdCatalog(id);
	}

	@Override
	public int updateCatalog(Catalog catalog) {
		// TODO Auto-generated method stub
		return catalogDao.updateCatalog(catalog);
	}

	@Override
	public List<Catalog> findByCaname(String caname) {
		return catalogDao.findByCaname(caname);
	}
}
