package burst.modular.system.service;

import burst.modular.system.entity.UserInfo;
import com.baomidou.mybatisplus.service.IService;
import burst.core.model.RequestData;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-16
 */
@Service
public interface IUserInfoService extends IService<UserInfo> {

	

	//添加UserInfo
	public void add(RequestData requestData);
	//删除
	public void delete(RequestData requestData);
	//更新
	public void update(RequestData requestData);
	//查询
	public List<UserInfo> list(RequestData requestData);
}
