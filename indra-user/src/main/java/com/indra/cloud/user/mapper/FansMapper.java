package com.indra.cloud.user.mapper;

import com.indra.cloud.user.model.Fans;
import com.indra.cloud.user.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 皮卡皮
* @description 针对表【fans(粉丝表)】的数据库操作Mapper
* @createDate 2023-03-20 10:24:10
* @Entity com.indra.cloud.user.model.Fans
*/
@Mapper
public interface FansMapper {

    /**
     * 通过userId查询粉丝
     * @param userId userid
     * @return 粉丝列表
     */
    UserVO selectFansByUserId(Long userId);

    /**
     * 保存一个粉丝关系
     * @param fans fans实体
     * @return 影响的数据库行数
     */
    Integer save(Fans fans);
}
