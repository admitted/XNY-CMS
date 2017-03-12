package me.cuijing.cms.article.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import me.cuijing.cms.article.model.Article;

/**
 * 
 * <p>Title: ArticleMapper</p>
 * <p>Description: 文章持久层</p>
 * <p>Company: </p> 
 * @author cui
 * @date 2017年3月12日
 */
@Repository
public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    Article selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Article record);

	Integer recordsTotal();
	
	Integer recordsFiltered(@Param("search") String search);
	
	/**
	 * 
	 * <p>Title: deleteByPrimaryKeys</p>
	 * <p>Description: 多条删除</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param idlist
	 * @return int
	 */
	int deleteByPrimaryKeys(@Param("idlist")List<Integer> idlist);
	
	List<Article> getPageList(@Param("search") String search, @Param("subSQL") String subSQL);
}