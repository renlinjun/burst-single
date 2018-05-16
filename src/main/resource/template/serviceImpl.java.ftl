package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import burst.core.model.RequestData;
import java.util.List;

/**
 * <p>
 * ${table.comment} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {
	
	@Autowired
	private ${table.mapperName} ${table.mapperName?uncap_first}; 
	
	//添加${entity}
	public void add(RequestData data) {};
	//删除
	public void delete(RequestData data) {};
	//更新
	public void update(RequestData data) {};
	//查询
	public List<${entity}> list(RequestData data) {
		return null;
	};
}
</#if>
