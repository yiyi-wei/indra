package com.indra.cloud.rbac.controller;

import com.indra.cloud.api.auth.bo.UserInfoInTokenBO;
import com.indra.cloud.common.database.dto.PageDTO;
import com.indra.cloud.common.database.vo.PageVO;
import com.indra.cloud.common.response.ServerResponseEntity;
import com.indra.cloud.common.security.AuthUserContext;
import com.indra.cloud.common.utils.BooleanUtil;
import com.indra.cloud.rbac.dto.MenuPermissionDTO;
import com.indra.cloud.rbac.model.MenuPermission;
import com.indra.cloud.rbac.service.MenuPermissionService;
import com.indra.cloud.rbac.vo.MenuPermissionVO;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * "权限接口"
 * @author FrozenWatermelon
 * @date 2020/09/02
 */
@RequestMapping(value = "/menu_permission")
public class MenuPermissionController {

	@Autowired
	private MenuPermissionService menuPermissionService;

	@Autowired
	private MapperFacade mapperFacade;

	/**
	 * "获取菜单资源列表", notes = "分页获取菜单资源列表"
	 * @param menuId
	 * @return
	 */
	@GetMapping("/list_by_menu")
	public ServerResponseEntity<List<MenuPermissionVO>> listByMenuId(Long menuId) {
		List<MenuPermissionVO> menuPermissionVOList = menuPermissionService.listByMenuId(menuId);
		return ServerResponseEntity.success(menuPermissionVOList);
	}

	/**
	 * value = "获取菜单资源", notes = "根据menuPermissionId获取菜单资源"
	 * @param menuPermissionId
	 * @return
	 */
	@GetMapping
	public ServerResponseEntity<MenuPermissionVO> getByMenuPermissionId(@RequestParam Long menuPermissionId) {
		return ServerResponseEntity.success(menuPermissionService.getByMenuPermissionId(menuPermissionId));
	}

	/**
	 * value = "保存菜单资源", notes = "保存菜单资源"
	 * @param menuPermissionDTO
	 * @return
	 */
	@PostMapping
	public ServerResponseEntity<Void> save(@Valid @RequestBody MenuPermissionDTO menuPermissionDTO) {
		MenuPermission menuPermission = mapperFacade.map(menuPermissionDTO, MenuPermission.class);
		UserInfoInTokenBO userInfoInTokenBO = AuthUserContext.get();
		menuPermission.setMenuPermissionId(null);
		menuPermission.setBizType(userInfoInTokenBO.getSysType());
		return menuPermissionService.save(menuPermission);
	}

	/**
	 * value = "更新菜单资源", notes = "更新菜单资源"
	 * @param menuPermissionDTO
	 * @return
	 */

	@PutMapping
	public ServerResponseEntity<Void> update(@Valid @RequestBody MenuPermissionDTO menuPermissionDTO) {
		MenuPermission menuPermission = mapperFacade.map(menuPermissionDTO, MenuPermission.class);
		UserInfoInTokenBO userInfoInTokenBO = AuthUserContext.get();
		menuPermission.setBizType(userInfoInTokenBO.getSysType());
		return menuPermissionService.update(menuPermission);
	}

	/**
	 * "删除菜单资源", notes = "根据菜单资源id删除菜单资源"
	 * @param menuPermissionId
	 * @return
	 */
	@DeleteMapping
	public ServerResponseEntity<Void> delete(@RequestParam Long menuPermissionId) {
		UserInfoInTokenBO userInfoInTokenBO = AuthUserContext.get();
		menuPermissionService.deleteById(menuPermissionId,userInfoInTokenBO.getSysType());
		return ServerResponseEntity.success();
	}

	/**
	 * "获取当前用户拥有的权限", notes = "当前用户所拥有的所有权限，精确到按钮，实际上element admin里面的roles就可以理解成权限"
	 * @return
	 */

	@GetMapping(value = "/list")
	public ServerResponseEntity<List<String>> permissions() {
		UserInfoInTokenBO userInfoInTokenBO = AuthUserContext.get();
		return ServerResponseEntity.success(menuPermissionService.listUserPermissions(userInfoInTokenBO.getUserId(),
				userInfoInTokenBO.getSysType(), BooleanUtil.isTrue(userInfoInTokenBO.getIsAdmin())));
	}

	/**
	 * "获取当前用户拥有的权限", notes = "当前用户所拥有的所有权限，精确到按钮，实际上element admin里面的roles就可以理解成权限"
	 * @param pageDTO
	 * @return
	 */
	@GetMapping(value = "/page")
	public ServerResponseEntity<PageVO<MenuPermissionVO>> pagePermissions(PageDTO pageDTO) {
		UserInfoInTokenBO userInfoInTokenBO = AuthUserContext.get();
		PageVO<MenuPermissionVO> permissionPage = menuPermissionService.page(pageDTO, userInfoInTokenBO.getSysType());
		return ServerResponseEntity.success(permissionPage);
	}

}
