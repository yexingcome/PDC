package io.renren.modules.sys.dao;

import io.renren.modules.sys.entity.SysRoleEntity;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 角色管理
 * 
 * @author yexing
 * @email 745235790@qq.com
 * @date 2016年9月18日 上午9:33:33
 */
@Mapper
public interface SysRoleDao extends BaseDao<SysRoleEntity> {

	/**
	 * 查询用户创建的角色ID列表
	 */
	List<Long> queryRoleIdList(Long createUserId);
}
