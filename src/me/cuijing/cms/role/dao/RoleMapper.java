package me.cuijing.cms.role.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import me.cuijing.cms.role.model.Role;

/**
 * <p>Title: RoleMapper</p>
 * <p>Description: 角色持久层</p>
 * <p>Company: </p> 
 * @author cui
 * @date 2017年3月12日
 */
@Repository
public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role role);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Role role);
    
	List<Role> getPageList(@Param("search") String search, @Param("subSQL") String subSQL);

	int deleteByPrimaryKeys(@Param("idlist")List<Integer> idlist);

	List<Role> selectAll();
}