package burst.modular.system.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import burst.modular.system.entity.UserInfo;
import org.apache.catalina.User;

/**
 * <p>
 * 人员信息表 Mapper 接口
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {
	
	public void addUser(UserInfo userInfo);

	/**
	 * description:逻辑删除 用户
	 * @param userId
	 * @return
	 */
	public int delByuserId(String userId);

	/**
	 *
	 * @param userInfo
	 * @return
	 */
	public int updateByuserId(UserInfo userInfo);


	/**
	 *
	 * @param id
	 * @return
	 */
	public UserInfo get (String id);


	/**
	 *description:关系表查询
	 * @param id
	 * @return
	 */
	public List<UserInfo> findUserMemberShip (String id);
}
