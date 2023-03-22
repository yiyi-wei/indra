package com.indra.cloud.user.mapper;

import com.indra.cloud.user.model.UserAddr;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 皮卡皮
* @description 针对表【user_addr(用户地址)】的数据库操作Mapper
* @createDate 2023-03-20 10:24:10
* @Entity com.indra.cloud.user.model.UserAddr
*/
@Mapper
public interface UserAddrMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UserAddr record);

    int insertSelective(UserAddr record);

    UserAddr selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserAddr record);

    int updateByPrimaryKey(UserAddr record);

}
