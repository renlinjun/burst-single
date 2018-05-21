package burst.modular.system.service;

import burst.modular.system.entity.OptResource;
import com.baomidou.mybatisplus.service.IService;
import burst.core.model.RequestData;
import java.util.List;

/**
 * <p>
 * 功能操作资源表 服务类
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
public interface IOptResourceService extends IService<OptResource> {

	

	//添加OptResource
	public void add(RequestData requestData);
	//删除
	public void delete(RequestData requestData);
	//更新
	public void update(RequestData requestData);
	//查询
	public List<OptResource> list(RequestData requestData);
}
