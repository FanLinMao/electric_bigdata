package com.bunfly.electric.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bunfly.electric.pojo.MonthOfStationVqr;

@Repository
public interface MonthOfStationVqrMapper {
    int insert(MonthOfStationVqr record);

    int insertSelective(MonthOfStationVqr record);
    
    
}