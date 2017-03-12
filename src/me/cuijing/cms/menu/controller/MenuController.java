package me.cuijing.cms.menu.controller;

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

import com.alibaba.fastjson.JSONObject;
import me.cuijing.cms.admin.model.Admin;
import me.cuijing.cms.menu.model.Menu;
import me.cuijing.cms.menu.service.MenuService;
import me.cuijing.cms.system.base.BaseController;
import me.cuijing.cms.system.util.DataTables;

/**
 * <p>Title: MenuController</p>
 * <p>Description: 菜单控制</p>
 * <p>Company: </p> 
 * @author cui
 * @date 2017年3月12日
 */
@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {

	@Autowired
	HttpServletRequest request;// 请求

	@Autowired
	MenuService menuService;

	/**
	 * <p>Title: getPageList</p>
	 * <p>Description: 获取菜单列表</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @return String
	 */
	@RequestMapping(value = "/getPageList", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getPageList() {
		return JSONObject.toJSONString(menuService.getPageList(DataTables.getInstance(request, null)));
	}
	
	/**
	 * <p>Title: getMenuById</p>
	 * <p>Description: 获取菜单详情</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param id
	 * @return String
	 */
	@RequestMapping(value = "/getMenuById", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getMenuById(Integer id) {
		return JSONObject.toJSONString(menuService.getMenuById(id));
	}

	/**
	 * <p>Title: addMenu</p>
	 * <p>Description: 添加菜单</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param menu
	 * @return String
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String addMenu(@ModelAttribute Menu menu) {
		menu.setCreateId(((Admin)request.getSession().getAttribute("admin")).getId());
		menu.setCreateTime(new Date());
		menu.setUpdateTime(new Date());
		return JSONObject.toJSONString(menuService.addMenu(menu));
	}
	
	/**
	 * <p>Title: updateMenu</p>
	 * <p>Description: 更新菜单</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param menu
	 * @return String
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String updateMenu(@ModelAttribute Menu menu) {
		return JSONObject.toJSONString(menuService.updateMenu(menu));
	}
	
	/**
	 * 删除菜单
	 * 
	 * @author yangtao
	 * @since 2016年8月12日 下午8:42:07
	 * @param idlist
	 * @return
	 */
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String delMenu(@RequestParam("idlist[]") List<Integer> idlist) {
		return JSONObject.toJSONString(menuService.delMenu(idlist));
	}
	
	/**
	 * 获取所有的菜单数据
	 * 
	 * @author yangtao
	 * @since 2016年9月20日 下午9:26:32
	 * @return
	 */
	@RequestMapping(value = "/selectAll", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectAll() {
		return JSONObject.toJSONString(menuService.selectAll());
	}
}
