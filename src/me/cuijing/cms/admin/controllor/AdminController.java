package me.cuijing.cms.admin.controllor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import me.cuijing.cms.admin.model.Admin;
import me.cuijing.cms.admin.service.AdminService;
import me.cuijing.cms.system.base.BaseController;
import me.cuijing.cms.system.util.ConstantUtil;
import me.cuijing.cms.system.util.DataTables;
import me.cuijing.cms.system.util.GeneratorValidateCode;

/**
 * <p>Title: AdminController</p>
 * <p>Description: 用户控制</p>
 * <p>Company: </p> 
 * @author cui
 * @date 2017年3月11日 下午11:08:59
 */
 
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

	@Autowired
	HttpServletRequest request;  // 请求

	@Autowired
	AdminService adminService;
	
	/**
	 * <p>Title: login </p>
	 * <p>Description: 用户登录</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月11日 
	 * @param username
	 * @param password
	 * @param ValidateCode
	 * @return String
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String login(String username, String password, String ValidateCode) {
		if (!(ValidateCode != null && ValidateCode.equals(request.getSession().getAttribute("ValidateCode")))) {
			return "false_ValidateCode";
		}
		Admin admin = adminService.login(username, password); //查看有无此人
		if (admin != null) {
			request.getSession().setAttribute("admin", admin);
			request.getSession().setAttribute("IMGDOMAIN", ConstantUtil.IMGDOMAIN);
			return "success";
		}
		return "false";
	}


	/**
	 * <p>Title: getValidateCode </p>
	 * <p>Description: 生成验证码图片</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月11日 
	 * @param response
	 * @return String
	 */
	@RequestMapping(value = "/getValidateCode", method = RequestMethod.GET)
	@ResponseBody
	public String getValidateCode(HttpServletResponse response) {
		// 设置响应的类型格式为图片格式
		response.setContentType("image/jpeg");
		// 禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		GeneratorValidateCode instance = new GeneratorValidateCode();

//		request.getSession().setAttribute("ValidateCode", instance.getCode());
		request.getSession().setAttribute("ValidateCode", "1234");

		try {
			instance.write(response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * <p>Title: getPageList </p>
	 * <p>Description: 分页获取管理员列表</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月11日 
	 * @return String
	 */
	@RequestMapping(value = "/getPageList", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getPageList() {
		return JSONObject.toJSONString(adminService.getPageList(DataTables.getInstance(request, null)));
	}

}
