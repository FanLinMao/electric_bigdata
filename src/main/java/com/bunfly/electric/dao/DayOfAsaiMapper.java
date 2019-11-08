package com.bunfly.electric.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bunfly.electric.pojo.DayOfAsai;

@Repository
public interface DayOfAsaiMapper {
    int insert(DayOfAsai record);

    int insertSelective(DayOfAsai record);
    
    List<DayOfAsai> getDayOfAsaiBySearch(@Param("startMonth")String startMonth, @Param("endMonth")String endMonth);
    
    List<DayOfAsai> getEverydayPSCASAI(@Param("month")String month);
    
    
}