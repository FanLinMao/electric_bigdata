package com.bunfly.electric.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bunfly.electric.dao.DayOfAsaiMapper;
import com.bunfly.electric.dao.DayOfPscVqrMapper;
import com.bunfly.electric.dao.StationPowerCutMapper;
import com.bunfly.electric.dto.ResponseStatus;
import com.bunfly.electric.pojo.DayOfAsai;
import com.bunfly.electric.pojo.DayOfPscVqr;
import com.bunfly.electric.pojo.MonthOfPscVqr;
import com.bunfly.electric.pojo.StationPowerCut;

/**
 * @date: 2019/07/16
 * @author: 范林茂
 */
@RestController
public class PscASAIController {
	
	@Autowired
	private DayOfAsaiMapper dayOfAsai;
	@Autowired
	private StationPowerCutMapper stationPC;
	@Autowired
	private DayOfPscVqrMapper dayOfVQR;
	
	/**
	 * 根据跳转后的月份查询供电单位该月每天详细供电可靠率数据
	 * @param month  month格式：2018/1
	 * @return
	 */
	@PostMapping("/EverydayASAI")
	public List<DayOfAsai> getEverydayPSCASAI(String month) {
		
		List<DayOfAsai> everydayPSCASAI = dayOfAsai.getEverydayPSCASAI(month+"/");
		return everydayPSCASAI;
	}
	
	/**
	 * 根据跳转后的月份查询供电单位该月每天详细台区停电信息
	 * @param month  month格式：2018/1
	 * @return
	 */
	@PostMapping("/EveryPC")
	public List<StationPowerCut> getEveryPC(String month) {
		List<StationPowerCut> stationPowerCut = stationPC.getStationPowerCut(month+"/");
		return stationPowerCut;
	}
	
	/**
	 * 根据跳转后的月份查询供电单位该月每天详细电压质量数据
	 * @param month  格式为2018/1 
	 * @return
	 */
	@PostMapping("/EverydayVQR")
	public List<DayOfPscVqr> getEverydayVQR(String month) {
		List<DayOfPscVqr> everydayVQR = dayOfVQR.getEverydayVQR(month+"/");
		return everydayVQR;
	}
	
}
