package me.cuijing.cms.feedback.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import me.cuijing.cms.admin.model.Admin;
import me.cuijing.cms.feedback.model.Feedback;
import me.cuijing.cms.feedback.service.FeedbackService;
import me.cuijing.cms.system.base.BaseController;
import me.cuijing.cms.system.util.DataTables;

/**
 * <p>Title: FeedbackController</p>
 * <p>Description: 反馈控制</p>
 * <p>Company: </p> 
 * @author cui
 * @date 2017年3月12日
 */
@Controller
@RequestMapping("/feedback")
public class FeedbackController extends BaseController {

	@Autowired
	HttpServletRequest request;// 请求

	@Autowired
	FeedbackService feedbackService;

	/**
	 * 
	 * <p>Title: getPageList</p>
	 * <p>Description: 获取反馈列表</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @return String
	 */
	@RequestMapping(value = "/getPageList", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getPageList(){
		return JSON.toJSONString(feedbackService.getPageList(DataTables.getInstance(request, null)));
	}
	
	/**
	 * 
	 * <p>Title: getFeedbackById</p>
	 * <p>Description: 获取反馈详情</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param id
	 * @return String
	 */
	@RequestMapping(value = "/getFeedbackById", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getFeedbackById(Integer id) {
		return JSONObject.toJSONString(feedbackService.getFeedbackById(id));
	}
	
	/**
	 * 
	 * <p>Title: save</p>
	 * <p>Description: 新增反馈</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param feedback
	 * @return String
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String addFeedback(@ModelAttribute Feedback feedback) {
		feedback.setCreateId(((Admin)request.getSession().getAttribute("admin")).getId());
		feedback.setCreateTime(new Date());
		feedback.setUpdateTime(new Date());
		feedback.setStatus(0);
		return JSON.toJSONString(feedbackService.addFeedback(feedback));
	}
	
	/**
	 * 
	 * <p>Title: updateFeedback</p>
	 * <p>Description: 更新反馈</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param feedback
	 * @return String
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String updateFeedback(@ModelAttribute Feedback feedback) {
		return JSONObject.toJSONString(feedbackService.updateFeedback(feedback));
	}
	
	/**
	 * 
	 * <p>Title: delFeedback</p>
	 * <p>Description: 删除反馈</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param idlist
	 * @return String
	 */
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String delFeedback(@RequestParam("idlist[]") List<Integer> idlist) {
		return JSONObject.toJSONString(feedbackService.delFeedback(idlist));
	}
}
