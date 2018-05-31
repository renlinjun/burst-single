package burst.modular.system.service;

import burst.core.model.RequestData;
import burst.modular.system.entity.Dept;
import burst.modular.system.entity.Role;
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



	//添加
	public int add(RequestData requestData);
	//删除
	public void delete(RequestData requestData);
	//更新
	public void update(RequestData requestData);
	//查询
	public List<Dept> list(RequestData requestData);


}

