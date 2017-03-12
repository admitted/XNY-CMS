package me.cuijing.cms.authorities.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.cuijing.cms.authorities.dao.AuthoritiesMapper;
import me.cuijing.cms.authorities.service.AuthoritiesService;
import me.cuijing.cms.system.util.RequestStatus;
import me.cuijing.cms.system.util.StringUtil;

/**
 * 
 * @ClassName: AuthoritiesServiceImpl
 * @Description: 授权服务层实现类
 *
 * @author yangtao
 * @since 2016年10月28日 下午1:25:55
 *
 */
@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {

	@Autowired
	AuthoritiesMapper authoritiesMapper;

	@Override
	public Map<String, Object> grant(Integer roleId, String menuIds) {
		Map<String, Object> map = new HashMap<>();
		List<String> menuIdList = StringUtil.StringToList(menuIds, ",");
		authoritiesMapper.deleteByRole(roleId);
		if ((menuIdList != null && menuIdList.size() > 0) && authoritiesMapper.grant(roleId, menuIdList) > 0) {
			map.put("status", RequestStatus.SUCCESS);
		} else {
			map.put("status", RequestStatus.FAIL);
		}
		return map;
	}
}
