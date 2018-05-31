package burst.modular.system.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

import burst.core.model.RequestData;
import burst.modular.system.entity.Account;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-16
 */
public interface IAccountService extends IService<Account> {

	

	//添加Account
	public void add(RequestData requestData);
	//删除
	public void delete(RequestData requestData);
	//更新
	public void update(RequestData requestData);
	//查询
	public List<Account> list(RequestData requestData);
	
	/**
	 * 检查用户名密码是否合法
	 * 如果用户名密码合法则返回账户信息
	 * 否则返回null
	 */
	public Account checkAccount(String accountName,String password);
}
