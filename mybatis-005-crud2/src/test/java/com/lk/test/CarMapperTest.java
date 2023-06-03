package com.lk.test;

import com.lk.mybatis.mapper.CarMapper;
import com.lk.mybatis.pojo.Car;
import com.lk.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarMapperTest {
    @Test
    public void testInsert() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(null, "8888", "本田", 30.0, "2001-10-11", "油车");
        int count = mapper.insert(car);
        System.out.println(count);
        sqlSession.commit();
    }

    @Test
    public void testDeleteByID() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count = mapper.deleteByID(2L);
        System.out.println(count);
        sqlSession.commit();
    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(5L,"222","宝马",55.5,"2102-11-22","新能源");
        int update = mapper.update(car);
        System.out.println(update);
        sqlSession.commit();
    }

    @Test
    public void testSelectByID(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectByID(5L);
        System.out.println(car);
    }
    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAll();
        for (Car car : cars) {
            System.out.println(car);
        }
    }
    @Test
    public void testCheckCar(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.checkCar(5L,"宝马");
        System.out.println(car);
    }

    @Test
    public void testCheckCarByMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Map<String,String> map=new HashMap<>();
        map.put("brand","宝马");
        map.put("carType","新能源");
        Car car = mapper.checkCarByMap(map);
        System.out.println(car);
    }
}
