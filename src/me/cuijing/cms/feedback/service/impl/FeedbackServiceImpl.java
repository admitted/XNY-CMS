package me.cuijing.cms.feedback.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.cuijing.cms.feedback.dao.FeedbackMapper;
import me.cuijing.cms.feedback.model.Feedback;
import me.cuijing.cms.feedback.service.FeedbackService;
import me.cuijing.cms.system.base.BaseService;
import me.cuijing.cms.system.util.DataTables;
import me.cuijing.cms.system.util.RequestStatus;

/**
 * <p>Title: FeedbackServiceImpl</p>
 * <p>Description: 反馈服务实现类</p>
 * <p>Company: </p> 
 * @author cui
 * @date 2017年3月12日
 */
@Service
public class FeedbackServiceImpl extends BaseService implements FeedbackService {
	
	@Autowired
	FeedbackMapper feedbackMapper;

	@Override
	public DataTables getPageList(DataTables dataTables) {
		PageHelper.startPage(dataTables.getStart(), dataTables.getLength()); // 核心分页代码 
		PageHelper.orderBy("id desc");
		
		if(!StringUtils.isEmpty(dataTables.getColumn())){
			String column = propertyToColumn(FeedbackMapper.class, dataTables.getColumn());
			if(!StringUtils.isEmpty(column)){
				PageHelper.orderBy(column + " " + dataTables.getOrder());
			}
		}
		
		PageInfo<Feedback> pageInfo = new PageInfo<Feedback>(feedbackMapper.getPageList(dataTables.getSearch(), dataTables.getSubSQL()));
		dataTables.setRecordsTotal(pageInfo.getTotal());
		dataTables.setRecordsFiltered(pageInfo.getTotal());
		dataTables.setData(pageInfo.getList() != null ? pageInfo.getList() : new ArrayList<>());
		
		return dataTables;
	}
	
	@Override
	public Map<String, Object> addFeedback(Feedback feedback) {
		Map<String, Object> map = new HashMap<>();
		Integer id = feedbackMapper.insert(feedback);
		if (id > 0) {
			map.put("status", RequestStatus.SUCCESS);
		}else{
			map.put("status", RequestStatus.FAIL);
		}
		
		return map;
	}
	
	@Override
	public Map<String, Object> updateFeedback(Feedback feedback) {
		Map<String, Object> map = new HashMap<>();
		if (feedbackMapper.updateByPrimaryKey(feedback) > 0) {
			map.put("status", RequestStatus.SUCCESS);
		}else{
			map.put("status", RequestStatus.FAIL);
		}
		return map;
	}

	@Override
	public Feedback getFeedbackById(Integer id) {
		return feedbackMapper.selectByPrimaryKey(id);
	}

	@Override
	public Map<String, Object> delFeedback(List<Integer> idlist) {
		Map<String, Object> map = new HashMap<>();
		if (feedbackMapper.deleteByPrimaryKeys(idlist) > 0) {
			map.put("status", RequestStatus.SUCCESS);
		}else{
			map.put("status", RequestStatus.FAIL);
		}
		return map;
	}


}
