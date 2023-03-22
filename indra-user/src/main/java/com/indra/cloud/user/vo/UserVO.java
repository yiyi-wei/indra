package com.indra.cloud.user.vo;

import com.indra.cloud.common.vo.BaseVO;
import lombok.Data;

import java.util.List;

/**
 * 用户表VO
 *
 * @author YXF
 * @date 2020-12-08 11:18:04
 */
@Data
public class UserVO extends BaseVO {
    private static final long serialVersionUID = 1L;

    /**ID*/
    private Long userId;

    /**用户昵称*/
    private String nickName;

    /**头像图片路径*/
    private String pic;

    /**状态 1 正常 0 无效*/
    private Integer status;

	/**
	 * openId list
	 */
	private List<String> bizUserIdList;

    /**
     * 粉丝列表
     */
    private List<UserVO> fansList;

}
