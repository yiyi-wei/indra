package com.indra.cloud.user.mapper;

import com.indra.cloud.api.user.vo.UserApiVO;
import com.indra.cloud.user.model.User;
import com.indra.cloud.user.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 皮卡皮
* @description 针对表【user(用户表)】的数据库操作Mapper
* @createDate 2023-03-20 10:24:10
* @Entity com.indra.cloud.user.model.User
*/
@Mapper
public interface UserMapper {

    /**
     * 获取用户表列表
     *
     * @return 用户表列表
     */
    List<UserVO> list();

    /**
     * 根据用户表id获取用户表
     *
     * @param userId 用户表id
     * @return 用户表
     */
    UserApiVO getByUserId(@Param("userId") Long userId);

    /**
     * 保存用户表
     *
     * @param user 用户表
     */
    Integer save(@Param("user") User user);

    /**
     * 更新用户表
     *
     * @param user 用户表
     */
    void update(@Param("user") User user);

    /**
     * 根据用户id列表，获取用户信息
     *
     * @param userIds
     * @return
     */
    List<UserApiVO> getUserByUserIds(@Param("userIds") List<Long> userIds);

    /**
     * 根据用户id获取用户详细信息
     * @param userId 用户id
     * @return 用户详细信息
     */
    UserApiVO getUserAndOpenIdsByUserId(@Param("userId") Long userId);


    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}
