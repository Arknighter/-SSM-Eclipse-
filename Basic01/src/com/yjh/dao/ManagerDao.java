package com.yjh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yjh.po.Manager;

/**
 * Manager�ӿ��ļ�
 *
 */
public interface ManagerDao {
	/**
	 * �����˺ź������ѯ�û�
	 */
	public Manager findUser(@Param("managername")String managername,@Param("passwd")String passwd);
	
	/**
	 * ����username��ѯ�û�
	 */
	public Manager findByusernameUser(String managername);
	
	/**
	 * ����usernameģ����ѯ�û�
	 */
	public List<Manager> findusername(String managername);
	
	/**
	 * ȫ���û�
	 */
	public List<Manager> findManagerAll();
	
	/**
	 * ��ҳȫ��
	 */
	public List<Manager> findManagerAllPage(@Param(value="startPos") Integer startPos,
	        @Param(value="pageSize") Integer pageSize);
	/**
	 * �û�����
	 */
	public long getManagerCount();
	
	/**
	 * ����û�
	 * @param manager
	 * @return
	 */
	public int addManager(Manager manager);

	

	/**
	 * ɾ���û�
	 */
	public int deleteManager(Integer id);
	
	
	/**
	 * ����id��ѯ�û�
	 */
	public Manager findByIdManager(Integer id);
	
	
	/**
	 * �����û�
	 */
	public int updateManager(Manager manager);
	
}
