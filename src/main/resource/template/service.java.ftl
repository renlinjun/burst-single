package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import burst.core.model.RequestData;
import java.util.List;

/**
 * <p>
 * ${table.comment} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

	

	//添加${entity}
	public void add(RequestData data);
	//删除
	public void delete(RequestData data);
	//更新
	public void update(RequestData data);
	//查询
	public List<${entity}> list(RequestData data);
}
</#if>
