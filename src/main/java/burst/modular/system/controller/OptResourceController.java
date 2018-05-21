package burst.modular.system.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import burst.modular.system.service.IOptResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import burst.core.model.RequestData;
import java.util.List;
import burst.modular.system.entity.OptResource;


/**
 * <p>
 * 功能操作资源表 前端控制层
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
@RestController
@RequestMapping("/system/optResource")
public class OptResourceController {
	
	@Autowired
	private IOptResourceService optResourceService;

	//添加OptResource
	@RequestMapping(value="/add")
	public void add(RequestData requestData) {};
	//删除
	@RequestMapping(value="/delete")
	public void delete(RequestData requestData) {};
	//更新
	@RequestMapping(value="/update")
	public void update(RequestData requestData) {};
	//查询
	@RequestMapping(value="/list")
	public List<OptResource> list(RequestData requestData) {
		return null;
	};
}
