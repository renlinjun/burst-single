package burst.modular.system.mapper;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import burst.modular.system.entity.UserInfo;

/**
 * <p>
 * 人员信息表 Mapper 接口
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {
	
	public void addUser(Map<String,Object> map);

}
