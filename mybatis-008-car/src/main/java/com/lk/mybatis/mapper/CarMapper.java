package com.lk.mybatis.mapper;

import com.lk.mybatis.pojo.Car;

import java.util.List;

public interface CarMapper {
    List<Car> selectByID(Long id);
}
