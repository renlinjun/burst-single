package burst.modular.system.service.impl;

import burst.modular.system.entity.Account;
import burst.modular.system.mapper.AccountMapper;
import burst.modular.system.service.IAccountService;
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
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {
	
	@Autowired
	private AccountMapper accountMapper; 
	
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
	public boolean isLegal(RequestData requestData) {
		
		
		
		return false;
	};
}
