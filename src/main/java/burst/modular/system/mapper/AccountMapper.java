package burst.modular.system.mapper;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
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
	
	public List<Account> selectAccount(JSONObject data);

}
