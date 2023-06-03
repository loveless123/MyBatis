package com.lk.mybatis.test;

import com.lk.mybatis.pojo.Car;
import com.lk.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarMapperTest {

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Object> cars = sqlSession.selectList("selectAll");
        for (Object car : cars) {
            System.out.println(car);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Object car = sqlSession.selectOne("selectById", 6);
        System.out.println(car);
        sqlSession.close();
    }

    @Test
    public void testUpdateById(){
        Car car = new Car(5L,"3355","本田",20.3,"2000-2-2","燃油车");
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.update("updateById", car);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testDeleteById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.delete("deleteCar", 14);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }




    @Test
    public void carTestInsert(){
        Car car = new Car(null,"3333","比亚迪秦",30.0,"2020-11-11","新能源");
        SqlSession sqlSession = SqlSessionUtil.openSession();
        sqlSession.insert("insertCar",car);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testInsertCar(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Map<String, Object> map = new HashMap<>();
        map.put("carNum","1111");
        map.put("brand","比亚迪汉2");
        map.put("guidePrice",10.0);
        map.put("produceTime","2020-11-11");
        map.put("carType","新能源");

        int count=sqlSession.insert("insertCar",map);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }
}
