package com.bunfly.electric.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bunfly.electric.dao.DayOfAsaiMapper;
import com.bunfly.electric.dao.DayOfPscVqrMapper;
import com.bunfly.electric.dao.MonthOfAsaiMapper;
import com.bunfly.electric.dao.MonthOfPscVqrMapper;
import com.bunfly.electric.dao.MonthOfStationVqrMapper;
import com.bunfly.electric.dao.StationPowerCutMapper;
import com.bunfly.electric.dto.ResponseStatus;
import com.bunfly.electric.pojo.ASAI;
import com.bunfly.electric.pojo.DayOfAsai;
import com.bunfly.electric.pojo.DayOfPscVqr;
import com.bunfly.electric.pojo.MonthOfAsai;
import com.bunfly.electric.pojo.MonthOfPscVqr;
import com.bunfly.electric.pojo.MonthOfStationVqr;
import com.bunfly.electric.pojo.StationPowerCut;
import com.bunfly.electric.pojo.VQR;

/**
 * @date: 2019/07/16
 * @author: 范林茂
 */
@Controller
public class IndexController {
	
	@Autowired
	private MonthOfAsaiMapper asaiOfmonth;
	@Autowired
	private MonthOfPscVqrMapper pscvqrOfmonth;
	@Autowired
	private DayOfAsaiMapper dayOfasai;
	@Autowired
	private DayOfPscVqrMapper dayOfVqr;
	@Autowired
	private StationPowerCutMapper stationpc;
	
	/**
	 * 首页 最近一年供电单位每月供电可靠率信息
	 * @return
	 */
	@PostMapping("/LastyearASAI")
	@ResponseBody
	public List<MonthOfAsai> getLastyearASAI() {
		return asaiOfmonth.getLastYearAsaiInfo();
	}
	
	/**
	 * 首页 最近一年供电单位每月供电质量信息
	 * @return
	 */
	@PostMapping("/LastyearVQR")
	@ResponseBody
	public List<MonthOfPscVqr> getLastyearVQR() {
		return pscvqrOfmonth.getLastyearVQR();
	}
	
	/**
	 * 首页 根据选择时间查询某段时间内供电单位每月的供电可靠率
	 * 选择时间为选择时间所在月
	 * @param startMonth 数据格式:2018/1/1
	 * @param endMonth 数据格式:2018/1/1
	 * @return
	 */
	@PostMapping("/LotofmonthASAI")
	@ResponseBody
	public List<DayOfAsai> getLotofmonthASAI(String startMonth, String endMonth) {
		return dayOfasai.getDayOfAsaiBySearch(startMonth, endMonth);
	}
	
	/**
	 * 首页 根据选择时间查询某段时间内供电单位每月的供电质量（电压合格率）
	 * 选择时间为选择时间所在月
	 * @param startMonth 数据格式:2018/1/1
	 * @param endMonth 数据格式:2018/1/1
	 * @return
	 */
	@PostMapping("/LotofmonthVQR")
	@ResponseBody
	public List<DayOfPscVqr> getLotofmonthVQR(String startMonth, String endMonth) {
		return dayOfVqr.getDayOfPscVqrBySearch(startMonth, endMonth);
	}
	
	/**
	 * 首页 供电单位本月月供电可靠率评分
	 * @return
	 */
	@PostMapping("/CurrentmonthASAIScore")
	@ResponseBody
	public MonthOfAsai getCurrentmonthASAIScore() {
		return asaiOfmonth.getCurrentMonthScore();
	}
	
	/**
	 * 首页 供电单位本月月电压合格率评分
	 * @return
	 */
	@PostMapping("/CurrentmonthVQRScore")
	@ResponseBody
	public MonthOfPscVqr getCurrentmonthVQRScore() {
		return pscvqrOfmonth.getCurrentMonthPscScore();
	}
	
	/**
	 * 首页 供电单位本月每天电压合格率
	 * @return    CurrentmonthVQR
	 */
	@PostMapping("/CurrentmonthVQR")
	@ResponseBody
	public List<DayOfPscVqr> getCurrentmonthVQR() {
		return dayOfVqr.getCurrentmonthVQR();
	}
	
	/**
	 * 首页 供电单位本月全部台区停电信息
	 * @return
	 */
	@PostMapping("/CurrentmonthPC")
	@ResponseBody
	public List<StationPowerCut> getCurrentMonthPC() {
		return stationpc.getCurrentMonthPC();
	}
	
	/**
	 * 根据点击曲线的跳转至供电单位某月供电质量详细信息
	 * headcount(供电单位用户数)
	 * daycount（选择月份监测总时间 单位：天）
	 * @param month   month格式：2018/1
	 * @return
	 */
	@GetMapping("/MonthVQR")
	public ModelAndView getMonthVQR(String month) {
		ModelAndView modelAndView = new ModelAndView("pscVQR");
		MonthOfPscVqr pscvqr = pscvqrOfmonth.getMonthVQR(month);
		//用户数
		String num = pscvqrOfmonth.getNum(month);
		String days = pscvqrOfmonth.getDays(month);
		modelAndView.addObject("pscVQR", pscvqr);
		modelAndView.addObject("headcount", num);
		modelAndView.addObject("daycount", days);
		//跳转页面
		return modelAndView;
	}
	
	/**
	 * 根据点击曲线的跳转至供电单位某月供电可靠率详细信息
	 * headcount(供电单位用户数)
	 * daycount（选择月份监测总时间 单位：天）
	 * @param month  month格式：2018/1
	 * @return
	 */
	@GetMapping("/MonthASAI")
	public ModelAndView getMonthASAI(String month) {
		ModelAndView modelAndView = new ModelAndView("pscASAI");
		MonthOfAsai asai = asaiOfmonth.getMonthASAIByMonth(month);
		modelAndView.addObject("asai", asai);
		modelAndView.addObject("headcount", asai.getTotalDay());
		modelAndView.addObject("daycount", asai.getTotalDay());
		//跳转页面
		return modelAndView;
	}
	

}
