package me.cuijing.cms.folder.service;

import java.util.List;
import java.util.Map;

import me.cuijing.cms.folder.model.Folder;
import me.cuijing.cms.system.util.DataTables;

/**
 * <p>Title: FolderService</p>
 * <p>Description: 栏目服务</p>
 * <p>Company: </p> 
 * @author cui
 * @date 2017年3月12日
 */
public interface FolderService {
	
	/**
	 * 
	 * <p>Title: getPageList</p>
	 * <p>Description: 获取栏目列表</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param dataTables
	 * @return DataTables
	 */
	DataTables getPageList(DataTables dataTables);
	
	/**
	 * 
	 * <p>Title: addFolder</p>
	 * <p>Description: 添加栏目</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param folder
	 * @return Map<String,Object>
	 */
	Map<String, Object> addFolder(Folder folder);
	
	/**
	 * <p>Title: updateFolder</p>
	 * <p>Description: 修改栏目</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param folder
	 * @return Map<String,Object>
	 */
	Map<String, Object> updateFolder(Folder folder);

	/**
	 * <p>Title: getFolderById</p>
	 * <p>Description: 获取栏目详情</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param id
	 * @return Folder
	 */
	Folder getFolderById(Integer id);

	/**
	 * 
	 * <p>Title: delFolder</p>
	 * <p>Description: 删除栏目</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param idlist
	 * @return Map<String,Object>
	 */
	Map<String, Object> delFolder(List<Integer> idlist);

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
