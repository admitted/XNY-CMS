package me.cuijing.cms.article.service;

import java.util.List;
import java.util.Map;

import me.cuijing.cms.article.model.Article;
import me.cuijing.cms.system.util.DataTables;

/**
 * <p>Title: ArticleService</p>
 * <p>Description: 文章服务</p>
 * <p>Company: </p> 
 * @author cui
 * @date 2017年3月12日 
 */
public interface ArticleService {
	
	/**
	 * <p>Title: getPageList</p>
	 * <p>Description: 获取文章列表</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param dataTables
	 * @return DataTables
	 */
	DataTables getPageList(DataTables dataTables);
	
	/**
	 * <p>Title: addArticle</p>
	 * <p>Description: 添加文章</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日
	 * @param article
	 * @return Map<String,Object>
	 */
	Map<String, Object> addArticle(Article article);
	
	/**
	 * <p>Title: updateArticle</p>
	 * <p>Description: 修改文章</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日
	 * @param article
	 * @return Map<String,Object>
	 */
	Map<String, Object> updateArticle(Article article);

	/**
	 * <p>Title: getArticleById</p>
	 * <p>Description: 获取文章详情</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日
	 * @param id
	 * @return Article
	 */
	Article getArticleById(Integer id);

	/**
	 * <p>Title: delArticle</p>
	 * <p>Description: 删除文章</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日
	 * @param idlist
	 * @return Map<String,Object>
	 */
	Map<String, Object> delArticle(List<Integer> idlist);

	/**
	 * <p>Title: getArticle</p>
	 * <p>Description: 获取文章</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日
	 * @param id
	 * @return Article
	 */
	Article getArticle(int id);
}
