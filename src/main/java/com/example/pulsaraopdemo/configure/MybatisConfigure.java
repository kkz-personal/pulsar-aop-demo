package com.example.pulsaraopdemo.configure;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kmz 
 */
public class MybatisConfigure {
    public void  generator() throws Exception{
        boolean overwrite = true;

        //指定逆向工程配置文件
        File configFile = new File("src/main/resources/generatorConfig.xml");
        System.out.println(configFile.getAbsolutePath());

        List<String> warnings = new ArrayList<>();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration configuration = cp.parseConfiguration(configFile);

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);

        MyBatisGenerator mybatisGenerator = new MyBatisGenerator(configuration,callback,warnings);
        mybatisGenerator.generate(null);

    }

    public static void  main(String [] args){
        MybatisConfigure mybatisConfigure = new MybatisConfigure();
        try {
            mybatisConfigure.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
