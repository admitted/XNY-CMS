package me.cuijing.cms.system.base;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * <p>Title: BaseController</p>
 * <p>Description: 控制器基类</p>
 * <p>Company: </p> 
 * @author cui
 * @date 2017年3月12日
 */
public abstract class BaseController {

	/**
	 * <p>Title: initBinder</p>
	 * <p>Description: 数据绑定重载</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param binder void
	 */
    @InitBinder    
    protected void initBinder(WebDataBinder binder) {
    	/**
    	 * 日期格式重载
    	 */
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	format.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));  
    }
}

