package burst.modular.system.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import burst.modular.system.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;

import burst.core.config.ResultConstants;
import burst.core.model.RequestData;
import burst.core.model.ResponseData;

import java.util.List;
import burst.modular.system.entity.Menu;


/**
 * <p>
 * 菜单表 前端控制层
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
@RestController
@RequestMapping("/system/menu")
public class MenuController {
	
	@Autowired
	private IMenuService menuService;

	//添加Menu
	@RequestMapping(value="/add")
	public ResponseData add(RequestData requestData) {
		int result = menuService.add(requestData);
		//添加失败
		if(result<=1) {
			return new ResponseData(ResultConstants.OPT_FAIL,"操作失败");
		}
		//添加成功
		return new ResponseData(ResultConstants.SUCCESS_RESPONSE);
	};
	//删除
	@RequestMapping(value="/delete")
	public void delete(RequestData requestData) {};
	//更新
	@RequestMapping(value="/update")
	public void update(RequestData requestData) {};
	//查询
	@RequestMapping(value="/list")
	public List<Menu> list(RequestData requestData) {
		return null;
	};
}
