package me.cuijing.cms.admin.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.cuijing.cms.admin.dao.AdminMapper;
import me.cuijing.cms.admin.model.Admin;
import me.cuijing.cms.admin.service.AdminService;
import me.cuijing.cms.article.dao.ArticleMapper;
import me.cuijing.cms.menu.model.Menu;
import me.cuijing.cms.system.base.BaseService;
import me.cuijing.cms.system.util.DataTables;


/**
 * <p>Title: AdminServiceImpl</p>
 * <p>Description: 用户服务实现</p>
 * <p>Company: </p> 
 * @author cui
 * @date 2017年3月11日 
 */
@Service
public class AdminServiceImpl extends BaseService implements AdminService {
	
	@Autowired
	AdminMapper adminMapper; 

	@Override
	public Admin login(String username, String password) {
		return adminMapper.login(username, password);
	}

	@Override
	public DataTables getPageList(DataTables dataTables) {
		PageHelper.startPage(dataTables.getStart(), dataTables.getLength()); // 核心分页代码 
		PageHelper.orderBy("id desc");
		
		if(!StringUtils.isEmpty(dataTables.getColumn())){
			String column = propertyToColumn(ArticleMapper.class, dataTables.getColumn());
			if(!StringUtils.isEmpty(column)){
				PageHelper.orderBy(column + " " + dataTables.getOrder());
			}
		}
		
		PageInfo<Menu> pageInfo = new PageInfo<Menu>(adminMapper.getPageList(dataTables.getSearch(), dataTables.getSubSQL()));
		dataTables.setRecordsTotal(pageInfo.getTotal());
		dataTables.setRecordsFiltered(pageInfo.getTotal());
		dataTables.setData(pageInfo.getList() != null ? pageInfo.getList() : new ArrayList<>());
		
		return dataTables;
	}

}
