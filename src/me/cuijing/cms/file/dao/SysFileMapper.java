package me.cuijing.cms.file.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import me.cuijing.cms.file.model.SysFile;

public interface SysFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysFile file);

    SysFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(SysFile file);

    /**
     * <p>Title: check</p>
     * <p>Description: 检测文件是否已经存在</p>
     * <p>Company: </p> 
     * @author cui
     * @date 2017年3月12日 
     * @param hash
     * @return SysFile
     */
	SysFile check(@Param("hash") String hash);

	/**
	 * <p>Title: getPageList</p>
	 * <p>Description: 分页返回文件记录</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param search
	 * @param subSQL
	 * @return List<SysFile>
	 */
	List<SysFile> getPageList(@Param("search") String search, @Param("subSQL") String subSQL);
}