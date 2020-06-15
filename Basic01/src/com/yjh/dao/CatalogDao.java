package com.yjh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yjh.po.Catalog;
import com.yjh.po.Manager;

/**
 * Catalog接口文件
 */
public interface CatalogDao {
	/**
	 * 全查栏目
	 */
	public List<Catalog> findCatalogAll();
	/**
	 * 分页全查
	 */
	public List<Catalog> findCatalogAllPage(@Param(value="startPos") Integer startPos,
	        @Param(value="pageSize") Integer pageSize);
	/**
	 * 用户总数
	 */
	public long getCatalogAllCount();
	
	
	/**
	 * 查找上一条数据
	 */
	public String prenumber(String number);
	
	/**
	 * 上移操作
	 */
	public boolean exchange(@Param(value="numb") String numb, @Param(value="prenumb") String prenumb);
	
	/**
	 * 查找最大canmuber
	 */
	public String canumbermax();
	
	/**
	 * 添加catalog
	 */
	public int addCatalog(Catalog catalog);
	
	
	
	/**
	 * 根据id查找
	 */
	public Catalog findByIdCatalog(Integer id);
	
	/**
	 * 更新catalog
	 */
	public int updateCatalog(Catalog catalog);
	
	/**
	 * 根据栏目名模糊查找
	 */
	public List<Catalog> findByCaname(String caname);
	
	
}
