package com.itheima.test;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {
    @Test
    public void testSelectAll() throws IOException {
        // 获取sqlsession工厂
        // 1.加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException {
        // 获取sqlsession工厂
        // 1.加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brands = brandMapper.selectById(2);
        System.out.println(brands);
        sqlSession.close();
    }

    @Test
    public void testSelectByCondition() throws IOException {
        //接收参数

        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        // 处理接收参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        // 封装对象
//        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
        Map map = new HashMap();
        map.put("status", status);
        map.put("companyName", companyName);
//        map.put("brandName", brandName);
        // 获取sqlsession工厂
        // 1.加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        List<Brand> brands = brandMapper.selectByCondition(status,companyName,brandName);
        List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);
        sqlSession.close();
    }

    @Test
    public void testSelectByConditionString() throws IOException {
        //接收参数

        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        // 处理接收参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        // 封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);

        // 获取sqlsession工厂
        // 1.加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        List<Brand> brands = brandMapper.selectByCondition(status,companyName,brandName);
        List<Brand> brands = brandMapper.selectByConditionSingle(brand);
        System.out.println(brands);
        sqlSession.close();
    }


    @Test
    public void testAdd() throws IOException {
        //接收参数

        int status = 1;
        String companyName = "波导";
        String brandName = "波导手机";
        String description = "波导手机，手机中的战斗机";
        int orderby = 100;

        // 封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrderby(orderby);

        // 获取sqlsession工厂
        // 1.加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // false 手动提交事务 true 自动提交事务
        // openSession() 是默认开启事务的需要 commit提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.add(brand);
        // 提交事务
        sqlSession.commit();
        // 释放连接
        sqlSession.close();
    }

    @Test
    public void testAdd2() throws IOException {
        //接收参数

        int status = 1;
        String companyName = "波导";
        String brandName = "波导手机";
        String description = "波导手机，手机中的战斗机";
        int orderby = 100;

        // 封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrderby(orderby);

        // 获取sqlsession工厂
        // 1.加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // false 手动提交事务 true 自动提交事务
        // openSession() 是默认开启事务的需要 commit提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.add(brand);
        //获取主键
        Integer id = brand.getId();
        System.out.println(id);
        // 提交事务
        sqlSession.commit();
        // 释放连接
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        //接收参数

        int status = 0;
//        String companyName = "波导";
//        String brandName = "波导手机";
//        String description = "手机中的战斗机";
//        int orderby = 200;
        int id = 8;

        // 封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
//        brand.setDescription(description);
//        brand.setOrderby(orderby);
        brand.setId(id);

        // 获取sqlsession工厂
        // 1.加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // false 手动提交事务 true 自动提交事务
        // openSession() 是默认开启事务的需要 commit提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        int count = brandMapper.update(brand);
        System.out.println(count);
        sqlSession.commit();
        // 释放连接
        sqlSession.close();
    }


    @Test
    public void testdeleteById() throws IOException {
        int id = 5;
        // 获取sqlsession工厂
        // 1.加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // false 手动提交事务 true 自动提交事务
        // openSession() 是默认开启事务的需要 commit提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.deleteById(id);
        sqlSession.commit();
        // 释放连接
        sqlSession.close();
    }

    @Test
    public void testdeleteByIds() throws IOException {
        int[] ids = {1,2,3};
        // 获取sqlsession工厂
        // 1.加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // false 手动提交事务 true 自动提交事务
        // openSession() 是默认开启事务的需要 commit提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.deleteByIds(ids);
        sqlSession.commit();
        // 释放连接
        sqlSession.close();
    }
}
