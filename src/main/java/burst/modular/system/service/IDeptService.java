package burst.modular.system.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

import burst.core.model.RequestData;
import burst.modular.system.entity.Dept;

/**
 * @author yf.wang
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/5/3015:35
 */
public interface IDeptService extends IService<Dept> {


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
	public void update(RequestData requestData);


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

