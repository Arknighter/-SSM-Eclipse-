package com.yjh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yjh.po.Catalog;
import com.yjh.po.Manager;

/**
 * Catalog�ӿ��ļ�
 */
public interface CatalogDao {
	/**
	 * ȫ����Ŀ
	 */
	public List<Catalog> findCatalogAll();
	/**
	 * ��ҳȫ��
	 */
	public List<Catalog> findCatalogAllPage(@Param(value="startPos") Integer startPos,
	        @Param(value="pageSize") Integer pageSize);
	/**
	 * �û�����
	 */
	public long getCatalogAllCount();
	
	
	/**
	 * ������һ������
	 */
	public String prenumber(String number);
	
	/**
	 * ���Ʋ���
	 */
	public boolean exchange(@Param(value="numb") String numb, @Param(value="prenumb") String prenumb);
	
	/**
	 * �������canmuber
	 */
	public String canumbermax();
	
	/**
	 * ���catalog
	 */
	public int addCatalog(Catalog catalog);
	
	
	
	/**
	 * ����id����
	 */
	public Catalog findByIdCatalog(Integer id);
	
	/**
	 * ����catalog
	 */
	public int updateCatalog(Catalog catalog);
	
	/**
	 * ������Ŀ��ģ������
	 */
	public List<Catalog> findByCaname(String caname);
	
	
}
