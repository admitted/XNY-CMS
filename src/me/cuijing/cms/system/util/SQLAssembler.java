package me.cuijing.cms.system.util;

import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

/**
 * <p>Title: SQLAssembler</p>
 * <p>Description: SQL不固定column组装器</p>
 * <p>Company: </p> 
 * @author cui
 * @date 2017年3月12日
 */
public class SQLAssembler{
	
	/**
	 * C:column
	 * V:valu{V:single_value, VI:min_value, VA:max_value}
	 * T:type{S:String, L:like, CA:compare bigger than V, CI:compare smaller than V, CB:compare between VI and VA}
	 * 
	 * <p>Title: handler</p>
	 * <p>Description: SQL不固定column组装器</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param subParamList
	 * @return String
	 */
	public static String handler(List<Map<String, String>> subParamList) {
		String subSQL = "";
		for (Map<String, String> map : subParamList) {
			subSQL = StringUtils.isEmpty(subSQL) ? "" : subSQL + " and ";
			switch (map.get("T")) {
			case "S":
				subSQL += map.get("C") + " = '" + map.get("V") + "'";
				break;
			case "L":
				subSQL += "INSTR(ifnull(" + map.get("C") + ",''),'" + map.get("V") + "') > 0";
				break;
			case "CA":
				subSQL += map.get("C") + " > '" + map.get("V") + "'";
				break;
			case "CI":
				subSQL += map.get("C") + " < '" + map.get("V") + "'";
				break;
			case "CB":
				subSQL += map.get("C") + " > '" + map.get("VI") + "' and " + map.get("C") + " < '" + map.get("VA") + "'";
				break;
			}
		}
		return subSQL;
	}
}
