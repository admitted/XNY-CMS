package me.cuijing.cms.system.base;

import java.util.List;

import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseService {

	Logger logger = LoggerFactory.getLogger(BaseService.class);

	@Autowired
	SqlSessionFactory sessionFactory; // myBatis核心工厂

	/**
	 * <p>Title: propertyToColumn</p>
	 * <p>Description: property转Column</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param clazz
	 * @param property
	 * @return String
	 */
	@SuppressWarnings("rawtypes")
	public String propertyToColumn(Class clazz, String property) {
		if (property == null || property.equals("")) {
			return null;
		}
		
		String resultMapId = clazz.getName() + ".BaseResultMap";
		
		ResultMap resultMap = sessionFactory.getConfiguration().getResultMap(resultMapId);
		if (null == resultMap) {
			logger.error("resultMap 对象为空");
			return null;
		}

		List<ResultMapping> resultMappings = resultMap.getResultMappings();

		if (null == resultMappings) {
			logger.error("resultMappings 对象为空");
			return null;
		}

		Object[] resultMapping = resultMappings.stream().filter(map -> property.equals(map.getProperty())).map(ResultMapping::getColumn).toArray();

		if (resultMapping.length < 1) {
			return null;
		} else {
			return resultMapping[0].toString();
		}
	}
}
