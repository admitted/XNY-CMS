package me.cuijing.cms.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import me.cuijing.cms.comment.model.Comment;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Comment record);
    
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
	
	List<Comment> getPageList(@Param("search") String search, @Param("subSQL") String subSQL);
}