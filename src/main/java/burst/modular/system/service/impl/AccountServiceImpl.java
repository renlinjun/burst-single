package burst.modular.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import burst.core.config.ResultConstants;
import burst.core.model.RequestData;
import burst.core.model.ResponseData;
import burst.core.util.EncryptUtil;
import burst.modular.system.entity.Account;
import burst.modular.system.entity.DTO.AccountDTO;
import burst.modular.system.mapper.AccountMapper;
import burst.modular.system.service.IAccountService;
import cn.hutool.core.util.StrUtil;

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
	@Override
	public ResponseData update(RequestData requestData) {
		AccountDTO accountDto = requestData.parseObj(AccountDTO.class);
		String oldPassword = accountDto.getOldPassword();
		
		oldPassword = EncryptUtil.encryptStr(oldPassword);
		
		String newPassword = accountDto.getNewPassword();
		String reNewPassword = accountDto.getReNewPassword();
		if(StrUtil.isEmpty(newPassword)) {
			return new ResponseData(ResultConstants.PASSWORD_ERROR, "请输入有效的新密码"); 
		}
		//验证第二次确认密码是否正确
		if(!newPassword.equals(reNewPassword)) {
			return new ResponseData(ResultConstants.PASSWORD_ERROR, "两次密码不一致");
		}
		
		Account account = baseMapper.queryByAccountName(accountDto.getAccountName());
		//验证旧密码是否正确
		if(!account.getPassword().equals(oldPassword)) {
			return new ResponseData(ResultConstants.PASSWORD_ERROR, "旧密码错误");
		}
		
		//更新密码
		account.setPassword(EncryptUtil.encryptStr(newPassword));
		baseMapper.updatePassword(account);
		
		return new ResponseData(ResultConstants.SUCCESS_RESPONSE);
	}
	//查询
	public List<Account> list(RequestData requestData) {
		return null;
	}
	
	@Override
	public Account checkAccount(String accountName,String password) {
		//将密码进行加密
		password = EncryptUtil.encryptStr(password);
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
