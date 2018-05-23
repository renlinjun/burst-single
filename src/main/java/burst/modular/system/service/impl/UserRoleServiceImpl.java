package burst.modular.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import burst.core.model.RequestData;
import burst.modular.system.entity.UserRole;
import burst.modular.system.mapper.UserRoleMapper;
import burst.modular.system.service.IUserRoleService;

/**
 * <p>
 * 人员角色关联表 服务实现类
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {
	
	
	
	//添加UserRole
	public int add(RequestData requestData) {
		UserRole userRole = requestData.parseObj(UserRole.class);
		int result = baseMapper.insert(userRole);
		return result;
	};
	
	@Override
	public int addBatch(RequestData requestData) {
		
		JSONObject data = requestData.getData();
		JSONArray jsonArray = data.getJSONArray("dataList");
		
		List<UserRole> userRoles = new ArrayList<UserRole>();
		
		for(int i=0;i<jsonArray.size();i++) {
			JSONObject json = jsonArray.getJSONObject(i);
			UserRole userRole = new UserRole();
			
			String userId = json.getString("user_id");
			String roleId = json.getString("role_id");
			userRole.setRoleId(roleId);
			userRole.setUserId(userId);
			userRoles.add(userRole);
		}
		
		int result = baseMapper.addBatch(userRoles);
		
		return result;
	}
	
	//删除
	public void delete(RequestData requestData) {};
	//更新
	public void update(RequestData requestData) {};
	//查询
	public List<UserRole> list(RequestData requestData) {
		return null;
	};
}
