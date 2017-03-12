package me.cuijing.cms.role.service.impl;

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
import me.cuijing.cms.authorities.service.AuthoritiesService;
import me.cuijing.cms.role.dao.RoleMapper;
import me.cuijing.cms.role.model.Role;
import me.cuijing.cms.role.service.RoleService;
import me.cuijing.cms.system.base.BaseService;
import me.cuijing.cms.system.util.DataTables;
import me.cuijing.cms.system.util.RequestStatus;

/**
 * <p>Title: RoleServiceImpl</p>
 * <p>Description: 用户服务实现</p>
 * <p>Company: </p> 
 * @author cui
 * @date 2017年3月12日
 */
@Service
public class RoleServiceImpl extends BaseService implements RoleService {
	
	@Autowired
	RoleMapper roleMapper; 
	
	@Autowired
	AuthoritiesService authoritiesService;

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
		
		PageInfo<Role> pageInfo = new PageInfo<Role>(roleMapper.getPageList(dataTables.getSearch(), dataTables.getSubSQL()));
		dataTables.setRecordsTotal(pageInfo.getTotal());
		dataTables.setRecordsFiltered(pageInfo.getTotal());
		dataTables.setData(pageInfo.getList() != null ? pageInfo.getList() : new ArrayList<>());
		
		return dataTables;
	}

	@Override
	public Map<String, Object> addRole(Role role, String menuIds) {
		Map<String, Object> map = new HashMap<>();
		Integer id = roleMapper.insert(role);
		if (id > 0) {
			authoritiesService.grant(id, menuIds);
			map.put("status", RequestStatus.SUCCESS);
		}else{
			map.put("status", RequestStatus.FAIL);
		}
		
		return map;
	}

	@Override
	public Map<String, Object> updateRole(Role role, String menuIds) {
		Map<String, Object> map = new HashMap<>();
		if (roleMapper.updateByPrimaryKey(role) > 0) {
			authoritiesService.grant(role.getId(), menuIds);
			map.put("status", RequestStatus.SUCCESS);
		}else{
			map.put("status", RequestStatus.FAIL);
		}
		return map;
	}

	@Override
	public Role getRoleById(Integer id) {
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public Map<String, Object> delRole(List<Integer> idlist) {
		Map<String, Object> map = new HashMap<>();
		if (roleMapper.deleteByPrimaryKeys(idlist) > 0) {
			map.put("status", RequestStatus.SUCCESS);
		}else{
			map.put("status", RequestStatus.FAIL);
		}
		return map;
	}

	@Override
	public List<Role> selectAll() {
		return roleMapper.selectAll();
	}
}
