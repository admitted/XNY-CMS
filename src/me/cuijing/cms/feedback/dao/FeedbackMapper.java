package me.cuijing.cms.feedback.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import me.cuijing.cms.feedback.model.Feedback;

public interface FeedbackMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Feedback feedback);

    Feedback selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Feedback feedback);
    
    /**
	 * 
     * <p>Title: getPageList</p>
     * <p>Description: 分页反馈列表</p>
     * <p>Company: </p> 
     * @author cui
     * @date 2017年3月12日 
     * @param search
     * @param subSQL
     * @return List<Feedback>
     */
	List<Feedback> getPageList(@Param("search") String search, @Param("subSQL") String subSQL);
	
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
}