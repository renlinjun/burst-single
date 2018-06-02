package burst.modular.system.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

import burst.core.model.RequestData;
import burst.modular.system.entity.Role;
import burst.modular.system.entity.UserRole;

/**
 * <p>
 * 人员角色关联表 服务类
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
public interface IUserRoleService extends IService<UserRole> {

	

	//添加UserRole
	public int add(RequestData requestData);
	//批量添加
	public int addBatch(RequestData requestData);
	//删除
	public void delete(RequestData requestData);
	//更新
	public void update(RequestData requestData);
	//查询
	public List<UserRole> list(RequestData requestData);
	
	/**
	 * 根据人员ID查询角色列表
	 * @param userId
	 * @return
	 */
	public List<Role> queryRoleByUserId(String userId);
}
