package me.cuijing.cms.file.service;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import me.cuijing.cms.system.util.DataTables;

/**
 * <p>Title: FileService</p>
 * <p>Description: 文件服务</p>
 * <p>Company: </p> 
 * @author cui
 * @date 2017年3月12日
 */
public interface FileService {
	
	/**
	 * <p>Title: fileDownload</p>
	 * <p>Description: 下载文件</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param guid
	 * @param response
	 * @return String
	 */
	String fileDownload(String guid, HttpServletResponse response);

	/**
	 * <p>Title: getPageList</p>
	 * <p>Description: 获取文件列表</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param dataTables
	 * @return DataTables
	 */
	DataTables getPageList(DataTables dataTables);

	/**
	 * <p>Title: check</p>
	 * <p>Description: 检测文件是否上传过</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param hash
	 * @param userId
	 * @param fileName
	 * @return Map<String,Object>
	 */
	Map<String, Object> check(String hash, Integer userId, String fileName);
	
	/**
	 * <p>Title: fileUpload</p>
	 * <p>Description: web-uploader上传文件</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param files
	 * @param hash
	 * @param userId
	 * @param ok
	 * @return Map<String,Object>
	 */
	Map<String, Object> fileUpload(MultipartFile files, String hash, Integer userId, String ok);
	
	/**
	 * 
	 * <p>Title: simpleupload</p>
	 * <p>Description: Ueditor图片上传</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param file
	 * @param userId
	 * @return Map<String,Object>
	 */
	Map<String, Object> simpleupload(MultipartFile file, Integer userId);
}