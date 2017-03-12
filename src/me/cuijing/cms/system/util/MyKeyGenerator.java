package me.cuijing.cms.system.util;

import java.lang.reflect.Method;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKey;

/**
 * <p>Title: MyKeyGenerator</p>
 * <p>Description: 自定义缓存Key生成器(方法名加参数的方式)</p>
 * <p>Company: </p> 
 * @author cui
 * @date 2017年3月12日
 */
public class MyKeyGenerator implements KeyGenerator {

	@Override
	public Object generate(Object object, Method method, Object... params) {
		Object[] objects = new Object[params.length+1];
		objects[0] = method.getName();
		
		for (int i=0;i<params.length;i++) {
			objects[i+1] = params[i];
		}
		return new SimpleKey(objects);
	}
}
