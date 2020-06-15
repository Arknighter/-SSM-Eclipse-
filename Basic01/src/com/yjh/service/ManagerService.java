package com.yjh.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.yjh.po.Manager;
/**
 * 管理员service接口
 *
 */
public interface ManagerService {
	
	//根据账号和密码查询用户
	public Manager findUser(String managername,String passwd);
	
	//根据name验证用户/查询
	public Manager findByusernameUser(String managername);
	
	//根据name验证查询
	public List<Manager> BynamefindManager(String managername);
	
	//全查manager
	public List<Manager> findManagerAll();

	//分页全查manager
	public void  findManagerAllPage(HttpServletRequest request,Model model);
	
	//添加manager
	public int addManager(Manager manager);
	//删除manager
	public int deleteManager(Integer id);
	//根据id查询manager
	public Manager findByIdManager(Integer id);
	//更新manager
	public int updateManager(Manager manager);
}
