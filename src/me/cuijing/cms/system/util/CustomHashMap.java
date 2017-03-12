package me.cuijing.cms.system.util;

import java.util.HashMap;

/**
 * <p>Title: CustomHashMap</p>
 * <p>Description: 自定义hashMap</p>
 * <p>Company: </p> 
 * @author cui
 * @date 2017年3月12日
 */
public class CustomHashMap extends HashMap<String, Object> {

	private static final long serialVersionUID = -2968772844807564411L;

	@Override
	public CustomHashMap put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}