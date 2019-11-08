package com.bunfly.electric.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bunfly.electric.pojo.MonthOfAsai;

@Repository
public interface MonthOfAsaiMapper {
    int insert(MonthOfAsai record);

    int insertSelective(MonthOfAsai record);
    
    List<MonthOfAsai> getLastYearAsaiInfo();
    
    MonthOfAsai getCurrentMonthScore();
    
    MonthOfAsai getMonthASAIByMonth(@Param("month")String month);
}