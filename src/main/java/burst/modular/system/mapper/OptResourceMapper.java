package burst.modular.system.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import burst.modular.system.entity.OptResource;

/**
 * <p>
 * 功能操作资源表 Mapper 接口
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
public interface OptResourceMapper extends BaseMapper<OptResource> {
	
	/**
	 * 查询操作资源
	 * @param map
	 * 		条件
	 * @return 
	 * 		操作资源列表
	 */
	public List<OptResource> queryResource(Map<String,Object> map);

}
