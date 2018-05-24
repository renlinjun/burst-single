package burst.modular.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import burst.core.config.ResultConstants;
import burst.core.model.RequestData;
import burst.core.model.ResponseData;
import burst.modular.system.entity.PermissionMenu;
import burst.modular.system.mapper.PermissionMenuMapper;
import burst.modular.system.service.IPermissionMenuService;

/**
 * <p>
 * 权限菜单表 服务实现类
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
@Service
public class PermissionMenuServiceImpl extends ServiceImpl<PermissionMenuMapper, PermissionMenu> implements IPermissionMenuService {
	
	
	public ResponseData assignMenu(RequestData requestData) {
		JSONObject data = requestData.getData();
		
		String permissionId = data.getString("permissionId");
		String menuIdStr = data.getString("menuIds");
		
		String[] menuIds = menuIdStr.split(",");
		
		List<PermissionMenu> permissionMenus = new ArrayList<PermissionMenu>();
		
		for(int i=0;i<menuIds.length;i++) {
			PermissionMenu permissionMenu = new PermissionMenu();
			permissionMenu.setMenuId(menuIds[i]);
			permissionMenu.setPermissionId(permissionId);
			permissionMenus.add(permissionMenu);
		}

		try {
			baseMapper.assignMenu(permissionMenus);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseData(ResultConstants.OPT_FAIL,"添加失败");
		}
		return new ResponseData(ResultConstants.SUCCESS_RESPONSE);
		
	}
	//删除
	public void delete(RequestData requestData) {}
	//更新
	public void update(RequestData requestData) {}
	//查询
	public List<PermissionMenu> list(RequestData requestData) {
		return null;
	};
}
