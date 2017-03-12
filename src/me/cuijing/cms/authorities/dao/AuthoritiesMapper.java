package me.cuijing.cms.authorities.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import me.cuijing.cms.authorities.model.Authorities;

/**
 * <p>Title: AuthoritiesMapper</p>
 * <p>Description: 权限管理持久层</p>
 * <p>Company: </p> 
 * @author cui
 * @date 2017年3月12日
 */
@Repository
public interface AuthoritiesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Authorities record);

    Authorities selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Authorities record);

    /**
     * <p>Title: grant</p>
     * <p>Description: 给角色授权</p>
     * <p>Company: </p> 
     * @author cui
     * @date 2017年3月12日
     * @param roleId
     * @param menuIdList
     * @return int
     */
	int grant(@Param("roleId") Integer roleId, @Param("menuIdList") List<String> menuIdList);
	
	/**
	 * <p>Title: deleteByRole</p>
	 * <p>Description: 删除已有的授权</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日
	 * @param roleId
	 * @return int
	 */
	int deleteByRole(@Param("roleId") Integer roleId);
}