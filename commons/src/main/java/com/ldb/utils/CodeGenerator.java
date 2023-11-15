package com.ldb.utils;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author LiuDongBin
 * @Date 2023/11/07 14:08
 **/
public class CodeGenerator {
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //获取当前路径
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        //设置生成代码位置
        gc.setOutputDir(projectPath + "/commons/src/main/java");
        //设置代码文件头作者
        gc.setAuthor("LiuDongBin");
        //设置是否在资源管理器打开
        gc.setOpen(false);
        //设置生成代码是否覆盖
        gc.setFileOverride(true);
        //设置去除生成代码接口中的I
        gc.setServiceName("%sService");
        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/fmmall?serverTimezone=UTC");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("dobi0108");
        mpg.setDataSource(dsc);
        // 包配置
        PackageConfig pc = new PackageConfig();
        //设置模块名称
        //pc.setModuleName("shopping");
        pc.setParent("com.ldb");
        pc.setEntity("pojo");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        mpg.setPackageInfo(pc);
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
//表名 下划线转驼峰
        strategy.setNaming(NamingStrategy.underline_to_camel);
//字段名 下划线转驼峰
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//实体类是否使用lombok
        strategy.setEntityLombokModel(true);
//Controller是否使用RESTful风格(RestController)
        strategy.setRestControllerStyle(true);
//设置逻辑删除字段(数据库中需要有deleted字段)
//        strategy.setLogicDeleteFieldName("deleted");
//设置乐观锁注解(数据库中需要有version字段)
//        strategy.setVersionFieldName("version");
//设置生成的表名
        strategy.setInclude("product_img","product_comments","product_params","product_sku");
        mpg.setStrategy(strategy);
        mpg.execute();
    }
}
