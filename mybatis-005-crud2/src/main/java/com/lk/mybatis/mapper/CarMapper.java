package com.lk.mybatis.mapper;

import com.lk.mybatis.pojo.Car;

import java.util.List;
import java.util.Map;

public interface CarMapper {

    int insert(Car car);

    int deleteByID(Long id);

    int update(Car car);

    Car selectByID(Long id);

    List<Car> selectAll();

    Car checkCar(Long id,String brand);

    Car checkCarByMap(Map<String,String> map);
}
