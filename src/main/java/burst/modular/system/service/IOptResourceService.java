package burst.modular.system.service;

import com.baomidou.mybatisplus.service.IService;

import burst.core.model.RequestData;
import burst.core.model.ResponseData;
import burst.modular.system.entity.OptResource;

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
	/**
	 * 查询资源列表
	 * @param requestData
	 * @return
	 */
	public ResponseData list(RequestData requestData);
}
