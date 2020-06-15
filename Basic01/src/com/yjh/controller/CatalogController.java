package com.yjh.controller;

import java.util.List;

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

import com.yjh.dao.CatalogDao;
import com.yjh.po.Catalog;
import com.yjh.po.Manager;
import com.yjh.service.CatalogService;

@Controller
public class CatalogController {

	//依赖注入
	@Autowired
	private CatalogService catalogService;
	
	/**
	 * 全查catalog
	 */
	@RequestMapping("/findCatalogAll")
	public String findCatalogAll(Model model) {
		List<Catalog> cataloglist = catalogService.findCatalogAll();
		model.addAttribute("CatalogList", cataloglist);
		for (Catalog catalog : cataloglist) {
			if(catalog.getCastate().endsWith("1")){
				catalog.setCastate("启动");
			}
			if(catalog.getCastate().endsWith("2")){
				catalog.setCastate("未启动");
			}
		}
		return "cataloglist";
	}
	
	
	/**
	 * 分页全查catalog
	 */
	@RequestMapping("/findCatalogAllPage")
	public String PageManager(HttpServletRequest request,Model model) {
		catalogService.findCatalogAllPage(request, model);
		return "cataloglist";
	}
	
	/**
	 * 上移操作
	 */
	@RequestMapping("/exchange")
	@ResponseBody
	public String exchange(String canumber) {
		System.out.println(canumber);
		String prenumber = catalogService.prenumber(canumber);
		if(prenumber !=null&&prenumber.length()>0){
			boolean t = catalogService.exchage(canumber, prenumber);
			if(t==true) {
				return "OK";
			}
		}
		return "Fle";
	}
	
	/**
	 * 查找最大canmuber
	 */
	@RequestMapping("/canumbermax" )
	public String canmuber(Model model) {
		String canumbermax = catalogService.canumbermax();
		if(canumbermax == null){
			canumbermax="0";
		}
		int nownu = Integer.parseInt(canumbermax)+1;
		String nownumber = nownu+"";
		model.addAttribute("nownumber", nownumber);
		return "catalogadd";
	}	
	
	/**
	 * 添加catalog
	 */
	@RequestMapping("/addCatalog")
	@ResponseBody
	public String addCatalog(String caname,Catalog catalog) {
		if(caname!="") {
			int rows = catalogService.addCatalog(catalog);
			System.out.println("rows======"+rows);
			if(rows == 1) {
				return "OK";
			}			
		}
		return "Fle";
	}
	
	/**
	 * 根据id查找catalog
	 */
	@RequestMapping("/findByIdCatalog/{id}")
	public String findByIdCatalog(@PathVariable("id") int id,HttpSession session) {
		Catalog catalog = catalogService.findByIdCatalog(id);
		session.setAttribute("catalog",catalog);
		return "catalogupdate";
	}
	
	
	/**
	 * 更新catalog
	 */
	@RequestMapping("/updateCatalog" )
	@ResponseBody
	public String updateCatalog(Catalog catalog) {		
		int rows = catalogService.updateCatalog(catalog);
		if(rows == 1) {
			return "OK";
		}
		return "Fle";
	}
	/**
	 * 根据栏目名模糊查找
	 */
	@RequestMapping("/findByCaname")
	public String findByCaname(Model model ,HttpServletRequest request) {
		String caname = request.getParameter("findcaname");
		List<Catalog> cataloglist = catalogService.findByCaname(caname);
		model.addAttribute("CatalogList", cataloglist);
		for (Catalog catalog : cataloglist) {
			if(catalog.getCastate().endsWith("1")){
				catalog.setCastate("启动");
			}
			if(catalog.getCastate().endsWith("2")){
				catalog.setCastate("未启动");
			}			
		}
		return "cataloglist";
	}

	
}
