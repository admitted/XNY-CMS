package me.cuijing.cms.admin.service;

import me.cuijing.cms.admin.model.Admin;
import me.cuijing.cms.system.util.DataTables;

/**
 * 用户服务
 * @author cui
 * @date 2017年3月10日
 */
public interface AdminService {
	
	/**
	 * <p>Title: login </p>
	 * <p>Description: 用户登录</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月11日 
	 * @param username
	 * @param password
	 * @return Admin
	 */
	Admin login(String username, String password);

	/**
	 * <p>Title: getPageList </p>
	 * <p>Description: 获取分页数据</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月11日 
	 * @param dataTables
	 * @return DataTables
	 */
	DataTables getPageList(DataTables dataTables);

}
