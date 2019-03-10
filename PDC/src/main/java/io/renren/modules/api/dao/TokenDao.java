package io.renren.modules.api.dao;

import io.renren.modules.api.entity.TokenEntity;
import io.renren.modules.sys.dao.BaseDao;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用户Token
 * 
 * @author yexing
 * @email 745235790@qq.com
 * @date 2017-03-23 15:22:07
 */
@Mapper
public interface TokenDao extends BaseDao<TokenEntity> {

	TokenEntity queryByUserId(Long userId);

	TokenEntity queryByToken(String token);

}
