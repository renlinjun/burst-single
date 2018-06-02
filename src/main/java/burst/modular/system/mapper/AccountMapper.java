package burst.modular.system.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import burst.modular.system.entity.Account;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-16
 */
public interface AccountMapper extends BaseMapper<Account> {
	
	public List<Map<String,Object>> selectAccount(Map<String,Object> map);


	/**
	 * description:通过字段逻辑删除账户
	 * @param Id
	 * @return
	 */
	public int delByColId(String Id);
	
	/**
	 * 更新账户
	 * @param account
	 * @return
	 */
	public int updatePassword(Account account);
	
	/**
	 * 根据账户名查询账户
	 * @param account
	 * @return
	 */
	public Account queryByAccountName(String accountName);

}
