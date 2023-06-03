package com.lk.mybatis.mapper;

import com.lk.mybatis.pojo.Log;

import java.util.List;

public interface LogMapper {

    List<Log> selectAllByTable(String date);
}
