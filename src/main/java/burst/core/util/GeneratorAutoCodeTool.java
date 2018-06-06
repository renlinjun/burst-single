package burst.core.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * 代码自动生成工具类
 * @author RLJ
 *
 */
public class GeneratorAutoCodeTool {
	
	private String OUT_PUT_DIR = "D://code"; 
	
	static AutoGenerator mpg = new AutoGenerator();
	
	private void execute() {
		globalConfig();
		dataSourceConfig();
		strategyConfig();
		packageConfig();
		customConfig();
		mpg.execute();
	}
	// 全局配置
	private void globalConfig() {
		mpg.setTemplateEngine(new FreemarkerTemplateEngine());
		 
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("D://code");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(true);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
    // .setKotlin(true) 是否生成 kotlin 代码
        gc.setAuthor("renlinjun");
        gc.setIdType(IdType.UUID);
     // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("I%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);
	}
	 // 数据源配置
	private void dataSourceConfig() {
		
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        /*dsc.setTypeConvert(new MySqlTypeConvert(){
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                System.out.println("转换类型：" + fieldType);
        // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
                return super.processTypeConvert(fieldType);
            }
        });*/
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setUrl("jdbc:mysql://localhost:3306/burst?characterEncoding=utf8");
        mpg.setDataSource(dsc);
	}

	
	private void strategyConfig() {
		 // 策略配置
	    StrategyConfig strategy = new StrategyConfig();
	    //设置下划线开关
	    strategy.setDbColumnUnderline(true);
	    strategy.setCapitalMode(true);// 全局大写命名
	    //strategy.setTablePrefix(new String[] { "tlog_", "tsys_" });// 此处可以修改为您的表前缀
	    strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
	    strategy.setRestControllerStyle(true);
	    strategy.setInclude(new String[] { "role_permission" }); // 需要生成的表
	    // strategy.setExclude(new String[]{"test"}); // 排除生成的表
	    // 自定义 mapper 父类
	    strategy.setSuperMapperClass("com.baomidou.mybatisplus.mapper.BaseMapper");
	    // 自定义 service 父类
	    // strategy.setSuperServiceClass("com.baomidou.demo.TestService");
	    // 自定义 service 实现类父类
	    // strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
	    // 自定义 controller 父类
	    // strategy.setSuperControllerClass("com.baomidou.demo.TestController");
	    // 【实体】是否生成字段常量（默认 false）
	    // public static final String ID = "test_id";
	    // strategy.setEntityColumnConstant(true);
	    // 【实体】是否为构建者模型（默认 false）
	    // public User setName(String name) {this.name = name; return this;}
	    // strategy.setEntityBuilderModel(true);
	    mpg.setStrategy(strategy);
	}
	
	private void packageConfig() {
		  
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("burst.modular");
        pc.setModuleName("system");
        pc.setController("controller");
        mpg.setPackageInfo(pc);
	}
	
	private void customConfig() {
		 // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                //map.put("restControllerStyle", true);
                this.setMap(map);
            }
        };
        
        // 自定义 xxList.jsp 生成
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
     // 调整 xml 生成目录
        focList.add(new FileOutConfig("/template/mapper.xml.ftl") {
           @Override
           public String outputFile(TableInfo tableInfo) {
               return "D:\\code\\burst\\modular\\system\\mapper\\xml\\" + tableInfo.getEntityName() + ".xml";
           }
        });
       
       
        focList.add(new FileOutConfig("/template/controller.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return "D:\\code\\burst\\modular\\system\\controller\\" + tableInfo.getEntityName() + "Controller.java";
            }
         });
        
       
       cfg.setFileOutConfigList(focList);
       mpg.setCfg(cfg);
       
       // 关闭默认 xml 生成，调整生成 至 根目录,如果设置了自己的生成目录，则需要关闭默认的生成
       TemplateConfig tc = new TemplateConfig();
       tc.setXml(null);
       
//       
       // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
       // 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
       // TemplateConfig tc = new TemplateConfig();
       tc.setController(null);
       // tc.setEntity("...");
       // tc.setMapper("...");
       // tc.setXml("...");
       tc.setService("/template/service.java");
       tc.setServiceImpl("/template/serviceImpl.java");
   // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
        mpg.setTemplate(tc);
	}
	
	
	public static void main(String[] args) {
      new GeneratorAutoCodeTool().execute();
	}
	
	
}
