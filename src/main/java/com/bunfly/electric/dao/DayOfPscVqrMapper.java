package com.bunfly.electric.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.bunfly.electric.pojo.DayOfPscVqr;
import com.bunfly.electric.pojo.MonthOfPscVqr;

@Repository
public interface DayOfPscVqrMapper {
    int insert(DayOfPscVqr record);

    int insertSelective(DayOfPscVqr record);
    
    List<DayOfPscVqr> getDayOfPscVqrBySearch(@Param("startMonth")String startMonth, @Param("endMonth")String endMonth);
    
    List<DayOfPscVqr> getEverydayVQR(@Param("month")String month);
    
    List<DayOfPscVqr> getCurrentmonthVQR();
}