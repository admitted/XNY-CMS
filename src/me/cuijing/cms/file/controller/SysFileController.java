package me.cuijing.cms.file.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import me.cuijing.cms.admin.model.Admin;
import me.cuijing.cms.file.service.FileService;
import me.cuijing.cms.system.base.BaseController;
import me.cuijing.cms.system.util.DataTables;

/**
 * <p>Title: SysFileController</p>
 * <p>Description: 文件控制层</p>
 * <p>Company: </p> 
 * @author cui
 * @date 2017年3月12日
 */
@Controller
@RequestMapping("/file")
public class SysFileController extends BaseController {

	@Autowired
	FileService fileService;

	@Autowired
	HttpServletRequest request;

	/**
	 * <p>Title: fileUpload</p>
	 * <p>Description: web-uploader文件上传后台接收端</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param files
	 * @return String
	 */
	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String fileUpload(@RequestParam("upfile") MultipartFile files) {
		String hash = request.getParameter("hash");
		String ok = request.getParameter("ok");
		Integer adminId = ((Admin) request.getSession().getAttribute("admin")).getId();
		return JSON.toJSONString(fileService.fileUpload(files, hash, adminId, ok));
	}

	/**
	 * <p>Title: getfilebymd5</p>
	 * <p>Description: 检测文件是否上传过</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @return String
	 */
	@RequestMapping(value = "/fileUpload/check", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String checkFileIsUploaded() {
		String hash = request.getParameter("hash");
		String fileName = request.getParameter("fileName");
		return JSON.toJSONString(fileService.check(hash, ((Admin) request.getSession().getAttribute("admin")).getId(), fileName));
	}

	/**
	 * 
	 * <p>Title: fileDownload</p>
	 * <p>Description: 下载</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param fileGuid
	 * @param response
	 * @return String
	 */
	@RequestMapping("/download")
	@ResponseBody
	public String fileDownload(@RequestParam String fileGuid, HttpServletResponse response) {
		return fileService.fileDownload(fileGuid, response);
	}
	
	/**
	 * 
	 * <p>Title: getPageList</p>
	 * <p>Description: 分页获取文件列表</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @return String
	 */
	@RequestMapping(value = "/getPageList", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getPageList() {
		String subSQL = null;
		if (!StringUtils.isEmpty(request.getParameter("fType"))) {
			subSQL = "f_type = " + request.getParameter("fType");
		}
		if (!StringUtils.isEmpty(request.getParameter("timeMax"))) {
			subSQL = StringUtils.isEmpty(subSQL) ? "" : subSQL + " and ";
			subSQL += "f_time > '" + request.getParameter("timeMin") + "' and f_time < '" + request.getParameter("timeMax") + "'";
		}
		
		return JSON.toJSONString(fileService.getPageList(DataTables.getInstance(request, subSQL)));
	}
}
