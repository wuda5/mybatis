package com.demo.mybatis;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 运行此方法生成mybatis代码
 * 生成代码自动放入对应目录
 * 配置文件targetProject应从项目名称开始到要生成到的classpath
 * Created by huhaichao on 2017/5/15.
 */
public class MyBatisGeneratorRun {

    public static void main(String[] args) throws Exception{
        MyBatisGeneratorRun app = new MyBatisGeneratorRun();

        System.out.println(" xx:开始前 ："+ app.getClass().getResource("/").getPath());
        app.generator();
        System.out.println(" xx:开始后 ："+ System.getProperty("user.dir"));
    }

    public void generator() throws Exception{

        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        //加载 mybatisgenerator配置插件
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("generatorConfig.xml");

        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(resourceAsStream);//传入配置解析器

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);

        for(String warning:warnings){
            System.out.println("打印warning:"+warning);
        }
    }
}
