package burst.modular.system.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import burst.core.model.RequestData;
import burst.modular.system.entity.OptResource;
import burst.modular.system.mapper.OptResourceMapper;
import burst.modular.system.service.IOptResourceService;

/**
 * <p>
 * 功能操作资源表 服务实现类
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
@Service
public class OptResourceServiceImpl extends ServiceImpl<OptResourceMapper, OptResource> implements IOptResourceService {
	
	
	//添加OptResource
	public void add(RequestData requestData) {};
	//删除
	public void delete(RequestData requestData) {};
	//更新
	public void update(RequestData requestData) {};
	//查询
	public List<OptResource> list(RequestData requestData) {
		return null;
	};
}
