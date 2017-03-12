package me.cuijing.cms.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import me.cuijing.cms.admin.model.Admin;
import me.cuijing.cms.menu.model.Menu;

/** 
 * 用户持久层
 * <p>Title: AdminMapper</p>
 * <p>Description: </p>
 * <p>Company: </p> 
 * @author cui
 * @date 2017年3月11日 
 */
@Repository
public interface AdminMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Admin user);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Admin user);
    

    /**
     * <p>Title: login</p>
     * <p>Description: 用户登录</p>
     * <p>Company: </p> 
     * @author cui
     * @date 2017年3月11日 
     * @param username
     * @param password
     * @return Admin
     */
    Admin login(@Param("username")String username, @Param("password")String password);


    /** 
     * <p>Title: getPageList </p>
     * <p>Description: 分页获取管理员列表 </p>
     * <p>Company: </p> 
     * @author cui
     * @date 2017年3月11日 
     * @param search
     * @param subSQL
     * @return List<Menu>
     */
    List<Menu> getPageList(@Param("search") String search, @Param("subSQL") String subSQL);
}