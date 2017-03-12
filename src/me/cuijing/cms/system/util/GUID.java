package me.cuijing.cms.system.util;

import java.util.UUID;

/**
 * <p>Title: GUID</p>
 * <p>Description: 生成UUIDkey</p>
 * <p>Company: </p> 
 * @author cui
 * @date 2017年3月12日
 */
public class GUID {
	public static String getGuid(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
