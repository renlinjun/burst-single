package burst.modular.system.service.impl;

import java.util.List;
import java.util.Map;

import burst.core.util.PageUtils;
import burst.core.util.Query;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import burst.core.model.RequestData;
import burst.core.util.EncryptUtil;
import burst.modular.system.entity.Account;
import burst.modular.system.entity.UserInfo;
import burst.modular.system.mapper.AccountMapper;
import burst.modular.system.mapper.UserInfoMapper;
import burst.modular.system.service.IUserInfoService;
import io.netty.util.internal.StringUtil;

/**
 * <p>
 * 人员信息表 服务实现类
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {
	
	@Autowired
	private AccountMapper accountMapper;

	@Autowired
	private UserInfoMapper userInfoMapper;


	//添加UserInfo
	@Override
	@Transactional
	public int add(RequestData requestData) {
		//添加用户信息
		UserInfo userInfo = requestData.parseObj(UserInfo.class);
		int result = baseMapper.insert(userInfo);
		//如果用户信息添加失败，则返回-1
		if(result<=0) {
			return -1;
		}
		//为新增加的用户添加系统账号
		String accountName = userInfo.getUserCode();
		//初始密码111
		String password=EncryptUtil.encryptStr("111");
		String userInfoId = userInfo.getId();
		Account account = new Account();
		
		account.setAccountName(accountName);
		account.setPassword(password);
		account.setUserInfoId(userInfoId);
		int accountResult = accountMapper.insert(account);
		//如果账号添加失败，则返回-1
		if(accountResult<=0) {
			return -1;
		}
		//给用户添加所属部门

		return 1;
		
		
	};

	/**
	 *
	 * @param requestData
	 * @return
	 */
	@Override
	public int delete(RequestData requestData) {
		//删除信息
		Integer result=0;
		return result;
	};


	/**
	 * description：单条更新
	 * @param requestData
	 */
	@Override
	public int update(RequestData requestData) {

		Integer resultUser = 0;
		UserInfo userInfo = requestData.parseObj(UserInfo.class);
		String userInfoId = userInfo.getId();
		if(!StringUtil.isNullOrEmpty(userInfoId)){
			resultUser = userInfoMapper.updateByuserId(userInfo);
			if(!StringUtil.isNullOrEmpty(resultUser.toString())){
				return resultUser;
			}

		}
		return resultUser;
	};




	/**
	 *
	 * @param requestData
	 * @return
	 */
	@Override
	public List<UserInfo> list(RequestData requestData) {
//		Page
//		baseMapper.selectList()

		return null;
	}


	/**
	 * 通过id单条删除
	 * @param requestData
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public String delByuserId(RequestData requestData) {
		//删除信息
		Integer resultUser = 0;
		Integer resultAccout = 0;
		String userInfoId = requestData.parseObj(UserInfo.class).getId();
		if(!StringUtil.isNullOrEmpty(userInfoId)){
			try {
				resultUser = userInfoMapper.delByuserId(userInfoId);
				if(!StringUtil.isNullOrEmpty(resultUser.toString())){
                    resultAccout = accountMapper.delByColId(userInfoId);

                }
			} catch (Exception e) {
				throw new RuntimeException("插入数据库发生异常！");
			}
		}
		return resultUser+","+resultAccout;

	}

	/**
	 * description：分页查找数据
	 * @param requestData
	 * @return
	 */
	@Override
	public PageUtils findUserQueryPage(RequestData requestData) {
		Map<String,Object> map = requestData.getData();
		Query query = new Query(map);
		String userName= (String )query.get("userName");
		Page<UserInfo> page = this.selectPage(
			new Query<UserInfo>(map).getPage(),new EntityWrapper<UserInfo>()
						.like(StringUtils.isNotBlank(userName),"USER_NAME", userName));

		return new PageUtils(page);
	}


    /**
     *
     * @param requestData
     * @return
     */
	@Override
    public UserInfo get(RequestData requestData ){
		UserInfo userInfoParm = requestData.parseObj(UserInfo.class);
		if (StringUtil.isNullOrEmpty(userInfoParm.getId())){
		UserInfo userInfo = userInfoMapper.get(userInfoParm.getId());
			return userInfo;
		}else{
			return new UserInfo();
		}
    }


    /**
     *
     * @param id
     * @return
     */
    @Override
    public List<UserInfo> findUserMemberShip(String id) {
        List<UserInfo> userInfos = userInfoMapper.findUserMemberShip(id);
        return null;
    }
}
