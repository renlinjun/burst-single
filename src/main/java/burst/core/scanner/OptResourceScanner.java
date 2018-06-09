package burst.core.scanner;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import burst.core.annotation.RestApi;
import burst.core.config.GolbalConstants;
import burst.core.redis.RedisHandler;
import burst.modular.system.entity.OptResource;
/**
 * 资源扫描类
 * 扫描控制层配置的所有Url
 * @author RLJ
 *
 */
@Component
public class OptResourceScanner implements SmartInitializingSingleton {

	private Logger log = LoggerFactory.getLogger(OptResourceScanner.class);
	
	@Autowired
	private RedisHandler redisHandler;
	
	/*
	通过spring容器上下文获取bean定义
	实现资源扫描
	public void afterSingletonsInstantiated() {
		
		Map<String,Object> beans = ContextHolder.getApplicationContext().getBeansWithAnnotation(RestApi.class);
		//存储资源url对应的资源信息的map
		Map<String, OptResource> map = new HashMap<String, OptResource>();
		for(Object obj :beans.values()) {
			Class<?> clazz = obj.getClass();
			RestApi api = (RestApi) clazz.getAnnotation(RestApi.class);
			String[] parentPaths = api.path();
			//只取得类注解上配置的第一个路径
			String parentPath = "";
			if(parentPaths.length>0) {
				parentPath = parentPaths[0];
			}
			//为类上配置的路径添加“/”，防止方法上未添加"/"产生错误
			if(!(parentPath.endsWith("/"))) {
				parentPath = parentPath + "/";
			}
			Method[] methods = clazz.getDeclaredMethods();
			 for (Method method : methods) {
				 if(!method.isAnnotationPresent(RestApi.class)) {
					 continue;
				 }
	            //得到该类下面的RequestMapping注解
	            RestApi restApi = method.getAnnotation(RestApi.class);
	            
	            String[] paths = restApi.path();
            	//根据注解装配optResource类
            	OptResource optResource = new OptResource();
            	optResource.setLogin(restApi.useLogin());
            	optResource.setSign(restApi.isSign());
            	optResource.setResourceCode(restApi.code());
            	optResource.setResourceName(restApi.name());
            	//存入map中
            	for(int i=0;i<paths.length;i++) {
            		String path = paths[i];
            		if(path.startsWith("/")) {
            			path = path.substring(1);
            		}
            		path = parentPath + path;
            		optResource.setResourceUrl(path);
            		log.info("扫描到资源:"+optResource.toString());
            		//System.out.println("扫描到map:"+optResource.toString());
            		map.put(path, optResource);
            	}
			 }
			 //将资源信息缓存到redis中
			 redisHandler.put(GolbalConstants.ALL_OPT_RESOURCE, map);
		}
		
	}*/
	
	/**
	 * 通过反射框架的方式实现资源扫描
	 */
	@Override
	public void afterSingletonsInstantiated() {
		Reflections reflections = new Reflections("burst.modular",new MethodAnnotationsScanner());
		Set<Method> methods = reflections.getMethodsAnnotatedWith(RestApi.class);
        // 存放url和OptResource的对应关系
        Map<String, OptResource> map = new HashMap<String, OptResource>();
        for (Method method : methods) {
        	//获取该方法对应的类
        	String parentPath = "";
        	Class<?> clazz = method.getDeclaringClass();
        	if(clazz.isAnnotationPresent(RestApi.class)) {
        		RestApi api = (RestApi) clazz.getAnnotation(RestApi.class);
        		String[] parentPaths = api.path();
    			//只取得类注解上配置的第一个路径
    			if(parentPaths.length>0) {
    				parentPath = parentPaths[0];
    			}
    			//为类上配置的路径添加“/”，防止方法上未添加"/"产生错误
    			if(!(parentPath.endsWith("/"))) {
    				parentPath = parentPath + "/";
    			}
        	}
        	
            //得到该类下面的RequestMapping注解
            RestApi restApi = method.getAnnotation(RestApi.class);
            if (null != restApi) {
            	String[] paths = restApi.path();
            	//根据注解装配optResource类
            	OptResource optResource = new OptResource();
            	optResource.setLogin(restApi.useLogin());
            	optResource.setSign(restApi.isSign());
            	optResource.setResourceCode(restApi.code());
            	optResource.setResourceName(restApi.name());
            	//存入map中
            	for(int i=0;i<paths.length;i++) {
            		String path = paths[i];
            		if(path.startsWith("/")) {
            			path = path.substring(1);
            		}
            		path = parentPath + path;
            		optResource.setResourceUrl(path); 
            		log.info("扫描到资源:"+optResource.toString());
            		//System.out.println("扫描到map:"+optResource.toString());
            		map.put(path, optResource);
            	}
            }
        }
        //将资源信息缓存到redis中
        redisHandler.put(GolbalConstants.OPT_RESOURCE_CACHE_SUFFIX, map);
	}
}
