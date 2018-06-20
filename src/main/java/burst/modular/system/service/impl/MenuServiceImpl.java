package burst.modular.system.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import burst.core.model.RequestData;
import burst.modular.system.entity.Menu;
import burst.modular.system.mapper.MenuMapper;
import burst.modular.system.service.IMenuService;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {
	
	
	//添加Menu
	public int add(RequestData requestData) {
		Menu meun = requestData.parseObj(Menu.class);
		int result = baseMapper.insert(meun);
		return result;
	};
	//删除
	public void delete(RequestData requestData) {};
	//更新
	public void update(RequestData requestData) {};
	//查询
	public List<Menu> list(RequestData requestData) {
		return null;
	}
}
