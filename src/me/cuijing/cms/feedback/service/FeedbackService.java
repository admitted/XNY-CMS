package me.cuijing.cms.feedback.service;

import java.util.List;
import java.util.Map;

import me.cuijing.cms.feedback.model.Feedback;
import me.cuijing.cms.system.util.DataTables;

/**
 * <p>Title: FeedbackService</p>
 * <p>Description: 反馈服务</p>
 * <p>Company: </p> 
 * @author cui
 * @date 2017年3月12日
 */
public interface FeedbackService {
	
	/**
	 * 
	 * <p>Title: getPageList</p>
	 * <p>Description: 获取反馈列表</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param dataTables
	 * @return DataTables
	 */
	DataTables getPageList(DataTables dataTables);
	
	/**
	 * 
	 * <p>Title: addFeedback</p>
	 * <p>Description: 添加反馈</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param feedback
	 * @return Map<String,Object>
	 */
	Map<String, Object> addFeedback(Feedback feedback);
	
	/**
	 * <p>Title: updateFeedback</p>
	 * <p>Description: 修改反馈</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param feedback
	 * @return Map<String,Object>
	 */
	Map<String, Object> updateFeedback(Feedback feedback);

	/**
	 * <p>Title: getFeedbackById</p>
	 * <p>Description: 获取反馈详情</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param id
	 * @return Feedback
	 */
	Feedback getFeedbackById(Integer id);

	/**
	 * 
	 * <p>Title: delFeedback</p>
	 * <p>Description: 删除反馈</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param idlist
	 * @return Map<String,Object>
	 */
	Map<String, Object> delFeedback(List<Integer> idlist);
}
