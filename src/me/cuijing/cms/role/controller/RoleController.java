package me.cuijing.cms.role.controller;

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
import me.cuijing.cms.role.model.Role;
import me.cuijing.cms.role.service.RoleService;
import me.cuijing.cms.system.util.DataTables;

/**
 * <p>Title: RoleController</p>
 * <p>Description: 角色控制器</p>
 * <p>Company: </p> 
 * @author cui
 * @date 2017年3月12日
 */
@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	HttpServletRequest request;// 请求

	@Autowired
	RoleService roleService;

	/**
	 * <p>Title: getPageList</p>
	 * <p>Description: 获取角色列表</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @return String
	 */
	@RequestMapping(value = "/getPageList", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getPageList() {
		return JSONObject.toJSONString(roleService.getPageList(DataTables.getInstance(request, null)));
	}
	
	/**
	 * <p>Title: getRoleById</p>
	 * <p>Description: 获取角色详情</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param id
	 * @return String
	 */
	@RequestMapping(value = "/getRoleById", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getRoleById(Integer id) {
		return JSONObject.toJSONString(roleService.getRoleById(id));
	}
	

	/**
	 * <p>Title: addRole</p>
	 * <p>Description: 添加角色</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param role
	 * @param menuIds
	 * @return String
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String addRole(@ModelAttribute Role role, @RequestParam("menuIds") String menuIds) {
		role.setCreateId(((Admin)request.getSession().getAttribute("admin")).getId());
		role.setCreateTime(new Date());
		role.setUpdateTime(new Date());
		return JSONObject.toJSONString(roleService.addRole(role, menuIds));
	}
	
	/**
	 * <p>Title: updateRole</p>
	 * <p>Description: 更新角色</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param role
	 * @param menuIds
	 * @return String
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String updateRole(@ModelAttribute Role role, @RequestParam("menuIds") String menuIds) {
		return JSONObject.toJSONString(roleService.updateRole(role, menuIds));
	}
	
	/**
	 * <p>Title: delRole</p>
	 * <p>Description: 删除角色</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param idlist
	 * @return String
	 */
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String delRole(@RequestParam("idlist[]") List<Integer> idlist) {
		return JSONObject.toJSONString(roleService.delRole(idlist));
	}
	
	/**
	 * <p>Title: selectAll</p>
	 * <p>Description: 查询出所有的角色</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @return String
	 */
	@RequestMapping(value = "/selectAll", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectAll() {
		return JSONObject.toJSONString(roleService.selectAll());
	}
}
