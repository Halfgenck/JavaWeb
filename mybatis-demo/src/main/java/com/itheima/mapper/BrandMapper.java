package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    /**
     * 查询所有的brand
     */
    public List<Brand> selectAll();
    public Brand selectById(int id);

    /**
     * 参数设置
     *      1. 散装参数，如果方法中有多个参数 使用@Param("SQL占位符名称")
     *      2. 对象参数
     *          只需保证SQL中的参数名和实体类属性名对应上
     *      3. map集合参数
     *          只需保证SQL中的参数名和map集合的名称对应上
     * @param status
     * @param CompanyName
     * @param brandName
     * @return
     */
//    List<Brand> selectByCondition(@Param("status")int status,@Param("companyName")String CompanyName,@Param("brandName")String brandName);
//    List<Brand> selectByCondition(Brand brand);
    List<Brand> selectByCondition(Map map);

    // 单条件动态查询
    List<Brand> selectByConditionSingle(Brand brand);

}
