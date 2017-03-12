package me.cuijing.cms.comment.service;

import java.util.List;
import java.util.Map;

import me.cuijing.cms.comment.model.Comment;
import me.cuijing.cms.system.util.DataTables;

/**
 * <p>Title: CommentService</p>
 * <p>Description: 评论服务</p>
 * <p>Company: </p> 
 * @author cui
 * @date 2017年3月12日 
 */
public interface CommentService {
	
	/**
	 * 
	 * <p>Title: getPageList</p>
	 * <p>Description: 获取评论列表</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param dataTables
	 * @return DataTables
	 */
	DataTables getPageList(DataTables dataTables);
	
	/**
	 * 
	 * <p>Title: addComment</p>
	 * <p>Description: 添加评论</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param comment
	 * @return Map<String,Object>
	 */
	Map<String, Object> addComment(Comment comment);

	/**
	 * 
	 * <p>Title: updateComment</p>
	 * <p>Description: 修改评论</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param comment
	 * @return Map<String,Object>
	 */
	Map<String, Object> updateComment(Comment comment);

	/**
	 * 
	 * <p>Title: getCommentById</p>
	 * <p>Description: 获取评论详情</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param id
	 * @return Comment
	 */
	Comment getCommentById(Integer id);

	/**
	 * 
	 * <p>Title: delComment</p>
	 * <p>Description: 删除评论</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param idlist
	 * @return Map<String,Object>
	 */
	Map<String, Object> delComment(List<Integer> idlist);
}
