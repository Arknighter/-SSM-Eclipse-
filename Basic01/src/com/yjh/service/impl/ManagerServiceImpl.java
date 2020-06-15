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
	
	//ע��ķ�ʽע��ManagerDao
	@Autowired
	private ManagerDao managerDao;
	
	
	
	/**
	 *��¼����
	 */
	@Override
	public Manager findUser(String managername, String passwd) {
		Manager manager = this.managerDao.findUser(managername, passwd);
		return manager;
	}
	
	
	
	/**
	 *��֤��¼
	 */
	@Override
	public Manager findByusernameUser(String managername) {
		Manager manager = this.managerDao.findByusernameUser(managername);
		return manager;
	}
	
	
	
	/**
	 *ȫ���û�
	 */
	@Override
	public List<Manager> findManagerAll() {
		List<Manager> ManagerList = this.managerDao.findManagerAll();
		return ManagerList;
	}
	
	
	
	/**
	 *��ҳ��ѯ�û�
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
				manager.setMstate("����");
			}
			if(manager.getMstate().endsWith("2")){
				manager.setMstate("δ����");
			}
		}
        model.addAttribute("page", page); 		
	}

	/**
	 *����û�
	 */
	@Override
	public int addManager(Manager manager) {
		// TODO Auto-generated method stub
		return managerDao.addManager(manager);
	}

	/**
	 *ɾ���û�
	 */
	@Override
	public int deleteManager(Integer id) {
		// TODO Auto-generated method stub
		return managerDao.deleteManager(id);
	}



	/**
	 *����id��ѯmanager
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
