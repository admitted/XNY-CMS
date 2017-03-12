package me.cuijing.cms.folder.service.impl;

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
import me.cuijing.cms.folder.dao.FolderMapper;
import me.cuijing.cms.folder.model.Folder;
import me.cuijing.cms.folder.service.FolderService;
import me.cuijing.cms.system.base.BaseService;
import me.cuijing.cms.system.util.DataTables;
import me.cuijing.cms.system.util.RequestStatus;

/**
 * 
 * <p>Title: FolderServiceImpl</p>
 * <p>Description: 栏目服务实现类</p>
 * <p>Company: </p> 
 * @author cui
 * @date 2017年3月12日
 */
@Service
public class FolderServiceImpl extends BaseService implements FolderService {
	
	@Autowired
	FolderMapper folderMapper;

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
		
		PageInfo<Folder> pageInfo = new PageInfo<Folder>(folderMapper.getPageList(dataTables.getSearch(), dataTables.getSubSQL()));
		dataTables.setRecordsTotal(pageInfo.getTotal());
		dataTables.setRecordsFiltered(pageInfo.getTotal());
		dataTables.setData(pageInfo.getList() != null ? pageInfo.getList() : new ArrayList<>());
		
		return dataTables;
	}
	
	@Override
	public Map<String, Object> addFolder(Folder folder) {
		Map<String, Object> map = new HashMap<>();
		Integer id = folderMapper.insert(folder);
		if (id > 0) {
			map.put("status", RequestStatus.SUCCESS);
		}else{
			map.put("status", RequestStatus.FAIL);
		}
		
		return map;
	}
	
	@Override
	public Map<String, Object> updateFolder(Folder folder) {
		Map<String, Object> map = new HashMap<>();
		if (folderMapper.updateByPrimaryKey(folder) > 0) {
			map.put("status", RequestStatus.SUCCESS);
		}else{
			map.put("status", RequestStatus.FAIL);
		}
		return map;
	}

	@Override
	public Folder getFolderById(Integer id) {
		return folderMapper.selectByPrimaryKey(id);
	}

	@Override
	public Map<String, Object> delFolder(List<Integer> idlist) {
		Map<String, Object> map = new HashMap<>();
		if (folderMapper.deleteByPrimaryKeys(idlist) > 0) {
			map.put("status", RequestStatus.SUCCESS);
		}else{
			map.put("status", RequestStatus.FAIL);
		}
		return map;
	}

	@Override
	public List<Folder> selectAll() {
		return folderMapper.selectAll();
	}
}
