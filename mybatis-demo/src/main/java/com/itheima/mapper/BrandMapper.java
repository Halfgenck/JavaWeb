package com.itheima.mapper;

import com.itheima.pojo.Brand;
import com.itheima.pojo.User;

import java.util.List;

public interface BrandMapper {
    /**
     * 查询所有的brand
     */
    public List<Brand> selectAll();
    public Brand selectById(int id);

}
