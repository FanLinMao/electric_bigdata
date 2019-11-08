package com.bunfly.electric.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bunfly.electric.pojo.StationPowerCut;
@Repository
public interface StationPowerCutMapper {
    int insert(StationPowerCut record);

    int insertSelective(StationPowerCut record);
    
    List<StationPowerCut> getStationPowerCut(@Param("month")String month);
    
    List<StationPowerCut> getCurrentMonthPC();
}