package com.bunfly.electric.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.bunfly.electric.pojo.MonthOfPscVqr;

@Repository
public interface MonthOfPscVqrMapper {
    int insert(MonthOfPscVqr record);

    int insertSelective(MonthOfPscVqr record);
    
    List<MonthOfPscVqr> getLastyearVQR();
    
    MonthOfPscVqr getCurrentMonthPscScore();
    
    MonthOfPscVqr getMonthVQR(@Param("monthk")String month);
    
    String getNum(String month);
    
    String getDays(String month);
    
    
}