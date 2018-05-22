package burst.modular.system.service;

import burst.modular.system.entity.UserInfo;
import com.baomidou.mybatisplus.service.IService;
import burst.core.model.RequestData;
import java.util.List;

/**
 * <p>
 * 人员信息表 服务类
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
public interface IUserInfoService extends IService<UserInfo> {

	

	//添加UserInfo
	public int add(RequestData requestData);
	//删除
	public int delete(RequestData requestData);
	//更新
	public void update(RequestData requestData);
	//查询
	public List<UserInfo> list(RequestData requestData);
}
