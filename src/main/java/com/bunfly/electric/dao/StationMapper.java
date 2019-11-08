package com.bunfly.electric.dao;

import com.bunfly.electric.pojo.Station;

public interface StationMapper {
    int deleteByPrimaryKey(String stationNo);

    int insert(Station record);

    int insertSelective(Station record);

    Station selectByPrimaryKey(String stationNo);

    int updateByPrimaryKeySelective(Station record);

    int updateByPrimaryKey(Station record);
}