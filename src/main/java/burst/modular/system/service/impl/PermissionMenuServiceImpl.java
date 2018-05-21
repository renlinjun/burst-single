package burst.modular.system.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import burst.core.model.RequestData;
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
	
	
	//添加PermissionMenu
	public void add(RequestData requestData) {};
	//删除
	public void delete(RequestData requestData) {};
	//更新
	public void update(RequestData requestData) {};
	//查询
	public List<PermissionMenu> list(RequestData requestData) {
		return null;
	};
}
