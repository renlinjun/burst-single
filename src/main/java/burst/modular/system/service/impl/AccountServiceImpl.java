package burst.modular.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import burst.core.model.RequestData;
import burst.modular.system.entity.Account;
import burst.modular.system.mapper.AccountMapper;
import burst.modular.system.service.IAccountService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-16
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {
	
	
	//添加Account
	public void add(RequestData requestData) {};
	//删除
	public void delete(RequestData requestData) {};
	//更新
	public void update(RequestData requestData) {};
	//查询
	public List<Account> list(RequestData requestData) {
		return null;
	}
	
	@Override
	public Account checkAccount(String accountName,String password) {
		JSONObject data = new JSONObject();
		data.put("accountName", accountName);
		data.put("password", password);
		/** 查询用户名密码 */
		List<Map<String,Object>> accounts = baseMapper.selectAccount(data);
		
		if(accounts.size()<=0 || accounts.size()>1) {
			return null;
		}
		//组合account信息
		Map<String,Object> accountMap = accounts.get(0);
		Account account = new Account();
		account.setAccountName(accountMap.get("accountName").toString());
		account.setUserInfoId(accountMap.get("userInfoId").toString());
		
		return account;
	};
}
