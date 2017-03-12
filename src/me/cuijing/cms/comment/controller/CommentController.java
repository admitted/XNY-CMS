package me.cuijing.cms.comment.controller;

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
import me.cuijing.cms.comment.model.Comment;
import me.cuijing.cms.comment.service.CommentService;
import me.cuijing.cms.system.base.BaseController;
import me.cuijing.cms.system.util.DataTables;

/**
 * <p>Title: CommentController</p>
 * <p>Description: 评论控制</p>
 * <p>Company: </p> 
 * @author cui
 * @date 2017年3月12日 
 */
@Controller
@RequestMapping("/comment")
public class CommentController extends BaseController {

	@Autowired
	HttpServletRequest request;// 请求

	@Autowired
	CommentService commentService;

	/**
	 * <p>Title: getPageList</p>
	 * <p>Description: 获取评论列表</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @return String
	 */
	@RequestMapping(value = "/getPageList", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getPageList(){
		return JSON.toJSONString(commentService.getPageList(DataTables.getInstance(request, null)));
	}
	
	/**
	 * <p>Title: save</p>
	 * <p>Description: 新增评论</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param comment
	 * @return String
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String addComment(@ModelAttribute Comment comment) {
		comment.setCreateId(((Admin)request.getSession().getAttribute("admin")).getId());
		comment.setCreateTime(new Date());
		comment.setUpdateTime(new Date());
		comment.setStatus(0);
		return JSON.toJSONString(commentService.addComment(comment));
	}
	
	/**
	 * <p>Title: updateComment</p>
	 * <p>Description: 更新评论</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param comment
	 * @return String
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String updateComment(@ModelAttribute Comment comment) {
		return JSONObject.toJSONString(commentService.updateComment(comment));
	}
	
	/**
	 * <p>Title: delComment</p>
	 * <p>Description: 删除评论</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param idlist
	 * @return String
	 */
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String delComment(@RequestParam("idlist[]") List<Integer> idlist) {
		return JSONObject.toJSONString(commentService.delComment(idlist));
	}
}
