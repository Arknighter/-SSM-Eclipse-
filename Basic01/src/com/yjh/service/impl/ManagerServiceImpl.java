package com.yjh.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.yjh.dao.ManagerDao;
import com.yjh.po.Manager;
import com.yjh.po.Page;
import com.yjh.service.ManagerService;

@Service("managerService")
@Transactional
public class ManagerServiceImpl implements ManagerService {
	
	//注解的方式注入ManagerDao
	@Autowired
	private ManagerDao managerDao;
	
	
	
	/**
	 *登录查找
	 */
	@Override
	public Manager findUser(String managername, String passwd) {
		Manager manager = this.managerDao.findUser(managername, passwd);
		return manager;
	}
	
	
	
	/**
	 *验证登录
	 */
	@Override
	public Manager findByusernameUser(String managername) {
		Manager manager = this.managerDao.findByusernameUser(managername);
		return manager;
	}
	
	
	
	/**
	 *全查用户
	 */
	@Override
	public List<Manager> findManagerAll() {
		List<Manager> ManagerList = this.managerDao.findManagerAll();
		return ManagerList;
	}
	
	
	
	/**
	 *分页查询用户
	 */
	
	@Override
	public void  findManagerAllPage(HttpServletRequest request,Model model) {
		String pageNow = request.getParameter("pageNow"); 
		Page page = null; 
		
		List<Manager> managerlist = new ArrayList<Manager>();
		
		int totalCount = (int) managerDao.getManagerCount();
		
		if (pageNow != null) { 
            page = new Page(totalCount, Integer.parseInt(pageNow)); 
            managerlist = this.managerDao.findManagerAllPage(page.getStartPos(), page.getPageSize());          
        } else { 
            page = new Page(totalCount, 1); 
            managerlist = this.managerDao.findManagerAllPage(page.getStartPos(), page.getPageSize());  
        } 
		
		model.addAttribute("ManagerList", managerlist); 
		for (Manager manager : managerlist) {
			if(manager.getMstate().endsWith("1")){
				manager.setMstate("启动");
			}
			if(manager.getMstate().endsWith("2")){
				manager.setMstate("未启动");
			}
		}
        model.addAttribute("page", page); 		
	}

	/**
	 *添加用户
	 */
	@Override
	public int addManager(Manager manager) {
		// TODO Auto-generated method stub
		return managerDao.addManager(manager);
	}

	/**
	 *删除用户
	 */
	@Override
	public int deleteManager(Integer id) {
		// TODO Auto-generated method stub
		return managerDao.deleteManager(id);
	}



	/**
	 *根据id查询manager
	 */
	@Override
	public Manager findByIdManager(Integer id) {
		// TODO Auto-generated method stub
		return managerDao.findByIdManager(id);
	}



	@Override
	public int updateManager(Manager manager) {
		// TODO Auto-generated method stub
		return managerDao.updateManager(manager);
	}



	@Override
	public List<Manager> BynamefindManager(String managername) {
		// TODO Auto-generated method stub
		return managerDao.findusername(managername);
	}

}
