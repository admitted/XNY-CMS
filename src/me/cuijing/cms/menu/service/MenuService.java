package me.cuijing.cms.menu.service;

import java.util.List;
import java.util.Map;

import me.cuijing.cms.menu.model.Menu;
import me.cuijing.cms.system.util.DataTables;

/**
 * <p>Title: MenuService</p>
 * <p>Description: 菜单服务</p>
 * <p>Company: </p> 
 * @author cui
 * @date 2017年3月12日
 */
public interface MenuService {
	
	/**
	 * <p>Title: getPageList</p>
	 * <p>Description: 获取分页菜单列表</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param dataTables
	 * @return DataTables
	 */
	DataTables getPageList(DataTables dataTables);

	/**
	 * <p>Title: addMenu</p>
	 * <p>Description: 添加菜单</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param menu
	 * @return Map<String,Object>
	 */
	Map<String, Object> addMenu(Menu menu);
	
	/**
	 * <p>Title: selectAll</p>
	 * <p>Description: 获取所有菜单数据</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @return List<Menu>
	 */
	List<Menu> selectAll();

	/**
	 * <p>Title: updateMenu</p>
	 * <p>Description: 修改菜单</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param menu
	 * @return Map<String,Object>
	 */
	Map<String, Object> updateMenu(Menu menu);

	/**
	 * <p>Title: getMenuById</p>
	 * <p>Description: 获取菜单详情</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param id
	 * @return Menu
	 */
	Menu getMenuById(Integer id);

	/**
	 * <p>Title: delMenu</p>
	 * <p>Description: 删除菜单</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param idlist
	 * @return Map<String,Object>
	 */
	Map<String, Object> delMenu(List<Integer> idlist);
}
