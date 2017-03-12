package me.cuijing.cms.folder.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import me.cuijing.cms.folder.model.Folder;

public interface FolderMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Folder record);

	Folder selectByPrimaryKey(Integer id);

	int updateByPrimaryKey(Folder record);

	/**
	 * <p>Title: getPageList</p>
	 * <p>Description: 分页返回栏目</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param search
	 * @param subSQL
	 * @return List<Folder>
	 */
	List<Folder> getPageList(@Param("search") String search, @Param("subSQL") String subSQL);

	/**
	 * <p>Title: deleteByPrimaryKeys</p>
	 * <p>Description: 多条删除</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param idlist
	 * @return int
	 */
	int deleteByPrimaryKeys(@Param("idlist") List<Integer> idlist);

	/**
	 * 
	 * <p>Title: selectAll</p>
	 * <p>Description: 获取所有的栏目(树)</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @return List<Folder>
	 */
	List<Folder> selectAll();
}