package com.indra.cloud.rbac.vo;

import com.indra.cloud.common.vo.BaseVO;

import java.util.List;

/**
 * 角色VO
 *
 * @author FrozenWatermelon
 * @date 2020-09-17 19:15:44
 */
public class RoleVO extends BaseVO {
    private static final long serialVersionUID = 1L;

    /**角色id*/
    private Long roleId;

    /**角色名称*/
    private String roleName;

    /**备注*/
    private String remark;

    /**创建者ID*/
    private Long createUserId;

	/**所属租户id*/
	private Long tenantId;

	/**类型*/
	private Integer bizType;

	/**菜单id列表*/
	private List<Long> menuIds;

	/**菜单资源id列表*/
	private List<Long> menuPermissionIds;


	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public List<Long> getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(List<Long> menuIds) {
		this.menuIds = menuIds;
	}

	public List<Long> getMenuPermissionIds() {
		return menuPermissionIds;
	}

	public void setMenuPermissionIds(List<Long> menuPermissionIds) {
		this.menuPermissionIds = menuPermissionIds;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public Integer getBizType() {
		return bizType;
	}

	public void setBizType(Integer bizType) {
		this.bizType = bizType;
	}

	@Override
	public String toString() {
		return "RoleVO{" +
				"roleId=" + roleId +
				", roleName='" + roleName + '\'' +
				", remark='" + remark + '\'' +
				", createUserId=" + createUserId +
				", tenantId=" + tenantId +
				", bizType=" + bizType +
				", menuIds=" + menuIds +
				", menuPermissionIds=" + menuPermissionIds +
				"} " + super.toString();
	}
}
