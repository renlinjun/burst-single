package burst.modular.system.service.impl;

import burst.modular.system.entity.UserInfo;
import burst.modular.system.mapper.UserInfoMapper;
import burst.modular.system.service.IUserInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import burst.core.model.RequestData;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-16
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {
	
	@Autowired
	private UserInfoMapper userInfoMapper; 
	
	//添加UserInfo
	public void add(RequestData data) {};
	//删除
	public void delete(RequestData data) {};
	//更新
	public void update(RequestData data) {};
	//查询
	public List<UserInfo> list(RequestData data) {
		return null;
	};
}
