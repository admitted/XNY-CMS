package me.cuijing.cms.menu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.cuijing.cms.article.dao.ArticleMapper;
import me.cuijing.cms.menu.dao.MenuMapper;
import me.cuijing.cms.menu.model.Menu;
import me.cuijing.cms.menu.service.MenuService;
import me.cuijing.cms.system.base.BaseService;
import me.cuijing.cms.system.util.DataTables;
import me.cuijing.cms.system.util.RequestStatus;

/**
 * <p>Title: MenuServiceImpl</p>
 * <p>Description: 菜单服务实现</p>
 * <p>Company: </p> 
 * @author cui
 * @date 2017年3月12日
 */
@Service
public class MenuServiceImpl extends BaseService implements MenuService {
	
	@Autowired
	MenuMapper menuMapper; 

	@Override
	public DataTables getPageList(DataTables dataTables) {
		PageHelper.startPage(dataTables.getStart(), dataTables.getLength()); // 核心分页代码 
		PageHelper.orderBy("sort asc");
		
		if(!StringUtils.isEmpty(dataTables.getColumn())){
			String column = propertyToColumn(ArticleMapper.class, dataTables.getColumn());
			if(!StringUtils.isEmpty(column)){
				PageHelper.orderBy(column + " " + dataTables.getOrder());
			}
		}
		
		PageInfo<Menu> pageInfo = new PageInfo<Menu>(menuMapper.getPageList(dataTables.getSearch(), dataTables.getSubSQL()));
		dataTables.setRecordsTotal(pageInfo.getTotal());
		dataTables.setRecordsFiltered(pageInfo.getTotal());
		dataTables.setData(pageInfo.getList() != null ? pageInfo.getList() : new ArrayList<>());
		
		return dataTables;
	}

	@Override
	public Map<String, Object> addMenu(Menu menu) {
		Map<String, Object> map = new HashMap<>();
		Integer id = menuMapper.insert(menu);
		if (id > 0) {
			map.put("status", RequestStatus.SUCCESS);
		}else{
			map.put("status", RequestStatus.FAIL);
		}
		
		return map;
	}

	@Override
	public List<Menu> selectAll() {
		List<Menu> menus = menuMapper.selectAll();
		for (Menu menu : menus) {
			menu.setIcon(null);
		}
		return menus;
	}

	@Override
	public Map<String, Object> updateMenu(Menu menu) {
		Map<String, Object> map = new HashMap<>();
		if (menuMapper.updateByPrimaryKey(menu) > 0) {
			map.put("status", RequestStatus.SUCCESS);
		}else{
			map.put("status", RequestStatus.FAIL);
		}
		return map;
	}

	@Override
	public Menu getMenuById(Integer id) {
		return menuMapper.selectByPrimaryKey(id);
	}

	@Override
	public Map<String, Object> delMenu(List<Integer> idlist) {
		Map<String, Object> map = new HashMap<>();
		if (menuMapper.deleteByPrimaryKeys(idlist) > 0) {
			map.put("status", RequestStatus.SUCCESS);
		}else{
			map.put("status", RequestStatus.FAIL);
		}
		return map;
	}

}
