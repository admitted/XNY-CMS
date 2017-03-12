package me.cuijing.cms.role.service;

import java.util.List;
import java.util.Map;

import me.cuijing.cms.role.model.Role;
import me.cuijing.cms.system.util.DataTables;

/**
 * <p>Title: RoleService</p>
 * <p>Description: 角色服务</p>
 * <p>Company: </p> 
 * @author cui
 * @date 2017年3月12日
 */
public interface RoleService {
	
	/**
	 * <p>Title: getPageList</p>
	 * <p>Description: 获取分页角色列表</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param dataTables
	 * @return DataTables
	 */
	DataTables getPageList(DataTables dataTables);

	/**
	 * <p>Title: addRole</p>
	 * <p>Description: 添加角色</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param role
	 * @param menuIds
	 * @return Map<String,Object>
	 */
	Map<String, Object> addRole(Role role, String menuIds);

	/**
	 * <p>Title: updateRole</p>
	 * <p>Description: 修改角色</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param role
	 * @param menuIds
	 * @return Map<String,Object>
	 */
	Map<String, Object> updateRole(Role role, String menuIds);

	/**
	 * <p>Title: getRoleById</p>
	 * <p>Description: 获取角色详情</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param id
	 * @return Role
	 */
	Role getRoleById(Integer id);

	/**
	 * <p>Title: delRole</p>
	 * <p>Description: 删除角色</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param idlist
	 * @return Map<String,Object>
	 */
	Map<String, Object> delRole(List<Integer> idlist);

	/**
	 * <p>Title: selectAll</p>
	 * <p>Description: 查询出所有的角色</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @return List<Role>
	 */
	List<Role> selectAll();
}
