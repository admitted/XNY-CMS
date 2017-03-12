package me.cuijing.cms.authorities.service;

import java.util.Map;

/**
 * <p>Title: AuthoritiesService</p>
 * <p>Description: 授权服务层</p>
 * <p>Company: </p> 
 * @author cui
 * @date 2017年3月12日
 */
public interface AuthoritiesService {

	/**
	 * <p>Title: grant</p>
	 * <p>Description: 给角色授权</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日
	 * @param id
	 * @param menuIds
	 * @return Map<String,Object>
	 */
	Map<String, Object> grant(Integer id, String menuIds);

}
