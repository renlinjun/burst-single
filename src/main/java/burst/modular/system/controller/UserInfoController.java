package burst.modular.system.controller;


import java.util.List;

import javax.validation.Valid;

import burst.core.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import burst.core.config.ResultConstants;
import burst.core.model.RequestData;
import burst.core.model.ResponseData;
import burst.modular.system.entity.UserInfo;
import burst.modular.system.service.IUserInfoService;
import io.netty.util.internal.StringUtil;


/**
 * <p>
 * 人员信息表 前端控制层
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
@RestController
@RequestMapping("/system/userInfo")
public class UserInfoController {
	
	@Autowired
	private IUserInfoService userInfoService;


	/*------------------------------------------------------------------------*/

	/**
	 * 添加user
	 * @param requestData
	 * @return
	 */
	@RequestMapping(value="/add")
	public ResponseData add(@RequestBody RequestData requestData) {
		int result = userInfoService.add(requestData);
		if(result>0) {
			return new ResponseData(ResultConstants.SUCCESS_RESPONSE);
		}
		
		return new ResponseData(ResultConstants.OPT_FAIL,"操作失败");
		
	};


	/**
	 * descirption:逻辑删除单条数据
	 * @author yufei.w
	 * @param requestData
	 * @return
	 */
	@RequestMapping(value="/deleteById")
	public ResponseData deleteById(@Valid @RequestBody RequestData requestData, BindingResult errors) {

		if(errors.hasErrors()){
			errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
			return new ResponseData(ResultConstants.OPT_FAIL,"数据库插入失败"+errors.getAllErrors().stream());
		}

		String result = userInfoService.delByuserId(requestData);
		if(!StringUtil.isNullOrEmpty(result)) {
			return new ResponseData(ResultConstants.SUCCESS_RESPONSE,"操作成功用户表条数，账户表数据条数:"+result);
		}

		return new ResponseData(ResultConstants.OPT_FAIL,"数据库插入失败");
	};



	/**
	 *descripton:更新单条数据
	 * @author yufei.w
	 * @param requestData
	 * @return
	 */
	@RequestMapping(value="/updateById")
	public ResponseData update(@RequestBody RequestData requestData) {
		Integer result = userInfoService.update(requestData);
		if(!"0".equals(result)) {
			return new ResponseData(ResultConstants.SUCCESS_RESPONSE,"操作成功用户表，更新用户表数据条数:"+result);
		}

		return new ResponseData(ResultConstants.OPT_FAIL,"数据库更新失败");
	};


	/**
	 * description:
	 * @author yufei.w
	 * @param requestData
	 * @return
	 */
	@RequestMapping(value="/list")
	public List<UserInfo> list(@RequestBody RequestData requestData) {

		List<UserInfo> userInfos = userInfoService.list(requestData);
		return userInfos;
	};


	/**
	 * description：分页查询用户表中所有数据
	 * @author yufei.w
	 * @param requestData
	 * @return
	 */
	public ResponseData findUserInfoList (@RequestBody RequestData requestData){

		PageUtils page =userInfoService.findUserQueryPage(requestData);

		return new ResponseData(ResultConstants.SUCCESS_RESPONSE,page);

	}


    /**
     *descirption：判断关系表中是否重复
     * @param userInfo
     * @param requestData
     * @return
     */
	public ResponseData JudgeTheUserCode(UserInfo userInfo ,RequestData requestData){


	    return null;
    }


	/**
	 * descirption:为人员添加分配角色
	 * @param requestData
	 * @return
	 */
	public ResponseData saveTheRole (@RequestBody RequestData requestData){

		//查询关系表中 是否存在
      /*  if(userInfo!=null){
           List<UserInfo> userInfoList = userInfoService.findUserMemberShip(userInfo.getId());
        }else {
           return new ResponseData(ResultConstants.OPT_FAIL,"参数异常");
        }*/

		//如果不存在 执行插入

		return null;

	}
}
