package com.indra.cloud.rbac.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 菜单管理DTO
 *
 * @author FrozenWatermelon
 * @date 2020-09-15 16:35:01
 */
@Data
public class MenuDTO {
    private static final long serialVersionUID = 1L;

    /**菜单id*/
    private Long menuId;

    @NotNull(message = "parentId NotNull")
    /**父菜单ID，一级菜单为0*/
    private Long parentId;

    /**权限，需要有哪个权限才能访问该菜单*/
    private String permission;

    /**路径 就像uri*/
    private String path;

	@NotBlank(message = "component NotBlank")
    /**组件如：1.'Layout' 为布局，不会跳页面 2.'components-demo/tinymce' 跳转到该页面*/
    private String component;

    /**当设置 true 的时候该路由不会在侧边栏出现 如401，login等页面，或者如一些编辑页面/edit/1*/
    private Integer hidden;

	@NotBlank(message = "name NotBlank")
    /**设定路由的名字，一定要填写不然使用<keep-alive>时会出现各种问题*/
    private String name;

	@NotBlank(message = "title NotBlank")
    /**设置该路由在侧边栏和面包屑中展示的名字*/
    private String title;

	/**系统类型*/
	private Integer sysType;

    /**设置该路由的图标，支持 svg-class，也支持 el-icon-x element-ui 的 icon*/
    private String icon;

    /**当路由设置了该属性，则会高亮相对应的侧边栏。*/
    private String activeMenu;

    /**排序，越小越靠前*/
    private Integer seq;

}
