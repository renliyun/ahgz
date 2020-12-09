package com.vot.ahgz.genertor;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class Genertor {
    public static void main(String[] args) {

        GlobalConfig config =new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        config.setActiveRecord(true)//是否支持AR模式
                .setAuthor("renlirong")//作者
                .setOutputDir(projectPath +"/src/main/java")//生成路径
                .setFileOverride(true)//文件覆盖
                .setIdType(IdType.AUTO)//设置主键生成策略
                .setServiceImplName("%sService")//设置生成的service接口的首字母是否为I
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                .setSwagger2(true);


        DataSourceConfig dsc =new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setUrl("jdbc:mysql://localhost:3306/vot");
        dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("821827aa");


        String[] tables =new String[8];
        tables[0] ="address_list";
        tables[1] ="borrow_record";
        tables[2]="delivery_record";
        tables[3]="in_record";
        tables[4]="non_conforming";
        tables[5]="out_record";
        tables[6]="storage_table";
        tables[7]="user_table";

        StrategyConfig strategyConfig =new StrategyConfig();  strategyConfig.setCapitalMode(true)//开启大小
                // 写命名
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setNaming(NamingStrategy.underline_to_camel)//数据库表映射到实体的命名策略
                .setInclude(tables);


        PackageConfig pc =new PackageConfig();
        pc.setParent("com.vot.ahgz")
                .setService("service")
                .setController("controller")
                .setEntity("entity")
                .setXml("./mapper")  //不设定会默认分级目录填写
                .setMapper("mapper");

        AutoGenerator ag =new AutoGenerator();
        ag.setGlobalConfig(config);
        ag.setDataSource(dsc)
                .setStrategy(strategyConfig)
                .setPackageInfo(pc); //执行
        ag.execute();}


    }

