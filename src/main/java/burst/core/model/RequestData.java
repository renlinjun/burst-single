package burst.core.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;

/**
 * 客户端请求数据的封装
 * @author RLJ
 *
 */
public class RequestData {
	//客户端请求的数据
	private  JSONObject data;

	public JSONObject getData() {
		return data;
	}

	public void setData(JSONObject data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return data.toJSONString();
	}
	
	/**
	 * 将请求中的数据转换为相应的实体对象
	 * @return
	 */
	public <T> T parseObj(Class<T> clazz) {
		JSONObject json = this.getData();
		Set<String> keys = json.keySet();
		Map<String,Object> beanMap = new HashMap<String,Object>();
		Iterator<String> it = keys.iterator();
		//将数据从map中取出转换为bean
		while(it.hasNext()) {
			String key = it.next();
			Object value = json.get(key);
			beanMap.put(StrUtil.toCamelCase(key), value);
		}
		return BeanUtil.mapToBean(beanMap, clazz, false);
		
	}
}
