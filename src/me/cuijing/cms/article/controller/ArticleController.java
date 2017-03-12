package me.cuijing.cms.article.controller;

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
import me.cuijing.cms.article.model.Article;
import me.cuijing.cms.article.service.ArticleService;
import me.cuijing.cms.system.base.BaseController;
import me.cuijing.cms.system.util.DataTables;

/**
 * <p>Title: ArticleController</p>
 * <p>Description: 文章控制</p>
 * <p>Company: </p> 
 * @author cui
 * @date 2017年3月12日 
 */
@Controller
@RequestMapping("/article")
public class ArticleController extends BaseController {

	@Autowired
	HttpServletRequest request;// 请求

	@Autowired
	ArticleService articleService;


	/**
	 * <p>Title: getPageList</p>
	 * <p>Description: 获取文章列表</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @return String
	 */
	@RequestMapping(value = "/getPageList", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getPageList(){
		return JSON.toJSONString(articleService.getPageList(DataTables.getInstance(request, null)));
	}
	
	/**
	 * <p>Title: getArticle</p>
	 * <p>Description: 获取文章</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param id
	 * @return String
	 */
	@RequestMapping(value = "/getArticle", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getArticle(int id){
		return JSON.toJSONString(articleService.getArticle(id));
	}
	
	/**
	 * <p>Title: save</p>
	 * <p>Description: 新增文章</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param article
	 * @return String
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String addArticle(@ModelAttribute Article article) {
		article.setCreateId(((Admin)request.getSession().getAttribute("admin")).getId());
		article.setCreateTime(new Date());
		article.setUpdateTime(new Date());
		article.setStatus(0);
		return JSON.toJSONString(articleService.addArticle(article));
	}
	
	/**
	 * <p>Title: updateArticle</p>
	 * <p>Description: 更新文章</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param article
	 * @return String
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String updateArticle(@ModelAttribute Article article) {
		return JSONObject.toJSONString(articleService.updateArticle(article));
	}
	
	/**
	 * <p>Title: delArticle</p>
	 * <p>Description: 删除文章</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param idlist
	 * @return String
	 */
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String delArticle(@RequestParam("idlist[]") List<Integer> idlist) {
		return JSONObject.toJSONString(articleService.delArticle(idlist));
	}
}
