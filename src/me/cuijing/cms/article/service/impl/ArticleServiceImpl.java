package me.cuijing.cms.article.service.impl;

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
import me.cuijing.cms.article.model.Article;
import me.cuijing.cms.article.service.ArticleService;
import me.cuijing.cms.system.base.BaseService;
import me.cuijing.cms.system.util.DataTables;
import me.cuijing.cms.system.util.RequestStatus;

/**
 * <p>Title: ArticleServiceImpl</p>
 * <p>Description: 文章服务实现类</p>
 * <p>Company: </p> 
 * @author cui
 * @date 2017年3月12日 
 */
@Service
public class ArticleServiceImpl extends BaseService implements ArticleService {
	
	@Autowired
	ArticleMapper articleMapper;

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
		
		PageInfo<Article> pageInfo = new PageInfo<Article>(articleMapper.getPageList(dataTables.getSearch(), dataTables.getSubSQL()));
		dataTables.setRecordsTotal(pageInfo.getTotal());
		dataTables.setRecordsFiltered(pageInfo.getTotal());
		dataTables.setData(pageInfo.getList() != null ? pageInfo.getList() : new ArrayList<>());
		
		return dataTables;
	}
	
	@Override
	public Map<String, Object> addArticle(Article article) {
		Map<String, Object> map = new HashMap<>();
		Integer id = articleMapper.insert(article);
		if (id > 0) {
			map.put("status", RequestStatus.SUCCESS);
		}else{
			map.put("status", RequestStatus.FAIL);
		}
		
		return map;
	}
	
	@Override
	public Map<String, Object> updateArticle(Article article) {
		Map<String, Object> map = new HashMap<>();
		if (articleMapper.updateByPrimaryKey(article) > 0) {
			map.put("status", RequestStatus.SUCCESS);
		}else{
			map.put("status", RequestStatus.FAIL);
		}
		return map;
	}

	@Override
	public Article getArticleById(Integer id) {
		return articleMapper.selectByPrimaryKey(id);
	}

	@Override
	public Map<String, Object> delArticle(List<Integer> idlist) {
		Map<String, Object> map = new HashMap<>();
		if (articleMapper.deleteByPrimaryKeys(idlist) > 0) {
			map.put("status", RequestStatus.SUCCESS);
		}else{
			map.put("status", RequestStatus.FAIL);
		}
		return map;
	}

	@Override
	public Article getArticle(int id) {
		return articleMapper.selectByPrimaryKey(id);
	}
}
