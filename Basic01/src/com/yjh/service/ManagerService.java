package com.yjh.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.yjh.po.Manager;
/**
 * ����Աservice�ӿ�
 *
 */
public interface ManagerService {
	
	//�����˺ź������ѯ�û�
	public Manager findUser(String managername,String passwd);
	
	//����name��֤�û�/��ѯ
	public Manager findByusernameUser(String managername);
	
	//����name��֤��ѯ
	public List<Manager> BynamefindManager(String managername);
	
	//ȫ��manager
	public List<Manager> findManagerAll();

	//��ҳȫ��manager
	public void  findManagerAllPage(HttpServletRequest request,Model model);
	
	//���manager
	public int addManager(Manager manager);
	//ɾ��manager
	public int deleteManager(Integer id);
	//����id��ѯmanager
	public Manager findByIdManager(Integer id);
	//����manager
	public int updateManager(Manager manager);
}
