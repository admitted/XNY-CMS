package me.cuijing.cms.folder.controller;

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
import me.cuijing.cms.folder.model.Folder;
import me.cuijing.cms.folder.service.FolderService;
import me.cuijing.cms.system.base.BaseController;
import me.cuijing.cms.system.util.DataTables;

/**
 * 
 * <p>Title: FolderController</p>
 * <p>Description: 栏目控制</p>
 * <p>Company: </p> 
 * @author cui
 * @date 2017年3月12日
 */
@Controller
@RequestMapping("/folder")
public class FolderController extends BaseController {

	@Autowired
	HttpServletRequest request;// 请求

	@Autowired
	FolderService folderService;

	/**
	 * 
	 * <p>Title: getPageList</p>
	 * <p>Description: 获取栏目列表</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @return String
	 */
	@RequestMapping(value = "/getPageList", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getPageList(){
		return JSON.toJSONString(folderService.getPageList(DataTables.getInstance(request, null)));
	}
	
	/**
	 * 
	 * <p>Title: save</p>
	 * <p>Description: 新增栏目</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param folder
	 * @return String
	 */
	@RequestMapping(value = "/addFolder", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String save(@ModelAttribute Folder folder) {
		folder.setCreateId(((Admin)request.getSession().getAttribute("admin")).getId());
		folder.setCreateTime(new Date());
		folder.setUpdateTime(new Date());
		return JSON.toJSONString(folderService.addFolder(folder));
	}
	
	/**
	 * <p>Title: updateFolder</p>
	 * <p>Description: 更新栏目</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param folder
	 * @return String
	 */
	@RequestMapping(value = "/updateFolder", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String updateFolder(@ModelAttribute Folder folder) {
		return JSONObject.toJSONString(folderService.updateFolder(folder));
	}
	
	/**
	 * <p>Title: delFolder</p>
	 * <p>Description: 删除栏目</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param idlist
	 * @return String
	 */
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String delFolder(@RequestParam("idlist[]") List<Integer> idlist) {
		return JSONObject.toJSONString(folderService.delFolder(idlist));
	}
	
	/**
	 * <p>Title: getAll</p>
	 * <p>Description: 获取所有的栏目(树)</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @return String
	 */
	@RequestMapping(value = "/selectAll", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectAll() {
		return JSON.toJSONString(folderService.selectAll());
	}
}
