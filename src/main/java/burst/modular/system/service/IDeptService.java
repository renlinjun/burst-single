package burst.modular.system.service;

import burst.core.model.RequestData;
import burst.modular.system.entity.Dept;
import burst.modular.system.entity.Role;
import burst.modular.system.entity.UserInfo;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * @author yf.wang
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/5/3015:35
 */
public interface IDeptService extends IService<Dept> {



	/**
	 *
	 * @param deptParm
	 * @return
	 */
	public Dept get (String deptParm);


	/**
	 * 添加
	 * @param requestData
	 * @return
	 */
	public int add(RequestData requestData);


	/**
	 * 删除
	 * @param requestData
	 * @return
	 */
	public Integer delete(RequestData requestData);



	/**
	 * 更新
	 * @param requestData
	 * @return
	 */
	public Integer update(RequestData requestData,Dept dept);


	/**
	 * 查询
	 * @param requestData
	 * @return
	 */
	public List<Dept> list(RequestData requestData);

	/**
	 * decription:全查
	 * @param requestData
	 * @return
	 */
	public List<Dept> findAll(RequestData requestData);

}

