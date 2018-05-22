package burst.modular.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import burst.core.model.RequestData;
import burst.modular.system.entity.Account;
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
	@Transactional
	public int add(RequestData requestData) {
		//添加用户想信息
		UserInfo userInfo = requestData.parseObj(UserInfo.class);
		int result = baseMapper.insert(userInfo);
		//如果用户信息添加失败，则返回-1
		if(result<=0) {
			return -1;
		}
		//为新增加的用户添加系统账号
		String accountName = userInfo.getUserCode();
		String password="111";
		String userInfoId = userInfo.getId();
		Account account = new Account();
		account.setAccountName(accountName);
		account.setPasswd(password);
		account.setUserInfoId(userInfoId);
		int accountResult = accountMapper.insert(account);
		//如果账号添加失败，则返回-1
		if(accountResult<=0) {
			return -1;
		}
		
		return 1;
		
		
	};
	//删除
	public int delete(RequestData requestData) {
		return 1;
	};
	//更新
	public void update(RequestData requestData) {};
	//查询
	public List<UserInfo> list(RequestData requestData) {
		return null;
	};
}
