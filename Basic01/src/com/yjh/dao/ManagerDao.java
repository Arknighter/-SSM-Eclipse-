package com.yjh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yjh.po.Manager;

/**
 * Manager接口文件
 *
 */
public interface ManagerDao {
	/**
	 * 根据账号和密码查询用户
	 */
	public Manager findUser(@Param("managername")String managername,@Param("passwd")String passwd);
	
	/**
	 * 根据username查询用户
	 */
	public Manager findByusernameUser(String managername);
	
	/**
	 * 根据username模糊查询用户
	 */
	public List<Manager> findusername(String managername);
	
	/**
	 * 全查用户
	 */
	public List<Manager> findManagerAll();
	
	/**
	 * 分页全查
	 */
	public List<Manager> findManagerAllPage(@Param(value="startPos") Integer startPos,
	        @Param(value="pageSize") Integer pageSize);
	/**
	 * 用户总数
	 */
	public long getManagerCount();
	
	/**
	 * 添加用户
	 * @param manager
	 * @return
	 */
	public int addManager(Manager manager);

	

	/**
	 * 删除用户
	 */
	public int deleteManager(Integer id);
	
	
	/**
	 * 根据id查询用户
	 */
	public Manager findByIdManager(Integer id);
	
	
	/**
	 * 更新用户
	 */
	public int updateManager(Manager manager);
	
}
