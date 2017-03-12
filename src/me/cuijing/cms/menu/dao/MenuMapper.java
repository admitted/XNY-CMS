package me.cuijing.cms.menu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import me.cuijing.cms.menu.model.Menu;

/**
 * 
 * <p>Title: MenuMapper</p>
 * <p>Description: 菜单持久层</p>
 * <p>Company: </p> 
 * @author cui
 * @date 2017年3月12日
 */
@Repository
public interface MenuMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Menu menu);

	Menu selectByPrimaryKey(Integer id);

	/**
	 * <p>Title: selectAll</p>
	 * <p>Description: 分页查询菜单</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @return List<Menu>
	 */
	List<Menu> selectAll();

	int updateByPrimaryKey(Menu menu);

	/**
	 * <p>Title: getPageList</p>
	 * <p>Description: 分页菜单列表</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param search
	 * @param subSQL
	 * @return List<Menu>
	 */
	List<Menu> getPageList(@Param("search") String search, @Param("subSQL") String subSQL);

	/**
	 * <p>Title: deleteByPrimaryKeys</p>
	 * <p>Description: 多条删除</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param idlist
	 * @return int
	 */
	int deleteByPrimaryKeys(@Param("idlist")List<Integer> idlist);
}