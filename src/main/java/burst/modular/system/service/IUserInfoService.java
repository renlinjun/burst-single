package burst.modular.system.service;

import burst.modular.system.entity.UserInfo;
import com.baomidou.mybatisplus.service.IService;
import burst.core.model.RequestData;
import org.apache.catalina.User;

import java.util.List;

/**
 * <p>
 * 人员信息表 服务类
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
public interface IUserInfoService extends IService<UserInfo> {

	

	//添加UserInfo
	public int add(RequestData requestData);



	//删除
	public int delete(RequestData requestData);

	/**
	 * description：修改用户信息
	 * @param requestData
	 */
	public int update(RequestData requestData);




	//查询
	public List<UserInfo> list(RequestData requestData);

	/**
	 * description:逻辑删除用户
	 * @param requestData
	 * @return
	 */
	public String delByuserId(RequestData requestData);


	/**
	 *
	 * @param requestData
	 * @return
	 */
	public List<UserInfo> findUserQueryPage (RequestData requestData);


	/**
	 *
	 * @param userInfoParm
	 * @return
	 */
	public UserInfo get (String userInfoParm);


	/**
	 * description:关系表查询
	 * @param id
	 * @return
	 */
	public List<UserInfo> findUserMemberShip(String id);
}
