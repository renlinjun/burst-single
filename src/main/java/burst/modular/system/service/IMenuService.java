package burst.modular.system.service;

import burst.modular.system.entity.Menu;
import com.baomidou.mybatisplus.service.IService;
import burst.core.model.RequestData;
import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
public interface IMenuService extends IService<Menu> {

	

	//添加Menu
	public int add(RequestData requestData);
	//删除
	public void delete(RequestData requestData);
	//更新
	public void update(RequestData requestData);
	//查询
	public List<Menu> list(RequestData requestData);
}
