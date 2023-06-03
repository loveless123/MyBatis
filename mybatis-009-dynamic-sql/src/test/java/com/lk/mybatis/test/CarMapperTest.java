package com.lk.mybatis.test;

import com.lk.mybatis.mapper.CarMapper;
import com.lk.mybatis.pojo.Car;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CarMapperTest {
    @Test
    public void testInsertByForeach() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car1 = new Car(null, "2001", "兰博基尼", 100.0, "1998-10-11", "燃油车");
        Car car2 = new Car(null, "2001", "兰博基尼", 100.0, "1998-10-11", "燃油车");
        Car car3 = new Car(null, "2001", "兰博基尼", 100.0, "1998-10-11", "燃油车");
        List<Car> cars=new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        int count=mapper.insertByForeach(cars);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testSelectByMultiConditionWithTrim() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars=mapper.selectByMultiConditionWithTrim("宝马",null,"");
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }

    @Test
    public void testSelectByMultiCondition() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = build.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars=mapper.selectByMultiCondition("宝马",55.00,"新能源");
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }
}
