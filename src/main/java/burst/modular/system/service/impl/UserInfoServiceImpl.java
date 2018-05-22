package burst.modular.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import burst.core.model.RequestData;
import burst.modular.system.entity.UserInfo;
import burst.modular.system.mapper.AccountMapper;
import burst.modular.system.mapper.UserInfoMapper;
import burst.modular.system.service.IUserInfoService;

/**
 * <p>
 * 人员信息表 服务实现类
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {
	
	@Autowired
	private AccountMapper accountMapper;
	
	//添加UserInfo
	public void add(RequestData requestData) {
		UserInfo userInfo = requestData.parseObj(UserInfo.class);
		baseMapper.insert(userInfo);
	};
	//删除
	public void delete(RequestData requestData) {};
	//更新
	public void update(RequestData requestData) {};
	//查询
	public List<UserInfo> list(RequestData requestData) {
		return null;
	};
}
